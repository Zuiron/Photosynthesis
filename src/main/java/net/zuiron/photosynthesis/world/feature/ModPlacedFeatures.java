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

    public static final RegistryKey<PlacedFeature> CANDLEBERRY_BUSH_PLACED_KEY = registerKey("candleberry_bush_placed");
    public static final RegistryKey<PlacedFeature> CRANBERRY_BUSH_PLACED_KEY = registerKey("cranberry_bush_placed");
    public static final RegistryKey<PlacedFeature> HUCKLEBERRY_BUSH_PLACED_KEY = registerKey("huckleberry_bush_placed");
    public static final RegistryKey<PlacedFeature> JUNIPERBERRY_BUSH_PLACED_KEY = registerKey("juniperberry_bush_placed");
    public static final RegistryKey<PlacedFeature> MULBERRY_BUSH_PLACED_KEY = registerKey("mulberry_bush_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SALT_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SALT_ORE_KEY),
                modifiersWithCount(9, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(90))));
        //from -80 to +80, most in middle, meaning mining level 0.






        register(context, DECO_ROCKS_RANDOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_ROCKS_RANDOM_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.5f, 3)));

        register(context, DECO_STICKS_RANDOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_STICKS_RANDOM_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.5f, 2)));

        register(context, DECO_BEACHGRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_BEACHGRASS_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.5f, 5)));

        register(context, DECO_TALL_BEACHGRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_TALL_BEACHGRASS_KEY),
                NoiseThresholdCountPlacementModifier.of(-0.8, 0, 7),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, DECO_SEASHELL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DECO_SEASHELL_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(0, 0.5f, 2)));






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
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));





        register(context, BANANATREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BANANATREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.BANANATREE_SAPLING)));
        register(context, BANANATREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BANANATREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, CINNAMONTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CINNAMONTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CINNAMON_SAPLING)));
        register(context, CINNAMONTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CINNAMONTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, ORANGETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.ORANGETREE_SAPLING)));
        register(context, ORANGETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, PEARTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEARTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PEARTREE_SAPLING)));
        register(context, PEARTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEARTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, COCONUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COCONUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.COCONUTTREE_SAPLING)));
        register(context, COCONUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COCONUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, AVOCADOTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AVOCADOTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.AVOCADOTREE_SAPLING)));
        register(context, AVOCADOTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AVOCADOTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, CHERRYTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHERRYTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CHERRYTREE_SAPLING)));
        register(context, CHERRYTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHERRYTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, LEMONTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEMONTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.LEMONTREE_SAPLING)));
        register(context, LEMONTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEMONTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, MANGOTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MANGOTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.MANGOTREE_SAPLING)));
        register(context, MANGOTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MANGOTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, OLIVETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OLIVETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.OLIVETREE_SAPLING)));
        register(context, OLIVETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OLIVETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));



        register(context, RUBBERTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBBERTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.RUBBERTREE_SAPLING)));
        register(context, RUBBERTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBBERTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));














        register(context, CANDLENUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CANDLENUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CANDLENUTTREE_SAPLING)));
        register(context, CANDLENUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CANDLENUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, CHESTNUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHESTNUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CHESTNUTTREE_SAPLING)));
        register(context, CHESTNUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHESTNUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, NUTMEGTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NUTMEGTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.NUTMEGTREE_SAPLING)));
        register(context, NUTMEGTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NUTMEGTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PEACHTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEACHTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PEACHTREE_SAPLING)));
        register(context, PEACHTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEACHTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PLUMTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLUMTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PLUMTREE_SAPLING)));
        register(context, PLUMTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLUMTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, WALNUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WALNUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.WALNUTTREE_SAPLING)));
        register(context, WALNUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WALNUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, HAZELNUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HAZELNUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.HAZELNUTTREE_SAPLING)));
        register(context, HAZELNUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HAZELNUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PAWPAWTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PAWPAWTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PAWPAWTREE_SAPLING)));
        register(context, PAWPAWTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PAWPAWTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, SOURSOPTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SOURSOPTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.SOURSOPTREE_SAPLING)));
        register(context, SOURSOPTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SOURSOPTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, ALMONDTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ALMONDTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.ALMONDTREE_SAPLING)));
        register(context, ALMONDTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ALMONDTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, APRICOTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APRICOTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.APRICOTTREE_SAPLING)));
        register(context, APRICOTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APRICOTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, CASHEWTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CASHEWTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CASHEWTREE_SAPLING)));
        register(context, CASHEWTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CASHEWTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, DATETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DATETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.DATETREE_SAPLING)));
        register(context, DATETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DATETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, DRAGONFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DRAGONFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.DRAGONFRUITTREE_SAPLING)));
        register(context, DRAGONFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DRAGONFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, DURIANTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DURIANTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.DURIANTREE_SAPLING)));
        register(context, DURIANTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DURIANTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, FIGTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FIGTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.FIGTREE_SAPLING)));
        register(context, FIGTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FIGTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, GRAPEFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRAPEFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.GRAPEFRUITTREE_SAPLING)));
        register(context, GRAPEFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRAPEFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, LIMETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LIMETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.LIMETREE_SAPLING)));
        register(context, LIMETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LIMETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PAPAYATREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PAPAYATREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PAPAYATREE_SAPLING)));
        register(context, PAPAYATREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PAPAYATREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PECANTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PECANTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PECANTREE_SAPLING)));
        register(context, PECANTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PECANTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PERSIMMONTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PERSIMMONTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PERSIMMONTREE_SAPLING)));
        register(context, PERSIMMONTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PERSIMMONTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PISTACHIOTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PISTACHIOTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PISTACHIOTREE_SAPLING)));
        register(context, PISTACHIOTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PISTACHIOTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, POMEGRANATETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.POMEGRANATETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.POMEGRANATETREE_SAPLING)));
        register(context, POMEGRANATETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.POMEGRANATETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, STARFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.STARFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.STARFRUITTREE_SAPLING)));
        register(context, STARFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.STARFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, BREADFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BREADFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.BREADFRUITTREE_SAPLING)));
        register(context, BREADFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BREADFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, GUAVATREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GUAVATREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.GUAVATREE_SAPLING)));
        register(context, GUAVATREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GUAVATREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, JACKFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JACKFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.JACKFRUITTREE_SAPLING)));
        register(context, JACKFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JACKFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, LYCHEETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LYCHEETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.LYCHEETREE_SAPLING)));
        register(context, LYCHEETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LYCHEETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PASSIONFRUITTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PASSIONFRUITTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PASSIONFRUITTREE_SAPLING)));
        register(context, PASSIONFRUITTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PASSIONFRUITTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, RAMBUTANTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RAMBUTANTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.RAMBUTANTREE_SAPLING)));
        register(context, RAMBUTANTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RAMBUTANTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, TAMARINDTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TAMARINDTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.TAMARINDTREE_SAPLING)));
        register(context, TAMARINDTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TAMARINDTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));









        register(context, MAPLETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MAPLETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.MAPLETREE_SAPLING)));
        register(context, MAPLETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MAPLETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PEPPERCORNTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEPPERCORNTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PEPPERCORNTREE_SAPLING)));
        register(context, PEPPERCORNTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEPPERCORNTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, VANILLABEANTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VANILLABEANTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.VANILLABEANTREE_SAPLING)));
        register(context, VANILLABEANTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VANILLABEANTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, PINENUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINENUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PINENUTTREE_SAPLING)));
        register(context, PINENUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINENUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, GOOSEBERRYTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GOOSEBERRYTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.GOOSEBERRYTREE_SAPLING)));
        register(context, GOOSEBERRYTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GOOSEBERRYTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));

        register(context, GRAPETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRAPETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.GRAPETREE_SAPLING)));
        register(context, GRAPETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRAPETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));






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

        register(context, CANDLEBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CANDLEBERRY_KEY),
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