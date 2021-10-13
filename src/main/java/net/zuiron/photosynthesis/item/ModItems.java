package net.zuiron.photosynthesis.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.CropBlock;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.mixin.ItemAccessor;

public class ModItems {

    // BERRIES ---------------------------------------------------------------------------------------------------------
    public static final Item BLUEBERRY = registerItem("blueberry",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));



    // CRAFTING TOOLS --------------------------------------------------------------------------------------------------
    public static final Item CUTTING_KNIFE = registerRemainderItem("cutting_knife",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));



    // CROP PRODUCE ----------------------------------------------------------------------------------------------------
    public static final Item PRODUCE_TOMATO = registerItem("produce_tomato",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    // CROP SEEDS ----------------------------------------------------------------------------------------------------

    public static final Item TOMATO_SEEDS = registerSeedItem("tomato_seeds", ModBlocks.TOMATO_CROP_BLOCK);

    public static final Item CUSTOM_SEEDS = registerSeedItem("custom_seeds", ModBlocks.CUSTOM_CROP_BLOCK);

    // END OF ModItems -------------------------------------------------------------------------------------------------

    private static Item registerSeedItem(String name, CropBlock alias) {
        return Registry.register(Registry.ITEM, new Identifier(Photosynthesis.MOD_ID, name),
                new AliasedBlockItem(alias, new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));
    }

    private static Item registerRemainderItem(String name, Item item) {
        Item remainderItem = registerItem(name, item);
        ((ItemAccessor) remainderItem).setRecipeRemainder(remainderItem);

        return remainderItem;
    }

    private static Item registerItem(String name, Item item){
        Photosynthesis.LOGGER.info("Registering item with name: " + name);
        return Registry.register(Registry.ITEM, new Identifier(Photosynthesis.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registered Mod Items for " + Photosynthesis.MOD_ID);
    }
}
