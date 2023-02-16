package net.zuiron.photosynthesis.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
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











    public static final RegistryKey<PlacedFeature> FLORAMELISSIA_PLACED_KEY = registerKey("flormelissia_placed");

    public static final RegistryKey<PlacedFeature> BLUEBERRY_BUSH_PLACED_KEY = registerKey("blueberry_bush_placed");
    public static final RegistryKey<PlacedFeature> BLACKBERRY_BUSH_PLACED_KEY = registerKey("blackberry_bush_placed");
    public static final RegistryKey<PlacedFeature> RASPBERRY_BUSH_PLACED_KEY = registerKey("raspberry_bush_placed");
    public static final RegistryKey<PlacedFeature> CLOUDBERRY_BUSH_PLACED_KEY = registerKey("cloudberry_bush_placed");
    public static final RegistryKey<PlacedFeature> WILD_STRAWBERRY_BUSH_PLACED_KEY = registerKey("wild_strawberry_bush_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);


        register(context, FLORAMELISSIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FLORAMELISSIA_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


        register(context, APPLETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APPLETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.APPLETREE_SAPLING)));
        register(context, APPLETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APPLETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, BANANATREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BANANATREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.BANANATREE_SAPLING)));
        register(context, BANANATREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BANANATREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, CINNAMONTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CINNAMONTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CINNAMON_SAPLING)));
        register(context, CINNAMONTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CINNAMONTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, ORANGETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.ORANGETREE_SAPLING)));
        register(context, ORANGETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, PEARTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEARTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.PEARTREE_SAPLING)));
        register(context, PEARTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PEARTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, COCONUTTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COCONUTTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.COCONUTTREE_SAPLING)));
        register(context, COCONUTTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COCONUTTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, AVOCADOTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AVOCADOTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.AVOCADOTREE_SAPLING)));
        register(context, AVOCADOTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AVOCADOTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, CHERRYTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHERRYTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.CHERRYTREE_SAPLING)));
        register(context, CHERRYTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHERRYTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, LEMONTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEMONTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.LEMONTREE_SAPLING)));
        register(context, LEMONTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEMONTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, MANGOTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MANGOTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.MANGOTREE_SAPLING)));
        register(context, MANGOTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MANGOTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, OLIVETREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OLIVETREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.OLIVETREE_SAPLING)));
        register(context, OLIVETREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OLIVETREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));



        register(context, RUBBERTREE_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBBERTREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.RUBBERTREE_SAPLING)));
        register(context, RUBBERTREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBBERTREE_SPAWN_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));










        register(context, BLUEBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUEBERRYBUSH_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, BLACKBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLACKBERRY_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, RASPBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RASPBERRY_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, CLOUDBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CLOUDBERRY_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, WILD_STRAWBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WILDSTRAWBERRY_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
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