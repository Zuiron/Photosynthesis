package net.zuiron.photosynthesis.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.Seasons;

public class SeasonTickHandler implements ServerTickEvents.StartTick {
    public static String cSeason = "Spring";
    public static boolean firstDaySnowWinter = false;
    @Override
    public void onStartTick(MinecraftServer server) {
        if(Seasons.isSeasonsEnabled()) {
            long time = server.getOverworld().getTimeOfDay();
            cSeason = Seasons.getSeasonString(Seasons.getCurrentSeason(time));

            if(!cSeason.equals("Winter")) {
                firstDaySnowWinter = true;
            }

            if(firstDaySnowWinter && cSeason.equals("Winter")) {
                server.getOverworld().setWeather(0, 24000, true, false);
                firstDaySnowWinter = false;
            }
        }
    }
}
