package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.Seasons;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Mixin(PassiveEntity.class)
public abstract class ModPassiveEntity extends PathAwareEntity {

    @Shadow public abstract void setBreedingAge(int age);

    @Shadow public abstract int getBreedingAge();

    @Shadow public abstract boolean isBaby();

    @Unique
    public long mob_tick_born = -1;

    @Unique
    public int mod_Water = 96000; //4 days (minecraft days) -- one day = 24000
    @Unique
    protected final int mod_Water_max = 96000;
    @Unique
    public int mod_Grass = 168000; //7 days (minecraft days)
    @Unique
    protected final int mod_Grass_max = 168000;
    @Unique
    public int mod_Hay = 168000; //7 days (minecraft days)
    @Unique
    protected final int mod_Hay_max = 168000;
    @Unique
    public int mod_Straw = 168000; //7 days (minecraft days)
    @Unique
    protected final int mod_Straw_max = 168000;
    @Unique
    public int mod_Food = 168000; //7 days (minecraft days)
    @Unique
    protected final int mod_Food_max = 168000;
    @Unique
    public int mod_Milk = 0; //this is 4 buckets worth of milk. each grass,hay,straw,food(TMR). adds +1 every tick if above 50%.
    @Unique
    protected final int mod_Milk_max = 96000; //24000 = one bucket.


    protected ModPassiveEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super((EntityType<? extends PathAwareEntity>)entityType, world);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putLong("photosynthesis_timeofdayborntime", this.mob_tick_born);

