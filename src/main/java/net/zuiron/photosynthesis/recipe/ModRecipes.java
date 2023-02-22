package net.zuiron.photosynthesis.recipe;

import net.minecraft.item.Item;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Photosynthesis.MOD_ID, CuttingBoardRecipe.Serializer.ID),
                CuttingBoardRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Photosynthesis.MOD_ID, CuttingBoardRecipe.Type.ID),
                CuttingBoardRecipe.Type.INSTANCE);

        //public static final Item RAW_SALT = registerItem......
        //SKILLET("skillet", SkilletRecipe.class, SkilletRecipe::new);

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Photosynthesis.MOD_ID, SkilletRecipe.Serializer.ID),
                SkilletRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Photosynthesis.MOD_ID, SkilletRecipe.Type.ID),
                SkilletRecipe.Type.INSTANCE);
    }
}
