package net.zuiron.photosynthesis.event;

import net.minecraft.text.Text;
import net.zuiron.photosynthesis.api.CropData;
import net.zuiron.photosynthesis.api.ThirstDataAPI;

public class OnPlayerEatEvent {
    public static void registerOnPlayerEatEvents() {
        ModOnPlayerEatEvent();
        ModOnPlayerEatEventThirstHandler();
    }

    public static void ModOnPlayerEatEventThirstHandler() {
        PlayerEatEvent.EVENT.register((world, player, stack) -> {
            if(!world.isClient) {
                ThirstDataAPI thirstDataAPI = ThirstDataAPI.getThirstDataFor(stack.getItem().getTranslationKey());
                if(thirstDataAPI != null) {
                    int thirst = thirstDataAPI.getThirstData();
                    int thirstSat = thirstDataAPI.getThirstSatData();
                    player.sendMessage(Text.of("We have thirst data for this: thirst:"+thirst +", sat:"+thirstSat + " - " + stack.getItem().getTranslationKey()), false);
                }
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
