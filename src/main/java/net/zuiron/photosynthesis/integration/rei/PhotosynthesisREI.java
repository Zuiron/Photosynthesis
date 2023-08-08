package net.zuiron.photosynthesis.integration.rei;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.fluid.ModFluids;
import net.zuiron.photosynthesis.integration.rei.cookingpot.CookingPotRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.cookingpot.CookingPotRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.cutting_board.CuttingBoardRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.cutting_board.CuttingBoardRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.dryingnet.DryingNetRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.dryingnet.DryingNetRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.dryingrack.DryingRackRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.dryingrack.DryingRackRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.fluidpress.FluidPressRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.fluidpress.FluidPressRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.gravitypress.GravityPressRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.gravitypress.GravityPressRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.hayrack.HayRackRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.hayrack.HayRackRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.keg.KegRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.keg.KegRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.milkseparator.MilkSeparatorRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.milkseparator.MilkSeparatorRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.mixingbowl.MixingBowlRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.mixingbowl.MixingBowlRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.mortar.MortarRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.mortar.MortarRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.skillet.SkilletRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.skillet.SkilletRecipeDisplay;
import net.zuiron.photosynthesis.integration.rei.woodfiredoven.WoodFiredOvenRecipeCategory;
import net.zuiron.photosynthesis.integration.rei.woodfiredoven.WoodFiredOvenRecipeDisplay;
import net.zuiron.photosynthesis.recipe.*;
import net.zuiron.photosynthesis.screen.*;

@Environment(EnvType.CLIENT)
public class PhotosynthesisREI implements REIClientPlugin {

    public static final CategoryIdentifier<SkilletRecipeDisplay> SKILLET = CategoryIdentifier.of(Photosynthesis.MOD_ID, "skillet");
    public static final CategoryIdentifier<MixingBowlRecipeDisplay> MIXINGBOWL = CategoryIdentifier.of(Photosynthesis.MOD_ID, "mixingbowl");
    public static final CategoryIdentifier<CuttingBoardRecipeDisplay> CUTTINGBOARD = CategoryIdentifier.of(Photosynthesis.MOD_ID, "cuttingboard");
    public static final CategoryIdentifier<MortarRecipeDisplay> MORTAR = CategoryIdentifier.of(Photosynthesis.MOD_ID, "mortar");
    public static final CategoryIdentifier<GravityPressRecipeDisplay> GRAVITYPRESS = CategoryIdentifier.of(Photosynthesis.MOD_ID, "gravitypress");
    public static final CategoryIdentifier<CookingPotRecipeDisplay> COOKINGPOT = CategoryIdentifier.of(Photosynthesis.MOD_ID, "cookingpot");
    public static final CategoryIdentifier<KegRecipeDisplay> KEG = CategoryIdentifier.of(Photosynthesis.MOD_ID, "keg");
    public static final CategoryIdentifier<FluidPressRecipeDisplay> FLUIDPRESS = CategoryIdentifier.of(Photosynthesis.MOD_ID, "fluidpress");
    public static final CategoryIdentifier<MilkSeparatorRecipeDisplay> MILKSEPARATOR = CategoryIdentifier.of(Photosynthesis.MOD_ID, "milkseparator");
    public static final CategoryIdentifier<DryingNetRecipeDisplay> DRYINGNET = CategoryIdentifier.of(Photosynthesis.MOD_ID, "dryingnet");
    public static final CategoryIdentifier<DryingRackRecipeDisplay> DRYINGRACK = CategoryIdentifier.of(Photosynthesis.MOD_ID, "dryingrack");
    public static final CategoryIdentifier<HayRackRecipeDisplay> HAYRACK = CategoryIdentifier.of(Photosynthesis.MOD_ID, "hayrack");
    public static final CategoryIdentifier<WoodFiredOvenRecipeDisplay> WOOD_FIRED_OVEN = CategoryIdentifier.of(Photosynthesis.MOD_ID, "woodfiredoven");

    public static Rectangle centeredIntoRecipeBase(Point origin, int width, int height) {
        return centeredInto(new Rectangle(origin.x, origin.y, 150, 66), width, height);
    }

