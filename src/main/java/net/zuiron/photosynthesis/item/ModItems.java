package net.zuiron.photosynthesis.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.CropBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.mixin.ItemAccessor;

public class ModItems {

    // BERRIES ---------------------------------------------------------------------------------------------------------
    public static final Item BLUEBERRIES = registerBerryItem("blueberries", ModBlocks.BLUEBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS));

    public static final Item BLACKBERRIES = registerBerryItem("blackberries", ModBlocks.BLACKBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS));

    public static final Item RASPBERRIES = registerBerryItem("raspberries", ModBlocks.RASPBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS));

    public static final Item CLOUDBERRIES = registerBerryItem("cloudberries", ModBlocks.CLOUDBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS));

    public static final Item WILD_STRAWBERRIES = registerBerryItem("wild_strawberries", ModBlocks.WILD_STRAWBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS));


    // CRAFTING TOOLS --------------------------------------------------------------------------------------------------
    public static final Item CUTTING_KNIFE = registerRemainderItem("cutting_knife",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));


    // CROP PRODUCE ----------------------------------------------------------------------------------------------------
    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item BASIL = registerItem("basil",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item OREGANO = registerItem("oregano",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item STRAWBERRY = registerItem("strawberry",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));


    // CROP SEEDS ----------------------------------------------------------------------------------------------------
    public static final Item TOMATO_SEEDS = registerSeedItem("tomato_seeds", ModBlocks.TOMATO_CROP);
    public static final Item BASIL_SEEDS = registerSeedItem("basil_seeds", ModBlocks.BASIL_CROP);
    public static final Item OREGANO_SEEDS = registerSeedItem("oregano_seeds", ModBlocks.OREGANO_CROP);
    public static final Item STRAWBERRY_SEEDS = registerSeedItem("oregano_seeds", ModBlocks.STRAWBERRY_CROP);



    // END OF ModItems -------------------------------------------------------------------------------------------------
    private static Item registerBerryItem(String name, SweetBerryBushBlock alias, FabricItemSettings settings) {
        return Registry.register(Registry.ITEM, new Identifier(Photosynthesis.MOD_ID, name),
                new AliasedBlockItem(alias, settings));
    }

    private static Item registerBlockItem(String name, BlockItem item) {
        return Registry.register(Registry.ITEM, new Identifier(Photosynthesis.MOD_ID, name), item);
    }

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
