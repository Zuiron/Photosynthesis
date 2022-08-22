package net.zuiron.photosynthesis.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.item.ModItemGroup;
import net.zuiron.photosynthesis.item.ModItems;

public class ModBlocks {

    // FLOWERS ---------------------------------------------------------------------------------------------------------
    public static final Block FLORAMELISSIA = registerBlock("floramelissia",
            new FlowerBlock(StatusEffect.byRawId(1),1, FabricBlockSettings.copy(Blocks.POTTED_POPPY).nonOpaque()));

    public static final Block POTTED_FLORAMELISSIA = registerBlockWithoutBlockItem("potted_floramelissia",
            new FlowerPotBlock(ModBlocks.FLORAMELISSIA, FabricBlockSettings.copy(Blocks.POTTED_POPPY).nonOpaque()));


    // CROP BLOCKS -----------------------------------------------------------------------------------------------------
    public static final CropBlock TOMATO_CROP = registerCropBlockSimple("tomato_crop");
    public static final CropBlock BASIL_CROP = registerCropBlockSimple("basil_crop");
    public static final CropBlock OREGANO_CROP = registerCropBlockSimple("oregano_crop");
    public static final CropBlock STRAWBERRY_CROP = registerCropBlockSimple("strawberry_crop");
    public static final CropBlock OAT_CROP = registerCropBlockSimple("oat_crop");
    public static final CropBlock JALAPENO_CROP = registerCropBlockSimple("jalapeno_crop");
    public static final CropBlock CHILI_CROP = registerCropBlockSimple("chili_crop");
    public static final CropBlock CUCUMBER_CROP = registerCropBlockSimple("cucumber_crop");
    public static final CropBlock ONION_CROP = registerCropBlockSimple("onion_crop");
    public static final CropBlock LEEK_CROP = registerCropBlockSimple("leek_crop");
    public static final CropBlock CELERY_CROP = registerCropBlockSimple("celery_crop");
    public static final CropBlock PEAS_CROP = registerCropBlockSimple("peas_crop");
    public static final CropBlock SWEET_POTATO_CROP = registerCropBlockSimple("sweet_potato_crop");
    public static final CropBlock ASPARAGUS_CROP = registerCropBlockSimple("asparagus_crop");
    public static final CropBlock SCALLION_CROP = registerCropBlockSimple("scallion_crop");
    public static final CropBlock GARLIC_CROP = registerCropBlockSimple("garlic_crop");
    public static final CropBlock CHIVE_CROP = registerCropBlockSimple("chive_crop");
    public static final CropBlock BROCCOLI_CROP = registerCropBlockSimple("broccoli_crop");
    public static final CropBlock CAULIFLOWER_CROP = registerCropBlockSimple("cauliflower_crop");
    public static final CropBlock CORN_CROP = registerCropBlockSimple("corn_crop");
    public static final CropBlock BLACK_PEPPER_CROP = registerCropBlockSimple("black_pepper_crop");
    public static final CropBlock CABBAGE_CROP = registerCropBlockSimple("cabbage_crop");
    public static final CropBlock BELLPEPPER_CROP = registerCropBlockSimple("bellpepper_crop");
    public static final CropBlock TURNIP_CROP = registerCropBlockSimple("turnip_crop");
    public static final CropBlock RUTABAGA_CROP = registerCropBlockSimple("rutabaga_crop");
    public static final CropBlock CANOLA_CROP = registerCropBlockSimple("canola_crop");
    public static final CropBlock BARLEY_CROP = registerCropBlockSimple("barley_crop");
    public static final CropBlock COTTON_CROP = registerCropBlockSimple("cotton_crop");
    public static final CropBlock SUGARBEET_CROP = registerCropBlockSimple("sugarbeet_crop");
    public static final CropBlock RICE_CROP = registerCropBlockSimpleWL("rice_crop");
    public static final CropBlock SOYBEAN_CROP = registerCropBlockSimple("soybean_crop");
    public static final CropBlock SPINACH_CROP = registerCropBlockSimple("spinach_crop");
    public static final CropBlock ARROWROOT_CROP = registerCropBlockSimple("arrowroot_crop");
    public static final CropBlock ARTICHOKE_CROP = registerCropBlockSimple("artichoke_crop");
    public static final CropBlock BRUSSELS_SPROUTS_CROP = registerCropBlockSimple("brussels_sprouts_crop");
    public static final CropBlock CASSAVA_CROP = registerCropBlockSimple("cassava_crop");
    public static final CropBlock EGGPLANT_CROP = registerCropBlockSimple("eggplant_crop");
    public static final CropBlock SUNFLOWER_CROP = registerCropBlockSimple("sunflower_crop");
    public static final CropBlock JICAMA_CROP = registerCropBlockSimple("jicama_crop");
    public static final CropBlock KALE_CROP = registerCropBlockSimple("kale_crop");
    public static final CropBlock KOHLRABI_CROP = registerCropBlockSimple("kohlrabi_crop");
    public static final CropBlock LETTUCE_CROP = registerCropBlockSimple("lettuce_crop");
    public static final CropBlock OKRA_CROP = registerCropBlockSimple("okra_crop");
    public static final CropBlock PARSNIP_CROP = registerCropBlockSimple("parsnip_crop");
    public static final CropBlock RADISH_CROP = registerCropBlockSimple("radish_crop");
    public static final CropBlock RHUBARB_CROP = registerCropBlockSimple("rhubarb_crop");