    public static Rectangle centeredInto(Rectangle origin, int width, int height) {
        return new Rectangle(origin.x + (origin.width - width) / 2, origin.y + (origin.height - height) / 2, width, height);
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(
                new SkilletRecipeCategory());
        registry.addWorkstations(SKILLET, EntryStacks.of(ModBlocks.SKILLET));

        registry.add(
                new MixingBowlRecipeCategory());
        registry.addWorkstations(MIXINGBOWL, EntryStacks.of(ModBlocks.MIXING_BOWL));

        registry.add(
                new CuttingBoardRecipeCategory());
        registry.addWorkstations(CUTTINGBOARD, EntryStacks.of(ModBlocks.CUTTINGBOARD));

        registry.add(
                new MortarRecipeCategory());
        registry.addWorkstations(MORTAR, EntryStacks.of(ModBlocks.MORTAR));

        registry.add(
                new GravityPressRecipeCategory());
        registry.addWorkstations(GRAVITYPRESS, EntryStacks.of(ModBlocks.GRAVITYPRESS));

        registry.add(
                new CookingPotRecipeCategory());
        registry.addWorkstations(COOKINGPOT, EntryStacks.of(ModBlocks.COOKINGPOT));

        registry.add(
                new KegRecipeCategory());
        registry.addWorkstations(KEG, EntryStacks.of(ModBlocks.KEG));

        registry.add(
                new FluidPressRecipeCategory());
        registry.addWorkstations(FLUIDPRESS, EntryStacks.of(ModBlocks.FLUID_PRESS));

        registry.add(
                new MilkSeparatorRecipeCategory());
        registry.addWorkstations(MILKSEPARATOR, EntryStacks.of(ModBlocks.MILKSEPERATOR));

        registry.add(
                new DryingNetRecipeCategory());
        registry.addWorkstations(DRYINGNET, EntryStacks.of(ModBlocks.DRYINGNET));

        registry.add(
                new DryingRackRecipeCategory());
        registry.addWorkstations(DRYINGRACK, EntryStacks.of(ModBlocks.DRYINGRACK));

        registry.add(
                new HayRackRecipeCategory());
        registry.addWorkstations(HAYRACK, EntryStacks.of(ModBlocks.HAYRACK));

        registry.add(
                new WoodFiredOvenRecipeCategory());
        registry.addWorkstations(WOOD_FIRED_OVEN, EntryStacks.of(ModBlocks.WOOD_FIRED_OVEN));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(SkilletRecipe.class, SkilletRecipe.Type.INSTANCE, SkilletRecipeDisplay::new);

        registry.registerRecipeFiller(MixingBowlRecipe.class, MixingBowlRecipe.Type.INSTANCE, MixingBowlRecipeDisplay::new);

        registry.registerRecipeFiller(CuttingBoardRecipe.class, CuttingBoardRecipe.Type.INSTANCE, CuttingBoardRecipeDisplay::new);

        registry.registerRecipeFiller(MortarRecipe.class, MortarRecipe.Type.INSTANCE, MortarRecipeDisplay::new);

        registry.registerRecipeFiller(GravityPressRecipe.class, GravityPressRecipe.Type.INSTANCE, GravityPressRecipeDisplay::new);

        registry.registerRecipeFiller(CookingPotRecipe.class, CookingPotRecipe.Type.INSTANCE, CookingPotRecipeDisplay::new);

        registry.registerRecipeFiller(KegRecipe.class, KegRecipe.Type.INSTANCE, KegRecipeDisplay::new);

        registry.registerRecipeFiller(FluidPressRecipe.class, FluidPressRecipe.Type.INSTANCE, FluidPressRecipeDisplay::new);

        registry.registerRecipeFiller(MilkSeperatorRecipe.class, MilkSeperatorRecipe.Type.INSTANCE, MilkSeparatorRecipeDisplay::new);

        registry.registerRecipeFiller(DryingNetRecipe.class, DryingNetRecipe.Type.INSTANCE, DryingNetRecipeDisplay::new);

        registry.registerRecipeFiller(DryingRackRecipe.class, DryingRackRecipe.Type.INSTANCE, DryingRackRecipeDisplay::new);

        registry.registerRecipeFiller(HayRackRecipe.class, HayRackRecipe.Type.INSTANCE, HayRackRecipeDisplay::new);

        registry.registerRecipeFiller(WoodFiredOvenRecipe.class, WoodFiredOvenRecipe.Type.INSTANCE, WoodFiredOvenRecipeDisplay::new);

        registerDescriptions(registry);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerContainerClickArea(new Rectangle(88, 44, 26, 17), SkilletScreen.class, SKILLET);

        registry.registerContainerClickArea(new Rectangle(77, 36, 22, 15), MixingBowlScreen.class, MIXINGBOWL);

        registry.registerContainerClickArea(new Rectangle(100, 27, 13, 26), CuttingBoardScreen.class, CUTTINGBOARD);

        registry.registerContainerClickArea(new Rectangle(100, 27, 13, 26), MortarScreen.class, MORTAR);

        registry.registerContainerClickArea(new Rectangle(100, 27, 13, 26), GravityPressScreen.class, GRAVITYPRESS);

        registry.registerContainerClickArea(new Rectangle(88, 44, 26, 18), CookingPotScreen.class, COOKINGPOT);

        registry.registerContainerClickArea(new Rectangle(76, 47, 22, 15), KegScreen.class, KEG);

        registry.registerContainerClickArea(new Rectangle(85, 31, 22, 15), FluidPressScreen.class, FLUIDPRESS);

        registry.registerContainerClickArea(new Rectangle(85, 31, 22, 15), MilkSeperatorScreen.class, MILKSEPARATOR);

        registry.registerContainerClickArea(new Rectangle(77, 37, 22, 15), DryingNetScreen.class, DRYINGNET);

        registry.registerContainerClickArea(new Rectangle(77, 37, 22, 15), DryingRackScreen.class, DRYINGRACK);

        registry.registerContainerClickArea(new Rectangle(77, 37, 22, 15), HayRackScreen.class, HAYRACK);

        registry.registerContainerClickArea(new Rectangle(90, 45, 22, 15), WoodFiredOvenScreen.class, WOOD_FIRED_OVEN);
    }

