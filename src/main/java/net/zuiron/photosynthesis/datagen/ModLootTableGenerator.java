package net.zuiron.photosynthesis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.item.ModItems;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.APPLETREE_PLANKS);

        addDrop(ModBlocks.DECORATION_ROCKS_RANDOM, ModItems.STONE_SMALL);
        addDrop(ModBlocks.DECORATION_STICKS_RANDOM, Items.STICK);
        addDrop(ModBlocks.DECORATION_SEASHELL, ModItems.SEASHELL);
    }
}