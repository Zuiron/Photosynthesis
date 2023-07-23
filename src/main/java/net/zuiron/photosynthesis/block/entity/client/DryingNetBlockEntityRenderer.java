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
import net.zuiron.photosynthesis.block.custom.DryingNetBlock;
import net.zuiron.photosynthesis.block.entity.DryingNetBlockEntity;

public class DryingNetBlockEntityRenderer implements BlockEntityRenderer<DryingNetBlockEntity> {
    public DryingNetBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }
    public float rot = 0.0f;
    @Override
    public void render(DryingNetBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        ItemStack itemStack = entity.getRenderStack();

        double max = 1.0f;
        //case: SOUTH: player looking north
        double x = 0.5f; //0 is LEFT, 1.0 is RIGHT edge.
        double y = 0.3f; //0 is BOTTOM, 1 is TOP.
        double z = 0.5f; //0, is BACK, 1.0 is FRONT outside of shelf. toward player when looking at shelf.
        //int rot = 0;
        rot += 0.125f;
        if(rot > 360.0f) { rot = 0.0f; }
        float scale = 0.6f;

        matrices.push();
        switch (entity.getCachedState().get(DryingNetBlock.FACING)) {
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
        itemRenderer.renderItem(itemStack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();



    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
