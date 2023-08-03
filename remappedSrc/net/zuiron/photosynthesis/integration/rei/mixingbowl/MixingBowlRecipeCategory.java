package net.zuiron.photosynthesis.integration.rei.mixingbowl;

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
import net.minecraft.util.collection.DefaultedList;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.integration.rei.PhotosynthesisREI;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class MixingBowlRecipeCategory implements DisplayCategory<MixingBowlRecipeDisplay> {
    private static final Identifier GUI_TEXTURE = new Identifier(Photosynthesis.MOD_ID, "textures/gui/mixingbowl_gui_rei.png");

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.MIXING_BOWL);
    }

    @Override
    public Text getTitle() {
        //return Photosynthesis.i18n("rei.cooking");
        return Text.literal("Mixing Bowl");
    }

    @Override
    public CategoryIdentifier<? extends MixingBowlRecipeDisplay> getCategoryIdentifier() {
        return PhotosynthesisREI.MIXINGBOWL;
    }

    @Override
    public List<Widget> setupDisplay(MixingBowlRecipeDisplay display, Rectangle bounds) {
        Point origin = bounds.getLocation();
        final List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createRecipeBase(bounds));
        Rectangle bgBounds = PhotosynthesisREI.centeredIntoRecipeBase(origin, 176, 67);
        widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, bgBounds, 0, 0));

        List<EntryIngredient> ingredientEntries = display.getIngredientEntries();
        DefaultedList counts = display.getCounts();

        //INPUTS
        if (ingredientEntries != null) {
            int[] posX = {6, 26, 44, 8, 26, 44, 8, 26, 44};
            int[] posY = {7, 9, 9, 27, 27, 27, 45, 45, 45};

            for (int i = 0; i < ingredientEntries.size(); i++) {
                //INPUT ITEMS TODO foreach Item item = ((ItemStack) ingredientEntries.get(i) - might be multiple? if tags.
                Item item = ((ItemStack) ingredientEntries.get(i).get(0).getValue()).getItem();
                widgets.add(Widgets.createSlot(new Point(bgBounds.x + posX[i], bgBounds.y + posY[i])).markInput().entries(List.of(EntryStacks.of(new ItemStack(item, (Integer) counts.get(i))))).disableBackground());
            }
        }



        //OUTPUT
        widgets.add(Widgets.createSlot(new Point(bgBounds.x + 116, bgBounds.y + 9))
                .entries(display.getContainerOutput()).markOutput().disableBackground());



        int cookTime = display.getCookTime();
        int cookTimeSeconds = cookTime / 20;

        Arrow cookArrow = Widgets.createArrow(new Point(bgBounds.x + 77, bgBounds.y + 36))
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
