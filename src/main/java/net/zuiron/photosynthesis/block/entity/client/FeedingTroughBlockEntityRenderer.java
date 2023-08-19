package net.zuiron.photosynthesis.block.entity.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.custom.FeedingTroughBlock;
import net.zuiron.photosynthesis.block.entity.FeedingTroughBlockEntity;

public class FeedingTroughBlockEntityRenderer implements BlockEntityRenderer<FeedingTroughBlockEntity> {
    public FeedingTroughBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(FeedingTroughBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        ItemStack itemStack = entity.getRenderStack();
        int count = itemStack.getCount();
        int maxCount = itemStack.getMaxCount();
        int maxCountBy3 = maxCount / 3;

        float scale = 0.6f;
        float offset = 0.5f; //up/down
        float rotate = -90;
        float center = 0.5f;

        renderAStack(entity, matrices, scale, offset,  rotate,  center, itemRenderer, itemStack, vertexConsumers, -6.0f);
        if(count >= maxCountBy3) {
            offset+=0.04f;
            renderAStack(entity, matrices, scale, offset,  rotate,  center, itemRenderer, itemStack, vertexConsumers, 3.0f);
        }
        if(count >= maxCountBy3*2) {
            offset+=0.04f;
            renderAStack(entity, matrices, scale, offset,  rotate,  center, itemRenderer, itemStack, vertexConsumers, 9.0f);
        }

    }

    private void renderAStack(FeedingTroughBlockEntity entity, MatrixStack matrices,float scale,float offset, float rotate, float center, ItemRenderer itemRenderer, ItemStack itemStack, VertexConsumerProvider vertexConsumers, float rot2) {
        matrices.push();
        switch (entity.getCachedState().get(FeedingTroughBlock.FACING)) {
            case NORTH -> {
                matrices.translate(center, offset, center); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180+rot2));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotate));
                matrices.scale(scale, scale, scale);
            }
            case EAST -> {
                matrices.translate(center, offset, center); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-270+rot2));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotate));
                matrices.scale(scale, scale, scale);
            }
            case SOUTH -> {
                matrices.translate(center, offset, center); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0+rot2));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotate));
                matrices.scale(scale, scale, scale);
            }
            case WEST -> {
                matrices.translate(center, offset, center); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270+rot2));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotate));
                matrices.scale(scale, scale, scale);
            }
        }
        itemRenderer.renderItem(itemStack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
