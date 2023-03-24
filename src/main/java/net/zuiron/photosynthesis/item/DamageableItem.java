package net.zuiron.photosynthesis.item;

import net.minecraft.item.Item;

public class DamageableItem extends Item {
    public DamageableItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isDamageable() {
        return true;
    }


}
