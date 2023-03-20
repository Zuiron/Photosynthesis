package net.zuiron.photosynthesis.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FillableLeatherWaterBladder extends Item {
    public FillableLeatherWaterBladder(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    private static boolean isAroundWaterThem(ServerPlayerEntity player, World world, int size) {
        return BlockPos.stream(player.getBoundingBox().expand(size))
                .map(world::getBlockState).filter(state -> state.isOf(Blocks.WATER)).toArray().length > 0;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            if(isAroundWaterThem(serverPlayerEntity, world, 2)) {
                stack.damage(1, user, (e) -> {
                    //Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
                });
                return stack.isEmpty() ? new ItemStack(ModItems.LEATHER_WATER_BLADDER_DIRTY) : stack;
            }
        }
        return new ItemStack(Items.AIR);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            return ItemUsage.consumeHeldItem(world, user, hand);
        } else {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
    }
}
