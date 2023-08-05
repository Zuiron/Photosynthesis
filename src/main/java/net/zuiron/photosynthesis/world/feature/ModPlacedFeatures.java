package net.zuiron.photosynthesis.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    //crops
    public static final RegistryKey<PlacedFeature> TOMATO_CROP_PLACED_KEY = registerKey("tomato_crop_placed");
    public static final RegistryKey<PlacedFeature> BASIL_CROP_PLACED_KEY = registerKey("basil_crop_placed");
    public static final RegistryKey<PlacedFeature> OREGANO_CROP_PLACED_KEY = registerKey("oregano_crop_placed");
    public static final RegistryKey<PlacedFeature> STRAWBERRY_CROP_PLACED_KEY = registerKey("strawberry_crop_placed");
    public static final RegistryKey<PlacedFeature> OAT_CROP_PLACED_KEY = registerKey("oat_crop_placed");
    public static final RegistryKey<PlacedFeature> JALAPENO_CROP_PLACED_KEY = registerKey("jalapeno_crop_placed");
    public static final RegistryKey<PlacedFeature> CHILI_CROP_PLACED_KEY = registerKey("chili_crop_placed");
    public static final RegistryKey<PlacedFeature> CUCUMBER_CROP_PLACED_KEY = registerKey("cucumber_crop_placed");
    public static final RegistryKey<PlacedFeature> ONION_CROP_PLACED_KEY = registerKey("onion_crop_placed");
    public static final RegistryKey<PlacedFeature> LEEK_CROP_PLACED_KEY = registerKey("leek_crop_placed");
    public static final RegistryKey<PlacedFeature> CELERY_CROP_PLACED_KEY = registerKey("celery_crop_placed");
    public static final RegistryKey<PlacedFeature> PEAS_CROP_PLACED_KEY = registerKey("peas_crop_placed");
    public static final RegistryKey<PlacedFeature> SWEET_POTATO_CROP_PLACED_KEY = registerKey("sweet_potato_crop_placed");
    public static final RegistryKey<PlacedFeature> ASPARAGUS_CROP_PLACED_KEY = registerKey("asparagus_crop_placed");
    public static final RegistryKey<PlacedFeature> SCALLION_CROP_PLACED_KEY = registerKey("scallion_crop_placed");
    public static final RegistryKey<PlacedFeature> GARLIC_CROP_PLACED_KEY = registerKey("garlic_crop_placed");
    public static final RegistryKey<PlacedFeature> CHIVE_CROP_PLACED_KEY = registerKey("chive_crop_placed");
    public static final RegistryKey<PlacedFeature> BROCCOLI_CROP_PLACED_KEY = registerKey("broccoli_crop_placed");
    public static final RegistryKey<PlacedFeature> CAULIFLOWER_CROP_PLACED_KEY = registerKey("cauliflower_crop_placed");
    public static final RegistryKey<PlacedFeature> CORN_CROP_PLACED_KEY = registerKey("corn_crop_placed");
    public static final RegistryKey<PlacedFeature> CABBAGE_CROP_PLACED_KEY = registerKey("cabbage_crop_placed");
    public static final RegistryKey<PlacedFeature> BELLPEPPER_CROP_PLACED_KEY = registerKey("bellpepper_crop_placed");
    public static final RegistryKey<PlacedFeature> TURNIP_CROP_PLACED_KEY = registerKey("turnip_crop_placed");
    public static final RegistryKey<PlacedFeature> RUTABAGA_CROP_PLACED_KEY = registerKey("rutabaga_crop_placed");
    public static final RegistryKey<PlacedFeature> CANOLA_CROP_PLACED_KEY = registerKey("canola_crop_placed");
    public static final RegistryKey<PlacedFeature> BARLEY_CROP_PLACED_KEY = registerKey("barley_crop_placed");
    public static final RegistryKey<PlacedFeature> COTTON_CROP_PLACED_KEY = registerKey("cotton_crop_placed");
    public static final RegistryKey<PlacedFeature> SUGARBEET_CROP_PLACED_KEY = registerKey("sugarbeet_crop_placed");
    public static final RegistryKey<PlacedFeature> RICE_CROP_PLACED_KEY = registerKey("rice_crop_placed");
    public static final RegistryKey<PlacedFeature> WHITE_BUTTON_MUSHROOM_CROP_PLACED_KEY = registerKey("white_button_mushroom_crop_placed");
    public static final RegistryKey<PlacedFeature> PORCINI_MUSHROOM_CROP_PLACED_KEY = registerKey("porcini_mushroom_crop_placed");
    public static final RegistryKey<PlacedFeature> CHANTERELLE_MUSHROOM_CROP_PLACED_KEY = registerKey("chanterelle_mushroom_crop_placed");
    public static final RegistryKey<PlacedFeature> MOREL_MUSHROOM_CROP_PLACED_KEY = registerKey("morel_mushroom_crop_placed");
    public static final RegistryKey<PlacedFeature> SOYBEAN_CROP_PLACED_KEY = registerKey("soybean_crop_placed");
    public static final RegistryKey<PlacedFeature> SPINACH_CROP_PLACED_KEY = registerKey("spinach_crop_placed");
    public static final RegistryKey<PlacedFeature> ARROWROOT_CROP_PLACED_KEY = registerKey("arrowroot_crop_placed");
    public static final RegistryKey<PlacedFeature> ARTICHOKE_CROP_PLACED_KEY = registerKey("artichoke_crop_placed");
    public static final RegistryKey<PlacedFeature> BRUSSELS_SPROUTS_CROP_PLACED_KEY = registerKey("brussels_sprouts_crop_placed");
    public static final RegistryKey<PlacedFeature> CASSAVA_CROP_PLACED_KEY = registerKey("cassava_crop_placed");
    public static final RegistryKey<PlacedFeature> EGGPLANT_CROP_PLACED_KEY = registerKey("eggplant_crop_placed");
    public static final RegistryKey<PlacedFeature> SUNFLOWER_CROP_PLACED_KEY = registerKey("sunflower_crop_placed");
    public static final RegistryKey<PlacedFeature> JICAMA_CROP_PLACED_KEY = registerKey("jicama_crop_placed");
    public static final RegistryKey<PlacedFeature> KALE_CROP_PLACED_KEY = registerKey("kale_crop_placed");
    public static final RegistryKey<PlacedFeature> KOHLRABI_CROP_PLACED_KEY = registerKey("kohlrabi_crop_placed");
    public static final RegistryKey<PlacedFeature> LETTUCE_CROP_PLACED_KEY = registerKey("lettuce_crop_placed");
    public static final RegistryKey<PlacedFeature> OKRA_CROP_PLACED_KEY = registerKey("okra_crop_placed");
    public static final RegistryKey<PlacedFeature> PARSNIP_CROP_PLACED_KEY = registerKey("parsnip_crop_placed");
    public static final RegistryKey<PlacedFeature> RADISH_CROP_PLACED_KEY = registerKey("radish_crop_placed");
    public static final RegistryKey<PlacedFeature> RHUBARB_CROP_PLACED_KEY = registerKey("rhubarb_crop_placed");
    public static final RegistryKey<PlacedFeature> MILLET_CROP_PLACED_KEY = registerKey("millet_crop_placed");
    public static final RegistryKey<PlacedFeature> RYE_CROP_PLACED_KEY = registerKey("rye_crop_placed");
    public static final RegistryKey<PlacedFeature> SQUASH_CROP_PLACED_KEY = registerKey("squash_crop_placed");
    public static final RegistryKey<PlacedFeature> ZUCCHINI_CROP_PLACED_KEY = registerKey("zucchini_crop_placed");
    public static final RegistryKey<PlacedFeature> COFFEA_CROP_PLACED_KEY = registerKey("coffea_crop_placed");
    public static final RegistryKey<PlacedFeature> PARSLEY_CROP_PLACED_KEY = registerKey("parsley_crop_placed");
    public static final RegistryKey<PlacedFeature> MINT_CROP_PLACED_KEY = registerKey("mint_crop_placed");
    public static final RegistryKey<PlacedFeature> PINEAPPLE_CROP_PLACED_KEY = registerKey("pineapple_crop_placed");
    public static final RegistryKey<PlacedFeature> HOP_CROP_PLACED_KEY = registerKey("hop_crop_placed");
    public static final RegistryKey<PlacedFeature> FILIPENDULA_CROP_PLACED_KEY = registerKey("filipendula_crop_placed");
    public static final RegistryKey<PlacedFeature> CACTUS_FRUIT_CROP_PLACED_KEY = registerKey("cactus_fruit_crop_placed");
    public static final RegistryKey<PlacedFeature> CANTALOUPE_CROP_PLACED_KEY = registerKey("cantaloupe_crop_placed");
    public static final RegistryKey<PlacedFeature> FLAX_CROP_PLACED_KEY = registerKey("flax_crop_placed");
    public static final RegistryKey<PlacedFeature> JUTE_CROP_PLACED_KEY = registerKey("jute_crop_placed");
    public static final RegistryKey<PlacedFeature> KENAF_CROP_PLACED_KEY = registerKey("kenaf_crop_placed");
    public static final RegistryKey<PlacedFeature> SISAL_CROP_PLACED_KEY = registerKey("sisal_crop_placed");
    public static final RegistryKey<PlacedFeature> AMARANTH_CROP_PLACED_KEY = registerKey("amaranth_crop_placed");
    public static final RegistryKey<PlacedFeature> BEAN_CROP_PLACED_KEY = registerKey("bean_crop_placed");
    public static final RegistryKey<PlacedFeature> CHICKPEA_CROP_PLACED_KEY = registerKey("chickpea_crop_placed");
    public static final RegistryKey<PlacedFeature> LENTIL_CROP_PLACED_KEY = registerKey("lentil_crop_placed");
    public static final RegistryKey<PlacedFeature> QUINOA_CROP_PLACED_KEY = registerKey("quinoa_crop_placed");
    public static final RegistryKey<PlacedFeature> PEANUT_CROP_PLACED_KEY = registerKey("peanut_crop_placed");
    public static final RegistryKey<PlacedFeature> TARO_CROP_PLACED_KEY = registerKey("taro_crop_placed");
    public static final RegistryKey<PlacedFeature> TOMATILLO_CROP_PLACED_KEY = registerKey("tomatillo_crop_placed");
    public static final RegistryKey<PlacedFeature> AGAVE_CROP_PLACED_KEY = registerKey("agave_crop_placed");
    public static final RegistryKey<PlacedFeature> GINGER_CROP_PLACED_KEY = registerKey("ginger_crop_placed");
    public static final RegistryKey<PlacedFeature> SESAME_CROP_PLACED_KEY = registerKey("sesame_crop_placed");
    public static final RegistryKey<PlacedFeature> MUSTARD_CROP_PLACED_KEY = registerKey("mustard_crop_placed");
    public static final RegistryKey<PlacedFeature> CAMELLIA_SINENSIS_CROP_PLACED_KEY = registerKey("camellia_sinensis_crop_placed");
    public static final RegistryKey<PlacedFeature> NICOTIANA_RUSTICA_CROP_PLACED_KEY = registerKey("nicotiana_rustica_crop_placed");
    public static final RegistryKey<PlacedFeature> PAPAVER_SOMNIFERUM_CROP_PLACED_KEY = registerKey("papaver_somniferum_crop_placed");
    public static final RegistryKey<PlacedFeature> ERYTHROXYLUM_COCA_CROP_PLACED_KEY = registerKey("erythroxylum_coca_crop_placed");


    public static final RegistryKey<PlacedFeature> SALT_ORE_PLACED_KEY = registerKey("salt_ore_placed");


    public static final RegistryKey<PlacedFeature> APPLETREE_CHECKED_KEY = registerKey("appletree_checked");
    public static final RegistryKey<PlacedFeature> APPLETREE_PLACED_KEY = registerKey("appletree_placed");
    public static final RegistryKey<PlacedFeature> BANANATREE_CHECKED_KEY = registerKey("bananatree_checked");
    public static final RegistryKey<PlacedFeature> BANANATREE_PLACED_KEY = registerKey("bananatree_placed");
    public static final RegistryKey<PlacedFeature> CINNAMONTREE_CHECKED_KEY = registerKey("cinnamon_checked");
    public static final RegistryKey<PlacedFeature> CINNAMONTREE_PLACED_KEY = registerKey("cinnamon_placed");
    public static final RegistryKey<PlacedFeature> ORANGETREE_CHECKED_KEY = registerKey("orangetree_checked");
    public static final RegistryKey<PlacedFeature> ORANGETREE_PLACED_KEY = registerKey("orangetree_placed");

    public static final RegistryKey<PlacedFeature> PEARTREE_CHECKED_KEY = registerKey("peartree_checked");
    public static final RegistryKey<PlacedFeature> PEARTREE_PLACED_KEY = registerKey("peartree_placed");

    public static final RegistryKey<PlacedFeature> COCONUTTREE_CHECKED_KEY = registerKey("coconuttree_checked");
    public static final RegistryKey<PlacedFeature> COCONUTTREE_PLACED_KEY = registerKey("coconuttree_placed");

    public static final RegistryKey<PlacedFeature> AVOCADOTREE_CHECKED_KEY = registerKey("avocadotree_checked");
    public static final RegistryKey<PlacedFeature> AVOCADOTREE_PLACED_KEY = registerKey("avocadotree_placed");

    public static final RegistryKey<PlacedFeature> CHERRYTREE_CHECKED_KEY = registerKey("cherrytree_checked");
    public static final RegistryKey<PlacedFeature> CHERRYTREE_PLACED_KEY = registerKey("cherrytree_placed");

    public static final RegistryKey<PlacedFeature> LEMONTREE_CHECKED_KEY = registerKey("lemontree_checked");
    public static final RegistryKey<PlacedFeature> LEMONTREE_PLACED_KEY = registerKey("lemontree_placed");

    public static final RegistryKey<PlacedFeature> MANGOTREE_CHECKED_KEY = registerKey("mangotree_checked");
    public static final RegistryKey<PlacedFeature> MANGOTREE_PLACED_KEY = registerKey("mangotree_placed");

    public static final RegistryKey<PlacedFeature> OLIVETREE_CHECKED_KEY = registerKey("olivetree_checked");
    public static final RegistryKey<PlacedFeature> OLIVETREE_PLACED_KEY = registerKey("olivetree_placed");

    public static final RegistryKey<PlacedFeature> RUBBERTREE_CHECKED_KEY = registerKey("rubbertree_checked");
    public static final RegistryKey<PlacedFeature> RUBBERTREE_PLACED_KEY = registerKey("rubbertree_placed");















    public static final RegistryKey<PlacedFeature> CANDLENUTTREE_CHECKED_KEY = registerKey("candlenuttree_checked");
    public static final RegistryKey<PlacedFeature> CANDLENUTTREE_PLACED_KEY = registerKey("candlenuttree_placed");

    public static final RegistryKey<PlacedFeature> CHESTNUTTREE_CHECKED_KEY = registerKey("chestnuttree_checked");
    public static final RegistryKey<PlacedFeature> CHESTNUTTREE_PLACED_KEY = registerKey("chestnuttree_placed");

    public static final RegistryKey<PlacedFeature> NUTMEGTREE_CHECKED_KEY = registerKey("nutmegtree_checked");
    public static final RegistryKey<PlacedFeature> NUTMEGTREE_PLACED_KEY = registerKey("nutmegtree_placed");

    public static final RegistryKey<PlacedFeature> PEACHTREE_CHECKED_KEY = registerKey("peachtree_checked");
    public static final RegistryKey<PlacedFeature> PEACHTREE_PLACED_KEY = registerKey("peachtree_placed");

    public static final RegistryKey<PlacedFeature> PLUMTREE_CHECKED_KEY = registerKey("plumtree_checked");
    public static final RegistryKey<PlacedFeature> PLUMTREE_PLACED_KEY = registerKey("plumtree_placed");

    public static final RegistryKey<PlacedFeature> WALNUTTREE_CHECKED_KEY = registerKey("walnuttree_checked");
    public static final RegistryKey<PlacedFeature> WALNUTTREE_PLACED_KEY = registerKey("walnuttree_placed");

    public static final RegistryKey<PlacedFeature> HAZELNUTTREE_CHECKED_KEY = registerKey("hazelnuttree_checked");
    public static final RegistryKey<PlacedFeature> HAZELNUTTREE_PLACED_KEY = registerKey("hazelnuttree_placed");

    public static final RegistryKey<PlacedFeature> PAWPAWTREE_CHECKED_KEY = registerKey("pawpawtree_checked");
    public static final RegistryKey<PlacedFeature> PAWPAWTREE_PLACED_KEY = registerKey("pawpawtree_placed");

    public static final RegistryKey<PlacedFeature> SOURSOPTREE_CHECKED_KEY = registerKey("soursoptree_checked");
    public static final RegistryKey<PlacedFeature> SOURSOPTREE_PLACED_KEY = registerKey("soursoptree_placed");

    public static final RegistryKey<PlacedFeature> ALMONDTREE_CHECKED_KEY = registerKey("almondtree_checked");
    public static final RegistryKey<PlacedFeature> ALMONDTREE_PLACED_KEY = registerKey("almondtree_placed");

    public static final RegistryKey<PlacedFeature> APRICOTTREE_CHECKED_KEY = registerKey("apricottree_checked");
    public static final RegistryKey<PlacedFeature> APRICOTTREE_PLACED_KEY = registerKey("apricottree_placed");

    public static final RegistryKey<PlacedFeature> CASHEWTREE_CHECKED_KEY = registerKey("cashewtree_checked");
    public static final RegistryKey<PlacedFeature> CASHEWTREE_PLACED_KEY = registerKey("cashewtree_placed");

    public static final RegistryKey<PlacedFeature> DATETREE_CHECKED_KEY = registerKey("datetree_checked");
    public static final RegistryKey<PlacedFeature> DATETREE_PLACED_KEY = registerKey("datetree_placed");

    public static final RegistryKey<PlacedFeature> DRAGONFRUITTREE_CHECKED_KEY = registerKey("dragonfruittree_checked");
    public static final RegistryKey<PlacedFeature> DRAGONFRUITTREE_PLACED_KEY = registerKey("dragonfruittree_placed");

    public static final RegistryKey<PlacedFeature> DURIANTREE_CHECKED_KEY = registerKey("duriantree_checked");
    public static final RegistryKey<PlacedFeature> DURIANTREE_PLACED_KEY = registerKey("duriantree_placed");

    public static final RegistryKey<PlacedFeature> FIGTREE_CHECKED_KEY = registerKey("figtree_checked");
    public static final RegistryKey<PlacedFeature> FIGTREE_PLACED_KEY = registerKey("figtree_placed");

    public static final RegistryKey<PlacedFeature> GRAPEFRUITTREE_CHECKED_KEY = registerKey("grapefruittree_checked");
    public static final RegistryKey<PlacedFeature> GRAPEFRUITTREE_PLACED_KEY = registerKey("grapefruittree_placed");

    public static final RegistryKey<PlacedFeature> LIMETREE_CHECKED_KEY = registerKey("limetree_checked");
    public static final RegistryKey<PlacedFeature> LIMETREE_PLACED_KEY = registerKey("limetree_placed");

    public static final RegistryKey<PlacedFeature> PAPAYATREE_CHECKED_KEY = registerKey("papayatree_checked");
    public static final RegistryKey<PlacedFeature> PAPAYATREE_PLACED_KEY = registerKey("papayatree_placed");

    public static final RegistryKey<PlacedFeature> PECANTREE_CHECKED_KEY = registerKey("pecantree_checked");
    public static final RegistryKey<PlacedFeature> PECANTREE_PLACED_KEY = registerKey("pecantree_placed");

    public static final RegistryKey<PlacedFeature> PERSIMMONTREE_CHECKED_KEY = registerKey("persimmontree_checked");
    public static final RegistryKey<PlacedFeature> PERSIMMONTREE_PLACED_KEY = registerKey("persimmontree_placed");

    public static final RegistryKey<PlacedFeature> PISTACHIOTREE_CHECKED_KEY = registerKey("pistachiotree_checked");
    public static final RegistryKey<PlacedFeature> PISTACHIOTREE_PLACED_KEY = registerKey("pistachiotree_placed");

    public static final RegistryKey<PlacedFeature> POMEGRANATETREE_CHECKED_KEY = registerKey("pomegranatetree_checked");
    public static final RegistryKey<PlacedFeature> POMEGRANATETREE_PLACED_KEY = registerKey("pomegranatetree_placed");

    public static final RegistryKey<PlacedFeature> STARFRUITTREE_CHECKED_KEY = registerKey("starfruittree_checked");
    public static final RegistryKey<PlacedFeature> STARFRUITTREE_PLACED_KEY = registerKey("starfruittree_placed");

    public static final RegistryKey<PlacedFeature> BREADFRUITTREE_CHECKED_KEY = registerKey("breadfruittree_checked");
    public static final RegistryKey<PlacedFeature> BREADFRUITTREE_PLACED_KEY = registerKey("breadfruittree_placed");

    public static final RegistryKey<PlacedFeature> GUAVATREE_CHECKED_KEY = registerKey("guavatree_checked");
    public static final RegistryKey<PlacedFeature> GUAVATREE_PLACED_KEY = registerKey("guavatree_placed");

    public static final RegistryKey<PlacedFeature> JACKFRUITTREE_CHECKED_KEY = registerKey("jackfruittree_checked");
    public static final RegistryKey<PlacedFeature> JACKFRUITTREE_PLACED_KEY = registerKey("jackfruittree_placed");

    public static final RegistryKey<PlacedFeature> LYCHEETREE_CHECKED_KEY = registerKey("lycheetree_checked");
    public static final RegistryKey<PlacedFeature> LYCHEETREE_PLACED_KEY = registerKey("lycheetree_placed");

    public static final RegistryKey<PlacedFeature> PASSIONFRUITTREE_CHECKED_KEY = registerKey("passionfruittree_checked");
    public static final RegistryKey<PlacedFeature> PASSIONFRUITTREE_PLACED_KEY = registerKey("passionfruittree_placed");

    public static final RegistryKey<PlacedFeature> RAMBUTANTREE_CHECKED_KEY = registerKey("rambutantree_checked");
    public static final RegistryKey<PlacedFeature> RAMBUTANTREE_PLACED_KEY = registerKey("rambutantree_placed");

    public static final RegistryKey<PlacedFeature> TAMARINDTREE_CHECKED_KEY = registerKey("tamarindtree_checked");
    public static final RegistryKey<PlacedFeature> TAMARINDTREE_PLACED_KEY = registerKey("tamarindtree_placed");









    public static final RegistryKey<PlacedFeature> MAPLETREE_CHECKED_KEY = registerKey("mapletree_checked");
    public static final RegistryKey<PlacedFeature> MAPLETREE_PLACED_KEY = registerKey("mapletree_placed");

    public static final RegistryKey<PlacedFeature> PEPPERCORNTREE_CHECKED_KEY = registerKey("peppercorntree_checked");
    public static final RegistryKey<PlacedFeature> PEPPERCORNTREE_PLACED_KEY = registerKey("peppercorntree_placed");

    public static final RegistryKey<PlacedFeature> VANILLABEANTREE_CHECKED_KEY = registerKey("vanillabeantree_checked");
    public static final RegistryKey<PlacedFeature> VANILLABEANTREE_PLACED_KEY = registerKey("vanillabeantree_placed");

    public static final RegistryKey<PlacedFeature> PINENUTTREE_CHECKED_KEY = registerKey("pinenuttree_checked");
    public static final RegistryKey<PlacedFeature> PINENUTTREE_PLACED_KEY = registerKey("pinenuttree_placed");

    public static final RegistryKey<PlacedFeature> GOOSEBERRYTREE_CHECKED_KEY = registerKey("gooseberrytree_checked");
    public static final RegistryKey<PlacedFeature> GOOSEBERRYTREE_PLACED_KEY = registerKey("gooseberrytree_placed");

    public static final RegistryKey<PlacedFeature> GRAPETREE_CHECKED_KEY = registerKey("grapetree_checked");
    public static final RegistryKey<PlacedFeature> GRAPETREE_PLACED_KEY = registerKey("grapetree_placed");

    public static final RegistryKey<PlacedFeature> RED_GRAPETREE_CHECKED_KEY = registerKey("red_grapetree_checked");
    public static final RegistryKey<PlacedFeature> RED_GRAPETREE_PLACED_KEY = registerKey("red_grapetree_placed");

    public static final RegistryKey<PlacedFeature> KIWITREE_CHECKED_KEY = registerKey("kiwitree_checked");
    public static final RegistryKey<PlacedFeature> KIWITREE_PLACED_KEY = registerKey("kiwitree_placed");





    public static final RegistryKey<PlacedFeature> DECO_ROCKS_RANDOM_PLACED_KEY = registerKey("deco_rocks_random_placed");
    public static final RegistryKey<PlacedFeature> DECO_STICKS_RANDOM_PLACED_KEY = registerKey("deco_sticks_random_placed");

    public static final RegistryKey<PlacedFeature> DECO_BEACHGRASS_PLACED_KEY = registerKey("deco_beachgrass_placed");
    public static final RegistryKey<PlacedFeature> DECO_TALL_BEACHGRASS_PLACED_KEY = registerKey("deco_tall_beachgrass_placed");
    public static final RegistryKey<PlacedFeature> DECO_SEASHELL_PLACED_KEY = registerKey("deco_seashell_placed");

    public static final RegistryKey<PlacedFeature> FLORAMELISSIA_PLACED_KEY = registerKey("flormelissia_placed");

    public static final RegistryKey<PlacedFeature> BLUEBERRY_BUSH_PLACED_KEY = registerKey("blueberry_bush_placed");
    public static final RegistryKey<PlacedFeature> BLACKBERRY_BUSH_PLACED_KEY = registerKey("blackberry_bush_placed");
    public static final RegistryKey<PlacedFeature> RASPBERRY_BUSH_PLACED_KEY = registerKey("raspberry_bush_placed");
    public static final RegistryKey<PlacedFeature> CLOUDBERRY_BUSH_PLACED_KEY = registerKey("cloudberry_bush_placed");
    public static final RegistryKey<PlacedFeature> WILD_STRAWBERRY_BUSH_PLACED_KEY = registerKey("wild_strawberry_bush_placed");

    public static final RegistryKey<PlacedFeature> LINGONBERRY_BUSH_PLACED_KEY = registerKey("lingonberry_bush_placed");
    public static final RegistryKey<PlacedFeature> CRANBERRY_BUSH_PLACED_KEY = registerKey("cranberry_bush_placed");
    public static final RegistryKey<PlacedFeature> HUCKLEBERRY_BUSH_PLACED_KEY = registerKey("huckleberry_bush_placed");
    public static final RegistryKey<PlacedFeature> JUNIPERBERRY_BUSH_PLACED_KEY = registerKey("juniperberry_bush_placed");
    public static final RegistryKey<PlacedFeature> MULBERRY_BUSH_PLACED_KEY = registerKey("mulberry_bush_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //Crops
        register(context, TOMATO_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOMATO_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, BASIL_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BASIL_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, OREGANO_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OREGANO_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, STRAWBERRY_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.STRAWBERRY_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, OAT_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OAT_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, JALAPENO_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JALAPENO_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CHILI_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHILI_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CUCUMBER_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CUCUMBER_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, ONION_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ONION_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, LEEK_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEEK_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CELERY_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CELERY_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, PEAS_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEAS_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, SWEET_POTATO_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SWEET_POTATO_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, ASPARAGUS_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ASPARAGUS_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, SCALLION_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SCALLION_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, GARLIC_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GARLIC_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CHIVE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHIVE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, BROCCOLI_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BROCCOLI_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CAULIFLOWER_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CAULIFLOWER_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CORN_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CORN_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CABBAGE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CABBAGE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, BELLPEPPER_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BELLPEPPER_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, TURNIP_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURNIP_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, RUTABAGA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUTABAGA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CANOLA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CANOLA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, BARLEY_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BARLEY_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, COTTON_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COTTON_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, SUGARBEET_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SUGARBEET_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, RICE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RICE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, WHITE_BUTTON_MUSHROOM_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WHITE_BUTTON_MUSHROOM_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, PORCINI_MUSHROOM_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PORCINI_MUSHROOM_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CHANTERELLE_MUSHROOM_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHANTERELLE_MUSHROOM_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, MOREL_MUSHROOM_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOREL_MUSHROOM_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, SOYBEAN_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SOYBEAN_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, SPINACH_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPINACH_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, ARROWROOT_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ARROWROOT_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, ARTICHOKE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ARTICHOKE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, BRUSSELS_SPROUTS_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BRUSSELS_SPROUTS_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CASSAVA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CASSAVA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, EGGPLANT_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.EGGPLANT_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, SUNFLOWER_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SUNFLOWER_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, JICAMA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JICAMA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, KALE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.KALE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, KOHLRABI_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.KOHLRABI_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, LETTUCE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LETTUCE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, OKRA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OKRA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, PARSNIP_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PARSNIP_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, RADISH_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RADISH_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, RHUBARB_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RHUBARB_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, MILLET_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MILLET_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, RYE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RYE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, SQUASH_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SQUASH_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, ZUCCHINI_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ZUCCHINI_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, COFFEA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COFFEA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, PARSLEY_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PARSLEY_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, MINT_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MINT_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, PINEAPPLE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINEAPPLE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, HOP_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HOP_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, FILIPENDULA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FILIPENDULA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CACTUS_FRUIT_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CACTUS_FRUIT_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CANTALOUPE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CANTALOUPE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, FLAX_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FLAX_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, JUTE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JUTE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, KENAF_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.KENAF_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, SISAL_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SISAL_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, AMARANTH_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AMARANTH_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, BEAN_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BEAN_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CHICKPEA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHICKPEA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, LENTIL_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LENTIL_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, QUINOA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.QUINOA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, PEANUT_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEANUT_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, TARO_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TARO_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, TOMATILLO_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOMATILLO_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, AGAVE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AGAVE_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, GINGER_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GINGER_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, SESAME_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SESAME_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, MUSTARD_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSTARD_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, CAMELLIA_SINENSIS_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CAMELLIA_SINENSIS_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, NICOTIANA_RUSTICA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NICOTIANA_RUSTICA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, PAPAVER_SOMNIFERUM_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PAPAVER_SOMNIFERUM_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));

        register(context, ERYTHROXYLUM_COCA_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ERYTHROXYLUM_COCA_CROP_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1)));













        register(context, SALT_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SALT_ORE_KEY),
                modifiersWithCount(9, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(90))));
        //from -80 to +80, most in middle, meaning mining level 0.






        register(context, DECO_ROCKS_RANDOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_ROCKS_RANDOM_KEY),
                //VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.5f, 3)));
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.5f, 3)));

        register(context, DECO_STICKS_RANDOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_STICKS_RANDOM_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.5f, 2)));

        register(context, DECO_BEACHGRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_BEACHGRASS_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.5f, 5)));

        register(context, DECO_TALL_BEACHGRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_TALL_BEACHGRASS_KEY),
                NoiseThresholdCountPlacementModifier.of(-0.8, 0, 7),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, DECO_SEASHELL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_SEASHELL_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(0, 0.5f, 2)));






        register(context, FLORAMELISSIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FLORAMELISSIA_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


        //tree count, extraChance, extraCount
        int count = 0;              //the base number of times the feature will attempt to spawn in a chunk.
        float extraChance = 0.01f;  //the probability of an extra feature spawn. For example, if set to 0.1f, there will be a 10% chance of an additional feature spawn for each attempt to place the feature.
        int extraCount = 1;         //the maximum number of additional spawns that can occur, if the extra chance is successful.



        register(context, APPLETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APPLETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.APPLETREE_SAPLING)));
        register(context, APPLETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APPLETREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));





        register(context, BANANATREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BANANATREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.BANANATREE_SAPLING)));
        register(context, BANANATREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BANANATREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, CINNAMONTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CINNAMONTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CINNAMON_SAPLING)));
        register(context, CINNAMONTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CINNAMONTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, ORANGETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.ORANGETREE_SAPLING)));
        register(context, ORANGETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGETREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, PEARTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEARTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PEARTREE_SAPLING)));
        register(context, PEARTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEARTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, COCONUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COCONUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.COCONUTTREE_SAPLING)));
        register(context, COCONUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COCONUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, AVOCADOTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AVOCADOTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.AVOCADOTREE_SAPLING)));
        register(context, AVOCADOTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AVOCADOTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, CHERRYTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHERRYTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CHERRYTREE_SAPLING)));
        register(context, CHERRYTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHERRYTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, LEMONTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEMONTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.LEMONTREE_SAPLING)));
        register(context, LEMONTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEMONTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, MANGOTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MANGOTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.MANGOTREE_SAPLING)));
        register(context, MANGOTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MANGOTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, OLIVETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OLIVETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.OLIVETREE_SAPLING)));
        register(context, OLIVETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OLIVETREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, RUBBERTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBBERTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.RUBBERTREE_SAPLING)));
        register(context, RUBBERTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBBERTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));














        register(context, CANDLENUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CANDLENUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CANDLENUTTREE_SAPLING)));
        register(context, CANDLENUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CANDLENUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, CHESTNUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHESTNUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CHESTNUTTREE_SAPLING)));
        register(context, CHESTNUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHESTNUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, NUTMEGTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NUTMEGTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.NUTMEGTREE_SAPLING)));
        register(context, NUTMEGTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NUTMEGTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PEACHTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEACHTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PEACHTREE_SAPLING)));
        register(context, PEACHTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEACHTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PLUMTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLUMTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PLUMTREE_SAPLING)));
        register(context, PLUMTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLUMTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, WALNUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WALNUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.WALNUTTREE_SAPLING)));
        register(context, WALNUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WALNUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, HAZELNUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HAZELNUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.HAZELNUTTREE_SAPLING)));
        register(context, HAZELNUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HAZELNUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PAWPAWTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PAWPAWTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PAWPAWTREE_SAPLING)));
        register(context, PAWPAWTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PAWPAWTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, SOURSOPTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SOURSOPTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.SOURSOPTREE_SAPLING)));
        register(context, SOURSOPTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SOURSOPTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, ALMONDTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ALMONDTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.ALMONDTREE_SAPLING)));
        register(context, ALMONDTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ALMONDTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, APRICOTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APRICOTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.APRICOTTREE_SAPLING)));
        register(context, APRICOTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APRICOTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, CASHEWTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CASHEWTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CASHEWTREE_SAPLING)));
        register(context, CASHEWTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CASHEWTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, DATETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DATETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.DATETREE_SAPLING)));
        register(context, DATETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DATETREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, DRAGONFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DRAGONFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.DRAGONFRUITTREE_SAPLING)));
        register(context, DRAGONFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DRAGONFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, DURIANTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DURIANTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.DURIANTREE_SAPLING)));
        register(context, DURIANTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DURIANTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, FIGTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FIGTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.FIGTREE_SAPLING)));
        register(context, FIGTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FIGTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, GRAPEFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRAPEFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.GRAPEFRUITTREE_SAPLING)));
        register(context, GRAPEFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRAPEFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, LIMETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LIMETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.LIMETREE_SAPLING)));
        register(context, LIMETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LIMETREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PAPAYATREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PAPAYATREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PAPAYATREE_SAPLING)));
        register(context, PAPAYATREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PAPAYATREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PECANTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PECANTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PECANTREE_SAPLING)));
        register(context, PECANTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PECANTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PERSIMMONTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PERSIMMONTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PERSIMMONTREE_SAPLING)));
        register(context, PERSIMMONTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PERSIMMONTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PISTACHIOTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PISTACHIOTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PISTACHIOTREE_SAPLING)));
        register(context, PISTACHIOTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PISTACHIOTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, POMEGRANATETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.POMEGRANATETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.POMEGRANATETREE_SAPLING)));
        register(context, POMEGRANATETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.POMEGRANATETREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, STARFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.STARFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.STARFRUITTREE_SAPLING)));
        register(context, STARFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.STARFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, BREADFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BREADFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.BREADFRUITTREE_SAPLING)));
        register(context, BREADFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BREADFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, GUAVATREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GUAVATREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.GUAVATREE_SAPLING)));
        register(context, GUAVATREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GUAVATREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, JACKFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JACKFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.JACKFRUITTREE_SAPLING)));
        register(context, JACKFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JACKFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, LYCHEETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LYCHEETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.LYCHEETREE_SAPLING)));
        register(context, LYCHEETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LYCHEETREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PASSIONFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PASSIONFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PASSIONFRUITTREE_SAPLING)));
        register(context, PASSIONFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PASSIONFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, RAMBUTANTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RAMBUTANTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.RAMBUTANTREE_SAPLING)));
        register(context, RAMBUTANTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RAMBUTANTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, TAMARINDTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TAMARINDTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.TAMARINDTREE_SAPLING)));
        register(context, TAMARINDTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TAMARINDTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));









        register(context, MAPLETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MAPLETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.MAPLETREE_SAPLING)));
        register(context, MAPLETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MAPLETREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PEPPERCORNTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEPPERCORNTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PEPPERCORNTREE_SAPLING)));
        register(context, PEPPERCORNTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEPPERCORNTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, VANILLABEANTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VANILLABEANTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.VANILLABEANTREE_SAPLING)));
        register(context, VANILLABEANTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VANILLABEANTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PINENUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINENUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PINENUTTREE_SAPLING)));
        register(context, PINENUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINENUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, GOOSEBERRYTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GOOSEBERRYTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.GOOSEBERRYTREE_SAPLING)));
        register(context, GOOSEBERRYTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GOOSEBERRYTREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, GRAPETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRAPETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.GRAPETREE_SAPLING)));
        register(context, GRAPETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRAPETREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, RED_GRAPETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_GRAPETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.RED_GRAPETREE_SAPLING)));
        register(context, RED_GRAPETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_GRAPETREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, KIWITREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.KIWITREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.KIWITREE_SAPLING)));
        register(context, KIWITREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.KIWITREE_SPAWN_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));




        /*
        register(context, DECO_BEACHGRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_BEACHGRASS_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.5f, 5)));
         */


        register(context, BLUEBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUEBERRYBUSH_KEY),
                RarityFilterPlacementModifier.of(28), SquarePlacementModifier.of(), CountPlacementModifier.of(8), RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(2)),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, BLACKBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLACKBERRY_KEY),
                RarityFilterPlacementModifier.of(28), SquarePlacementModifier.of(), CountPlacementModifier.of(8), RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(2)),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, RASPBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RASPBERRY_KEY),
                RarityFilterPlacementModifier.of(28), SquarePlacementModifier.of(), CountPlacementModifier.of(8), RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(2)),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, CLOUDBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CLOUDBERRY_KEY),
                RarityFilterPlacementModifier.of(28), SquarePlacementModifier.of(), CountPlacementModifier.of(8), RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(2)),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, WILD_STRAWBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WILDSTRAWBERRY_KEY),
                RarityFilterPlacementModifier.of(28), SquarePlacementModifier.of(), CountPlacementModifier.of(8), RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(2)),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, LINGONBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LINGONBERRY_KEY),
                RarityFilterPlacementModifier.of(28), SquarePlacementModifier.of(), CountPlacementModifier.of(8), RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(2)),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, CRANBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CRANBERRY_KEY),
                RarityFilterPlacementModifier.of(28), SquarePlacementModifier.of(), CountPlacementModifier.of(8), RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(2)),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, HUCKLEBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HUCKLEBERRY_KEY),
                RarityFilterPlacementModifier.of(28), SquarePlacementModifier.of(), CountPlacementModifier.of(8), RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(2)),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, JUNIPERBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JUNIPERBERRY_KEY),
                RarityFilterPlacementModifier.of(28), SquarePlacementModifier.of(), CountPlacementModifier.of(8), RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(2)),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, MULBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MULBERRY_KEY),
                RarityFilterPlacementModifier.of(28), SquarePlacementModifier.of(), CountPlacementModifier.of(8), RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(2)),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
    }



    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Photosynthesis.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}