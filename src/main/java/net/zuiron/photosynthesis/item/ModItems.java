package net.zuiron.photosynthesis.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.CropBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.effect.ModEffects;
import net.zuiron.photosynthesis.item.advanced.WrenchItem;
import net.zuiron.photosynthesis.mixin.ItemAccessor;




public class ModItems {
    public static final Item WRENCH = registerItem("wrench",
            new WrenchItem(new FabricItemSettings()));

    public static final Item SLOT_LOCK_LOCKED = registerItem("slot_lock_locked",
            new Item(new FabricItemSettings()));
    public static final Item SLOT_LOCK_UNLOCKED = registerItem("slot_lock_unlocked",
            new Item(new FabricItemSettings()));

    // ORES
    public static final Item RAW_SALT = registerItem("raw_salt",
            new Item(new FabricItemSettings()));
    public static final Item SALT = registerItem("salt",
            new Item(new FabricItemSettings()));

    // SURVIVAL --------------------------------------------------------------------------------------------------------
    public static final Item FORESTY_BUNDLE = registerItem("foresty_bundle",
            new Item(new FabricItemSettings()));

    public static final Item PLASTIC_WRAP = registerItem("plastic_wrap",
            new TooltippedItem(new FabricItemSettings(), "Use on Grass Bale's to wrap them. Turns into Silage (over time)."));

    public static final Item TMR = registerItem("tmr",
            new Item(new FabricItemSettings()));

    public static final Item MANURE = registerItem("manure",
            new TooltippedItem(new FabricItemSettings(),"Organic Fertilizer"));

    public static final Item RAW_SULFUR = registerItem("raw_sulfur",
            new Item(new FabricItemSettings()));
    public static final Item SULFUR_DUST = registerItem("sulfur_dust",
            new TooltippedItem(new FabricItemSettings(), "Organic Pesticide"));

    public static final Item GRASS_BUNDLE = registerItem("grass_bundle",
            new Item(new FabricItemSettings()));
    public static final Item HAY_BUNDLE = registerItem("hay_bundle",
            new Item(new FabricItemSettings()));
    public static final Item STRAW_BUNDLE = registerItem("straw_bundle",
            new Item(new FabricItemSettings()));

    public static final Item GRASS_FIBRE_PIECE = registerItem("grass_fibre_piece",
            new Item(new FabricItemSettings()));

    public static final Item STRAW_PIECE = registerItem("straw_piece",
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

   /*public static final Item MORTAR_PESTLE = registerRemainderItem("mortar_pestle",
            new Item(new FabricItemSettings()));

    public static final Item MORTAR = registerItem("mortar",
            new Item(new FabricItemSettings()));*/
   public static final Item FIRESTARTER = registerItem("firestarter",
           new DamageableItem(new FabricItemSettings().maxCount(1).maxDamage(4)));

    public static final Item DEBUG_ITEM = registerItem("debug_item",
            new DebugItem(new FabricItemSettings().maxCount(1)));

    public static final Item PESTLE = registerItem("pestle",
            new DamageableItem(new FabricItemSettings().maxCount(1).maxDamage(45)));

    /*public static final Item PLATE = registerItem("plate",
            new Item(new FabricItemSettings()));*/

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
            new Item(new FabricItemSettings().recipeRemainder(ModItems.WHISK)));

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

    public static final Item MEASURING_CUP_SKIMMED_MILK = registerItem("measuring_cup_skimmed_milk",
            new Item(new FabricItemSettings().recipeRemainder(ModItems.MEASURING_CUP)));

    public static final Item MEASURING_CUP_MILK_CREAM = registerItem("measuring_cup_milk_cream",
            new Item(new FabricItemSettings().recipeRemainder(ModItems.MEASURING_CUP)));

    public static final Item MEASURING_CUP_CANOLAOIL = registerItem("measuring_cup_canolaoil",
            new Item(new FabricItemSettings().recipeRemainder(ModItems.MEASURING_CUP)));

    public static final Item MEASURING_CUP_SUNFLOWEROIL = registerItem("measuring_cup_sunfloweroil",
            new Item(new FabricItemSettings().recipeRemainder(ModItems.MEASURING_CUP)));

    public static final Item MEASURING_CUP_OLIVEOIL = registerItem("measuring_cup_oliveoil",
            new Item(new FabricItemSettings().recipeRemainder(ModItems.MEASURING_CUP)));

