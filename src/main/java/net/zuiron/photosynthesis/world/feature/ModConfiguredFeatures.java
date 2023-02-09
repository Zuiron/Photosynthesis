package net.zuiron.photosynthesis.world.feature;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.world.gen.AppleTreeDecorator;
import net.zuiron.photosynthesis.world.gen.BananaTreeDecorator;

import java.util.Collections;
import java.util.List;

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




    //TREE's -----------------------------------------------------------------------------------------------------------
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> APPLETREE_TREE =
            ConfiguredFeatures.register("appletree_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.APPLETREE_LOG),
                    new StraightTrunkPlacer(3, 4, 2), //3,4,2
                    BlockStateProvider.of(ModBlocks.APPLETREE_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),//3
                    new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(AppleTreeDecorator.INSTANCE)).build());

    public static final RegistryEntry<PlacedFeature> APPLETREE_CHECKED = PlacedFeatures.register("appletree_checked",
            ModConfiguredFeatures.APPLETREE_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.APPLETREE_SAPLING)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> APPLETREE_SPAWN =
            ConfiguredFeatures.register("appletree_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(APPLETREE_CHECKED, 0.1f)),
                            APPLETREE_CHECKED));






    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BANANATREE_TREE =
            ConfiguredFeatures.register("bananatree_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.BANANATREE_LOG),
                    new ForkingTrunkPlacer(6, 2, 2), //StraightTrunkPlacer(4, 8, 0)
                    BlockStateProvider.of(ModBlocks.BANANATREE_LEAVES),
                    new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),//3
                    new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(BananaTreeDecorator.INSTANCE)).ignoreVines().build());

    public static final RegistryEntry<PlacedFeature> BANANATREE_CHECKED = PlacedFeatures.register("bananatree_checked",
            ModConfiguredFeatures.BANANATREE_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.BANANATREE_SAPLING)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> BANANATREE_SPAWN =
            ConfiguredFeatures.register("bananatree_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(BANANATREE_CHECKED, 0.1f)),
                            BANANATREE_CHECKED));





    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CINNAMON_TREE =
            ConfiguredFeatures.register("cinnamon_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.CINNAMON_LOG),
                    new StraightTrunkPlacer(5, 6, 3),//5,6,3
                    BlockStateProvider.of(ModBlocks.CINNAMON_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),//4
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final RegistryEntry<PlacedFeature> CINNAMON_CHECKED = PlacedFeatures.register("cinnamon_checked",
            ModConfiguredFeatures.CINNAMON_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.CINNAMON_SAPLING)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CINNAMON_SPAWN =
            ConfiguredFeatures.register("cinnamon_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(CINNAMON_CHECKED, 0.1f)),
                            CINNAMON_CHECKED));






    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + Photosynthesis.MOD_ID);
    }
}