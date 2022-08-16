package net.zuiron.photosynthesis.block;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.zuiron.photosynthesis.item.ModItems;

public class CustomCropBlock extends CropBlock {
    String seed;
    public CustomCropBlock(Settings settings, String itemname) {
        super(settings);
        seed = itemname;
    }

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
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

        if(seed == "tomato_crop") { return ModItems.TOMATO; }
        else if(seed == "basil_crop") { return ModItems.BASIL; }
        else if(seed == "oregano_crop") { return ModItems.OREGANO; }
        else if(seed == "strawberry_crop") { return ModItems.STRAWBERRY; }
        else if(seed == "oat_crop") { return ModItems.OAT; }
        else if(seed == "jalapeno_crop") { return ModItems.JALAPENO; }
        else if(seed == "chili_crop") { return ModItems.CHILI; }
        else if(seed == "cucumber_crop") { return ModItems.CUCUMBER; }
        else if(seed == "onion_crop") { return ModItems.ONION; }
        else if(seed == "leek_crop") { return ModItems.LEEK; }
        else if(seed == "celery_crop") { return ModItems.CELERY; }
        else if(seed == "peas_crop") { return ModItems.PEAS; }
        else if(seed == "sweet_potato_crop") { return ModItems.SWEET_POTATO; }
        else if(seed == "asparagus_crop") { return ModItems.ASPARAGUS; }
        else if(seed == "scallion_crop") { return ModItems.SCALLION; }
        else if(seed == "garlic_crop") { return ModItems.GARLIC; }
        else if(seed == "chive_crop") { return ModItems.CHIVE; }
        else if(seed == "broccoli_crop") { return ModItems.BROCCOLI; }
        else if(seed == "cauliflower_crop") { return ModItems.CAULIFLOWER; }
        else if(seed == "corn_crop") { return ModItems.CORN; }
        else if(seed == "black_pepper_crop") { return ModItems.BLACK_PEPPER; }
        else if(seed == "cabbage_crop") { return ModItems.CABBAGE; }
        else if(seed == "bellpepper_crop") { return ModItems.RED_BELLPEPPER; }
        else if(seed == "turnip_crop") { return ModItems.TURNIP; }
        else if(seed == "rutabaga_crop") { return ModItems.RUTABAGA; }
        else if(seed == "canola_crop") { return ModItems.CANOLA; }
        else if(seed == "barley_crop") { return ModItems.BARLEY; }
        else if(seed == "cotton_crop") { return ModItems.COTTON; }
        else if(seed == "sugarbeet_crop") { return ModItems.SUGARBEET; }
        else if(seed == "rice_crop") { return ModItems.RICE; }
        else if(seed == "sugarcane_crop") { return Items.SUGAR_CANE; }
        else if(seed == "soybean_crop") { return ModItems.SOYBEAN; }
        else if(seed == "spinach_crop") { return ModItems.SPINACH; }
        else if(seed == "arrowroot_crop") { return ModItems.ARROWROOT; }
        else if(seed == "artichoke_crop") { return ModItems.ARTICHOKE; }
        else if(seed == "brussels_sprouts_crop") { return ModItems.BRUSSELS_SPROUTS; }
        else if(seed == "cassava_crop") { return ModItems.CASSAVA; }
        else if(seed == "eggplant_crop") { return ModItems.EGGPLANT; }
        else if(seed == "sunflower_crop") { return ModItems.SUNFLOWER; }
        else if(seed == "jicama_crop") { return ModItems.JICAMA; }
        else if(seed == "kale_crop") { return ModItems.KALE; }
        else if(seed == "kohlrabi_crop") { return ModItems.KOHLRABI; }
        else if(seed == "lettuce_crop") { return ModItems.LETTUCE; }
        else if(seed == "okra_crop") { return ModItems.OKRA; }
        else if(seed == "parsnip_crop") { return ModItems.PARSNIP; }
        else if(seed == "radish_crop") { return ModItems.RADISH; }
        else if(seed == "rhubarb_crop") { return ModItems.RHUBARB; }

        else {
            return Items.AIR;
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }
}
