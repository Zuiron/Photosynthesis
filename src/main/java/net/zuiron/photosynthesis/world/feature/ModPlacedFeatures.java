package net.zuiron.photosynthesis.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> FLORAMELISSIA_PLACED = PlacedFeatures.register("floramelissia_placed",
            ModConfiguredFeatures.FLORAMELISSIA, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> BLUEBERRY_BUSH_PLACED = PlacedFeatures.register("blueberry_bush_placed",
            ModConfiguredFeatures.BLUEBERRY_BUSH, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> BLACKBERRY_BUSH_PLACED = PlacedFeatures.register("blackberry_bush_placed",
            ModConfiguredFeatures.BLACKBERRY_BUSH, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> RASPBERRY_BUSH_PLACED = PlacedFeatures.register("raspberry_bush_placed",
            ModConfiguredFeatures.RASPBERRY_BUSH, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> CLOUDBERRY_BUSH_PLACED = PlacedFeatures.register("cloudberry_bush_placed",
            ModConfiguredFeatures.CLOUDBERRY_BUSH, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> WILD_STRAWBERRY_BUSH_PLACED = PlacedFeatures.register("wild_strawberry_bush_placed",
            ModConfiguredFeatures.WILD_STRAWBERRY_BUSH, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
}