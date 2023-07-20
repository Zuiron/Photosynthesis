package net.zuiron.photosynthesis.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;

public class ModScreenHandlers {
    public static ScreenHandlerType<CuttingBoardScreenHandler> CUTTING_BOARD_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(CuttingBoardScreenHandler::new);

    public static ScreenHandlerType<MortarScreenHandler> MORTAR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(MortarScreenHandler::new);

    public static ScreenHandlerType<LatexExtractorScreenHandler> LATEX_EXTRACTOR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(LatexExtractorScreenHandler::new);

    public static ScreenHandlerType<MapleExtractorScreenHandler> MAPLE_EXTRACTOR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(MapleExtractorScreenHandler::new);

    public static ScreenHandlerType<SkilletScreenHandler> SKILLET_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(SkilletScreenHandler::new);

    public static ScreenHandlerType<MixingBowlScreenHandler> MIXINGBOWL_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(MixingBowlScreenHandler::new);

    public static ScreenHandlerType<CookingPotScreenHandler> COOKINGPOT_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(CookingPotScreenHandler::new);

    public static ScreenHandlerType<KegScreenHandler> KEG_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(KegScreenHandler::new);

    public static ScreenHandlerType<FluidPressScreenHandler> FLUID_PRESS_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(FluidPressScreenHandler::new);

    public static ScreenHandlerType<MilkSeperatorScreenHandler> MILKSEPERATOR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(MilkSeperatorScreenHandler::new);

    public static ScreenHandlerType<PlateScreenHandler> PLATE_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(PlateScreenHandler::new);

    public static void registerAllScreenHandlers() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "cutting_board"),
                CUTTING_BOARD_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "mortar"),
                MORTAR_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "latex_extractor"),
                LATEX_EXTRACTOR_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "maple_extractor"),
                MAPLE_EXTRACTOR_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "skillet"),
                SKILLET_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "mixingbowl"),
                MIXINGBOWL_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "cookingpot"),
                COOKINGPOT_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "keg"),
                KEG_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "fluid_press"),
                FLUID_PRESS_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "milkseperator"),
                MILKSEPERATOR_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "plate"),
                PLATE_SCREEN_HANDLER);
    }
}
