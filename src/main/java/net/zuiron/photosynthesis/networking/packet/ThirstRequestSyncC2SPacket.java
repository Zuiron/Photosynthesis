package net.zuiron.photosynthesis.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Blocks;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.util.IEntityDataSaver;
import net.zuiron.photosynthesis.util.ThirstData;

public class ThirstRequestSyncC2SPacket {

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {

        // outputting the current thirst level of player
        /*player.sendMessage(Text.literal("Thirst request sync: " + ((IEntityDataSaver) player).getPersistentData().getInt("thirst"))
                .fillStyle(Style.EMPTY.withColor(Formatting.DARK_BLUE)), true);*/
        Photosynthesis.LOGGER.info("Thirst request sync: " + ((IEntityDataSaver) player).getPersistentData().getInt("thirst"));

        // Sync thirst
        ThirstData.syncThirst(((IEntityDataSaver) player).getPersistentData().getInt("thirst"), player);
        ThirstData.syncThirstSat(((IEntityDataSaver) player).getPersistentData().getInt("thirst_sat"), player);
    }
}
