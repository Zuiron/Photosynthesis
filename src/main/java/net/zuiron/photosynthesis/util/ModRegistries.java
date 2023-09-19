package net.zuiron.photosynthesis.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.entity.ModEntities;
import net.zuiron.photosynthesis.entity.custom.BoarEntity;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.villager.ModVillagers;

public class ModRegistries {
    public static void registerModStuffs() {
        registerCustomTrades();
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.BOAR, BoarEntity.createBoarAttributes());
    }

    private static void registerCustomTrades() {
        /*TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.CAULIFLOWER, 2), 6, 2, 0.02f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(ModItems.SALT, 1), 2, 6, 0.08f
                    ));
                });*/

        TradeOfferHelper.registerVillagerOffers(ModVillagers.LIVESTOCK_TRADER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.CHICKEN_SPAWN_EGG, 1), 2, 100, 0.0f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.LIVESTOCK_TRADER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.SHEEP_SPAWN_EGG, 1), 2, 100, 0.0f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.LIVESTOCK_TRADER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.PIG_SPAWN_EGG, 1), 2, 100, 0.0f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.LIVESTOCK_TRADER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.COW_SPAWN_EGG, 1), 2, 100, 0.0f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.LIVESTOCK_TRADER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.GOAT_SPAWN_EGG, 1), 2, 100, 0.0f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.LIVESTOCK_TRADER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.HORSE_SPAWN_EGG, 1), 2, 100, 0.0f
                    ));
                });
    }
}
