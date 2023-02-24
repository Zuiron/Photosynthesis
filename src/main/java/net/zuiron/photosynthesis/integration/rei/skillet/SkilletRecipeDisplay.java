package net.zuiron.photosynthesis.integration.rei.skillet;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;

import com.google.common.collect.ImmutableList;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.zuiron.photosynthesis.integration.rei.PhotosynthesisREI;
import net.zuiron.photosynthesis.recipe.SkilletRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import java.util.List;
@Environment(EnvType.CLIENT)
public class SkilletRecipeDisplay extends BasicDisplay {
    private final EntryIngredient containerOutput;
    private final int cookTime;

    public SkilletRecipeDisplay(SkilletRecipe recipe) {
        super(EntryIngredients.ofIngredients(recipe.getIngredients()), Collections.singletonList(EntryIngredients.of(recipe.getOutput())),
                Optional.ofNullable(recipe.getId()));
        containerOutput = EntryIngredients.of(recipe.getOutput());
        cookTime = recipe.getCookTime();
        //cookTime = 200;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return PhotosynthesisREI.SKILLET;
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        List<EntryIngredient> inputEntryList = new ArrayList<>(super.getInputEntries());
        inputEntryList.add(getContainerOutput());

        return ImmutableList.copyOf(inputEntryList);
    }

    public List<EntryIngredient> getIngredientEntries() {
        return super.getInputEntries();
    }

    public EntryIngredient getContainerOutput() {
        return containerOutput;
    }

    public int getCookTime() {
        return cookTime;
    }
}
