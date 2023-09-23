package net.zuiron.photosynthesis.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.zuiron.photosynthesis.entity.ModEntities;
import net.zuiron.photosynthesis.entity.custom.AlligatorEntity;
import net.zuiron.photosynthesis.entity.custom.BoarEntity;

public class ModEntitySpawns {
    public static void addSpawns() {
        /*BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE, BiomeKeys.FOREST, BiomeKeys.WOODED_BADLANDS, BiomeKeys.DARK_FOREST),
                SpawnGroup.CREATURE, ModEntities.BOAR, 200, 1, 3);*/
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_BADLANDS),
                SpawnGroup.CREATURE, ModEntities.BOAR, 200, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_FOREST),
                SpawnGroup.CREATURE, ModEntities.BOAR, 200, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_JUNGLE),
                SpawnGroup.CREATURE, ModEntities.BOAR, 200, 1, 3);

        SpawnRestriction.register(ModEntities.BOAR, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, BoarEntity::isValidSpawn); //AnimalEntity::isValidNaturalSpawn



        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.RUINED_PORTAL_SWAMP_HAS_STRUCTURE), //BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP
                SpawnGroup.CREATURE, ModEntities.ALLIGATOR, 700, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_RIVER),
                SpawnGroup.CREATURE, ModEntities.ALLIGATOR, 110, 1, 1);

        SpawnRestriction.register(ModEntities.ALLIGATOR, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AlligatorEntity::isValidSpawn);
    }
}
