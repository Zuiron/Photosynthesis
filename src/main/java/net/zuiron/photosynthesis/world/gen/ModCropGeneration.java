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
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TOMATO_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BASIL_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OREGANO_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.STRAWBERRY_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OAT_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.JALAPENO_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHILI_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CUCUMBER_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ONION_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LEEK_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CELERY_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PEAS_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SWEET_POTATO_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ASPARAGUS_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SCALLION_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GARLIC_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHIVE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BROCCOLI_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CAULIFLOWER_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CORN_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CABBAGE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BELLPEPPER_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TURNIP_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RUTABAGA_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CANOLA_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BARLEY_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.COTTON_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SUGARBEET_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RICE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WHITE_BUTTON_MUSHROOM_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SOYBEAN_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SPINACH_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ARROWROOT_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ARTICHOKE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BRUSSELS_SPROUTS_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CASSAVA_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.EGGPLANT_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SUNFLOWER_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.JICAMA_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.KALE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.KOHLRABI_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LETTUCE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OKRA_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PARSNIP_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RADISH_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RHUBARB_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MILLET_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RYE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SQUASH_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ZUCCHINI_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.COFFEA_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PARSLEY_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MINT_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PINEAPPLE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HOP_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FILIPENDULA_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CACTUS_FRUIT_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CANTALOUPE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FLAX_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.JUTE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.KENAF_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SISAL_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AMARANTH_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BEAN_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHICKPEA_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LENTIL_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.QUINOA_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PEANUT_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TARO_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TOMATILLO_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AGAVE_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GINGER_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SESAME_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MUSTARD_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CAMELLIA_SINENSIS_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.NICOTIANA_RUSTICA_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PAPAVER_SOMNIFERUM_CROP_PLACED_KEY);

        BiomeModifications.addFeature(context -> context.getBiome().getTemperature() >= 0.5 && context.getBiome().getTemperature() <= 2.0
                        && !BiomeKeys.PLAINS.equals(context.getBiomeKey()) && context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ERYTHROXYLUM_COCA_CROP_PLACED_KEY);











    }
}
