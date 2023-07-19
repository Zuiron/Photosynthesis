package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.CropData;
import net.zuiron.photosynthesis.api.Seasons;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StemBlock.class)
public abstract class ModStemBlock extends PlantBlock
        implements Fertilizable {

    @Mutable
    @Final
    @Shadow private static final IntProperty AGE = Properties.AGE_7;

    @Mutable
    @Final
    @Shadow
    private final GourdBlock gourdBlock;

    public ModStemBlock(Settings settings, GourdBlock gourdBlock) {
        super(settings);
        this.gourdBlock = gourdBlock;
    }

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if(Seasons.isSeasonsEnabled()) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if(cropData != null) {
                int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                int currentCropAge = state.get(AGE);

                if(currentCropAge >= 7 && seasonPercentage > 0.7f) {
                    //gourd matures ON crop. / replaces crop.
                    world.setBlockState(pos, this.gourdBlock.getDefaultState());
                    Photosynthesis.LOGGER.info("gourd grows... like magic!");
                }

                if(currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > 0.5f) { //0.5f = 50% "halfway thru season"
                    Photosynthesis.LOGGER.info("Crop: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NewCropAge: "+(currentCropAge + 1)+", %:"+seasonPercentage);
                    state = (BlockState) state.with(AGE, currentCropAge + 1);
                    world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
                } else {
                    Photosynthesis.LOGGER.info("Crop: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NO GROW"+", %:"+seasonPercentage);
                }

                //we got seasons data, do not run vanilla code.
                ci.cancel();
            }
        }
    }
}
