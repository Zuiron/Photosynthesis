package net.zuiron.photosynthesis.mixin.season_weather;

import com.mojang.serialization.Codec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.event.SeasonTickHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public abstract class ModBiomeWeather {
    /*
    public Precipitation getPrecipitation(BlockPos pos) {
        if (!this.hasPrecipitation()) {
            return Precipitation.NONE;
        }
        return this.isCold(pos) ? Precipitation.SNOW : Precipitation.RAIN;
    }
     */

    @Shadow public abstract boolean hasPrecipitation();
    @Shadow public abstract boolean isCold(BlockPos pos);
    @Shadow public abstract boolean doesNotSnow(BlockPos pos);

    @Shadow public abstract BiomeEffects getEffects();

    @Shadow @Final public static Codec<RegistryEntry<Biome>> REGISTRY_CODEC;

    @Environment(EnvType.CLIENT)
    @Inject(method = "getPrecipitation", at = @At("HEAD"), cancellable = true)
    public void getPrecipitation(BlockPos pos, CallbackInfoReturnable<Biome.Precipitation> cir) {
        if(Seasons.isSeasonsEnabled()) {
            World world = MinecraftClient.getInstance().world;
            if(world != null) {
                long time = world.getTimeOfDay();


                int season = Seasons.getCurrentSeason(time);
                String seasonString = Seasons.getSeasonString(season);

                if (seasonString.equals("Winter")) {
                    cir.setReturnValue(Biome.Precipitation.SNOW);
                } else {
                    cir.setReturnValue(Biome.Precipitation.RAIN);
                }
            } else {
                if (!this.hasPrecipitation()) {
                    cir.setReturnValue(Biome.Precipitation.NONE);
                }
                cir.setReturnValue(this.isCold(pos) ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN);
            }
            if (!this.hasPrecipitation()) {
                cir.setReturnValue(Biome.Precipitation.NONE);
            }
            cir.cancel();
        }
    }

    @Inject(method = "doesNotSnow", at = @At("HEAD"), cancellable = true)
    public void doesNotSnow(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        //return this.getTemperature(pos) >= 0.15f;

        //TODO fix snowblock and iceblock meltable before turning this on.
        boolean enableSnow = true;

        if(Seasons.isSeasonsEnabled() && enableSnow) {
            /*assert MinecraftClient.getInstance().world != null;
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            long time = minecraftClient.world.getTimeOfDay();
            int season = Seasons.getCurrentSeason(time);
            String seasonString = Seasons.getSeasonString(season);*/

            //if (seasonString.equals("Winter")) {
            if (SeasonTickHandler.cSeason.equals("Winter")) {
                cir.setReturnValue(false);
            } else {
                cir.setReturnValue(true);
            }
            if (!this.hasPrecipitation()) {
                cir.setReturnValue(true);
            }
            cir.cancel();
        }
    }

    //@Inject(method = "canSetIce", at = @At("HEAD"), cancellable = true)
    @Inject(method = "canSetIce(Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;Z)Z",at = @At("RETURN"),cancellable = true)
    public void canSetIce(WorldView world, BlockPos pos, boolean doWaterCheck, CallbackInfoReturnable<Boolean> cir) {
        if(world.getBiome(pos).isIn(BiomeTags.POLAR_BEARS_SPAWN_ON_ALTERNATE_BLOCKS)) {
            cir.setReturnValue(true);
        }
        else if (world.getBiome(pos).isIn(BiomeTags.IS_OCEAN)
                || world.getBiome(pos).isIn(BiomeTags.IS_BEACH)
                || world.getBiome(pos).isIn(BiomeTags.IS_DEEP_OCEAN)
                || world.getBiome(pos).isIn(BiomeTags.IS_JUNGLE)
                || world.getBiome(pos).isIn(BiomeTags.IS_SAVANNA)
                || world.getBiome(pos).isIn(BiomeTags.IS_BADLANDS)
                || world.getBiome(pos).isIn(BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE)
        ) {
            cir.setReturnValue(false);
        }
    }
}
