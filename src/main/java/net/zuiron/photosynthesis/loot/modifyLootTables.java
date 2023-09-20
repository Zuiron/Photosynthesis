package net.zuiron.photosynthesis.loot;

import net.fabricmc.fabric.api.loot.v2.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.item.ModItems;

public class modifyLootTables {
    private static final Identifier GRASS_ID1 = new Identifier("minecraft", "blocks/grass");
    private static final Identifier GRASS_ID = Blocks.GRASS.getLootTableId();
    private static final Identifier TALL_GRASS_ID = Blocks.TALL_GRASS.getLootTableId();

    private static final Identifier WHEAT_ID = Blocks.WHEAT.getLootTableId();
    private static final Identifier BARLEY_ID = ModBlocks.BARLEY_CROP.getLootTableId();
    private static final Identifier OAT_ID = ModBlocks.OAT_CROP.getLootTableId();
    private static final Identifier RICE_ID = ModBlocks.RICE_CROP.getLootTableId();

    private static final Identifier COMMON_COW_LOOT_TABLE_ID = new Identifier("minecraft", "entities/cow");
    private static final Identifier COMMON_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep");
    private static final Identifier COMMON_CHICKEN_LOOT_TABLE_ID = new Identifier("minecraft", "entities/chicken");
    private static final Identifier COMMON_PIG_LOOT_TABLE_ID = new Identifier("minecraft", "entities/pig");
    private static final Identifier COMMON_BOAR_LOOT_TABLE_ID = new Identifier("photosynthesis", "entities/boar");
    private static final Identifier COMMON_HORSE_LOOT_TABLE_ID = new Identifier("minecraft", "entities/horse");
    private static final Identifier COMMON_WOLF_LOOT_TABLE_ID = new Identifier("minecraft", "entities/wolf");


    private static final Identifier COD_LTID = new Identifier("minecraft", "entities/cod");
    private static final Identifier SALMON_LTID = new Identifier("minecraft", "entities/salmon");

