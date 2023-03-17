package net.zuiron.photosynthesis.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.CropData;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.config.ModConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(CropBlock.class)
public abstract class ModCropBlock {
    @Shadow public abstract int getMaxAge();

    @Shadow protected abstract int getAge(BlockState state);

    @Shadow public abstract BlockState withAge(int age);

    //@Inject(method = "randomTick", at = @At("HEAD"))
    @Inject(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/CropBlock;withAge(I)Lnet/minecraft/block/BlockState;", ordinal = 0), cancellable = true)
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {

        if(Seasons.isSeasonsEnabled()) {
            //Photosynthesis.LOGGER.info("apply growth?: " + state.getBlock().getTranslationKey());
            /*int spring_maxAge = 4;
            int spring_minAge = 1;

            int summer_maxAge = 7;
            int summer_minAge = 4;

            int autumn_maxAge = 1;
            int autumn_minAge = 0;

            int winter_maxAge = 1;
            int winter_minAge = 1;*/

            //WHEAT - plant in autumn, harvestable in summer.
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if(cropData != null) {
                int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                int currentCropAge = this.getAge(state);
                if(currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > 0.5f) { //0.5f = 50% "halfway thru season"
                    Photosynthesis.LOGGER.info("Crop: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NewCropAge: "+(this.getAge(state) + 1)+", %:"+seasonPercentage);
                    world.setBlockState(pos, this.withAge(this.getAge(state) + 1), 2);
                } else {
                    Photosynthesis.LOGGER.info("Crop: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NO GROW"+", %:"+seasonPercentage);
                }
                ci.cancel(); //cancel, do not run vanilla code.
                //Note we only cancel IF we found seasons data for the crop. otherwise vanilla code runs.
            }

            /*if (Objects.equals(state.getBlock().getTranslationKey(), "block.minecraft.wheat")) {
                Photosynthesis.LOGGER.info("Wheat tried to grow. Season: "+Seasons.getCurrentSeason(world.getTimeOfDay()));
            }*/
            //world.setBlockState(pos, this.withAge(this.getAge(state) + 1), 2); //works - converted - applies growth
        }
        //world.setBlockState(pos, this.withAge(i + 1), 2); //Original MC Code
    }

    /*@Inject(method = "randomTick", at = @At("HEAD"))
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        Photosynthesis.LOGGER.info("test");
    }*/
}
