package net.zuiron.photosynthesis.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import net.zuiron.photosynthesis.block.entity.KegBlockEntity;
import net.zuiron.photosynthesis.block.entity.MilkSeperatorBlockEntity;
import net.zuiron.photosynthesis.screen.KegScreenHandler;
import net.zuiron.photosynthesis.screen.MilkSeperatorScreenHandler;
import net.zuiron.photosynthesis.util.FluidStack;

public class FluidSyncS2CPacket3 {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        FluidVariant variant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();
        BlockPos position = buf.readBlockPos();

        if(client.world.getBlockEntity(position) instanceof MilkSeperatorBlockEntity blockEntity) {
            blockEntity.setOutputFluidLevel2(variant, fluidLevel);

            if(client.player.currentScreenHandler instanceof MilkSeperatorScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setOutputFluidLevel2(variant, fluidLevel);
                screenHandler.setOutputFluid2(new FluidStack(variant, fluidLevel));
            }
        }
    }
}
