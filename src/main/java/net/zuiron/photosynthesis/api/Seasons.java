package net.zuiron.photosynthesis.api;

import me.shedaniel.autoconfig.AutoConfig;
import net.zuiron.photosynthesis.config.ModConfig;

import java.text.DecimalFormat;

public class Seasons {
    static ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

    static String[] seasonNames = {"Summer", "Autumn", "Winter", "Spring"};

    // get str from int.
    public static String getSeasonString(int season) {
        return seasonNames[season];
    }

    // is seasons enabled or not.
    public static boolean isSeasonsEnabled() {
        return config.seasons; //true if seasons is enabled. false if disabled.
    }

    // calculate day based on minecraft time
    public static int getDay(long time) {
        return (int) (time / 24000L);
    }

    // calculate the current day of the current season
    public static int getDayInSeason(long time) {
        return (getDay(time)) % config.daysPerSeason;
    }

    // calculate days per year
    public static int getDaysPerYear() {
        return config.daysPerSeason * 4;
    }

    // Calculate the number of days since the start of the year, modulo the number of days in a year
    public static int getDayOfYear(long time) {
        return getDay(time) % getDaysPerYear();
    }

    // Calculate the year
    public static int getYear(long time) {
        return getDay(time) / (config.daysPerSeason * 4);
    }

    // Calculate remaining days in current year
    public static int getRemainingDaysInCurrentYear(long time) {
        return getDay(time) % (config.daysPerSeason * 4); //UMMMMMMM???
    }

    // Calculate the number of days per season, modulo the number of days in a year
    public static int getDaysPerSeasonMod() {
        return config.daysPerSeason % getDaysPerYear();
    }

    // Calculate the season, based on the number of days since the start of the year
    public static int getCurrentSeason(long time) {
        return (getDayOfYear(time) / getDaysPerSeasonMod()) % 4;
    }

    // Get the current season and days remaining in the season
    public static int getRemainingDaysOfCurrentSeason(long time) {
        return config.daysPerSeason - (getDay(time) % config.daysPerSeason);
    }

    // Calculate the percentage of the current season that has elapsed
    public static float getSeasonPercentage(long time) {
        return ((float) (getDay(time) % config.daysPerSeason)) / config.daysPerSeason;
    }

    //temperature
    public static float convertTemp(float temp) {
        // Define the range of your input values
        float minValue = -1.0f;
        float maxValue = 2.0f;

        // Define the corresponding Celsius temperature ranges
        float minCelsiusBelowZero = -20.0f; // Temperature range for values at or below 0.0
        float maxCelsiusBelowZero = 0.0f;

        float minCelsiusAboveZero = 9.0f;   // Temperature range for values above 0.0
        float maxCelsiusAboveZero = 34.0f;

        // Perform linear interpolation based on the input value
        float celsius;
        if (temp <= 0.0f) {
            // For values at or below 0.0, use the below-zero temperature range
            celsius = minCelsiusBelowZero + (maxCelsiusBelowZero - minCelsiusBelowZero) * (temp - minValue) / (0.0f - minValue);
        } else {
            // For values above 0.0, use the above-zero temperature range
            celsius = minCelsiusAboveZero + (maxCelsiusAboveZero - minCelsiusAboveZero) * (temp - 0.0f) / (maxValue - 0.0f);
        }

        return celsius;
    }
}