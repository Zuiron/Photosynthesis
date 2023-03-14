package net.zuiron.photosynthesis.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.zuiron.photosynthesis.networking.ModMessages;

public class ThirstData {

    public static int getThirst(IEntityDataSaver player) {
        NbtCompound nbt = player.getPersistentData();
        int thirst = nbt.getInt("thirst");
        syncThirst(thirst, (ServerPlayerEntity) player);
        return thirst;
    }

    public static int addThirstSaturation(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int thirst_sat = nbt.getInt("thirst_sat");
        if(thirst_sat + amount >= 600) {
            thirst_sat = 600;
        } else {
            thirst_sat += amount;
        }

        nbt.putInt("thirst_sat", thirst_sat);
        syncThirstSat(thirst_sat, (ServerPlayerEntity) player);
        return thirst_sat;
    }

    public static int removeThirstSaturation(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int thirst_sat = nbt.getInt("thirst_sat");
        if(thirst_sat - amount <= 0) {
            thirst_sat = 0;
            //TODO remove thirst and reset saturation.
            removeThirst(player, 1);
            thirst_sat = 150;
        } else {
            thirst_sat -= amount;
        }

        nbt.putInt("thirst_sat", thirst_sat);
        syncThirstSat(thirst_sat, (ServerPlayerEntity) player);
        return thirst_sat;
    }

    public static int addThirst(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int thirst = nbt.getInt("thirst");
        if(thirst + amount >= 10) {
            thirst = 10;
        } else {
            thirst += amount;
        }

        nbt.putInt("thirst", thirst);
        addThirstSaturation(player, 300);
        syncThirst(thirst, (ServerPlayerEntity) player);
        return thirst;
    }

    public static int removeThirst(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int thirst = nbt.getInt("thirst");
        if(thirst - amount < 0) {
            thirst = 0;
        } else {
            thirst -= amount;
        }

        nbt.putInt("thirst", thirst);
        syncThirst(thirst, (ServerPlayerEntity) player);
        return thirst;
    }

    public static void syncThirst(int thirst, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(thirst);
        ServerPlayNetworking.send(player, ModMessages.THIRST_SYNC_ID, buffer);
    }

    public static void syncThirstSat(int thirstSat, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(thirstSat);
        ServerPlayNetworking.send(player, ModMessages.THIRSTSAT_SYNC_ID, buffer);
    }
}
