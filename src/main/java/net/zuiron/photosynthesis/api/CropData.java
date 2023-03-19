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
        return 0;
    }

    public int getPlantSeason() {
        for (int i = 0; i < 4; i++) {
            if(minAge[i] == 0) {
                return i;
            }
        }
        return 0;
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
    static {
        //Vanilla                                                       //maxAge Summer, Autumn, Winter, Spring ---- minAge Summer, Autumn, Winter, Spring
        cropDataMap.put("block.minecraft.wheat",                        new CropData(new int[]{7, 1, 2, 5}, new int[]{4, 0, 1, 2}));    //plant autumn, harvest summer.
        cropDataMap.put("block.minecraft.carrots",                      new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.minecraft.potatoes",                     new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.minecraft.beetroots",                    new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.minecraft.sweet_berry_bush",             new CropData(new int[]{7, 0, 0, 1}, new int[]{1, 7, 7, 0}));    //plant spring, harvest summer.
        //cropDataMap.put("block.minecraft.melon_stem",                 new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        //cropDataMap.put("block.minecraft.pumpkin_stem",               new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        //TODO need to make mixin for StemBlock. melon and pumpkin. or nah?
        //TODO mixin for cocoaBlock. or nah?
        //TODO GlowBerries? / cave vines. or nah?

        //Crops                                                         //maxAge Summer, Autumn, Winter, Spring ---- minAge Summer, Autumn, Winter, Spring
        cropDataMap.put("block.photosynthesis.tomato_crop",             new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.basil_crop",              new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        cropDataMap.put("block.photosynthesis.oregano_crop",            new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        cropDataMap.put("block.photosynthesis.strawberry_crop",         new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.oat_crop",                new CropData(new int[]{7, 1, 2, 5}, new int[]{4, 0, 1, 2}));    //plant autumn, harvest summer.
        cropDataMap.put("block.photosynthesis.jalapeno_crop",           new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.chili_crop",              new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.cucumber_crop",           new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        cropDataMap.put("block.photosynthesis.onion_crop",              new CropData(new int[]{7, 1, 2, 5}, new int[]{4, 0, 1, 2}));    //plant autumn, harvest summer.
        cropDataMap.put("block.photosynthesis.leek_crop",               new CropData(new int[]{7, 1, 2, 5}, new int[]{4, 0, 1, 2}));    //plant autumn, harvest summer.
        cropDataMap.put("block.photosynthesis.celery_crop",             new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        cropDataMap.put("block.photosynthesis.peas_crop",               new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.sweet_potato_crop",       new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.asparagus_crop",          new CropData(new int[]{5, 2, 4, 7}, new int[]{7, 0, 2, 4}));    //plant autumn, harvest spring.
        cropDataMap.put("block.photosynthesis.scallion_crop",           new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.garlic_crop",             new CropData(new int[]{5, 2, 4, 7}, new int[]{7, 0, 2, 4}));    //plant autumn, harvest spring.
        cropDataMap.put("block.photosynthesis.chive_crop",              new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.broccoli_crop",           new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.cauliflower_crop",        new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.corn_crop",               new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.cabbage_crop",            new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.bellpepper_crop",         new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.turnip_crop",             new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        cropDataMap.put("block.photosynthesis.rutabaga_crop",           new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.canola_crop",             new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.barley_crop",             new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.cotton_crop",             new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.sugarbeet_crop",          new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.rice_crop",               new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.soybean_crop",            new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        cropDataMap.put("block.photosynthesis.spinach_crop",            new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.arrowroot_crop",          new CropData(new int[]{4, 6, 7, 2}, new int[]{2, 4, 6, 0}));    //plant spring, harvest winter.
        cropDataMap.put("block.photosynthesis.artichoke_crop",          new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.brussels_sprouts_crop",   new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.cassava_crop",            new CropData(new int[]{4, 6, 7, 2}, new int[]{2, 4, 6, 0}));    //plant spring, harvest winter.
        cropDataMap.put("block.photosynthesis.eggplant_crop",           new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.sunflower_crop",          new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.jicama_crop",             new CropData(new int[]{4, 6, 7, 2}, new int[]{2, 4, 6, 0}));    //plant spring, harvest winter.
        cropDataMap.put("block.photosynthesis.kale_crop",               new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.kohlrabi_crop",           new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.lettuce_crop",            new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.okra_crop",               new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.parsnip_crop",            new CropData(new int[]{5, 2, 4, 7}, new int[]{7, 0, 2, 4}));    //plant autumn, harvest spring.
        cropDataMap.put("block.photosynthesis.radish_crop",             new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.rhubarb_crop",            new CropData(new int[]{7, 1, 2, 5}, new int[]{4, 0, 1, 2}));    //plant autumn, harvest summer.
        cropDataMap.put("block.photosynthesis.millet_crop",             new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        cropDataMap.put("block.photosynthesis.rye_crop",                new CropData(new int[]{7, 1, 2, 5}, new int[]{4, 0, 1, 2}));    //plant autumn, harvest summer.
        cropDataMap.put("block.photosynthesis.squash_crop",             new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        cropDataMap.put("block.photosynthesis.zucchini_crop",           new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.coffea_crop",             new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.parsley_crop",            new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.mint_crop",               new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.pineapple_crop",          new CropData(new int[]{4, 7, 0, 0}, new int[]{0, 4, 7, 7}));    //plant summer, harvest autumn.
        cropDataMap.put("block.photosynthesis.hop_crop",                new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.filipendula_crop",        new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.cactus_fruit_crop",       new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.cantaloupe_crop",         new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.flax_crop",               new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.jute_crop",               new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.kenaf_crop",              new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.sisal_crop",              new CropData(new int[]{7, 1, 2, 5}, new int[]{4, 0, 1, 2}));    //plant autumn, harvest summer.
        cropDataMap.put("block.photosynthesis.amaranth_crop",           new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.bean_crop",               new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.chickpea_crop",           new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.lentil_crop",             new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.quinoa_crop",             new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.peanut_crop",             new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.taro_crop",               new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.tomatillo_crop",          new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.agave_crop",              new CropData(new int[]{7, 1, 2, 5}, new int[]{4, 0, 1, 2}));    //plant autumn, harvest summer.
        cropDataMap.put("block.photosynthesis.ginger_crop",             new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.sesame_crop",             new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.mustard_crop",            new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.camellia_sinensis_crop",  new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.nicotiana_rustica_crop",  new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.papaver_somniferum_crop", new CropData(new int[]{7, 0, 0, 4}, new int[]{4, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.erythroxylum_coca_crop",  new CropData(new int[]{4, 7, 1, 1}, new int[]{1, 4, 7, 0}));    //plant spring, harvest autumn.


        //Berries - where you want it to grow to max, use 7 not 3 as max, because 7 is identifier as "harvest season"
                                                                        //maxAge Summer, Autumn, Winter, Spring ---- minAge Summer, Autumn, Winter, Spring
        cropDataMap.put("block.photosynthesis.blueberry_bush",          new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.blackberry_bush",         new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.raspberry_bush",          new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.cloudberry_bush",         new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.wild_strawberry_bush",    new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.candleberry_bush",        new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.cranberry_bush",          new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.huckleberry_bush",        new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.juniperberry_bush",       new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.mulberry_bush",           new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.

        //TreeCrops - where you want it to grow to max, use 7 not 3 as max, because 7 is identifier as "harvest season"
                                                                        //maxAge Summer, Autumn, Winter, Spring ---- minAge Summer, Autumn, Winter, Spring
        cropDataMap.put("block.photosynthesis.appletree_bushcrop",      new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.bananatree_bushcrop",     new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.orangetree_bushcrop",     new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.peartree_bushcrop",       new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.coconuttree_bushcrop",    new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.avocadotree_bushcrop",    new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.cherrytree_bushcrop",     new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.lemontree_bushcrop",      new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.mangotree_bushcrop",      new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.olivetree_bushcrop",      new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.candlenuttree_bushcrop",  new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.chestnuttree_bushcrop",   new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.nutmegtree_bushcrop",     new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.peachtree_bushcrop",      new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.plumtree_bushcrop",       new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.walnuttree_bushcrop",     new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.hazelnuttree_bushcrop",   new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.pawpawtree_bushcrop",     new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.soursoptree_bushcrop",    new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.almondtree_bushcrop",     new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.apricottree_bushcrop",    new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.cashewtree_bushcrop",     new CropData(new int[]{2, 2, 7, 2}, new int[]{2, 2, 2, 0}));    //plant spring, harvest winter.
        cropDataMap.put("block.photosynthesis.datetree_bushcrop",       new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.dragonfruittree_bushcrop",new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.duriantree_bushcrop",     new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.figtree_bushcrop",        new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.grapefruittree_bushcrop", new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.limetree_bushcrop",       new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.papayatree_bushcrop",     new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.pecantree_bushcrop",      new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.persimmontree_bushcrop",  new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.pistachiotree_bushcrop",  new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.pomegranatetree_bushcrop",new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.starfruittree_bushcrop",  new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.breadfruittree_bushcrop", new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.guavatree_bushcrop",      new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.jackfruittree_bushcrop",  new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.lycheetree_bushcrop",     new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.passionfruittree_bushcrop",new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.rambutantree_bushcrop",   new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.tamarindtree_bushcrop",   new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.peppercorntree_bushcrop", new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        cropDataMap.put("block.photosynthesis.vanillabeantree_bushcrop",new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.pinenuttree_bushcrop",    new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.gooseberrytree_bushcrop", new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.grapetree_bushcrop",      new CropData(new int[]{7, 0, 0, 2}, new int[]{2, 7, 7, 0}));    //plant spring, harvest summer.
        cropDataMap.put("block.photosynthesis.kiwitree_bushcrop",       new CropData(new int[]{2, 7, 0, 1}, new int[]{1, 2, 7, 0}));    //plant spring, harvest autumn.
        //cropDataMap.put("block.photosynthesis.",        new CropData(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}));
        // add more crops here as needed - crops not added here will grow as per vanilla.
    }

    public static CropData getCropDataFor(String blockName) {
        return cropDataMap.get(blockName);
    }
}

