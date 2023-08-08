package net.zuiron.photosynthesis.item;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
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



        //tooltip.add(Text.literal("damage: "));


        int remain = stack.getMaxDamage() - stack.getDamage();
        tooltip.add(Text.literal("Durability: "+remain+"/"+stack.getMaxDamage()));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
