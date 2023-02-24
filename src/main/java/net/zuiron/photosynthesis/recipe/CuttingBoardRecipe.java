package net.zuiron.photosynthesis.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;

public class CuttingBoardRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    private final int cookingTime;

    public CuttingBoardRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems, int cookingTime) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.cookingTime = cookingTime;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) {
            return false;
        }

        //get0 is first ingredient in json, getstack1 is slot 1. same item in slot as recipe list = true.
        //return recipeItems.get(0).test(inventory.getStack(1)) && recipeItems.get(1).test(inventory.getStack(0));

        //return recipeItems.get(0).test(inventory.getStack(1));

        //SLOT 0 = tool
        //SLOT 1 = input
        //SLOT 2 = output ?

        //RECIPE 0 = tool
        //RECIPE 1 = input
        return recipeItems.get(0).test(inventory.getStack(0)) && recipeItems.get(1).test(inventory.getStack(1));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    public int getCookTime() {
        return cookingTime;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<CuttingBoardRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "cutting_board";
    }

    public static class Serializer implements RecipeSerializer<CuttingBoardRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "cutting_board";
        // this is the name given in the json file

        @Override
        public CuttingBoardRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
            int CookTime = JsonHelper.getInt(json, "cookingtime");
            Photosynthesis.LOGGER.info("read cookingtime of: " + CookTime + ", for: " + output.getItem().getName().getString());

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(2, Ingredient.EMPTY); //size: number of possible input ingredients.

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CuttingBoardRecipe(id, output, inputs, CookTime);
        }

        @Override
        public CuttingBoardRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new CuttingBoardRecipe(id, output, inputs, 0);
        }

        @Override
        public void write(PacketByteBuf buf, CuttingBoardRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
        }
    }
}
