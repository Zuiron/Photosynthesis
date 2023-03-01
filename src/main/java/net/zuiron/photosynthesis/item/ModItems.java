package net.zuiron.photosynthesis.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.CropBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.mixin.ItemAccessor;




public class ModItems {
    // ORES
    public static final Item RAW_SALT = registerItem("raw_salt",
            new Item(new FabricItemSettings()));
    public static final Item SALT = registerItem("salt",
            new Item(new FabricItemSettings()));

    // SURVIVAL --------------------------------------------------------------------------------------------------------
    public static final Item FORESTY_BUNDLE = registerItem("foresty_bundle",
            new Item(new FabricItemSettings()));

    public static final Item GRASS_FIBRE_PIECE = registerItem("grass_fibre_piece",
            new Item(new FabricItemSettings()));

    public static final Item GRASS_TWINE = registerItem("grass_twine",
            new Item(new FabricItemSettings()));

    public static final Item GRASS_TWINE_DRY = registerItem("grass_twine_dry",
            new Item(new FabricItemSettings()));

    public static final Item SHARP_FLINT_FRAGMENT = registerItem("sharp_flint_fragment",
            new Item(new FabricItemSettings()));

    public static final Item SHEEP_BONES = registerItem("sheep_bones",
            new Item(new FabricItemSettings()));

    public static final Item STONE_LARGE = registerItem("stone_large",
            new Item(new FabricItemSettings()));

    public static final Item STONE_LONG = registerItem("stone_long",
            new Item(new FabricItemSettings()));

    public static final Item STONE_SMALL = registerItem("stone_small",
            new Item(new FabricItemSettings()));

    public static final Item STURDY_STICK = registerItem("sturdy_stick",
            new Item(new FabricItemSettings()));

    public static final Item TINY_CHARCOAL = registerItem("tiny_charcoal",
            new Item(new FabricItemSettings()));

    public static final Item TREE_BRANCH = registerItem("tree_branch",
            new Item(new FabricItemSettings()));

    public static final Item TREE_CONE = registerItem("tree_cone",
            new Item(new FabricItemSettings()));

    public static final Item TREE_LEAF = registerItem("tree_leaf",
            new Item(new FabricItemSettings()));

    /*public static final Item WOOL_RAW_BLACK = registerItem("wool_raw_black",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_BLUE = registerItem("wool_raw_blue",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_BROWN = registerItem("wool_raw_brown",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_CYAN = registerItem("wool_raw_cyan",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_DARK_GRAY = registerItem("wool_raw_dark_gray",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_GRAY = registerItem("wool_raw_gray",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_GREEN = registerItem("wool_raw_green",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_LIGHT_BLUE = registerItem("wool_raw_light_blue",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_LIME = registerItem("wool_raw_lime",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_MAGENTA = registerItem("wool_raw_magenta",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_ORANGE = registerItem("wool_raw_orange",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_PINK = registerItem("wool_raw_pink",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_PURPLE = registerItem("wool_raw_purple",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_RED = registerItem("wool_raw_red",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_WHITE = registerItem("wool_raw_white",
            new Item(new FabricItemSettings()));

    public static final Item WOOL_RAW_YELLOW = registerItem("wool_raw_yellow",
            new Item(new FabricItemSettings()));*/

    public static final Item SEASHELL = registerItem("seashell",
            new Item(new FabricItemSettings()));

    // TOOLS -----------------------------------------------------------------------------------------------------------
    public static final Item BARK_PEELER_SPUD = registerItem("bark_peeler_spud",
            new BarkPeelerSpudItem(PrimitiveToolMaterial.INSTANCE,
                    1,
                    -3.2F,
                    new FabricItemSettings()));

    /*public static final Item CUTTING_KNIFE = registerItem("cutting_knife",
            new Item(new FabricItemSettings()));*/
    public static final Item GARDEN_GRUBBER_FLINT = registerItem("garden_grubber_flint",
            new ShovelItem(PrimitiveToolMaterial.INSTANCE, 0, -0.0F, new FabricItemSettings()));
    public static final Item GARDEN_GRUBBER_IRON = registerItem("garden_grubber_iron",
            new ShovelItem(ToolMaterials.IRON, 0, -0.0F, new FabricItemSettings()));
    public static final Item GARDEN_GRUBBER_DIAMOND = registerItem("garden_grubber_diamond",
            new ShovelItem(ToolMaterials.DIAMOND, 0, -0.0F, new FabricItemSettings()));


