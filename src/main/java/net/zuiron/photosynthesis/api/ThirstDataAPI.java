package net.zuiron.photosynthesis.api;

import java.util.HashMap;
import java.util.Map;

public class ThirstDataAPI {
    private int thirst;
    private int thirstSat;

    public ThirstDataAPI(int thirst, int thirstSat) {
        this.thirst = thirst;
        this.thirstSat = thirstSat;
    }

    public int getThirstData() {
        return thirst;
    }

    public int getThirstSatData() {
        return thirstSat;
    }

    public static Map<String, ThirstDataAPI> thirstDataMap = new HashMap<>();
    static {
        thirstDataMap.put("item.photosynthesis.strawberry",  new ThirstDataAPI(0, 60));
    }

    public static ThirstDataAPI getThirstDataFor(String itemName) {
        return thirstDataMap.get(itemName);
    }
}
