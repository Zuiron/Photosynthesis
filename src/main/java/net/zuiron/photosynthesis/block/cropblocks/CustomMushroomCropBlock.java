package net.zuiron.photosynthesis.block.cropblocks;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
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

public class CustomMushroomCropBlock extends CropBlock {
    String seed;
    public CustomMushroomCropBlock(Settings settings, String itemname) {
        super(settings);
        seed = itemname;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        /*switch (seed) {
            case "white_button_mushroom": return floor.isOpaqueFullCube(world, pos);
            default: return floor.isOf(Blocks.FARMLAND);
        }*/
        return floor.isOpaqueFullCube(world, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if(state.get(Properties.AGE_7) == 7 && world.getBlockState(pos.down()).isIn(BlockTags.DIRT)) {
            //WE MUST DO THIS, IF WORLD-GEN CAN PLANT IT IN THE WILD!
            return true;
        }
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isIn(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        }
        return world.getBaseLightLevel(pos, 0) < 13 && this.canPlantOnTop(blockState, world, blockPos);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return !Seasons.isSeasonsEnabled();
    }

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(3, 0, 3, 13, 2, 13),
            Block.createCuboidShape(3, 0, 3, 13, 4, 13),
            Block.createCuboidShape(3, 0, 3, 13, 4, 13),
            Block.createCuboidShape(3, 0, 3, 13, 6, 13),
            Block.createCuboidShape(3, 0, 3, 13, 6, 13),
            Block.createCuboidShape(3, 0, 3, 13, 8, 13),
            Block.createCuboidShape(3, 0, 3, 13, 8, 13),
            Block.createCuboidShape(3, 0, 3, 13, 10, 13)
    };

    //DOING THIS CAUSES issues with right click harvest. however. if we do not. icon is not present in WTHIT!
    @Override
    protected ItemConvertible getSeedsItem() {
        switch (seed) {
            case "white_button_mushroom_crop": return ModItems.WHITE_BUTTON_MUSHROOM_SPORES;
            case "porcini_mushroom_crop": return ModItems.PORCINI_MUSHROOM_SPORES;
            case "chanterelle_mushroom_crop": return ModItems.CHANTERELLE_MUSHROOM_SPORES;
            case "morel_mushroom_crop": return ModItems.MOREL_MUSHROOM_SPORES;
            default: return Items.AIR;
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        //return !this.isMature(state);
        return true;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        //prevent fertilizer use.
        return ActionResult.FAIL;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float f2;
        int i2;
        if(Seasons.isSeasonsEnabled() && world.getBaseLightLevel(pos, 0) < 13 && (i2 = this.getAge(state)) < this.getMaxAge() && random.nextInt((int) (25.0f / (f2 = 7.0f)) + 1) == 0) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if(cropData != null) {
                int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                int currentCropAge = this.getAge(state);

                if(currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > 0.5f) { //0.5f = 50% "halfway thru season"
                    //Photosynthesis.LOGGER.info("CropMUSHROOM: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NewCropAge: "+(this.getAge(state) + 1)+", %:"+seasonPercentage);
                    world.setBlockState(pos, this.withAge(this.getAge(state) + 1), 2);
                } else {
                    //Photosynthesis.LOGGER.info("CropMUSHROOM: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NO GROW"+", %:"+seasonPercentage);
                }
            } else {
                //Photosynthesis.LOGGER.info("No data for: "+state.getBlock().getTranslationKey());
            }
        } else if(!Seasons.isSeasonsEnabled()) {
            //SEASONS DISABLED
            float f;
            int i;
            if (world.getBaseLightLevel(pos, 0) < 13 && (i = this.getAge(state)) < this.getMaxAge() && random.nextInt((int) (25.0f / (f = 7.0f)) + 1) == 0) {
                world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
            }
        }

        //TODO - spread mushroom! IF age is mature. (max)
        if (random.nextInt(25) == 0 && this.getAge(state) == this.getMaxAge()) {
            if(Seasons.isSeasonsEnabled()) {
                CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
                int CurSeason = Seasons.getCurrentSeason(world.getTimeOfDay());
                int harvestSeason = cropData.getHarvestSeason();
                if(CurSeason != harvestSeason) {
                    //Photosynthesis.LOGGER.info("seasons enabled && we are stopping, wrong season to spread!");
                    return;
                }
            }
            //Photosynthesis.LOGGER.info("we are suppose to spread.");
            int i = 5;
            int j = 4;
            for (BlockPos blockPos : BlockPos.iterate(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
                if (!world.getBlockState(blockPos).isOf(this) || --i > 0) continue;
                return;
            }
            BlockPos blockPos2 = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
            for (int k = 0; k < 4; ++k) {
                if (world.isAir(blockPos2) && state.canPlaceAt(world, blockPos2)) {
                    pos = blockPos2;
                }
                blockPos2 = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
            }
            if (world.isAir(blockPos2) && state.canPlaceAt(world, blockPos2)) {
                world.setBlockState(blockPos2, state.with(Properties.AGE_7, 0), Block.NOTIFY_LISTENERS);
                //Photosynthesis.LOGGER.info("we are spreading!");
            }
        }
    }
}
