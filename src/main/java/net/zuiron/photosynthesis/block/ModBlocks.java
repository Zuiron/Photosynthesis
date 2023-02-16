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
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.berrybushblocks.*;
import net.zuiron.photosynthesis.block.bushtreecrops.*;
import net.zuiron.photosynthesis.block.cropblocks.CustomCropBlock;
import net.zuiron.photosynthesis.block.cropblocks.CustomCropBlockWL;
import net.zuiron.photosynthesis.block.custom.CookingPotBlock;
import net.zuiron.photosynthesis.block.custom.CuttingBoardBlock;
import net.zuiron.photosynthesis.block.custom.KegBlock;
import net.zuiron.photosynthesis.block.custom.SkilletBlock;
import net.zuiron.photosynthesis.item.ModItemGroup;
import net.zuiron.photosynthesis.world.feature.tree.*;

public class ModBlocks {

    // FLOWERS ---------------------------------------------------------------------------------------------------------
    public static final Block FLORAMELISSIA = registerBlock("floramelissia",
            new FlowerBlock(StatusEffect.byRawId(1), 1, FabricBlockSettings.copy(Blocks.POTTED_POPPY).nonOpaque()));

    public static final Block POTTED_FLORAMELISSIA = registerBlockWithoutBlockItem("potted_floramelissia",
            new FlowerPotBlock(ModBlocks.FLORAMELISSIA, FabricBlockSettings.copy(Blocks.POTTED_POPPY).nonOpaque()));

    // "Machines"
    public static final Block SKILLET = registerBlock("skillet",
            new SkilletBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(4f).requiresTool().nonOpaque()));

    public static final Block KEG = registerBlock("keg",
            new KegBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(4f).requiresTool().nonOpaque()));

    public static final Block COOKINGPOT = registerBlock("cooking_pot",
            new CookingPotBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(4f).requiresTool().nonOpaque()));

    public static final Block CUTTINGBOARD = registerBlock("cutting_board",
            new CuttingBoardBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(4f).requiresTool().nonOpaque()));


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
    public static final CropBlock PARSLEY_CROP = registerCropBlockSimple("parsley_crop");
    public static final CropBlock MINT_CROP = registerCropBlockSimple("mint_crop");
    public static final CropBlock PINEAPPLE_CROP = registerCropBlockSimple("pineapple_crop");
    public static final CropBlock HOP_CROP = registerCropBlockSimple("hop_crop");
    public static final CropBlock FILIPENDULA_CROP = registerCropBlockSimple("filipendula_crop");


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
            new AppletreeBushCrop(AbstractBlock.Settings.of(Material.PLANT)
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
            new BananatreeBushCrop(AbstractBlock.Settings.of(Material.PLANT)
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
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

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
            new OrangetreeBushCrop(AbstractBlock.Settings.of(Material.PLANT)
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
            new PeartreeBushCrop(AbstractBlock.Settings.of(Material.PLANT)
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
            new CoconuttreeBushCrop(AbstractBlock.Settings.of(Material.PLANT)
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
            new AvocadotreeBushCrop(AbstractBlock.Settings.of(Material.PLANT)
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
            new CherrytreeBushCrop(AbstractBlock.Settings.of(Material.PLANT)
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
            new LemontreeBushCrop(AbstractBlock.Settings.of(Material.PLANT)
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
            new MangotreeBushCrop(AbstractBlock.Settings.of(Material.PLANT)
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
            new OlivetreeBushCrop(AbstractBlock.Settings.of(Material.PLANT)
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

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block, ModItemGroup.PHOTOSYNTHESIS);
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(item));
        return item;
    }

    private static CropBlock registerCropBlock(String name, CropBlock block){
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    private static CropBlock registerCropBlockSimple(String name){
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name),
                new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                name));
    }

    private static CropBlock registerCropBlockSimpleWL(String name){
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name),
                new CustomCropBlockWL(AbstractBlock.Settings.of(Material.PLANT)
                        .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                        name));
    }

    private static SweetBerryBushBlock registerBushBlock(String name, SweetBerryBushBlock block){
        return Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + Photosynthesis.MOD_ID);
    }
}
