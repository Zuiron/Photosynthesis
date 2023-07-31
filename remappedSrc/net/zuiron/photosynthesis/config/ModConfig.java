package net.zuiron.photosynthesis.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.zuiron.photosynthesis.Photosynthesis;

@Config(name = Photosynthesis.MOD_ID)
public class ModConfig implements ConfigData {
    //@Comment("test")
    //public boolean requireHeatUnder = true;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable thirst")
    public boolean thirst = true;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable seasons")
    public boolean seasons = true;
    public int daysPerSeason = 20;

    //https://www.curseforge.com/minecraft/texture-packs/seasons-data-pack

    /*boolean toggleA = true;
    boolean toggleB = false;

    @ConfigEntry.Gui.CollapsibleObject
    InnerStuff stuff = new InnerStuff();

    @ConfigEntry.Gui.Excluded
    InnerStuff invisibleStuff = new InnerStuff();

    static class InnerStuff {
        int a = 0;
        int b = 1;
    }*/
}
