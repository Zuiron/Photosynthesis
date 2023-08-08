package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.fluid.ModFluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CowEntity.class)
public abstract class ModCowEntity extends AnimalEntity {
    protected ModCowEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    public int milkablecooldown;

    @Unique
    public int cooldownticks = 8000; // 8000 = 3 times pr mc day.


    protected void mobTick() {
        if(this.milkablecooldown < cooldownticks) {
            this.milkablecooldown += 1;
        }
        //Photosynthesis.LOGGER.info("cow MobTick: "+this.milkablecooldown);
        super.mobTick();
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putInt("milkablecooldown", this.milkablecooldown);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        this.milkablecooldown = nbt.getInt("milkablecooldown");
    }

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        //public void isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient, CallbackInfoReturnable<Boolean> cir) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.isOf(Items.BUCKET) && !this.isBaby() && this.milkablecooldown < cooldownticks) {
            player.playSound(SoundEvents.ENTITY_COW_AMBIENT, 1.0F, 1.0F);
            if(this.milkablecooldown != 0) {
                Photosynthesis.LOGGER.info("cow ticks:" + this.milkablecooldown + "/"+cooldownticks);
            }
        }
        if (itemStack.isOf(Items.BUCKET) && !this.isBaby() && this.milkablecooldown >= cooldownticks) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            //ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, Items.MILK_BUCKET.getDefaultStack());
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, ModFluids.MILK_BUCKET.getDefaultStack()); //we give our own milk bucket instead
            player.getItemCooldownManager().set(itemStack2.getItem(), 40); //fixes weird issue with reactivating immediately.
            player.setStackInHand(hand, itemStack2);
            //return ActionResult.success(this.getWorld().isClient);
            this.milkablecooldown = 0;
            cir.setReturnValue(ActionResult.success(this.getWorld().isClient));
        } else {
            //return super.interactMob(player, hand);
            cir.setReturnValue(super.interactMob(player, hand));
        }
        cir.cancel(); //do not run vanilla code.
    }
}
