package net.zuiron.photosynthesis.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface PlayerEatEvent {
    Event<PlayerEatEvent> EVENT = EventFactory.createArrayBacked(PlayerEatEvent.class, (listeners) -> (world, player, stack) -> {
        for (PlayerEatEvent listener : listeners) {
            listener.onPlayerEat(world, player, stack);
        }
    });

    void onPlayerEat(World world, PlayerEntity player, ItemStack stack);
}
