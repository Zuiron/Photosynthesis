package net.zuiron.photosynthesis.datagen.entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class CropEntry {
    private final Block cropBlock;
    private final Item dropItem;

    public CropEntry(Block cropBlock, Item dropItem) {
        this.cropBlock = cropBlock;
        this.dropItem = dropItem;
    }

    // Getters for the variables
    public Block getCropBlock() {
        return cropBlock;
    }

    public Item getDropItem() {
        return dropItem;
    }
}