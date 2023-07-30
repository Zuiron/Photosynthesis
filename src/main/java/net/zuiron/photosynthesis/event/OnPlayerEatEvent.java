package net.zuiron.photosynthesis.event;

import net.minecraft.text.Text;
import net.zuiron.photosynthesis.api.ThirstDataAPI;
import net.zuiron.photosynthesis.util.IEntityDataSaver;
import net.zuiron.photosynthesis.util.ThirstData;

public class OnPlayerEatEvent {
    public static void registerOnPlayerEatEvents() {
        ModOnPlayerEatEvent();
        ModOnPlayerEatEventThirstHandler();
    }

    public static void ModOnPlayerEatEventThirstHandler() {
        PlayerEatEvent.EVENT.register((world, player, stack) -> {
            if(!world.isClient) {
                ThirstDataAPI thirstItemData = ThirstDataAPI.getThirstDataFor(stack.getItem().getTranslationKey());
                boolean isThirstEnabled = ThirstDataAPI.isThirstEnabled();
                if(thirstItemData != null && isThirstEnabled) {
                    int thirst = thirstItemData.getThirstData();
                    int thirstSat = thirstItemData.getThirstSatData();

                    int remThirst = thirstItemData.getRemThirstData();
                    int remThirstSat = thirstItemData.getRemThirstSatData();

                    //ADD thirst.
                    ThirstData.addThirst((IEntityDataSaver)player, thirst);
                    ThirstData.addThirstSaturation((IEntityDataSaver)player, thirstSat);

                    //REMOVE thirst.
                    ThirstData.removeThirst((IEntityDataSaver)player, remThirst);
                    ThirstData.removeThirstSaturation((IEntityDataSaver)player, remThirstSat);

                    player.sendMessage(Text.of("We have thirst data for this: thirst:"+thirst +", sat:"+thirstSat + " - " + stack.getItem().getTranslationKey()), false);
                }
                else if (thirstItemData == null && isThirstEnabled) {
                    //NO DATA ON ITEM. DO SOMETHING OR NOT?
                    //DEFAULT remove thirst, unknown item. remove 2 thirst bars.
                    /*
                    ThirstData.removeThirst((IEntityDataSaver)player, 1);
                    ThirstData.removeThirstSaturation((IEntityDataSaver)player, 120);
                    */
                }
            }
        });
    }

    public static void ModOnPlayerEatEvent() {
        PlayerEatEvent.EVENT.register((world, player, stack) -> {
            if(!world.isClient) {
                player.sendMessage(Text.of("You just ate: " + stack.getItem().getName().getString()+" "+stack.getItem().getTranslationKey()), false);
            }
        });
    }
}
