package net.zuiron.photosynthesis.event;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.TypedActionResult;

public class ModUseItemCallback {
    public static void registerModUseItemCallback() {
        // Register the event handler for the UseItemCallback event
        UseItemCallback.EVENT.register((player, world, hand) -> {
            // Get the item the player is using
            Item item = player.getStackInHand(hand).getItem();

            // Check if the item is food (you can add more specific checks if needed)
            if (item.isFood()) {
                // Do something when the player eats the item
                // For example, you can send a message to the player
                // player.sendMessage(Text.of("You just TRIED to eat: " + item.getName().getString()), false);
            }

            // Return ActionResult.PASS to allow normal item usage to proceed
            return TypedActionResult.pass(item.getDefaultStack());
        });
    }
}
