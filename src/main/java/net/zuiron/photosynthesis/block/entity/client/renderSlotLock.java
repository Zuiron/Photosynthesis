package net.zuiron.photosynthesis.block.entity.client;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.custom.ShelfBlock;
import net.zuiron.photosynthesis.block.entity.SkilletBlockEntity;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.state.property.ModProperties;

import java.util.Objects;

public class renderSlotLock {
    public static void render(BlockEntity entity, ItemRenderer itemRenderer, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        //boolean slotLock = entity.getSlotLockState();

        if(!Objects.requireNonNull(entity.getWorld()).getBlockState(entity.getPos()).contains(ModProperties.SLOT_LOCKED)) {
            return;
        }

        boolean slotLock = entity.getWorld().getBlockState(entity.getPos()).get(ModProperties.SLOT_LOCKED);

        ItemStack itemStackSlotLocked = Items.AIR.getDefaultStack();

        assert MinecraftClient.getInstance().player != null;
        ItemStack handStack = MinecraftClient.getInstance().player.getStackInHand(MinecraftClient.getInstance().player.getActiveHand());

        if(handStack.isOf(ModItems.WRENCH)) {
            if (slotLock) {
                itemStackSlotLocked = ModItems.SLOT_LOCK_LOCKED.getDefaultStack();
            } else {
                itemStackSlotLocked = ModItems.SLOT_LOCK_UNLOCKED.getDefaultStack();
            }
        }

        //SLOTLOCK
        double max = 1.0f;
        //case: SOUTH: player looking north
        double x = 0.845f; //0 is LEFT, 1.0 is RIGHT edge.
        double y = 0.1f; //0 is BOTTOM, 1 is TOP.
        double z = 0.94f; //0, is BACK, 1.0 is FRONT outside of shelf. toward player when looking at block.
        int rot = 0;
        float scale2 = 0.15f;

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

        matrices.scale(scale2, scale2, scale2);
        itemRenderer.renderItem(itemStackSlotLocked, ModelTransformationMode.NONE, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
    }

    private static int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
