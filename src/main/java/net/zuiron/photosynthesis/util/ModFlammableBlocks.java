package net.zuiron.photosynthesis.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.zuiron.photosynthesis.block.ModBlocks;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.APPLETREE_LOG, 5, 5);
        registry.add(ModBlocks.APPLETREE_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_APPLETREE_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_APPLETREE_WOOD, 5, 5);

        registry.add(ModBlocks.APPLETREE_PLANKS, 5, 20);
        registry.add(ModBlocks.APPLETREE_LEAVES, 30, 60);



        registry.add(ModBlocks.CINNAMON_LOG, 5, 5);
        registry.add(ModBlocks.CINNAMON_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_CINNAMON_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_CINNAMON_WOOD, 5, 5);

        registry.add(ModBlocks.CINNAMON_PLANKS, 5, 20);
        registry.add(ModBlocks.CINNAMON_LEAVES, 30, 60);
    }
}