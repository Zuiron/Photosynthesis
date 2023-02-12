package net.zuiron.photosynthesis.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PrimitiveToolMaterial implements ToolMaterial {
    public static final PrimitiveToolMaterial INSTANCE = new PrimitiveToolMaterial();

    @Override
    public int getDurability() {
        return 30;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 1.0F;
    }

    @Override
    public float getAttackDamage() {
        return 0.0F;
    }

    @Override
    public int getMiningLevel() {
        return -1;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
