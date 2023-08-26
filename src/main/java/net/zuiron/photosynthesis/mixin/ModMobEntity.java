package net.zuiron.photosynthesis.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.config.ModConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class ModMobEntity extends LivingEntity {

    /*@Unique
    public long mob_tick_born = 0;*/

    protected ModMobEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    /*public void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putLong("timeofdayborntime", this.mob_tick_born);
    }
    public void readCustomDataFromNbt(NbtCompound nbt) {
        this.mob_tick_born = nbt.getLong("timeofdayborntime");
    }

    @Inject(method = "mobTick", at = @At("HEAD"))
    protected void mobTick(CallbackInfo ci) {
        if(this.mob_tick_born == 0) {
            this.mob_tick_born = this.getWorld().getTimeOfDay();
            Photosynthesis.LOGGER.info("setting mob borntime to: "+this.getWorld().getTimeOfDay()+", for: "+this.getWorld().getEntityById(this.getId()).getName().getString());
        }
    }*/

    @Inject(method = "canMobSpawn", at = @At("HEAD"), cancellable = true)
    private static void canMobSpawn(EntityType<? extends MobEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        //vanilla code.
        //BlockPos blockPos = pos.down();
        //return spawnReason == SpawnReason.SPAWNER || world.getBlockState(blockPos).allowsSpawning(world, blockPos, type);
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        //Photosynthesis.LOGGER.info("trying spawning: "+type+" at: "+pos+", reason: "+spawnReason);
        if(     type.equals(EntityType.CREEPER) ||
                type.equals(EntityType.ZOMBIE) ||
                type.equals(EntityType.ZOMBIE_VILLAGER) ||
                type.equals(EntityType.ZOMBIE_HORSE) ||
                type.equals(EntityType.SKELETON) ||
                type.equals(EntityType.HUSK) ||
                type.equals(EntityType.WITCH) ||
                type.equals(EntityType.SPIDER) ||
                type.equals(EntityType.SKELETON_HORSE)) {
            if(spawnReason == SpawnReason.CHUNK_GENERATION || spawnReason == SpawnReason.NATURAL) {
                //Photosynthesis.LOGGER.info("Prevented " + type + " from spawning @" + pos + ", it's from chunkgen, or natural reasons!");
                if(config.doCreeperSpawn && type.equals(EntityType.CREEPER)) { cir.setReturnValue(true); }
                else if(config.doZombieSpawn && type.equals(EntityType.ZOMBIE)) { cir.setReturnValue(true); }
                else if(config.doZombieVillagerSpawn && type.equals(EntityType.ZOMBIE_VILLAGER)) { cir.setReturnValue(true); }
                else if(config.doZombieHorseSpawn && type.equals(EntityType.ZOMBIE_HORSE)) { cir.setReturnValue(true); }
                else if(config.doSkeletonSpawn && type.equals(EntityType.SKELETON)) { cir.setReturnValue(true); }
                else if(config.doHuskSpawn && type.equals(EntityType.HUSK)) { cir.setReturnValue(true); }
                else if(config.doWitchSpawn && type.equals(EntityType.WITCH)) { cir.setReturnValue(true); }
                else if(config.doSpiderSpawn && type.equals(EntityType.SPIDER)) { cir.setReturnValue(true); }
                else if(config.doSkeletonHorseSpawn && type.equals(EntityType.SKELETON_HORSE)) { cir.setReturnValue(true); }
                else { cir.setReturnValue(false); }
            } else {
                //allow structure and spawnegg, spawners etc. but not natural or chunk gen.
                BlockPos blockPos = pos.down();
                cir.setReturnValue(spawnReason == SpawnReason.SPAWNER || world.getBlockState(blockPos).allowsSpawning(world, blockPos, type));
            }
        }
    }
}
