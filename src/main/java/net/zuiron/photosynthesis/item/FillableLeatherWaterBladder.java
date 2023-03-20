package net.zuiron.photosynthesis.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Right click near water to fill.").formatted(Formatting.ITALIC, Formatting.DARK_GRAY));
    }

    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity && !world.isClient) {
            if(isAroundWaterThem(serverPlayerEntity, world, 1)) {
                stack.damage(1, user, (e) -> {
                    Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
                });
                ItemStack stackInHand = serverPlayerEntity.getStackInHand(serverPlayerEntity.getActiveHand());
                if(stackInHand.isEmpty()) {
                    serverPlayerEntity.giveItemStack(new ItemStack(ModItems.LEATHER_WATER_BLADDER_DIRTY));
                    world.playSound(
                            null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                            serverPlayerEntity.getBlockPos(), // The position of where the sound will come from
                            SoundEvents.ITEM_BUCKET_FILL, // The sound that will play, in this case, the sound the anvil plays when it lands.
                            SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                            1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                            1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                    );
                }
            } else {
                serverPlayerEntity.sendMessage(Text.translatable("message.photosynthesis.no_water_nearby")
                        .fillStyle(Style.EMPTY.withColor(Formatting.RED)), false);
            }
        }
    }

    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.NONE;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity && !world.isClient()) {
            return ItemUsage.consumeHeldItem(world, user, hand);
        } else {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
    }
}
