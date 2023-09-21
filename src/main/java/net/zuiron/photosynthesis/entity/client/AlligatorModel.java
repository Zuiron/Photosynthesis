package net.zuiron.photosynthesis.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.FrogAnimations;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.FrogEntity;
import net.zuiron.photosynthesis.entity.animations.AlligatorAnimations;
import net.zuiron.photosynthesis.entity.custom.AlligatorEntity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class AlligatorModel<T extends AlligatorEntity> extends SinglePartEntityModel<T> {
    private final ModelPart alligator;

    public AlligatorModel(ModelPart root) {
        this.alligator = root.getChild("alligator");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData alligator = modelPartData.addChild("alligator", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 24.0F));

        ModelPartData body = alligator.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -14.0F, -14.0F, 16.0F, 12.0F, 27.0F, new Dilation(0.0F))
                .uv(51, 14).cuboid(-5.0F, -16.0F, -14.0F, 0.0F, 2.0F, 27.0F, new Dilation(0.0F))
                .uv(51, 12).cuboid(5.0F, -16.0F, -14.0F, 0.0F, 2.0F, 27.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(51, 18).cuboid(-3.5F, -7.0F, 0.0F, 0.0F, 2.0F, 27.0F, new Dilation(0.0F))
                .uv(0, 39).cuboid(-6.0F, -5.0F, 0.0F, 12.0F, 10.0F, 27.0F, new Dilation(0.0F))
                .uv(51, 16).cuboid(3.5F, -7.0F, 0.0F, 0.0F, 2.0F, 27.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 13.0F));

        ModelPartData tail_2 = tail.addChild("tail_2", ModelPartBuilder.create().uv(51, 20).cuboid(-2.0F, -5.0F, 0.0F, 0.0F, 2.0F, 27.0F, new Dilation(0.0F))
                .uv(0, 56).cuboid(2.0F, -5.0F, 0.0F, 0.0F, 2.0F, 27.0F, new Dilation(0.0F))
                .uv(51, 49).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 7.0F, 27.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 27.0F));

        ModelPartData tail_3 = tail_2.addChild("tail_3", ModelPartBuilder.create().uv(54, 65).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 10.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 27.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(59, 0).cuboid(-6.0F, -5.6F, -11.6F, 12.0F, 10.0F, 12.0F, new Dilation(0.0F))
                .uv(0, 1).cuboid(4.0F, -6.6F, -11.6F, 0.0F, 1.0F, 12.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-4.0F, -6.6F, -11.6F, 0.0F, 1.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.4F, -14.4F));

        ModelPartData mouth = head.addChild("mouth", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.6F, -11.6F));

        ModelPartData mouth_upper = mouth.addChild("mouth_upper", ModelPartBuilder.create().uv(75, 83).cuboid(-3.5F, -2.4167F, -26.0F, 7.0F, 4.0F, 15.0F, new Dilation(0.0F))
                .uv(86, 22).cuboid(-5.5F, -0.4167F, -12.0F, 11.0F, 2.0F, 12.0F, new Dilation(0.0F))
                .uv(35, 93).cuboid(-5.0F, -2.4167F, -11.0F, 10.0F, 2.0F, 11.0F, new Dilation(0.0F))
                .uv(95, 0).cuboid(-4.5F, -3.4167F, -11.0F, 9.0F, 1.0F, 11.0F, new Dilation(0.0F))
                .uv(17, 23).cuboid(2.0F, -4.4167F, -11.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(18, 20).cuboid(-4.0F, -4.4167F, -11.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.5833F, 0.0F, -0.0436F, 0.0F, 0.0F));

        ModelPartData cube_r1 = mouth_upper.addChild("cube_r1", ModelPartBuilder.create().uv(0, 4).cuboid(-3.5F, -2.0764F, -0.6039F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.5F, -2.0764F, -0.6039F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 2.6F, -25.6F, -0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r2 = mouth_upper.addChild("cube_r2", ModelPartBuilder.create().uv(0, 22).cuboid(-0.053F, 0.6684F, 8.0835F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 8).cuboid(-0.0595F, 0.6439F, 4.0786F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 17).cuboid(-0.0661F, 0.6194F, 0.0737F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.1418F, 0.6762F, -22.5019F, 0.0F, 0.0F, 0.2618F));

        ModelPartData cube_r3 = mouth_upper.addChild("cube_r3", ModelPartBuilder.create().uv(23, 2).cuboid(-0.947F, 0.6684F, 8.0835F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 14).cuboid(-0.9405F, 0.6439F, 4.0786F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(23, 5).cuboid(-0.9339F, 0.6194F, 0.0737F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.1418F, 0.6762F, -22.5019F, 0.0F, 0.0F, -0.2618F));

        ModelPartData mouth_lower = mouth.addChild("mouth_lower", ModelPartBuilder.create().uv(0, 85).cuboid(-5.5F, -1.5F, -12.0F, 11.0F, 3.0F, 12.0F, new Dilation(0.0F))
                .uv(90, 49).cuboid(-3.5F, -1.5F, -26.0F, 7.0F, 3.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.5F, 0.0F));

        ModelPartData cube_r4 = mouth_lower.addChild("cube_r4", ModelPartBuilder.create().uv(23, 8).cuboid(0.0F, -0.0764F, -0.6039F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.4833F, -25.6F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r5 = mouth_lower.addChild("cube_r5", ModelPartBuilder.create().uv(20, 3).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(23, 23).cuboid(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 0).cuboid(-1.0F, -2.0F, -9.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.4F, -1.4833F, -15.5F, 0.0F, 0.0F, -0.2618F));

        ModelPartData cube_r6 = mouth_lower.addChild("cube_r6", ModelPartBuilder.create().uv(20, 6).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 24).cuboid(0.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 9).cuboid(0.0F, -2.0F, -9.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.4F, -1.4833F, -15.5F, 0.0F, 0.0F, 0.2618F));

        ModelPartData left_front_leg = body.addChild("left_front_leg", ModelPartBuilder.create().uv(16, 100).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -9.0F, -11.0F, 0.2618F, 0.0F, -0.6109F));

        ModelPartData left_front_leg_toe = left_front_leg.addChild("left_front_leg_toe", ModelPartBuilder.create(), ModelTransform.of(0.0F, 9.0F, 0.0F, -0.1302F, -0.0151F, 0.2195F));

        ModelPartData cube_r7 = left_front_leg_toe.addChild("cube_r7", ModelPartBuilder.create().uv(90, 66).cuboid(-2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 22).cuboid(-3.0F, 1.0F, -9.0F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F))
                .uv(14, 76).cuboid(-2.0F, 0.0F, -7.0F, 4.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -2.0F, -0.0233F, -0.1451F, 0.3186F));

        ModelPartData right_front_leg = body.addChild("right_front_leg", ModelPartBuilder.create().uv(51, 49).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -9.0F, -11.0F, 0.2618F, 0.0F, 0.6109F));

        ModelPartData right_front_leg_toe = right_front_leg.addChild("right_front_leg_toe", ModelPartBuilder.create(), ModelTransform.of(0.0F, 9.0F, 0.0F, -0.1302F, 0.0151F, -0.2195F));

        ModelPartData cube_r8 = right_front_leg_toe.addChild("cube_r8", ModelPartBuilder.create().uv(34, 85).cuboid(-2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 5.0F, new Dilation(0.0F))
                .uv(10, 14).cuboid(-3.0F, 1.0F, -9.0F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 76).cuboid(-2.0F, 0.0F, -7.0F, 4.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -2.0F, -0.0233F, 0.1451F, -0.3186F));

        ModelPartData left_back_leg = body.addChild("left_back_leg", ModelPartBuilder.create().uv(0, 100).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 15.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -10.0F, 14.0F, 0.4331F, 0.0552F, -0.7296F));

        ModelPartData left_back_leg_toe = left_back_leg.addChild("left_back_leg_toe", ModelPartBuilder.create(), ModelTransform.of(0.7443F, 11.6223F, -0.2424F, -0.0869F, 0.0076F, 0.3924F));

        ModelPartData cube_r9 = left_back_leg_toe.addChild("cube_r9", ModelPartBuilder.create().uv(0, 6).cuboid(-4.0F, 1.0F, -10.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F))
                .uv(75, 22).cuboid(-3.0F, 0.0F, -7.0F, 5.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 58).cuboid(-3.0F, -1.0F, -4.0F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -2.0F, -0.1979F, -0.1451F, 0.3186F));

        ModelPartData right_back_leg = body.addChild("right_back_leg", ModelPartBuilder.create().uv(0, 39).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 15.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -10.0F, 14.0F, 0.4331F, -0.0552F, 0.7296F));

        ModelPartData right_back_leg_toe = right_back_leg.addChild("right_back_leg_toe", ModelPartBuilder.create(), ModelTransform.of(-0.7443F, 11.6223F, -0.2424F, -0.0869F, -0.0076F, -0.3924F));

        ModelPartData cube_r10 = right_back_leg_toe.addChild("cube_r10", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, 1.0F, -10.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F))
                .uv(59, 22).cuboid(-2.0F, 0.0F, -7.0F, 5.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 14).cuboid(-2.0F, -1.0F, -4.0F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -2.0F, -0.1979F, 0.1451F, -0.3186F));
        return TexturedModelData.of(modelData, 256, 256);
    }
    @Override
    public void setAngles(AlligatorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        //this.animateMovement(AlligatorAnimations.ALLIGATOR_WALK, limbSwing, limbSwingAmount, 2.5f, 3.5f);
        this.updateAnimation(entity.idleAnimationState, AlligatorAnimations.ALLIGATOR_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, AlligatorAnimations.ALLIGATOR_ATTACK, ageInTicks, 1f);

        //hmmmm
        if (((Entity)entity).isInsideWaterOrBubbleColumn()) {
            //swimming animation...
            //this.animateMovement(FrogAnimations.SWIMMING, limbSwing, limbSwingAmount, 1.0f, 2.5f);
            this.animateMovement(AlligatorAnimations.ALLIGATOR_WALK, limbSwing, limbSwingAmount, 3.5f, 3.5f);
        } else {
            //walking animation...
            //this.animateMovement(FrogAnimations.WALKING, limbSwing, limbSwingAmount, 1.5f, 2.5f);
            this.animateMovement(AlligatorAnimations.ALLIGATOR_WALK, limbSwing, limbSwingAmount, 2.5f, 3.5f);
        }
        //this.updateAnimation(((AlligatorEntity)entity).idlingInWaterAnimationState, FrogAnimations.IDLING_IN_WATER, ageInTicks);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        alligator.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return alligator;
    }
}