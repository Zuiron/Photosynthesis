package net.zuiron.photosynthesis.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.zuiron.photosynthesis.world.feature.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        /*BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APPLETREE_PLACED_KEY);*/

        /*BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), //includeByKey(BiomeKeys.SPARSE_JUNGLE
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BANANATREE_PLACED_KEY);*/

        /*BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.15 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APPLETREE_PLACED_KEY);*/

        BiomeModifications.addFeature(context -> {
            RegistryKey<Biome> biomeKey = context.getBiomeKey();
            String biomeId = biomeKey.getValue().toString();
            float temperature = context.getBiome().getTemperature();
            return temperature >= 0.15 && temperature <= 0.95
                    && !biomeId.equals("minecraft:plains")
                    && !biomeId.equals("tectonic:cold_plains")
                    && !biomeId.equals("tectonic:grasslands");
        }, GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APPLETREE_PLACED_KEY);



        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.9 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BANANATREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.95 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CINNAMONTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.8 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGETREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.15 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PEARTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 1.0 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.COCONUTTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AVOCADOTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHERRYTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 1.2
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LEMONTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.8 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MANGOTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.2 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OLIVETREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RUBBERTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.6 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CANDLENUTTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= -0.5 && context.getBiome().getTemperature() <= 0.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHESTNUTTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.6 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.NUTMEGTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.2 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PEACHTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= -0.5 && context.getBiome().getTemperature() <= 0.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PLUMTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= -0.5 && context.getBiome().getTemperature() <= 0.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WALNUTTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= -0.5 && context.getBiome().getTemperature() <= 0.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HAZELNUTTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.2 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PAWPAWTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.2 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SOURSOPTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.0 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ALMONDTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.2 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APRICOTTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.6 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CASHEWTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 1.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DATETREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.8 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DRAGONFRUITTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 1.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DURIANTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.2 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FIGTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.2 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GRAPEFRUITTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.2 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LIMETREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.2 && context.getBiome().getTemperature() <= 0.95
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PAPAYATREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= -0.5 && context.getBiome().getTemperature() <= 0.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PECANTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.6 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PERSIMMONTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.6 && context.getBiome().getTemperature() <= 1.2
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PISTACHIOTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.9 && context.getBiome().getTemperature() <= 1.1
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.POMEGRANATETREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.7 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.STARFRUITTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.95 && context.getBiome().getTemperature() <= 1.2
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BREADFRUITTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.95 && context.getBiome().getTemperature() <= 1.4
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GUAVATREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.95 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.JACKFRUITTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.95 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LYCHEETREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.85 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PASSIONFRUITTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.9 && context.getBiome().getTemperature() <= 1.2
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RAMBUTANTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.25 && context.getBiome().getTemperature() <= 1.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TAMARINDTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MAPLETREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 1.5 && context.getBiome().getTemperature() <= 2.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PEPPERCORNTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 1.5 && context.getBiome().getTemperature() <= 2.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.VANILLABEANTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PINENUTTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GOOSEBERRYTREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GRAPETREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RED_GRAPETREE_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 1.5
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.KIWITREE_PLACED_KEY);

    }
}