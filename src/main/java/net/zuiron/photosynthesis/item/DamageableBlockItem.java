package net.zuiron.photosynthesis.item;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DamageableBlockItem extends BlockItem {
    public DamageableBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.isOf(ModBlocks.GRASS_BALE.asItem()) || stack.isOf(ModBlocks.STRAW_BALE.asItem()) || stack.isOf(ModBlocks.HAY_BALE.asItem())) {
            //int remain = stack.getMaxDamage() - stack.getDamage();
            //tooltip.add(Text.literal("Durability: " + remain + "/" + stack.getMaxDamage()));

            int remain = stack.getMaxDamage() - stack.getDamage();
            double pct = ((double) remain / stack.getMaxDamage()) * 100.0;
            int pctInt = (int) Math.round(pct);
            tooltip.add(Text.literal("Bale: " + pctInt + "%"));

        } else if (stack.isOf(ModBlocks.WRAPPED_GRASS_BALE.asItem())) {
            int remain = stack.getMaxDamage() - stack.getDamage();
            double pct = ((double) stack.getDamage() / stack.getMaxDamage()) * 100.0;
            int pctInt = (int) Math.round(pct);
            tooltip.add(Text.literal("Fermenting Silage: " + pctInt + "%"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
