package net.zuiron.photosynthesis.mixin.Animals;

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
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.fluid.ModFluids;
import net.zuiron.photosynthesis.util.getCustomVarsPassiveEntity;
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
    public int mod_Milk = 0; //this is 4 buckets worth of milk.
    @Unique
    protected final int mod_Milk_max = 96000; //24000 = one bucket.
    @Inject(method = "mobTick", at = @At("HEAD"), cancellable = false)
    protected void mobTick(CallbackInfo ci) {
        int mod_Water = ((getCustomVarsPassiveEntity) this).getMod_Water();
        int mod_Water_max = ((getCustomVarsPassiveEntity) this).getMod_Water_max();

        int mod_Grass = ((getCustomVarsPassiveEntity) this).getMod_Grass();
        int mod_Grass_max = ((getCustomVarsPassiveEntity) this).getMod_Grass_max();

        int mod_Food = ((getCustomVarsPassiveEntity) this).getMod_Food();
        int mod_Food_max = ((getCustomVarsPassiveEntity) this).getMod_Food_max();

        //Food Control -------------------------------------------------------------------------------------------------
        //remove food and waters.
        if(mod_Water > 0)  { ((getCustomVarsPassiveEntity) this).setMod_Water(mod_Water-1); }
        if(mod_Grass > 0)  { ((getCustomVarsPassiveEntity) this).setMod_Grass(mod_Grass-1); }
        if(mod_Food > 0)   { ((getCustomVarsPassiveEntity) this).setMod_Food(mod_Food-1);  }

        float goatProductivity = photosynthesis$getMilkProductivity(mod_Water, mod_Water_max, mod_Grass, mod_Grass_max, mod_Food, mod_Food_max);

        //livingTicks
        if(goatProductivity >= 100.0f) {
            ((getCustomVarsPassiveEntity) this).addMod_LivingTicks(1);
        }

        //milk control.
        if(!this.isBaby() && goatProductivity >= 50.0f) {
            this.mod_Milk+=2;
            if(goatProductivity >= 100.0f) { this.mod_Milk += 2; }
        }

        //damage missing water or food.
        if(mod_Water <= 0) {
            this.damage(this.getDamageSources().dryOut(), 2);
        } else if (mod_Food <= 0) {
            if (mod_Grass <= 0) {
                this.damage(this.getDamageSources().starve(), 1);
            }
        }
    }
    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("photosynthesis_milk", this.mod_Milk);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.mod_Milk = nbt.getInt("photosynthesis_milk");
    }

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        long mod_LivingTicks = ((getCustomVarsPassiveEntity) this).getMod_LivingTicks();

        int mod_Water = ((getCustomVarsPassiveEntity) this).getMod_Water();
        int mod_Water_max = ((getCustomVarsPassiveEntity) this).getMod_Water_max();

        int mod_Grass = ((getCustomVarsPassiveEntity) this).getMod_Grass();
        int mod_Grass_max = ((getCustomVarsPassiveEntity) this).getMod_Grass_max();

        int mod_Food = ((getCustomVarsPassiveEntity) this).getMod_Food();
        int mod_Food_max = ((getCustomVarsPassiveEntity) this).getMod_Food_max();

        if (!player.getWorld().isClient()) {

            //get some data.
            if (player.isPlayer()) {
                if (player.getStackInHand(hand).isOf(Items.STICK)) {

                    String entityname = this.getWorld().getEntityById(this.getId()).getName().getString(); //gets name, or if tagged tag name.
                    String string = "Entity: "+entityname + " \n";

                    float goatProductivity = photosynthesis$getMilkProductivity(mod_Water, mod_Water_max, mod_Grass, mod_Grass_max, mod_Food, mod_Food_max);

                    string += "LivingTicks: "+mod_LivingTicks+" \n";

                    if(this.isBaby()) {
                        if(goatProductivity >= 100.0f) {
                            string += "Growing: TRUE \n";
                        } else {
                            string += "Growing: FALSE \n";
                        }
                    }

                    string += "Water: "+mod_Water+"/"+mod_Water_max+" \n";
                    string += "Grass: "+mod_Grass+"/"+mod_Grass_max+" \n";
                    string += "Food: "+mod_Food+"/"+mod_Food_max+" \n";
                    string += "Milk: "+this.mod_Milk+"/"+mod_Milk_max+", Buckets: "+ photosynthesis$getAvailBucketsMilk()+" \n";
                    string += "Productivity: "+ goatProductivity +"%";


                    player.sendMessage(Text.literal(string),false);
                } else if (player.getStackInHand(hand).isOf(Items.ROTTEN_FLESH)) {
                    //this.mod_Milk = this.mod_Milk_max;
                    //((getCustomVarsPassiveEntity) this).setMod_Food(mod_Food-24000);
                    //((getCustomVarsPassiveEntity) this).setMod_Water(mod_Water-24000);
                    //((getCustomVarsPassiveEntity) this).addMod_LivingTicks(480000);
                }
            }
        }

        //MILK BUCKET STUFF
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.isOf(Items.BUCKET) && !this.isBaby() && this.mod_Milk < 24000) {
            if(!player.getWorld().isClient) {
                this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.ENTITY_GOAT_HURT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                player.sendMessage(Text.literal("Not Enough Milk: " + this.mod_Milk + "/" + this.mod_Milk_max + ", " + photosynthesis$getAvailBucketsMilk() + " Buckets. \n Productivity: "+ photosynthesis$getMilkProductivity(mod_Water, mod_Water_max, mod_Grass, mod_Grass_max, mod_Food, mod_Food_max)+"%"), false);
            }
        }
        if (itemStack.isOf(Items.BUCKET) && !this.isBaby() && this.mod_Milk >= 24000) {
            if(!player.getWorld().isClient) {
                this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.ENTITY_GOAT_HURT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            }
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, ModFluids.GOATMILK_BUCKET.getDefaultStack()); //we give our own milk bucket instead
            player.getItemCooldownManager().set(itemStack2.getItem(), 40); //fixes weird issue with reactivating immediately.
            player.setStackInHand(hand, itemStack2);
            this.mod_Milk -= 24000;

            if(!player.getWorld().isClient) {
                player.sendMessage(Text.literal("Milk: " + this.mod_Milk + "/" + this.mod_Milk_max + ", " + photosynthesis$getAvailBucketsMilk() + " Buckets Left. \n Productivity: "+ photosynthesis$getMilkProductivity(mod_Water, mod_Water_max, mod_Grass, mod_Grass_max, mod_Food, mod_Food_max)+"%"), false);
            }

            //return ActionResult.success(this.getWorld().isClient);
            cir.setReturnValue(ActionResult.success(this.getWorld().isClient));
        } else {
            //return super.interactMob(player, hand);
            cir.setReturnValue(super.interactMob(player, hand));
        }
    }

    @Unique
    public int photosynthesis$getAvailBucketsMilk() {
        if(this.mod_Milk >= (24000 * 4)) { return 4; }
        if(this.mod_Milk >= (24000 * 3)) { return 3; }
        if(this.mod_Milk >= (24000 * 2)) { return 2; }
        if(this.mod_Milk >= 24000)       { return 1; }

        return 0;
    }

    @Unique
    public float photosynthesis$getMilkProductivity(int mod_Water, int mod_Water_max, int mod_Grass, int mod_Grass_max, int mod_Food, int mod_Food_max) {
        float productivity = 0.0f;

        if(mod_Water >= (mod_Water_max/2)) {
            if(mod_Grass > (mod_Grass_max/2)) { productivity += 50f; }
            if(mod_Food  > (mod_Food_max/2) ) { productivity += 50f; }
        }

        return productivity;
    }
}
