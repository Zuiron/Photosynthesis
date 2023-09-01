package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmlandBlock.class)
public abstract class ModFarmlandBlock extends Block {
    @Final
    @Shadow
    public static final IntProperty MOISTURE = Properties.MOISTURE;
    public ModFarmlandBlock(Settings settings) {
        super(settings);
    }

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        int i = state.get(MOISTURE);
        if (MODisWaterNearby(world, pos) || world.hasRain(pos.up())) {
            if (i < 7) {
                world.setBlockState(pos, (BlockState)state.with(MOISTURE, 7), Block.NOTIFY_LISTENERS);
            }
        } else if (i > 0) {
            world.setBlockState(pos, (BlockState)state.with(MOISTURE, i - 1), Block.NOTIFY_LISTENERS);
        } else if (!MODhasCrop(world, pos)) {
            //FarmlandBlock.setToDirt(null, state, world, pos);
        }
        ci.cancel(); //DO NOT RUN VANILLA CODE
    }

    @Unique
    private static boolean MODhasCrop(BlockView world, BlockPos pos) {
        return world.getBlockState(pos.up()).isIn(BlockTags.MAINTAINS_FARMLAND);
    }

    @Unique
    private static boolean MODisWaterNearby(WorldView world, BlockPos pos) {
        for (BlockPos blockPos : BlockPos.iterate(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
            if (!world.getFluidState(blockPos).isIn(FluidTags.WATER)) continue;
            return true;
        }
        return false;
    }
}