    public static final CropBlock MILLET_CROP = registerCropBlockSimple("millet_crop");
    public static final CropBlock RYE_CROP = registerCropBlockSimple("rye_crop");
    public static final CropBlock SQUASH_CROP = registerCropBlockSimple("squash_crop");
    public static final CropBlock ZUCCHINI_CROP = registerCropBlockSimple("zucchini_crop");
    public static final CropBlock COFFEA_CROP = registerCropBlockSimple("coffea_crop");
    public static final CropBlock GRAPE_CROP = registerCropBlockSimple("grape_crop");
    public static final CropBlock CAMELLIA_SINENSIS_CROP = registerCropBlockSimple("camellia_sinensis_crop");
    public static final CropBlock NICOTIANA_RUSTICA_CROP = registerCropBlockSimple("nicotiana_rustica_crop");
    public static final CropBlock PAPAVER_SOMNIFERUM_CROP = registerCropBlockSimple("papaver_somniferum_crop");
    public static final CropBlock ERYTHROXYLUM_COCA_CROP = registerCropBlockSimple("erythroxylum_coca_crop");

    public static final CropBlock SATIVA_COLUMBIAN_CROP = registerCropBlockSimple("sativa_columbian_crop");
    public static final CropBlock SATIVA_SOUR_DIESEL_CROP = registerCropBlockSimple("sativa_sour_diesel_crop");
    public static final CropBlock SATIVA_NEPALESE_CROP = registerCropBlockSimple("sativa_nepalese_crop");
    public static final CropBlock SATIVA_THAI_CROP = registerCropBlockSimple("sativa_thai_crop");
    public static final CropBlock SATIVA_SUPER_SILVER_HAZE_CROP = registerCropBlockSimple("sativa_super_silver_haze_crop");
    public static final CropBlock SATIVA_OAXACAN_CROP = registerCropBlockSimple("sativa_oaxacan_crop");

    public static final CropBlock INDICA_ACAPULCO_GOLD_CROP = registerCropBlockSimple("indica_acapulco_gold_crop");
    public static final CropBlock INDICA_PURPLE_KUSH_CROP = registerCropBlockSimple("indica_purple_kush_crop");
    public static final CropBlock INDICA_AFGHAN_KUSH_CROP = registerCropBlockSimple("indica_afghan_kush_crop");
    public static final CropBlock INDICA_BUBBA_KUSH_CROP = registerCropBlockSimple("indica_bubba_kush_crop");
    public static final CropBlock INDICA_LA_CONFIDENTIAL_CROP = registerCropBlockSimple("indica_la_confidential_crop");
    public static final CropBlock INDICA_NORTHERN_LIGHTS_CROP = registerCropBlockSimple("indica_northern_lights_crop");

    public static final CropBlock HYBRID_DURBAN_CROP = registerCropBlockSimple("hybrid_durban_crop");
    public static final CropBlock HYBRID_HINDU_KUSH_CROP = registerCropBlockSimple("hybrid_hindu_kush_crop");
    public static final CropBlock HYBRID_BLUE_DREAM_CROP = registerCropBlockSimple("hybrid_blue_dream_crop");
    public static final CropBlock HYBRID_MAUI_CROP = registerCropBlockSimple("hybrid_maui_crop");
    public static final CropBlock HYBRID_GOLDEN_GOAT_CROP = registerCropBlockSimple("hybrid_golden_goat_crop");
    public static final CropBlock HYBRID_WHITE_WIDOW_CROP = registerCropBlockSimple("hybrid_white_widow_crop");
    public static final CropBlock HYBRID_PINEAPPLE_EXPRESS_CROP = registerCropBlockSimple("hybrid_pineapple_express_crop");

    public static final CropBlock RUDERALIS_SKUNK_CROP = registerCropBlockSimple("ruderalis_skunk_crop");
    public static final CropBlock RUDERALIS_DO_SI_DOS_CROP = registerCropBlockSimple("ruderalis_do_si_dos_crop");
    public static final CropBlock RUDERALIS_MEMBRANA_HIPER_AUTOFLOWERING_CROP = registerCropBlockSimple("ruderalis_membrana_hiper_autoflowering_crop");
    public static final CropBlock RUDERALIS_AUTO_MAZAR_CROP = registerCropBlockSimple("ruderalis_auto_mazar_crop");





    /*public static final CropBlock RHUBARB_CROP = registerCropBlock("rhubarb_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.RHUBARB_SEEDS));*/


    // BERRY BUSHES ----------------------------------------------------------------------------------------------------
    public static final SweetBerryBushBlock BLUEBERRY_BUSH = registerBushBlock("blueberry_bush",
            new BlueberryBush(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    public static final SweetBerryBushBlock BLACKBERRY_BUSH = registerBushBlock("blackberry_bush",
            new BlackberryBush(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    public static final SweetBerryBushBlock RASPBERRY_BUSH = registerBushBlock("raspberry_bush",
            new RaspberryBush(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    public static final SweetBerryBushBlock CLOUDBERRY_BUSH = registerBushBlock("cloudberry_bush",
            new CloudberryBush(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final SweetBerryBushBlock WILD_STRAWBERRY_BUSH = registerBushBlock("wild_strawberry_bush",
            new Wild_StrawberryBush(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));



    // END OF BLOCKS ---------------------------------------------------------------------------------------------------

    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(Photosynthesis.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));
    }

    private static CropBlock registerCropBlock(String name, CropBlock block){
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    private static CropBlock registerCropBlockSimple(String name){
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name),
                new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                name));
    }

    private static CropBlock registerCropBlockSimpleWL(String name){
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name),
                new CustomCropBlockWL(AbstractBlock.Settings.of(Material.PLANT)
                        .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                        name));
    }

    private static SweetBerryBushBlock registerBushBlock(String name, SweetBerryBushBlock block){
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + Photosynthesis.MOD_ID);
    }
}
