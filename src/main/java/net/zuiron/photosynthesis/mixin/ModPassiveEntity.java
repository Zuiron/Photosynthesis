package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.nbt.NbtCompound;
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

@Mixin(PassiveEntity.class)
public abstract class ModPassiveEntity extends PathAwareEntity {

    @Shadow public abstract void setBreedingAge(int age);

    @Shadow public abstract int getBreedingAge();

    @Unique
    public long mob_tick_born = -1;

    @Unique
    public long mod_Water = 8000;
    @Unique
    public long mod_Grass = 8000;
    @Unique
    public long mod_Hay = 8000;

    protected ModPassiveEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putLong("timeofdayborntime", this.mob_tick_born);
    }
    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.mob_tick_born = nbt.getLong("timeofdayborntime");
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

        //Photosynthesis.LOGGER.info("DEBUG borntime: "+this.mob_tick_born);
        //this.setBreedingAge(0); //now, they should NEVER grow up ? right? //0 is grows to mature. and -whatever or -24000. isbaby(). its baby if its not 0.
        /*Photosynthesis.LOGGER.info(
                "current time: " + this.getWorld().getTimeOfDay() +
                ", entity born time: " + this.mob_tick_born +
                ", mob: "+ this.getWorld().getEntityById(this.getId()).getName().getString()+
                ", days old: "+calculateEntityAge(this.mob_tick_born, this.getWorld().getTimeOfDay()));*/



        //prevent growing until ready.
        int days_to_mature_cow = Seasons.getDaysPerSeasonMod()*8; //2 years to maturity
        long mcdaysold = calculateEntityAge(this.mob_tick_born, this.getWorld().getTimeOfDay());
        String entityname = this.getWorld().getEntityById(this.getId()).getName().getString();

        //isbaby, lower than 0 its a baby.
        if(this.getBreedingAge() < 0) {
            if(entityname == "Cow") {
                if(mcdaysold < days_to_mature_cow) {
                    Photosynthesis.LOGGER.info("cow baby is not old enough yet. prevent maturing... I am: "+mcdaysold+", req: "+days_to_mature_cow);
                    this.setBreedingAge(-24000);
                } else {
                    Photosynthesis.LOGGER.info("cow baby is ready to mature!!! I am: "+mcdaysold+", req: "+days_to_mature_cow);
                    this.setBreedingAge(0);
                }
            }
        }

        super.mobTick();
    }

    @Unique
    private static long calculateEntityAge(long birthTick, long currentTick) {
        //returns total minecraft days old.
        int TICKS_PER_DAY = 24000;
        return (currentTick - birthTick) / TICKS_PER_DAY;
    }

}
