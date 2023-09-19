package net.zuiron.photosynthesis.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.entity.custom.BoarEntity;
import net.zuiron.photosynthesis.entity.layer.ModModelLayers;

public class BoarRenderer extends MobEntityRenderer<BoarEntity, BoarModel<BoarEntity>> {
    private static final Identifier TEXTURE = new Identifier(Photosynthesis.MOD_ID, "textures/entity/boar.png");
    public BoarRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BoarModel<>(ctx.getPart(ModModelLayers.BOAR)), 0.6f);
    }

    @Override
    public Identifier getTexture(BoarEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(BoarEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.6f, 0.6f, 0.6f);
        } else {
            matrixStack.scale(1.1f, 1.1f, 1.1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
