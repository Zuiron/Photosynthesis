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

        //SLOT0
        matrices.push();
        matrices.scale(0.5f, 0.5f, 0.5f);
        switch (entity.getCachedState().get(ShelfBlock.FACING)) {
            case NORTH -> { //player looking south
                matrices.translate(1.5f, 1.0f, 1.85f); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180)); //correct
            }
            case SOUTH -> { //player looking north
                matrices.translate(0.5f, 1.0f, 0.15f); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0)); //correct
            }
            case EAST -> { //player looking west
                matrices.translate(0.15f, 1.0f, 1.5f); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90)); //correct
            }
            case WEST -> { //player looking east
                matrices.translate(1.85f, 1.0f, 0.5f); //correct
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90)); //correct
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
