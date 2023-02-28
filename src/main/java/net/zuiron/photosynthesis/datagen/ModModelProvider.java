package net.zuiron.photosynthesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
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
                ModItems.FLINT_HOE,
                ModItems.FLINT_KNIFE,
                ModItems.FLINT_PICKAXE,
                ModItems.FLINT_SHOVEL,
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
                ModItems.WOOL_RAW_BLACK,
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
                ModItems.WOOL_RAW_YELLOW,
                ModItems.SEASHELL,

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
                ModItems.SESAME_SEEDS,
                ModItems.MUSTARD_SEEDS,

                ModItems.CANDLEBERRIES,
                ModItems.CRANBERRIES,
                ModItems.HUCKLEBERRIES,
                ModItems.JUNIPERBERRIES,
                ModItems.MULBERRIES,

                ModItems.CUT_KIWI
        };
        for (Item item : simple_items) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }
}
