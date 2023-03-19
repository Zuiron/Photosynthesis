package net.zuiron.photosynthesis.item;

import com.mojang.datafixers.util.Pair;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.util.IEntityDataSaver;
import net.zuiron.photosynthesis.util.ThirstData;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ThirstItem extends Item {
    private final int addThirst;
    private final int addThirstSat;
    public ThirstItem(Settings settings, int addThirst, int addThirstSat) {
        super(settings);
        this.addThirst = addThirst;
        this.addThirstSat = addThirstSat;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    private void applyFoodEffects(ItemStack stack, World world, LivingEntity targetEntity) {
        Item item = stack.getItem();
        if (item.isFood()) {
            List<Pair<StatusEffectInstance, Float>> list = Objects.requireNonNull(item.getFoodComponent()).getStatusEffects();

            for (Pair<StatusEffectInstance, Float> pair : list) {
                if (!world.isClient && pair.getFirst() != null && world.random.nextFloat() < pair.getSecond()) {
                    targetEntity.addStatusEffect(new StatusEffectInstance(pair.getFirst()));
                }
            }
        }

    }
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            ThirstData.addThirst((IEntityDataSaver)serverPlayerEntity, addThirst);
            ThirstData.addThirstSaturation((IEntityDataSaver)serverPlayerEntity, addThirstSat);
            if (stack.isFood()) {
                this.applyFoodEffects(stack, world, user);
            }
            stack.damage(1, user, (e) -> {
                Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            });
        }
        ItemStack recipeRemain = this.getRecipeRemainder(stack);
        return stack.isEmpty() ? new ItemStack(recipeRemain.getItem()) : stack;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        String thirst = "";
        String thirstSat = "";

        for (int i = 0; i < addThirst; i++) {
            thirst = thirst + "\uE001";
        }
        tooltip.add(Text.literal(thirst));

        for (int i = 0; i < addThirstSat / 60; i++) {
            thirstSat = thirstSat + "\uE002";
        }
        if(addThirstSat > 0) {
            tooltip.add(Text.literal(thirstSat));
        }

        int remain = stack.getMaxDamage() - stack.getDamage();
        tooltip.add(Text.literal("Uses: "+remain+"/"+stack.getMaxDamage()));
        super.appendTooltip(stack, world, tooltip, context);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            //prevent drinking if full. nahhhhhh
            /*ItemStack itemStack = user.getStackInHand(hand);
            int Thirst = ThirstData.getThirst((IEntityDataSaver)serverPlayerEntity);
            if (Thirst < 10) {
                return ItemUsage.consumeHeldItem(world, user, hand);
            } else {
                return TypedActionResult.fail(itemStack);
            }*/
            return ItemUsage.consumeHeldItem(world, user, hand);
        } else {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
    }
}
