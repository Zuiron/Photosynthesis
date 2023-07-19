package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.*;
import net.minecraft.block.sapling.MangroveSaplingGenerator;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.CropData;
import net.zuiron.photosynthesis.api.Seasons;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.block.PropaguleBlock.HANGING;

@Mixin(PropaguleBlock.class)
public abstract class ModPropaguleBlock extends SaplingBlock
        implements Waterloggable {

    @Mutable
    @Final
    @Shadow
    private static final IntProperty AGE = Properties.AGE_4;

    public ModPropaguleBlock(Settings settings) {
        super(new MangroveSaplingGenerator(0.85f), settings);
    }

    @Inject(method = "isFertilizable", at = @At("HEAD"), cancellable = true)
    public void isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient, CallbackInfoReturnable<Boolean> cir) {
        //disable bonemealing on crops we have cropdata for.
        if(Seasons.isSeasonsEnabled()) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if(cropData != null) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
    }

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if(Seasons.isSeasonsEnabled()) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if (cropData != null) {
                int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                int currentCropAge = state.get(AGE);

                if (!state.get(HANGING)) { //if (!PropaguleBlock.isHanging(state)) {
                    if (currentCropAge >= 4) {
                        Photosynthesis.LOGGER.info("Propagule Sapling is mature, attempt generate now!");
                        this.generate(world, pos, state, random);
                    }
                    return;
                }
                if (state.get(AGE) != 4) { //if (!PropaguleBlock.isFullyGrown(state)) {
                    if (currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > 0.5f && world.getLightLevel(pos.up()) >= 9) { //0.5f = 50% "halfway thru season"
                        Photosynthesis.LOGGER.info("Sapling: " + state.getBlock().getTranslationKey() + ", minAge:" + minAge + ", maxAge:" + maxAge + ", CurrentCropAge: " + currentCropAge + ", NewCropAge: " + (currentCropAge + 1) + ", %:" + seasonPercentage);
                        world.setBlockState(pos, (BlockState) state.cycle(AGE), Block.NOTIFY_LISTENERS);
                    } else {
                        Photosynthesis.LOGGER.info("Sapling: " + state.getBlock().getTranslationKey() + ", minAge:" + minAge + ", maxAge:" + maxAge + ", CurrentCropAge: " + currentCropAge + ", NO GROW" + ", %:" + seasonPercentage);
                    }
                }
                ci.cancel(); //do not run vanilla code!
            }
        }
    }


}
