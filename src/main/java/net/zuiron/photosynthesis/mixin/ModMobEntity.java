package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.zuiron.photosynthesis.Photosynthesis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class ModMobEntity {

    @Inject(method = "canMobSpawn", at = @At("HEAD"), cancellable = true)
    private static void canMobSpawn(EntityType<? extends MobEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        //vanilla code.
        //BlockPos blockPos = pos.down();
        //return spawnReason == SpawnReason.SPAWNER || world.getBlockState(blockPos).allowsSpawning(world, blockPos, type);

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
                cir.setReturnValue(false);
            } else {
                //allow structure and spawnegg, spawners etc. but not natural or chunk gen.
                BlockPos blockPos = pos.down();
                cir.setReturnValue(spawnReason == SpawnReason.SPAWNER || world.getBlockState(blockPos).allowsSpawning(world, blockPos, type));
            }
        }
    }
}
