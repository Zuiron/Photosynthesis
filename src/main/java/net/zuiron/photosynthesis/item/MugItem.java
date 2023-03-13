package net.zuiron.photosynthesis.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.ItemDurabilityChangedCriterion;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class MugItem extends Item{
    public MugItem(Settings settings) {
        super(settings);
    }

    //TODO placing?
}
