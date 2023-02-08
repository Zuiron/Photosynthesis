package net.zuiron.photosynthesis;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.mixin.TreeDecoratorTypeInvoker;
import net.zuiron.photosynthesis.util.ModFlammableBlocks;
import net.zuiron.photosynthesis.util.ModStrippableBlocks;
import net.zuiron.photosynthesis.world.feature.ModConfiguredFeatures;
import net.zuiron.photosynthesis.world.gen.ModWorldGen;
import net.zuiron.photosynthesis.world.gen.RichTreeDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Photosynthesis implements ModInitializer {
	public static final String MOD_ID = "photosynthesis";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final TreeDecoratorType<RichTreeDecorator> RICH_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:rich_tree_decorator", RichTreeDecorator.CODEC);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModConfiguredFeatures.registerConfiguredFeatures(); //first

		ModItems.registerModItems(); //before blocks
		ModBlocks.registerModBlocks();

		ModFlammableBlocks.registerFlammableBlocks();
		ModStrippableBlocks.registerStrippables();

		ModWorldGen.generateModWorldGen(); //last

		LOGGER.info("Hello Fabric world!");
	}
}
