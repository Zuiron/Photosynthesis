package net.zuiron.photosynthesis.mixin.Animals;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.zuiron.photosynthesis.fluid.ModFluids;
import net.zuiron.photosynthesis.util.getCustomVarsPassiveEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChickenEntity.class)
public abstract class ModChickenEntity extends AnimalEntity {
    @Shadow
    public float prevFlapProgress;
    @Shadow
    public float flapProgress;
    @Shadow
    public float prevMaxWingDeviation;
    @Shadow
    public float maxWingDeviation;
    @Shadow
    public float flapSpeed;
    @Shadow public abstract boolean hasJockey();

    @Shadow
    public int eggLayTime;


    protected ModChickenEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    public int mod_Egg = 0;
    @Unique
    protected final int mod_Egg_max = 48000; //24000 = one egg.

    @Inject(method = "tickMovement", at = @At("HEAD"), cancellable = true)
    public void tickMovement(CallbackInfo ci) {
        super.tickMovement();
        this.prevFlapProgress = this.flapProgress;
        this.prevMaxWingDeviation = this.maxWingDeviation;
        this.maxWingDeviation += (this.isOnGround() ? -1.0F : 4.0F) * 0.3F;
        this.maxWingDeviation = MathHelper.clamp(this.maxWingDeviation, 0.0F, 1.0F);
        if (!this.isOnGround() && this.flapSpeed < 1.0F) {
            this.flapSpeed = 1.0F;
        }

        this.flapSpeed *= 0.9F;
        Vec3d vec3d = this.getVelocity();
        if (!this.isOnGround() && vec3d.y < 0.0) {
            this.setVelocity(vec3d.multiply(1.0, 0.6, 1.0));
        }

        this.flapProgress += this.flapSpeed * 2.0F;
        if (!this.getWorld().isClient && this.isAlive() && !this.isBaby() && !this.hasJockey() && --this.eggLayTime <= 0) {
            /*this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Items.EGG);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.eggLayTime = this.random.nextInt(6000) + 6000;*/
        }
        ci.cancel();
    }

    @Override
    protected void mobTick() {
        int mod_Water = ((getCustomVarsPassiveEntity) this).getMod_Water();
        int mod_Water_max = ((getCustomVarsPassiveEntity) this).getMod_Water_max();

        int mod_Straw = ((getCustomVarsPassiveEntity) this).getMod_Straw();
        int mod_Straw_max = ((getCustomVarsPassiveEntity) this).getMod_Straw_max();

        int mod_Food = ((getCustomVarsPassiveEntity) this).getMod_Food();
        int mod_Food_max = ((getCustomVarsPassiveEntity) this).getMod_Food_max();

        //Food Control -------------------------------------------------------------------------------------------------
        //remove food and waters.
        if(mod_Water > 0)  { ((getCustomVarsPassiveEntity) this).setMod_Water(mod_Water-1); }
        if(mod_Straw > 0)  { ((getCustomVarsPassiveEntity) this).setMod_Straw(mod_Straw-1); }
        if(mod_Food > 0)   { ((getCustomVarsPassiveEntity) this).setMod_Food(mod_Food-1);  }

        float chickenProductivity = photosynthesis$getChickenProductivity(mod_Water, mod_Water_max, mod_Straw, mod_Straw_max, mod_Food, mod_Food_max);

        //livingTicks
        if(chickenProductivity >= 100.0f) {
            ((getCustomVarsPassiveEntity) this).addMod_LivingTicks(1);
        }

        //egg control.
        if(!this.isBaby() && chickenProductivity >= 50.0f) {
            this.mod_Egg++;
            if(chickenProductivity >= 100.0f) { this.mod_Egg++; }

            this.eggLayTime = (48000 - this.mod_Egg);
        }
        if(this.mod_Egg >= 48000) {
            if (!this.getWorld().isClient && this.isAlive() && !this.isBaby() && !this.hasJockey()) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Items.EGG);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
                this.mod_Egg = 0;
            }
        }

        //damage missing water or food.
        if(mod_Water <= 0) {
            this.damage(this.getDamageSources().dryOut(), 2);
        } else if (mod_Food <= 0) {
            this.damage(this.getDamageSources().starve(), 1);
        }

        super.mobTick();
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("photosynthesis_egg", this.mod_Egg);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.mod_Egg = nbt.getInt("photosynthesis_egg");
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        long mod_LivingTicks = ((getCustomVarsPassiveEntity) this).getMod_LivingTicks();

        int mod_Water = ((getCustomVarsPassiveEntity) this).getMod_Water();
        int mod_Water_max = ((getCustomVarsPassiveEntity) this).getMod_Water_max();

        int mod_Straw = ((getCustomVarsPassiveEntity) this).getMod_Straw();
        int mod_Straw_max = ((getCustomVarsPassiveEntity) this).getMod_Straw_max();

        int mod_Food = ((getCustomVarsPassiveEntity) this).getMod_Food();
        int mod_Food_max = ((getCustomVarsPassiveEntity) this).getMod_Food_max();

        if (!player.getWorld().isClient()) {

            //get some data.
            if (player.isPlayer()) {
                if (player.getStackInHand(hand).isOf(Items.STICK)) {

                    String entityname = this.getWorld().getEntityById(this.getId()).getName().getString(); //gets name, or if tagged tag name.
                    String string = "Entity: "+entityname + " \n";

                    float chickenProductivity = photosynthesis$getChickenProductivity(mod_Water, mod_Water_max, mod_Straw, mod_Straw_max, mod_Food, mod_Food_max);

                    string += "LivingTicks: "+mod_LivingTicks+" \n";

                    if(this.isBaby()) {
                        if(chickenProductivity >= 100.0f) {
                            string += "Growing: TRUE \n";
                        } else {
                            string += "Growing: FALSE \n";
                        }
                    }

                    string += "Water: "+mod_Water+"/"+mod_Water_max+" \n";
                    string += "Straw: "+mod_Straw+"/"+mod_Straw_max+" \n";
                    string += "Food: "+mod_Food+"/"+mod_Food_max+" \n";
                    string += "Egg Progress: "+this.mod_Egg+"/"+mod_Egg_max+" \n";
                    string += "Productivity: "+ chickenProductivity +"%";


                    player.sendMessage(Text.literal(string),false);
                } else if (player.getStackInHand(hand).isOf(Items.ROTTEN_FLESH)) {
                    //this.mod_Milk = this.mod_Milk_max;
                    //((getCustomVarsPassiveEntity) this).setMod_Food(mod_Food-24000);
                    //((getCustomVarsPassiveEntity) this).setMod_Water(mod_Water-24000);
                    //((getCustomVarsPassiveEntity) this).addMod_LivingTicks(480000);
                    this.mod_Egg+= 10000;
                }
            }
        }
        super.interactMob(player, hand);
        return ActionResult.SUCCESS;
    }

    @Unique
    public float photosynthesis$getChickenProductivity(int mod_Water, int mod_Water_max, int mod_Straw, int mod_Straw_max, int mod_Food, int mod_Food_max) {
        float productivity = 0.0f;

        if(mod_Water >= (mod_Water_max/2)) {
            if(mod_Straw > (mod_Straw_max/2)) { productivity += 50f; }
            if(mod_Food  > (mod_Food_max/2) ) { productivity += 50f; }
        }

        return productivity;
    }
}
