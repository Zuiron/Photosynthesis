package net.zuiron.photosynthesis.block.cropblocks;

import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.item.ModItems;

public class CustomGrassCropBlock extends CropBlock {
    String seed;
    public CustomGrassCropBlock(Settings settings, String itemname) {
        super(settings);
        seed = itemname;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        switch (seed) {
            case "rice_crop_anotherclass": if(world.getFluidState(pos.up(1)).isOf(Fluids.WATER)) { return true; }
            default: return floor.isOf(Blocks.GRASS_BLOCK) || floor.isOf(Blocks.DIRT) || floor.isOf(Blocks.FARMLAND);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if(state.get(Properties.AGE_7) == 7 && super.canPlaceAt(state, world, pos) && (world.getBaseLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos))) {
            //WE MUST DO THIS, IF WORLD-GEN CAN PLANT IT IN THE WILD!
            return true;
        }
        return (world.getBaseLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos)) && super.canPlaceAt(state, world, pos);
    }

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };

    //DOING THIS CAUSES issues with right click harvest. however. if we do not. icon is not present in WTHIT!
    @Override
    protected ItemConvertible getSeedsItem() {

        switch (seed) {
            case "grass_crop": return ModItems.GRASS_SEEDS;
            case "dandelion_crop": return ModItems.DANDELION_SEEDS;
            case "poppy_crop": return ModItems.POPPY_SEEDS;
            case "blue_orchid_crop": return ModItems.BLUE_ORCHID_SEEDS;
            case "allium_crop": return ModItems.ALLIUM_SEEDS;
            case "azure_bluet_crop": return ModItems.AZURE_BLUET_SEEDS;
            case "red_tulip_crop": return ModItems.RED_TULIP_SEEDS;
            case "orange_tulip_crop": return ModItems.ORANGE_TULIP_SEEDS;
            case "white_tulip_crop": return ModItems.WHITE_TULIP_SEEDS;
            case "pink_tulip_crop": return ModItems.PINK_TULIP_SEEDS;
            case "oxeye_daisy_crop": return ModItems.OXEYE_DAISY_SEEDS;
            case "cornflower_crop": return ModItems.CORNFLOWER_SEEDS;
            case "lily_of_the_valley_crop": return ModItems.LILY_OF_THE_VALLEY_SEEDS;

            default: return Items.AIR;
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        if (Seasons.isSeasonsEnabled()) {
            return false;
        } else return this.getAge(state) < 7;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }
}
