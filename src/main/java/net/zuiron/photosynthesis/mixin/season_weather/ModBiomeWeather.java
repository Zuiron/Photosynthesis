package net.zuiron.photosynthesis.mixin.season_weather;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.Seasons;
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

    @Inject(method = "getPrecipitation", at = @At("HEAD"), cancellable = true)
    public void getPrecipitation(BlockPos pos, CallbackInfoReturnable<Biome.Precipitation> cir) {
        if(Seasons.isSeasonsEnabled()) {
            if (!this.hasPrecipitation()) {
                cir.setReturnValue(Biome.Precipitation.NONE);
            }

            assert MinecraftClient.getInstance().world != null;
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            long time = minecraftClient.world.getTimeOfDay();
            int season = Seasons.getCurrentSeason(time);
            String seasonString = Seasons.getSeasonString(season);

            if (seasonString.equals("Winter")) {
                cir.setReturnValue(Biome.Precipitation.SNOW);
            } else {
                cir.setReturnValue(Biome.Precipitation.RAIN);
            }
            cir.cancel();
        }
    }
}
