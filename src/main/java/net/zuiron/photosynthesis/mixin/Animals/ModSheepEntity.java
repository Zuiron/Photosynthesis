package net.zuiron.photosynthesis.mixin.Animals;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
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
import net.minecraft.world.World;
import net.zuiron.photosynthesis.fluid.ModFluids;
import net.zuiron.photosynthesis.util.getCustomVarsPassiveEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public abstract class ModSheepEntity extends AnimalEntity {
    protected ModSheepEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    public int mod_Wool = 0;
    @Unique
    protected final int mod_Wool_max = 48000; //24000 == 1 mc day. (max every other per mc day at MAX productivity.)

    @Shadow public abstract void setSheared(boolean sheared);

    @Inject(method = "mobTick", at = @At("HEAD"), cancellable = false)
    protected void mobTick(CallbackInfo ci) {
        int mod_Water = ((getCustomVarsPassiveEntity) this).getMod_Water();
        int mod_Water_max = ((getCustomVarsPassiveEntity) this).getMod_Water_max();

        int mod_Grass = ((getCustomVarsPassiveEntity) this).getMod_Grass();
        int mod_Grass_max = ((getCustomVarsPassiveEntity) this).getMod_Grass_max();

        //Food Control -------------------------------------------------------------------------------------------------
        //remove food and waters.
        if(mod_Water > 0)  { ((getCustomVarsPassiveEntity) this).setMod_Water(mod_Water-1); }
        if(mod_Grass > 0)  { ((getCustomVarsPassiveEntity) this).setMod_Grass(mod_Grass-1); }

        float sheepProductivity = photosynthesis$getWoolProductivity(mod_Water, mod_Water_max, mod_Grass, mod_Grass_max);

        //livingTicks
        if(sheepProductivity >= 100.0f) {
            ((getCustomVarsPassiveEntity) this).addMod_LivingTicks(1);
        }

        //wool control.
        if(!this.isBaby() && sheepProductivity >= 100.0f && this.mod_Wool < this.mod_Wool_max) {
            this.mod_Wool++;
        }
        if(!this.isBaby() && sheepProductivity >= 100.0f && this.mod_Wool >= this.mod_Wool_max) {
            //super.onEatingGrass();
            this.setSheared(false);
        }

        //damage missing water or food.
        if(mod_Water <= 0) {
            this.damage(this.getDamageSources().dryOut(), 2);
        } else if (mod_Grass <= 0) {
            this.damage(this.getDamageSources().starve(), 1);
        }

        super.mobTick();
    }


    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("photosynthesis_wool", this.mod_Wool);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.mod_Wool = nbt.getInt("photosynthesis_wool");
    }

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {

        long mod_LivingTicks = ((getCustomVarsPassiveEntity) this).getMod_LivingTicks();

        int mod_Water = ((getCustomVarsPassiveEntity) this).getMod_Water();
        int mod_Water_max = ((getCustomVarsPassiveEntity) this).getMod_Water_max();

        int mod_Grass = ((getCustomVarsPassiveEntity) this).getMod_Grass();
        int mod_Grass_max = ((getCustomVarsPassiveEntity) this).getMod_Grass_max();

        if (!player.getWorld().isClient()) {

            //get some data.
            if (player.isPlayer()) {
                if (player.getStackInHand(hand).isOf(Items.STICK)) {

                    String entityname = this.getWorld().getEntityById(this.getId()).getName().getString(); //gets name, or if tagged tag name.
                    String string = "Entity: "+entityname + " \n";

                    float sheepProductivity = photosynthesis$getWoolProductivity(mod_Water, mod_Water_max, mod_Grass, mod_Grass_max);

                    string += "LivingTicks: "+mod_LivingTicks+" \n";

                    if(this.isBaby()) {
                        if(sheepProductivity >= 75.0f) {
                            string += "Growing: TRUE \n";
                        } else {
                            string += "Growing: FALSE \n";
                        }
                    }

                    string += "Water: "+mod_Water+"/"+mod_Water_max+" \n";
                    string += "Grass: "+mod_Grass+"/"+mod_Grass_max+" \n";
                    string += "Wool: "+this.mod_Wool+"/"+mod_Wool_max+" \n";
                    string += "Productivity: "+ sheepProductivity +"%";


                    player.sendMessage(Text.literal(string),false);
                } else if (player.getStackInHand(hand).isOf(Items.ROTTEN_FLESH)) {
                    //this.mod_Milk = this.mod_Milk_max;
                    //((getCustomVarsPassiveEntity) this).setMod_Grass(mod_Grass-24000);
                    //((getCustomVarsPassiveEntity) this).addMod_LivingTicks(480000);
                    //this.mod_Wool += 5000;
                }
            }
        }


    }

    @Unique
    public float photosynthesis$getWoolProductivity(int mod_Water, int mod_Water_max, int mod_Grass, int mod_Grass_max) {
        float productivity = 0.0f;

        if(mod_Water >= (mod_Water_max/2)) {
            if(mod_Grass > (mod_Grass_max/2)) { productivity += 100f; }
        }

        return productivity;
    }

    @Inject(method = "onEatingGrass", at = @At("HEAD"), cancellable = true)
    public void onEatingGrass(CallbackInfo ci) {
        ci.cancel(); //this code makes it grow up and grows wool. disable. we use custom.
    }

    @Inject(method = "sheared", at = @At("HEAD"), cancellable = true)
    public void sheared(SoundCategory shearedSoundCategory, CallbackInfo ci) {
        this.mod_Wool = 0;
    }
}
