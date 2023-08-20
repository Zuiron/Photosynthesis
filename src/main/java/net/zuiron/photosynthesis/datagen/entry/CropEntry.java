package net.zuiron.photosynthesis.datagen.entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class CropEntry {
    private final Block cropBlock;
    private final Item dropItem;
    private final Item seedItem;

    public CropEntry(Block cropBlock, Item dropItem, Item seedItem) {
        this.cropBlock = cropBlock;
        this.dropItem = dropItem;
        this.seedItem = seedItem;
    }

    // Getters for the variables
    public Block getCropBlock() {
        return cropBlock;
    }

    public Item getDropItem() {
        return dropItem;
    }

    public Item getSeedItem() {
        return seedItem;
    }
}