package net.zuiron.photosynthesis.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.zuiron.photosynthesis.Photosynthesis;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.networking.packet.*;

public class ModMessages {
    public static final Identifier DRINKING_ID = new Identifier(Photosynthesis.MOD_ID, "drinking");
    public static final Identifier THIRST_REQ_SYNC_ID = new Identifier(Photosynthesis.MOD_ID, "drinking_request_sync");
    public static final Identifier THIRST_SYNC_ID = new Identifier(Photosynthesis.MOD_ID, "thirst_sync");
    public static final Identifier THIRSTSAT_SYNC_ID = new Identifier(Photosynthesis.MOD_ID, "thirstsat_sync");

    //public static final Identifier EXAMPLE_ID = new Identifier(Photosynthesis.MOD_ID, "example");
    //public static final Identifier ENERGY_SYNC = new Identifier(Photosynthesis.MOD_ID, "energy_sync");
    public static final Identifier FLUID_SYNC = new Identifier(Photosynthesis.MOD_ID, "fluid_sync");
    public static final Identifier FLUID_SYNC2 = new Identifier(Photosynthesis.MOD_ID, "fluid_sync2");
    public static final Identifier FLUID_SYNC3 = new Identifier(Photosynthesis.MOD_ID, "fluid_sync3");
    public static final Identifier ITEM_SYNC = new Identifier(Photosynthesis.MOD_ID, "item_sync");

    public static void registerC2SPackets() { //SERVER?
        //ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(DRINKING_ID, DrinkingC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(THIRST_REQ_SYNC_ID, ThirstRequestSyncC2SPacket::receive);
    }

    public static void registerS2CPackets() { //CLIENT
        ClientPlayNetworking.registerGlobalReceiver(THIRST_SYNC_ID, ThirstSyncDataS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(THIRSTSAT_SYNC_ID, ThirstSatSyncDataS2CPacket::receive);
        //ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(FLUID_SYNC, FluidSyncS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(FLUID_SYNC2, FluidSyncS2CPacket2::receive);
        ClientPlayNetworking.registerGlobalReceiver(FLUID_SYNC3, FluidSyncS2CPacket3::receive);
        ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC, ItemStackSyncS2CPacket::receive);
    }
}
