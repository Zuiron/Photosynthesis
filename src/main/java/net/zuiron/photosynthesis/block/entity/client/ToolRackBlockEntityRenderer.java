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
import net.zuiron.photosynthesis.block.custom.ToolRackBlock;
import net.zuiron.photosynthesis.block.entity.ToolRackBlockEntity;

public class ToolRackBlockEntityRenderer implements BlockEntityRenderer<ToolRackBlockEntity> {
    public ToolRackBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(ToolRackBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        ItemStack itemStack = entity.getRenderStack0();

        //TOOL
        matrices.push();
        matrices.scale(0.5f, 0.5f, 0.5f);
        switch (entity.getCachedState().get(ToolRackBlock.FACING)) {
            case NORTH -> {
                matrices.translate(1.0f, 0.05f, 1.0f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case EAST -> {
                matrices.translate(1.0f, 0.05f, 1.0f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-270));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case SOUTH -> {
                matrices.translate(1.0f, 0.05f, 1.0f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case WEST -> {
                matrices.translate(1.0f, 0.05f, 1.0f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
        }
        //itemRenderer.renderItem(itemStack, ModelTransformation.Mode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 1);
        itemRenderer.renderItem(itemStack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
