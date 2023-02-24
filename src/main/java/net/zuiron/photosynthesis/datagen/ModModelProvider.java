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
        };
        for (Item item : simple_items) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }
}
