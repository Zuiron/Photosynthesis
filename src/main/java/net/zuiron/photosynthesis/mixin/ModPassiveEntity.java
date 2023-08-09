package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
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

    @Unique
    public long mob_tick_born = -1;

    @Unique
    public int mod_Water = 96000; //4 days (minecraft days) -- one day = 24000
    @Unique
    public int mod_Grass = 168000; //7 days (minecraft days)
    @Unique
    public int mod_Hay = 168000; //7 days (minecraft days)
    @Unique
    public int mod_Straw = 168000; //7 days (minecraft days)
    @Unique
    public int mod_Food = 168000; //7 days (minecraft days)


    protected ModPassiveEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super((EntityType<? extends PathAwareEntity>)entityType, world);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putLong("timeofdayborntime", this.mob_tick_born);
    }
    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.mob_tick_born = nbt.getLong("timeofdayborntime");
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!player.getWorld().isClient()) {
            //get some data.
            if (player.isPlayer()) {
                if (player.getStackInHand(hand).isOf(Items.STICK)) {
                    player.sendMessage(Text.literal("test"),true);
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

        //we have to calculate age stuff here because its configurable via config. game restart would be required if we move it outside. we might.
        Map<String, Integer> name2days2mature = new HashMap<>();
        name2days2mature.put("entity.minecraft.cow", Seasons.getDaysPerSeasonMod()*8); //2years
        name2days2mature.put("entity.minecraft.pig", (int) (Seasons.getDaysPerSeasonMod()*1.5)); //6months
        name2days2mature.put("entity.minecraft.sheep", Seasons.getDaysPerSeasonMod()*4); //1years
        name2days2mature.put("entity.minecraft.chicken", (int) (Seasons.getDaysPerSeasonMod()*1.25)); //5months
        name2days2mature.put("entity.minecraft.horse", Seasons.getDaysPerSeasonMod()*16); //4years
        name2days2mature.put("entity.minecraft.goat", Seasons.getDaysPerSeasonMod()*12); //3years

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

}
