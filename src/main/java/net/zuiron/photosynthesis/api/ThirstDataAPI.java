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

        //Minecraft
        thirstDataMap.put("item.minecraft.cooked_beef",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.cooked_porkchop",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.cooked_mutton",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.cooked_chicken",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.cooked_rabbit",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.cooked_cod",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.cooked_salmon",  new ThirstDataAPI(0, 0, 0, 0));

        thirstDataMap.put("item.minecraft.apple",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.minecraft.golden_apple",  new ThirstDataAPI(0, 300, 0, 0));
        thirstDataMap.put("item.minecraft.enchanted_golden_apple",  new ThirstDataAPI(0, 600, 0, 0));
        thirstDataMap.put("item.minecraft.melon_slice",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.minecraft.sweet_berries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.minecraft.glow_berries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.minecraft.chorus_fruit",  new ThirstDataAPI(0, 60, 0, 0));

        thirstDataMap.put("item.minecraft.beef",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.porkchop",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.mutton",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.chicken",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.rabbit",  new ThirstDataAPI(0, 0, 0, 0));

        thirstDataMap.put("item.minecraft.poisonous_potato",  new ThirstDataAPI(0, 0, 5, 540));
        thirstDataMap.put("item.minecraft.rotten_flesh",  new ThirstDataAPI(0, 0, 5, 540));
        thirstDataMap.put("item.minecraft.spider_eye",  new ThirstDataAPI(0, 0, 5, 540));

        thirstDataMap.put("item.minecraft.honey_bottle",  new ThirstDataAPI(0, 120, 0, 0));

        thirstDataMap.put("item.minecraft.bread",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.cookie",  new ThirstDataAPI(0, 0, 0, 0));
        thirstDataMap.put("item.minecraft.pumpkin_pie",  new ThirstDataAPI(0, 0, 0, 0));

        thirstDataMap.put("item.minecraft.mushroom_stew",  new ThirstDataAPI(1, 60, 0, 0));
        thirstDataMap.put("item.minecraft.beetroot_soup",  new ThirstDataAPI(1, 60, 0, 0));
        thirstDataMap.put("item.minecraft.rabbit_stew",  new ThirstDataAPI(1, 60, 0, 0));




        //Crop Produce
        thirstDataMap.put("item.photosynthesis.strawberry",  new ThirstDataAPI(0, 60, 0, 0));
        //Tree Produce

        //Berries
        thirstDataMap.put("item.photosynthesis.blueberries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.photosynthesis.blackberries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.photosynthesis.raspberries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.photosynthesis.cloudberries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.photosynthesis.wild_strawberries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.photosynthesis.lingonberries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.photosynthesis.cranberries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.photosynthesis.huckleberries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.photosynthesis.juniperberries",  new ThirstDataAPI(0, 60, 0, 0));
        thirstDataMap.put("item.photosynthesis.mulberries",  new ThirstDataAPI(0, 60, 0, 0));
        //Foods
    }

    public static ThirstDataAPI getThirstDataFor(String itemName) {
        return thirstDataMap.get(itemName);
    }
}
