package net.zuiron.photosynthesis.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.zuiron.photosynthesis.world.feature.ModPlacedFeatures;

public class ModCropGeneration {
    public static void generateCrops() {
        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BASIL_CROP_PLACED_KEY);

    }
}
