package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
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

@Mixin(SugarCaneBlock.class)
public abstract class ModSugarCaneBlock extends Block {

    @Mutable
    @Final
    @Shadow
    private static final IntProperty AGE = Properties.AGE_15;

    public ModSugarCaneBlock(Settings settings) {
        super(settings);
    }

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if (world.isAir(pos.up())) {
            if (Seasons.isSeasonsEnabled()) {
                CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
                if (cropData != null) {
                    int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                    int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                    float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                    int currentCropAge = state.get(AGE);

                    int i = 1;
                    while (world.getBlockState(pos.down(i)).isOf(this)) {
                        ++i;
                    }
                    if (i < 3) {
                        if (currentCropAge == 7) { //if cane age is 7, grow upwards.
                            world.setBlockState(pos.up(), this.getDefaultState()); //add sugarcane above.
                            world.setBlockState(pos, (BlockState)state.with(AGE, 0), Block.NO_REDRAW); //set this age to 0
                            world.setBlockState(pos.up(), (BlockState)state.with(AGE, minAge), Block.NO_REDRAW); //set above cane age to min-grow age.
                        } else { //if cane age is not 7, add +1 to age.
                            if(currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > 0.5f) { //0.5f = 50% "halfway thru season"
                                //Photosynthesis.LOGGER.info("Crop: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NewCropAge: "+(currentCropAge + 1)+", %:"+seasonPercentage);
                                world.setBlockState(pos, (BlockState)state.with(AGE, currentCropAge + 1), Block.NO_REDRAW);
                            } else {
                                //Photosynthesis.LOGGER.info("Crop: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NO GROW"+", %:"+seasonPercentage);
                            }
                        }
                    }

                    //we have crop data, do not run vanilla code.
                    ci.cancel();
                }
            }
        }
    }
}
