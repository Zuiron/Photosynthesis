package net.zuiron.photosynthesis.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.config.ModConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DrownedEntity.class)
public abstract class ModDrownedEntity {

    @Inject(method = "canSpawn(Lnet/minecraft/world/WorldView;)Z", at = @At("HEAD"), cancellable = true)
    private void canSpawn(WorldView world, CallbackInfoReturnable<Boolean> cir) {
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        if(!config.doDrownedSpawn) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }

    @Inject(
            method = "canSpawn(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/random/Random;)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void canSpawn(EntityType<DrownedEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        if(!config.doDrownedSpawn) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
}
