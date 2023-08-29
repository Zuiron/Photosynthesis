package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.AzaleaBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AzaleaBlock.class)
public abstract class ModAzaleaBlock extends PlantBlock
        implements Fertilizable {

    public ModAzaleaBlock(Settings settings) {
        super(settings);
    }

    @Inject(method = "isFertilizable", at = @At("HEAD"), cancellable = true)
    public void isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient, CallbackInfoReturnable<Boolean> cir) {
        //return world.getFluidState(pos.up()).isEmpty();
        cir.setReturnValue(false);
        cir.cancel();
    }

    @Inject(method = "grow", at = @At("HEAD"), cancellable = true)
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state, CallbackInfo ci) {
        ci.cancel();
        //GENERATOR.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
    }
}