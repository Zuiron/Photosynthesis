package net.zuiron.photosynthesis.block.entity.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.custom.CuttingBoardBlock;
import net.zuiron.photosynthesis.block.entity.CuttingBoardBlockEntity;

public class CuttingBoardBlockEntityRenderer implements BlockEntityRenderer<CuttingBoardBlockEntity> {
    public CuttingBoardBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(CuttingBoardBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        ItemStack itemStack = entity.getRenderStack0();
        ItemStack itemStack1 = entity.getRenderStack1();
        ItemStack itemStack2 = entity.getRenderStack2();

        //TOOL
        matrices.push();
        matrices.scale(0.3f, 0.3f, 0.3f);
        switch (entity.getCachedState().get(CuttingBoardBlock.FACING)) {
            case NORTH -> {
                matrices.translate(1.7f, 0.25f, 2.3f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case EAST -> {
                matrices.translate(1.03f, 0.25f, 1.7f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-270));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case SOUTH -> {
                matrices.translate(1.7f, 0.25f, 1.03f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case WEST -> {
                matrices.translate(2.3f, 0.25f, 1.7f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
        }
        itemRenderer.renderItem(itemStack, ModelTransformation.Mode.GUI, getLightLevel(entity.getWorld(), entity.getPos()),
                OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 1);
        matrices.pop();




        //INPUT
        matrices.push();
        matrices.scale(0.3f, 0.3f, 0.3f);
        switch (entity.getCachedState().get(CuttingBoardBlock.FACING)) {
            case NORTH -> {
                matrices.translate(2.3f, 0.25f, 1.0f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case EAST -> {
                matrices.translate(2.3f, 0.25f, 2.3f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-270));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case SOUTH -> {
                matrices.translate(1.0f, 0.25f, 2.3f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case WEST -> {
                matrices.translate(1.0f, 0.25f, 1.0f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
        }
        itemRenderer.renderItem(itemStack1, ModelTransformation.Mode.GUI, getLightLevel(entity.getWorld(), entity.getPos()),
                OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 1);
        matrices.pop();




        //OUTPUT
        matrices.push();
        matrices.scale(0.3f, 0.3f, 0.3f);
        switch (entity.getCachedState().get(CuttingBoardBlock.FACING)) {
            case NORTH -> {
                matrices.translate(1.0f, 0.25f, 1.0f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case EAST -> {
                matrices.translate(2.3f, 0.25f, 1.0f); //
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-270));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case SOUTH -> {
                matrices.translate(2.3f, 0.25f, 2.3f); //DONE
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
            case WEST -> {
                matrices.translate(1.0f, 0.25f, 2.3f); //
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
            }
        }
        itemRenderer.renderItem(itemStack2, ModelTransformation.Mode.GUI, getLightLevel(entity.getWorld(), entity.getPos()),
                OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 1);
        matrices.pop();



    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
