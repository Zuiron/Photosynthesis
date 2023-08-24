package net.zuiron.photosynthesis.networking.packet;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.config.ModConfig;
import net.zuiron.photosynthesis.util.ConfigSync;

public class ConfigRequestSyncC2SPacket {

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //do something
        Photosynthesis.LOGGER.info(player.getName().getString()+": Requesting server config.");

        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        ConfigSync.syncConfig(config,player);
    }
}