    public static final Item CUTTING_KNIFE_FLINT = registerItem("cutting_knife_flint",
            new SwordItem(ToolMaterials.WOOD, 2, 3.4F, new FabricItemSettings()));
    public static final Item CUTTING_KNIFE_IRON = registerItem("cutting_knife_iron",
            new SwordItem(ToolMaterials.IRON, 2, 3.4F, new FabricItemSettings()));
    public static final Item CUTTING_KNIFE_DIAMOND = registerItem("cutting_knife_diamond",
            new SwordItem(ToolMaterials.DIAMOND, 2, 3.4F, new FabricItemSettings()));

    public static final Item CUTTING_KNIFE_BLADE_FLINT = registerItem("cutting_knife_blade_flint",
            new Item(new FabricItemSettings()));
    public static final Item CUTTING_KNIFE_BLADE_IRON = registerItem("cutting_knife_blade_iron",
            new Item(new FabricItemSettings()));
    public static final Item CUTTING_KNIFE_BLADE_DIAMOND = registerItem("cutting_knife_blade_diamond",
            new Item(new FabricItemSettings()));

    public static final Item CUTTING_KNIFE_HANDLE = registerItem("cutting_knife_handle",
            new Item(new FabricItemSettings()));

    /*public static final Item CUTTING_BOARD = registerRemainderItem("cutting_board",
            new Item(new FabricItemSettings()));*/

    public static final Item MORTAR_PESTLE = registerRemainderItem("mortar_pestle",
            new Item(new FabricItemSettings()));

    public static final Item MORTAR = registerItem("mortar",
            new Item(new FabricItemSettings()));

    public static final Item PESTLE = registerItem("pestle",
            new Item(new FabricItemSettings()));

    public static final Item PLATE = registerItem("plate",
            new Item(new FabricItemSettings()));

    public static final Item ROLLING_PIN = registerRemainderItem("rolling_pin",
            new Item(new FabricItemSettings()));

    public static final Item ROLLING_PIN_HANDLE = registerItem("rolling_pin_handle",
            new Item(new FabricItemSettings()));

    public static final Item ROLLING_PIN_PIN = registerItem("rolling_pin_pin",
            new Item(new FabricItemSettings()));

    public static final Item ROLLING_PIN_PART = registerItem("rolling_pin_part",
            new Item(new FabricItemSettings()));

    public static final Item SQUEEZER = registerRemainderItem("squeezer",
            new Item(new FabricItemSettings()));

    public static final Item SQUEEZER_PART = registerItem("squeezer_part",
            new Item(new FabricItemSettings()));

    public static final Item WHISK = registerRemainderItem("whisk",
            new Item(new FabricItemSettings()));

    public static final Item WHISK_PART = registerItem("whisk_part",
            new Item(new FabricItemSettings()));

    public static final Item WHISK_HANDLE = registerItem("whisk_handle",
            new Item(new FabricItemSettings()));

    public static final Item MEASURING_CUP = registerItem("measuring_cup",
            new Item(new FabricItemSettings()));
    public static final Item MEASURING_CUP_WATER = registerItem("measuring_cup_water",
            new Item(new FabricItemSettings().recipeRemainder(ModItems.MEASURING_CUP)));

    public static final Item MEASURING_CUP_MILK = registerItem("measuring_cup_milk",
            new Item(new FabricItemSettings().recipeRemainder(ModItems.MEASURING_CUP)));

    public static final Item MEASURING_CUP_CANOLAOIL = registerItem("measuring_cup_canolaoil",
            new Item(new FabricItemSettings().recipeRemainder(ModItems.MEASURING_CUP)));

    public static final Item MEASURING_CUP_SUNFLOWEROIL = registerItem("measuring_cup_sunfloweroil",
            new Item(new FabricItemSettings().recipeRemainder(ModItems.MEASURING_CUP)));

    /*
    LATEX_BUCKET = Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, "latex_bucket"),
                new BucketItem(ModFluids.STILL_LATEX, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
     */



