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
    // CRAFTING TOOLS --------------------------------------------------------------------------------------------------

    // -------------- Remainder Items
    public static final Item CUTTING_KNIFE = registerRemainderItem("cutting_knife",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item MORTAR_PESTLE = registerRemainderItem("mortar_pestle",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item ROLLING_PIN = registerRemainderItem("rolling_pin",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item PLATE = registerRemainderItem("plate",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));


    // -------------- Crafting Items
    public static final Item MORTAR = registerItem("mortar",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item PESTLE = registerItem("pestle",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item ROLLING_PIN_PART = registerItem("rolling_pin_part",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item ROLLING_PIN_HANDLE = registerItem("rolling_pin_handle",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item ROLLING_PIN_PIN = registerItem("rolling_pin_pin",
            new Item(new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));



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

    public static final Item OAT = registerItem("oat",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item JALAPENO = registerItem("jalapeno",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item CHILI = registerItem("chili",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item CUCUMBER = registerItem("cucumber",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item ONION = registerItem("onion",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item LEEK = registerItem("leek",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item CELERY = registerItem("celery",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item PEAS = registerItem("peas",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item SWEET_POTATO = registerItem("sweet_potato",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item ASPARAGUS = registerItem("asparagus",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item SCALLION = registerItem("scallion",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item GARLIC = registerItem("garlic",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item CHIVE = registerItem("chive",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item BROCCOLI = registerItem("broccoli",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item BLACK_PEPPER = registerItem("black_pepper",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item CABBAGE = registerItem("cabbage",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item RED_BELLPEPPER = registerItem("red_bellpepper",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item GREEN_BELLPEPPER = registerItem("green_bellpepper",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item YELLOW_BELLPEPPER = registerItem("yellow_bellpepper",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item TURNIP = registerItem("turnip",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item RUTABAGA = registerItem("rutabaga",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item CANOLA = registerItem("canola",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item BARLEY = registerItem("barley",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item COTTON = registerItem("cotton",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item SUGARBEET = registerItem("sugarbeet",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item RICE = registerItem("rice",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item SOYBEAN = registerItem("soybean",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item SPINACH = registerItem("spinach",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item ARROWROOT = registerItem("arrowroot",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item ARTICHOKE = registerItem("artichoke",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item BRUSSELS_SPROUTS = registerItem("brussels_sprouts",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item CASSAVA = registerItem("cassava",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item SUNFLOWER = registerItem("sunflower",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));

    public static final Item JICAMA = registerItem("jicama",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())
                    .group(ModItemGroup.PHOTOSYNTHESIS)));


    // CROP SEEDS ----------------------------------------------------------------------------------------------------
    public static final Item TOMATO_SEEDS = registerSeedItem("tomato_seeds", ModBlocks.TOMATO_CROP);
    public static final Item BASIL_SEEDS = registerSeedItem("basil_seeds", ModBlocks.BASIL_CROP);
    public static final Item OREGANO_SEEDS = registerSeedItem("oregano_seeds", ModBlocks.OREGANO_CROP);
    public static final Item STRAWBERRY_SEEDS = registerSeedItem("strawberry_seeds", ModBlocks.STRAWBERRY_CROP);
    public static final Item OAT_SEEDS = registerSeedItem("oat_seeds", ModBlocks.OAT_CROP);
    public static final Item JALAPENO_SEEDS = registerSeedItem("jalapeno_seeds", ModBlocks.JALAPENO_CROP);
    public static final Item CHILI_SEEDS = registerSeedItem("chili_seeds", ModBlocks.CHILI_CROP);
    public static final Item CUCUMBER_SEEDS = registerSeedItem("cucumber_seeds", ModBlocks.CUCUMBER_CROP);
    public static final Item ONION_SEEDS = registerSeedItem("onion_seeds", ModBlocks.ONION_CROP);
    public static final Item LEEK_SEEDS = registerSeedItem("leek_seeds", ModBlocks.LEEK_CROP);
    public static final Item CELERY_SEEDS = registerSeedItem("celery_seeds", ModBlocks.CELERY_CROP);
    public static final Item PEAS_SEEDS = registerSeedItem("peas_seeds", ModBlocks.PEAS_CROP);
    public static final Item SWEET_POTATO_SEEDS = registerSeedItem("sweet_potato_seeds", ModBlocks.SWEET_POTATO_CROP);
    public static final Item ASPARAGUS_SEEDS = registerSeedItem("asparagus_seeds", ModBlocks.ASPARAGUS_CROP);
    public static final Item SCALLION_SEEDS = registerSeedItem("scallion_seeds", ModBlocks.SCALLION_CROP);
    public static final Item GARLIC_SEEDS = registerSeedItem("garlic_seeds", ModBlocks.GARLIC_CROP);
    public static final Item CHIVE_SEEDS = registerSeedItem("chive_seeds", ModBlocks.CHIVE_CROP);
    public static final Item BROCCOLI_SEEDS = registerSeedItem("broccoli_seeds", ModBlocks.BROCCOLI_CROP);
    public static final Item CAULIFLOWER_SEEDS = registerSeedItem("cauliflower_seeds", ModBlocks.CAULIFLOWER_CROP);
    public static final Item CORN_SEEDS = registerSeedItem("corn_seeds", ModBlocks.CORN_CROP);
    public static final Item BLACK_PEPPER_SEEDS = registerSeedItem("black_pepper_seeds", ModBlocks.BLACK_PEPPER_CROP);
    public static final Item CABBAGE_SEEDS = registerSeedItem("cabbage_seeds", ModBlocks.CABBAGE_CROP);
    public static final Item BELLPEPPER_SEEDS = registerSeedItem("bellpepper_seeds", ModBlocks.BELLPEPPER_CROP);
    public static final Item TURNIP_SEEDS = registerSeedItem("turnip_seeds", ModBlocks.TURNIP_CROP);
    public static final Item RUTABAGA_SEEDS = registerSeedItem("rutabaga_seeds", ModBlocks.RUTABAGA_CROP);
    public static final Item CANOLA_SEEDS = registerSeedItem("canola_seeds", ModBlocks.CANOLA_CROP);
    public static final Item BARLEY_SEEDS = registerSeedItem("barley_seeds", ModBlocks.BARLEY_CROP);
    public static final Item COTTON_SEEDS = registerSeedItem("cotton_seeds", ModBlocks.COTTON_CROP);
    public static final Item SUGARBEET_SEEDS = registerSeedItem("sugarbeet_seeds", ModBlocks.SUGARBEET_CROP);
    public static final Item RICE_SEEDS = registerSeedItem("rice_seeds", ModBlocks.RICE_CROP);
    public static final Item SUGARCANE_SEEDS = registerSeedItem("sugarcane_seeds", ModBlocks.SUGARCANE_CROP);
    public static final Item SOYBEAN_SEEDS = registerSeedItem("soybean_seeds", ModBlocks.SOYBEAN_CROP);
    public static final Item SPINACH_SEEDS = registerSeedItem("spinach_seeds", ModBlocks.SPINACH_CROP);
    public static final Item ARROWROOT_SEEDS = registerSeedItem("arrowroot_seeds", ModBlocks.ARROWROOT_CROP);
    public static final Item ARTICHOKE_SEEDS = registerSeedItem("artichoke_seeds", ModBlocks.ARTICHOKE_CROP);
    public static final Item BRUSSELS_SPROUTS_SEEDS = registerSeedItem("brussels_sprouts_seeds", ModBlocks.BRUSSELS_SPROUTS_CROP);
    public static final Item CASSAVA_SEEDS = registerSeedItem("cassava_seeds", ModBlocks.CASSAVA_CROP);
    public static final Item EGGPLANT_SEEDS = registerSeedItem("eggplant_seeds", ModBlocks.EGGPLANT_CROP);
    public static final Item SUNFLOWER_SEEDS = registerSeedItem("sunflower_seeds", ModBlocks.SUNFLOWER_CROP);
    public static final Item JICAMA_SEEDS = registerSeedItem("jicama_seeds", ModBlocks.JICAMA_CROP);


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
