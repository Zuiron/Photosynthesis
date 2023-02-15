package net.zuiron.photosynthesis.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.zuiron.photosynthesis.world.feature.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APPLETREE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), //includeByKey(BiomeKeys.SPARSE_JUNGLE
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BANANATREE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CINNAMONTREE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGETREE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PEARTREE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.COCONUTTREE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AVOCADOTREE_PLACED_KEY);
    }
}