        nbt.putInt("photosynthesis_water",this.mod_Water);
        nbt.putInt("photosynthesis_grass",this.mod_Grass);
        nbt.putInt("photosynthesis_hay",this.mod_Hay);
        nbt.putInt("photosynthesis_straw",this.mod_Straw);
        nbt.putInt("photosynthesis_food",this.mod_Food);
        nbt.putInt("photosynthesis_milk",this.mod_Milk);
    }
    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.mob_tick_born = nbt.getLong("photosynthesis_timeofdayborntime");

        this.mod_Water = nbt.getInt("photosynthesis_water");
        this.mod_Grass = nbt.getInt("photosynthesis_grass");
        this.mod_Hay = nbt.getInt("photosynthesis_hay");
        this.mod_Straw = nbt.getInt("photosynthesis_straw");
        this.mod_Food = nbt.getInt("photosynthesis_food");
        this.mod_Milk = nbt.getInt("photosynthesis_milk");
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!player.getWorld().isClient()) {
            //get some data.
            if (player.isPlayer()) {
                if (player.getStackInHand(hand).isOf(Items.STICK)) {
                    String entityname = this.getWorld().getEntityById(this.getId()).getName().getString(); //gets name, or if tagged tag name.
                    String transkey = Objects.requireNonNull(this.getWorld().getEntityById(this.getId())).getType().getTranslationKey();
                    String string = "Entity: "+entityname + " \n";

                    if(Objects.equals(transkey, "entity.minecraft.cow")) {
                        string += "Water: "+this.mod_Water+"/"+mod_Water_max+" \n";
                        string += "Grass: "+this.mod_Grass+"/"+mod_Grass_max+" \n";
                        string += "Hay: "+this.mod_Hay+"/"+mod_Hay_max+" \n";
                        string += "Straw: "+this.mod_Straw+"/"+mod_Straw_max+" \n";
                        string += "Milk: "+this.mod_Milk+"/"+mod_Milk_max+", Buckets: "+getAvailBucketsMilk();
                    }


                    player.sendMessage(Text.literal(string),false);
                } else if (player.getStackInHand(hand).isOf(Items.ROTTEN_FLESH)) {
                    this.mod_Milk += 24000;
                }
            }
        }

        return super.interactMob(player, hand);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {

        this.mob_tick_born = this.getWorld().getTimeOfDay();
        Photosynthesis.LOGGER.info("Initializing entity with borntick: "+this.getWorld().getTimeOfDay());

        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    protected void mobTick() {
        if(this.mob_tick_born == -1) { //working, when breeding, initialize is not triggered apparently. so we need this fix.
            //Photosynthesis.LOGGER.info("missing data. fixing.");
            this.mob_tick_born = this.getWorld().getTimeOfDay();
        }

        long mcdaysold = calculateEntityAge(this.mob_tick_born, this.getWorld().getTimeOfDay());
        String entityname = this.getWorld().getEntityById(this.getId()).getName().getString();
        //EntityType<? extends AnimalEntity> type = (EntityType<? extends AnimalEntity>) this.getWorld().getEntityById(this.getId()).getType();
        //Photosynthesis.LOGGER.info("transkey: "+type.getTranslationKey());
        String transkey = Objects.requireNonNull(this.getWorld().getEntityById(this.getId())).getType().getTranslationKey();




        //Food Control -------------------------------------------------------------------------------------------------
        if(Objects.equals(transkey, "entity.minecraft.cow")) {
            //remove food and waters.
            if(this.mod_Water > 0)  { this.mod_Water--; }
            if(this.mod_Grass > 0)  { this.mod_Grass--; }
            if(this.mod_Hay > 0)    { this.mod_Hay--;   }
            if(this.mod_Straw > 0)  { this.mod_Straw--; }
            if(this.mod_Food > 0)   { this.mod_Food--;  } //for cows. TMR. total mixed rations.

            //milk control.
            if(!this.isBaby()) {
                if(this.mod_Grass > (this.mod_Grass_max/2) && this.mod_Milk < this.mod_Milk_max) { this.mod_Milk++; }
                if(this.mod_Hay   > (this.mod_Hay_max/2)   && this.mod_Milk < this.mod_Milk_max) { this.mod_Milk++; }
                if(this.mod_Straw > (this.mod_Straw_max/2) && this.mod_Milk < this.mod_Milk_max) { this.mod_Milk++; }
                if(this.mod_Food  > (this.mod_Food_max/2)  && this.mod_Milk < this.mod_Milk_max) { this.mod_Milk++; }
            }

            //damage missing water or food.
            if(this.mod_Water <= 0) {
                this.damage(this.getDamageSources().dryOut(), 2);
            } else if (this.mod_Food <= 0) {
                if (this.mod_Grass <= 0 || this.mod_Hay <= 0) {
                    this.damage(this.getDamageSources().starve(), 1);
                }
            }
        }


        // Baby -> Mature Control --------------------------------------------------------------------------------------
        //we have to calculate age stuff here because its configurable via config. game restart would be required if we move it outside. we should!
        //for development purposes im going to keep it here awhile.
        Map<String, Integer> name2days2mature = new HashMap<>();
        name2days2mature.put("entity.minecraft.cow", Seasons.getDaysPerSeasonMod()*8);                  //2years
        name2days2mature.put("entity.minecraft.pig", (int) (Seasons.getDaysPerSeasonMod()*1.5));        //6months
        name2days2mature.put("entity.minecraft.sheep", Seasons.getDaysPerSeasonMod()*4);                //1years
        name2days2mature.put("entity.minecraft.chicken", (int) (Seasons.getDaysPerSeasonMod()*1.25));   //5months
        name2days2mature.put("entity.minecraft.horse", Seasons.getDaysPerSeasonMod()*16);               //4years
        name2days2mature.put("entity.minecraft.goat", Seasons.getDaysPerSeasonMod()*12);                //3years

        if(this.getBreedingAge() < 0) { //isbaby, lower than 0 its a baby.
            if(name2days2mature.containsKey(transkey)) {
                if(mcdaysold < name2days2mature.get(transkey)) {
                    //Photosynthesis.LOGGER.info(entityname+" baby is not old enough yet. prevent maturing... I am: "+mcdaysold+", req: "+name2days2mature.get(entityname));
                    int daysleft = (int) (name2days2mature.get(transkey) - mcdaysold);
                    long days2ticks = 24000L * daysleft;
                    long ticksleft = -days2ticks;
                    this.setBreedingAge((int) ticksleft);
                } else {
                    //Photosynthesis.LOGGER.info(entityname+" baby is ready to mature!!! I am: "+mcdaysold+", req: "+name2days2mature.get(entityname));
                    this.setBreedingAge(0);
                }
            }
        }

        super.mobTick();
    }

    @Unique
    private int getAvailBucketsMilk() {
        if(this.mod_Milk >= (24000 * 4)) { return 4; }
        if(this.mod_Milk >= (24000 * 3)) { return 3; }
        if(this.mod_Milk >= (24000 * 2)) { return 2; }
        if(this.mod_Milk >= 24000)       { return 1; }

        return 0;
    }

    @Unique
    private static long calculateEntityAge(long birthTick, long currentTick) {
        //returns total minecraft days old.
        long TICKS_PER_DAY = 24000;
        return (currentTick - birthTick) / TICKS_PER_DAY;
    }

}
