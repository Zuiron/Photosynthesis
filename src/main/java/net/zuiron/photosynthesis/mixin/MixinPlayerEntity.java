package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.event.PlayerEatEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class MixinPlayerEntity {
    @Inject(method = "eatFood", at = @At("HEAD"))
    private void onEatFood(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        if (stack.getItem().isFood()) {
            // Cast 'this' to PlayerEntity since we're inside a Mixin
            PlayerEntity player = (PlayerEntity) (Object) this;
            // Trigger the custom event
            PlayerEatEvent.EVENT.invoker().onPlayerEat(world, player, stack);
        }
    }
}
