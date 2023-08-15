package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.util.getCustomVarsPassiveEntity;
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
public abstract class ModPassiveEntity extends PathAwareEntity implements getCustomVarsPassiveEntity {

    @Shadow public abstract void setBreedingAge(int age);

    @Shadow public abstract int getBreedingAge();

    @Shadow public abstract boolean isBaby();

    @Unique
    public long mob_tick_born = -1;

    @Unique
    public long mod_living_ticks = 0;

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
    public int mod_Food = 168000; //spawns with: 1 days worth (minecraft days)
    @Unique
    protected final int mod_Food_max = 168000; //7 days (minecraft days)


    protected ModPassiveEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super((EntityType<? extends PathAwareEntity>)entityType, world);
    }

    @Unique
    public int getMod_Water() { return this.mod_Water; }
    @Unique
    public void setMod_Water(int amount) { this.mod_Water = amount; }
    @Unique
    public int getMod_Water_max() { return this.mod_Water_max; }
    @Unique
    public int getMod_Grass() { return this.mod_Grass; }
    @Unique
    public void setMod_Grass(int amount) { this.mod_Grass = amount; }
    @Unique
    public int getMod_Grass_max() { return this.mod_Grass_max; }
    @Unique
    public int getMod_Hay() { return this.mod_Hay; }
    @Unique
    public void setMod_Hay(int amount) { this.mod_Hay = amount; }
    @Unique
    public int getMod_Hay_max() { return this.mod_Hay_max; }
    @Unique
    public int getMod_Straw() { return this.mod_Straw; }
    @Unique
    public void setMod_Straw(int amount) { this.mod_Straw = amount; }
    @Unique
    public int getMod_Straw_max() { return this.mod_Straw_max; }
    @Unique
    public int getMod_Food() { return this.mod_Food; }
    @Unique
    public void setMod_Food(int amount) { this.mod_Food = amount; }
    @Unique
    public int getMod_Food_max() { return this.mod_Food_max; }
    @Unique
    public long getMod_LivingTicks() { return this.mod_living_ticks; }
    @Unique
    public void addMod_LivingTicks(long amount) { this.mod_living_ticks += amount; }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putLong("photosynthesis_timeofdayborntime", this.mob_tick_born);
        nbt.putLong("photosynthesis_livingticks", this.mod_living_ticks);

        nbt.putInt("photosynthesis_water",this.mod_Water);
        nbt.putInt("photosynthesis_grass",this.mod_Grass);
        nbt.putInt("photosynthesis_hay",this.mod_Hay);
        nbt.putInt("photosynthesis_straw",this.mod_Straw);
        nbt.putInt("photosynthesis_food",this.mod_Food);
    }
    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.mob_tick_born = nbt.getLong("photosynthesis_timeofdayborntime");
        this.mod_living_ticks = nbt.getLong("photosynthesis_livingticks");

        this.mod_Water = nbt.getInt("photosynthesis_water");
        this.mod_Grass = nbt.getInt("photosynthesis_grass");
        this.mod_Hay = nbt.getInt("photosynthesis_hay");
        this.mod_Straw = nbt.getInt("photosynthesis_straw");
        this.mod_Food = nbt.getInt("photosynthesis_food");
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
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

        //DO NOT uncomment this. living ticks needs to be added by for example CowEntity Mixin. needs values to calculate if it grows or not. like. does it have the
        // -required food? grass? hay, straw etc....
        //mob_living_ticks++;

        //this doesnt require ticks. can be cheated and works even if mob is not ticking or loaded by game.
        //long mcdaysold = calculateEntityAge(this.mob_tick_born, this.getWorld().getTimeOfDay());
        //this is ticks based
        long mcdaysold = calculateEntityAgeFromLivingTicks(this.mod_living_ticks);

        String entityname = this.getWorld().getEntityById(this.getId()).getName().getString();
        String transkey = Objects.requireNonNull(this.getWorld().getEntityById(this.getId())).getType().getTranslationKey();


        // Baby -> Mature Control --------------------------------------------------------------------------------------
        //we have to calculate age stuff here because its configurable via config. game restart would be required if we move it outside. we should!
        //for development purposes im going to keep it here awhile.
        Map<String, Integer> name2days2mature = new HashMap<>();
        name2days2mature.put("entity.minecraft.cow", Seasons.getDaysPerSeasonMod()*8);                  //2years
        name2days2mature.put("entity.minecraft.pig", (int) (Seasons.getDaysPerSeasonMod()*1.5));        //6months
        name2days2mature.put("entity.minecraft.sheep", Seasons.getDaysPerSeasonMod()*4);                //1years
        name2days2mature.put("entity.minecraft.chicken", (int) (Seasons.getDaysPerSeasonMod()*1.25));   //5months
        name2days2mature.put("entity.minecraft.horse", Seasons.getDaysPerSeasonMod()*8);                //4years //horse animations interrupt ticks?, so half this. should be:*16
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
    private static long calculateEntityAge(long birthTick, long currentTick) {
        //returns total minecraft days old.
        long TICKS_PER_DAY = 24000;
        return (currentTick - birthTick) / TICKS_PER_DAY;
    }

    @Unique
    private static long calculateEntityAgeFromLivingTicks(long livingTicks) {
        // Define the constants
        long TICKS_PER_DAY = 24000;
        long DAYS_PER_YEAR = Seasons.getDaysPerYear(); //365 real life.

        // Calculate the age in days
        long totalDays = livingTicks / TICKS_PER_DAY;

        // Calculate the years and remaining days
        long years = totalDays / DAYS_PER_YEAR;
        long remainingDays = totalDays % DAYS_PER_YEAR;

        // Print the result or use it as needed
        //System.out.println("Years: " + years + ", Days: " + remainingDays);

        return totalDays;
    }

}
