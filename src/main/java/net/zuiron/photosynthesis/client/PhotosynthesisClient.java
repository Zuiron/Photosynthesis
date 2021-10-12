package net.zuiron.photosynthesis.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;
import net.zuiron.photosynthesis.block.ModBlocks;

@SuppressWarnings("unused")
public class PhotosynthesisClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.FLORAMELISSIA);
    }
}
