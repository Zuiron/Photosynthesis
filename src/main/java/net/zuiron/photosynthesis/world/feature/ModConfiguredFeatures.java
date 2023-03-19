package net.zuiron.photosynthesis.world.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.block.berrybushblocks.*;
import net.zuiron.photosynthesis.world.gen.treedecorators.*;

import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> SALT_ORE_KEY = registerKey("salt_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> DECO_ROCKS_RANDOM_KEY = registerKey("deco_rocks_random");
    public static final RegistryKey<ConfiguredFeature<?,?>> DECO_STICKS_RANDOM_KEY = registerKey("deco_sticks_random");
    public static final RegistryKey<ConfiguredFeature<?,?>> DECO_BEACHGRASS_KEY = registerKey("deco_beachgrass");
    public static final RegistryKey<ConfiguredFeature<?,?>> DECO_TALL_BEACHGRASS_KEY = registerKey("deco_tall_beachgrass");
    public static final RegistryKey<ConfiguredFeature<?,?>> DECO_SEASHELL_KEY = registerKey("deco_seashell");
    public static final RegistryKey<ConfiguredFeature<?,?>> FLORAMELISSIA_KEY = registerKey("floramelissia");
    public static final RegistryKey<ConfiguredFeature<?,?>> BLUEBERRYBUSH_KEY = registerKey("blueberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> BLACKBERRY_KEY = registerKey("blackberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> RASPBERRY_KEY = registerKey("raspberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> CLOUDBERRY_KEY = registerKey("cloudberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> WILDSTRAWBERRY_KEY = registerKey("wild_strawberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> CANDLEBERRY_KEY = registerKey("candleberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> CRANBERRY_KEY = registerKey("cranberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> HUCKLEBERRY_KEY = registerKey("huckleberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> JUNIPERBERRY_KEY = registerKey("juniperberry_bush");
    public static final RegistryKey<ConfiguredFeature<?,?>> MULBERRY_KEY = registerKey("mulberry_bush");


    public static final RegistryKey<ConfiguredFeature<?,?>> APPLETREE_KEY = registerKey("appletree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> APPLETREE_SPAWN_KEY = registerKey("appletree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> BANANATREE_KEY = registerKey("bananatree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> BANANATREE_SPAWN_KEY = registerKey("bananatree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> CINNAMONTREE_KEY = registerKey("cinnamon_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> CINNAMONTREE_SPAWN_KEY = registerKey("cinnamon_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> ORANGETREE_KEY = registerKey("orangetree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> ORANGETREE_SPAWN_KEY = registerKey("orangetree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PEARTREE_KEY = registerKey("peartree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PEARTREE_SPAWN_KEY = registerKey("peartree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> COCONUTTREE_KEY = registerKey("coconuttree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> COCONUTTREE_SPAWN_KEY = registerKey("coconuttree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> AVOCADOTREE_KEY = registerKey("avocadotree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> AVOCADOTREE_SPAWN_KEY = registerKey("avocadotree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> CHERRYTREE_KEY = registerKey("cherrytree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> CHERRYTREE_SPAWN_KEY = registerKey("cherrytree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> LEMONTREE_KEY = registerKey("lemontree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> LEMONTREE_SPAWN_KEY = registerKey("lemontree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> MANGOTREE_KEY = registerKey("mangotree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> MANGOTREE_SPAWN_KEY = registerKey("mangotree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> OLIVETREE_KEY = registerKey("olivetree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> OLIVETREE_SPAWN_KEY = registerKey("olivetree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> RUBBERTREE_KEY = registerKey("rubbertree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> RUBBERTREE_SPAWN_KEY = registerKey("rubbertree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> CANDLENUTTREE_KEY = registerKey("candlenuttree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> CANDLENUTTREE_SPAWN_KEY = registerKey("candlenuttree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> CHESTNUTTREE_KEY = registerKey("chestnuttree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> CHESTNUTTREE_SPAWN_KEY = registerKey("chestnuttree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> NUTMEGTREE_KEY = registerKey("nutmegtree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> NUTMEGTREE_SPAWN_KEY = registerKey("nutmegtree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PEACHTREE_KEY = registerKey("peachtree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PEACHTREE_SPAWN_KEY = registerKey("peachtree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PLUMTREE_KEY = registerKey("plumtree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PLUMTREE_SPAWN_KEY = registerKey("plumtree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> WALNUTTREE_KEY = registerKey("walnuttree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> WALNUTTREE_SPAWN_KEY = registerKey("walnuttree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> HAZELNUTTREE_KEY = registerKey("hazelnuttree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> HAZELNUTTREE_SPAWN_KEY = registerKey("hazelnuttree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PAWPAWTREE_KEY = registerKey("pawpawtree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PAWPAWTREE_SPAWN_KEY = registerKey("pawpawtree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> SOURSOPTREE_KEY = registerKey("soursoptree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> SOURSOPTREE_SPAWN_KEY = registerKey("soursoptree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> ALMONDTREE_KEY = registerKey("almondtree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> ALMONDTREE_SPAWN_KEY = registerKey("almondtree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> APRICOTTREE_KEY = registerKey("apricottree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> APRICOTTREE_SPAWN_KEY = registerKey("apricottree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> CASHEWTREE_KEY = registerKey("cashewtree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> CASHEWTREE_SPAWN_KEY = registerKey("cashewtree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> DATETREE_KEY = registerKey("datetree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> DATETREE_SPAWN_KEY = registerKey("datetree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> DRAGONFRUITTREE_KEY = registerKey("dragonfruittree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> DRAGONFRUITTREE_SPAWN_KEY = registerKey("dragonfruittree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> DURIANTREE_KEY = registerKey("duriantree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> DURIANTREE_SPAWN_KEY = registerKey("duriantree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> FIGTREE_KEY = registerKey("figtree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> FIGTREE_SPAWN_KEY = registerKey("figtree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> GRAPEFRUITTREE_KEY = registerKey("grapefruittree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> GRAPEFRUITTREE_SPAWN_KEY = registerKey("grapefruittree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> LIMETREE_KEY = registerKey("limetree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> LIMETREE_SPAWN_KEY = registerKey("limetree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PAPAYATREE_KEY = registerKey("papayatree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PAPAYATREE_SPAWN_KEY = registerKey("papayatree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PECANTREE_KEY = registerKey("pecantree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PECANTREE_SPAWN_KEY = registerKey("pecantree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PERSIMMONTREE_KEY = registerKey("persimmontree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PERSIMMONTREE_SPAWN_KEY = registerKey("persimmontree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PISTACHIOTREE_KEY = registerKey("pistachiotree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PISTACHIOTREE_SPAWN_KEY = registerKey("pistachiotree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> POMEGRANATETREE_KEY = registerKey("pomegranatetree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> POMEGRANATETREE_SPAWN_KEY = registerKey("pomegranatetree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> STARFRUITTREE_KEY = registerKey("starfruittree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> STARFRUITTREE_SPAWN_KEY = registerKey("starfruittree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> BREADFRUITTREE_KEY = registerKey("breadfruittree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> BREADFRUITTREE_SPAWN_KEY = registerKey("breadfruittree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> GUAVATREE_KEY = registerKey("guavatree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> GUAVATREE_SPAWN_KEY = registerKey("guavatree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> JACKFRUITTREE_KEY = registerKey("jackfruittree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> JACKFRUITTREE_SPAWN_KEY = registerKey("jackfruittree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> LYCHEETREE_KEY = registerKey("lycheetree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> LYCHEETREE_SPAWN_KEY = registerKey("lycheetree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PASSIONFRUITTREE_KEY = registerKey("passionfruittree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PASSIONFRUITTREE_SPAWN_KEY = registerKey("passionfruittree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> RAMBUTANTREE_KEY = registerKey("rambutantree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> RAMBUTANTREE_SPAWN_KEY = registerKey("rambutantree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> TAMARINDTREE_KEY = registerKey("tamarindtree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> TAMARINDTREE_SPAWN_KEY = registerKey("tamarindtree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> MAPLETREE_KEY = registerKey("mapletree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> MAPLETREE_SPAWN_KEY = registerKey("mapletree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PEPPERCORNTREE_KEY = registerKey("peppercorntree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PEPPERCORNTREE_SPAWN_KEY = registerKey("peppercorntree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> VANILLABEANTREE_KEY = registerKey("vanillabeantree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> VANILLABEANTREE_SPAWN_KEY = registerKey("vanillabeantree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> PINENUTTREE_KEY = registerKey("pinenuttree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PINENUTTREE_SPAWN_KEY = registerKey("pinenuttree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> GOOSEBERRYTREE_KEY = registerKey("gooseberrytree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> GOOSEBERRYTREE_SPAWN_KEY = registerKey("gooseberrytree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> GRAPETREE_KEY = registerKey("grapetree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> GRAPETREE_SPAWN_KEY = registerKey("grapetree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> RED_GRAPETREE_KEY = registerKey("red_grapetree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> RED_GRAPETREE_SPAWN_KEY = registerKey("red_grapetree_spawn");
    public static final RegistryKey<ConfiguredFeature<?,?>> KIWITREE_KEY = registerKey("kiwitree_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> KIWITREE_SPAWN_KEY = registerKey("kiwitree_spawn");



    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        //register(context, KEY, );

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldSaltOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SALT_ORE.getDefaultState()));

        register(context, SALT_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSaltOres, 16)); //size: vein size??? default: 9
        //size is basically, how many ores per started generation?


        register(context, FLORAMELISSIA_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLORAMELISSIA)))));


        register(context, DECO_ROCKS_RANDOM_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.DECORATION_ROCKS_RANDOM)))));

        register(context, DECO_STICKS_RANDOM_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.DECORATION_STICKS_RANDOM)))));

        register(context, DECO_BEACHGRASS_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BEACHGRASS)))));


        register(context, DECO_TALL_BEACHGRASS_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(25, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TALL_BEACHGRASS)))));

        register(context, DECO_SEASHELL_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.DECORATION_SEASHELL)))));



        register(context, BLUEBERRYBUSH_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBERRY_BUSH.getDefaultState().with(BlueberryBush.AGE, 3))))));
        register(context, BLACKBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLACKBERRY_BUSH.getDefaultState().with(BlackberryBush.AGE, 3))))));
        register(context, RASPBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RASPBERRY_BUSH.getDefaultState().with(RaspberryBush.AGE, 3))))));
        register(context, CLOUDBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CLOUDBERRY_BUSH.getDefaultState().with(CloudberryBush.AGE, 3))))));
        register(context, WILDSTRAWBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WILD_STRAWBERRY_BUSH.getDefaultState().with(Wild_StrawberryBush.AGE, 3))))));
        register(context, CANDLEBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CANDLEBERRY_BUSH.getDefaultState().with(CandleberryBush.AGE, 3))))));
        register(context, CRANBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CRANBERRY_BUSH.getDefaultState().with(CranberryBush.AGE, 3))))));
        register(context, HUCKLEBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HUCKLEBERRY_BUSH.getDefaultState().with(HuckleberryBush.AGE, 3))))));
        register(context, JUNIPERBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.JUNIPERBERRY_BUSH.getDefaultState().with(JuniperberryBush.AGE, 3))))));
        register(context, MULBERRY_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MULBERRY_BUSH.getDefaultState().with(MulberryBush.AGE, 3))))));


        //chance to spawn tree's
        float spawnChance = 0.05f; //5%


        register(context, APPLETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.APPLETREE_LOG), //int baseHeight, int firstRandomHeight, int secondRandomHeight, IntProvider extraBranchSteps, float placeBranchPerLogProbability, IntProvider extraBranchLength, RegistryEntryList<Block> canGrowThrough
                new LargeOakTrunkPlacer(7, 2, 1),
                BlockStateProvider.of(ModBlocks.APPLETREE_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(3), 3),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(6))).ignoreVines().decorators(Collections.singletonList(AppleTreeDecorator.INSTANCE)).build());

        register(context, APPLETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.APPLETREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.APPLETREE_CHECKED_KEY)));




        register(context, BANANATREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BANANATREE_LOG),
                new BendingTrunkPlacer(4, 1, 1, 7, ConstantIntProvider.create(1)), //4117
                BlockStateProvider.of(ModBlocks.BANANATREE_LEAVES),
                new JungleFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), 3),//112
                //new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(BananaTreeDecorator.INSTANCE)).ignoreVines().build());
                new TwoLayersFeatureSize(1, 0, 2)).decorators(ImmutableList.of(BananaTreeDecorator.INSTANCE, TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25F))).ignoreVines().build());


        //.decorators(ImmutableList.of(
        // new CocoaBeansTreeDecorator(0.2F),
        // TrunkVineTreeDecorator.INSTANCE,
        // new LeavesVineTreeDecorator(0.25F)
        // )).ignoreVines().build());

        register(context, BANANATREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.BANANATREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.BANANATREE_CHECKED_KEY)));




        register(context, CINNAMONTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CINNAMON_LOG),
                new StraightTrunkPlacer(5, 6, 3),//5,6,3
                BlockStateProvider.of(ModBlocks.CINNAMON_LEAVES),
                new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), ConstantIntProvider.create(3)),//204
                new TwoLayersFeatureSize(2, 1, 4)).build());

        register(context, CINNAMONTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CINNAMONTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CINNAMONTREE_CHECKED_KEY)));





        register(context, ORANGETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ORANGETREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.ORANGETREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(OrangeTreeDecorator.INSTANCE)).build());

        register(context, ORANGETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.ORANGETREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.ORANGETREE_CHECKED_KEY)));





        register(context, PEARTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PEARTREE_LOG),
                new LargeOakTrunkPlacer(7, 2, 1),
                BlockStateProvider.of(ModBlocks.PEARTREE_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(3), 3),
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PearTreeDecorator.INSTANCE)).build());

        register(context, PEARTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PEARTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PEARTREE_CHECKED_KEY)));







        register(context, COCONUTTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.COCONUTTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.COCONUTTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(CoconutTreeDecorator.INSTANCE)).build());

        register(context, COCONUTTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.COCONUTTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.COCONUTTREE_CHECKED_KEY)));






        register(context, AVOCADOTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.AVOCADOTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.AVOCADOTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(AvocadoTreeDecorator.INSTANCE)).build());

        register(context, AVOCADOTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.AVOCADOTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.AVOCADOTREE_CHECKED_KEY)));






        register(context, CHERRYTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CHERRYTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.CHERRYTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(CherryTreeDecorator.INSTANCE)).build());

        register(context, CHERRYTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CHERRYTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CHERRYTREE_CHECKED_KEY)));





        register(context, LEMONTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.LEMONTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.LEMONTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(LemonTreeDecorator.INSTANCE)).build());

        register(context, LEMONTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.LEMONTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.LEMONTREE_CHECKED_KEY)));







        register(context, MANGOTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MANGOTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.MANGOTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(MangoTreeDecorator.INSTANCE)).build());

        register(context, MANGOTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.MANGOTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.MANGOTREE_CHECKED_KEY)));






        register(context, OLIVETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.OLIVETREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.OLIVETREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(OliveTreeDecorator.INSTANCE)).build());

        register(context, OLIVETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.OLIVETREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.OLIVETREE_CHECKED_KEY)));






        register(context, RUBBERTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.RUBBERTREE_LOG),
                new StraightTrunkPlacer(6, 1, 1),//5,6,3
                BlockStateProvider.of(ModBlocks.RUBBERTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//204
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, RUBBERTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.RUBBERTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.RUBBERTREE_CHECKED_KEY)));










        register(context, CANDLENUTTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CANDLENUTTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.CANDLENUTTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(CandlenutTreeDecorator.INSTANCE)).build());

        register(context, CANDLENUTTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CANDLENUTTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CANDLENUTTREE_CHECKED_KEY)));

        register(context, CHESTNUTTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CHESTNUTTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.CHESTNUTTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(ChestnutTreeDecorator.INSTANCE)).build());

        register(context, CHESTNUTTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CHESTNUTTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CHESTNUTTREE_CHECKED_KEY)));

        register(context, NUTMEGTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.NUTMEGTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.NUTMEGTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(NutmegTreeDecorator.INSTANCE)).build());

        register(context, NUTMEGTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.NUTMEGTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.NUTMEGTREE_CHECKED_KEY)));

        register(context, PEACHTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PEACHTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.PEACHTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PeachTreeDecorator.INSTANCE)).build());

        register(context, PEACHTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PEACHTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PEACHTREE_CHECKED_KEY)));

        register(context, PLUMTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PLUMTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.PLUMTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PlumTreeDecorator.INSTANCE)).build());

        register(context, PLUMTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PLUMTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PLUMTREE_CHECKED_KEY)));

        register(context, WALNUTTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.WALNUTTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.WALNUTTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(WalnutTreeDecorator.INSTANCE)).build());

        register(context, WALNUTTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.WALNUTTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.WALNUTTREE_CHECKED_KEY)));

        register(context, HAZELNUTTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.HAZELNUTTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.HAZELNUTTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(HazelnutTreeDecorator.INSTANCE)).build());

        register(context, HAZELNUTTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.HAZELNUTTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.HAZELNUTTREE_CHECKED_KEY)));

        register(context, PAWPAWTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PAWPAWTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.PAWPAWTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PawpawTreeDecorator.INSTANCE)).build());

        register(context, PAWPAWTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PAWPAWTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PAWPAWTREE_CHECKED_KEY)));

        register(context, SOURSOPTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SOURSOPTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.SOURSOPTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(SoursopTreeDecorator.INSTANCE)).build());

        register(context, SOURSOPTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.SOURSOPTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.SOURSOPTREE_CHECKED_KEY)));

        register(context, ALMONDTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ALMONDTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.ALMONDTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(AlmondTreeDecorator.INSTANCE)).build());

        register(context, ALMONDTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.ALMONDTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.ALMONDTREE_CHECKED_KEY)));

        register(context, APRICOTTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.APRICOTTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.APRICOTTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(ApricotTreeDecorator.INSTANCE)).build());

        register(context, APRICOTTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.APRICOTTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.APRICOTTREE_CHECKED_KEY)));

        register(context, CASHEWTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CASHEWTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.CASHEWTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(CashewTreeDecorator.INSTANCE)).build());

        register(context, CASHEWTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CASHEWTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CASHEWTREE_CHECKED_KEY)));

        register(context, DATETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DATETREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.DATETREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(DateTreeDecorator.INSTANCE)).build());

        register(context, DATETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.DATETREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.DATETREE_CHECKED_KEY)));

        register(context, DRAGONFRUITTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DRAGONFRUITTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.DRAGONFRUITTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(DragonfruitTreeDecorator.INSTANCE)).build());

        register(context, DRAGONFRUITTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.DRAGONFRUITTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.DRAGONFRUITTREE_CHECKED_KEY)));

        register(context, DURIANTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DURIANTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.DURIANTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(DurianTreeDecorator.INSTANCE)).build());

        register(context, DURIANTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.DURIANTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.DURIANTREE_CHECKED_KEY)));

        register(context, FIGTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.FIGTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.FIGTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(FigTreeDecorator.INSTANCE)).build());

        register(context, FIGTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.FIGTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.FIGTREE_CHECKED_KEY)));

        register(context, GRAPEFRUITTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.GRAPEFRUITTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.GRAPEFRUITTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(GrapefruitTreeDecorator.INSTANCE)).build());

        register(context, GRAPEFRUITTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.GRAPEFRUITTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.GRAPEFRUITTREE_CHECKED_KEY)));

        register(context, LIMETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.LIMETREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.LIMETREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(LimeTreeDecorator.INSTANCE)).build());

        register(context, LIMETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.LIMETREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.LIMETREE_CHECKED_KEY)));

        register(context, PAPAYATREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PAPAYATREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.PAPAYATREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PapayaTreeDecorator.INSTANCE)).build());

        register(context, PAPAYATREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PAPAYATREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PAPAYATREE_CHECKED_KEY)));

        register(context, PECANTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PECANTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.PECANTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PecanTreeDecorator.INSTANCE)).build());

        register(context, PECANTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PECANTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PECANTREE_CHECKED_KEY)));

        register(context, PERSIMMONTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PERSIMMONTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.PERSIMMONTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PersimmonTreeDecorator.INSTANCE)).build());

        register(context, PERSIMMONTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PERSIMMONTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PERSIMMONTREE_CHECKED_KEY)));

        register(context, PISTACHIOTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PISTACHIOTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.PISTACHIOTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PistachioTreeDecorator.INSTANCE)).build());

        register(context, PISTACHIOTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PISTACHIOTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PISTACHIOTREE_CHECKED_KEY)));

        register(context, POMEGRANATETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.POMEGRANATETREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.POMEGRANATETREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PomegranateTreeDecorator.INSTANCE)).build());

        register(context, POMEGRANATETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.POMEGRANATETREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.POMEGRANATETREE_CHECKED_KEY)));

        register(context, STARFRUITTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.STARFRUITTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.STARFRUITTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(StarfruitTreeDecorator.INSTANCE)).build());

        register(context, STARFRUITTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.STARFRUITTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.STARFRUITTREE_CHECKED_KEY)));

        register(context, BREADFRUITTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BREADFRUITTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.BREADFRUITTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(BreadfruitTreeDecorator.INSTANCE)).build());

        register(context, BREADFRUITTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.BREADFRUITTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.BREADFRUITTREE_CHECKED_KEY)));

        register(context, GUAVATREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.GUAVATREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.GUAVATREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(GuavaTreeDecorator.INSTANCE)).build());

        register(context, GUAVATREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.GUAVATREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.GUAVATREE_CHECKED_KEY)));

        register(context, JACKFRUITTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.JACKFRUITTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.JACKFRUITTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(JackfruitTreeDecorator.INSTANCE)).build());

        register(context, JACKFRUITTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.JACKFRUITTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.JACKFRUITTREE_CHECKED_KEY)));

        register(context, LYCHEETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.LYCHEETREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.LYCHEETREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(LycheeTreeDecorator.INSTANCE)).build());

        register(context, LYCHEETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.LYCHEETREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.LYCHEETREE_CHECKED_KEY)));

        register(context, PASSIONFRUITTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PASSIONFRUITTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.PASSIONFRUITTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PassionfruitTreeDecorator.INSTANCE)).build());

        register(context, PASSIONFRUITTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PASSIONFRUITTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PASSIONFRUITTREE_CHECKED_KEY)));

        register(context, RAMBUTANTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.RAMBUTANTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.RAMBUTANTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(RambutanTreeDecorator.INSTANCE)).build());

        register(context, RAMBUTANTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.RAMBUTANTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.RAMBUTANTREE_CHECKED_KEY)));

        register(context, TAMARINDTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.TAMARINDTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.TAMARINDTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(TamarindTreeDecorator.INSTANCE)).build());

        register(context, TAMARINDTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.TAMARINDTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.TAMARINDTREE_CHECKED_KEY)));

















        /*register(context, MAPLETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLETREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.MAPLETREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).build());*/

        register(context, MAPLETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLETREE_LOG),
                new LargeOakTrunkPlacer(3, 11, 0), //3,4,2
                BlockStateProvider.of(ModBlocks.MAPLETREE_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),//3
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        register(context, MAPLETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.MAPLETREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.MAPLETREE_CHECKED_KEY)));

        register(context, PEPPERCORNTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PEPPERCORNTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.PEPPERCORNTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PeppercornTreeDecorator.INSTANCE)).build());

        register(context, PEPPERCORNTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PEPPERCORNTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PEPPERCORNTREE_CHECKED_KEY)));

        register(context, VANILLABEANTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.VANILLABEANTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.VANILLABEANTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(VanillabeanTreeDecorator.INSTANCE)).build());

        register(context, VANILLABEANTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.VANILLABEANTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.VANILLABEANTREE_CHECKED_KEY)));

        register(context, PINENUTTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PINENUTTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.PINENUTTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(PinenutTreeDecorator.INSTANCE)).build());

        register(context, PINENUTTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PINENUTTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.PINENUTTREE_CHECKED_KEY)));

        register(context, GOOSEBERRYTREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.GOOSEBERRYTREE_LOG),
                new StraightTrunkPlacer(4, 1, 1), //3,4,2
                BlockStateProvider.of(ModBlocks.GOOSEBERRYTREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),//3
                new TwoLayersFeatureSize(1, 0, 2)).decorators(Collections.singletonList(GooseberryTreeDecorator.INSTANCE)).build());

        register(context, GOOSEBERRYTREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.GOOSEBERRYTREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.GOOSEBERRYTREE_CHECKED_KEY)));

        register(context, GRAPETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.GRAPETREE_LOG),
                new StraightTrunkPlacer(3, 0, 0), //3,4,2
                BlockStateProvider.of(ModBlocks.GRAPETREE_LEAVES),
                new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), 2),//3
                new TwoLayersFeatureSize(2, 2, 3)).decorators(Collections.singletonList(GrapeTreeDecorator.INSTANCE)).build());

        register(context, GRAPETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.GRAPETREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.GRAPETREE_CHECKED_KEY)));






        register(context, RED_GRAPETREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.RED_GRAPETREE_LOG),
                new StraightTrunkPlacer(3, 0, 0), //3,4,2
                BlockStateProvider.of(ModBlocks.RED_GRAPETREE_LEAVES),
                new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), 2),//3
                new TwoLayersFeatureSize(2, 2, 3)).decorators(Collections.singletonList(RedGrapeTreeDecorator.INSTANCE)).build());

        register(context, RED_GRAPETREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.RED_GRAPETREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.RED_GRAPETREE_CHECKED_KEY)));







        register(context, KIWITREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.KIWITREE_LOG),
                new StraightTrunkPlacer(3, 0, 0), //3,4,2
                BlockStateProvider.of(ModBlocks.KIWITREE_LEAVES),
                new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), 2),//radius, offset, height
                new TwoLayersFeatureSize(2, 2, 3)).decorators(Collections.singletonList(KiwiTreeDecorator.INSTANCE)).build());

        register(context, KIWITREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.KIWITREE_CHECKED_KEY),
                        spawnChance)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.KIWITREE_CHECKED_KEY)));


















    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Photosynthesis.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}