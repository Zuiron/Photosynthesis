package net.zuiron.photosynthesis.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Item.class)
public abstract class ModItemAnimalDataTooltipMixin {
    @Inject(method = "appendTooltip", at = @At("HEAD"))
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        if(stack.isOf(Items.PIG_SPAWN_EGG)) {
            tooltip.add(Text.literal("Requires: Water, Food, Straw (Optional)"));
            tooltip.add(Text.literal("Feed: Wheat, Barley, Corn, Soybean, Canola, Potato, Sugarbeet."));
        }
        else if(stack.isOf(Items.CHICKEN_SPAWN_EGG)) {
            tooltip.add(Text.literal("Requires: Water, Food, Straw (Optional)"));
            tooltip.add(Text.literal("Feed: Wheat, Barley."));
        }
        else if(stack.isOf(Items.GOAT_SPAWN_EGG)) {
            tooltip.add(Text.literal("Requires: Water, Grass, Food."));
            tooltip.add(Text.literal("Feed: Saplings, Leaves."));
        }
        else if(stack.isOf(Items.COW_SPAWN_EGG)) {
            tooltip.add(Text.literal("Requires: Water, Grass, Hay. Food/TMR & Straw (Optional)"));
            tooltip.add(Text.literal("Feed: TMR - Total Mixed Ration. (Optional)"));
        }
        else if(stack.isOf(Items.SHEEP_SPAWN_EGG)) {
            tooltip.add(Text.literal("Requires: Water, Grass."));
        }
        else if(stack.isOf(Items.HORSE_SPAWN_EGG)) {
            tooltip.add(Text.literal("Requires: Water, Hay, Food, Straw (Optional)"));
            tooltip.add(Text.literal("Feed: Oat."));
        }
    }
}