    public static final Item MEASURING_CUP_MEAD = registerItem("measuring_cup_mead",
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
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.2f).build()));

    public static final Item BLACKBERRIES = registerBerryItem("blackberries", ModBlocks.BLACKBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.2f).build()));

    public static final Item RASPBERRIES = registerBerryItem("raspberries", ModBlocks.RASPBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.2f).build()));

    public static final Item CLOUDBERRIES = registerBerryItem("cloudberries", ModBlocks.CLOUDBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.2f).build()));

    public static final Item WILD_STRAWBERRIES = registerBerryItem("wild_strawberries", ModBlocks.WILD_STRAWBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.2f).build()));

    public static final Item LINGONBERRIES = registerBerryItem("lingonberries", ModBlocks.LINGONBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.2f).build()));

    public static final Item CRANBERRIES = registerBerryItem("cranberries", ModBlocks.CRANBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.2f).build()));

    public static final Item HUCKLEBERRIES = registerBerryItem("huckleberries", ModBlocks.HUCKLEBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.2f).build()));

    public static final Item JUNIPERBERRIES = registerBerryItem("juniperberries", ModBlocks.JUNIPERBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.2f).build()));

    public static final Item MULBERRIES = registerBerryItem("mulberries", ModBlocks.MULBERRY_BUSH,
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.2f).build()));






    // CROP PRODUCE ----------------------------------------------------------------------------------------------------
    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));

    public static final Item BASIL = registerItem("basil",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item OREGANO = registerItem("oregano",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item STRAWBERRY = registerItem("strawberry",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).alwaysEdible().snack().saturationModifier(0.1f).build())));

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

 public static final Item RICE_PANICLE = registerItem("rice_panicle",
         new Item(new FabricItemSettings()));

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
    public static final Item SESAME = registerItem("sesame",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item MUSTARD = registerItem("mustard",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item WHITE_BUTTON_MUSHROOM = registerItem("white_button_mushroom",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PORCINI_MUSHROOM = registerItem("porcini_mushroom",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHANTERELLE_MUSHROOM = registerItem("chanterelle_mushroom",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item MOREL_MUSHROOM = registerItem("morel_mushroom",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

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
    public static final Item RED_GRAPE = registerBerryItem("red_grape", ModBlocks.RED_GRAPETREE_BUSHCROP,
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
    public static final Item GRASS_SEEDS = registerSeedItem("grass_seeds", ModBlocks.GRASS_CROP);
    public static final Item WHITE_BUTTON_MUSHROOM_SPORES = registerSeedItem("white_button_mushroom_spores", ModBlocks.WHITE_BUTTON_MUSHROOM_CROP);
    public static final Item PORCINI_MUSHROOM_SPORES = registerSeedItem("porcini_mushroom_spores", ModBlocks.PORCINI_MUSHROOM_CROP);
    public static final Item CHANTERELLE_MUSHROOM_SPORES = registerSeedItem("chanterelle_mushroom_spores", ModBlocks.CHANTERELLE_MUSHROOM_CROP);
    public static final Item MOREL_MUSHROOM_SPORES = registerSeedItem("morel_mushroom_spores", ModBlocks.MOREL_MUSHROOM_CROP);
    public static final Item DANDELION_SEEDS = registerSeedItem("dandelion_seeds", ModBlocks.DANDELION_CROP);
    public static final Item POPPY_SEEDS = registerSeedItem("poppy_seeds", ModBlocks.POPPY_CROP);
    public static final Item BLUE_ORCHID_SEEDS = registerSeedItem("blue_orchid_seeds", ModBlocks.BLUE_ORCHID_CROP);
    public static final Item ALLIUM_SEEDS = registerSeedItem("allium_seeds", ModBlocks.ALLIUM_CROP);
    public static final Item AZURE_BLUET_SEEDS = registerSeedItem("azure_bluet_seeds", ModBlocks.AZURE_BLUET_CROP);
    public static final Item RED_TULIP_SEEDS = registerSeedItem("red_tulip_seeds", ModBlocks.RED_TULIP_CROP);
    public static final Item ORANGE_TULIP_SEEDS = registerSeedItem("orange_tulip_seeds", ModBlocks.ORANGE_TULIP_CROP);
    public static final Item WHITE_TULIP_SEEDS = registerSeedItem("white_tulip_seeds", ModBlocks.WHITE_TULIP_CROP);
    public static final Item PINK_TULIP_SEEDS = registerSeedItem("pink_tulip_seeds", ModBlocks.PINK_TULIP_CROP);
    public static final Item OXEYE_DAISY_SEEDS = registerSeedItem("oxeye_daisy_seeds", ModBlocks.OXEYE_DAISY_CROP);
    public static final Item CORNFLOWER_SEEDS = registerSeedItem("cornflower_seeds", ModBlocks.CORNFLOWER_CROP);
    public static final Item LILY_OF_THE_VALLEY_SEEDS = registerSeedItem("lily_of_the_valley_seeds", ModBlocks.LILY_OF_THE_VALLEY_CROP);
    public static final Item FLORAMELISSIA_SEEDS = registerSeedItem("floramelissia_seeds", ModBlocks.FLORAMELISSIA_CROP);
    public static final Item WITHER_ROSE_SEEDS = registerSeedItem("wither_rose_seeds", ModBlocks.WITHER_ROSE_CROP);

    // Leathers
    public static final Item RAW_LEATHER = registerItem("raw_leather",
            new Item(new FabricItemSettings()));
    public static final Item PIG_SKIN = registerItem("pig_skin",
            new Item(new FabricItemSettings()));
    public static final Item WOLF_PELT = registerItem("wolf_pelt",
            new Item(new FabricItemSettings()));
    public static final Item HORSE_LEATHER = registerItem("horse_leather",
            new Item(new FabricItemSettings()));
    public static final Item SALTED_PIG_SKIN = registerItem("salted_pig_skin",
            new Item(new FabricItemSettings()));
    public static final Item SALTED_WOLF_PELT = registerItem("salted_wolf_pelt",
            new Item(new FabricItemSettings()));
    public static final Item SALTED_RAW_LEATHER = registerItem("salted_raw_leather",
            new Item(new FabricItemSettings()));
    public static final Item SALTED_HORSE_LEATHER = registerItem("salted_horse_leather",
            new Item(new FabricItemSettings()));
    public static final Item SALTED_RABBIT_HIDE = registerItem("salted_rabbit_hide",
            new Item(new FabricItemSettings()));

    // Meat's ----------------------------------------------------------------------------------------------------------
    public static final Item COW_BRISKET = registerItem("cow_brisket",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item COOKED_COW_BRISKET = registerItem("cooked_cow_brisket",
            new Item(new FabricItemSettings().food(FoodComponents.COOKED_BEEF)));

    public static final Item COW_RIBS = registerItem("cow_ribs",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item COOKED_COW_RIBS = registerItem("cooked_cow_ribs",
            new Item(new FabricItemSettings().food(FoodComponents.COOKED_BEEF)));

    public static final Item COOKED_COW_ROAST_BEEF = registerItem("cooked_cow_roast_beef",
            new Item(new FabricItemSettings().food(FoodComponents.COOKED_BEEF)));


    public static final Item COW_STEAK = registerItem("cow_steak",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item COOKED_COW_STEAK = registerItem("cooked_cow_steak",
            new Item(new FabricItemSettings().food(FoodComponents.COOKED_BEEF)));



    public static final Item COW_HEARTH = registerItem("cow_hearth",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item COW_KIDNEY = registerItem("cow_kidney",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item COW_LIVER = registerItem("cow_liver",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item COW_TONGUE = registerItem("cow_tongue",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item COW_TRIMMINGS = registerItem("cow_trimmings",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));



    public static final Item SHEEP_TRIMMINGS = registerItem("sheep_trimmings",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SHEEP_RIBS = registerItem("sheep_ribs",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SHEEP_LEGS = registerItem("sheep_legs",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));


    public static final Item CHICKEN_LIVER = registerItem("chicken_liver",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHICKEN_BONES = registerItem("chicken_bones",
            new Item(new FabricItemSettings()));

    public static final Item CHICKEN_FEET = registerItem("chicken_feet",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHICKEN_WINGS = registerItem("chicken_wings",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHICKEN_TRIMMINGS = registerItem("chicken_trimmings",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));



    public static final Item RAW_BACON = registerItem("raw_bacon",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PIG_BELLY = registerItem("pig_belly",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item RAW_HAM = registerItem("raw_ham",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PIG_BONES = registerItem("pig_bones",
            new Item(new FabricItemSettings()));

    public static final Item PIG_TRIMMINGS = registerItem("pig_trimmings",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));


    public static final Item HORSE_MEAT = registerItem("horse_meat",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item HORSE_BONES = registerItem("horse_bones",
            new Item(new FabricItemSettings()));

    public static final Item HORSE_HAIR = registerItem("horse_hair",
            new Item(new FabricItemSettings()));



    // Food's ----------------------------------------------------------------------------------------------------------

    /*public static final Item CANOLA_OIL_BOTTLE = registerItem("canola_oil_bottle",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SUNFLOWER_OIL_BOTTLE = registerItem("sunflower_oil_bottle",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));*/

    public static final Item FISH_ROE = registerItem("fish_roe",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SMOKED_FISH_ROE = registerItem("smoked_fish_roe",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item KAVIAR = registerItem("kaviar",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item WHEAT_BREAD_SLICE_WITH_SCRAMBLED_EGG_AND_KAVIAR = registerItem("wheat_bread_slice_with_scrambled_egg_and_kaviar",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(20).saturationModifier(2.0f).build())));

    public static final Item CINNAMON_POWDER = registerItem("cinnamon_powder",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item WHEAT_FLOUR = registerItem("wheat_flour",
            new Item(new FabricItemSettings()));

    public static final Item CUT_CHIVES = registerItem("cut_chives",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CUT_KIWI = registerItem("cut_kiwi",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

 public static final Item CUT_WHITE_BUTTON_MUSHROOM = registerItem("cut_white_button_mushroom",
         new Item(new FabricItemSettings()
                 .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CUT_PORCINI_MUSHROOM = registerItem("cut_porcini_mushroom",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CUT_CHANTERELLE_MUSHROOM = registerItem("cut_chanterelle_mushroom",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CUT_MOREL_MUSHROOM = registerItem("cut_morel_mushroom",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BREAD_SLICE = registerItem("bread_slice",
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
                    .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5f).build())));

    /*public static final Item HARD_BOILED_EGG = registerItem("hard_boiled_egg",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item SOFT_BOILED_EGG = registerItem("soft_boiled_egg",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));*/

    public static final Item BOILED_EGG = registerItem("boiled_egg",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item DRIED_BLACK_PEPPER = registerItem("dried_black_pepper",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item MARSHMALLOW = registerItem("marshmallow",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item POWDERED_SUGAR = registerItem("powdered_sugar",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item GELATIN_SHEET = registerItem("gelatin_sheet",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item VANILLA_POWDER = registerItem("vanilla_powder",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BUTTER = registerItem("butter",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item WHIPPED_CREAM = registerItem("whipped_cream",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHOCOLATE_COOKIE_DOUGH = registerItem("chocolate_cookie_dough",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item COOKIE_DOUGH = registerItem("cookie_dough",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item TOMATOSOUP = registerItem("tomatosoup",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build())));

    public static final Item BEEFSTEW = registerItem("beefstew",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(9).saturationModifier(0.9f).build())));

    public static final Item MASHEDPOTATOES = registerItem("mashedpotatoes",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item ASPARAGUSBACONDISH = registerItem("asparagusbacondish",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item RICE_PORRIDGE = registerItem("rice_porridge",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build())));

    public static final Item SALAD = registerItem("salad",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BBQ_SKEWERS = registerItem("barbeque_skewers",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item MINCED_BEEF = registerItem("minced_beef",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item YELLOW_CHEESE = registerItem("yellow_cheese",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item ENGLISH_BREAKFAST = registerItem("english_breakfast",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item MEATBALLS = registerItem("meatballs",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item MINCED_PORK = registerItem("minced_pork",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PUMPKIN_SOUP = registerItem("pumpkin_soup",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item WAFFLE = registerItem("waffle",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PIZZA = registerItem("pizza",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PANCAKES = registerItem("pancakes",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PIE = registerItem("pie",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHICKEN_THIGH = registerItem("chicken_thigh",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BAKED_SQUASH = registerItem("baked_squash",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BAGUETTE = registerItem("baguette",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item OMELETTE = registerItem("omelette",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item GARLIC_BREAD_SLICE = registerItem("garlic_bread_slice",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item DUMPLING = registerItem("dumpling",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item PANCAKE = registerItem("pancake",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item BACON = registerItem("bacon",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHOCOLATE_CUPCAKE = registerItem("chocolate_cupcake",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CHICKEN_NUGGETS = registerItem("chicken_nuggets",
         new Item(new FabricItemSettings()
                 .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));


    public static final Item GRILLED_SALMON = registerItem("grilled_salmon",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item GRILLED_COD = registerItem("grilled_cod",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item CALIFLOWER_SOUP = registerItem("califlower_soup",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item HAM = registerItem("ham",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item EGG_SANDWICH = registerItem("egg_sandwich",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item TACO = registerItem("taco",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item SUSHI_ROLL2 = registerItem("sushi_roll2",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item SUSHI_ROLL = registerItem("sushi_roll",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item SALMON_SUSHI = registerItem("salmon_sushi",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item PIZZA_SAUCE = registerItem("pizza_sauce",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item OAT_BREAD = registerItem("oat_bread",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item RYE_BREAD = registerItem("rye_bread",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item TACO_SHELL = registerItem("taco_shell",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item RAW_CHICKEN_NUGGETS = registerItem("raw_chicken_nuggets",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));

    public static final Item CORN_FLOUR = registerItem("corn_flour",
            new Item(new FabricItemSettings()));

    public static final Item FISH_SOUP = registerItem("fish_soup",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item GARLIC_BREAD = registerItem("garlic_bread",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item CHEESE_BREAD_SLICE = registerItem("cheese_bread_slice",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item HAM_BAGUETTE = registerItem("ham_baguette",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item SEMOLINA_FLOUR = registerItem("semolina_flour",
            new Item(new FabricItemSettings()));

    public static final Item OAT_FLOUR = registerItem("oat_flour",
            new Item(new FabricItemSettings()));

    public static final Item RYE_FLOUR = registerItem("rye_flour",
            new Item(new FabricItemSettings()));

    public static final Item BARLEY_FLOUR = registerItem("barley_flour",
            new Item(new FabricItemSettings()));















    public static final Item BREAD_FORM = registerItem("bread_form",
                new Item(new FabricItemSettings()));

    public static final Item OVEN_TRAY = registerItem("oven_tray",
            new Item(new FabricItemSettings()));

    public static final Item PIZZA_STONE = registerItem("pizza_stone",
            new Item(new FabricItemSettings()));

    public static final Item WHEAT_DOUGH = registerItem("wheat_dough",
            new Item(new FabricItemSettings()));

    public static final Item OAT_DOUGH = registerItem("oat_dough",
            new Item(new FabricItemSettings()));

    public static final Item RYE_DOUGH = registerItem("rye_dough",
            new Item(new FabricItemSettings()));

    public static final Item BARLEY_DOUGH = registerItem("barley_dough",
            new Item(new FabricItemSettings()));

    public static final Item CORN_DOUGH = registerItem("corn_dough",
            new Item(new FabricItemSettings()));

    public static final Item SEMOLINA_DOUGH = registerItem("semolina_dough",
            new Item(new FabricItemSettings()));

    public static final Item EMPTY_MUG = registerItem("mug",
            new Item(new FabricItemSettings()));

    public static final Item MUG_MEAD = registerItem("mug_mead", //max 10 thirst - 600 tSat - damage is drink usage.
            new ThirstItem(new FabricItemSettings()
                    .maxCount(1)
                    .maxDamage(6)
                    .recipeRemainder(ModItems.EMPTY_MUG)
                    .food(new FoodComponent.Builder()
                            .hunger(4)
                            .saturationModifier(1.0f)
                            .alwaysEdible()
                            .statusEffect(new StatusEffectInstance(ModEffects.MEAD, 100, 0),1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500,0),1.0f)
                            .build())
                    ,3, 240));

    /*public static final Item MUG_WATER = registerItem("mug_water", //max 10 thirst - 600 tSat - damage is drink usage.
            new ThirstItem(new FabricItemSettings().maxCount(1).maxDamage(6).recipeRemainder(ModItems.EMPTY_MUG),3, 120));*/

    public static final Item LEATHER_WATER_BLADDER = registerItem("leather_water_bladder",
            new FillableLeatherWaterBladder(new FabricItemSettings().maxCount(1).maxDamage(1)));

    public static final Item LEATHER_WATER_BLADDER_DIRTY = registerItem("leather_water_bladder_dirty", //max 10 thirst - 600 tSat - damage is drink usage.
            new ThirstItem(new FabricItemSettings().food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 1), 1.0f).alwaysEdible().build())
                    .maxCount(1).maxDamage(1).recipeRemainder(ModItems.LEATHER_WATER_BLADDER),1, 0));

    public static final Item LEATHER_WATER_BLADDER_CLEAN = registerItem("leather_water_bladder_clean", //max 10 thirst - 600 tSat - damage is drink usage.
            new ThirstItem(new FabricItemSettings().maxCount(1).maxDamage(6).recipeRemainder(ModItems.LEATHER_WATER_BLADDER),2, 120));

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

    public static void registerModItems() {
        System.out.println("Registered Mod Items for " + Photosynthesis.MOD_ID);
    }
}
