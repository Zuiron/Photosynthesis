package net.zuiron.photosynthesis.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.zuiron.photosynthesis.block.entity.*;

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
        else if(client.world.getBlockEntity(position) instanceof PlateBlockEntity blockEntity) { blockEntity.setInventory(list); }
        else if(client.world.getBlockEntity(position) instanceof ToolRackBlockEntity blockEntity) { blockEntity.setInventory(list); }
        else if(client.world.getBlockEntity(position) instanceof ShelfBlockEntity blockEntity) { blockEntity.setInventory(list); }
        else if(client.world.getBlockEntity(position) instanceof DryingNetBlockEntity blockEntity) { blockEntity.setInventory(list); }
        else if(client.world.getBlockEntity(position) instanceof DryingRackBlockEntity blockEntity) { blockEntity.setInventory(list); }
        else if(client.world.getBlockEntity(position) instanceof SingleDoubleChestBlockEntity blockEntity) { blockEntity.setInventory(list); }
    }
}
