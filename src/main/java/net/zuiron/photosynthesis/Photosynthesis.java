package net.zuiron.photosynthesis;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.block.entity.ModBlockEntities;
import net.zuiron.photosynthesis.config.ModConfig;
import net.zuiron.photosynthesis.event.PlayerTickHandler;
import net.zuiron.photosynthesis.fluid.ModFluids;
import net.zuiron.photosynthesis.item.ModItemGroup;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.mixin.TreeDecoratorTypeInvoker;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.recipe.ModRecipes;
import net.zuiron.photosynthesis.screen.ModScreenHandlers;
import net.zuiron.photosynthesis.util.ModFlammableBlocks;
import net.zuiron.photosynthesis.util.ModStrippableBlocks;
import net.zuiron.photosynthesis.world.gen.*;
import net.zuiron.photosynthesis.world.gen.treedecorators.*;
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
	public static final TreeDecoratorType<OliveTreeDecorator> OLIVE_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:olive_tree_decorator", OliveTreeDecorator.CODEC);







	public static final TreeDecoratorType<CandlenutTreeDecorator> CANDLENUT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:candlenut_tree_decorator", CandlenutTreeDecorator.CODEC);

	public static final TreeDecoratorType<ChestnutTreeDecorator> CHESTNUT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:chestnut_tree_decorator", ChestnutTreeDecorator.CODEC);

	public static final TreeDecoratorType<NutmegTreeDecorator> NUTMEG_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:nutmeg_tree_decorator", NutmegTreeDecorator.CODEC);

	public static final TreeDecoratorType<PeachTreeDecorator> PEACH_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:peach_tree_decorator", PeachTreeDecorator.CODEC);

	public static final TreeDecoratorType<PlumTreeDecorator> PLUM_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:plum_tree_decorator", PlumTreeDecorator.CODEC);

	public static final TreeDecoratorType<WalnutTreeDecorator> WALNUT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:walnut_tree_decorator", WalnutTreeDecorator.CODEC);

	public static final TreeDecoratorType<HazelnutTreeDecorator> HAZELNUT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:hazelnut_tree_decorator", HazelnutTreeDecorator.CODEC);

	public static final TreeDecoratorType<PawpawTreeDecorator> PAWPAW_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:pawpaw_tree_decorator", PawpawTreeDecorator.CODEC);

	public static final TreeDecoratorType<SoursopTreeDecorator> SOURSOP_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:soursop_tree_decorator", SoursopTreeDecorator.CODEC);

	public static final TreeDecoratorType<AlmondTreeDecorator> ALMOND_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:almond_tree_decorator", AlmondTreeDecorator.CODEC);

	public static final TreeDecoratorType<ApricotTreeDecorator> APRICOT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:apricot_tree_decorator", ApricotTreeDecorator.CODEC);

	public static final TreeDecoratorType<CashewTreeDecorator> CASHEW_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:cashew_tree_decorator", CashewTreeDecorator.CODEC);

	public static final TreeDecoratorType<DateTreeDecorator> DATE_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:date_tree_decorator", DateTreeDecorator.CODEC);

	public static final TreeDecoratorType<DragonfruitTreeDecorator> DRAGONFRUIT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:dragonfruit_tree_decorator", DragonfruitTreeDecorator.CODEC);

	public static final TreeDecoratorType<DurianTreeDecorator> DURIAN_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:durian_tree_decorator", DurianTreeDecorator.CODEC);

	public static final TreeDecoratorType<FigTreeDecorator> FIG_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:fig_tree_decorator", FigTreeDecorator.CODEC);

	public static final TreeDecoratorType<GrapefruitTreeDecorator> GRAPEFRUIT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:grapefruit_tree_decorator", GrapefruitTreeDecorator.CODEC);

	public static final TreeDecoratorType<LimeTreeDecorator> LIME_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:lime_tree_decorator", LimeTreeDecorator.CODEC);

	public static final TreeDecoratorType<PapayaTreeDecorator> PAPAYA_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:papaya_tree_decorator", PapayaTreeDecorator.CODEC);

	public static final TreeDecoratorType<PecanTreeDecorator> PECAN_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:pecan_tree_decorator", PecanTreeDecorator.CODEC);

	public static final TreeDecoratorType<PersimmonTreeDecorator> PERSIMMON_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:persimmon_tree_decorator", PersimmonTreeDecorator.CODEC);

	public static final TreeDecoratorType<PistachioTreeDecorator> PISTACHIO_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:pistachio_tree_decorator", PistachioTreeDecorator.CODEC);

	public static final TreeDecoratorType<PomegranateTreeDecorator> POMEGRANATE_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:pomegranate_tree_decorator", PomegranateTreeDecorator.CODEC);

	public static final TreeDecoratorType<StarfruitTreeDecorator> STARFRUIT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:starfruit_tree_decorator", StarfruitTreeDecorator.CODEC);

	public static final TreeDecoratorType<BreadfruitTreeDecorator> BREADFRUIT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:breadfruit_tree_decorator", BreadfruitTreeDecorator.CODEC);

	public static final TreeDecoratorType<GuavaTreeDecorator> GUAVA_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:guava_tree_decorator", GuavaTreeDecorator.CODEC);

	public static final TreeDecoratorType<JackfruitTreeDecorator> JACKFRUIT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:jackfruit_tree_decorator", JackfruitTreeDecorator.CODEC);

	public static final TreeDecoratorType<LycheeTreeDecorator> LYCHEE_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:lychee_tree_decorator", LycheeTreeDecorator.CODEC);

	public static final TreeDecoratorType<PassionfruitTreeDecorator> PASSIONFRUIT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:passionfruit_tree_decorator", PassionfruitTreeDecorator.CODEC);

	public static final TreeDecoratorType<RambutanTreeDecorator> RAMBUTAN_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:rambutan_tree_decorator", RambutanTreeDecorator.CODEC);

	public static final TreeDecoratorType<TamarindTreeDecorator> TAMARIND_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:tamarind_tree_decorator", TamarindTreeDecorator.CODEC);








	public static final TreeDecoratorType<PeppercornTreeDecorator> PEPPERCORN_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:peppercorn_tree_decorator", PeppercornTreeDecorator.CODEC);

	public static final TreeDecoratorType<VanillabeanTreeDecorator> VANILLABEAN_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:vanillabean_tree_decorator", VanillabeanTreeDecorator.CODEC);

	public static final TreeDecoratorType<PinenutTreeDecorator> PINENUT_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:pinenut_tree_decorator", PinenutTreeDecorator.CODEC);

	public static final TreeDecoratorType<GooseberryTreeDecorator> GOOSEBERRY_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:gooseberry_tree_decorator", GooseberryTreeDecorator.CODEC);

	public static final TreeDecoratorType<GrapeTreeDecorator> GRAPE_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:grape_tree_decorator", GrapeTreeDecorator.CODEC);


	public static final TreeDecoratorType<KiwiTreeDecorator> KIWI_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("photosynthesis:kiwi_tree_decorator", KiwiTreeDecorator.CODEC);



	public static final Identifier SKILLET_SOUND_ID = new Identifier("photosynthesis:skillet");
	public static SoundEvent SKILLET_SOUND_EVENT = SoundEvent.of(SKILLET_SOUND_ID);

	public static final Identifier COOKINGPOT_SOUND_ID = new Identifier("photosynthesis:cookingpot");
	public static SoundEvent COOKINGPOT_SOUND_EVENT = SoundEvent.of(COOKINGPOT_SOUND_ID);

	public static final Identifier KEG_SOUND_ID = new Identifier("photosynthesis:keg");
	public static SoundEvent KEG_SOUND_EVENT = SoundEvent.of(KEG_SOUND_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);

		Registry.register(Registries.SOUND_EVENT, Photosynthesis.SKILLET_SOUND_ID, SKILLET_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Photosynthesis.COOKINGPOT_SOUND_ID, COOKINGPOT_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Photosynthesis.KEG_SOUND_ID, KEG_SOUND_EVENT);

		ModItemGroup.registerItemGroup();

		ModItems.registerModItems(); //before blocks
		ModBlocks.registerModBlocks();

		ModFlammableBlocks.registerFlammableBlocks();
		ModStrippableBlocks.registerStrippables();

		ModFluids.register();
		ModMessages.registerC2SPackets();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerAllScreenHandlers();

		ModRecipes.registerRecipes();

		ModWorldGen.generateModWorldGen(); //last

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());

		LOGGER.info("Hello Fabric world!");
	}
}
