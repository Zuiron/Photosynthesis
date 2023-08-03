package net.zuiron.photosynthesis.datagen.entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BerryAndBushDropEntry {
    private final Block berryBush;
    private final Item berryDrop;
    private final int age;
    private final float minCount;
    private final float maxCount;

    public BerryAndBushDropEntry(Block berryBush, Item berryDrop, int age, float minCount, float maxCount) {
        this.berryBush = berryBush;
        this.berryDrop = berryDrop;
        this.age = age;
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    // Getters for the variables
    public Block getBerryBush() {
        return berryBush;
    }

    public Item getBerryDrop() {
        return berryDrop;
    }

    public int getAge() {
        return age;
    }

    public float getMinCount() {
        return minCount;
    }

    public float getMaxCount() {
        return maxCount;
    }
}