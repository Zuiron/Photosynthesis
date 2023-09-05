package net.zuiron.photosynthesis.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.zuiron.photosynthesis.api.Seasons;

public class SeasonTickHandler implements ServerTickEvents.StartTick {
    public static String cSeason = "Spring";
    @Override
    public void onStartTick(MinecraftServer server) {
        if(Seasons.isSeasonsEnabled()) {
            long time = server.getOverworld().getTimeOfDay();
            cSeason = Seasons.getSeasonString(Seasons.getCurrentSeason(time));
        }
    }
}
