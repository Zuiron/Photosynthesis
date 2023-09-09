package net.zuiron.photosynthesis.mixin.season_weather;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.event.SeasonTickHandler;
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
                    //if (SeasonTickHandler.cSeason.equals("Winter")) {
                    cir.setReturnValue(Biome.Precipitation.SNOW);
                } else {
                    cir.setReturnValue(Biome.Precipitation.RAIN);
                }
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
}