    // BARK ------------------------------------------------------------------------------------------------------------
    public static final Item BARK_ACACIA = registerItem("bark_acacia",
            new Item(new FabricItemSettings()));
    public static final Item BARK_BIRCH = registerItem("bark_birch",
            new Item(new FabricItemSettings()));
    public static final Item BARK_DARK_OAK = registerItem("bark_dark_oak",
            new Item(new FabricItemSettings()));
    public static final Item BARK_JUNGLE = registerItem("bark_jungle",
            new Item(new FabricItemSettings()));
    public static final Item BARK_OAK = registerItem("bark_oak",
            new Item(new FabricItemSettings()));
    public static final Item BARK_SPRUCE = registerItem("bark_spruce",
            new Item(new FabricItemSettings()));

    // BERRIES ---------------------------------------------------------------------------------------------------------
    public static final Item BLUEBERRIES = registerBerryItem("blueberries", ModBlocks.BLUEBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item BLACKBERRIES = registerBerryItem("blackberries", ModBlocks.BLACKBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item RASPBERRIES = registerBerryItem("raspberries", ModBlocks.RASPBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item CLOUDBERRIES = registerBerryItem("cloudberries", ModBlocks.CLOUDBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item WILD_STRAWBERRIES = registerBerryItem("wild_strawberries", ModBlocks.WILD_STRAWBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item CANDLEBERRIES = registerBerryItem("candleberries", ModBlocks.CANDLEBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item CRANBERRIES = registerBerryItem("cranberries", ModBlocks.CRANBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item HUCKLEBERRIES = registerBerryItem("huckleberries", ModBlocks.HUCKLEBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item JUNIPERBERRIES = registerBerryItem("juniperberries", ModBlocks.JUNIPERBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item MULBERRIES = registerBerryItem("mulberries", ModBlocks.MULBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));






    // CROP PRODUCE ----------------------------------------------------------------------------------------------------
    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BASIL = registerItem("basil",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item OREGANO = registerItem("oregano",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item STRAWBERRY = registerItem("strawberry",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item OAT = registerItem("oat",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item JALAPENO = registerItem("jalapeno",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHILI = registerItem("chili",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CUCUMBER = registerItem("cucumber",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item ONION = registerItem("onion",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item LEEK = registerItem("leek",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CELERY = registerItem("celery",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PEAS = registerItem("peas",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SWEET_POTATO = registerItem("sweet_potato",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item ASPARAGUS = registerItem("asparagus",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SCALLION = registerItem("scallion",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item GARLIC = registerItem("garlic",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHIVE = registerItem("chive",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BROCCOLI = registerItem("broccoli",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    /*public static final Item BLACK_PEPPER = registerItem("black_pepper",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));*/

    public static final Item CABBAGE = registerItem("cabbage",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item RED_BELLPEPPER = registerItem("red_bellpepper",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item GREEN_BELLPEPPER = registerItem("green_bellpepper",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item YELLOW_BELLPEPPER = registerItem("yellow_bellpepper",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item TURNIP = registerItem("turnip",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item RUTABAGA = registerItem("rutabaga",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CANOLA = registerItem("canola",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BARLEY = registerItem("barley",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item COTTON = registerItem("cotton",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SUGARBEET = registerItem("sugarbeet",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item RICE = registerItem("rice",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SOYBEAN = registerItem("soybean",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SPINACH = registerItem("spinach",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item ARROWROOT = registerItem("arrowroot",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item ARTICHOKE = registerItem("artichoke",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BRUSSELS_SPROUTS = registerItem("brussels_sprouts",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CASSAVA = registerItem("cassava",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SUNFLOWER = registerItem("sunflower",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item JICAMA = registerItem("jicama",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item KALE = registerItem("kale",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item KOHLRABI = registerItem("kohlrabi",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item LETTUCE = registerItem("lettuce",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item OKRA = registerItem("okra",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PARSNIP = registerItem("parsnip",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item RADISH = registerItem("radish",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item RHUBARB = registerItem("rhubarb",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item MILLET = registerItem("millet",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item RYE = registerItem("rye",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SQUASH = registerItem("squash",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item ZUCCHINI = registerItem("zucchini",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item COFFEA = registerItem("coffea",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    /*public static final Item GRAPE = registerItem("grape",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));*/

    public static final Item PARSLEY = registerItem("parsley",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item MINT = registerItem("mint",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PINEAPPLE = registerItem("pineapple",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item HOP = registerItem("hop",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item FILIPENDULA = registerItem("filipendula",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));



    public static final Item CAMELLIA_SINENSIS = registerItem("camellia_sinensis",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item NICOTIANA_RUSTICA = registerItem("nicotiana_rustica",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PAPAVER_SOMNIFERUM = registerItem("papaver_somniferum",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item ERYTHROXYLUM_COCA = registerItem("erythroxylum_coca",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));



    public static final Item CACTUS_FRUIT = registerItem("cactus_fruit",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CANTALOUPE = registerItem("cantaloupe",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item FLAX = registerItem("flax",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item JUTE = registerItem("jute",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item KENAF = registerItem("kenaf",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SISAL = registerItem("sisal",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item AMARANTH = registerItem("amaranth",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BEAN = registerItem("bean",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHICKPEA = registerItem("chickpea",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item LENTIL = registerItem("lentil",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item QUINOA = registerItem("quinoa",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PEANUT = registerItem("peanut",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item TARO = registerItem("taro",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item TOMATILLO = registerItem("tomatillo",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item AGAVE = registerItem("agave",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item GINGER = registerItem("ginger",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    //sesame and mustard crops drops straight seeds.
    /*public static final Item SESAME = registerItem("sesame",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item MUSTARD = registerItem("mustard",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));*/

    // TREE PRODUCE ----------------------------------------------------------------------------------------------------

    public static final Item CINNAMON_RAW = registerItem("cinnamon_raw",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item GREENAPPLE = registerBerryItem("greenapple", ModBlocks.APPLETREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item BANANA = registerBerryItem("banana", ModBlocks.BANANATREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item ORANGE = registerBerryItem("orange", ModBlocks.ORANGETREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item PEAR = registerBerryItem("pear", ModBlocks.PEARTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item COCONUT = registerBerryItem("coconut", ModBlocks.COCONUTTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item AVOCADO = registerBerryItem("avocado", ModBlocks.AVOCADOTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item CHERRY = registerBerryItem("cherry", ModBlocks.CHERRYTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item LEMON = registerBerryItem("lemon", ModBlocks.LEMONTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item MANGO = registerBerryItem("mango", ModBlocks.MANGOTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item OLIVE = registerBerryItem("olive", ModBlocks.OLIVETREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));






    public static final Item CANDLENUT = registerBerryItem("candlenut", ModBlocks.CANDLENUTTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item CHESTNUT = registerBerryItem("chestnut", ModBlocks.CHESTNUTTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item NUTMEG = registerBerryItem("nutmeg", ModBlocks.NUTMEGTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item PEACH = registerBerryItem("peach", ModBlocks.PEACHTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item PLUM = registerBerryItem("plum", ModBlocks.PLUMTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item WALNUT = registerBerryItem("walnut", ModBlocks.WALNUTTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item HAZELNUT = registerBerryItem("hazelnut", ModBlocks.HAZELNUTTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item PAWPAW = registerBerryItem("pawpaw", ModBlocks.PAWPAWTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item SOURSOP = registerBerryItem("soursop", ModBlocks.SOURSOPTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item ALMOND = registerBerryItem("almond", ModBlocks.ALMONDTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item APRICOT = registerBerryItem("apricot", ModBlocks.APRICOTTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item CASHEW = registerBerryItem("cashew", ModBlocks.CASHEWTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item DATE = registerBerryItem("date", ModBlocks.DATETREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item DRAGONFRUIT = registerBerryItem("dragonfruit", ModBlocks.DRAGONFRUITTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item DURIAN = registerBerryItem("durian", ModBlocks.DURIANTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item FIG = registerBerryItem("fig", ModBlocks.FIGTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item GRAPEFRUIT = registerBerryItem("grapefruit", ModBlocks.GRAPEFRUITTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item LIME = registerBerryItem("lime", ModBlocks.LIMETREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item PAPAYA = registerBerryItem("papaya", ModBlocks.PAPAYATREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item PECAN = registerBerryItem("pecan", ModBlocks.PECANTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item PERSIMMON = registerBerryItem("persimmon", ModBlocks.PERSIMMONTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item PISTACHIO = registerBerryItem("pistachio", ModBlocks.PISTACHIOTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item POMEGRANATE = registerBerryItem("pomegranate", ModBlocks.POMEGRANATETREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item STARFRUIT = registerBerryItem("starfruit", ModBlocks.STARFRUITTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item BREADFRUIT = registerBerryItem("breadfruit", ModBlocks.BREADFRUITTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item GUAVA = registerBerryItem("guava", ModBlocks.GUAVATREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item JACKFRUIT = registerBerryItem("jackfruit", ModBlocks.JACKFRUITTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.4f).build()));

    public static final Item LYCHEE = registerBerryItem("lychee", ModBlocks.LYCHEETREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item PASSIONFRUIT = registerBerryItem("passionfruit", ModBlocks.PASSIONFRUITTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item RAMBUTAN = registerBerryItem("rambutan", ModBlocks.RAMBUTANTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item TAMARIND = registerBerryItem("tamarind", ModBlocks.TAMARINDTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));


    //'Peppercorn', 'Vanillabean', 'Pinenut', 'Gooseberry', 'Grape']
    public static final Item PEPPERCORN = registerBerryItem("peppercorn", ModBlocks.PEPPERCORNTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));
    public static final Item VANILLABEAN = registerBerryItem("vanillabean", ModBlocks.VANILLABEANTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));
    public static final Item PINENUT = registerBerryItem("pinenut", ModBlocks.PINENUTTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));
    public static final Item GOOSEBERRY = registerBerryItem("gooseberry", ModBlocks.GOOSEBERRYTREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));
    public static final Item GRAPE = registerBerryItem("grape", ModBlocks.GRAPETREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));

    public static final Item KIWI = registerBerryItem("kiwi", ModBlocks.KIWITREE_BUSHCROP,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));





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
    //public static final Item BLACK_PEPPER_SEEDS = registerSeedItem("black_pepper_seeds", ModBlocks.BLACK_PEPPER_CROP);
    public static final Item CABBAGE_SEEDS = registerSeedItem("cabbage_seeds", ModBlocks.CABBAGE_CROP);
    public static final Item BELLPEPPER_SEEDS = registerSeedItem("bellpepper_seeds", ModBlocks.BELLPEPPER_CROP);
    public static final Item TURNIP_SEEDS = registerSeedItem("turnip_seeds", ModBlocks.TURNIP_CROP);
    public static final Item RUTABAGA_SEEDS = registerSeedItem("rutabaga_seeds", ModBlocks.RUTABAGA_CROP);
    public static final Item CANOLA_SEEDS = registerSeedItem("canola_seeds", ModBlocks.CANOLA_CROP);
    public static final Item BARLEY_SEEDS = registerSeedItem("barley_seeds", ModBlocks.BARLEY_CROP);
    public static final Item COTTON_SEEDS = registerSeedItem("cotton_seeds", ModBlocks.COTTON_CROP);
    public static final Item SUGARBEET_SEEDS = registerSeedItem("sugarbeet_seeds", ModBlocks.SUGARBEET_CROP);
    public static final Item RICE_SEEDS = registerSeedItem("rice_seeds", ModBlocks.RICE_CROP);
    public static final Item SOYBEAN_SEEDS = registerSeedItem("soybean_seeds", ModBlocks.SOYBEAN_CROP);
    public static final Item SPINACH_SEEDS = registerSeedItem("spinach_seeds", ModBlocks.SPINACH_CROP);
    public static final Item ARROWROOT_SEEDS = registerSeedItem("arrowroot_seeds", ModBlocks.ARROWROOT_CROP);
    public static final Item ARTICHOKE_SEEDS = registerSeedItem("artichoke_seeds", ModBlocks.ARTICHOKE_CROP);
    public static final Item BRUSSELS_SPROUTS_SEEDS = registerSeedItem("brussels_sprouts_seeds", ModBlocks.BRUSSELS_SPROUTS_CROP);
    public static final Item CASSAVA_SEEDS = registerSeedItem("cassava_seeds", ModBlocks.CASSAVA_CROP);
    public static final Item EGGPLANT_SEEDS = registerSeedItem("eggplant_seeds", ModBlocks.EGGPLANT_CROP);
    public static final Item SUNFLOWER_SEEDS = registerSeedItem("sunflower_seeds", ModBlocks.SUNFLOWER_CROP);
    public static final Item JICAMA_SEEDS = registerSeedItem("jicama_seeds", ModBlocks.JICAMA_CROP);
    public static final Item KALE_SEEDS = registerSeedItem("kale_seeds", ModBlocks.KALE_CROP);
    public static final Item KOHLRABI_SEEDS = registerSeedItem("kohlrabi_seeds", ModBlocks.KOHLRABI_CROP);
    public static final Item LETTUCE_SEEDS = registerSeedItem("lettuce_seeds", ModBlocks.LETTUCE_CROP);
    public static final Item OKRA_SEEDS = registerSeedItem("okra_seeds", ModBlocks.OKRA_CROP);
    public static final Item PARSNIP_SEEDS = registerSeedItem("parsnip_seeds", ModBlocks.PARSNIP_CROP);
    public static final Item RADISH_SEEDS = registerSeedItem("radish_seeds", ModBlocks.RADISH_CROP);
    public static final Item RHUBARB_SEEDS = registerSeedItem("rhubarb_seeds", ModBlocks.RHUBARB_CROP);
    public static final Item MILLET_SEEDS = registerSeedItem("millet_seeds", ModBlocks.MILLET_CROP);
    public static final Item RYE_SEEDS = registerSeedItem("rye_seeds", ModBlocks.RYE_CROP);
    public static final Item SQUASH_SEEDS = registerSeedItem("squash_seeds", ModBlocks.SQUASH_CROP);
    public static final Item ZUCCHINI_SEEDS = registerSeedItem("zucchini_seeds", ModBlocks.ZUCCHINI_CROP);
    public static final Item COFFEA_SEEDS = registerSeedItem("coffea_seeds", ModBlocks.COFFEA_CROP);
    //public static final Item GRAPE_SEEDS = registerSeedItem("grape_seeds", ModBlocks.GRAPE_CROP);
    public static final Item PARSLEY_SEEDS = registerSeedItem("parsley_seeds", ModBlocks.PARSLEY_CROP);
    public static final Item MINT_SEEDS = registerSeedItem("mint_seeds", ModBlocks.MINT_CROP);
    public static final Item PINEAPPLE_SEEDS = registerSeedItem("pineapple_seeds", ModBlocks.PINEAPPLE_CROP);
    public static final Item HOP_SEEDS = registerSeedItem("hop_seeds", ModBlocks.HOP_CROP);
    public static final Item FILIPENDULA_SEEDS = registerSeedItem("filipendula_seeds", ModBlocks.FILIPENDULA_CROP);



    public static final Item CAMELLIA_SINENSIS_SEEDS = registerSeedItem("camellia_sinensis_seeds", ModBlocks.CAMELLIA_SINENSIS_CROP);
    public static final Item NICOTIANA_RUSTICA_SEEDS = registerSeedItem("nicotiana_rustica_seeds", ModBlocks.NICOTIANA_RUSTICA_CROP);
    public static final Item PAPAVER_SOMNIFERUM_SEEDS = registerSeedItem("papaver_somniferum_seeds", ModBlocks.PAPAVER_SOMNIFERUM_CROP);
    public static final Item ERYTHROXYLUM_COCA_SEEDS = registerSeedItem("erythroxylum_coca_seeds", ModBlocks.ERYTHROXYLUM_COCA_CROP);



    public static final Item CACTUS_FRUIT_SEEDS = registerSeedItem("cactus_fruit_seeds", ModBlocks.CACTUS_FRUIT_CROP);
    public static final Item CANTALOUPE_SEEDS = registerSeedItem("cantaloupe_seeds", ModBlocks.CANTALOUPE_CROP);
    public static final Item FLAX_SEEDS = registerSeedItem("flax_seeds", ModBlocks.FLAX_CROP);
    public static final Item JUTE_SEEDS = registerSeedItem("jute_seeds", ModBlocks.JUTE_CROP);
    public static final Item KENAF_SEEDS = registerSeedItem("kenaf_seeds", ModBlocks.KENAF_CROP);
    public static final Item SISAL_SEEDS = registerSeedItem("sisal_seeds", ModBlocks.SISAL_CROP);
    public static final Item AMARANTH_SEEDS = registerSeedItem("amaranth_seeds", ModBlocks.AMARANTH_CROP);
    public static final Item BEAN_SEEDS = registerSeedItem("bean_seeds", ModBlocks.BEAN_CROP);
    public static final Item CHICKPEA_SEEDS = registerSeedItem("chickpea_seeds", ModBlocks.CHICKPEA_CROP);
    public static final Item LENTIL_SEEDS = registerSeedItem("lentil_seeds", ModBlocks.LENTIL_CROP);
    public static final Item QUINOA_SEEDS = registerSeedItem("quinoa_seeds", ModBlocks.QUINOA_CROP);
    public static final Item PEANUT_SEEDS = registerSeedItem("peanut_seeds", ModBlocks.PEANUT_CROP);
    public static final Item TARO_SEEDS = registerSeedItem("taro_seeds", ModBlocks.TARO_CROP);
    public static final Item TOMATILLO_SEEDS = registerSeedItem("tomatillo_seeds", ModBlocks.TOMATILLO_CROP);
    public static final Item AGAVE_SEEDS = registerSeedItem("agave_seeds", ModBlocks.AGAVE_CROP);
    public static final Item GINGER_SEEDS = registerSeedItem("ginger_seeds", ModBlocks.GINGER_CROP);
    public static final Item SESAME_SEEDS = registerSeedItem("sesame_seeds", ModBlocks.SESAME_CROP);
    public static final Item MUSTARD_SEEDS = registerSeedItem("mustard_seeds", ModBlocks.MUSTARD_CROP);

    // Food's ----------------------------------------------------------------------------------------------------------

    public static final Item CANOLA_OIL_BOTTLE = registerItem("canola_oil_bottle",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SUNFLOWER_OIL_BOTTLE = registerItem("sunflower_oil_bottle",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CINNAMON_POWDER = registerItem("cinnamon_powder",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CUT_CHIVES = registerItem("cut_chives",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CUT_KIWI = registerItem("cut_kiwi",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CRACKED_EGG = registerItem("cracked_egg",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item FRIED_EGG = registerItem("fried_egg",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SCRAMBLED_EGG = registerItem("scrambled_egg",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item HARD_BOILED_EGG = registerItem("hard_boiled_egg",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SOFT_BOILED_EGG = registerItem("soft_boiled_egg",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item DRIED_BLACK_PEPPER = registerItem("dried_black_pepper",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));









    public static final Item TOMATOSOUP = registerItem("tomatosoup",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BEEFSTEW = registerItem("beefstew",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item MASHEDPOTATOES = registerItem("mashedpotatoes",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item ASPARAGUSBACONDISH = registerItem("asparagusbacondish",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item RICE_PORRIDGE = registerItem("rice_porridge",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SALAD = registerItem("salad",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));




    // END OF ModItems -------------------------------------------------------------------------------------------------
    private static Item registerBerryItem(String name, SweetBerryBushBlock alias, FabricItemSettings settings) {
        return Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, name),
                new AliasedBlockItem(alias, settings));
    }

    private static Item registerBlockItem(String name, BlockItem item) {
        return Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, name), item);
    }

    private static Item registerSeedItem(String name, CropBlock alias) {
        return Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, name),
                new AliasedBlockItem(alias, new FabricItemSettings()));
    }

    private static Item registerRemainderItem(String name, Item item) {
        Item remainderItem = registerItem(name, item);
        ((ItemAccessor) remainderItem).setRecipeRemainder(remainderItem);

        return remainderItem;
    }

    private static Item registerItem(String name, Item item){
        Photosynthesis.LOGGER.info("Registering item with name: " + name);
        return Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, name), item);
    }

    public static void addItemsToItemGroups() {
        //ItemGroups.INGREDIENTS
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BARK_PEELER_SPUD );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GARDEN_GRUBBER_FLINT );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GARDEN_GRUBBER_IRON );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GARDEN_GRUBBER_DIAMOND );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUTTING_KNIFE_FLINT);
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUTTING_KNIFE_IRON);
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUTTING_KNIFE_DIAMOND);

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUTTING_KNIFE_BLADE_FLINT);
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUTTING_KNIFE_BLADE_IRON);
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUTTING_KNIFE_BLADE_DIAMOND);

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUTTING_KNIFE_HANDLE );
        //addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUTTING_BOARD );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MORTAR_PESTLE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MORTAR );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PESTLE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PLATE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ROLLING_PIN );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ROLLING_PIN_HANDLE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ROLLING_PIN_PIN );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ROLLING_PIN_PART );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SQUEEZER );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SQUEEZER_PART );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, WHISK );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, WHISK_PART );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, WHISK_HANDLE );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MEASURING_CUP );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MEASURING_CUP_WATER );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MEASURING_CUP_MILK );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MEASURING_CUP_CANOLAOIL );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MEASURING_CUP_SUNFLOWEROIL );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BARK_ACACIA );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BARK_BIRCH );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BARK_JUNGLE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BARK_OAK );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BARK_DARK_OAK );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BARK_SPRUCE );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BLUEBERRIES );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BLACKBERRIES );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RASPBERRIES );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CLOUDBERRIES );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, WILD_STRAWBERRIES );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, TOMATO );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BASIL );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, OREGANO );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, STRAWBERRY );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, OAT );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, JALAPENO );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CHILI );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUCUMBER );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ONION );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, LEEK );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CELERY );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PEAS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SWEET_POTATO );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ASPARAGUS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SCALLION );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GARLIC );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CHIVE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BROCCOLI );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CAULIFLOWER );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CORN );
        //addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BLACK_PEPPER );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CABBAGE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RED_BELLPEPPER );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GREEN_BELLPEPPER );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, YELLOW_BELLPEPPER );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, TURNIP );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RUTABAGA );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CANOLA );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BARLEY );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, COTTON );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SUGARBEET );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RICE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SOYBEAN );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SPINACH );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ARROWROOT );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ARTICHOKE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BRUSSELS_SPROUTS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CASSAVA );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, EGGPLANT );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SUNFLOWER );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, JICAMA );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, KALE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, KOHLRABI );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, LETTUCE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, OKRA );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PARSNIP );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RADISH );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RHUBARB );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MILLET );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RYE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SQUASH );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ZUCCHINI );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, COFFEA );
        //addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GRAPE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PARSLEY );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MINT );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PINEAPPLE );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CAMELLIA_SINENSIS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, NICOTIANA_RUSTICA );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PAPAVER_SOMNIFERUM );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ERYTHROXYLUM_COCA );


        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CACTUS_FRUIT );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CANTALOUPE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, FLAX );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, JUTE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, KENAF );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SISAL );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, AMARANTH );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BEAN );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CHICKPEA );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, LENTIL );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, QUINOA );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PEANUT );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, TARO );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, TOMATILLO );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, AGAVE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GINGER );




        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CINNAMON_RAW );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GREENAPPLE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BANANA );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ORANGE );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, TOMATO_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BASIL_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, OREGANO_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, STRAWBERRY_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, OAT_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, JALAPENO_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CHILI_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUCUMBER_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ONION_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, LEEK_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CELERY_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PEAS_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SWEET_POTATO_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ASPARAGUS_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SCALLION_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GARLIC_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CHIVE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BROCCOLI_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CAULIFLOWER_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CORN_SEEDS );
        //addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BLACK_PEPPER_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CABBAGE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BELLPEPPER_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, TURNIP_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RUTABAGA_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CANOLA_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BARLEY_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, COTTON_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SUGARBEET_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RICE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SOYBEAN_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SPINACH_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ARROWROOT_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ARTICHOKE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BRUSSELS_SPROUTS_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CASSAVA_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, EGGPLANT_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SUNFLOWER_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, JICAMA_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, KALE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, KOHLRABI_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, LETTUCE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, OKRA_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PARSNIP_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RADISH_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RHUBARB_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MILLET_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RYE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SQUASH_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ZUCCHINI_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, COFFEA_SEEDS );
        //addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GRAPE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PARSLEY_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MINT_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PINEAPPLE_SEEDS );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CAMELLIA_SINENSIS_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, NICOTIANA_RUSTICA_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PAPAVER_SOMNIFERUM_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ERYTHROXYLUM_COCA_SEEDS );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CACTUS_FRUIT_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CANTALOUPE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, FLAX_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, JUTE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, KENAF_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SISAL_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, AMARANTH_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BEAN_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CHICKPEA_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, LENTIL_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, QUINOA_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, PEANUT_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, TARO_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, TOMATILLO_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, AGAVE_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, GINGER_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SESAME_SEEDS );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MUSTARD_SEEDS );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CANOLA_OIL_BOTTLE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SUNFLOWER_OIL_BOTTLE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CINNAMON_POWDER );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUT_CHIVES );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CUT_KIWI );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, CRACKED_EGG );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, FRIED_EGG );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SCRAMBLED_EGG );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, HARD_BOILED_EGG );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SOFT_BOILED_EGG );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, DRIED_BLACK_PEPPER );

        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, TOMATOSOUP );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, BEEFSTEW );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, MASHEDPOTATOES );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, ASPARAGUSBACONDISH );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, RICE_PORRIDGE );
        addToItemGroup(ModItemGroup.PHOTOSYNTHESIS, SALAD );
    }
    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        System.out.println("Registered Mod Items for " + Photosynthesis.MOD_ID);

        addItemsToItemGroups();
    }
}
