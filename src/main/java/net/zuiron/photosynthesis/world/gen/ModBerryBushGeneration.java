package net.zuiron.photosynthesis.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.zuiron.photosynthesis.world.feature.ModPlacedFeatures;

public class ModBerryBushGeneration {
    public static void generateBerryBushes() {
        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 0.95,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUEBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.9 && context.getBiome().getTemperature() <= 1.2,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLACKBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 1.5,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RASPBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.05 && context.getBiome().getTemperature() <= 0.9,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CLOUDBERRY_BUSH_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 1.5,
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_STRAWBERRY_BUSH_PLACED_KEY);
    }
}
