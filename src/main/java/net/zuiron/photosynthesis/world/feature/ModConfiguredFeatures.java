package net.zuiron.photosynthesis.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.world.gen.AppleTreeDecorator;
import net.zuiron.photosynthesis.world.gen.BananaTreeDecorator;
import net.zuiron.photosynthesis.world.gen.OrangeTreeDecorator;

import java.util.Collections;
import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> FLORAMELISSIA_KEY = registerKey("floramelissia");
    public static final RegistryKey<ConfiguredFeature<?,?>> BLUEBERRYBUSH_KEY = registerKey("blueberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> BLACKBERRY_KEY = registerKey("blackberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> RASPBERRY_KEY = registerKey("raspberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> CLOUDBERRY_KEY = registerKey("cloudberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> WILDSTRAWBERRY_KEY = registerKey("wild_strawberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> APPLETREE_KEY = registerKey("appletree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> APPLETREE_SPAWN_KEY = registerKey("appletree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> BANANATREE_KEY = registerKey("bananatree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> BANANATREE_SPAWN_KEY = registerKey("bananatree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> CINNAMONTREE_KEY = registerKey("cinnamon_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> CINNAMONTREE_SPAWN_KEY = registerKey("cinnamon_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> ORANGETREE_KEY = registerKey("orangetree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> ORANGETREE_SPAWN_KEY = registerKey("orangetree_spawn");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        //register(context, KEY, );

        register(context, FLORAMELISSIA_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLORAMELISSIA)))));



        register(context, BLUEBERRYBUSH_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBERRY_BUSH)))));
        register(context, BLACKBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLACKBERRY_BUSH)))));
        register(context, RASPBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RASPBERRY_BUSH)))));
        register(context, CLOUDBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CLOUDBERRY_BUSH)))));
        register(context, WILDSTRAWBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WILD_STRAWBERRY_BUSH)))));




        register(context, APPLETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.APPLETREE_LOG),
                new StraightTrunkPlacer(3, 4, 2), //3,4,2
                BlockStateProvider.of(ModBlocks.APPLETREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(AppleTreeDecorator.INSTANCE)).build());

        register(context, APPLETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.APPLETREE_CHECKED_KEY),
                        0.5f)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.APPLETREE_CHECKED_KEY)));




        register(context, BANANATREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BANANATREE_LOG),
                new ForkingTrunkPlacer(6, 2, 2), //StraightTrunkPlacer(4, 8, 0)
                BlockStateProvider.of(ModBlocks.BANANATREE_LEAVES),
                new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(BananaTreeDecorator.INSTANCE)).ignoreVines().build());

        register(context, BANANATREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.BANANATREE_CHECKED_KEY),
                        0.5f)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.BANANATREE_CHECKED_KEY)));




        register(context, CINNAMONTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CINNAMON_LOG),
                new StraightTrunkPlacer(5, 6, 3),//5,6,3
                BlockStateProvider.of(ModBlocks.CINNAMON_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),//4
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, CINNAMONTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CINNAMONTREE_CHECKED_KEY),
                        0.5f)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CINNAMONTREE_CHECKED_KEY)));





        register(context, ORANGETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ORANGETREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.ORANGETREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(OrangeTreeDecorator.INSTANCE)).build());

        register(context, ORANGETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.ORANGETREE_CHECKED_KEY),
                        0.5f)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.ORANGETREE_CHECKED_KEY)));



    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Photosynthesis.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}