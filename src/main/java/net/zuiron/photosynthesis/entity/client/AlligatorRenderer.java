package net.zuiron.photosynthesis.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.entity.custom.AlligatorEntity;
import net.zuiron.photosynthesis.entity.custom.BoarEntity;
import net.zuiron.photosynthesis.entity.layer.ModModelLayers;

public class AlligatorRenderer extends MobEntityRenderer<AlligatorEntity, AlligatorModel<AlligatorEntity>> {
    private static final Identifier TEXTURE = new Identifier(Photosynthesis.MOD_ID, "textures/entity/alligator.png");
    public AlligatorRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AlligatorModel<>(ctx.getPart(ModModelLayers.ALLIGATOR)), 0.6f);
    }

    @Override
    public Identifier getTexture(AlligatorEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(AlligatorEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1.0f, 1.0f, 1.0f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
