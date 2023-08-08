package net.zuiron.photosynthesis.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class DamageableBlockItem extends BlockItem {
    public DamageableBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public boolean isDamageable() {
        return true;
    }
}
