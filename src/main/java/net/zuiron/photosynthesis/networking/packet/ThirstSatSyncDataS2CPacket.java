package net.zuiron.photosynthesis.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.zuiron.photosynthesis.util.IEntityDataSaver;

public class ThirstSatSyncDataS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        assert client.player != null;
        ((IEntityDataSaver) client.player).getPersistentData().putInt("thirst_sat", buf.readInt());
    }
}
