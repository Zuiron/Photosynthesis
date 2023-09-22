package net.zuiron.photosynthesis.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.entity.custom.AlligatorEntity;
import net.zuiron.photosynthesis.entity.custom.BoarEntity;
import net.zuiron.photosynthesis.entity.layer.ModModelLayers;
import net.zuiron.photosynthesis.entity.variant.AlligatorVariant;

import java.util.Map;

public class AlligatorRenderer extends MobEntityRenderer<AlligatorEntity, AlligatorModel<AlligatorEntity>> {
    private static final Identifier TEXTURE = new Identifier(Photosynthesis.MOD_ID, "textures/entity/alligator.png");

    private static final Map<AlligatorVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(AlligatorVariant.class), map -> {
                map.put(AlligatorVariant.DEFAULT,
                        new Identifier(Photosynthesis.MOD_ID, "textures/entity/alligator.png"));
                map.put(AlligatorVariant.BROWN,
                        new Identifier(Photosynthesis.MOD_ID, "textures/entity/alligator_brown.png"));
                map.put(AlligatorVariant.BLACK,
                        new Identifier(Photosynthesis.MOD_ID, "textures/entity/alligator_black.png"));
            });

    public AlligatorRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AlligatorModel<>(ctx.getPart(ModModelLayers.ALLIGATOR)), 0.6f);
    }

    @Override
    public Identifier getTexture(AlligatorEntity entity) {
        //return TEXTURE;
        return LOCATION_BY_VARIANT.get(entity.getVariant());
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
