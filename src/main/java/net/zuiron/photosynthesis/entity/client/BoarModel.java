package net.zuiron.photosynthesis.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.zuiron.photosynthesis.entity.animations.ModAnimations;
import net.zuiron.photosynthesis.entity.custom.BoarEntity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BoarModel<T extends BoarEntity> extends SinglePartEntityModel<T> {
    private final ModelPart boar;
    private final ModelPart head;

    public BoarModel(ModelPart root) {
        this.boar = root.getChild("boar");
        this.head = boar.getChild("body").getChild("torso").getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData boar = modelPartData.addChild("boar", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData body = boar.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 14).cuboid(-4.0F, -12.0F, -3.5F, 7.0F, 10.0F, 7.0F, new Dilation(0.0F))
                .uv(26, 0).cuboid(-4.0F, -13.0F, -2.5F, 7.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.5F, 0.0F));

        ModelPartData back = torso.addChild("back", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -5.0F, 0.0F));

        ModelPartData cube_r1 = back.addChild("cube_r1", ModelPartBuilder.create().uv(21, 14).cuboid(-1.4F, -7.9F, -2.0F, 10.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.4F, -5.9F, -3.0F, 10.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

        ModelPartData head = torso.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(-3.2F, -7.5F, 0.0F));

        ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.496F, -4.4826F, 2.0F, -0.6981F, 0.0F, -0.0436F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(0, 14).cuboid(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.496F, -4.4826F, -2.0F, 0.6981F, 0.0F, -0.0436F));

        ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(0, 31).cuboid(-1.8F, -4.5F, -1.5F, 4.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(23, 26).cuboid(-1.8F, -3.5F, -2.5F, 4.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(28, 20).cuboid(-1.4F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-5.5526F, 1.1735F, 0.0F, 0.0F, 0.0F, -0.4363F));

        ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(21, 14).cuboid(-0.5F, -2.0F, 0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.3882F, 1.6562F, -2.0F, 0.4363F, 0.0F, -0.4363F));

        ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(0, 18).cuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.5616F, 0.3386F, 1.4837F, -0.48F, 0.0F, -0.4363F));

        ModelPartData tail = torso.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(13.6544F, -7.0208F, 0.0F));

        ModelPartData cube_r8 = tail.addChild("cube_r8", ModelPartBuilder.create().uv(32, 6).cuboid(-0.6F, -4.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.4544F, 1.3208F, 0.0F, 0.0F, 0.0F, -0.48F));

        ModelPartData left_front_leg = body.addChild("left_front_leg", ModelPartBuilder.create().uv(20, 38).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -6.0F, -2.0F));

        ModelPartData right_front_leg = body.addChild("right_front_leg", ModelPartBuilder.create().uv(8, 37).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -6.0F, 2.0F));

        ModelPartData right_back_leg = body.addChild("right_back_leg", ModelPartBuilder.create().uv(0, 35).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(9.0F, -6.0F, 1.9F));

        ModelPartData left_back_leg = body.addChild("left_back_leg", ModelPartBuilder.create().uv(14, 31).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(9.0F, -6.0F, -1.9F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(BoarEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateMovement(ModAnimations.BOAR_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.BOAR_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.BOAR_ATTACK, ageInTicks, 1f);
    }
    private void setHeadAngles(BoarEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        boar.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return boar;
    }
}