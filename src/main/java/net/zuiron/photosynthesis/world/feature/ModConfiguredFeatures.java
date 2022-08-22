package net.zuiron.photosynthesis.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> FLORAMELISSIA =
            ConfiguredFeatures.register("floramelissia", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLORAMELISSIA)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> BLUEBERRY_BUSH =
            ConfiguredFeatures.register("blueberry_bush", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBERRY_BUSH)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> BLACKBERRY_BUSH =
            ConfiguredFeatures.register("blackberry_bush", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLACKBERRY_BUSH)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> RASPBERRY_BUSH =
            ConfiguredFeatures.register("raspberry_bush", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RASPBERRY_BUSH)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CLOUDBERRY_BUSH =
            ConfiguredFeatures.register("cloudberry_bush", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CLOUDBERRY_BUSH)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> WILD_STRAWBERRY_BUSH =
            ConfiguredFeatures.register("wild_strawberry_bush", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WILD_STRAWBERRY_BUSH)))));


    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + Photosynthesis.MOD_ID);
    }
}