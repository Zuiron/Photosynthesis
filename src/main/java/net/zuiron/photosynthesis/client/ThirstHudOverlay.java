package net.zuiron.photosynthesis.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.util.IEntityDataSaver;

public class ThirstHudOverlay implements HudRenderCallback {
    private static final Identifier FILLED_THIRST = new Identifier(Photosynthesis.MOD_ID,
            "textures/thirst/thirst_full.png");
    private static final Identifier EMPTY_THIRST = new Identifier(Photosynthesis.MOD_ID,
            "textures/thirst/thirst_empty.png");

    Random random = Random.create();
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        assert client != null;
        PlayerEntity player = client.player;
        int offset;
        //if (player != null && player.isSubmergedInWater()) {
        if (player != null && player.getAir() < 300) {
            // Player is underwater
            // Draw the underwater HUD overlay here
            offset = 59;
        } else {
            // Player is not underwater
            // Draw the regular HUD overlay here
            offset = 49;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_THIRST);

        int k = player.getHungerManager().getFoodLevel();
        int z = 0;

        for(int i = 0; i < 10; i++) {
            //if (player.getHungerManager().getSaturationLevel() <= 0.0F) {
            if (((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst") <= 1) {
                z = offset + (random.nextInt(3) - 1);
            } else {
                z = offset;
            }
            DrawableHelper.drawTexture(matrixStack,x + 10 + (i * 8),y - z,0,0,9,9,
                    9,9);
        }

        RenderSystem.setShaderTexture(0, FILLED_THIRST);
        for(int i = 0; i < 10; i++) {
            assert MinecraftClient.getInstance().player != null;
            if(((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst") > i) {
            //if(7 > i) {
                DrawableHelper.drawTexture(matrixStack,x + 82 - (i * 8),y - z,0,0,9,9,
                        9,9);
            } else {
                break;
            }
        }
    }
}
