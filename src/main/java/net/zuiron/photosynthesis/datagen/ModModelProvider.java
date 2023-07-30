package net.zuiron.photosynthesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        //itemModelGenerator.register(ModItems.CACTUS_FRUIT, );
        Item[] simple_items = {
                ModItems.FORESTY_BUNDLE,
                ModItems.GRASS_FIBRE_PIECE,
                ModItems.GRASS_TWINE,
                ModItems.GRASS_TWINE_DRY,
                ModItems.SHARP_FLINT_FRAGMENT,
                ModItems.SHEEP_BONES,
                ModItems.STONE_LARGE,
                ModItems.STONE_LONG,
                ModItems.STONE_SMALL,
                ModItems.STURDY_STICK,
                ModItems.TINY_CHARCOAL,
                ModItems.TREE_BRANCH,
                ModItems.TREE_CONE,
                ModItems.TREE_LEAF,
                /*ModItems.WOOL_RAW_BLACK,
                ModItems.WOOL_RAW_BLUE,
                ModItems.WOOL_RAW_BROWN,
                ModItems.WOOL_RAW_CYAN,
                ModItems.WOOL_RAW_DARK_GRAY,
                ModItems.WOOL_RAW_GRAY,
                ModItems.WOOL_RAW_GREEN,
                ModItems.WOOL_RAW_LIGHT_BLUE,
                ModItems.WOOL_RAW_LIME,
                ModItems.WOOL_RAW_MAGENTA,
                ModItems.WOOL_RAW_ORANGE,
                ModItems.WOOL_RAW_PINK,
                ModItems.WOOL_RAW_PURPLE,
                ModItems.WOOL_RAW_RED,
                ModItems.WOOL_RAW_WHITE,
                ModItems.WOOL_RAW_YELLOW,*/
                ModItems.SEASHELL,

                ModItems.GARDEN_GRUBBER_FLINT,
                ModItems.GARDEN_GRUBBER_IRON,
                ModItems.GARDEN_GRUBBER_DIAMOND,

                ModItems.CUTTING_KNIFE_FLINT,
                ModItems.CUTTING_KNIFE_IRON,
                ModItems.CUTTING_KNIFE_DIAMOND,

                ModItems.CUTTING_KNIFE_BLADE_FLINT,
                ModItems.CUTTING_KNIFE_BLADE_IRON,
                ModItems.CUTTING_KNIFE_BLADE_DIAMOND,

                ModItems.CUTTING_KNIFE_HANDLE,

                ModItems.CACTUS_FRUIT,
                ModItems.CACTUS_FRUIT_SEEDS,
                ModItems.CANTALOUPE,
                ModItems.CANTALOUPE_SEEDS,
                ModItems.FLAX,
                ModItems.FLAX_SEEDS,
                ModItems.JUTE,
                ModItems.JUTE_SEEDS,
                ModItems.KENAF,
                ModItems.KENAF_SEEDS,
                ModItems.SISAL,
                ModItems.SISAL_SEEDS,
                ModItems.AMARANTH,
                ModItems.AMARANTH_SEEDS,
                ModItems.BEAN,
                ModItems.BEAN_SEEDS,
                ModItems.CHICKPEA,
                ModItems.CHICKPEA_SEEDS,
                ModItems.LENTIL,
                ModItems.LENTIL_SEEDS,
                ModItems.QUINOA,
                ModItems.QUINOA_SEEDS,
                ModItems.PEANUT,
                ModItems.PEANUT_SEEDS,
                ModItems.TARO,
                ModItems.TARO_SEEDS,
                ModItems.TOMATILLO,
                ModItems.TOMATILLO_SEEDS,
                ModItems.AGAVE,
                ModItems.AGAVE_SEEDS,
                ModItems.GINGER,
                ModItems.GINGER_SEEDS,
                ModItems.SESAME,
                ModItems.SESAME_SEEDS,
                ModItems.MUSTARD,
                ModItems.MUSTARD_SEEDS,

                ModItems.LINGONBERRIES,
                ModItems.CRANBERRIES,
                ModItems.HUCKLEBERRIES,
                ModItems.JUNIPERBERRIES,
                ModItems.MULBERRIES,

                ModItems.COW_BRISKET,
                ModItems.COOKED_COW_BRISKET,
                ModItems.COW_RIBS,
                ModItems.COOKED_COW_RIBS,
                ModItems.COOKED_COW_ROAST_BEEF,
                ModItems.COW_HEARTH,
                ModItems.COW_KIDNEY,
                ModItems.COW_LIVER,
                ModItems.COW_TONGUE,
                ModItems.COW_TRIMMINGS,
                ModItems.COW_STEAK,
                ModItems.COOKED_COW_STEAK,

                ModItems.BOILED_EGG,
                ModItems.WHEAT_DOUGH,

                ModItems.BBQ_SKEWERS,
                ModItems.MINCED_BEEF,
                ModItems.YELLOW_CHEESE,
                ModItems.ENGLISH_BREAKFAST,
                ModItems.MEATBALLS,
                ModItems.MINCED_PORK,
                ModItems.PUMPKIN_SOUP,
                ModItems.WAFFLE,

                ModItems.CUT_KIWI,
                /*ModItems.MEASURING_CUP,
                ModItems.MEASURING_CUP_WATER,
                ModItems.MEASURING_CUP_MILK,
                ModItems.MEASURING_CUP_MILK_CREAM,
                ModItems.MEASURING_CUP_CANOLAOIL,
                ModItems.MEASURING_CUP_SUNFLOWEROIL,
                ModItems.MEASURING_CUP_MEAD,
                */

                ModItems.LEATHER_WATER_BLADDER,
                ModItems.LEATHER_WATER_BLADDER_DIRTY,
                ModItems.LEATHER_WATER_BLADDER_CLEAN,

                ModItems.MARSHMALLOW,
                ModItems.BUTTER,
                ModItems.WHIPPED_CREAM,
                ModItems.COOKIE_DOUGH,
                ModItems.CHOCOLATE_COOKIE_DOUGH,
                ModItems.WHEAT_FLOUR,
                ModItems.BREAD_SLICE,
                ModItems.POWDERED_SUGAR,
                ModItems.GELATIN_SHEET,
                ModItems.VANILLA_POWDER,
                ModItems.PIZZA,
                ModItems.PANCAKES,
                ModItems.PIE,
                ModItems.CHICKEN_THIGH,
                ModItems.BAKED_SQUASH,
                ModItems.BAGUETTE,
                ModItems.OMELETTE,
                ModItems.GARLIC_BREAD_SLICE,
                ModItems.DUMPLING,
                ModItems.PANCAKE,
                ModItems.BREAD_FORM,
                ModItems.BACON,







        };
        for (Item item : simple_items) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }
}
