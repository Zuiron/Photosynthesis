package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.fluid.ModFluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GoatEntity.class)
public abstract class ModGoatEntity extends AnimalEntity {
    protected ModGoatEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.BUCKET) && !this.isBaby()) {
            //player.playSound(this.getMilkingSound(), 1.0F, 1.0F);
            player.playSound(SoundEvents.ENTITY_GOAT_MILK, 1.0F, 1.0F);
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, ModFluids.GOATMILK_BUCKET.getDefaultStack());
            player.setStackInHand(hand, itemStack2);
            //return ActionResult.success(this.getWorld().isClient);
            cir.setReturnValue(ActionResult.success(this.getWorld().isClient));
        } else {
            ActionResult actionResult = super.interactMob(player, hand);
            if (actionResult.isAccepted() && this.isBreedingItem(itemStack)) {
                this.getWorld().playSoundFromEntity((PlayerEntity)null, this, this.getEatSound(itemStack), SoundCategory.NEUTRAL, 1.0F, MathHelper.nextBetween(this.getWorld().random, 0.8F, 1.2F));
            }

            //return actionResult;
            cir.setReturnValue(actionResult);
        }
        cir.cancel(); //do not run vanilla code.
    }
}
