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
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.custom.ShelfBlock;
import net.zuiron.photosynthesis.block.entity.GravityPressBlockEntity;
import net.zuiron.photosynthesis.block.entity.ShelfBlockEntity;

public class GravityPressBlockEntityRenderer implements BlockEntityRenderer<GravityPressBlockEntity> {
    public GravityPressBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(GravityPressBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        DefaultedList<ItemStack> inventoryList = entity.getInventoryMod();

        double max = 1.0f;



        //case: SOUTH: player looking north
        double x = 1.5f; //0 is LEFT, 1.0 is RIGHT edge.
        double y = 0.95f; //0 is BOTTOM, 1 is TOP.
        double z = 0.6f; //0, is BACK, 1.0 is FRONT outside of shelf. toward player when looking at shelf.
        int rot = 25;
        float scale = 0.5f;

        //0 = WEIGHT block.
        matrices.push();
        switch (entity.getCachedState().get(ShelfBlock.FACING)) {
            case NORTH -> { //player looking south
                matrices.translate(max - x, y, max - z);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180+rot));
            }
            case SOUTH -> { //player looking north
                matrices.translate(x, y, z);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0+rot));
            }
            case EAST -> { //player looking west
                matrices.translate(z, y, max - x);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90+rot));
            }
            case WEST -> { //player looking east
                matrices.translate(max - z, y, x);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90+rot));
            }
        }

        matrices.scale(scale, scale, scale);
        itemRenderer.renderItem(inventoryList.get(0), ModelTransformationMode.NONE, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();



        //1/2 = INPUT / OUTPUT ITEM.
        ItemStack inputOutputItem;
        if(inventoryList.get(2).isEmpty()) {
            inputOutputItem = inventoryList.get(1);
        } else {
            inputOutputItem = inventoryList.get(2);
        }

        x = 0.5f; //0 is LEFT, 1.0 is RIGHT edge.
        y = 0.39f; //0 is BOTTOM, 1 is TOP.
        z = 0.525f; //0, is BACK, 1.0 is FRONT outside of shelf. toward player when looking at shelf.
        rot = 0;
        scale = 0.3f;

        matrices.push();
        switch (entity.getCachedState().get(ShelfBlock.FACING)) {
            case NORTH -> { //player looking south
                matrices.translate(max - x, y, max - z);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180+rot));
            }
            case SOUTH -> { //player looking north
                matrices.translate(x, y, z);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0+rot));
            }
            case EAST -> { //player looking west
                matrices.translate(z, y, max - x);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90+rot));
            }
            case WEST -> { //player looking east
                matrices.translate(max - z, y, x);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90+rot));
            }
        }

        matrices.scale(scale, scale, scale);
        itemRenderer.renderItem(inputOutputItem, ModelTransformationMode.NONE, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
