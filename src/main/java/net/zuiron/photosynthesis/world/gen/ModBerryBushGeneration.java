package net.zuiron.photosynthesis.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.zuiron.photosynthesis.world.feature.ModPlacedFeatures;

public class ModBerryBushGeneration {
    public static void generateBerryBushes() {
        /*
        BiomeModifications.addFeature(context -> context.hasTag(BiomeTags.IS_OVERWORLD)
                        && !BiomeKeys.DESERT.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DECO_ROCKS_RANDOM_PLACED_KEY);
         */
        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUEBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.9 && context.getBiome().getTemperature() <= 1.2,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLACKBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 1.5,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RASPBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.05 && context.getBiome().getTemperature() <= 0.9
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CLOUDBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 1.5,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_STRAWBERRY_BUSH_PLACED_KEY);


        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 1.2 && context.getBiome().getTemperature() <= 2.0,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CANDLEBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= -0.5 && context.getBiome().getTemperature() <= 1.2,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CRANBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.0 && context.getBiome().getTemperature() <= 1.2,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HUCKLEBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.JUNIPERBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.0 && context.getBiome().getTemperature() <= 2.0,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MULBERRY_BUSH_PLACED_KEY);
    }
}
