package net.zuiron.photosynthesis.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.zuiron.photosynthesis.block.ModBlocks;

public class ModStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.APPLETREE_LOG, ModBlocks.STRIPPED_APPLETREE_LOG);
        StrippableBlockRegistry.register(ModBlocks.APPLETREE_WOOD, ModBlocks.STRIPPED_APPLETREE_WOOD);

        StrippableBlockRegistry.register(ModBlocks.BANANATREE_LOG, ModBlocks.STRIPPED_BANANATREE_LOG);
        StrippableBlockRegistry.register(ModBlocks.BANANATREE_WOOD, ModBlocks.STRIPPED_BANANATREE_WOOD);

        StrippableBlockRegistry.register(ModBlocks.CINNAMON_LOG, ModBlocks.STRIPPED_CINNAMON_LOG);
        StrippableBlockRegistry.register(ModBlocks.CINNAMON_WOOD, ModBlocks.STRIPPED_CINNAMON_WOOD);

        StrippableBlockRegistry.register(ModBlocks.ORANGETREE_LOG, ModBlocks.STRIPPED_ORANGETREE_LOG);
        StrippableBlockRegistry.register(ModBlocks.ORANGETREE_WOOD, ModBlocks.STRIPPED_ORANGETREE_WOOD);
    }
}
