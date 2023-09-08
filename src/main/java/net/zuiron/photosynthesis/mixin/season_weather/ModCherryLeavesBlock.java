package net.zuiron.photosynthesis.mixin.season_weather;

import net.minecraft.block.BlockState;
import net.minecraft.block.CherryLeavesBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.api.Seasons;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CherryLeavesBlock.class)
public abstract class ModCherryLeavesBlock extends LeavesBlock {
    public ModCherryLeavesBlock(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("HEAD"), method = "randomDisplayTick", cancellable = true)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random, CallbackInfo ci) {
        if(Seasons.isSeasonsEnabled()) {
            super.randomDisplayTick(state, world, pos, random);
            boolean doParticleSpawn = true;
            if (random.nextInt(10) != 0) {
                doParticleSpawn = false;
            }
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (CherryLeavesBlock.isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
                doParticleSpawn = false;
            }

            int season = Seasons.getCurrentSeason(world.getTimeOfDay());
            if (season == 1 && doParticleSpawn) {
                ParticleUtil.spawnParticle(world, pos, random, ParticleTypes.CHERRY_LEAVES);
            }
            ci.cancel();
        }
    }
}
