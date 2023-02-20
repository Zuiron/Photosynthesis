package net.zuiron.photosynthesis.block.cropblocks;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.zuiron.photosynthesis.item.ModItems;

public class CustomCropBlock extends CropBlock {
    String seed;
    public CustomCropBlock(Settings settings, String itemname) {
        super(settings);
        seed = itemname;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        switch (seed) {
            case "rice_crop_anotherclass": if(world.getFluidState(pos.up(1)).isOf(Fluids.WATER)) { return true; }
            default: return floor.isOf(Blocks.FARMLAND);
        }
    }

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)
    };

    @Override
    protected ItemConvertible getSeedsItem() {

        switch (seed) {
            case "tomato_crop": return ModItems.TOMATO;
            case "basil_crop": return ModItems.BASIL;
            case "oregano_crop": return ModItems.OREGANO;
            case "strawberry_crop": return ModItems.STRAWBERRY;
            case "oat_crop": return ModItems.OAT;
            case "jalapeno_crop": return ModItems.JALAPENO;
            case "chili_crop": return ModItems.CHILI;
            case "cucumber_crop": return ModItems.CUCUMBER;
            case "onion_crop": return ModItems.ONION;
            case "leek_crop": return ModItems.LEEK;
            case "celery_crop": return ModItems.CELERY;
            case "peas_crop": return ModItems.PEAS;
            case "sweet_potato_crop": return ModItems.SWEET_POTATO;
            case "asparagus_crop": return ModItems.ASPARAGUS;
            case "scallion_crop": return ModItems.SCALLION;
            case "garlic_crop": return ModItems.GARLIC;
            case "chive_crop": return ModItems.CHIVE;
            case "broccoli_crop": return ModItems.BROCCOLI;
            case "cauliflower_crop": return ModItems.CAULIFLOWER;
            case "corn_crop": return ModItems.CORN;
            case "black_pepper_crop": return ModItems.BLACK_PEPPER;
            case "cabbage_crop": return ModItems.CABBAGE;
            case "bellpepper_crop": return ModItems.RED_BELLPEPPER;
            case "turnip_crop": return ModItems.TURNIP;
            case "rutabaga_crop": return ModItems.RUTABAGA;
            case "canola_crop": return ModItems.CANOLA;
            case "barley_crop": return ModItems.BARLEY;
            case "cotton_crop": return ModItems.COTTON;
            case "sugarbeet_crop": return ModItems.SUGARBEET;
            case "rice_crop": return ModItems.RICE;
            case "soybean_crop": return ModItems.SOYBEAN;
            case "spinach_crop": return ModItems.SPINACH;
            case "arrowroot_crop": return ModItems.ARROWROOT;
            case "artichoke_crop": return ModItems.ARTICHOKE;
            case "brussels_sprouts_crop": return ModItems.BRUSSELS_SPROUTS;
            case "cassava_crop": return ModItems.CASSAVA;
            case "eggplant_crop": return ModItems.EGGPLANT;
            case "sunflower_crop": return ModItems.SUNFLOWER;
            case "jicama_crop": return ModItems.JICAMA;
            case "kale_crop": return ModItems.KALE;
            case "kohlrabi_crop": return ModItems.KOHLRABI;
            case "lettuce_crop": return ModItems.LETTUCE;
            case "okra_crop": return ModItems.OKRA;
            case "parsnip_crop": return ModItems.PARSNIP;
            case "radish_crop": return ModItems.RADISH;
            case "rhubarb_crop": return ModItems.RHUBARB;

            case "millet_crop": return ModItems.MILLET;
            case "rye_crop": return ModItems.RYE;
            case "squash_crop": return ModItems.SQUASH;
            case "zucchini_crop": return ModItems.ZUCCHINI;
            case "coffea_crop": return ModItems.COFFEA;
            //case "grape_crop": return ModItems.GRAPE;
            case "parsley_crop": return ModItems.PARSLEY;
            case "mint_crop": return ModItems.MINT;
            case "pineapple_crop": return ModItems.PINEAPPLE;
            case "hop_crop": return ModItems.HOP;
            case "filipendula_crop": return ModItems.FILIPENDULA;

            case "camellia_sinensis_crop": return ModItems.CAMELLIA_SINENSIS;
            case "nicotiana_rustica_crop": return ModItems.NICOTIANA_RUSTICA;
            case "papaver_somniferum_crop": return ModItems.PAPAVER_SOMNIFERUM;
            case "erythroxylum_coca_crop": return ModItems.ERYTHROXYLUM_COCA;

            default: return Items.AIR;
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }
}
