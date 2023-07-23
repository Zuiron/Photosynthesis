package net.zuiron.photosynthesis.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.berrybushblocks.*;
import net.zuiron.photosynthesis.block.bushtreecrops.*;
import net.zuiron.photosynthesis.block.cropblocks.CustomCropBlock;
import net.zuiron.photosynthesis.block.cropblocks.CustomCropBlockWL;
import net.zuiron.photosynthesis.block.custom.*;
import net.zuiron.photosynthesis.block.decoration.*;
import net.zuiron.photosynthesis.item.ModItemGroup;
import net.zuiron.photosynthesis.world.feature.tree.*;

public class ModBlocks {

    // DECORATION ------------------------------------------------------------------------------------------------------
    public static final Block DECORATION_ROCKS_RANDOM = registerBlockWithoutBlockItem("decoration_rocks_random",
            new DecoRocksBlock(StatusEffect.byRawId(1), 1,FabricBlockSettings.copy(Blocks.GRAVEL).nonOpaque().noCollision().breakInstantly().noBlockBreakParticles()));
    public static final Block DECORATION_STICKS_RANDOM = registerBlockWithoutBlockItem("decoration_sticks_random",
            new DecoSticksBlock(StatusEffect.byRawId(1), 1,FabricBlockSettings.copy(Blocks.BAMBOO).nonOpaque().noCollision().breakInstantly().noBlockBreakParticles()));
    public static final Block TALL_BEACHGRASS = registerBlock("tall_beachgrass",
            new TallBeachGrassBlock(AbstractBlock.Settings.copy(Blocks.TALL_GRASS).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)));
    public static final Block BEACHGRASS = registerBlock("beachgrass",
            new BeachGrassBlock(AbstractBlock.Settings.copy(Blocks.GRASS).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ)));
    public static final Block DECORATION_SEASHELL = registerBlockWithoutBlockItem("decoration_seashell",
            new DecoSeaShellBlock(StatusEffect.byRawId(1), 1,FabricBlockSettings.copy(Blocks.SAND).nonOpaque().noCollision().breakInstantly().noBlockBreakParticles()));

    // FLOWERS ---------------------------------------------------------------------------------------------------------
    public static final Block FLORAMELISSIA = registerBlock("floramelissia",
            new FlowerBlock(StatusEffect.byRawId(1), 1, FabricBlockSettings.copy(Blocks.POTTED_POPPY).nonOpaque().noCollision()));

    public static final Block POTTED_FLORAMELISSIA = registerBlockWithoutBlockItem("potted_floramelissia",
            new FlowerPotBlock(ModBlocks.FLORAMELISSIA, FabricBlockSettings.copy(Blocks.POTTED_POPPY).nonOpaque()));

    // ORES
    public static final Block SALT_ORE = registerBlock("salt_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f).requiresTool(),
                    UniformIntProvider.create(1, 2)));

    // "Machines"
    public static final Block SKILLET = registerBlock("skillet",
            new SkilletBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block MIXING_BOWL = registerBlock("mixing_bowl",
            new MixingBowlBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block KEG = registerBlock("keg",
            new KegBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block FLUID_PRESS = registerBlock("fluid_press",
            new FluidPressBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block MILKSEPERATOR = registerBlock("milk_seperator",
            new MilkSeperatorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block COOKINGPOT = registerBlock("cooking_pot",
            new CookingPotBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block CUTTINGBOARD = registerBlock("cutting_board",
            new CuttingBoardBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block MORTAR = registerBlock("mortar",
            new MortarBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block DRYINGNET = registerBlock("dryingnet",
            new DryingNetBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block DRYINGRACK = registerBlock("dryingrack",
            new DryingRackBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block LATEX_EXTRACTOR = registerBlock("latex_extractor",
            new LatexExtractorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block MAPLE_EXTRACTOR = registerBlock("maple_extractor",
            new MapleExtractorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block PLATE = registerBlock("plate",
            new PlateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block TOOLRACK = registerBlock("toolrack",
            new ToolRackBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));

    public static final Block SHELF = registerBlock("shelf",
            new ShelfBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .strength(2f).nonOpaque()));


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
    //public static final CropBlock BLACK_PEPPER_CROP = registerCropBlockSimple("black_pepper_crop");
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
    //public static final CropBlock GRAPE_CROP = registerCropBlockSimple("grape_crop");
    public static final CropBlock PARSLEY_CROP = registerCropBlockSimple("parsley_crop");
    public static final CropBlock MINT_CROP = registerCropBlockSimple("mint_crop");
    public static final CropBlock PINEAPPLE_CROP = registerCropBlockSimple("pineapple_crop");
    public static final CropBlock HOP_CROP = registerCropBlockSimple("hop_crop");
    public static final CropBlock FILIPENDULA_CROP = registerCropBlockSimple("filipendula_crop");

    //new
    public static final CropBlock CACTUS_FRUIT_CROP = registerCropBlockSimple("cactus_fruit_crop");
    public static final CropBlock CANTALOUPE_CROP = registerCropBlockSimple("cantaloupe_crop");
    public static final CropBlock FLAX_CROP = registerCropBlockSimple("flax_crop");
    public static final CropBlock JUTE_CROP = registerCropBlockSimple("jute_crop");
    public static final CropBlock KENAF_CROP = registerCropBlockSimple("kenaf_crop");
    public static final CropBlock SISAL_CROP = registerCropBlockSimple("sisal_crop");
    public static final CropBlock AMARANTH_CROP = registerCropBlockSimple("amaranth_crop");
    public static final CropBlock BEAN_CROP = registerCropBlockSimple("bean_crop");
    public static final CropBlock CHICKPEA_CROP = registerCropBlockSimple("chickpea_crop");
    public static final CropBlock LENTIL_CROP = registerCropBlockSimple("lentil_crop");
    public static final CropBlock QUINOA_CROP = registerCropBlockSimple("quinoa_crop");
    public static final CropBlock PEANUT_CROP = registerCropBlockSimple("peanut_crop");
    public static final CropBlock TARO_CROP = registerCropBlockSimple("taro_crop");
    public static final CropBlock TOMATILLO_CROP = registerCropBlockSimple("tomatillo_crop");
    public static final CropBlock AGAVE_CROP = registerCropBlockSimple("agave_crop");
    public static final CropBlock GINGER_CROP = registerCropBlockSimple("ginger_crop");
    public static final CropBlock SESAME_CROP = registerCropBlockSimple("sesame_crop");
    public static final CropBlock MUSTARD_CROP = registerCropBlockSimple("mustard_crop");


    public static final CropBlock CAMELLIA_SINENSIS_CROP = registerCropBlockSimple("camellia_sinensis_crop");
    public static final CropBlock NICOTIANA_RUSTICA_CROP = registerCropBlockSimple("nicotiana_rustica_crop");
    public static final CropBlock PAPAVER_SOMNIFERUM_CROP = registerCropBlockSimple("papaver_somniferum_crop");
    public static final CropBlock ERYTHROXYLUM_COCA_CROP = registerCropBlockSimple("erythroxylum_coca_crop");


    // TREE's ----------------------------------------------------------------------------------------------------------
    public static final Block APPLETREE_LOG = registerBlock("appletree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block APPLETREE_WOOD = registerBlock("appletree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_APPLETREE_LOG = registerBlock("stripped_appletree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_APPLETREE_WOOD = registerBlock("stripped_appletree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block APPLETREE_PLANKS = registerBlock("appletree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block APPLETREE_LEAVES = registerBlock("appletree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block APPLETREE_SAPLING = registerBlock("appletree_sapling",
            new SaplingBlock(new AppletreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock APPLETREE_BUSHCROP = registerBushBlock("appletree_bushcrop",
            new AppletreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));




    public static final Block BANANATREE_LOG = registerBlock("bananatree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block BANANATREE_WOOD = registerBlock("bananatree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_BANANATREE_LOG = registerBlock("stripped_bananatree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_BANANATREE_WOOD = registerBlock("stripped_bananatree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block BANANATREE_PLANKS = registerBlock("bananatree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block BANANATREE_LEAVES = registerBlock("bananatree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block BANANATREE_SAPLING = registerBlock("bananatree_sapling",
            new SaplingBlock(new BananatreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock BANANATREE_BUSHCROP = registerBushBlock("bananatree_bushcrop",
            new BananatreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));




    public static final Block CINNAMON_LOG = registerBlock("cinnamon_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CINNAMON_WOOD = registerBlock("cinnamon_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_CINNAMON_LOG = registerBlock("stripped_cinnamon_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_CINNAMON_WOOD = registerBlock("stripped_cinnamon_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block CINNAMON_PLANKS = registerBlock("cinnamon_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CINNAMON_LEAVES = registerBlock("cinnamon_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.AZALEA_LEAVES)));

    public static final Block CINNAMON_SAPLING = registerBlock("cinnamon_sapling",
            new SaplingBlock(new CinnamonSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));





    public static final Block ORANGETREE_LOG = registerBlock("orangetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block ORANGETREE_WOOD = registerBlock("orangetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_ORANGETREE_LOG = registerBlock("stripped_orangetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_ORANGETREE_WOOD = registerBlock("stripped_orangetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block ORANGETREE_PLANKS = registerBlock("orangetree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block ORANGETREE_LEAVES = registerBlock("orangetree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block ORANGETREE_SAPLING = registerBlock("orangetree_sapling",
            new SaplingBlock(new OrangetreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock ORANGETREE_BUSHCROP = registerBushBlock("orangetree_bushcrop",
            new OrangetreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));





    public static final Block PEARTREE_LOG = registerBlock("peartree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PEARTREE_WOOD = registerBlock("peartree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PEARTREE_LOG = registerBlock("stripped_peartree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PEARTREE_WOOD = registerBlock("stripped_peartree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PEARTREE_PLANKS = registerBlock("peartree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block PEARTREE_LEAVES = registerBlock("peartree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PEARTREE_SAPLING = registerBlock("peartree_sapling",
            new SaplingBlock(new PeartreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PEARTREE_BUSHCROP = registerBushBlock("peartree_bushcrop",
            new PeartreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));







    public static final Block COCONUTTREE_LOG = registerBlock("coconuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block COCONUTTREE_WOOD = registerBlock("coconuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_COCONUTTREE_LOG = registerBlock("stripped_coconuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_COCONUTTREE_WOOD = registerBlock("stripped_coconuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block COCONUTTREE_PLANKS = registerBlock("coconuttree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block COCONUTTREE_LEAVES = registerBlock("coconuttree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block COCONUTTREE_SAPLING = registerBlock("coconuttree_sapling",
            new SaplingBlock(new CoconuttreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock COCONUTTREE_BUSHCROP = registerBushBlock("coconuttree_bushcrop",
            new CoconuttreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));







    public static final Block AVOCADOTREE_LOG = registerBlock("avocadotree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block AVOCADOTREE_WOOD = registerBlock("avocadotree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_AVOCADOTREE_LOG = registerBlock("stripped_avocadotree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_AVOCADOTREE_WOOD = registerBlock("stripped_avocadotree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block AVOCADOTREE_PLANKS = registerBlock("avocadotree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block AVOCADOTREE_LEAVES = registerBlock("avocadotree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block AVOCADOTREE_SAPLING = registerBlock("avocadotree_sapling",
            new SaplingBlock(new AvocadotreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock AVOCADOTREE_BUSHCROP = registerBushBlock("avocadotree_bushcrop",
            new AvocadotreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));







    public static final Block CHERRYTREE_LOG = registerBlock("cherrytree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CHERRYTREE_WOOD = registerBlock("cherrytree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_CHERRYTREE_LOG = registerBlock("stripped_cherrytree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_CHERRYTREE_WOOD = registerBlock("stripped_cherrytree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block CHERRYTREE_PLANKS = registerBlock("cherrytree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block CHERRYTREE_LEAVES = registerBlock("cherrytree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block CHERRYTREE_SAPLING = registerBlock("cherrytree_sapling",
            new SaplingBlock(new CherrytreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock CHERRYTREE_BUSHCROP = registerBushBlock("cherrytree_bushcrop",
            new CherrytreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));






    public static final Block LEMONTREE_LOG = registerBlock("lemontree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block LEMONTREE_WOOD = registerBlock("lemontree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_LEMONTREE_LOG = registerBlock("stripped_lemontree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_LEMONTREE_WOOD = registerBlock("stripped_lemontree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block LEMONTREE_PLANKS = registerBlock("lemontree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block LEMONTREE_LEAVES = registerBlock("lemontree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block LEMONTREE_SAPLING = registerBlock("lemontree_sapling",
            new SaplingBlock(new LemontreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock LEMONTREE_BUSHCROP = registerBushBlock("lemontree_bushcrop",
            new LemontreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));






    public static final Block MANGOTREE_LOG = registerBlock("mangotree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block MANGOTREE_WOOD = registerBlock("mangotree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_MANGOTREE_LOG = registerBlock("stripped_mangotree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_MANGOTREE_WOOD = registerBlock("stripped_mangotree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block MANGOTREE_PLANKS = registerBlock("mangotree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block MANGOTREE_LEAVES = registerBlock("mangotree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block MANGOTREE_SAPLING = registerBlock("mangotree_sapling",
            new SaplingBlock(new MangotreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock MANGOTREE_BUSHCROP = registerBushBlock("mangotree_bushcrop",
            new MangotreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));







    public static final Block OLIVETREE_LOG = registerBlock("olivetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block OLIVETREE_WOOD = registerBlock("olivetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_OLIVETREE_LOG = registerBlock("stripped_olivetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_OLIVETREE_WOOD = registerBlock("stripped_olivetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block OLIVETREE_PLANKS = registerBlock("olivetree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block OLIVETREE_LEAVES = registerBlock("olivetree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block OLIVETREE_SAPLING = registerBlock("olivetree_sapling",
            new SaplingBlock(new OlivetreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock OLIVETREE_BUSHCROP = registerBushBlock("olivetree_bushcrop",
            new OlivetreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));









    public static final Block RUBBERTREE_LOG = registerBlock("rubbertree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block RUBBERTREE_WOOD = registerBlock("rubbertree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_RUBBERTREE_LOG = registerBlock("stripped_rubbertree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_RUBBERTREE_WOOD = registerBlock("stripped_rubbertree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block RUBBERTREE_PLANKS = registerBlock("rubbertree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block RUBBERTREE_LEAVES = registerBlock("rubbertree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block RUBBERTREE_SAPLING = registerBlock("rubbertree_sapling",
            new SaplingBlock(new RubbertreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));




















    public static final Block CANDLENUTTREE_LOG = registerBlock("candlenuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CANDLENUTTREE_WOOD = registerBlock("candlenuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_CANDLENUTTREE_LOG = registerBlock("stripped_candlenuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_CANDLENUTTREE_WOOD = registerBlock("stripped_candlenuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block CANDLENUTTREE_PLANKS = registerBlock("candlenuttree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CANDLENUTTREE_LEAVES = registerBlock("candlenuttree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block CANDLENUTTREE_SAPLING = registerBlock("candlenuttree_sapling",
            new SaplingBlock(new CandlenuttreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock CANDLENUTTREE_BUSHCROP = registerBushBlock("candlenuttree_bushcrop",
            new CandlenuttreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block CHESTNUTTREE_LOG = registerBlock("chestnuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CHESTNUTTREE_WOOD = registerBlock("chestnuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_CHESTNUTTREE_LOG = registerBlock("stripped_chestnuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_CHESTNUTTREE_WOOD = registerBlock("stripped_chestnuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block CHESTNUTTREE_PLANKS = registerBlock("chestnuttree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CHESTNUTTREE_LEAVES = registerBlock("chestnuttree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block CHESTNUTTREE_SAPLING = registerBlock("chestnuttree_sapling",
            new SaplingBlock(new ChestnuttreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock CHESTNUTTREE_BUSHCROP = registerBushBlock("chestnuttree_bushcrop",
            new ChestnuttreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block NUTMEGTREE_LOG = registerBlock("nutmegtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block NUTMEGTREE_WOOD = registerBlock("nutmegtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_NUTMEGTREE_LOG = registerBlock("stripped_nutmegtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_NUTMEGTREE_WOOD = registerBlock("stripped_nutmegtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block NUTMEGTREE_PLANKS = registerBlock("nutmegtree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block NUTMEGTREE_LEAVES = registerBlock("nutmegtree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block NUTMEGTREE_SAPLING = registerBlock("nutmegtree_sapling",
            new SaplingBlock(new NutmegtreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock NUTMEGTREE_BUSHCROP = registerBushBlock("nutmegtree_bushcrop",
            new NutmegtreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block PEACHTREE_LOG = registerBlock("peachtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PEACHTREE_WOOD = registerBlock("peachtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PEACHTREE_LOG = registerBlock("stripped_peachtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PEACHTREE_WOOD = registerBlock("stripped_peachtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PEACHTREE_PLANKS = registerBlock("peachtree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PEACHTREE_LEAVES = registerBlock("peachtree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PEACHTREE_SAPLING = registerBlock("peachtree_sapling",
            new SaplingBlock(new PeachtreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PEACHTREE_BUSHCROP = registerBushBlock("peachtree_bushcrop",
            new PeachtreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block PLUMTREE_LOG = registerBlock("plumtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PLUMTREE_WOOD = registerBlock("plumtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PLUMTREE_LOG = registerBlock("stripped_plumtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PLUMTREE_WOOD = registerBlock("stripped_plumtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PLUMTREE_PLANKS = registerBlock("plumtree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PLUMTREE_LEAVES = registerBlock("plumtree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PLUMTREE_SAPLING = registerBlock("plumtree_sapling",
            new SaplingBlock(new PlumtreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PLUMTREE_BUSHCROP = registerBushBlock("plumtree_bushcrop",
            new PlumtreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block WALNUTTREE_LOG = registerBlock("walnuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block WALNUTTREE_WOOD = registerBlock("walnuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_WALNUTTREE_LOG = registerBlock("stripped_walnuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_WALNUTTREE_WOOD = registerBlock("stripped_walnuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block WALNUTTREE_PLANKS = registerBlock("walnuttree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block WALNUTTREE_LEAVES = registerBlock("walnuttree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block WALNUTTREE_SAPLING = registerBlock("walnuttree_sapling",
            new SaplingBlock(new WalnuttreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock WALNUTTREE_BUSHCROP = registerBushBlock("walnuttree_bushcrop",
            new WalnuttreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block HAZELNUTTREE_LOG = registerBlock("hazelnuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block HAZELNUTTREE_WOOD = registerBlock("hazelnuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_HAZELNUTTREE_LOG = registerBlock("stripped_hazelnuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_HAZELNUTTREE_WOOD = registerBlock("stripped_hazelnuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block HAZELNUTTREE_PLANKS = registerBlock("hazelnuttree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block HAZELNUTTREE_LEAVES = registerBlock("hazelnuttree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block HAZELNUTTREE_SAPLING = registerBlock("hazelnuttree_sapling",
            new SaplingBlock(new HazelnuttreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock HAZELNUTTREE_BUSHCROP = registerBushBlock("hazelnuttree_bushcrop",
            new HazelnuttreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block PAWPAWTREE_LOG = registerBlock("pawpawtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PAWPAWTREE_WOOD = registerBlock("pawpawtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PAWPAWTREE_LOG = registerBlock("stripped_pawpawtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PAWPAWTREE_WOOD = registerBlock("stripped_pawpawtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PAWPAWTREE_PLANKS = registerBlock("pawpawtree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PAWPAWTREE_LEAVES = registerBlock("pawpawtree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PAWPAWTREE_SAPLING = registerBlock("pawpawtree_sapling",
            new SaplingBlock(new PawpawtreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PAWPAWTREE_BUSHCROP = registerBushBlock("pawpawtree_bushcrop",
            new PawpawtreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block SOURSOPTREE_LOG = registerBlock("soursoptree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block SOURSOPTREE_WOOD = registerBlock("soursoptree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_SOURSOPTREE_LOG = registerBlock("stripped_soursoptree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_SOURSOPTREE_WOOD = registerBlock("stripped_soursoptree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block SOURSOPTREE_PLANKS = registerBlock("soursoptree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SOURSOPTREE_LEAVES = registerBlock("soursoptree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block SOURSOPTREE_SAPLING = registerBlock("soursoptree_sapling",
            new SaplingBlock(new SoursoptreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock SOURSOPTREE_BUSHCROP = registerBushBlock("soursoptree_bushcrop",
            new SoursoptreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block ALMONDTREE_LOG = registerBlock("almondtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block ALMONDTREE_WOOD = registerBlock("almondtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_ALMONDTREE_LOG = registerBlock("stripped_almondtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_ALMONDTREE_WOOD = registerBlock("stripped_almondtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block ALMONDTREE_PLANKS = registerBlock("almondtree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block ALMONDTREE_LEAVES = registerBlock("almondtree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block ALMONDTREE_SAPLING = registerBlock("almondtree_sapling",
            new SaplingBlock(new AlmondtreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock ALMONDTREE_BUSHCROP = registerBushBlock("almondtree_bushcrop",
            new AlmondtreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block APRICOTTREE_LOG = registerBlock("apricottree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block APRICOTTREE_WOOD = registerBlock("apricottree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_APRICOTTREE_LOG = registerBlock("stripped_apricottree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_APRICOTTREE_WOOD = registerBlock("stripped_apricottree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block APRICOTTREE_PLANKS = registerBlock("apricottree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block APRICOTTREE_LEAVES = registerBlock("apricottree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block APRICOTTREE_SAPLING = registerBlock("apricottree_sapling",
            new SaplingBlock(new ApricottreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock APRICOTTREE_BUSHCROP = registerBushBlock("apricottree_bushcrop",
            new ApricottreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block CASHEWTREE_LOG = registerBlock("cashewtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CASHEWTREE_WOOD = registerBlock("cashewtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_CASHEWTREE_LOG = registerBlock("stripped_cashewtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_CASHEWTREE_WOOD = registerBlock("stripped_cashewtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block CASHEWTREE_PLANKS = registerBlock("cashewtree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CASHEWTREE_LEAVES = registerBlock("cashewtree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block CASHEWTREE_SAPLING = registerBlock("cashewtree_sapling",
            new SaplingBlock(new CashewtreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock CASHEWTREE_BUSHCROP = registerBushBlock("cashewtree_bushcrop",
            new CashewtreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block DATETREE_LOG = registerBlock("datetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block DATETREE_WOOD = registerBlock("datetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_DATETREE_LOG = registerBlock("stripped_datetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_DATETREE_WOOD = registerBlock("stripped_datetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block DATETREE_PLANKS = registerBlock("datetree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block DATETREE_LEAVES = registerBlock("datetree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block DATETREE_SAPLING = registerBlock("datetree_sapling",
            new SaplingBlock(new DatetreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock DATETREE_BUSHCROP = registerBushBlock("datetree_bushcrop",
            new DatetreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block DRAGONFRUITTREE_LOG = registerBlock("dragonfruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block DRAGONFRUITTREE_WOOD = registerBlock("dragonfruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_DRAGONFRUITTREE_LOG = registerBlock("stripped_dragonfruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_DRAGONFRUITTREE_WOOD = registerBlock("stripped_dragonfruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block DRAGONFRUITTREE_PLANKS = registerBlock("dragonfruittree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block DRAGONFRUITTREE_LEAVES = registerBlock("dragonfruittree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block DRAGONFRUITTREE_SAPLING = registerBlock("dragonfruittree_sapling",
            new SaplingBlock(new DragonfruittreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock DRAGONFRUITTREE_BUSHCROP = registerBushBlock("dragonfruittree_bushcrop",
            new DragonfruittreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block DURIANTREE_LOG = registerBlock("duriantree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block DURIANTREE_WOOD = registerBlock("duriantree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_DURIANTREE_LOG = registerBlock("stripped_duriantree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_DURIANTREE_WOOD = registerBlock("stripped_duriantree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block DURIANTREE_PLANKS = registerBlock("duriantree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block DURIANTREE_LEAVES = registerBlock("duriantree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block DURIANTREE_SAPLING = registerBlock("duriantree_sapling",
            new SaplingBlock(new DuriantreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock DURIANTREE_BUSHCROP = registerBushBlock("duriantree_bushcrop",
            new DuriantreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block FIGTREE_LOG = registerBlock("figtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block FIGTREE_WOOD = registerBlock("figtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_FIGTREE_LOG = registerBlock("stripped_figtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_FIGTREE_WOOD = registerBlock("stripped_figtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block FIGTREE_PLANKS = registerBlock("figtree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block FIGTREE_LEAVES = registerBlock("figtree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block FIGTREE_SAPLING = registerBlock("figtree_sapling",
            new SaplingBlock(new FigtreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock FIGTREE_BUSHCROP = registerBushBlock("figtree_bushcrop",
            new FigtreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block GRAPEFRUITTREE_LOG = registerBlock("grapefruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block GRAPEFRUITTREE_WOOD = registerBlock("grapefruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_GRAPEFRUITTREE_LOG = registerBlock("stripped_grapefruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_GRAPEFRUITTREE_WOOD = registerBlock("stripped_grapefruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block GRAPEFRUITTREE_PLANKS = registerBlock("grapefruittree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block GRAPEFRUITTREE_LEAVES = registerBlock("grapefruittree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block GRAPEFRUITTREE_SAPLING = registerBlock("grapefruittree_sapling",
            new SaplingBlock(new GrapefruittreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock GRAPEFRUITTREE_BUSHCROP = registerBushBlock("grapefruittree_bushcrop",
            new GrapefruittreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block LIMETREE_LOG = registerBlock("limetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block LIMETREE_WOOD = registerBlock("limetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_LIMETREE_LOG = registerBlock("stripped_limetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_LIMETREE_WOOD = registerBlock("stripped_limetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block LIMETREE_PLANKS = registerBlock("limetree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block LIMETREE_LEAVES = registerBlock("limetree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block LIMETREE_SAPLING = registerBlock("limetree_sapling",
            new SaplingBlock(new LimetreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock LIMETREE_BUSHCROP = registerBushBlock("limetree_bushcrop",
            new LimetreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block PAPAYATREE_LOG = registerBlock("papayatree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PAPAYATREE_WOOD = registerBlock("papayatree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PAPAYATREE_LOG = registerBlock("stripped_papayatree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PAPAYATREE_WOOD = registerBlock("stripped_papayatree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PAPAYATREE_PLANKS = registerBlock("papayatree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PAPAYATREE_LEAVES = registerBlock("papayatree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PAPAYATREE_SAPLING = registerBlock("papayatree_sapling",
            new SaplingBlock(new PapayatreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PAPAYATREE_BUSHCROP = registerBushBlock("papayatree_bushcrop",
            new PapayatreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block PECANTREE_LOG = registerBlock("pecantree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PECANTREE_WOOD = registerBlock("pecantree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PECANTREE_LOG = registerBlock("stripped_pecantree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PECANTREE_WOOD = registerBlock("stripped_pecantree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PECANTREE_PLANKS = registerBlock("pecantree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PECANTREE_LEAVES = registerBlock("pecantree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PECANTREE_SAPLING = registerBlock("pecantree_sapling",
            new SaplingBlock(new PecantreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PECANTREE_BUSHCROP = registerBushBlock("pecantree_bushcrop",
            new PecantreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block PERSIMMONTREE_LOG = registerBlock("persimmontree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PERSIMMONTREE_WOOD = registerBlock("persimmontree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PERSIMMONTREE_LOG = registerBlock("stripped_persimmontree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PERSIMMONTREE_WOOD = registerBlock("stripped_persimmontree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PERSIMMONTREE_PLANKS = registerBlock("persimmontree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PERSIMMONTREE_LEAVES = registerBlock("persimmontree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PERSIMMONTREE_SAPLING = registerBlock("persimmontree_sapling",
            new SaplingBlock(new PersimmontreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PERSIMMONTREE_BUSHCROP = registerBushBlock("persimmontree_bushcrop",
            new PersimmontreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block PISTACHIOTREE_LOG = registerBlock("pistachiotree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PISTACHIOTREE_WOOD = registerBlock("pistachiotree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PISTACHIOTREE_LOG = registerBlock("stripped_pistachiotree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PISTACHIOTREE_WOOD = registerBlock("stripped_pistachiotree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PISTACHIOTREE_PLANKS = registerBlock("pistachiotree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PISTACHIOTREE_LEAVES = registerBlock("pistachiotree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PISTACHIOTREE_SAPLING = registerBlock("pistachiotree_sapling",
            new SaplingBlock(new PistachiotreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PISTACHIOTREE_BUSHCROP = registerBushBlock("pistachiotree_bushcrop",
            new PistachiotreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block POMEGRANATETREE_LOG = registerBlock("pomegranatetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block POMEGRANATETREE_WOOD = registerBlock("pomegranatetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_POMEGRANATETREE_LOG = registerBlock("stripped_pomegranatetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_POMEGRANATETREE_WOOD = registerBlock("stripped_pomegranatetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block POMEGRANATETREE_PLANKS = registerBlock("pomegranatetree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block POMEGRANATETREE_LEAVES = registerBlock("pomegranatetree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block POMEGRANATETREE_SAPLING = registerBlock("pomegranatetree_sapling",
            new SaplingBlock(new PomegranatetreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock POMEGRANATETREE_BUSHCROP = registerBushBlock("pomegranatetree_bushcrop",
            new PomegranatetreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block STARFRUITTREE_LOG = registerBlock("starfruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block STARFRUITTREE_WOOD = registerBlock("starfruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_STARFRUITTREE_LOG = registerBlock("stripped_starfruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_STARFRUITTREE_WOOD = registerBlock("stripped_starfruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block STARFRUITTREE_PLANKS = registerBlock("starfruittree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block STARFRUITTREE_LEAVES = registerBlock("starfruittree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block STARFRUITTREE_SAPLING = registerBlock("starfruittree_sapling",
            new SaplingBlock(new StarfruittreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock STARFRUITTREE_BUSHCROP = registerBushBlock("starfruittree_bushcrop",
            new StarfruittreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block BREADFRUITTREE_LOG = registerBlock("breadfruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block BREADFRUITTREE_WOOD = registerBlock("breadfruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_BREADFRUITTREE_LOG = registerBlock("stripped_breadfruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_BREADFRUITTREE_WOOD = registerBlock("stripped_breadfruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block BREADFRUITTREE_PLANKS = registerBlock("breadfruittree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block BREADFRUITTREE_LEAVES = registerBlock("breadfruittree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block BREADFRUITTREE_SAPLING = registerBlock("breadfruittree_sapling",
            new SaplingBlock(new BreadfruittreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock BREADFRUITTREE_BUSHCROP = registerBushBlock("breadfruittree_bushcrop",
            new BreadfruittreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block GUAVATREE_LOG = registerBlock("guavatree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block GUAVATREE_WOOD = registerBlock("guavatree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_GUAVATREE_LOG = registerBlock("stripped_guavatree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_GUAVATREE_WOOD = registerBlock("stripped_guavatree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block GUAVATREE_PLANKS = registerBlock("guavatree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block GUAVATREE_LEAVES = registerBlock("guavatree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block GUAVATREE_SAPLING = registerBlock("guavatree_sapling",
            new SaplingBlock(new GuavatreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock GUAVATREE_BUSHCROP = registerBushBlock("guavatree_bushcrop",
            new GuavatreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block JACKFRUITTREE_LOG = registerBlock("jackfruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block JACKFRUITTREE_WOOD = registerBlock("jackfruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_JACKFRUITTREE_LOG = registerBlock("stripped_jackfruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_JACKFRUITTREE_WOOD = registerBlock("stripped_jackfruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block JACKFRUITTREE_PLANKS = registerBlock("jackfruittree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block JACKFRUITTREE_LEAVES = registerBlock("jackfruittree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block JACKFRUITTREE_SAPLING = registerBlock("jackfruittree_sapling",
            new SaplingBlock(new JackfruittreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock JACKFRUITTREE_BUSHCROP = registerBushBlock("jackfruittree_bushcrop",
            new JackfruittreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block LYCHEETREE_LOG = registerBlock("lycheetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block LYCHEETREE_WOOD = registerBlock("lycheetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_LYCHEETREE_LOG = registerBlock("stripped_lycheetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_LYCHEETREE_WOOD = registerBlock("stripped_lycheetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block LYCHEETREE_PLANKS = registerBlock("lycheetree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block LYCHEETREE_LEAVES = registerBlock("lycheetree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block LYCHEETREE_SAPLING = registerBlock("lycheetree_sapling",
            new SaplingBlock(new LycheetreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock LYCHEETREE_BUSHCROP = registerBushBlock("lycheetree_bushcrop",
            new LycheetreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block PASSIONFRUITTREE_LOG = registerBlock("passionfruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PASSIONFRUITTREE_WOOD = registerBlock("passionfruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PASSIONFRUITTREE_LOG = registerBlock("stripped_passionfruittree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PASSIONFRUITTREE_WOOD = registerBlock("stripped_passionfruittree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PASSIONFRUITTREE_PLANKS = registerBlock("passionfruittree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PASSIONFRUITTREE_LEAVES = registerBlock("passionfruittree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PASSIONFRUITTREE_SAPLING = registerBlock("passionfruittree_sapling",
            new SaplingBlock(new PassionfruittreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PASSIONFRUITTREE_BUSHCROP = registerBushBlock("passionfruittree_bushcrop",
            new PassionfruittreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block RAMBUTANTREE_LOG = registerBlock("rambutantree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block RAMBUTANTREE_WOOD = registerBlock("rambutantree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_RAMBUTANTREE_LOG = registerBlock("stripped_rambutantree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_RAMBUTANTREE_WOOD = registerBlock("stripped_rambutantree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block RAMBUTANTREE_PLANKS = registerBlock("rambutantree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block RAMBUTANTREE_LEAVES = registerBlock("rambutantree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block RAMBUTANTREE_SAPLING = registerBlock("rambutantree_sapling",
            new SaplingBlock(new RambutantreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock RAMBUTANTREE_BUSHCROP = registerBushBlock("rambutantree_bushcrop",
            new RambutantreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block TAMARINDTREE_LOG = registerBlock("tamarindtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block TAMARINDTREE_WOOD = registerBlock("tamarindtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_TAMARINDTREE_LOG = registerBlock("stripped_tamarindtree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_TAMARINDTREE_WOOD = registerBlock("stripped_tamarindtree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block TAMARINDTREE_PLANKS = registerBlock("tamarindtree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block TAMARINDTREE_LEAVES = registerBlock("tamarindtree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block TAMARINDTREE_SAPLING = registerBlock("tamarindtree_sapling",
            new SaplingBlock(new TamarindtreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock TAMARINDTREE_BUSHCROP = registerBushBlock("tamarindtree_bushcrop",
            new TamarindtreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));















    public static final Block MAPLETREE_LOG = registerBlock("mapletree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block MAPLETREE_WOOD = registerBlock("mapletree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_MAPLETREE_LOG = registerBlock("stripped_mapletree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_MAPLETREE_WOOD = registerBlock("stripped_mapletree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block MAPLETREE_PLANKS = registerBlock("mapletree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block MAPLETREE_LEAVES = registerBlock("mapletree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block MAPLETREE_SAPLING = registerBlock("mapletree_sapling",
            new SaplingBlock(new MapletreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));



    public static final Block PEPPERCORNTREE_LOG = registerBlock("peppercorntree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PEPPERCORNTREE_WOOD = registerBlock("peppercorntree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PEPPERCORNTREE_LOG = registerBlock("stripped_peppercorntree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PEPPERCORNTREE_WOOD = registerBlock("stripped_peppercorntree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PEPPERCORNTREE_PLANKS = registerBlock("peppercorntree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PEPPERCORNTREE_LEAVES = registerBlock("peppercorntree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PEPPERCORNTREE_SAPLING = registerBlock("peppercorntree_sapling",
            new SaplingBlock(new PeppercorntreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PEPPERCORNTREE_BUSHCROP = registerBushBlock("peppercorntree_bushcrop",
            new PeppercorntreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block VANILLABEANTREE_LOG = registerBlock("vanillabeantree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block VANILLABEANTREE_WOOD = registerBlock("vanillabeantree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_VANILLABEANTREE_LOG = registerBlock("stripped_vanillabeantree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_VANILLABEANTREE_WOOD = registerBlock("stripped_vanillabeantree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block VANILLABEANTREE_PLANKS = registerBlock("vanillabeantree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block VANILLABEANTREE_LEAVES = registerBlock("vanillabeantree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block VANILLABEANTREE_SAPLING = registerBlock("vanillabeantree_sapling",
            new SaplingBlock(new VanillabeantreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock VANILLABEANTREE_BUSHCROP = registerBushBlock("vanillabeantree_bushcrop",
            new VanillabeantreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block PINENUTTREE_LOG = registerBlock("pinenuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block PINENUTTREE_WOOD = registerBlock("pinenuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PINENUTTREE_LOG = registerBlock("stripped_pinenuttree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PINENUTTREE_WOOD = registerBlock("stripped_pinenuttree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PINENUTTREE_PLANKS = registerBlock("pinenuttree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block PINENUTTREE_LEAVES = registerBlock("pinenuttree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block PINENUTTREE_SAPLING = registerBlock("pinenuttree_sapling",
            new SaplingBlock(new PinenuttreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock PINENUTTREE_BUSHCROP = registerBushBlock("pinenuttree_bushcrop",
            new PinenuttreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block GOOSEBERRYTREE_LOG = registerBlock("gooseberrytree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block GOOSEBERRYTREE_WOOD = registerBlock("gooseberrytree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_GOOSEBERRYTREE_LOG = registerBlock("stripped_gooseberrytree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_GOOSEBERRYTREE_WOOD = registerBlock("stripped_gooseberrytree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block GOOSEBERRYTREE_PLANKS = registerBlock("gooseberrytree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block GOOSEBERRYTREE_LEAVES = registerBlock("gooseberrytree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block GOOSEBERRYTREE_SAPLING = registerBlock("gooseberrytree_sapling",
            new SaplingBlock(new GooseberrytreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock GOOSEBERRYTREE_BUSHCROP = registerBushBlock("gooseberrytree_bushcrop",
            new GooseberrytreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block GRAPETREE_LOG = registerBlock("grapetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).nonOpaque()));
    /*public static final Block GRAPETREE_WOOD = registerBlock("grapetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_GRAPETREE_LOG = registerBlock("stripped_grapetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_GRAPETREE_WOOD = registerBlock("stripped_grapetree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block GRAPETREE_PLANKS = registerBlock("grapetree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));*/
    public static final Block GRAPETREE_LEAVES = registerBlock("grapetree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block GRAPETREE_SAPLING = registerBlock("grapetree_sapling",
            new SaplingBlock(new GrapetreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock GRAPETREE_BUSHCROP = registerBushBlock("grapetree_bushcrop",
            new GrapetreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));




    public static final Block RED_GRAPETREE_LOG = registerBlock("red_grapetree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).nonOpaque()));
    public static final Block RED_GRAPETREE_LEAVES = registerBlock("red_grapetree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block RED_GRAPETREE_SAPLING = registerBlock("red_grapetree_sapling",
            new SaplingBlock(new RedGrapetreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock RED_GRAPETREE_BUSHCROP = registerBushBlock("red_grapetree_bushcrop",
            new RedGrapetreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));




    public static final Block KIWITREE_LOG = registerBlock("kiwitree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).nonOpaque()));
    /*public static final Block KIWITREE_WOOD = registerBlock("kiwitree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_KIWITREE_LOG = registerBlock("stripped_kiwitree_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_KIWITREE_WOOD = registerBlock("stripped_kiwitree_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block KIWITREE_PLANKS = registerBlock("kiwitree_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));*/
    public static final Block KIWITREE_LEAVES = registerBlock("kiwitree_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block KIWITREE_SAPLING = registerBlock("kiwitree_sapling",
            new SaplingBlock(new KiwitreeSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final SweetBerryBushBlock KIWITREE_BUSHCROP = registerBushBlock("kiwitree_bushcrop",
            new KiwitreeBushCrop(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));














    //Candlenut, Chestnut, Nutmeg, Peach, Plum, Walnut, Hazelnut, Pawpaw, Soursop, Almond, Apricot, Cashew, Date, Dragonfruit, Durian,
    //Fig, Grapefruit, Lime, Papaya, Pecan, Persimmon, Pistachio, Pomegranate, Starfruit, Breadfruit, Guava, Jackfruit, Lychee, Passionfruit, Rambutan, Tamarind
    //

    //Maple, Peppercorn, Vanillabean, Pinenut, Gooseberry, Grape

    //Trees without crop
    // Maple

    //Trees with crop
    // Peppercorn, Vanillabean, Pinenut, Gooseberry, Grape



    // BERRY BUSHES ----------------------------------------------------------------------------------------------------
    public static final SweetBerryBushBlock BLUEBERRY_BUSH = registerBushBlock("blueberry_bush",
            new BlueberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    public static final SweetBerryBushBlock BLACKBERRY_BUSH = registerBushBlock("blackberry_bush",
            new BlackberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    public static final SweetBerryBushBlock RASPBERRY_BUSH = registerBushBlock("raspberry_bush",
            new RaspberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    public static final SweetBerryBushBlock CLOUDBERRY_BUSH = registerBushBlock("cloudberry_bush",
            new CloudberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final SweetBerryBushBlock WILD_STRAWBERRY_BUSH = registerBushBlock("wild_strawberry_bush",
            new Wild_StrawberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final SweetBerryBushBlock LINGONBERRY_BUSH = registerBushBlock("lingonberry_bush",
            new LingonberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final SweetBerryBushBlock CRANBERRY_BUSH = registerBushBlock("cranberry_bush",
            new CranberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final SweetBerryBushBlock HUCKLEBERRY_BUSH = registerBushBlock("huckleberry_bush",
            new HuckleberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final SweetBerryBushBlock JUNIPERBERRY_BUSH = registerBushBlock("juniperberry_bush",
            new JuniperberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final SweetBerryBushBlock MULBERRY_BUSH = registerBushBlock("mulberry_bush",
            new MulberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    // END OF BLOCKS ---------------------------------------------------------------------------------------------------

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    private static CropBlock registerCropBlock(String name, CropBlock block){
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    private static CropBlock registerCropBlockSimple(String name){
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name),
                new CustomCropBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                name));
    }

    private static CropBlock registerCropBlockSimpleWL(String name){
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name),
                new CustomCropBlockWL(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                        .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                        name));

        //TALL_GRASS = register("tall_grass", new TallPlantBlock(Settings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offsetType(OffsetType.XZ)));
    }

    private static SweetBerryBushBlock registerBushBlock(String name, SweetBerryBushBlock block){
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + Photosynthesis.MOD_ID);
    }
}
