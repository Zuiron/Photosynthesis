package net.zuiron.photosynthesis.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.zuiron.photosynthesis.block.entity.CookingPotBlockEntity;
import net.zuiron.photosynthesis.block.entity.CuttingBoardBlockEntity;
import net.zuiron.photosynthesis.block.entity.SkilletBlockEntity;

public class ItemStackSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        int size = buf.readInt();
        DefaultedList<ItemStack> list = DefaultedList.ofSize(size, ItemStack.EMPTY);
        for(int i = 0; i < size; i++) {
            list.set(i, buf.readItemStack());
        }
        BlockPos position = buf.readBlockPos();

        if(client.world.getBlockEntity(position) instanceof CuttingBoardBlockEntity blockEntity) { blockEntity.setInventory(list); }
        else if(client.world.getBlockEntity(position) instanceof SkilletBlockEntity blockEntity) { blockEntity.setInventory(list); }
        else if(client.world.getBlockEntity(position) instanceof CookingPotBlockEntity blockEntity) { blockEntity.setInventory(list); }
    }
}
