package net.zuiron.photosynthesis.block.cropblocks;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.CropData;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.item.ModItems;

public class CustomCropBlockWL2Tall extends CropBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    String seed;
    public static final int LOWER_HALF_MAX_AGE = 3;
    public static final int UPPER_HALF_MAX_AGE = 7;
    public CustomCropBlockWL2Tall(Settings settings, String itemname) {
        super(settings);
        seed = itemname;

        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        //builder.add(new Property[]{AGE}).add(new Property[]{WATERLOGGED}).add(HALF);
        builder.add(new Property[]{AGE}).add(new Property[]{Properties.WATERLOGGED});
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(Properties.WATERLOGGED)) {
            // This is for 1.17 and below: world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    //is this when player tries to plant?
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        switch (seed) {
            case "rice_crop":
                if(world.getFluidState(pos.up(1)).isOf(Fluids.WATER) && world.getBlockState(pos.up(2)).isOf(Blocks.AIR))
                {
                    return true;
                }
            default: return false;
        }
    }

    //block allowed? nothing to do with the player.
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        switch (seed) {
            case "rice_crop":
                if(!world.getBlockState(pos.down(1)).isOf(this) && world.getBlockState(pos.up(-1)).isOf(Blocks.DIRT) && (world.getFluidState(pos.up(0)).isOf(Fluids.WATER) || world.getBlockState(pos.up(0)).isOf(this)) && (world.getBlockState(pos.up(1)).isOf(Blocks.AIR) || world.getBlockState(pos.up(1)).isOf(this)))
                {
                    return true;
                }
                else if (world.getBlockState(pos.down(1)).isOf(this)) {
                    return true;
                }
            default: return false;
        }
    }

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),

            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };

    //DOING THIS CAUSES issues with right click harvest. however. if we do not. icon is not present in WTHIT!
    @Override
    protected ItemConvertible getSeedsItem() {
        switch (seed) {
            case "rice_crop": return ModItems.RICE;
            default: return Items.AIR;
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }

    //this fixes light issue. and seasons support.
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float f2;
        int i2;
        if(Seasons.isSeasonsEnabled() && world.getBaseLightLevel(pos.up(2), 0) >= 9 && (i2 = this.getAge(state)) < this.getMaxAge() && random.nextInt((int) (25.0f / (f2 = 7.0f)) + 1) == 0) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if(cropData != null) {
                int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                int currentCropAge = this.getAge(state);

                if(currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > 0.5f) { //0.5f = 50% "halfway thru season"
                    Photosynthesis.LOGGER.info("CropWL: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NewCropAge: "+(this.getAge(state) + 1)+", %:"+seasonPercentage);
                    world.setBlockState(pos, this.withAge(this.getAge(state) + 1), 2);
                } else {
                    Photosynthesis.LOGGER.info("CropWL: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NO GROW"+", %:"+seasonPercentage);
                }
            }
        } else if(!Seasons.isSeasonsEnabled()) {
            //SEASONS DISABLED
            float f;
            int i;
            int currentAge = this.getAge(state);
            if (world.getBaseLightLevel(pos.up(2), 0) >= 9 && (i = currentAge) < this.getMaxAge() && random.nextInt((int) (25.0f / (f = 7.0f)) + 1) == 0) {

                if(currentAge < LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
                    //world.setBlockState(pos, this.withAge(currentAge + 1), Block.NOTIFY_LISTENERS);
                    world.setBlockState(pos, withWaterloggedState(world, pos, this.withAge(currentAge + 1)), Block.NOTIFY_LISTENERS);
                }
                else if(currentAge == LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
                    if(world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                        world.setBlockState(pos.up(1), withWaterloggedState(world, pos.up(1), (BlockState)this.getDefaultState().with(AGE, currentAge+1)), Block.NOTIFY_LISTENERS);
                    }
                }
                else if(world.getBlockState(pos.down()).isOf(this) && world.getBlockState(pos.down()).get(AGE) == LOWER_HALF_MAX_AGE && currentAge < UPPER_HALF_MAX_AGE) {
                    world.setBlockState(pos, this.withAge(currentAge + 1), Block.NOTIFY_LISTENERS);
                }
            }
        }
    }

    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int currentAge = this.getAge(state);
        if(currentAge < LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
            world.setBlockState(pos, withWaterloggedState(world, pos, this.withAge(currentAge + 1)), Block.NOTIFY_LISTENERS);
        }
        else if(currentAge == LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
            if(world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                world.setBlockState(pos.up(1), withWaterloggedState(world, pos.up(1), (BlockState)this.getDefaultState().with(AGE, currentAge+1)), Block.NOTIFY_LISTENERS);
            }
        }
        else if(world.getBlockState(pos.down()).isOf(this) && world.getBlockState(pos.down()).get(AGE) == LOWER_HALF_MAX_AGE && currentAge < UPPER_HALF_MAX_AGE) {
            world.setBlockState(pos, this.withAge(currentAge + 1), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        if(Seasons.isSeasonsEnabled()) {
            return false;
        }

        int currentAge = this.getAge(state);
        if(currentAge < LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
            return true;
        }
        else if(currentAge == LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
            if(world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                return true;
            }
        }
        else if(world.getBlockState(pos.down()).isOf(this) && world.getBlockState(pos.down()).get(AGE) == LOWER_HALF_MAX_AGE && currentAge < UPPER_HALF_MAX_AGE) {
            return true;
        }

        return false;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlockState(pos, withWaterloggedState(world, pos, (BlockState)this.getDefaultState()), 3);
    }

    public static BlockState withWaterloggedState(WorldView world, BlockPos pos, BlockState state) {
        return state.contains(Properties.WATERLOGGED) ? (BlockState)state.with(Properties.WATERLOGGED, world.isWater(pos)) : state;
    }
}
