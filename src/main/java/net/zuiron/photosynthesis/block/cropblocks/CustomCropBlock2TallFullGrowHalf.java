package net.zuiron.photosynthesis.block.cropblocks;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.CropData;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.item.ModItems;

public class CustomCropBlock2TallFullGrowHalf extends CropBlock implements Waterloggable {
    String seed;

    public static final EnumProperty<DoubleBlockHalf> HALF;
    public CustomCropBlock2TallFullGrowHalf(Settings settings, String itemname) {
        super(settings);
        seed = itemname;
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if(state.get(Properties.AGE_7) == 7 && (world.getBlockState(pos.down()).isIn(BlockTags.DIRT) || world.getBlockState(pos.down()).isOf(Blocks.FARMLAND)) || world.getBlockState(pos.down()).isOf(this)) {
            //WE MUST DO THIS, IF WORLD-GEN CAN PLANT IT IN THE WILD!
            return true;
        }
        else if (state.get(HALF) == DoubleBlockHalf.LOWER && world.getBlockState(pos.down()).isOf(Blocks.FARMLAND)) {
            return true;
        }
        else if (state.get(HALF) == DoubleBlockHalf.UPPER && world.getBlockState(pos.down()).isOf(this)) {
            return true;
        }
        return false;
    }

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),

            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };


    @Override
    protected ItemConvertible getSeedsItem() {
        switch (seed) {
            case "corn_crop": return ModItems.CORN_SEEDS;
            case "tomato_crop": return ModItems.TOMATO_SEEDS;
            default: return Items.AIR;
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() == newState.getBlock()) {
            if(state.get(Properties.AGE_7) == 7 && newState.get(Properties.AGE_7) == 0) {
                switch (seed) {
                    case "corn_crop": {
                        if(state.get(HALF) == DoubleBlockHalf.UPPER) {
                            world.breakBlock(pos.down(), true);
                        }
                    }
                    case "tomato_crop": world.setBlockState(pos, this.withAge(3).with(HALF, state.get(HALF)), Block.NOTIFY_LISTENERS);
                }
            }
        } else if (state.getBlock() != newState.getBlock() && state.get(HALF) == DoubleBlockHalf.UPPER) {
            switch (seed) {
                case "corn_crop": {
                    if (state.get(HALF) == DoubleBlockHalf.UPPER) {
                        world.breakBlock(pos.down(), true);
                    }
                }
            }
        } else {
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(state.get(Properties.AGE_7) == 7 && world.getBlockState(pos.down()).isIn(BlockTags.DIRT)) {
            //WE MUST DO THIS, IF WORLD-GEN CAN PLANT IT IN THE WILD!
            world.setBlockState(pos.up(1), (BlockState)this.getDefaultState().with(AGE, 7).with(HALF, DoubleBlockHalf.UPPER), Block.NOTIFY_LISTENERS);
        }

        float f2;
        int i2;
        if(Seasons.isSeasonsEnabled() && world.getBaseLightLevel(pos.up(1), 0) >= 9 && (i2 = this.getAge(state)) < this.getMaxAge() && random.nextInt((int) (25.0f / (f2 = 7.0f)) + 1) == 0) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if(cropData != null) {
                int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                int currentCropAge = this.getAge(state);

                if(currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > 0.5f) { //0.5f = 50% "halfway thru season"
                    //Photosynthesis.LOGGER.info("CropWL: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NewCropAge: "+(this.getAge(state) + 1)+", %:"+seasonPercentage);
                    if(currentCropAge < 7) {
                        world.setBlockState(pos, this.withAge(currentCropAge + 1).with(HALF, state.get(HALF)), Block.NOTIFY_LISTENERS);
                    }
                    if(state.get(HALF) == DoubleBlockHalf.LOWER && currentCropAge >= 3 && world.getBlockState(pos.up(1)).isOf(Blocks.AIR) && world.getBlockState(pos.down(1)).isOf(Blocks.FARMLAND)) {
                        world.setBlockState(pos.up(1), (BlockState)this.getDefaultState().with(AGE, 3).with(HALF, DoubleBlockHalf.UPPER), Block.NOTIFY_LISTENERS);
                    }
                } else {
                    //Photosynthesis.LOGGER.info("CropWL: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NO GROW"+", %:"+seasonPercentage);
                }
            }
        } else if(!Seasons.isSeasonsEnabled()) {
            //SEASONS DISABLED
            float f;
            int i;
            int currentCropAge = this.getAge(state);
            if (world.getBaseLightLevel(pos.up(1), 0) >= 9 && (i = currentCropAge) < this.getMaxAge() && random.nextInt((int) (25.0f / (f = 7.0f)) + 1) == 0) {

                if(currentCropAge < 7) {
                    world.setBlockState(pos, this.withAge(currentCropAge + 1).with(HALF, state.get(HALF)), Block.NOTIFY_LISTENERS);
                }
                if(state.get(HALF) == DoubleBlockHalf.LOWER && currentCropAge >= 3 && world.getBlockState(pos.up(1)).isOf(Blocks.AIR) && world.getBlockState(pos.down(1)).isOf(Blocks.FARMLAND)) {
                    world.setBlockState(pos.up(1), (BlockState)this.getDefaultState().with(AGE, 3).with(HALF, DoubleBlockHalf.UPPER), Block.NOTIFY_LISTENERS);
                }

            }
        }
    }

    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int currentCropAge = this.getAge(state);
        if(currentCropAge < 7) {
            world.setBlockState(pos, this.withAge(currentCropAge + 1).with(HALF, state.get(HALF)), Block.NOTIFY_LISTENERS);
        }
        if(state.get(HALF) == DoubleBlockHalf.LOWER && currentCropAge >= 3 && world.getBlockState(pos.up(1)).isOf(Blocks.AIR) && world.getBlockState(pos.down(1)).isOf(Blocks.FARMLAND)) {
            world.setBlockState(pos.up(1), (BlockState)this.getDefaultState().with(AGE, 3).with(HALF, DoubleBlockHalf.UPPER), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        if(Seasons.isSeasonsEnabled()) {
            return false;
        }

        int currentCropAge = this.getAge(state);
        if(currentCropAge < 7) {
            return true;
        }

        return false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{HALF}).add(new Property[]{AGE});
    }

    static {
        HALF = Properties.DOUBLE_BLOCK_HALF;
    }
}
