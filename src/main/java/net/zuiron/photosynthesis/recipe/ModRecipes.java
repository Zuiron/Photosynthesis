package net.zuiron.photosynthesis.recipe;

import net.minecraft.item.Item;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;

public class ModRecipes {
    public static void registerRecipes() {
        //Cutting Board
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Photosynthesis.MOD_ID, CuttingBoardRecipe.Serializer.ID),
                CuttingBoardRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Photosynthesis.MOD_ID, CuttingBoardRecipe.Type.ID),
                CuttingBoardRecipe.Type.INSTANCE);

        //Mortar
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Photosynthesis.MOD_ID, MortarRecipe.Serializer.ID),
                MortarRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Photosynthesis.MOD_ID, MortarRecipe.Type.ID),
                MortarRecipe.Type.INSTANCE);


        //SKILLET
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Photosynthesis.MOD_ID, SkilletRecipe.Serializer.ID),
                SkilletRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Photosynthesis.MOD_ID, SkilletRecipe.Type.ID),
                SkilletRecipe.Type.INSTANCE);

        //MIXING BOWL
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Photosynthesis.MOD_ID, MixingBowlRecipe.Serializer.ID),
                MixingBowlRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Photosynthesis.MOD_ID, MixingBowlRecipe.Type.ID),
                MixingBowlRecipe.Type.INSTANCE);


        //COOKING POT
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Photosynthesis.MOD_ID, CookingPotRecipe.Serializer.ID),
                CookingPotRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Photosynthesis.MOD_ID, CookingPotRecipe.Type.ID),
                CookingPotRecipe.Type.INSTANCE);

        //KEG
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Photosynthesis.MOD_ID, KegRecipe.Serializer.ID),
                KegRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Photosynthesis.MOD_ID, KegRecipe.Type.ID),
                KegRecipe.Type.INSTANCE);
    }
}