    public static void registerModifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            // Let's only modify built-in loot tables and leave data pack loot tables untouched by checking the source.
            // We also check that the loot table ID is equal to the ID we want.
            if(source.isBuiltin() && COMMON_WOLF_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.WOLF_PELT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(source.isBuiltin() && COD_LTID.equals(id) || SALMON_LTID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.FISH_ROE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(source.isBuiltin() && COMMON_HORSE_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.HORSE_MEAT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(14.0f, 20.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.HORSE_BONES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.HORSE_HAIR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.HORSE_LEATHER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(source.isBuiltin() && COMMON_PIG_LOOT_TABLE_ID.equals(id) || COMMON_BOAR_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.RAW_BACON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.PORKCHOP))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.PIG_TRIMMINGS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(10.0f, 12.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.PIG_BELLY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.RAW_HAM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.PIG_SKIN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.PIG_BONES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(source.isBuiltin() && COMMON_CHICKEN_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.CHICKEN_BONES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.CHICKEN_FEET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.CHICKEN_TRIMMINGS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5.0f, 7.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.CHICKEN_THIGH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.CHICKEN_WINGS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.CHICKEN_LIVER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(source.isBuiltin() && COMMON_SHEEP_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.SHEEP_BONES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.SHEEP_TRIMMINGS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(10.0f, 12.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.SHEEP_RIBS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.SHEEP_LEGS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 4.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.MUTTON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0f, 8.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(source.isBuiltin() && COMMON_COW_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.COW_STEAK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0f, 8.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.COW_RIBS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.RAW_LEATHER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 6.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.COW_TRIMMINGS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(10.0f, 12.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.COW_BRISKET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.COW_LIVER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.COW_KIDNEY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.COW_HEARTH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());

                poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.COW_TONGUE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (source.isBuiltin() && WHEAT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.STRAW_PIECE))
                        .conditionally(BlockStatePropertyLootCondition.builder(Blocks.WHEAT).properties(StatePredicate.Builder.create().exactMatch(Properties.AGE_7, 7)))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 6.0f)).build());
                tableBuilder.pool(poolBuilder);
            }

            if (source.isBuiltin() && BARLEY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.STRAW_PIECE))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.BARLEY_CROP).properties(StatePredicate.Builder.create().exactMatch(Properties.AGE_7, 7)))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 6.0f)).build());
                tableBuilder.pool(poolBuilder);
            }

            if (source.isBuiltin() && OAT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.STRAW_PIECE))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.OAT_CROP).properties(StatePredicate.Builder.create().exactMatch(Properties.AGE_7, 7)))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 6.0f)).build());
                tableBuilder.pool(poolBuilder);
            }

            if (source.isBuiltin() && RICE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.STRAW_PIECE))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP).properties(StatePredicate.Builder.create().exactMatch(Properties.AGE_7, 7)))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 6.0f)).build());
                tableBuilder.pool(poolBuilder);
            }

            if (source.isBuiltin() && GRASS_ID.equals(id) || TALL_GRASS_ID.equals(id)) {
                //grass fibre piece drops if grass is hit with cutting knifes.
                final TagKey<Item> CUTTING_KNIFES = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "cutting_board_cutting_knifes"));
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.GRASS_FIBRE_PIECE))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(CUTTING_KNIFES)).build())
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && GRASS_ID.equals(id) || TALL_GRASS_ID.equals(id)) {
                //seeds drop from grass if hit with garden grubbers - NOPE
                //just grass seeds drop from punching grass.
                final TagKey<Item> GARDEN_GRUBBERS = TagKey.of(RegistryKeys.ITEM, new Identifier("photosynthesis", "garden_grubbers"));
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.GRASS_SEEDS))
                        /*.with(ItemEntry.builder(ModItems.TOMATO_SEEDS))
                        .with(ItemEntry.builder(ModItems.BASIL_SEEDS))
                        .with(ItemEntry.builder(ModItems.OREGANO_SEEDS))
                        .with(ItemEntry.builder(ModItems.STRAWBERRY_SEEDS))
                        .with(ItemEntry.builder(ModItems.OAT_SEEDS))
                        .with(ItemEntry.builder(ModItems.JALAPENO_SEEDS))
                        .with(ItemEntry.builder(ModItems.CHILI_SEEDS))
                        .with(ItemEntry.builder(ModItems.CUCUMBER_SEEDS))
                        .with(ItemEntry.builder(ModItems.ONION_SEEDS))
                        .with(ItemEntry.builder(ModItems.LEEK_SEEDS))
                        .with(ItemEntry.builder(ModItems.CELERY_SEEDS))
                        .with(ItemEntry.builder(ModItems.PEAS_SEEDS))
                        .with(ItemEntry.builder(ModItems.SWEET_POTATO_SEEDS))
                        .with(ItemEntry.builder(ModItems.ASPARAGUS_SEEDS))
                        .with(ItemEntry.builder(ModItems.SCALLION_SEEDS))

                        .with(ItemEntry.builder(ModItems.GARLIC_SEEDS))
                        .with(ItemEntry.builder(ModItems.CHIVE_SEEDS))
                        .with(ItemEntry.builder(ModItems.BROCCOLI_SEEDS))
                        .with(ItemEntry.builder(ModItems.CAULIFLOWER_SEEDS))
                        .with(ItemEntry.builder(ModItems.CORN_SEEDS))
                        .with(ItemEntry.builder(ModItems.CABBAGE_SEEDS))
                        .with(ItemEntry.builder(ModItems.BELLPEPPER_SEEDS))
                        .with(ItemEntry.builder(ModItems.TURNIP_SEEDS))
                        .with(ItemEntry.builder(ModItems.RUTABAGA_SEEDS))
                        .with(ItemEntry.builder(ModItems.CANOLA_SEEDS))
                        .with(ItemEntry.builder(ModItems.BARLEY_SEEDS))
                        .with(ItemEntry.builder(ModItems.COTTON_SEEDS))
                        .with(ItemEntry.builder(ModItems.SUGARBEET_SEEDS))
                        .with(ItemEntry.builder(ModItems.RICE_SEEDS))
                        .with(ItemEntry.builder(ModItems.SOYBEAN_SEEDS))
                        .with(ItemEntry.builder(ModItems.SPINACH_SEEDS))
                        .with(ItemEntry.builder(ModItems.ARROWROOT_SEEDS))
                        .with(ItemEntry.builder(ModItems.ARTICHOKE_SEEDS))
                        .with(ItemEntry.builder(ModItems.BRUSSELS_SPROUTS_SEEDS))
                        .with(ItemEntry.builder(ModItems.CASSAVA_SEEDS))

                        .with(ItemEntry.builder(ModItems.EGGPLANT_SEEDS))
                        .with(ItemEntry.builder(ModItems.SUNFLOWER_SEEDS))
                        .with(ItemEntry.builder(ModItems.JICAMA_SEEDS))
                        .with(ItemEntry.builder(ModItems.KALE_SEEDS))
                        .with(ItemEntry.builder(ModItems.KOHLRABI_SEEDS))
                        .with(ItemEntry.builder(ModItems.LETTUCE_SEEDS))
                        .with(ItemEntry.builder(ModItems.OKRA_SEEDS))
                        .with(ItemEntry.builder(ModItems.PARSNIP_SEEDS))
                        .with(ItemEntry.builder(ModItems.RADISH_SEEDS))
                        .with(ItemEntry.builder(ModItems.RHUBARB_SEEDS))
                        .with(ItemEntry.builder(ModItems.MILLET_SEEDS))
                        .with(ItemEntry.builder(ModItems.RYE_SEEDS))
                        .with(ItemEntry.builder(ModItems.SQUASH_SEEDS))
                        .with(ItemEntry.builder(ModItems.ZUCCHINI_SEEDS))
                        .with(ItemEntry.builder(ModItems.COFFEA_SEEDS))
                        .with(ItemEntry.builder(ModItems.PARSLEY_SEEDS))
                        .with(ItemEntry.builder(ModItems.MINT_SEEDS))
                        .with(ItemEntry.builder(ModItems.PINEAPPLE_SEEDS))
                        .with(ItemEntry.builder(ModItems.HOP_SEEDS))
                        .with(ItemEntry.builder(ModItems.FILIPENDULA_SEEDS))

                        .with(ItemEntry.builder(ModItems.CAMELLIA_SINENSIS_SEEDS))
                        .with(ItemEntry.builder(ModItems.NICOTIANA_RUSTICA_SEEDS))
                        .with(ItemEntry.builder(ModItems.PAPAVER_SOMNIFERUM_SEEDS))
                        .with(ItemEntry.builder(ModItems.ERYTHROXYLUM_COCA_SEEDS))
                        .with(ItemEntry.builder(ModItems.CACTUS_FRUIT_SEEDS))
                        .with(ItemEntry.builder(ModItems.CANTALOUPE_SEEDS))
                        .with(ItemEntry.builder(ModItems.FLAX_SEEDS))
                        .with(ItemEntry.builder(ModItems.JUTE_SEEDS))
                        .with(ItemEntry.builder(ModItems.KENAF_SEEDS))
                        .with(ItemEntry.builder(ModItems.SISAL_SEEDS))
                        .with(ItemEntry.builder(ModItems.AMARANTH_SEEDS))
                        .with(ItemEntry.builder(ModItems.BEAN_SEEDS))
                        .with(ItemEntry.builder(ModItems.CHICKPEA_SEEDS))
                        .with(ItemEntry.builder(ModItems.LENTIL_SEEDS))
                        .with(ItemEntry.builder(ModItems.QUINOA_SEEDS))
                        .with(ItemEntry.builder(ModItems.PEANUT_SEEDS))
                        .with(ItemEntry.builder(ModItems.TARO_SEEDS))
                        .with(ItemEntry.builder(ModItems.TOMATILLO_SEEDS))
                        .with(ItemEntry.builder(ModItems.AGAVE_SEEDS))
                        .with(ItemEntry.builder(ModItems.GINGER_SEEDS))

                        .with(ItemEntry.builder(ModItems.SESAME_SEEDS))
                        .with(ItemEntry.builder(ModItems.MUSTARD_SEEDS))*/
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(GARDEN_GRUBBERS)).build())
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
