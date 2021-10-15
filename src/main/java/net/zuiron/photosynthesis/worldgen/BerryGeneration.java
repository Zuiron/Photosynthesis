package net.zuiron.photosynthesis.worldgen;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.zuiron.photosynthesis.Photosynthesis;

import java.util.function.Predicate;

public class BerryGeneration {

    public static void registerBerryGeneration(String spawnBiomes, Block bushBlock, int spawnChance, String name) {
        String[] biomes = spawnBiomes.split(",");
        BlockState blockState = bushBlock.getDefaultState().with(SweetBerryBushBlock.AGE, 3);
        RandomPatchFeatureConfig featureConfig = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(blockState), SimpleBlockPlacer.INSTANCE)).tries(32).spreadX(1).spreadY(2).spreadZ(1).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK)).build();
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Photosynthesis.MOD_ID, name + "_generation"), Feature.RANDOM_PATCH.configure(featureConfig).applyChance(spawnChance * 2));

        for(int i = 0; i < biomes.length; i++) {
            Predicate<BiomeSelectionContext> biomeSelector = BiomeSelectors.includeByKey(RegistryKey.of(Registry.BIOME_KEY, new Identifier(biomes[i])));
            BiomeModifications.addFeature(biomeSelector, GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Photosynthesis.MOD_ID, name + "_generation")));
        }

        Photosynthesis.LOGGER.info("Berry Generation: " + name);
    }
}
