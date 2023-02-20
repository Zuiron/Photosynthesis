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

    public static ScreenHandlerType<LatexExtractorScreenHandler> LATEX_EXTRACTOR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(LatexExtractorScreenHandler::new);

    public static void registerAllScreenHandlers() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "cutting_board"),
                CUTTING_BOARD_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(Photosynthesis.MOD_ID, "latex_extractor"),
                LATEX_EXTRACTOR_SCREEN_HANDLER);
    }
}
