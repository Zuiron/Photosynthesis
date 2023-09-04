package net.zuiron.photosynthesis.item.advanced;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class StackableStewItem extends Item {
    public StackableStewItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if(!world.isClient) {
            user.dropStack(new ItemStack(Items.BOWL, 1));
        }
        return super.finishUsing(stack, world, user);
    }
}
