package net.zuiron.photosynthesis.block.entity.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.entity.KegBlockEntity;
import net.zuiron.photosynthesis.block.entity.MixingBowlBlockEntity;

public class KegBlockEntityRenderer implements BlockEntityRenderer<KegBlockEntity> {
    public KegBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(KegBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        //render slot lock
        double x = 0.81f; //0 is LEFT, 1.0 is RIGHT edge.
        double y = 0.35f; //0 is BOTTOM, 1 is TOP.
        double z = 0.94f; //0, is BACK, 1.0 is FRONT outside of shelf. toward player when looking at block.
        int rot = 0;
        float scale2 = 0.15f;
        renderSlotLock.render(entity,itemRenderer,tickDelta,matrices,vertexConsumers,light,overlay, x, y, z, rot, scale2);
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
