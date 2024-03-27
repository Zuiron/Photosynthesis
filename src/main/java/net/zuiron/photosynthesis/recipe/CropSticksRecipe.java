package net.zuiron.photosynthesis.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class CropSticksRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    private final int cookingTime;

    private final float chance;


    public CropSticksRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems, int cookingTime, float chance) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.cookingTime = cookingTime;
        this.chance = chance;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) {
            return false;
        }

        return recipeItems.get(0).test(inventory.getStack(0))
                && recipeItems.get(1).test(inventory.getStack(1))
                && recipeItems.get(2).test(inventory.getStack(2))
                && recipeItems.get(3).test(inventory.getStack(3));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output.copy();
    }

    public ItemStack getOutputStack() {
        return output.copy();
    }

    public int getCookTime() {
        return cookingTime;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return recipeItems;
    } //IMPORTANT FOR REI

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

    public float getChancePercentage() {
        return chance;
    }

    public static class Type implements RecipeType<CropSticksRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "cropsticks";
    }

    public static class Serializer implements RecipeSerializer<CropSticksRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "cropsticks";
        // this is the name given in the json file

        @Override
        public CropSticksRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

            float chance = 100.0f;

            int CookTime = JsonHelper.getInt(json, "cookingtime");
            if(JsonHelper.hasElement(json, "chance")) {
                chance = JsonHelper.getFloat(json, "chance");
            }

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(7, Ingredient.EMPTY); //size: max number of possible input ingredients.

            for (int i = 0; i < ingredients.size(); i++) {
                if (i >= inputs.size()) {
                    inputs.add(Ingredient.EMPTY);
                }
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CropSticksRecipe(id, output, inputs, CookTime, chance);
        }

        @Override
        public CropSticksRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();

            int cookingTime = buf.readInt();
            float chance = buf.readFloat();

            return new CropSticksRecipe(id, output, inputs, cookingTime, chance);
        }

        @Override
        public void write(PacketByteBuf buf, CropSticksRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutputStack());

            buf.writeInt(recipe.getCookTime());
            buf.writeFloat(recipe.getChancePercentage());
        }
    }
}
