package net.zuiron.photosynthesis.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import net.zuiron.photosynthesis.block.entity.*;
import net.zuiron.photosynthesis.screen.*;
import net.zuiron.photosynthesis.util.FluidStack;

public class FluidSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        FluidVariant variant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();
        BlockPos position = buf.readBlockPos();

        if(client.world.getBlockEntity(position) instanceof LatexExtractorBlockEntity blockEntity) {
            blockEntity.setFluidLevel(variant, fluidLevel);

            if(client.player.currentScreenHandler instanceof LatexExtractorScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setFluidLevel(variant, fluidLevel);
                screenHandler.setFluid(new FluidStack(variant, fluidLevel));
            }
        }
        else if(client.world.getBlockEntity(position) instanceof KegBlockEntity blockEntity) {
            blockEntity.setInputFluidLevel(variant, fluidLevel);

            if(client.player.currentScreenHandler instanceof KegScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setInputFluidLevel(variant, fluidLevel);
                screenHandler.setInputFluid(new FluidStack(variant, fluidLevel));
            }
        }
        else if(client.world.getBlockEntity(position) instanceof MapleExtractorBlockEntity blockEntity) {
            blockEntity.setFluidLevel(variant, fluidLevel);

            if(client.player.currentScreenHandler instanceof MapleExtractorScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setFluidLevel(variant, fluidLevel);
                screenHandler.setFluid(new FluidStack(variant, fluidLevel));
            }
        }
        else if(client.world.getBlockEntity(position) instanceof MilkSeperatorBlockEntity blockEntity) {
            blockEntity.setInputFluidLevel(variant, fluidLevel);

            if(client.player.currentScreenHandler instanceof MilkSeperatorScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setInputFluidLevel(variant, fluidLevel);
                screenHandler.setInputFluid(new FluidStack(variant, fluidLevel));
            }
        }
        else if(client.world.getBlockEntity(position) instanceof WaterTroughBlockEntity blockEntity) {
            blockEntity.setFluidLevel(variant, fluidLevel);

            if(client.player.currentScreenHandler instanceof WaterTroughScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setFluidLevel(variant, fluidLevel);
                screenHandler.setFluid(new FluidStack(variant, fluidLevel));
            }
        }
    }
}
