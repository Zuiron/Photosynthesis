package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.fluid.ModFluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GoatEntity.class)
public abstract class ModGoatEntity extends AnimalEntity {
    protected ModGoatEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }


    @Unique
    public int milkablecooldown;
    @Inject(method = "mobTick", at = @At("HEAD"), cancellable = false)
    protected void mobTick(CallbackInfo ci) {
        if(this.milkablecooldown < 8000) {
            this.milkablecooldown += 1;
        }
        //Photosynthesis.LOGGER.info("MobTick: "+this.milkablecooldown);
    }
    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("milkablecooldown", this.milkablecooldown);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.milkablecooldown = nbt.getInt("milkablecooldown");
    }

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack itemStack = player.getStackInHand(hand);
        //if (itemStack.isOf(Items.BUCKET) && !this.isBaby()) {
        //Photosynthesis.LOGGER.info("debug: "+this.milkablecooldown);
        if (itemStack.isOf(Items.BUCKET) && !this.isBaby() && this.milkablecooldown < 8000) {
            player.playSound(SoundEvents.ENTITY_GOAT_AMBIENT, 1.0F, 1.0F);
            if(this.milkablecooldown != 0) {
                Photosynthesis.LOGGER.info("ticks:" + this.milkablecooldown + "/8000");
            }
        }
        if (itemStack.isOf(Items.BUCKET) && !this.isBaby() && this.milkablecooldown >= 8000) { //24000 = one mc day, 8000 = 3 milking sessions per mc day.
            //player.playSound(this.getMilkingSound(), 1.0F, 1.0F);
            //Photosynthesis.LOGGER.info("MILK SUCCESS: ticks: "+this.milkablecooldown);
            player.playSound(SoundEvents.ENTITY_GOAT_MILK, 1.0F, 1.0F);
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, ModFluids.GOATMILK_BUCKET.getDefaultStack());
            player.getItemCooldownManager().set(itemStack2.getItem(), 40); //fixes weird issue with reactivating immediately.
            player.setStackInHand(hand, itemStack2);
            //return ActionResult.success(this.getWorld().isClient);
            this.milkablecooldown = 0;
            cir.setReturnValue(ActionResult.success(this.method_48926().isClient));
        } else {
            ActionResult actionResult = super.interactMob(player, hand);
            if (actionResult.isAccepted() && this.isBreedingItem(itemStack)) {
                this.method_48926().playSoundFromEntity((PlayerEntity)null, this, this.getEatSound(itemStack), SoundCategory.NEUTRAL, 1.0F, MathHelper.nextBetween(this.method_48926().random, 0.8F, 1.2F));
            }

            //return actionResult;
            cir.setReturnValue(actionResult);
        }
        cir.cancel(); //do not run vanilla code.
    }
}
