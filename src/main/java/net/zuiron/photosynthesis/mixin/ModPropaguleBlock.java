package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.*;
import net.minecraft.block.sapling.MangroveSaplingGenerator;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
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
    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    private final int MAX_AGE2 = 7;
    private static final IntProperty AGE2 = IntProperty.of("age2", 0, 7);

    public ModPropaguleBlock(Settings settings) {
        super(new MangroveSaplingGenerator(0.85f), settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(this.getAgeProperty(), 0));
    }

    protected IntProperty getAgeProperty() {
        return AGE2;
    }

    public int getMaxAge() {
        return this.MAX_AGE2;
    }

    public int getAge(BlockState state) {
        return state.get(this.getAgeProperty());
    }

    public BlockState withAge(int age) {
        return (BlockState)this.getDefaultState().with(this.getAgeProperty(), age);
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
                int currentCropAge = this.getAge(state);

                if (!state.get(HANGING)) { //if (!PropaguleBlock.isHanging(state)) {
                    if (currentCropAge >= 4) {
                        Photosynthesis.LOGGER.info("Propagule Sapling is mature, attempt generate now!");
                        this.generate(world, pos, state, random);
                    }
                }
                if (currentCropAge != 4 && !state.get(HANGING)) { //if (!PropaguleBlock.isFullyGrown(state)) {
                    if (currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > 0.5f && world.getLightLevel(pos.up()) >= 9) { //0.5f = 50% "halfway thru season"
                        Photosynthesis.LOGGER.info("Sapling: " + state.getBlock().getTranslationKey() + ", minAge:" + minAge + ", maxAge:" + maxAge + ", CurrentCropAge: " + currentCropAge + ", NewCropAge: " + (currentCropAge + 1) + ", %:" + seasonPercentage);
                        //world.setBlockState(pos, (BlockState) state.cycle(AGE2), Block.NOTIFY_LISTENERS);
                        world.setBlockState(pos, this.withAge(this.getAge(state) + 1), 2);
                    } else {
                        Photosynthesis.LOGGER.info("Sapling: " + state.getBlock().getTranslationKey() + ", minAge:" + minAge + ", maxAge:" + maxAge + ", CurrentCropAge: " + currentCropAge + ", NO GROW" + ", %:" + seasonPercentage);
                    }
                }
                ci.cancel(); //do not run vanilla code!
            }
        }
    }

    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int j;
        int i = this.getAge(state) + this.getGrowthAmount(world);
        if (i > (j = this.getMaxAge())) {
            i = j;
        }
        world.setBlockState(pos, this.withAge(i), Block.NOTIFY_LISTENERS);
    }

    protected int getGrowthAmount(World world) {
        return MathHelper.nextInt(world.random, 1, 1);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.applyGrowth(world, pos, state);
    }

    @Inject(method = "appendProperties", at = @At("HEAD"), cancellable = true)
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        //builder.add(this.AGE, STAGE);
        builder.add(AGE2);
        //ci.cancel();
    }
}
