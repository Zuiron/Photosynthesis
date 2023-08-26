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

        boolean doPigSpawn = buf.readBoolean();
        boolean doCowSpawn = buf.readBoolean();
        boolean doSheepSpawn = buf.readBoolean();
        boolean doChickenSpawn = buf.readBoolean();
        boolean doHorseSpawn = buf.readBoolean();
        boolean doGoatSpawn = buf.readBoolean();

        boolean doCreeperSpawn = buf.readBoolean();
        boolean doZombieSpawn = buf.readBoolean();
        boolean doZombieVillagerSpawn = buf.readBoolean();
        boolean doZombieHorseSpawn = buf.readBoolean();
        boolean doSkeletonSpawn = buf.readBoolean();
        boolean doHuskSpawn = buf.readBoolean();
        boolean doWitchSpawn = buf.readBoolean();
        boolean doSpiderSpawn = buf.readBoolean();
        boolean doSkeletonHorseSpawn = buf.readBoolean();

        //set config.
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        config.daysPerSeason = daysPerSeason;
        config.thirst = thirstEnabled;
        config.seasons = seasonsEnabled;

        config.doPigSpawn = doPigSpawn;
        config.doCowSpawn = doCowSpawn;
        config.doSheepSpawn = doSheepSpawn;
        config.doChickenSpawn = doChickenSpawn;
        config.doHorseSpawn = doHorseSpawn;
        config.doGoatSpawn = doGoatSpawn;

        config.doCreeperSpawn = doCreeperSpawn;
        config.doZombieSpawn = doZombieSpawn;
        config.doZombieVillagerSpawn = doZombieVillagerSpawn;
        config.doZombieHorseSpawn = doZombieHorseSpawn;
        config.doSkeletonSpawn = doSkeletonSpawn;
        config.doHuskSpawn = doHuskSpawn;
        config.doWitchSpawn = doWitchSpawn;
        config.doSpiderSpawn = doSpiderSpawn;
        config.doSkeletonHorseSpawn = doSkeletonHorseSpawn;

        //actually set config.
        AutoConfig.getConfigHolder(ModConfig.class).setConfig(config);

        Photosynthesis.LOGGER.info("received and set (server) config from server.");
    }
}
