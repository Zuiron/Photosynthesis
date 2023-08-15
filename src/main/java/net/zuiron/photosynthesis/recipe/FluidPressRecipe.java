package net.zuiron.photosynthesis.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.util.FluidStack;

public class FluidPressRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final FluidStack output;
    //private final FluidStack fluidInput;
    private final DefaultedList<Ingredient> recipeItems;

    private final int cookingTime;

    private final DefaultedList counts;


    public FluidPressRecipe(Identifier id, FluidStack output, DefaultedList<Ingredient> recipeItems, int cookingTime, DefaultedList counts) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.cookingTime = cookingTime;
        this.counts = counts;
        //this.fluidInput = fluidInput;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) {
            return false;
        }
        //is this not used???
        return recipeItems.get(0).test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return null;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        //return new ItemStack(output.fluidVariant.getFluid().getBucketItem());
        if (output != null && output.fluidVariant != null && output.fluidVariant.getFluid() != null) {
            return new ItemStack(output.fluidVariant.getFluid().getBucketItem());
        } else {
            // Return a default ItemStack or handle the situation as appropriate for your context.
            return ItemStack.EMPTY; // Example: Returning an empty ItemStack.
        }
    }

    public ItemStack getOutputStack() {
        //return new ItemStack(output.fluidVariant.getFluid().getBucketItem());
        if (output != null && output.fluidVariant != null && output.fluidVariant.getFluid() != null) {
            return new ItemStack(output.fluidVariant.getFluid().getBucketItem());
        } else {
            // Return a default ItemStack or handle the situation as appropriate for your context.
            return ItemStack.EMPTY; // Example: Returning an empty ItemStack.
        }
    }

    public FluidStack getOutputFluid() {
        return output;
    }

    public int getCookTime() {
        return cookingTime;
    }

    /*public FluidStack getFluidInput() {
        return fluidInput;
    }*/

    public DefaultedList getCounts() { return counts; }

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

    public static class Type implements RecipeType<FluidPressRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "fluid_press";
    }

    public static class Serializer implements RecipeSerializer<FluidPressRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "fluid_press";
        // this is the name given in the json file

        @Override
        public FluidPressRecipe read(Identifier id, JsonObject json) {

            //FLUID output -- DONE
            JsonObject outputobj = JsonHelper.getObject(json, "output");
            int fluidamount = JsonHelper.getInt(outputobj, "amount", 81000);

            String fluidstring = JsonHelper.getString(outputobj, "fluid");
            Fluid fluid = (Fluid) Registries.FLUID.getOrEmpty(new Identifier(fluidstring)).orElseThrow(() -> {
                return new JsonSyntaxException("Unknown fluid '" + fluidstring + "'");
            });
            FluidStack fluidOutput = new FluidStack(FluidVariant.of(fluid), fluidamount);
            //Photosynthesis.LOGGER.info("output fluid: " + fluidOutput.fluidVariant.getFluid() + ", amount: " + fluidOutput.amount);
            //----------------------------------------------------------------------------------------------------------




            //ITEM input -- DONE
            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1, Ingredient.EMPTY);
            DefaultedList<Integer> counts = DefaultedList.ofSize(1, 0);

            for (int i = 0; i < ingredients.size(); i++) {
                if (i >= inputs.size()) {
                    inputs.add(Ingredient.EMPTY);
                    counts.add(0);
                }
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
                counts.set(i, JsonHelper.getInt(ingredients.get(i).getAsJsonObject(),"count"));
                //Photosynthesis.LOGGER.info("Ingredient: " + inputs.get(i).toJson() + ", count: " + counts.get(i));
            }
            //----------------------------------------------------------------------------------------------------------


            //FLUID input -- DONE
            /*JsonObject inputobj = JsonHelper.getObject(json, "fluidinput");
            int inputfluidamount = JsonHelper.getInt(inputobj, "amount", 81000);

            String inputfluidstring = JsonHelper.getString(inputobj, "fluid");
            Fluid inputfluid = (Fluid) Registries.FLUID.getOrEmpty(new Identifier(inputfluidstring)).orElseThrow(() -> {
                return new JsonSyntaxException("Unknown fluid '" + inputfluidstring + "'");
            });
            FluidStack fluidInput = new FluidStack(FluidVariant.of(inputfluid), inputfluidamount);
            //Photosynthesis.LOGGER.info("input fluid: " + fluidInput.fluidVariant.getFluid() + ", amount: " + fluidInput.amount);
            */
            //----------------------------------------------------------------------------------------------------------






            /*
            until its done.
             */
            //DefaultedList<Ingredient> inputsS = DefaultedList.ofSize(5, Ingredient.EMPTY);
            //ItemStack output = new ItemStack(Items.STICK);

            int CookTime = JsonHelper.getInt(json, "cookingtime");
            return new FluidPressRecipe(id, fluidOutput, inputs, CookTime, counts);
        }

        @Override
        public FluidPressRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }
            FluidVariant fluidOutput = FluidVariant.fromPacket(buf);
            FluidStack fluidOutputStack = new FluidStack(FluidVariant.of(fluidOutput.getFluid()), FluidConstants.BUCKET);

            int cookingTime = buf.readInt();

            return new FluidPressRecipe(id, fluidOutputStack, inputs, cookingTime, DefaultedList.ofSize(7, 1));
        }

        @Override
        public void write(PacketByteBuf buf, FluidPressRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            recipe.getOutputFluid().getFluidVariant().toPacket(buf);

            buf.writeInt(recipe.getCookTime());
        }
    }
}
