package net.zuiron.photosynthesis.event;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.util.ActionResult;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.config.ModConfig;
import net.zuiron.photosynthesis.networking.ModMessages;

public class ClientPlayConnectionJoin implements ClientPlayConnectionEvents.Join {
    @Override
    public void onPlayReady(ClientPlayNetworkHandler handler, PacketSender sender, MinecraftClient client) {
        //sync thirst
        ClientPlayNetworking.send(ModMessages.THIRST_REQ_SYNC_ID, PacketByteBufs.create());

        //when saving config, request server config IF world exists (single or multiplayer world exists)
        AutoConfig.getConfigHolder(ModConfig.class).registerSaveListener((manager, data) -> {
            if(client.world != null) {
                Photosynthesis.LOGGER.info("saved?");
                //sync config
                Photosynthesis.LOGGER.info("Sending config request to server...");
                ClientPlayNetworking.send(ModMessages.CONFIG_REQ_SYNC_ID, PacketByteBufs.create());
            }
            return ActionResult.SUCCESS;
        });
        //--------------------------------------------------------------------------------------------------------------

        //sync config
        Photosynthesis.LOGGER.info("Sending config request to server...");
        ClientPlayNetworking.send(ModMessages.CONFIG_REQ_SYNC_ID, PacketByteBufs.create());
    }
}
