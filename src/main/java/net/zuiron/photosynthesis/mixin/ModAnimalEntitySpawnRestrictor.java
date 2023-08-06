package net.zuiron.photosynthesis.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.zuiron.photosynthesis.Photosynthesis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnimalEntity.class)
public class ModAnimalEntitySpawnRestrictor {
    @Inject(method = "isValidNaturalSpawn", at = @At("HEAD"), cancellable = true)
    private static void isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        //return world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON) && AnimalEntity.isLightLevelValidForNaturalSpawn(world, pos);
        /*if(type == EntityType.PIG) {
            Photosynthesis.LOGGER.info("type: "+type+", reason: "+spawnReason);
        }*/

        if(type == EntityType.PIG && spawnReason != SpawnReason.SPAWN_EGG || spawnReason != SpawnReason.BREEDING) {
            //Photosynthesis.LOGGER.info("Prevented PIG from spawning, it's not from breeding, or spawn-egg!");
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
}
