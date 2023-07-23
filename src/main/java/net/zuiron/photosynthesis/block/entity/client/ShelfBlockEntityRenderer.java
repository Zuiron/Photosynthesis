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
import net.zuiron.photosynthesis.block.custom.ShelfBlock;
import net.zuiron.photosynthesis.block.custom.ToolRackBlock;
import net.zuiron.photosynthesis.block.entity.ShelfBlockEntity;
import net.zuiron.photosynthesis.block.entity.ToolRackBlockEntity;

public class ShelfBlockEntityRenderer implements BlockEntityRenderer<ShelfBlockEntity> {
    public ShelfBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(ShelfBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        ItemStack itemStack = entity.getRenderStack0();
        ItemStack itemStack1 = entity.getRenderStack1();
        ItemStack itemStack2 = entity.getRenderStack2();
        ItemStack itemStack3 = entity.getRenderStack3();
        ItemStack itemStack4 = entity.getRenderStack4();
        ItemStack itemStack5 = entity.getRenderStack5();

        double max = 1.0f;
        //case: SOUTH: player looking north
        double x = 0.10f; //0 is LEFT, 1.0 is RIGHT edge.
        double y = 0.56f; //0 is BOTTOM, 1 is TOP.
        double z = 0.15f; //0, is BACK, 1.0 is FRONT outside of shelf. toward player when looking at shelf.
        int rot = 30;
        double itemOffset = 0.16;

        //SLOT0
        matrices.push();
        switch (entity.getCachedState().get(ShelfBlock.FACING)) {
            case NORTH -> { //player looking south
                //matrices.translate(0.75f, 0.56f, 0.925f); //correct
                matrices.translate(max - x, y, max - z); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180+rot)); //correct
            }
            case SOUTH -> { //player looking north
                //matrices.translate(0.25f, 0.56f, 0.075f); //correct
                matrices.translate(x, y, z); //correct
                //matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0)); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0+rot)); //correct
            }
            case EAST -> { //player looking west
                //matrices.translate(0.075f, 0.56f, 0.75f); //correct
                matrices.translate(z, y, max - x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90+rot)); //correct
            }
            case WEST -> { //player looking east
                //matrices.translate(0.925f, 0.56f, 0.25f); //correct
                matrices.translate(max - z, y, x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90+rot)); //correct
            }
        }
        matrices.scale(0.25f, 0.25f, 0.25f);
        itemRenderer.renderItem(itemStack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        //SLOT1
        x += itemOffset;
        matrices.push();
        switch (entity.getCachedState().get(ShelfBlock.FACING)) {
            case NORTH -> { //player looking south
                //matrices.translate(0.75f, 0.56f, 0.925f); //correct
                matrices.translate(max - x, y, max - z); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180+rot)); //correct
            }
            case SOUTH -> { //player looking north
                //matrices.translate(0.25f, 0.56f, 0.075f); //correct
                matrices.translate(x, y, z); //correct
                //matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0)); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0+rot)); //correct
            }
            case EAST -> { //player looking west
                //matrices.translate(0.075f, 0.56f, 0.75f); //correct
                matrices.translate(z, y, max - x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90+rot)); //correct
            }
            case WEST -> { //player looking east
                //matrices.translate(0.925f, 0.56f, 0.25f); //correct
                matrices.translate(max - z, y, x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90+rot)); //correct
            }
        }
        matrices.scale(0.25f, 0.25f, 0.25f);
        itemRenderer.renderItem(itemStack1, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        //SLOT2
        x += itemOffset;
        matrices.push();
        switch (entity.getCachedState().get(ShelfBlock.FACING)) {
            case NORTH -> { //player looking south
                //matrices.translate(0.75f, 0.56f, 0.925f); //correct
                matrices.translate(max - x, y, max - z); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180+rot)); //correct
            }
            case SOUTH -> { //player looking north
                //matrices.translate(0.25f, 0.56f, 0.075f); //correct
                matrices.translate(x, y, z); //correct
                //matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0)); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0+rot)); //correct
            }
            case EAST -> { //player looking west
                //matrices.translate(0.075f, 0.56f, 0.75f); //correct
                matrices.translate(z, y, max - x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90+rot)); //correct
            }
            case WEST -> { //player looking east
                //matrices.translate(0.925f, 0.56f, 0.25f); //correct
                matrices.translate(max - z, y, x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90+rot)); //correct
            }
        }
        matrices.scale(0.25f, 0.25f, 0.25f);
        itemRenderer.renderItem(itemStack2, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        //SLOT3
        x += itemOffset;
        matrices.push();
        switch (entity.getCachedState().get(ShelfBlock.FACING)) {
            case NORTH -> { //player looking south
                //matrices.translate(0.75f, 0.56f, 0.925f); //correct
                matrices.translate(max - x, y, max - z); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180+rot)); //correct
            }
            case SOUTH -> { //player looking north
                //matrices.translate(0.25f, 0.56f, 0.075f); //correct
                matrices.translate(x, y, z); //correct
                //matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0)); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0+rot)); //correct
            }
            case EAST -> { //player looking west
                //matrices.translate(0.075f, 0.56f, 0.75f); //correct
                matrices.translate(z, y, max - x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90+rot)); //correct
            }
            case WEST -> { //player looking east
                //matrices.translate(0.925f, 0.56f, 0.25f); //correct
                matrices.translate(max - z, y, x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90+rot)); //correct
            }
        }
        matrices.scale(0.25f, 0.25f, 0.25f);
        itemRenderer.renderItem(itemStack3, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        //SLOT4
        x += itemOffset;
        matrices.push();
        switch (entity.getCachedState().get(ShelfBlock.FACING)) {
            case NORTH -> { //player looking south
                //matrices.translate(0.75f, 0.56f, 0.925f); //correct
                matrices.translate(max - x, y, max - z); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180+rot)); //correct
            }
            case SOUTH -> { //player looking north
                //matrices.translate(0.25f, 0.56f, 0.075f); //correct
                matrices.translate(x, y, z); //correct
                //matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0)); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0+rot)); //correct
            }
            case EAST -> { //player looking west
                //matrices.translate(0.075f, 0.56f, 0.75f); //correct
                matrices.translate(z, y, max - x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90+rot)); //correct
            }
            case WEST -> { //player looking east
                //matrices.translate(0.925f, 0.56f, 0.25f); //correct
                matrices.translate(max - z, y, x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90+rot)); //correct
            }
        }
        matrices.scale(0.25f, 0.25f, 0.25f);
        itemRenderer.renderItem(itemStack4, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        //SLOT5
        x += itemOffset;
        matrices.push();
        switch (entity.getCachedState().get(ShelfBlock.FACING)) {
            case NORTH -> { //player looking south
                //matrices.translate(0.75f, 0.56f, 0.925f); //correct
                matrices.translate(max - x, y, max - z); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180+rot)); //correct
            }
            case SOUTH -> { //player looking north
                //matrices.translate(0.25f, 0.56f, 0.075f); //correct
                matrices.translate(x, y, z); //correct
                //matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0)); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0+rot)); //correct
            }
            case EAST -> { //player looking west
                //matrices.translate(0.075f, 0.56f, 0.75f); //correct
                matrices.translate(z, y, max - x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90+rot)); //correct
            }
            case WEST -> { //player looking east
                //matrices.translate(0.925f, 0.56f, 0.25f); //correct
                matrices.translate(max - z, y, x); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90+rot)); //correct
            }
        }
        matrices.scale(0.25f, 0.25f, 0.25f);
        itemRenderer.renderItem(itemStack5, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
