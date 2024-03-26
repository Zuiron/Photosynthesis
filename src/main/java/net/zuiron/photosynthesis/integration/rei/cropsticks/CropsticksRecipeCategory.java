package net.zuiron.photosynthesis.integration.rei.cropsticks;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.integration.rei.PhotosynthesisREI;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class CropsticksRecipeCategory implements DisplayCategory<CropsticksRecipeDisplay> {
    private static final Identifier GUI_TEXTURE = new Identifier(Photosynthesis.MOD_ID, "textures/gui/cropsticks_gui_rei.png");

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.CROPSTICKS);
    }

    @Override
    public Text getTitle() {
        return Text.literal("Crop Mutation");
    }

    @Override
    public CategoryIdentifier<? extends CropsticksRecipeDisplay> getCategoryIdentifier() {
        return PhotosynthesisREI.CROPSTICKS;
    }

    @Override
    public List<Widget> setupDisplay(CropsticksRecipeDisplay display, Rectangle bounds) {
        Point origin = bounds.getLocation();
        final List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createRecipeBase(bounds));
        Rectangle bgBounds = PhotosynthesisREI.centeredIntoRecipeBase(origin, 116, 64);
        widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, bgBounds, 0, 0));

        List<EntryIngredient> ingredientEntries = display.getIngredientEntries();
        if (ingredientEntries != null) {
            //seed1
            /*widgets.add(Widgets.createSlot(new Point(bgBounds.x + 29, bgBounds.y + 6))
                    .entries(ingredientEntries.get(0)).markInput().disableBackground());*/
            //seed2
            /*widgets.add(Widgets.createSlot(new Point(bgBounds.x + 75, bgBounds.y + 6))
                    .entries(ingredientEntries.get(1)).markInput().disableBackground());*/
            //farmland
            /*widgets.add(Widgets.createSlot(new Point(bgBounds.x + 52, bgBounds.y + 25))
                    .entries(ingredientEntries.get(2)).markInput().disableBackground());*/
            //below farmland
            /*widgets.add(Widgets.createSlot(new Point(bgBounds.x + 52, bgBounds.y + 44))
                    .entries(ingredientEntries.get(3)).markInput().disableBackground());*/

            int[] posX = {29, 75, 52, 52};
            int[] posY = { 6,  6, 25, 44};

            for (int i = 0; i < ingredientEntries.size(); i++) {
                widgets.add(Widgets.createSlot(new Point(bgBounds.x + posX[i], bgBounds.y + posY[i]))
                        .entries(ingredientEntries.get(i)).markInput().disableBackground());
            }
        }

        //OUTPUT
        widgets.add(Widgets.createSlot(new Point(bgBounds.x + 52, bgBounds.y + 4))
                .entries(display.getContainerOutput()).markOutput().disableBackground());


        int cookTime = display.getCookTime();
        int cookTimeSeconds = cookTime / 20;
        float chance = display.getChance();

        Arrow cookArrow = Widgets.createArrow(new Point(bgBounds.x + 100, bgBounds.y + 14))
                .animationDurationTicks(cookTime);
        widgets.add(cookArrow);
        widgets.add(Widgets.createLabel(new Point(
                                cookArrow.getBounds().x + cookArrow.getBounds().width / 2, cookArrow.getBounds().y - 8),
                        Text.literal(cookTimeSeconds + " s"))
                .noShadow().centered().tooltip(Text.literal("Seconds ("+cookTime+" t)"))
                .color(Formatting.DARK_GRAY.getColorValue(), Formatting.GRAY.getColorValue()));

        //chance display
        widgets.add(Widgets.createLabel(new Point(
                                bgBounds.x + 73, bgBounds.y + 28),
                        Text.literal(chance + " %"))
                .noShadow().leftAligned().tooltip(Text.literal("Chance of mutation"))
                .color(Formatting.DARK_GRAY.getColorValue(), Formatting.GRAY.getColorValue()));

        return widgets;
    }
}
