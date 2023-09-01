package net.zuiron.photosynthesis.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.WorldAccess;
import net.zuiron.photosynthesis.config.ModConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnimalEntity.class)
public class ModAnimalEntitySpawnRestrictor {
    @Inject(method = "isValidNaturalSpawn", at = @At("HEAD"), cancellable = true)
    private static void isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        //vanilla code
        //return world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON) && AnimalEntity.isLightLevelValidForNaturalSpawn(world, pos);
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        //Photosynthesis.LOGGER.info("trying spawning: "+type+" at: "+pos+", reason: "+spawnReason);
        if(     type.equals(EntityType.PIG) ||
                type.equals(EntityType.COW) ||
                type.equals(EntityType.SHEEP) ||
                type.equals(EntityType.CHICKEN) ||
                type.equals(EntityType.HORSE)
        //        || type.equals(EntityType.GOAT) //GOAT spawn restriction is under ModGoatEntity
        )
        {
            if(spawnReason == SpawnReason.SPAWN_EGG || spawnReason == SpawnReason.BREEDING) {
                cir.setReturnValue(world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON) && MODisLightLevelValidForNaturalSpawn(world, pos));
            } else {
                //Photosynthesis.LOGGER.info("Prevented " + type + " from spawning @" + pos + ", it's not from breeding, or spawn-egg!");
                if(config.doPigSpawn && type.equals(EntityType.PIG)) { cir.setReturnValue(world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON) && MODisLightLevelValidForNaturalSpawn(world, pos)); }
                else if(config.doCowSpawn && type.equals(EntityType.COW)) { cir.setReturnValue(world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON) && MODisLightLevelValidForNaturalSpawn(world, pos)); }
                else if(config.doSheepSpawn && type.equals(EntityType.SHEEP)) { cir.setReturnValue(world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON) && MODisLightLevelValidForNaturalSpawn(world, pos)); }
                else if(config.doChickenSpawn && type.equals(EntityType.CHICKEN)) { cir.setReturnValue(world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON) && MODisLightLevelValidForNaturalSpawn(world, pos)); }
                else if(config.doHorseSpawn && type.equals(EntityType.HORSE)) { cir.setReturnValue(world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON) && MODisLightLevelValidForNaturalSpawn(world, pos)); }
                //else if(config.doGoatSpawn && type.equals(EntityType.GOAT)) { cir.setReturnValue(true); } //GOAT spawn restriction is under ModGoatEntity
                else { cir.setReturnValue(false); }
            }
        }

    }

    @Unique
    private static boolean MODisLightLevelValidForNaturalSpawn(BlockRenderView world, BlockPos pos) {
        return world.getBaseLightLevel(pos, 0) > 8;
    }
}
