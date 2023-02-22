package net.zuiron.photosynthesis.integration.rei.skillet;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Arrow;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.integration.rei.PhotosynthesisREI;
@Environment(EnvType.CLIENT)
public class SkilletRecipeCategory implements DisplayCategory<SkilletRecipeDisplay> {
    private static final Identifier GUI_TEXTURE = new Identifier(Photosynthesis.MOD_ID, "textures/gui/skillet_gui.png");

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.SKILLET);
    }

    @Override
    public Text getTitle() {
        //return Photosynthesis.i18n("rei.cooking");
        return Text.literal("Skillet");
    }

    @Override
    public CategoryIdentifier<? extends SkilletRecipeDisplay> getCategoryIdentifier() {
        return PhotosynthesisREI.SKILLET;
    }

    @Override
    public List<Widget> setupDisplay(SkilletRecipeDisplay display, Rectangle bounds) {
        Point origin = bounds.getLocation();
        final List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createRecipeBase(bounds));
        Rectangle bgBounds = PhotosynthesisREI.centeredIntoRecipeBase(origin, 116, 56);
        widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, bgBounds, 29, 16));

        //FOR SOME REASON, WE ARE MISSING INPUTS!

        List<EntryIngredient> ingredientEntries = display.getIngredientEntries();
        if (ingredientEntries != null) {
            /*for (int i = 0; i < ingredientEntries.size(); i++) {
                Point slotLoc = new Point(bgBounds.x + 1 + i % 3 * 18, bgBounds.y + 1 + (i / 3) * 18);
                widgets.add(Widgets.createSlot(slotLoc).entries(ingredientEntries.get(i)).markInput().disableBackground());
            }*/
            widgets.add(Widgets.createSlot(new Point(bgBounds.x + 33, bgBounds.y + 16))
                    .entries(ingredientEntries.get(0)).markInput().disableBackground());
            widgets.add(Widgets.createSlot(new Point(bgBounds.x + 33, bgBounds.y + 34))
                    .entries(ingredientEntries.get(1)).markInput().disableBackground());
        }

        //OUTPUT
        widgets.add(Widgets.createSlot(new Point(bgBounds.x + 69, bgBounds.y + 34))
                .entries(display.getContainerOutput()).markInput().disableBackground());

        /*
        widgets.add(Widgets.createSlot(new Point(bgBounds.x + 95, bgBounds.y + 12))
                .entries(display.getOutputEntries().get(0)).markOutput().disableBackground());
        widgets.add(Widgets.createSlot(new Point(bgBounds.x + 95, bgBounds.y + 39))
                .entries(display.getOutputEntries().get(0)).markOutput().disableBackground());
         */

/*
        widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE,
                new Rectangle(bgBounds.x + 18, bgBounds.y + 39, 17, 15), 176, 0));

        Arrow cookArrow = Widgets.createArrow(new Point(bgBounds.x + 61, bgBounds.y + 10))
                .animationDurationTicks(display.getCookTime());
        widgets.add(cookArrow);
        widgets.add(Widgets.createLabel(new Point(
                                cookArrow.getBounds().x + cookArrow.getBounds().width / 2, cookArrow.getBounds().y - 8),
                        Text.literal(display.getCookTime() + " t"))
                .noShadow().centered().tooltip(Text.literal("Ticks"))
                .color(Formatting.DARK_GRAY.getColorValue(), Formatting.GRAY.getColorValue()));

 */

        return widgets;
    }
}
