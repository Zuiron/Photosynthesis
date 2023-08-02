package net.zuiron.photosynthesis.block.cropblocks;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.api.CropData;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.item.ModItems;

public class CustomCropBlock2TallFullGrow extends CropBlock implements Waterloggable {
    String seed;
    public static final int LOWER_HALF_MAX_AGE = 3;
    public static final int UPPER_HALF_MAX_AGE = 7;
    public CustomCropBlock2TallFullGrow(Settings settings, String itemname) {
        super(settings);
        seed = itemname;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if(state.get(Properties.AGE_7) == 7 && world.getBlockState(pos.down()).isIn(BlockTags.DIRT)) {
            //WE MUST DO THIS, IF WORLD-GEN CAN PLANT IT IN THE WILD!
            world.setBlockState(pos.up(), (BlockState)this.getDefaultState().with(AGE, 7), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        switch (seed) {
            case "tomato_crop":
                if(state.get(Properties.AGE_7) == 3 && world.getBlockState(pos.down()).isIn(BlockTags.DIRT)) {
                    //WE MUST DO THIS, IF WORLD-GEN CAN PLANT IT IN THE WILD!
                    return true;
                }
                else if(state.get(Properties.AGE_7) == 7 && world.getBlockState(pos.down()).isOf(this)) {
                    //WE MUST DO THIS, IF WORLD-GEN CAN PLANT IT IN THE WILD!
                    return true;
                }
                else if(!world.getBlockState(pos.down(1)).isOf(this) && world.getBlockState(pos.up(-1)).isOf(Blocks.FARMLAND) && (world.getBlockState(pos.up(1)).isOf(Blocks.AIR) || world.getBlockState(pos.up(1)).isOf(this)))
                {
                    return true;
                }
                else if (world.getBlockState(pos.down(1)).isOf(this) && world.getBlockState(pos.down(1)).contains(AGE) && world.getBlockState(pos.down(1)).get(AGE) == LOWER_HALF_MAX_AGE && state.get(AGE) >= LOWER_HALF_MAX_AGE + 1) {
                    return true;
                }
            default: return false;
        }
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
            case "tomato_crop": return ModItems.TOMATO_SEEDS;
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
        if(Seasons.isSeasonsEnabled() && world.getBaseLightLevel(pos.up(1), 0) >= 9 && (i2 = this.getAge(state)) < this.getMaxAge() && random.nextInt((int) (25.0f / (f2 = 7.0f)) + 1) == 0) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if(cropData != null) {
                int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                int currentCropAge = this.getAge(state);

                if(currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > 0.5f) { //0.5f = 50% "halfway thru season"
                    //Photosynthesis.LOGGER.info("CropWL: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NewCropAge: "+(this.getAge(state) + 1)+", %:"+seasonPercentage);
                    if(currentCropAge < LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
                        world.setBlockState(pos, this.withAge(currentCropAge + 1), Block.NOTIFY_LISTENERS);
                    }
                    else if(currentCropAge == LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
                        if(world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                            world.setBlockState(pos.up(1), (BlockState)this.getDefaultState().with(AGE, currentCropAge+1), Block.NOTIFY_LISTENERS);
                        }
                    }
                    else if(world.getBlockState(pos.down()).isOf(this) && world.getBlockState(pos.down()).get(AGE) == LOWER_HALF_MAX_AGE && currentCropAge < UPPER_HALF_MAX_AGE) {
                        world.setBlockState(pos, this.withAge(currentCropAge + 1), Block.NOTIFY_LISTENERS);
                        if(currentCropAge + 1 == UPPER_HALF_MAX_AGE) {
                            world.setBlockState(pos.down(), this.withAge(UPPER_HALF_MAX_AGE), Block.NOTIFY_LISTENERS);
                        }
                    }
                } else {
                    //Photosynthesis.LOGGER.info("CropWL: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NO GROW"+", %:"+seasonPercentage);
                }
            }
        } else if(!Seasons.isSeasonsEnabled()) {
            //SEASONS DISABLED
            float f;
            int i;
            int currentAge = this.getAge(state);
            if (world.getBaseLightLevel(pos.up(1), 0) >= 9 && (i = currentAge) < this.getMaxAge() && random.nextInt((int) (25.0f / (f = 7.0f)) + 1) == 0) {

                if(currentAge < LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
                    world.setBlockState(pos, this.withAge(currentAge + 1), Block.NOTIFY_LISTENERS);
                }
                else if(currentAge == LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
                    if(world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                        world.setBlockState(pos.up(1), (BlockState)this.getDefaultState().with(AGE, currentAge+1), Block.NOTIFY_LISTENERS);
                    }
                }
                else if(world.getBlockState(pos.down()).isOf(this) && world.getBlockState(pos.down()).get(AGE) == LOWER_HALF_MAX_AGE && currentAge < UPPER_HALF_MAX_AGE) {
                    world.setBlockState(pos, this.withAge(currentAge + 1), Block.NOTIFY_LISTENERS);
                    if(currentAge + 1 == UPPER_HALF_MAX_AGE) {
                        world.setBlockState(pos.down(), this.withAge(UPPER_HALF_MAX_AGE), Block.NOTIFY_LISTENERS);
                    }
                }
                /*else if(world.getBlockState(pos.down()).isOf(this) && world.getBlockState(pos.down()).get(AGE) == LOWER_HALF_MAX_AGE && currentAge == UPPER_HALF_MAX_AGE) {
                    //fully grown top. now grow bottom to full!
                    world.setBlockState(pos.down(), this.withAge(UPPER_HALF_MAX_AGE), Block.NOTIFY_LISTENERS);
                }*/
            }
        }
    }

    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int currentAge = this.getAge(state);
        if(currentAge < LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
            world.setBlockState(pos, this.withAge(currentAge + 1), Block.NOTIFY_LISTENERS);
        }
        else if(currentAge == LOWER_HALF_MAX_AGE && !world.getBlockState(pos.up()).isOf(this)) {
            if(world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                world.setBlockState(pos.up(1), (BlockState)this.getDefaultState().with(AGE, currentAge+1), Block.NOTIFY_LISTENERS);
            }
        }
        else if(world.getBlockState(pos.down()).isOf(this) && world.getBlockState(pos.down()).get(AGE) == LOWER_HALF_MAX_AGE && currentAge < UPPER_HALF_MAX_AGE) {
            world.setBlockState(pos, this.withAge(currentAge + 1), Block.NOTIFY_LISTENERS);
            if(currentAge + 1 == UPPER_HALF_MAX_AGE) {
                world.setBlockState(pos.down(), this.withAge(UPPER_HALF_MAX_AGE), Block.NOTIFY_LISTENERS);
            }
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
}
