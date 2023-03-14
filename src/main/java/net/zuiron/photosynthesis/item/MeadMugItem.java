package net.zuiron.photosynthesis.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
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

import java.util.List;

public class MeadMugItem extends MugItem {
    private final int addThirst;
    private final int addThirstSat;
    public MeadMugItem(Settings settings, int addThirst, int addThirstSat) {
        super(settings);
        this.addThirst = addThirst;
        this.addThirstSat = addThirstSat;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            ThirstData.addThirst((IEntityDataSaver)serverPlayerEntity, addThirst);
            ThirstData.addThirstSaturation((IEntityDataSaver)serverPlayerEntity, addThirstSat);

            stack.damage(1, user, (e) -> {
                Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            });
        }

        return stack.isEmpty() ? new ItemStack(ModItems.EMPTY_MUG) : stack;
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

        for (int i = 0; i < addThirst; i++) {
            thirst = thirst + "\uE001";
        }

        tooltip.add(Text.literal(thirst));
        int remain = stack.getMaxDamage() - stack.getDamage();
        tooltip.add(Text.literal("Uses: "+remain+"/"+stack.getMaxDamage()));
        super.appendTooltip(stack, world, tooltip, context);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            ItemStack itemStack = user.getStackInHand(hand);
            int Thirst = ThirstData.getThirst((IEntityDataSaver)serverPlayerEntity);
            if (Thirst < 10) {
                return ItemUsage.consumeHeldItem(world, user, hand);
            } else {
                return TypedActionResult.fail(itemStack);
            }
        } else {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
    }
}
