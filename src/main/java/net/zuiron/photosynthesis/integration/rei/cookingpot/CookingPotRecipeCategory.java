package net.zuiron.photosynthesis.integration.rei.cookingpot;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.*;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.integration.rei.PhotosynthesisREI;
import net.zuiron.photosynthesis.integration.rei.skillet.SkilletRecipeDisplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class CookingPotRecipeCategory implements DisplayCategory<CookingPotRecipeDisplay> {
    private static final Identifier GUI_TEXTURE = new Identifier(Photosynthesis.MOD_ID, "textures/gui/cookingpot_gui_rei.png");

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.COOKINGPOT);
    }

    @Override
    public Text getTitle() {
        //return Photosynthesis.i18n("rei.cooking");
        return Text.literal("Cooking Pot");
    }

    @Override
    public CategoryIdentifier<? extends CookingPotRecipeDisplay> getCategoryIdentifier() {
        return PhotosynthesisREI.COOKINGPOT;
    }

    @Override
    public List<Widget> setupDisplay(CookingPotRecipeDisplay display, Rectangle bounds) {
        Point origin = bounds.getLocation();
        final List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createRecipeBase(bounds));
        Rectangle bgBounds = PhotosynthesisREI.centeredIntoRecipeBase(origin, 125, 63);
        widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, bgBounds, 29, 3));


        List<EntryIngredient> ingredientEntries = display.getIngredientEntries();
        DefaultedList counts = display.getCounts();

        if (ingredientEntries != null) {
            int[] posX = {96, 5, 23, 41, 5, 23, 41};
            int[] posY = {15, 24, 24, 24, 42, 42, 42};

            for (int i = 0; i < ingredientEntries.size(); i++) {

                /*widgets.add(Widgets.createSlot(new Point(bgBounds.x + posX[i], bgBounds.y + posY[i]))
                        .entries(ingredientEntries.get(i)).markInput().disableBackground());*/

                /*widgets.add(Widgets.createSlot(new Point(bgBounds.x + posX[i], bgBounds.y + posY[i]))
                        .entry(ingredientEntries.get(i).get(0)));*/
                Slot slot = Widgets.createSlot(new Point(bgBounds.x + posX[i], bgBounds.y + posY[i]))
                        .entry(ingredientEntries.get(i).get(0));
                slot
                        .disableBackground()
                        .markInput();
                widgets.add(slot);


                //COUNT!!!!!!
                Label countLabel = Widgets.createLabel(new Point(slot.getBounds().x + 16, slot.getBounds().y + 8),
                        Text.literal(""+counts.get(i)));
                countLabel
                        .color(Formatting.WHITE.getColorValue())
                        .rightAligned();
                widgets.add(countLabel);

                //slot.setFocused(countLabel);
                countLabel.setFocused(slot);
            }
        }



        //OUTPUT
        widgets.add(Widgets.createSlot(new Point(bgBounds.x + 87, bgBounds.y + 42))
                .entries(display.getContainerOutput()).markOutput().disableBackground());



        int cookTime = display.getCookTime();
        int cookTimeSeconds = cookTime / 20;

        Arrow cookArrow = Widgets.createArrow(new Point(bgBounds.x + 60, bgBounds.y + 42))
                .animationDurationTicks(cookTime);
        widgets.add(cookArrow);
        widgets.add(Widgets.createLabel(new Point(
                                cookArrow.getBounds().x + cookArrow.getBounds().width / 2, cookArrow.getBounds().y - 8),
                        Text.literal(cookTimeSeconds + " s"))
                .noShadow().centered().tooltip(Text.literal("Seconds ("+cookTime+" t)"))
                .color(Formatting.DARK_GRAY.getColorValue(), Formatting.GRAY.getColorValue()));



        return widgets;
    }
}
