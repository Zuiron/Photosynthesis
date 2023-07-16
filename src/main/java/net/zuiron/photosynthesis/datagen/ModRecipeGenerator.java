package net.zuiron.photosynthesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.block.ModBlocks;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        /*
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_CITRINE)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('C', ModItems.CITRINE)
                .criterion(FabricRecipeProvider.hasItem(Items.STONE),
                        FabricRecipeProvider.conditionsFromItem(Items.STONE))
                .criterion(FabricRecipeProvider.hasItem(ModItems.CITRINE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CITRINE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RAW_CITRINE)));
         */

        /*final TagKey<Item> APPLETREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "appletree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLETREE_PLANKS, 4)
                .input(APPLETREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.APPLETREE_LOG),FabricRecipeProvider.conditionsFromItem(ModBlocks.APPLETREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.APPLETREE_PLANKS)));
        */
        final TagKey<Item> APPLETREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "appletree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLETREE_PLANKS, 4)
                .input(APPLETREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.APPLETREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.APPLETREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.APPLETREE_PLANKS)));

        final TagKey<Item> CINNAMON_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "cinnamon_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CINNAMON_PLANKS, 4)
                .input(CINNAMON_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.CINNAMON_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.CINNAMON_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.CINNAMON_PLANKS)));

        final TagKey<Item> BANANATREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "bananatree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANATREE_PLANKS, 4)
                .input(BANANATREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BANANATREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.BANANATREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.BANANATREE_PLANKS)));

        final TagKey<Item> ORANGETREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "orangetree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGETREE_PLANKS, 4)
                .input(ORANGETREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.ORANGETREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.ORANGETREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.ORANGETREE_PLANKS)));

        final TagKey<Item> PEARTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "peartree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PEARTREE_PLANKS, 4)
                .input(PEARTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PEARTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PEARTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PEARTREE_PLANKS)));

        final TagKey<Item> AVOCADOTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "avocadotree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AVOCADOTREE_PLANKS, 4)
                .input(AVOCADOTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.AVOCADOTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.AVOCADOTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.AVOCADOTREE_PLANKS)));

        final TagKey<Item> COCONUTTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "coconuttree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCONUTTREE_PLANKS, 4)
                .input(COCONUTTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.COCONUTTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.COCONUTTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.COCONUTTREE_PLANKS)));

        final TagKey<Item> CHERRYTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "cherrytree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRYTREE_PLANKS, 4)
                .input(CHERRYTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.CHERRYTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.CHERRYTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.CHERRYTREE_PLANKS)));

        final TagKey<Item> LEMONTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "lemontree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMONTREE_PLANKS, 4)
                .input(LEMONTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.LEMONTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.LEMONTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.LEMONTREE_PLANKS)));

        final TagKey<Item> OLIVETREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "olivetree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVETREE_PLANKS, 4)
                .input(OLIVETREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OLIVETREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.OLIVETREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.OLIVETREE_PLANKS)));

        final TagKey<Item> RUBBERTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "rubbertree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBBERTREE_PLANKS, 4)
                .input(RUBBERTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.RUBBERTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.RUBBERTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.RUBBERTREE_PLANKS)));

        final TagKey<Item> CANDLENUTTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "candlenuttree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CANDLENUTTREE_PLANKS, 4)
                .input(CANDLENUTTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.CANDLENUTTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.CANDLENUTTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.CANDLENUTTREE_PLANKS)));

        final TagKey<Item> CHESTNUTTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "chestnuttree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHESTNUTTREE_PLANKS, 4)
                .input(CHESTNUTTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.CHESTNUTTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.CHESTNUTTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.CHESTNUTTREE_PLANKS)));

        final TagKey<Item> NUTMEGTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "nutmegtree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NUTMEGTREE_PLANKS, 4)
                .input(NUTMEGTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.NUTMEGTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.NUTMEGTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.NUTMEGTREE_PLANKS)));

        final TagKey<Item> PEACHTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "peachtree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PEACHTREE_PLANKS, 4)
                .input(PEACHTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PEACHTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PEACHTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PEACHTREE_PLANKS)));

        final TagKey<Item> PLUMTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "plumtree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLUMTREE_PLANKS, 4)
                .input(PLUMTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PLUMTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PLUMTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PLUMTREE_PLANKS)));

        final TagKey<Item> WALNUTTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "walnuttree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUTTREE_PLANKS, 4)
                .input(WALNUTTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.WALNUTTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.WALNUTTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.WALNUTTREE_PLANKS)));

        final TagKey<Item> HAZELNUTTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "hazelnuttree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAZELNUTTREE_PLANKS, 4)
                .input(HAZELNUTTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.HAZELNUTTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.HAZELNUTTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.HAZELNUTTREE_PLANKS)));

        final TagKey<Item> PAWPAWTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "pawpawtree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PAWPAWTREE_PLANKS, 4)
                .input(PAWPAWTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PAWPAWTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PAWPAWTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PAWPAWTREE_PLANKS)));

        final TagKey<Item> SOURSOPTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "soursoptree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOURSOPTREE_PLANKS, 4)
                .input(SOURSOPTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SOURSOPTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.SOURSOPTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.SOURSOPTREE_PLANKS)));

        final TagKey<Item> ALMONDTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "almondtree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALMONDTREE_PLANKS, 4)
                .input(ALMONDTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.ALMONDTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.ALMONDTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.ALMONDTREE_PLANKS)));

        final TagKey<Item> APRICOTTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "apricottree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APRICOTTREE_PLANKS, 4)
                .input(APRICOTTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.APRICOTTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.APRICOTTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.APRICOTTREE_PLANKS)));

        final TagKey<Item> CASHEWTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "cashewtree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CASHEWTREE_PLANKS, 4)
                .input(CASHEWTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.CASHEWTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.CASHEWTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.CASHEWTREE_PLANKS)));

        final TagKey<Item> DATETREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "datetree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DATETREE_PLANKS, 4)
                .input(DATETREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.DATETREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.DATETREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.DATETREE_PLANKS)));

        final TagKey<Item> DRAGONFRUITTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "dragonfruittree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRAGONFRUITTREE_PLANKS, 4)
                .input(DRAGONFRUITTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.DRAGONFRUITTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.DRAGONFRUITTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.DRAGONFRUITTREE_PLANKS)));

        final TagKey<Item> DURIANTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "duriantree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DURIANTREE_PLANKS, 4)
                .input(DURIANTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.DURIANTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.DURIANTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.DURIANTREE_PLANKS)));

        final TagKey<Item> FIGTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "figtree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIGTREE_PLANKS, 4)
                .input(FIGTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.FIGTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.FIGTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.FIGTREE_PLANKS)));

        final TagKey<Item> GRAPEFRUITTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "grapefruittree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPEFRUITTREE_PLANKS, 4)
                .input(GRAPEFRUITTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GRAPEFRUITTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.GRAPEFRUITTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.GRAPEFRUITTREE_PLANKS)));

        final TagKey<Item> LIMETREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "limetree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMETREE_PLANKS, 4)
                .input(LIMETREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.LIMETREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.LIMETREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.LIMETREE_PLANKS)));

        final TagKey<Item> PAPAYATREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "papayatree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PAPAYATREE_PLANKS, 4)
                .input(PAPAYATREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PAPAYATREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PAPAYATREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PAPAYATREE_PLANKS)));

        final TagKey<Item> PECANTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "pecantree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PECANTREE_PLANKS, 4)
                .input(PECANTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PECANTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PECANTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PECANTREE_PLANKS)));

        final TagKey<Item> PERSIMMONTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "persimmontree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PERSIMMONTREE_PLANKS, 4)
                .input(PERSIMMONTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PERSIMMONTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PERSIMMONTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PERSIMMONTREE_PLANKS)));

        final TagKey<Item> PISTACHIOTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "pistachiotree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PISTACHIOTREE_PLANKS, 4)
                .input(PISTACHIOTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PISTACHIOTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PISTACHIOTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PISTACHIOTREE_PLANKS)));

        final TagKey<Item> POMEGRANATETREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "pomegranatetree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POMEGRANATETREE_PLANKS, 4)
                .input(POMEGRANATETREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POMEGRANATETREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.POMEGRANATETREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.POMEGRANATETREE_PLANKS)));

        final TagKey<Item> STARFRUITTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "starfruittree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STARFRUITTREE_PLANKS, 4)
                .input(STARFRUITTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STARFRUITTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.STARFRUITTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.STARFRUITTREE_PLANKS)));

        final TagKey<Item> BREADFRUITTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "breadfruittree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BREADFRUITTREE_PLANKS, 4)
                .input(BREADFRUITTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BREADFRUITTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.BREADFRUITTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.BREADFRUITTREE_PLANKS)));

        final TagKey<Item> GUAVATREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "guavatree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GUAVATREE_PLANKS, 4)
                .input(GUAVATREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GUAVATREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.GUAVATREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.GUAVATREE_PLANKS)));

        final TagKey<Item> JACKFRUITTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "jackfruittree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JACKFRUITTREE_PLANKS, 4)
                .input(JACKFRUITTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.JACKFRUITTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.JACKFRUITTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.JACKFRUITTREE_PLANKS)));

        final TagKey<Item> LYCHEETREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "lycheetree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LYCHEETREE_PLANKS, 4)
                .input(LYCHEETREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.LYCHEETREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.LYCHEETREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.LYCHEETREE_PLANKS)));

        final TagKey<Item> PASSIONFRUITTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "passionfruittree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PASSIONFRUITTREE_PLANKS, 4)
                .input(PASSIONFRUITTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PASSIONFRUITTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PASSIONFRUITTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PASSIONFRUITTREE_PLANKS)));

        final TagKey<Item> RAMBUTANTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "rambutantree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAMBUTANTREE_PLANKS, 4)
                .input(RAMBUTANTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.RAMBUTANTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.RAMBUTANTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.RAMBUTANTREE_PLANKS)));

        final TagKey<Item> TAMARINDTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "tamarindtree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TAMARINDTREE_PLANKS, 4)
                .input(TAMARINDTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TAMARINDTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.TAMARINDTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.TAMARINDTREE_PLANKS)));

        final TagKey<Item> MAPLETREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "mapletree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLETREE_PLANKS, 4)
                .input(MAPLETREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MAPLETREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.MAPLETREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.MAPLETREE_PLANKS)));

        final TagKey<Item> PEPPERCORNTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "peppercorntree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PEPPERCORNTREE_PLANKS, 4)
                .input(PEPPERCORNTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PEPPERCORNTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PEPPERCORNTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PEPPERCORNTREE_PLANKS)));

        final TagKey<Item> VANILLABEANTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "vanillabeantree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VANILLABEANTREE_PLANKS, 4)
                .input(VANILLABEANTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.VANILLABEANTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.VANILLABEANTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.VANILLABEANTREE_PLANKS)));

        final TagKey<Item> PINENUTTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "pinenuttree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINENUTTREE_PLANKS, 4)
                .input(PINENUTTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PINENUTTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.PINENUTTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.PINENUTTREE_PLANKS)));

        final TagKey<Item> GOOSEBERRYTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "gooseberrytree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOOSEBERRYTREE_PLANKS, 4)
                .input(GOOSEBERRYTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GOOSEBERRYTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.GOOSEBERRYTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.GOOSEBERRYTREE_PLANKS)));

        final TagKey<Item> MANGOTREE_LOGS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "mangotree_logs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGOTREE_PLANKS, 4)
                .input(MANGOTREE_LOGS_ITEMS)
                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MANGOTREE_LOG), FabricRecipeProvider.conditionsFromItem(ModBlocks.MANGOTREE_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.MANGOTREE_PLANKS)));


    }
}
