package net.zuiron.photosynthesis.block.cropblocks;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
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

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if(state.get(Properties.AGE_7) == 7 && world.getBlockState(pos.down()).isIn(BlockTags.DIRT)) {
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
            case "basil_crop": return ModItems.BASIL_SEEDS;
            case "oregano_crop": return ModItems.OREGANO_SEEDS;
            case "strawberry_crop": return ModItems.STRAWBERRY_SEEDS;
            case "oat_crop": return ModItems.OAT_SEEDS;
            case "jalapeno_crop": return ModItems.JALAPENO_SEEDS;
            case "chili_crop": return ModItems.CHILI_SEEDS;
            case "cucumber_crop": return ModItems.CUCUMBER_SEEDS;
            case "onion_crop": return ModItems.ONION_SEEDS;
            case "leek_crop": return ModItems.LEEK_SEEDS;
            case "celery_crop": return ModItems.CELERY_SEEDS;
            case "peas_crop": return ModItems.PEAS_SEEDS;
            case "sweet_potato_crop": return ModItems.SWEET_POTATO_SEEDS;
            case "asparagus_crop": return ModItems.ASPARAGUS_SEEDS;
            case "scallion_crop": return ModItems.SCALLION_SEEDS;
            case "garlic_crop": return ModItems.GARLIC_SEEDS;
            case "chive_crop": return ModItems.CHIVE_SEEDS;
            case "broccoli_crop": return ModItems.BROCCOLI_SEEDS;
            case "cauliflower_crop": return ModItems.CAULIFLOWER_SEEDS;
            case "cabbage_crop": return ModItems.CABBAGE_SEEDS;
            case "bellpepper_crop": return ModItems.BELLPEPPER_SEEDS;
            case "turnip_crop": return ModItems.TURNIP_SEEDS;
            case "rutabaga_crop": return ModItems.RUTABAGA_SEEDS;
            case "canola_crop": return ModItems.CANOLA_SEEDS;
            case "barley_crop": return ModItems.BARLEY_SEEDS;
            case "cotton_crop": return ModItems.COTTON_SEEDS;
            case "sugarbeet_crop": return ModItems.SUGARBEET_SEEDS;
            case "soybean_crop": return ModItems.SOYBEAN_SEEDS;
            case "spinach_crop": return ModItems.SPINACH_SEEDS;
            case "arrowroot_crop": return ModItems.ARROWROOT_SEEDS;
            case "artichoke_crop": return ModItems.ARTICHOKE_SEEDS;
            case "brussels_sprouts_crop": return ModItems.BRUSSELS_SPROUTS_SEEDS;
            case "cassava_crop": return ModItems.CASSAVA_SEEDS;
            case "eggplant_crop": return ModItems.EGGPLANT_SEEDS;
            case "sunflower_crop": return ModItems.SUNFLOWER_SEEDS;
            case "jicama_crop": return ModItems.JICAMA_SEEDS;
            case "kale_crop": return ModItems.KALE_SEEDS;
            case "kohlrabi_crop": return ModItems.KOHLRABI_SEEDS;
            case "lettuce_crop": return ModItems.LETTUCE_SEEDS;
            case "okra_crop": return ModItems.OKRA_SEEDS;
            case "parsnip_crop": return ModItems.PARSNIP_SEEDS;
            case "radish_crop": return ModItems.RADISH_SEEDS;
            case "rhubarb_crop": return ModItems.RHUBARB_SEEDS;
            case "millet_crop": return ModItems.MILLET_SEEDS;
            case "rye_crop": return ModItems.RYE_SEEDS;
            case "squash_crop": return ModItems.SQUASH_SEEDS;
            case "zucchini_crop": return ModItems.ZUCCHINI_SEEDS;
            case "coffea_crop": return ModItems.COFFEA_SEEDS;
            case "parsley_crop": return ModItems.PARSLEY_SEEDS;
            case "mint_crop": return ModItems.MINT_SEEDS;
            case "pineapple_crop": return ModItems.PINEAPPLE_SEEDS;
            case "hop_crop": return ModItems.HOP_SEEDS;
            case "filipendula_crop": return ModItems.FILIPENDULA_SEEDS;
            case "camellia_sinensis_crop": return ModItems.CAMELLIA_SINENSIS_SEEDS;
            case "nicotiana_rustica_crop": return ModItems.NICOTIANA_RUSTICA_SEEDS;
            case "papaver_somniferum_crop": return ModItems.PAPAVER_SOMNIFERUM_SEEDS;
            case "erythroxylum_coca_crop": return ModItems.ERYTHROXYLUM_COCA_SEEDS;
            case "cactus_fruit_crop": return ModItems.CACTUS_FRUIT_SEEDS;
            case "cantaloupe_crop": return ModItems.CANTALOUPE_SEEDS;
            case "flax_crop": return ModItems.FLAX_SEEDS;
            case "jute_crop": return ModItems.JUTE_SEEDS;
            case "kenaf_crop": return ModItems.KENAF_SEEDS;
            case "sisal_crop": return ModItems.SISAL_SEEDS;
            case "amaranth_crop": return ModItems.AMARANTH_SEEDS;
            case "bean_crop": return ModItems.BEAN_SEEDS;
            case "chickpea_crop": return ModItems.CHICKPEA_SEEDS;
            case "lentil_crop": return ModItems.LENTIL_SEEDS;
            case "quinoa_crop": return ModItems.QUINOA_SEEDS;
            case "peanut_crop": return ModItems.PEANUT_SEEDS;
            case "taro_crop": return ModItems.TARO_SEEDS;
            case "tomatillo_crop": return ModItems.TOMATILLO_SEEDS;
            case "agave_crop": return ModItems.AGAVE_SEEDS;
            case "ginger_crop": return ModItems.GINGER_SEEDS;
            case "sesame_crop": return ModItems.SESAME_SEEDS;
            case "mustard_crop": return ModItems.MUSTARD_SEEDS;

            default: return Items.AIR;
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }
}
