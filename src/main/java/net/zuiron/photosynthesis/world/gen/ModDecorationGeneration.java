package net.zuiron.photosynthesis.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.zuiron.photosynthesis.world.feature.ModPlacedFeatures;

public class ModDecorationGeneration {
    public static void generateDecorations() {
        /*
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DECO_ROCKS_STONE_PLACED_KEY);*/

        /*
        BiomeModifications.addFeature(
                context -> context.getBiome().getTemperature() >= 0.15 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.DESERT.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APPLETREE_PLACED_KEY
        );*/
        /*
        BiomeModifications.addFeature(
                context -> context.hasTag(BiomeTags.IS_OVERWORLD)
                        && !BiomeKeys.DESERT.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APPLETREE_PLACED_KEY
        );*/

        /*
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DECO_STICKS_OAK_PLACED_KEY);
         */

        //STONES AND STICKS
        BiomeModifications.addFeature(context -> context.hasTag(BiomeTags.IS_OVERWORLD)
                        && !BiomeKeys.DESERT.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DECO_ROCKS_RANDOM_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.hasTag(BiomeTags.IS_OVERWORLD)
                        && !BiomeKeys.DESERT.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DECO_STICKS_RANDOM_PLACED_KEY);


        //BEACHGRASS
        BiomeModifications.addFeature(context -> context.hasTag(BiomeTags.IS_OVERWORLD)
                        && BiomeKeys.BEACH.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DECO_BEACHGRASS_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.hasTag(BiomeTags.IS_OVERWORLD)
                        && BiomeKeys.BEACH.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DECO_TALL_BEACHGRASS_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.hasTag(BiomeTags.IS_OVERWORLD)
                        && BiomeKeys.BEACH.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DECO_SEASHELL_PLACED_KEY);

    }
}
