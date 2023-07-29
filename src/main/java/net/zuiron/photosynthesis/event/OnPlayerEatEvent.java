package net.zuiron.photosynthesis.event;

import net.minecraft.text.Text;

public class OnPlayerEatEvent {
    public static void registerOnPlayerEatEvents() {
        ModOnPlayerEatEvent();
        ModOnPlayerEatEventThirstHandler();
    }

    public static void ModOnPlayerEatEventThirstHandler() {
        PlayerEatEvent.EVENT.register((world, player, stack) -> {
            if(!world.isClient) {
                player.sendMessage(Text.of("You just ate /2: " + stack.getItem().getName().getString()), false);
            }
        });
    }

    public static void ModOnPlayerEatEvent() {
        PlayerEatEvent.EVENT.register((world, player, stack) -> {
            if(!world.isClient) {
                player.sendMessage(Text.of("You just ate: " + stack.getItem().getName().getString()), false);
            }
        });
    }
}
