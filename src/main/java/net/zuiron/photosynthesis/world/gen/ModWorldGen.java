package net.zuiron.photosynthesis.world.gen;

public class ModWorldGen {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModFlowerGeneration.generateFlowers();
        ModBerryBushGeneration.generateBerryBushes();
        ModTreeGeneration.generateTrees();
        ModDecorationGeneration.generateDecorations();
        //ModCropGeneration.generateCrops();
        ModEntitySpawns.addSpawns();
    }
}
