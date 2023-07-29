package net.zuiron.photosynthesis.api;

import me.shedaniel.autoconfig.AutoConfig;
import net.zuiron.photosynthesis.config.ModConfig;

import java.util.HashMap;
import java.util.Map;

public class ThirstDataAPI {
    static ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    private int thirst;
    private int thirstSat;
    private int remThirst;
    private int remThirstSat;

    public ThirstDataAPI(int thirst, int thirstSat, int remThirst, int remThirstSat) {
        this.thirst = thirst;
        this.thirstSat = thirstSat;
        this.remThirst = remThirst;
        this.remThirstSat = remThirstSat;
    }

    public int getThirstData() {
        return thirst;
    }

    public int getRemThirstData() {return remThirst; }

    public int getThirstSatData() {
        return thirstSat;
    }

    public int getRemThirstSatData() {return remThirstSat; }

    public static boolean isThirstEnabled() { return config.thirst; }

    public static Map<String, ThirstDataAPI> thirstDataMap = new HashMap<>();
    static {
        //IF a food item is NOT in this list. you will lose 1 Thirst, and 150 Saturation.
        //Max Thirst: 10
        //Max Saturation: 600 - 60 per 1 ICON
        thirstDataMap.put("item.minecraft.cooked_beef",  new ThirstDataAPI(0, 0, 2, 180));
        thirstDataMap.put("item.photosynthesis.strawberry",  new ThirstDataAPI(0, 60, 0, 0));
    }

    public static ThirstDataAPI getThirstDataFor(String itemName) {
        return thirstDataMap.get(itemName);
    }
}
