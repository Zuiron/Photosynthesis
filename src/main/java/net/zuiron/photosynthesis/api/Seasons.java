package net.zuiron.photosynthesis.api;

import me.shedaniel.autoconfig.AutoConfig;
import net.zuiron.photosynthesis.config.ModConfig;

public class Seasons {
    static ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    static boolean seasonsEnabled = config.seasons;
    static int daysPerSeason = config.daysPerSeason;

    // is seasons enabled or not.
    public static boolean isSeasonsEnabled() {
        return seasonsEnabled; //true if seasons is enabled. false if disabled.
    }

    // calculate day based on minecraft time
    public static int getDay(long time) {
        return (int) (time / 24000L);
    }

    // calculate the current day of the current season
    public static int getDayInSeason(long time) {
        return (getDay(time)) % daysPerSeason;
    }
}