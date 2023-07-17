package net.zuiron.photosynthesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.LootCondition;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.item.ModItems;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //machines
        addDrop(ModBlocks.SKILLET);
        addDrop(ModBlocks.MIXING_BOWL);
        addDrop(ModBlocks.KEG);
        addDrop(ModBlocks.FLUID_PRESS);
        addDrop(ModBlocks.MILKSEPERATOR);
        addDrop(ModBlocks.COOKINGPOT);
        addDrop(ModBlocks.CUTTINGBOARD);
        addDrop(ModBlocks.MORTAR);
        addDrop(ModBlocks.LATEX_EXTRACTOR);
        addDrop(ModBlocks.MAPLE_EXTRACTOR);

        //Planks
        addDrop(ModBlocks.APPLETREE_PLANKS);
        addDrop(ModBlocks.CINNAMON_PLANKS);
        addDrop(ModBlocks.BANANATREE_PLANKS);
        addDrop(ModBlocks.ORANGETREE_PLANKS);
        addDrop(ModBlocks.PEARTREE_PLANKS);
        addDrop(ModBlocks.AVOCADOTREE_PLANKS);
        addDrop(ModBlocks.COCONUTTREE_PLANKS);
        addDrop(ModBlocks.CHERRYTREE_PLANKS);
        addDrop(ModBlocks.LEMONTREE_PLANKS);
        addDrop(ModBlocks.OLIVETREE_PLANKS);
        addDrop(ModBlocks.RUBBERTREE_PLANKS);
        addDrop(ModBlocks.CANDLENUTTREE_PLANKS);
        addDrop(ModBlocks.CHESTNUTTREE_PLANKS);
        addDrop(ModBlocks.NUTMEGTREE_PLANKS);
        addDrop(ModBlocks.PEACHTREE_PLANKS);
        addDrop(ModBlocks.PLUMTREE_PLANKS);
        addDrop(ModBlocks.WALNUTTREE_PLANKS);
        addDrop(ModBlocks.HAZELNUTTREE_PLANKS);
        addDrop(ModBlocks.PAWPAWTREE_PLANKS);
        addDrop(ModBlocks.SOURSOPTREE_PLANKS);
        addDrop(ModBlocks.ALMONDTREE_PLANKS);
        addDrop(ModBlocks.APRICOTTREE_PLANKS);
        addDrop(ModBlocks.CASHEWTREE_PLANKS);
        addDrop(ModBlocks.DATETREE_PLANKS);
        addDrop(ModBlocks.DRAGONFRUITTREE_PLANKS);
        addDrop(ModBlocks.DURIANTREE_PLANKS);
        addDrop(ModBlocks.FIGTREE_PLANKS);
        addDrop(ModBlocks.GRAPEFRUITTREE_PLANKS);
        addDrop(ModBlocks.LIMETREE_PLANKS);
        addDrop(ModBlocks.PAPAYATREE_PLANKS);
        addDrop(ModBlocks.PECANTREE_PLANKS);
        addDrop(ModBlocks.PERSIMMONTREE_PLANKS);
        addDrop(ModBlocks.PISTACHIOTREE_PLANKS);
        addDrop(ModBlocks.POMEGRANATETREE_PLANKS);
        addDrop(ModBlocks.STARFRUITTREE_PLANKS);
        addDrop(ModBlocks.BREADFRUITTREE_PLANKS);
        addDrop(ModBlocks.GUAVATREE_PLANKS);
        addDrop(ModBlocks.JACKFRUITTREE_PLANKS);
        addDrop(ModBlocks.LYCHEETREE_PLANKS);
        addDrop(ModBlocks.PASSIONFRUITTREE_PLANKS);
        addDrop(ModBlocks.RAMBUTANTREE_PLANKS);
        addDrop(ModBlocks.TAMARINDTREE_PLANKS);
        addDrop(ModBlocks.MAPLETREE_PLANKS);
        addDrop(ModBlocks.PEPPERCORNTREE_PLANKS);
        addDrop(ModBlocks.VANILLABEANTREE_PLANKS);
        addDrop(ModBlocks.PINENUTTREE_PLANKS);
        addDrop(ModBlocks.GOOSEBERRYTREE_PLANKS);
        //addDrop(ModBlocks.GRAPETREE_PLANKS);
        //addDrop(ModBlocks.RED_GRAPETREE_PLANKS);
        //addDrop(ModBlocks.KIWITREE_PLANKS);
        addDrop(ModBlocks.MANGOTREE_PLANKS);

        //Logs
        addDrop(ModBlocks.APPLETREE_LOG);
        addDrop(ModBlocks.CINNAMON_LOG);
        addDrop(ModBlocks.BANANATREE_LOG);
        addDrop(ModBlocks.ORANGETREE_LOG);
        addDrop(ModBlocks.PEARTREE_LOG);
        addDrop(ModBlocks.AVOCADOTREE_LOG);
        addDrop(ModBlocks.COCONUTTREE_LOG);
        addDrop(ModBlocks.CHERRYTREE_LOG);
        addDrop(ModBlocks.LEMONTREE_LOG);
        addDrop(ModBlocks.OLIVETREE_LOG);
        addDrop(ModBlocks.RUBBERTREE_LOG);
        addDrop(ModBlocks.CANDLENUTTREE_LOG);
        addDrop(ModBlocks.CHESTNUTTREE_LOG);
        addDrop(ModBlocks.NUTMEGTREE_LOG);
        addDrop(ModBlocks.PEACHTREE_LOG);
        addDrop(ModBlocks.PLUMTREE_LOG);
        addDrop(ModBlocks.WALNUTTREE_LOG);
        addDrop(ModBlocks.HAZELNUTTREE_LOG);
        addDrop(ModBlocks.PAWPAWTREE_LOG);
        addDrop(ModBlocks.SOURSOPTREE_LOG);
        addDrop(ModBlocks.ALMONDTREE_LOG);
        addDrop(ModBlocks.APRICOTTREE_LOG);
        addDrop(ModBlocks.CASHEWTREE_LOG);
        addDrop(ModBlocks.DATETREE_LOG);
        addDrop(ModBlocks.DRAGONFRUITTREE_LOG);
        addDrop(ModBlocks.DURIANTREE_LOG);
        addDrop(ModBlocks.FIGTREE_LOG);
        addDrop(ModBlocks.GRAPEFRUITTREE_LOG);
        addDrop(ModBlocks.LIMETREE_LOG);
        addDrop(ModBlocks.PAPAYATREE_LOG);
        addDrop(ModBlocks.PECANTREE_LOG);
        addDrop(ModBlocks.PERSIMMONTREE_LOG);
        addDrop(ModBlocks.PISTACHIOTREE_LOG);
        addDrop(ModBlocks.POMEGRANATETREE_LOG);
        addDrop(ModBlocks.STARFRUITTREE_LOG);
        addDrop(ModBlocks.BREADFRUITTREE_LOG);
        addDrop(ModBlocks.GUAVATREE_LOG);
        addDrop(ModBlocks.JACKFRUITTREE_LOG);
        addDrop(ModBlocks.LYCHEETREE_LOG);
        addDrop(ModBlocks.PASSIONFRUITTREE_LOG);
        addDrop(ModBlocks.RAMBUTANTREE_LOG);
        addDrop(ModBlocks.TAMARINDTREE_LOG);
        addDrop(ModBlocks.MAPLETREE_LOG);
        addDrop(ModBlocks.PEPPERCORNTREE_LOG);
        addDrop(ModBlocks.VANILLABEANTREE_LOG);
        addDrop(ModBlocks.PINENUTTREE_LOG);
        addDrop(ModBlocks.GOOSEBERRYTREE_LOG);
        addDrop(ModBlocks.GRAPETREE_LOG);
        addDrop(ModBlocks.RED_GRAPETREE_LOG);
        addDrop(ModBlocks.KIWITREE_LOG);
        addDrop(ModBlocks.MANGOTREE_LOG);

        //Wood
        addDrop(ModBlocks.APPLETREE_WOOD);
        addDrop(ModBlocks.CINNAMON_WOOD);
        addDrop(ModBlocks.BANANATREE_WOOD);
        addDrop(ModBlocks.ORANGETREE_WOOD);
        addDrop(ModBlocks.PEARTREE_WOOD);
        addDrop(ModBlocks.AVOCADOTREE_WOOD);
        addDrop(ModBlocks.COCONUTTREE_WOOD);
        addDrop(ModBlocks.CHERRYTREE_WOOD);
        addDrop(ModBlocks.LEMONTREE_WOOD);
        addDrop(ModBlocks.OLIVETREE_WOOD);
        addDrop(ModBlocks.RUBBERTREE_WOOD);
        addDrop(ModBlocks.CANDLENUTTREE_WOOD);
        addDrop(ModBlocks.CHESTNUTTREE_WOOD);
        addDrop(ModBlocks.NUTMEGTREE_WOOD);
        addDrop(ModBlocks.PEACHTREE_WOOD);
        addDrop(ModBlocks.PLUMTREE_WOOD);
        addDrop(ModBlocks.WALNUTTREE_WOOD);
        addDrop(ModBlocks.HAZELNUTTREE_WOOD);
        addDrop(ModBlocks.PAWPAWTREE_WOOD);
        addDrop(ModBlocks.SOURSOPTREE_WOOD);
        addDrop(ModBlocks.ALMONDTREE_WOOD);
        addDrop(ModBlocks.APRICOTTREE_WOOD);
        addDrop(ModBlocks.CASHEWTREE_WOOD);
        addDrop(ModBlocks.DATETREE_WOOD);
        addDrop(ModBlocks.DRAGONFRUITTREE_WOOD);
        addDrop(ModBlocks.DURIANTREE_WOOD);
        addDrop(ModBlocks.FIGTREE_WOOD);
        addDrop(ModBlocks.GRAPEFRUITTREE_WOOD);
        addDrop(ModBlocks.LIMETREE_WOOD);
        addDrop(ModBlocks.PAPAYATREE_WOOD);
        addDrop(ModBlocks.PECANTREE_WOOD);
        addDrop(ModBlocks.PERSIMMONTREE_WOOD);
        addDrop(ModBlocks.PISTACHIOTREE_WOOD);
        addDrop(ModBlocks.POMEGRANATETREE_WOOD);
        addDrop(ModBlocks.STARFRUITTREE_WOOD);
        addDrop(ModBlocks.BREADFRUITTREE_WOOD);
        addDrop(ModBlocks.GUAVATREE_WOOD);
        addDrop(ModBlocks.JACKFRUITTREE_WOOD);
        addDrop(ModBlocks.LYCHEETREE_WOOD);
        addDrop(ModBlocks.PASSIONFRUITTREE_WOOD);
        addDrop(ModBlocks.RAMBUTANTREE_WOOD);
        addDrop(ModBlocks.TAMARINDTREE_WOOD);
        addDrop(ModBlocks.MAPLETREE_WOOD);
        addDrop(ModBlocks.PEPPERCORNTREE_WOOD);
        addDrop(ModBlocks.VANILLABEANTREE_WOOD);
        addDrop(ModBlocks.PINENUTTREE_WOOD);
        addDrop(ModBlocks.GOOSEBERRYTREE_WOOD);
        //addDrop(ModBlocks.GRAPETREE_WOOD);
        //addDrop(ModBlocks.RED_GRAPETREE_WOOD);
        //addDrop(ModBlocks.KIWITREE_WOOD);
        addDrop(ModBlocks.MANGOTREE_WOOD);

        //Stripped Log
        addDrop(ModBlocks.STRIPPED_APPLETREE_LOG);
        addDrop(ModBlocks.STRIPPED_CINNAMON_LOG);
        addDrop(ModBlocks.STRIPPED_BANANATREE_LOG);
        addDrop(ModBlocks.STRIPPED_ORANGETREE_LOG);
        addDrop(ModBlocks.STRIPPED_PEARTREE_LOG);
        addDrop(ModBlocks.STRIPPED_AVOCADOTREE_LOG);
        addDrop(ModBlocks.STRIPPED_COCONUTTREE_LOG);
        addDrop(ModBlocks.STRIPPED_CHERRYTREE_LOG);
        addDrop(ModBlocks.STRIPPED_LEMONTREE_LOG);
        addDrop(ModBlocks.STRIPPED_OLIVETREE_LOG);
        addDrop(ModBlocks.STRIPPED_RUBBERTREE_LOG);
        addDrop(ModBlocks.STRIPPED_CANDLENUTTREE_LOG);
        addDrop(ModBlocks.STRIPPED_CHESTNUTTREE_LOG);
        addDrop(ModBlocks.STRIPPED_NUTMEGTREE_LOG);
        addDrop(ModBlocks.STRIPPED_PEACHTREE_LOG);
        addDrop(ModBlocks.STRIPPED_PLUMTREE_LOG);
        addDrop(ModBlocks.STRIPPED_WALNUTTREE_LOG);
        addDrop(ModBlocks.STRIPPED_HAZELNUTTREE_LOG);
        addDrop(ModBlocks.STRIPPED_PAWPAWTREE_LOG);
        addDrop(ModBlocks.STRIPPED_SOURSOPTREE_LOG);
        addDrop(ModBlocks.STRIPPED_ALMONDTREE_LOG);
        addDrop(ModBlocks.STRIPPED_APRICOTTREE_LOG);
        addDrop(ModBlocks.STRIPPED_CASHEWTREE_LOG);
        addDrop(ModBlocks.STRIPPED_DATETREE_LOG);
        addDrop(ModBlocks.STRIPPED_DRAGONFRUITTREE_LOG);
        addDrop(ModBlocks.STRIPPED_DURIANTREE_LOG);
        addDrop(ModBlocks.STRIPPED_FIGTREE_LOG);
        addDrop(ModBlocks.STRIPPED_GRAPEFRUITTREE_LOG);
        addDrop(ModBlocks.STRIPPED_LIMETREE_LOG);
        addDrop(ModBlocks.STRIPPED_PAPAYATREE_LOG);
        addDrop(ModBlocks.STRIPPED_PECANTREE_LOG);
        addDrop(ModBlocks.STRIPPED_PERSIMMONTREE_LOG);
        addDrop(ModBlocks.STRIPPED_PISTACHIOTREE_LOG);
        addDrop(ModBlocks.STRIPPED_POMEGRANATETREE_LOG);
        addDrop(ModBlocks.STRIPPED_STARFRUITTREE_LOG);
        addDrop(ModBlocks.STRIPPED_BREADFRUITTREE_LOG);
        addDrop(ModBlocks.STRIPPED_GUAVATREE_LOG);
        addDrop(ModBlocks.STRIPPED_JACKFRUITTREE_LOG);
        addDrop(ModBlocks.STRIPPED_LYCHEETREE_LOG);
        addDrop(ModBlocks.STRIPPED_PASSIONFRUITTREE_LOG);
        addDrop(ModBlocks.STRIPPED_RAMBUTANTREE_LOG);
        addDrop(ModBlocks.STRIPPED_TAMARINDTREE_LOG);
        addDrop(ModBlocks.STRIPPED_MAPLETREE_LOG);
        addDrop(ModBlocks.STRIPPED_PEPPERCORNTREE_LOG);
        addDrop(ModBlocks.STRIPPED_VANILLABEANTREE_LOG);
        addDrop(ModBlocks.STRIPPED_PINENUTTREE_LOG);
        addDrop(ModBlocks.STRIPPED_GOOSEBERRYTREE_LOG);
        //addDrop(ModBlocks.STRIPPED_GRAPETREE_LOG);
        //addDrop(ModBlocks.STRIPPED_RED_GRAPETREE_LOG);
        //addDrop(ModBlocks.STRIPPED_KIWITREE_LOG);
        addDrop(ModBlocks.STRIPPED_MANGOTREE_LOG);

        //stripped WOOD
        addDrop(ModBlocks.STRIPPED_APPLETREE_WOOD);
        addDrop(ModBlocks.STRIPPED_CINNAMON_WOOD);
        addDrop(ModBlocks.STRIPPED_BANANATREE_WOOD);
        addDrop(ModBlocks.STRIPPED_ORANGETREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PEARTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_AVOCADOTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_COCONUTTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_CHERRYTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_LEMONTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_OLIVETREE_WOOD);
        addDrop(ModBlocks.STRIPPED_RUBBERTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_CANDLENUTTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_CHESTNUTTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_NUTMEGTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PEACHTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PLUMTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_WALNUTTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_HAZELNUTTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PAWPAWTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_SOURSOPTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_ALMONDTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_APRICOTTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_CASHEWTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_DATETREE_WOOD);
        addDrop(ModBlocks.STRIPPED_DRAGONFRUITTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_DURIANTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_FIGTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_GRAPEFRUITTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_LIMETREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PAPAYATREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PECANTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PERSIMMONTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PISTACHIOTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_POMEGRANATETREE_WOOD);
        addDrop(ModBlocks.STRIPPED_STARFRUITTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_BREADFRUITTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_GUAVATREE_WOOD);
        addDrop(ModBlocks.STRIPPED_JACKFRUITTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_LYCHEETREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PASSIONFRUITTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_RAMBUTANTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_TAMARINDTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_MAPLETREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PEPPERCORNTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_VANILLABEANTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PINENUTTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_GOOSEBERRYTREE_WOOD);
        //addDrop(ModBlocks.STRIPPED_GRAPETREE_WOOD);
        //addDrop(ModBlocks.STRIPPED_RED_GRAPETREE_WOOD);
        //addDrop(ModBlocks.STRIPPED_KIWITREE_WOOD);
        addDrop(ModBlocks.STRIPPED_MANGOTREE_WOOD);

        //Leaves
        addDrop(ModBlocks.APPLETREE_LEAVES, leavesDrops(ModBlocks.APPLETREE_LEAVES, ModBlocks.APPLETREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.CINNAMON_LEAVES, leavesDrops(ModBlocks.CINNAMON_LEAVES, ModBlocks.CINNAMON_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.BANANATREE_LEAVES, leavesDrops(ModBlocks.BANANATREE_LEAVES, ModBlocks.BANANATREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.ORANGETREE_LEAVES, leavesDrops(ModBlocks.ORANGETREE_LEAVES, ModBlocks.ORANGETREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PEARTREE_LEAVES, leavesDrops(ModBlocks.PEARTREE_LEAVES, ModBlocks.PEARTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.AVOCADOTREE_LEAVES, leavesDrops(ModBlocks.AVOCADOTREE_LEAVES, ModBlocks.AVOCADOTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.COCONUTTREE_LEAVES, leavesDrops(ModBlocks.COCONUTTREE_LEAVES, ModBlocks.COCONUTTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.CHERRYTREE_LEAVES, leavesDrops(ModBlocks.CHERRYTREE_LEAVES, ModBlocks.CHERRYTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.LEMONTREE_LEAVES, leavesDrops(ModBlocks.LEMONTREE_LEAVES, ModBlocks.LEMONTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.OLIVETREE_LEAVES, leavesDrops(ModBlocks.OLIVETREE_LEAVES, ModBlocks.OLIVETREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.RUBBERTREE_LEAVES, leavesDrops(ModBlocks.RUBBERTREE_LEAVES, ModBlocks.RUBBERTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.CANDLENUTTREE_LEAVES, leavesDrops(ModBlocks.CANDLENUTTREE_LEAVES, ModBlocks.CANDLENUTTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.CHESTNUTTREE_LEAVES, leavesDrops(ModBlocks.CHESTNUTTREE_LEAVES, ModBlocks.CHESTNUTTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.NUTMEGTREE_LEAVES, leavesDrops(ModBlocks.NUTMEGTREE_LEAVES, ModBlocks.NUTMEGTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PEACHTREE_LEAVES, leavesDrops(ModBlocks.PEACHTREE_LEAVES, ModBlocks.PEACHTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PLUMTREE_LEAVES, leavesDrops(ModBlocks.PLUMTREE_LEAVES, ModBlocks.PLUMTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.WALNUTTREE_LEAVES, leavesDrops(ModBlocks.WALNUTTREE_LEAVES, ModBlocks.WALNUTTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.HAZELNUTTREE_LEAVES, leavesDrops(ModBlocks.HAZELNUTTREE_LEAVES, ModBlocks.HAZELNUTTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PAWPAWTREE_LEAVES, leavesDrops(ModBlocks.PAWPAWTREE_LEAVES, ModBlocks.PAWPAWTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.SOURSOPTREE_LEAVES, leavesDrops(ModBlocks.SOURSOPTREE_LEAVES, ModBlocks.SOURSOPTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.ALMONDTREE_LEAVES, leavesDrops(ModBlocks.ALMONDTREE_LEAVES, ModBlocks.ALMONDTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.APRICOTTREE_LEAVES, leavesDrops(ModBlocks.APRICOTTREE_LEAVES, ModBlocks.APRICOTTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.CASHEWTREE_LEAVES, leavesDrops(ModBlocks.CASHEWTREE_LEAVES, ModBlocks.CASHEWTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.DATETREE_LEAVES, leavesDrops(ModBlocks.DATETREE_LEAVES, ModBlocks.DATETREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.DRAGONFRUITTREE_LEAVES, leavesDrops(ModBlocks.DRAGONFRUITTREE_LEAVES, ModBlocks.DRAGONFRUITTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.DURIANTREE_LEAVES, leavesDrops(ModBlocks.DURIANTREE_LEAVES, ModBlocks.DURIANTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.FIGTREE_LEAVES, leavesDrops(ModBlocks.FIGTREE_LEAVES, ModBlocks.FIGTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.GRAPEFRUITTREE_LEAVES, leavesDrops(ModBlocks.GRAPEFRUITTREE_LEAVES, ModBlocks.GRAPEFRUITTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.LIMETREE_LEAVES, leavesDrops(ModBlocks.LIMETREE_LEAVES, ModBlocks.LIMETREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PAPAYATREE_LEAVES, leavesDrops(ModBlocks.PAPAYATREE_LEAVES, ModBlocks.PAPAYATREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PECANTREE_LEAVES, leavesDrops(ModBlocks.PECANTREE_LEAVES, ModBlocks.PECANTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PERSIMMONTREE_LEAVES, leavesDrops(ModBlocks.PERSIMMONTREE_LEAVES, ModBlocks.PERSIMMONTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PISTACHIOTREE_LEAVES, leavesDrops(ModBlocks.PISTACHIOTREE_LEAVES, ModBlocks.PISTACHIOTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.POMEGRANATETREE_LEAVES, leavesDrops(ModBlocks.POMEGRANATETREE_LEAVES, ModBlocks.POMEGRANATETREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.STARFRUITTREE_LEAVES, leavesDrops(ModBlocks.STARFRUITTREE_LEAVES, ModBlocks.STARFRUITTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.BREADFRUITTREE_LEAVES, leavesDrops(ModBlocks.BREADFRUITTREE_LEAVES, ModBlocks.BREADFRUITTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.GUAVATREE_LEAVES, leavesDrops(ModBlocks.GUAVATREE_LEAVES, ModBlocks.GUAVATREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.JACKFRUITTREE_LEAVES, leavesDrops(ModBlocks.JACKFRUITTREE_LEAVES, ModBlocks.JACKFRUITTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.LYCHEETREE_LEAVES, leavesDrops(ModBlocks.LYCHEETREE_LEAVES, ModBlocks.LYCHEETREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PASSIONFRUITTREE_LEAVES, leavesDrops(ModBlocks.PASSIONFRUITTREE_LEAVES, ModBlocks.PASSIONFRUITTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.RAMBUTANTREE_LEAVES, leavesDrops(ModBlocks.RAMBUTANTREE_LEAVES, ModBlocks.RAMBUTANTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.TAMARINDTREE_LEAVES, leavesDrops(ModBlocks.TAMARINDTREE_LEAVES, ModBlocks.TAMARINDTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.MAPLETREE_LEAVES, leavesDrops(ModBlocks.MAPLETREE_LEAVES, ModBlocks.MAPLETREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PEPPERCORNTREE_LEAVES, leavesDrops(ModBlocks.PEPPERCORNTREE_LEAVES, ModBlocks.PEPPERCORNTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.VANILLABEANTREE_LEAVES, leavesDrops(ModBlocks.VANILLABEANTREE_LEAVES, ModBlocks.VANILLABEANTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.PINENUTTREE_LEAVES, leavesDrops(ModBlocks.PINENUTTREE_LEAVES, ModBlocks.PINENUTTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.GOOSEBERRYTREE_LEAVES, leavesDrops(ModBlocks.GOOSEBERRYTREE_LEAVES, ModBlocks.GOOSEBERRYTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(ModBlocks.GRAPETREE_LEAVES, leavesDrops(ModBlocks.GRAPETREE_LEAVES, ModBlocks.GRAPETREE_SAPLING, 0.3f, 0.36f, 0.48f, 0.6f));
        addDrop(ModBlocks.RED_GRAPETREE_LEAVES, leavesDrops(ModBlocks.RED_GRAPETREE_LEAVES, ModBlocks.RED_GRAPETREE_SAPLING, 0.3f, 0.36f, 0.48f, 0.6f));
        addDrop(ModBlocks.KIWITREE_LEAVES, leavesDrops(ModBlocks.KIWITREE_LEAVES, ModBlocks.KIWITREE_SAPLING, 0.3f, 0.36f, 0.48f, 0.6f));
        addDrop(ModBlocks.MANGOTREE_LEAVES, leavesDrops(ModBlocks.MANGOTREE_LEAVES, ModBlocks.MANGOTREE_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));


        /*
        0.05f, 0.0625f, 0.083333336f, 0.1f
         */




        addDrop(ModBlocks.DECORATION_ROCKS_RANDOM, ModItems.STONE_SMALL);
        addDrop(ModBlocks.DECORATION_STICKS_RANDOM, Items.STICK);
        addDrop(ModBlocks.DECORATION_SEASHELL, ModItems.SEASHELL);

        //cropDrops(ModBlocks.CACTUS_FRUIT_CROP, ModItems.CACTUS_FRUIT, ModItems.CACTUS_FRUIT_SEEDS, );
    }
}