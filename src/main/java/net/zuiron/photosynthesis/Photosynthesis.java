package net.zuiron.photosynthesis;

import net.fabricmc.api.ModInitializer;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Photosynthesis implements ModInitializer {
	public static final String MOD_ID = "photosynthesis";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems(); //Items first otherwise crash.
		ModBlocks.registerModBlocks();



		//WORLD GEN ----------------------------------------------------------------------------------------------------
		final String SPAWN_BIOMES = "" +
				"minecraft:birch_forest," +
				"minecraft:tall_birch_forest," +
				"minecraft:tall_birch_hills," +
				"minecraft:swamp," +
				"minecraft:swamp_hills," +
				"minecraft:badlands," +
				"minecraft:wooded_badlands_plateau," +
				"minecraft:badlands_plateau," +
				"minecraft:eroded_badlands," +
				"minecraft:modified_wooded_badlands_plateau," +
				"minecraft:modified_badlands_plateau," +
				"minecraft:jungle," +
				"minecraft:jungle_hills," +
				"minecraft:jungle_edge," +
				"minecraft:modified_jungle," +
				"minecraft:modified_jungle_edge," +
				"minecraft:bamboo_jungle," +
				"minecraft:bamboo_jungle_hills," +
				"minecraft:forest," +
				"minecraft:wooded_hills," +
				"minecraft:plains";

		final String BLUEBERRY_SPAWN_BIOMES = "minecraft:birch_forest,minecraft:tall_birch_forest";
		final String BLACKBERRY_SPAWN_BIOMES = "minecraft:modified_wooded_badlands_plateau,minecraft:tall_birch_hills,minecraft:dark_forest,minecraft:wooded_hills";
		final String RASPBERRY_SPAWN_BIOMES = "minecraft:plains,minecraft:jungle";
		final String CLOUDBERRY_SPAWN_BIOMES = "minecraft:mountains,minecraft:swamp,minecraft:snowy_mountains,minecraft:snowy_taiga,minecraft:snowy_taiga_hills,minecraft:snowy_taiga_mountains,minecraft:taiga_mountains,minecraft:wooded_mountains";
		final String WILD_STRAWBERRY_SPAWN_BIOMES = "minecraft:flower_forest,minecraft:forest,minecraft:snowy_mountains,minecraft:taiga_hills,minecraft:tall_birch_hills,minecraft:snowy_mountains,minecraft:wooded_mountains,minecraft:taiga";

		//BerryGeneration.registerBerryGeneration(BLUEBERRY_SPAWN_BIOMES, ModBlocks.BLUEBERRY_BUSH, 16, "blueberry");
		//BerryGeneration.registerBerryGeneration(BLACKBERRY_SPAWN_BIOMES, ModBlocks.BLACKBERRY_BUSH, 16, "blackberry");
		//BerryGeneration.registerBerryGeneration(RASPBERRY_SPAWN_BIOMES, ModBlocks.RASPBERRY_BUSH, 16, "raspberry");
		//BerryGeneration.registerBerryGeneration(CLOUDBERRY_SPAWN_BIOMES, ModBlocks.CLOUDBERRY_BUSH, 15, "cloudberry");
		//BerryGeneration.registerBerryGeneration(WILD_STRAWBERRY_SPAWN_BIOMES, ModBlocks.WILD_STRAWBERRY_BUSH, 14, "wild_strawberry");

		LOGGER.info("Hello Fabric world!");
	}
}
