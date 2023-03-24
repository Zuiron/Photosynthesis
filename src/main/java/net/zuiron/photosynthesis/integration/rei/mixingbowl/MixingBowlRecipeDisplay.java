package net.zuiron.photosynthesis.integration.rei.mixingbowl;

import com.google.common.collect.ImmutableList;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.collection.DefaultedList;
import net.zuiron.photosynthesis.integration.rei.PhotosynthesisREI;
import net.zuiron.photosynthesis.recipe.MixingBowlRecipe;
import net.zuiron.photosynthesis.recipe.SkilletRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Environment(EnvType.CLIENT)
public class MixingBowlRecipeDisplay extends BasicDisplay {
    private final EntryIngredient containerOutput;
    private final int cookTime;
    private final DefaultedList counts;

    public MixingBowlRecipeDisplay(MixingBowlRecipe recipe) {
        super(EntryIngredients.ofIngredients(recipe.getIngredients()), Collections.singletonList(EntryIngredients.of(recipe.getOutput())),
                Optional.ofNullable(recipe.getId()));
        containerOutput = EntryIngredients.of(recipe.getOutput());
        cookTime = recipe.getCookTime();
        this.counts = recipe.getCounts();
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return PhotosynthesisREI.MIXINGBOWL;
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

    public DefaultedList getCounts() {
        return counts;
    }
}
