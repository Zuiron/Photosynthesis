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
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable thirst")
    public boolean thirst = true;

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable seasons")
    public boolean seasons = true;

    @ConfigEntry.Gui.Tooltip
    @Comment("Days per season")
    public int daysPerSeason = 18;


    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable spawn egg baby animal (animals from egg spawn as baby) Only Affects: Pig,Cow,Sheep,Chicken,Horse & Goats.")
    public boolean spawnEggBaby = true;
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Pig spawning")
    public boolean doPigSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Cow spawning")
    public boolean doCowSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Sheep spawning")
    public boolean doSheepSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Chicken spawning")
    public boolean doChickenSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Horse spawning")
    public boolean doHorseSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Goat spawning")
    public boolean doGoatSpawn = false;


    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Creeper spawning")
    public boolean doCreeperSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Zombie spawning")
    public boolean doZombieSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural ZombieVillager spawning")
    public boolean doZombieVillagerSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural ZombieVillager spawning")
    public boolean doZombieHorseSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Skeleton spawning")
    public boolean doSkeletonSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Husk spawning")
    public boolean doHuskSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Witch spawning")
    public boolean doWitchSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural Husk spawning")
    public boolean doSpiderSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural SkeletonHorse spawning")
    public boolean doSkeletonHorseSpawn = false;

    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable natural EnderMan spawning")
    public boolean doEnderManSpawn = false;

    //https://www.curseforge.com/minecraft/texture-packs/seasons-data-pack

    // CLIENT side-only SETTINGS
    @ConfigEntry.Category("Client")
    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable season timeline")
    public boolean seasonDisplayTimeline = true;

    @ConfigEntry.Category("Client")
    @Comment("Season Timeline text scale")
    public float seasonTimelineTextScale = 0.5f;

    @ConfigEntry.Category("Client")
    @Comment("Season Timeline text Y offset")
    public int seasonTimelineTextYOffset = 20;




    @ConfigEntry.Category("Client")
    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable season icon")
    public boolean seasonDisplayIcon = true;

    @ConfigEntry.Category("Client")
    @ConfigEntry.Gui.Tooltip
    @Comment("enable or disable season info")
    public boolean seasonDisplayInfo = true;

    @ConfigEntry.Category("Client")
    @Comment("Season Info text scale")
    public float seasonDisplayInfoScale = 0.5f;

    @ConfigEntry.Category("Client")
    @Comment("Season Info text X offset")
    public int seasonDisplayInfoXOffset = 0;

    @ConfigEntry.Category("Client")
    @Comment("Season Info text Y offset")
    public int seasonDisplayInfoYOffset = 0;

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
