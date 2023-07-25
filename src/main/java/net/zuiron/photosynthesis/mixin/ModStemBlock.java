package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.CropData;
import net.zuiron.photosynthesis.api.Seasons;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

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

    @Unique
    private static final IntProperty GOURDS_SPAWNED = IntProperty.of("gourdsspawned", 0, 4);

    public ModStemBlock(Settings settings, GourdBlock gourdBlock) {
        super(settings);
        this.gourdBlock = gourdBlock;
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(this.getGourdsSpawnedProperty(), 0));
    }

    @Unique
    public IntProperty getGourdsSpawnedProperty() {
        return GOURDS_SPAWNED;
    }

    @Unique
    public int getGourdsSpawned(BlockState state) {
        return state.get(this.getGourdsSpawnedProperty());
    }

    @Unique
    public BlockState withGourdsSpawned(int spawned) {
        return (BlockState)this.getDefaultState().with(this.getGourdsSpawnedProperty(), spawned);
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
        //world.setBlockState(pos, (BlockState)state.cycle(AGE), Block.NOTIFY_LISTENERS);
        if(Seasons.isSeasonsEnabled()) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if(cropData != null) {
                int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                int currentCropAge = state.get(AGE);

                Photosynthesis.LOGGER.info("DEBUG::::: - "+this.getGourdsSpawned(state));

                if(this.getGourdsSpawned(state) >= 4) {
                    //we have spawned 4 gourds, reset crop to age 0.
                    state = (BlockState) state.with(AGE, 0).with(GOURDS_SPAWNED,0);
                    world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
                }

                if(currentCropAge >= 7 && seasonPercentage > 0.7f && this.getGourdsSpawned(state) < 4) {
                    //gourd matures ON crop. / replaces crop.
                    //world.setBlockState(pos, this.gourdBlock.getDefaultState());

                    Direction direction = Direction.Type.HORIZONTAL.random(random);
                    BlockPos blockPos = pos.offset(direction);
                    BlockState blockState = world.getBlockState(blockPos.down());
                    if (world.getBlockState(blockPos).isAir() && (blockState.isOf(Blocks.FARMLAND) || blockState.isIn(BlockTags.DIRT))) {
                        world.setBlockState(blockPos, this.gourdBlock.getDefaultState()); //SPAWN ACTUAL GOURD - melon or pumpkin
                        //world.setBlockState(pos, (BlockState)this.gourdBlock.getAttachedStem().getDefaultState().with(HorizontalFacingBlock.FACING, direction));

                        //this sets crop to age 0 agian, huh.
                        //world.setBlockState(pos, this.withGourdsSpawned(this.getGourdsSpawned(state) + 1), Block.NOTIFY_LISTENERS);
                        state = (BlockState) state.with(GOURDS_SPAWNED, this.getGourdsSpawned(state) + 1);
                        world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);

                        Photosynthesis.LOGGER.info("gourd grows... like magic!");
                    }

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

    @Inject(method = "appendProperties", at = @At("HEAD"), cancellable = true)
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(GOURDS_SPAWNED);
    }
}
