package net.zuiron.photosynthesis.block.entity.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisTransformation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.custom.SkilletBlock;
import net.zuiron.photosynthesis.block.entity.SkilletBlockEntity;

public class SkilletBlockEntityRenderer implements BlockEntityRenderer<SkilletBlockEntity> {
    public SkilletBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(SkilletBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        ItemStack itemStack = entity.getRenderStack();

        //TOOL
        matrices.push();
        float scale = 0.6f;
        float offset = 0.1f;
        float rotate = -90;
        float center = 0.5f;
        switch (entity.getCachedState().get(SkilletBlock.FACING)) {
            case NORTH -> {
                matrices.translate(center, offset, center); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotate));
                matrices.scale(scale, scale, scale);
            }
            case EAST -> {
                matrices.translate(center, offset, center); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-270));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotate));
                matrices.scale(scale, scale, scale);
            }
            case SOUTH -> {
                matrices.translate(center, offset, center); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotate));
                matrices.scale(scale, scale, scale);
            }
            case WEST -> {
                matrices.translate(center, offset, center); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotate));
                matrices.scale(scale, scale, scale);
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
