package net.zuiron.photosynthesis.api;

import java.util.HashMap;
import java.util.Map;

public class CropData {
    private int[] maxAge;
    private int[] minAge;

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
        int harvestSeason = getPlantSeason();
        return Seasons.getSeasonString(harvestSeason);
    }

    public static Map<String, CropData> cropDataMap = new HashMap<>();
    static { //maxAge Summer, Autumn, Winter, Spring ---- minAge Summer, Autumn, Winter, Spring
        cropDataMap.put("block.minecraft.wheat",                new CropData(new int[]{7, 1, 2, 5}, new int[]{4, 0, 1, 2}));    //plant autumn, harvest summer.
        cropDataMap.put("block.minecraft.carrots",              new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.minecraft.potatoes",             new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.minecraft.beetroot",             new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        cropDataMap.put("block.photosynthesis.oregano_crop",    new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        // add more crops here as needed
    }

    public static CropData getCropDataFor(String blockName) {
        return cropDataMap.get(blockName);
    }
}

