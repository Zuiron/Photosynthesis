package net.zuiron.photosynthesis.api;

import net.minecraft.text.TextColor;

import java.util.HashMap;
import java.util.Map;

public class CropData {
    private int[] maxAge;
    private int[] minAge;

    TextColor SPRING = TextColor.fromRgb(0xFF64e700);
    TextColor SUMMER = TextColor.fromRgb(0xFFe7e952);
    TextColor AUTUMN = TextColor.fromRgb(0xFFA500);
    TextColor WINTER = TextColor.fromRgb(0xFFebebeb);

    public CropData(int[] maxAge, int[] minAge) {
        this.maxAge = maxAge;
        this.minAge = minAge;
    }

    public int getMaxAge(int season) {
        return maxAge[season]; //max crop age for 'season'
    }

    public int getMinAge(int season) {
        return minAge[season]; //min crop age to grow in 'season'
    }

    public int getHarvestSeason() {
        for (int i = 0; i < 4; i++) {
            if(maxAge[i] == 7) {
                return i;
            }
        }
        return -1;
    }

    public int getPlantSeason() {
        for (int i = 0; i < 4; i++) {
            if(minAge[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public String getHarvestSeasonStr() {
        int harvestSeason = getHarvestSeason();
        return Seasons.getSeasonString(harvestSeason);
    }

    public String getPlantSeasonStr() {
        int plantSeason = getPlantSeason();
        return Seasons.getSeasonString(plantSeason);
    }

    public TextColor getPlantSeasonTextColor() {
        int plantSeason = getPlantSeason();
        if(plantSeason == 0) {
            return SUMMER;
        } else if(plantSeason == 1) {
            return AUTUMN;
        } else if (plantSeason == 2) {
            return WINTER;
        } else {
            return SPRING;
        }
    }

    public TextColor getHarvestSeasonTextColor() {
        int harvestSeason = getHarvestSeason();
        if(harvestSeason == 0) {
            return SUMMER;
        } else if(harvestSeason == 1) {
            return AUTUMN;
        } else if (harvestSeason == 2) {
            return WINTER;
        } else {
            return SPRING;
        }
    }

    public static Map<String, CropData> cropDataMap = new HashMap<>();
    static {                                                        //maxAge Summer, Autumn, Winter, Spring ---- minAge Summer, Autumn, Winter, Spring
        //Vanilla
        cropDataMap.put("block.minecraft.wheat",                    new CropData(new int[]{7, 1, 2, 5}, new int[]{4, 0, 1, 2}));    //plant autumn, harvest summer.
        cropDataMap.put("block.minecraft.carrots",                  new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.minecraft.potatoes",                 new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.minecraft.beetroot",                 new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.

        //Crops
        cropDataMap.put("block.photosynthesis.oregano_crop",        new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.

        //Berries and TreeCrops - where you want it to grow to max, use 7 not 3 as max, because 7 is identifier as "harvest season"
        cropDataMap.put("block.photosynthesis.appletree_bushcrop",  new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        // add more crops here as needed - crops not added here will grow as per vanilla.
    }

    public static CropData getCropDataFor(String blockName) {
        return cropDataMap.get(blockName);
    }
}

