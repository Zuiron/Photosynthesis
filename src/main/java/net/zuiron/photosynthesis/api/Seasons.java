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

    // calculate days per year
    public static int getDaysPerYear() {
        return daysPerSeason * 4;
    }

    // Calculate the number of days since the start of the year, modulo the number of days in a year
    public static int getDayOfYear(long time) {
        return getDay(time) % getDaysPerYear();
    }

    // Calculate the year
    public static int getYear(long time) {
        return getDay(time) / (daysPerSeason * 4);
    }

    // Calculate remaining days in current year
    public static int getRemainingDaysInCurrentYear(long time) {
        return getDay(time) % (daysPerSeason * 4); //UMMMMMMM???
    }

    // Calculate the number of days per season, modulo the number of days in a year
    public static int getDaysPerSeasonMod() {
        return daysPerSeason % getDaysPerYear();
    }

    // Calculate the season, based on the number of days since the start of the year
    public static int getCurrentSeason(long time) {
        return (getDayOfYear(time) / getDaysPerSeasonMod()) % 4;
    }

    // Get the current season and days remaining in the season
    public static int getRemainingDaysOfCurrentSeason(long time) {
        return daysPerSeason - (getDay(time) % daysPerSeason);
    }

    // Calculate the percentage of the current season that has elapsed
    public static float getSeasonPercentage(long time) {
        return ((float) (getDay(time) % daysPerSeason)) / daysPerSeason;
    }
}