package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.zuiron.photosynthesis.Photosynthesis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpawnRestriction.class)
public class ModSpawnRestriction {

    @Inject(method = "canSpawn", at = @At("HEAD"), cancellable = true)
    private static <T extends Entity> void canSpawn(EntityType<T> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        //SpawnRestriction.Entry entry = RESTRICTIONS.get(type);
        //return entry == null || entry.predicate.test(type, world, spawnReason, pos, random);
        //Photosynthesis.LOGGER.info("type: "+type+", reason: "+spawnReason);

        /*if(type == EntityType.PIG) {
            Photosynthesis.LOGGER.info("type: "+type+", reason: "+spawnReason);
        }

        if(type == EntityType.PIG && spawnReason != SpawnReason.SPAWN_EGG || spawnReason != SpawnReason.BREEDING) {
            cir.setReturnValue(false);
            cir.cancel();
        }*/


        //HELLO! this is apparently not for ALL mobs. look in spawnRestriction.class!
    }
}