    private void registerDescriptions(DisplayRegistry registry) {

        /*DefaultInformationDisplay info = DefaultInformationDisplay.createFromEntry(EntryStacks.of(ModBlocks.MAPLE_EXTRACTOR), Text.literal("confused"));
        info.lines(Text.literal("Place on a maple tree (LOG), and it will produce Maple Sap!"));
        registry.add(info);*/

        addDescription(registry, EntryStacks.of(ModBlocks.MAPLE_EXTRACTOR), "Place on a maple tree (LOG), and it will produce Maple Sap." +
                "Also if Seasons is Enabled, Maple Sap will only be produced in the Spring Season.");
        addDescription(registry, EntryStacks.of(ModBlocks.LATEX_EXTRACTOR), "Place on a rubber tree (LOG), and it will produce Latex. " +
                "Make sure to strip the log ABOVE where you want to place the extractor!" +
                "Also if Seasons is Enabled, Latex will only be produced in the Summer Season.");

        addDescription(registry, EntryStacks.of(ModFluids.LATEX_BUCKET), "Use the Latex Extractor to get latex!");
        addDescription(registry, EntryStacks.of(ModFluids.MAPLE_BUCKET), "Use the Maple Extractor to get maple sap!");

        addDescription2(registry, EntryIngredients.of(ModFluids.STILL_LATEX.getDefaultState().getFluid(), 81000), "Use the Latex Extractor to get latex!");
        addDescription2(registry, EntryIngredients.of(ModFluids.STILL_MAPLE.getDefaultState().getFluid(), 81000), "Use the Maple Extractor to get maple sap!");
        //EntryIngredients.of(outputFluid.fluidVariant.getFluid(), outputFluid.amount)
    }

    private static void addDescription(DisplayRegistry registry, EntryStack entryStack, String message) {
        DefaultInformationDisplay info = DefaultInformationDisplay.createFromEntry(entryStack, Text.literal("confused"));
        info.lines(Text.literal(message));
        registry.add(info);
    }
    private static void addDescription2(DisplayRegistry registry, EntryIngredient entryStacks, String message) {
        DefaultInformationDisplay info = DefaultInformationDisplay.createFromEntries(entryStacks, Text.literal("confused"));
        info.lines(Text.literal(message));
        registry.add(info);
    }
}
