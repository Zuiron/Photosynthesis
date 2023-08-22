package net.zuiron.photosynthesis.block.entity.client;

import net.minecraft.block.Blocks;
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
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.block.custom.ShelfBlock;
import net.zuiron.photosynthesis.block.entity.GravityPressBlockEntity;
import net.zuiron.photosynthesis.block.entity.ShelfBlockEntity;
import net.zuiron.photosynthesis.fluid.ModFluids;
import net.zuiron.photosynthesis.state.property.ModProperties;

import java.util.Objects;

public class GravityPressBlockEntityRenderer implements BlockEntityRenderer<GravityPressBlockEntity> {
    public GravityPressBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(GravityPressBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        DefaultedList<ItemStack> inventoryList = entity.getInventoryMod();

        double max = 1.0f;

        if(!Objects.requireNonNull(entity.getWorld()).getBlockState(entity.getPos()).contains(ModProperties.PROGRESS3)) {
            return;
        }
        int curProgress = entity.getWorld().getBlockState(entity.getPos()).get(ModProperties.PROGRESS3);

        //case: SOUTH: player looking north
        double x = 1.5f; //0 is LEFT, 1.0 is RIGHT edge.
        double y = 0.95f; //0 is BOTTOM, 1 is TOP.
        double z = 0.6f; //0, is BACK, 1.0 is FRONT outside of shelf. toward player when looking at shelf.
        int rot = 25;
        float scale = 0.5f;

        if(curProgress == 0) {
            y = 1.3f; //0 is BOTTOM, 1 is TOP.
            x = 1.2f;
        } else if(curProgress == 1) {
            y = 0.95f; //0 is BOTTOM, 1 is TOP.
        } else if(curProgress == 2) {
            y = 0.5f; //0 is BOTTOM, 1 is TOP.
            x = 1.6f;
        }

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

        //chain
        y += 0.4;
        scale = 0.6f;
        rot = 90;
        z = 0.575f; //0, is BACK, 1.0 is FRONT outside of shelf. toward player when looking at shelf.

        if(curProgress == 1) {
            y -= 0.1;
        }
        if(curProgress == 2) {
            y -= 0.2;
        }

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
        itemRenderer.renderItem(Items.CHAIN.getDefaultStack(), ModelTransformationMode.NONE, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
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

        if(curProgress == 2 || curProgress == 1) {
            inputOutputItem = ItemStack.EMPTY;
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
