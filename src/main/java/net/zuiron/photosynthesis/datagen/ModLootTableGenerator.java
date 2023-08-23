package net.zuiron.photosynthesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.Properties;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.datagen.entry.BerryAndBushDropEntry;
import net.zuiron.photosynthesis.datagen.entry.CropEntry;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.state.property.ModProperties;

import java.util.ArrayList;
import java.util.List;

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
        addDrop(ModBlocks.PLATE);
        addDrop(ModBlocks.TOOLRACK);
        addDrop(ModBlocks.SHELF);
        addDrop(ModBlocks.DRYINGNET);
        addDrop(ModBlocks.DRYINGRACK);
        addDrop(ModBlocks.WOOD_FIRED_STOVE);
        addDrop(ModBlocks.WOOD_FIRED_OVEN);
        addDrop(ModBlocks.FEEDINGTROUGH);
        addDrop(ModBlocks.WATERTROUGH);
        addDrop(ModBlocks.HAYRACK);
        addDrop(ModBlocks.SEASONSCALENDAR);

        //kitchen counters
        /*addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_OAK);

        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_OAK);

        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_OAK);

        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_OAK);*/

        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_OAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_SPRUCE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_BIRCH);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_JUNGLE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_ACACIA);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_CHERRY);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_DARKOAK);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_MANGROVE);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_BAMBOO);
        addDrop(ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_BAMBOO);

        //cabinets
        addDrop(ModBlocks.KITCHENCABINET_SPLIT_OAK);
        addDrop(ModBlocks.KITCHENCABINET_LEFT_OAK);
        addDrop(ModBlocks.KITCHENCABINET_RIGHT_OAK);
        addDrop(ModBlocks.KITCHENCABINET_SPLIT_SPRUCE);
        addDrop(ModBlocks.KITCHENCABINET_LEFT_SPRUCE);
        addDrop(ModBlocks.KITCHENCABINET_RIGHT_SPRUCE);
        addDrop(ModBlocks.KITCHENCABINET_SPLIT_BIRCH);
        addDrop(ModBlocks.KITCHENCABINET_LEFT_BIRCH);
        addDrop(ModBlocks.KITCHENCABINET_RIGHT_BIRCH);
        addDrop(ModBlocks.KITCHENCABINET_SPLIT_JUNGLE);
        addDrop(ModBlocks.KITCHENCABINET_LEFT_JUNGLE);
        addDrop(ModBlocks.KITCHENCABINET_RIGHT_JUNGLE);
        addDrop(ModBlocks.KITCHENCABINET_SPLIT_ACACIA);
        addDrop(ModBlocks.KITCHENCABINET_LEFT_ACACIA);
        addDrop(ModBlocks.KITCHENCABINET_RIGHT_ACACIA);
        addDrop(ModBlocks.KITCHENCABINET_SPLIT_CHERRY);
        addDrop(ModBlocks.KITCHENCABINET_LEFT_CHERRY);
        addDrop(ModBlocks.KITCHENCABINET_RIGHT_CHERRY);
        addDrop(ModBlocks.KITCHENCABINET_SPLIT_DARKOAK);
        addDrop(ModBlocks.KITCHENCABINET_LEFT_DARKOAK);
        addDrop(ModBlocks.KITCHENCABINET_RIGHT_DARKOAK);
        addDrop(ModBlocks.KITCHENCABINET_SPLIT_MANGROVE);
        addDrop(ModBlocks.KITCHENCABINET_LEFT_MANGROVE);
        addDrop(ModBlocks.KITCHENCABINET_RIGHT_MANGROVE);
        addDrop(ModBlocks.KITCHENCABINET_SPLIT_BAMBOO);
        addDrop(ModBlocks.KITCHENCABINET_LEFT_BAMBOO);
        addDrop(ModBlocks.KITCHENCABINET_RIGHT_BAMBOO);

        //Saplings
        addDrop(ModBlocks.APPLETREE_SAPLING);
        addDrop(ModBlocks.CINNAMON_SAPLING);
        addDrop(ModBlocks.BANANATREE_SAPLING);
        addDrop(ModBlocks.ORANGETREE_SAPLING);
        addDrop(ModBlocks.PEARTREE_SAPLING);
        addDrop(ModBlocks.AVOCADOTREE_SAPLING);
        addDrop(ModBlocks.COCONUTTREE_SAPLING);
        addDrop(ModBlocks.CHERRYTREE_SAPLING);
        addDrop(ModBlocks.LEMONTREE_SAPLING);
        addDrop(ModBlocks.OLIVETREE_SAPLING);
        addDrop(ModBlocks.RUBBERTREE_SAPLING);
        addDrop(ModBlocks.CANDLENUTTREE_SAPLING);
        addDrop(ModBlocks.CHESTNUTTREE_SAPLING);
        addDrop(ModBlocks.NUTMEGTREE_SAPLING);
        addDrop(ModBlocks.PEACHTREE_SAPLING);
        addDrop(ModBlocks.PLUMTREE_SAPLING);
        addDrop(ModBlocks.WALNUTTREE_SAPLING);
        addDrop(ModBlocks.HAZELNUTTREE_SAPLING);
        addDrop(ModBlocks.PAWPAWTREE_SAPLING);
        addDrop(ModBlocks.SOURSOPTREE_SAPLING);
        addDrop(ModBlocks.ALMONDTREE_SAPLING);
        addDrop(ModBlocks.APRICOTTREE_SAPLING);
        addDrop(ModBlocks.CASHEWTREE_SAPLING);
        addDrop(ModBlocks.DATETREE_SAPLING);
        addDrop(ModBlocks.DRAGONFRUITTREE_SAPLING);
        addDrop(ModBlocks.DURIANTREE_SAPLING);
        addDrop(ModBlocks.FIGTREE_SAPLING);
        addDrop(ModBlocks.GRAPEFRUITTREE_SAPLING);
        addDrop(ModBlocks.LIMETREE_SAPLING);
        addDrop(ModBlocks.PAPAYATREE_SAPLING);
        addDrop(ModBlocks.PECANTREE_SAPLING);
        addDrop(ModBlocks.PERSIMMONTREE_SAPLING);
        addDrop(ModBlocks.PISTACHIOTREE_SAPLING);
        addDrop(ModBlocks.POMEGRANATETREE_SAPLING);
        addDrop(ModBlocks.STARFRUITTREE_SAPLING);
        addDrop(ModBlocks.BREADFRUITTREE_SAPLING);
        addDrop(ModBlocks.GUAVATREE_SAPLING);
        addDrop(ModBlocks.JACKFRUITTREE_SAPLING);
        addDrop(ModBlocks.LYCHEETREE_SAPLING);
        addDrop(ModBlocks.PASSIONFRUITTREE_SAPLING);
        addDrop(ModBlocks.RAMBUTANTREE_SAPLING);
        addDrop(ModBlocks.TAMARINDTREE_SAPLING);
        addDrop(ModBlocks.MAPLETREE_SAPLING);
        addDrop(ModBlocks.PEPPERCORNTREE_SAPLING);
        addDrop(ModBlocks.VANILLABEANTREE_SAPLING);
        addDrop(ModBlocks.PINENUTTREE_SAPLING);
        addDrop(ModBlocks.GOOSEBERRYTREE_SAPLING);
        addDrop(ModBlocks.GRAPETREE_SAPLING);
        addDrop(ModBlocks.RED_GRAPETREE_SAPLING);
        addDrop(ModBlocks.KIWITREE_SAPLING);
        addDrop(ModBlocks.MANGOTREE_SAPLING);


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

        //dropschances
        float chance1 = 0.05f * 1.5f;
        float chance2 = 0.0625f * 1.5f;
        float chance3 = 0.083333336f * 1.5f;
        float chance4 = 0.1f * 1.5f;

        //0.05f, 0.0625f, 0.083333336f, 0.1f //default oak
        //0.3f, 0.36f, 0.48f, 0.6f //very high

        //Leaves
        addDrop(ModBlocks.APPLETREE_LEAVES, leavesDrops(ModBlocks.APPLETREE_LEAVES, ModBlocks.APPLETREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.CINNAMON_LEAVES, leavesDrops(ModBlocks.CINNAMON_LEAVES, ModBlocks.CINNAMON_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.BANANATREE_LEAVES, leavesDrops(ModBlocks.BANANATREE_LEAVES, ModBlocks.BANANATREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.ORANGETREE_LEAVES, leavesDrops(ModBlocks.ORANGETREE_LEAVES, ModBlocks.ORANGETREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PEARTREE_LEAVES, leavesDrops(ModBlocks.PEARTREE_LEAVES, ModBlocks.PEARTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.AVOCADOTREE_LEAVES, leavesDrops(ModBlocks.AVOCADOTREE_LEAVES, ModBlocks.AVOCADOTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.COCONUTTREE_LEAVES, leavesDrops(ModBlocks.COCONUTTREE_LEAVES, ModBlocks.COCONUTTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.CHERRYTREE_LEAVES, leavesDrops(ModBlocks.CHERRYTREE_LEAVES, ModBlocks.CHERRYTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.LEMONTREE_LEAVES, leavesDrops(ModBlocks.LEMONTREE_LEAVES, ModBlocks.LEMONTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.OLIVETREE_LEAVES, leavesDrops(ModBlocks.OLIVETREE_LEAVES, ModBlocks.OLIVETREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.RUBBERTREE_LEAVES, leavesDrops(ModBlocks.RUBBERTREE_LEAVES, ModBlocks.RUBBERTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.CANDLENUTTREE_LEAVES, leavesDrops(ModBlocks.CANDLENUTTREE_LEAVES, ModBlocks.CANDLENUTTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.CHESTNUTTREE_LEAVES, leavesDrops(ModBlocks.CHESTNUTTREE_LEAVES, ModBlocks.CHESTNUTTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.NUTMEGTREE_LEAVES, leavesDrops(ModBlocks.NUTMEGTREE_LEAVES, ModBlocks.NUTMEGTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PEACHTREE_LEAVES, leavesDrops(ModBlocks.PEACHTREE_LEAVES, ModBlocks.PEACHTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PLUMTREE_LEAVES, leavesDrops(ModBlocks.PLUMTREE_LEAVES, ModBlocks.PLUMTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.WALNUTTREE_LEAVES, leavesDrops(ModBlocks.WALNUTTREE_LEAVES, ModBlocks.WALNUTTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.HAZELNUTTREE_LEAVES, leavesDrops(ModBlocks.HAZELNUTTREE_LEAVES, ModBlocks.HAZELNUTTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PAWPAWTREE_LEAVES, leavesDrops(ModBlocks.PAWPAWTREE_LEAVES, ModBlocks.PAWPAWTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.SOURSOPTREE_LEAVES, leavesDrops(ModBlocks.SOURSOPTREE_LEAVES, ModBlocks.SOURSOPTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.ALMONDTREE_LEAVES, leavesDrops(ModBlocks.ALMONDTREE_LEAVES, ModBlocks.ALMONDTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.APRICOTTREE_LEAVES, leavesDrops(ModBlocks.APRICOTTREE_LEAVES, ModBlocks.APRICOTTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.CASHEWTREE_LEAVES, leavesDrops(ModBlocks.CASHEWTREE_LEAVES, ModBlocks.CASHEWTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.DATETREE_LEAVES, leavesDrops(ModBlocks.DATETREE_LEAVES, ModBlocks.DATETREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.DRAGONFRUITTREE_LEAVES, leavesDrops(ModBlocks.DRAGONFRUITTREE_LEAVES, ModBlocks.DRAGONFRUITTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.DURIANTREE_LEAVES, leavesDrops(ModBlocks.DURIANTREE_LEAVES, ModBlocks.DURIANTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.FIGTREE_LEAVES, leavesDrops(ModBlocks.FIGTREE_LEAVES, ModBlocks.FIGTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.GRAPEFRUITTREE_LEAVES, leavesDrops(ModBlocks.GRAPEFRUITTREE_LEAVES, ModBlocks.GRAPEFRUITTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.LIMETREE_LEAVES, leavesDrops(ModBlocks.LIMETREE_LEAVES, ModBlocks.LIMETREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PAPAYATREE_LEAVES, leavesDrops(ModBlocks.PAPAYATREE_LEAVES, ModBlocks.PAPAYATREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PECANTREE_LEAVES, leavesDrops(ModBlocks.PECANTREE_LEAVES, ModBlocks.PECANTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PERSIMMONTREE_LEAVES, leavesDrops(ModBlocks.PERSIMMONTREE_LEAVES, ModBlocks.PERSIMMONTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PISTACHIOTREE_LEAVES, leavesDrops(ModBlocks.PISTACHIOTREE_LEAVES, ModBlocks.PISTACHIOTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.POMEGRANATETREE_LEAVES, leavesDrops(ModBlocks.POMEGRANATETREE_LEAVES, ModBlocks.POMEGRANATETREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.STARFRUITTREE_LEAVES, leavesDrops(ModBlocks.STARFRUITTREE_LEAVES, ModBlocks.STARFRUITTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.BREADFRUITTREE_LEAVES, leavesDrops(ModBlocks.BREADFRUITTREE_LEAVES, ModBlocks.BREADFRUITTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.GUAVATREE_LEAVES, leavesDrops(ModBlocks.GUAVATREE_LEAVES, ModBlocks.GUAVATREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.JACKFRUITTREE_LEAVES, leavesDrops(ModBlocks.JACKFRUITTREE_LEAVES, ModBlocks.JACKFRUITTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.LYCHEETREE_LEAVES, leavesDrops(ModBlocks.LYCHEETREE_LEAVES, ModBlocks.LYCHEETREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PASSIONFRUITTREE_LEAVES, leavesDrops(ModBlocks.PASSIONFRUITTREE_LEAVES, ModBlocks.PASSIONFRUITTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.RAMBUTANTREE_LEAVES, leavesDrops(ModBlocks.RAMBUTANTREE_LEAVES, ModBlocks.RAMBUTANTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.TAMARINDTREE_LEAVES, leavesDrops(ModBlocks.TAMARINDTREE_LEAVES, ModBlocks.TAMARINDTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.MAPLETREE_LEAVES, leavesDrops(ModBlocks.MAPLETREE_LEAVES, ModBlocks.MAPLETREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PEPPERCORNTREE_LEAVES, leavesDrops(ModBlocks.PEPPERCORNTREE_LEAVES, ModBlocks.PEPPERCORNTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.VANILLABEANTREE_LEAVES, leavesDrops(ModBlocks.VANILLABEANTREE_LEAVES, ModBlocks.VANILLABEANTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.PINENUTTREE_LEAVES, leavesDrops(ModBlocks.PINENUTTREE_LEAVES, ModBlocks.PINENUTTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.GOOSEBERRYTREE_LEAVES, leavesDrops(ModBlocks.GOOSEBERRYTREE_LEAVES, ModBlocks.GOOSEBERRYTREE_SAPLING, chance1, chance2, chance3, chance4));
        addDrop(ModBlocks.MANGOTREE_LEAVES, leavesDrops(ModBlocks.MANGOTREE_LEAVES, ModBlocks.MANGOTREE_SAPLING, chance1, chance2, chance3, chance4));

        //higher drop rates.
        addDrop(ModBlocks.GRAPETREE_LEAVES, leavesDrops(ModBlocks.GRAPETREE_LEAVES, ModBlocks.GRAPETREE_SAPLING, 0.3f, 0.36f, 0.48f, 0.6f));
        addDrop(ModBlocks.RED_GRAPETREE_LEAVES, leavesDrops(ModBlocks.RED_GRAPETREE_LEAVES, ModBlocks.RED_GRAPETREE_SAPLING, 0.3f, 0.36f, 0.48f, 0.6f));
        addDrop(ModBlocks.KIWITREE_LEAVES, leavesDrops(ModBlocks.KIWITREE_LEAVES, ModBlocks.KIWITREE_SAPLING, 0.3f, 0.36f, 0.48f, 0.6f));




        addDrop(ModBlocks.DECORATION_ROCKS_RANDOM, ModItems.STONE_SMALL);
        addDrop(ModBlocks.DECORATION_STICKS_RANDOM, Items.STICK);
        addDrop(ModBlocks.DECORATION_SEASHELL, ModItems.SEASHELL);

        /*Block[] BerryBushes = {
                ModBlocks.WILD_STRAWBERRY_BUSH
        };
        Item[] BerryDrops = {
                ModItems.WILD_STRAWBERRIES
        };

        //Berry loot tables
        for (Block blockMod : BerryBushes) {
            this.addDrop(Blocks.SWEET_BERRY_BUSH, (Block block) -> this.applyExplosionDecay((ItemConvertible) block,
                    LootTable.builder().pool(LootPool.builder()
                        .conditionally(BlockStatePropertyLootCondition.builder(Blocks.SWEET_BERRY_BUSH)
                        .properties(StatePredicate.Builder.create()
                        .exactMatch(SweetBerryBushBlock.AGE, 3)))
                        .with(ItemEntry.builder(Items.SWEET_BERRIES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE)))));
        }*/

        List<BerryAndBushDropEntry> berryAndBushDrops = new ArrayList<>();
        //Berries
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.BLACKBERRY_BUSH, ModItems.BLACKBERRIES, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.BLUEBERRY_BUSH, ModItems.BLUEBERRIES, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.CLOUDBERRY_BUSH, ModItems.CLOUDBERRIES, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.CRANBERRY_BUSH, ModItems.CRANBERRIES, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.HUCKLEBERRY_BUSH, ModItems.HUCKLEBERRIES, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.JUNIPERBERRY_BUSH, ModItems.JUNIPERBERRIES, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.LINGONBERRY_BUSH, ModItems.LINGONBERRIES, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.MULBERRY_BUSH, ModItems.MULBERRIES, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.RASPBERRY_BUSH, ModItems.RASPBERRIES, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.WILD_STRAWBERRY_BUSH, ModItems.WILD_STRAWBERRIES, 3, 2.0f, 3.0f));

        //Tree-crops
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.ALMONDTREE_BUSHCROP, ModItems.ALMOND, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.APPLETREE_BUSHCROP, ModItems.GREENAPPLE, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.APRICOTTREE_BUSHCROP, ModItems.APRICOT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.AVOCADOTREE_BUSHCROP, ModItems.AVOCADO, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.BANANATREE_BUSHCROP, ModItems.BANANA, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.BREADFRUITTREE_BUSHCROP, ModItems.BREADFRUIT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.CANDLENUTTREE_BUSHCROP, ModItems.CANDLENUT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.CASHEWTREE_BUSHCROP, ModItems.CASHEW, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.CHERRYTREE_BUSHCROP, ModItems.CHERRY, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.CHESTNUTTREE_BUSHCROP, ModItems.CHESTNUT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.COCONUTTREE_BUSHCROP, ModItems.COCONUT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.DATETREE_BUSHCROP, ModItems.DATE, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.DRAGONFRUITTREE_BUSHCROP, ModItems.DRAGONFRUIT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.DURIANTREE_BUSHCROP, ModItems.DURIAN, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.FIGTREE_BUSHCROP, ModItems.FIG, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.GOOSEBERRYTREE_BUSHCROP, ModItems.GOOSEBERRY, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.GRAPEFRUITTREE_BUSHCROP, ModItems.GRAPEFRUIT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.GRAPETREE_BUSHCROP, ModItems.GRAPE, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.GUAVATREE_BUSHCROP, ModItems.GUAVA, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.HAZELNUTTREE_BUSHCROP, ModItems.HAZELNUT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.JACKFRUITTREE_BUSHCROP, ModItems.JACKFRUIT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.KIWITREE_BUSHCROP, ModItems.KIWI, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.LEMONTREE_BUSHCROP, ModItems.LEMON, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.LIMETREE_BUSHCROP, ModItems.LIME, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.LYCHEETREE_BUSHCROP, ModItems.LYCHEE, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.MANGOTREE_BUSHCROP, ModItems.MANGO, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.NUTMEGTREE_BUSHCROP, ModItems.NUTMEG, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.OLIVETREE_BUSHCROP, ModItems.OLIVE, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.ORANGETREE_BUSHCROP, ModItems.ORANGE, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PAPAYATREE_BUSHCROP, ModItems.PAPAYA, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PASSIONFRUITTREE_BUSHCROP, ModItems.PASSIONFRUIT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PAWPAWTREE_BUSHCROP, ModItems.PAWPAW, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PEACHTREE_BUSHCROP, ModItems.PEACH, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PEARTREE_BUSHCROP, ModItems.PEAR, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PECANTREE_BUSHCROP, ModItems.PECAN, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PEPPERCORNTREE_BUSHCROP, ModItems.PEPPERCORN, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PERSIMMONTREE_BUSHCROP, ModItems.PERSIMMON, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PINENUTTREE_BUSHCROP, ModItems.PINENUT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PISTACHIOTREE_BUSHCROP, ModItems.PISTACHIO, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.PLUMTREE_BUSHCROP, ModItems.PLUM, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.POMEGRANATETREE_BUSHCROP, ModItems.POMEGRANATE, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.RAMBUTANTREE_BUSHCROP, ModItems.RAMBUTAN, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.RED_GRAPETREE_BUSHCROP, ModItems.RED_GRAPE, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.SOURSOPTREE_BUSHCROP, ModItems.SOURSOP, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.STARFRUITTREE_BUSHCROP, ModItems.STARFRUIT, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.TAMARINDTREE_BUSHCROP, ModItems.TAMARIND, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.VANILLABEANTREE_BUSHCROP, ModItems.VANILLABEAN, 3, 2.0f, 3.0f));
        berryAndBushDrops.add(new BerryAndBushDropEntry(ModBlocks.WALNUTTREE_BUSHCROP, ModItems.WALNUT, 3, 2.0f, 3.0f));

        for (BerryAndBushDropEntry entry : berryAndBushDrops) {
            this.addDrop(entry.getBerryBush(), (Block block) -> this.applyExplosionDecay((ItemConvertible) block,
                    LootTable.builder().pool(LootPool.builder()
                            .conditionally(BlockStatePropertyLootCondition.builder(entry.getBerryBush())
                            .properties(StatePredicate.Builder.create()
                            .exactMatch(SweetBerryBushBlock.AGE, entry.getAge())))
                            .with(ItemEntry.builder(entry.getBerryDrop()))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(entry.getMinCount(), entry.getMaxCount())))
                            .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE)))));
        }

        //cropDrops(ModBlocks.CACTUS_FRUIT_CROP, ModItems.CACTUS_FRUIT, ModItems.CACTUS_FRUIT_SEEDS, );

        /*BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP)
                 .properties(StatePredicate.Builder.create().exactMatch(Properties.AGE_7, 7));
         this.addDrop(ModBlocks.RICE_CROP, this.cropDrops(ModBlocks.RICE_CROP, ModItems.RICE_PANICLE, ModItems.RICE_SEEDS, builder));*/




        //Loot Table Builder for CROPS.
        List<CropEntry> listCrops = new ArrayList<>();
        listCrops.add(new CropEntry(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.BASIL_CROP, ModItems.BASIL, ModItems.BASIL_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.OREGANO_CROP, ModItems.OREGANO, ModItems.OREGANO_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.STRAWBERRY_CROP, ModItems.STRAWBERRY, ModItems.STRAWBERRY_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.OAT_CROP, ModItems.OAT, ModItems.OAT_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.JALAPENO_CROP, ModItems.JALAPENO, ModItems.JALAPENO_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CHILI_CROP, ModItems.CHILI, ModItems.CHILI_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CUCUMBER_CROP, ModItems.CUCUMBER, ModItems.CUCUMBER_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.ONION_CROP, ModItems.ONION, ModItems.ONION_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.LEEK_CROP, ModItems.LEEK, ModItems.LEEK_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CELERY_CROP, ModItems.CELERY, ModItems.CELERY_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.PEAS_CROP, ModItems.PEAS, ModItems.PEAS_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.SWEET_POTATO_CROP, ModItems.SWEET_POTATO, ModItems.SWEET_POTATO_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.ASPARAGUS_CROP, ModItems.ASPARAGUS, ModItems.ASPARAGUS_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.SCALLION_CROP, ModItems.SCALLION, ModItems.SCALLION_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.GARLIC_CROP, ModItems.GARLIC, ModItems.GARLIC_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CHIVE_CROP, ModItems.CHIVE, ModItems.CHIVE_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.BROCCOLI_CROP, ModItems.BROCCOLI, ModItems.BROCCOLI_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CAULIFLOWER_CROP, ModItems.CAULIFLOWER, ModItems.CAULIFLOWER_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CABBAGE_CROP, ModItems.CABBAGE, ModItems.CABBAGE_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.BELLPEPPER_CROP, ModItems.RED_BELLPEPPER, ModItems.BELLPEPPER_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.TURNIP_CROP, ModItems.TURNIP, ModItems.TURNIP_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.RUTABAGA_CROP, ModItems.RUTABAGA, ModItems.RUTABAGA_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CANOLA_CROP, ModItems.CANOLA, ModItems.CANOLA_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.BARLEY_CROP, ModItems.BARLEY, ModItems.BARLEY_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.COTTON_CROP, ModItems.COTTON, ModItems.COTTON_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.SUGARBEET_CROP, ModItems.SUGARBEET, ModItems.SUGARBEET_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.RICE_CROP, ModItems.RICE_PANICLE, ModItems.RICE_SEEDS));
        //listCrops.add(new CropEntry(ModBlocks.WHITE_BUTTON_MUSHROOM_CROP, ModItems.WHITE_BUTTON_MUSHROOM, ModItems.WHITE_BUTTON_MUSHROOM_SEEDS));
        //listCrops.add(new CropEntry(ModBlocks.PORCINI_MUSHROOM_CROP, ModItems.PORCINI_MUSHROOM, ModItems.PORCINI_MUSHROOM_SEEDS));
        //listCrops.add(new CropEntry(ModBlocks.CHANTERELLE_MUSHROOM_CROP, ModItems.CHANTERELLE_MUSHROOM, ModItems.CHANTERELLE_MUSHROOM_SEEDS));
        //listCrops.add(new CropEntry(ModBlocks.MOREL_MUSHROOM_CROP, ModItems.MOREL_MUSHROOM, ModItems.MOREL_MUSHROOM_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.SOYBEAN_CROP, ModItems.SOYBEAN, ModItems.SOYBEAN_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.SPINACH_CROP, ModItems.SPINACH, ModItems.SPINACH_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.ARROWROOT_CROP, ModItems.ARROWROOT, ModItems.ARROWROOT_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.ARTICHOKE_CROP, ModItems.ARTICHOKE, ModItems.ARTICHOKE_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.BRUSSELS_SPROUTS_CROP, ModItems.BRUSSELS_SPROUTS, ModItems.BRUSSELS_SPROUTS_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CASSAVA_CROP, ModItems.CASSAVA, ModItems.CASSAVA_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.EGGPLANT_CROP, ModItems.EGGPLANT, ModItems.EGGPLANT_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.SUNFLOWER_CROP, ModItems.SUNFLOWER, ModItems.SUNFLOWER_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.JICAMA_CROP, ModItems.JICAMA, ModItems.JICAMA_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.KALE_CROP, ModItems.KALE, ModItems.KALE_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.KOHLRABI_CROP, ModItems.KOHLRABI, ModItems.KOHLRABI_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.LETTUCE_CROP, ModItems.LETTUCE, ModItems.LETTUCE_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.OKRA_CROP, ModItems.OKRA, ModItems.OKRA_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.PARSNIP_CROP, ModItems.PARSNIP, ModItems.PARSNIP_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.RADISH_CROP, ModItems.RADISH, ModItems.RADISH_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.RHUBARB_CROP, ModItems.RHUBARB, ModItems.RHUBARB_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.MILLET_CROP, ModItems.MILLET, ModItems.MILLET_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.RYE_CROP, ModItems.RYE, ModItems.RYE_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.SQUASH_CROP, ModItems.SQUASH, ModItems.SQUASH_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.ZUCCHINI_CROP, ModItems.ZUCCHINI, ModItems.ZUCCHINI_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.COFFEA_CROP, ModItems.COFFEA, ModItems.COFFEA_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.PARSLEY_CROP, ModItems.PARSLEY, ModItems.PARSLEY_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.MINT_CROP, ModItems.MINT, ModItems.MINT_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.PINEAPPLE_CROP, ModItems.PINEAPPLE, ModItems.PINEAPPLE_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.HOP_CROP, ModItems.HOP, ModItems.HOP_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.FILIPENDULA_CROP, ModItems.FILIPENDULA, ModItems.FILIPENDULA_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CACTUS_FRUIT_CROP, ModItems.CACTUS_FRUIT, ModItems.CACTUS_FRUIT_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CANTALOUPE_CROP, ModItems.CANTALOUPE, ModItems.CANTALOUPE_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.FLAX_CROP, ModItems.FLAX, ModItems.FLAX_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.JUTE_CROP, ModItems.JUTE, ModItems.JUTE_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.KENAF_CROP, ModItems.KENAF, ModItems.KENAF_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.SISAL_CROP, ModItems.SISAL, ModItems.SISAL_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.AMARANTH_CROP, ModItems.AMARANTH, ModItems.AMARANTH_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.BEAN_CROP, ModItems.BEAN, ModItems.BEAN_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CHICKPEA_CROP, ModItems.CHICKPEA, ModItems.CHICKPEA_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.LENTIL_CROP, ModItems.LENTIL, ModItems.LENTIL_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.QUINOA_CROP, ModItems.QUINOA, ModItems.QUINOA_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.PEANUT_CROP, ModItems.PEANUT, ModItems.PEANUT_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.TARO_CROP, ModItems.TARO, ModItems.TARO_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.TOMATILLO_CROP, ModItems.TOMATILLO, ModItems.TOMATILLO_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.AGAVE_CROP, ModItems.AGAVE, ModItems.AGAVE_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.GINGER_CROP, ModItems.GINGER, ModItems.GINGER_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.SESAME_CROP, ModItems.SESAME, ModItems.SESAME_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.MUSTARD_CROP, ModItems.MUSTARD, ModItems.MUSTARD_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.GRASS_CROP, Items.GRASS, ModItems.GRASS_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.CAMELLIA_SINENSIS_CROP, ModItems.CAMELLIA_SINENSIS, ModItems.CAMELLIA_SINENSIS_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.NICOTIANA_RUSTICA_CROP, ModItems.NICOTIANA_RUSTICA, ModItems.NICOTIANA_RUSTICA_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.PAPAVER_SOMNIFERUM_CROP, ModItems.PAPAVER_SOMNIFERUM, ModItems.PAPAVER_SOMNIFERUM_SEEDS));
        listCrops.add(new CropEntry(ModBlocks.ERYTHROXYLUM_COCA_CROP, ModItems.ERYTHROXYLUM_COCA, ModItems.ERYTHROXYLUM_COCA_SEEDS));


        for (CropEntry entry : listCrops) {
            BlockStatePropertyLootCondition.Builder no_age_condition = BlockStatePropertyLootCondition
                    .builder(entry.getCropBlock()).properties(StatePredicate.Builder.create()
                            .exactMatch(Properties.AGE_7, 0));

            BlockStatePropertyLootCondition.Builder max_age_condition = BlockStatePropertyLootCondition
                    .builder(entry.getCropBlock()).properties(StatePredicate.Builder.create()
                            .exactMatch(Properties.AGE_7, 7)
                            .exactMatch(ModProperties.MOD_FERTILIZED, 0)
                            .exactMatch(ModProperties.MOD_PESTICIDED, 0));

            BlockStatePropertyLootCondition.Builder max_age_condition_fertilized_1 = BlockStatePropertyLootCondition
                    .builder(entry.getCropBlock())
                    .properties(StatePredicate.Builder.create()
                            .exactMatch(Properties.AGE_7, 7)
                            .exactMatch(ModProperties.MOD_FERTILIZED, 1)
                            .exactMatch(ModProperties.MOD_PESTICIDED, 0));

            BlockStatePropertyLootCondition.Builder max_age_condition_fertilized_1_pesticided_1 = BlockStatePropertyLootCondition
                    .builder(entry.getCropBlock())
                    .properties(StatePredicate.Builder.create()
                            .exactMatch(Properties.AGE_7, 7)
                            .exactMatch(ModProperties.MOD_FERTILIZED, 1)
                            .exactMatch(ModProperties.MOD_PESTICIDED, 1));

            BlockStatePropertyLootCondition.Builder max_age_condition_fertilized_2_pesticided_1 = BlockStatePropertyLootCondition
                    .builder(entry.getCropBlock())
                    .properties(StatePredicate.Builder.create()
                            .exactMatch(Properties.AGE_7, 7)
                            .exactMatch(ModProperties.MOD_FERTILIZED, 2)
                            .exactMatch(ModProperties.MOD_PESTICIDED, 1));

            this.addDrop(entry.getCropBlock(), this.applyExplosionDecay(entry.getCropBlock(),
                    LootTable.builder()
                            .pool(LootPool.builder().conditionally(no_age_condition) //only drop seed, IF age is still 0.
                                    .with(ItemEntry.builder(entry.getSeedItem())))

                            .pool(LootPool.builder().conditionally(max_age_condition)
                                    .with((LootPoolEntry.Builder<?>) ((Object) ItemEntry.builder(entry.getDropItem())
                                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1), true))))) //should drop x2

                            .pool(LootPool.builder()
                                    .conditionally(max_age_condition_fertilized_1)
                                    .with((LootPoolEntry.Builder<?>) ItemEntry.builder(entry.getDropItem())
                                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 3), true)))) //should drop x4

                            .pool(LootPool.builder()
                                    .conditionally(max_age_condition_fertilized_1_pesticided_1)
                                    .with((LootPoolEntry.Builder<?>) ItemEntry.builder(entry.getDropItem())
                                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 5), true)))) //should drop x6

                            .pool(LootPool.builder()
                                    .conditionally(max_age_condition_fertilized_2_pesticided_1)
                                    .with((LootPoolEntry.Builder<?>) ItemEntry.builder(entry.getDropItem())
                                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(7, 7), true)))) //should drop x8
            ));
        }











        //DOESN'T QUIET WORK RIGHT...
        //this.addDrop(ModBlocks.RICE_CROP, (Block block) -> LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f)).with((LootPoolEntry.Builder)this.applyExplosionDecay((ItemConvertible)block, ItemEntry.builder(ModItems.RICE_PANICLE).apply((LootFunction.Builder)((Object)SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(Properties.AGE_7, 7)))))))));
    }
}