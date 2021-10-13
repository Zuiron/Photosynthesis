package net.zuiron.photosynthesis.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.mixin.ItemAccessor;

public class ModItems {

    public static final Item BLUEBERRY = registerItem("blueberry",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item CUTTING_KNIFE = registerRemainderItem("cutting_knife",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));


    //	public static final Item CUSTOM_SEEDS = new AliasedBlockItem(TutorialMod.CUSTOM_CROP_BLOCK, new Item.Settings().group(ItemGroup.MISC));
    public static final Item CUSTOM_SEEDS = registerItem("custom_seeds",
            new AliasedBlockItem(ModBlocks.CUSTOM_CROP_BLOCK, new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));

    //------------------------------------------------------------------------------------------------------------------

    private static Item registerRemainderItem(String name, Item item) {
        Item remainderItem = registerItem(name, item);
        ((ItemAccessor) remainderItem).setRecipeRemainder(remainderItem);

        return remainderItem;
    }

    //register items.
    private static Item registerItem(String name, Item item){
        Photosynthesis.LOGGER.info("Registering item with name: " + name);
        return Registry.register(Registry.ITEM, new Identifier(Photosynthesis.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registered Mod Items for " + Photosynthesis.MOD_ID);
    }
}
