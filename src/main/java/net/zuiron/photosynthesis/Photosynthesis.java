package net.zuiron.photosynthesis;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.item.ModItemGroup;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.mixin.TreeDecoratorTypeInvoker;
import net.zuiron.photosynthesis.util.ModFlammableBlocks;
import net.zuiron.photosynthesis.util.ModStrippableBlocks;
import net.zuiron.photosynthesis.world.gen.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Photosynthesis implements ModInitializer {
	public static final String MOD_ID = "photosynthesis";
	//1.19.3 branch

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final TreeDecoratorType<AppleTreeDecorator> APPLE_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:apple_tree_decorator", AppleTreeDecorator.CODEC);
	public static final TreeDecoratorType<BananaTreeDecorator> BANANA_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:banana_tree_decorator", BananaTreeDecorator.CODEC);
	public static final TreeDecoratorType<OrangeTreeDecorator> ORANGE_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:orange_tree_decorator", OrangeTreeDecorator.CODEC);
	public static final TreeDecoratorType<PearTreeDecorator> PEAR_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:pear_tree_decorator", PearTreeDecorator.CODEC);
	public static final TreeDecoratorType<CoconutTreeDecorator> COCONUT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:coconut_tree_decorator", CoconutTreeDecorator.CODEC);
	public static final TreeDecoratorType<AvocadoTreeDecorator> AVOCADO_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:avocado_tree_decorator", AvocadoTreeDecorator.CODEC);
	public static final TreeDecoratorType<CherryTreeDecorator> CHERRY_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:cherry_tree_decorator", CherryTreeDecorator.CODEC);
	public static final TreeDecoratorType<LemonTreeDecorator> LEMON_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:lemon_tree_decorator", LemonTreeDecorator.CODEC);
	public static final TreeDecoratorType<MangoTreeDecorator> MANGO_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:mango_tree_decorator", MangoTreeDecorator.CODEC);




	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroup.registerItemGroup();

		ModItems.registerModItems(); //before blocks
		ModBlocks.registerModBlocks();

		ModFlammableBlocks.registerFlammableBlocks();
		ModStrippableBlocks.registerStrippables();

		ModWorldGen.generateModWorldGen(); //last

		LOGGER.info("Hello Fabric world!");
	}
}
