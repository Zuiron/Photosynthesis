package net.zuiron.photosynthesis.networking.packet;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.config.ModConfig;
import net.zuiron.photosynthesis.util.IEntityDataSaver;

public class ConfigSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //((IEntityDataSaver) client.player).getPersistentData().putInt("thirst", buf.readInt());
        /*if (client.player instanceof IEntityDataSaver) {
            ((IEntityDataSaver) client.player).getPersistentData().putInt("thirst", buf.readInt());
        }*/

        //read data.
        int daysPerSeason = buf.readInt();
        boolean thirstEnabled = buf.readBoolean();
        boolean seasonsEnabled = buf.readBoolean();

        //set config.
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        config.daysPerSeason = daysPerSeason;
        config.thirst = thirstEnabled;
        config.seasons = seasonsEnabled;

        //actually set config.
        AutoConfig.getConfigHolder(ModConfig.class).setConfig(config);

        Photosynthesis.LOGGER.info("received and set (server) config from server.");
    }
}
