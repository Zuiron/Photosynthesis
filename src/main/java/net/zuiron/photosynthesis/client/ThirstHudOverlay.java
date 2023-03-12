package net.zuiron.photosynthesis.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;

public class ThirstHudOverlay implements HudRenderCallback {
    private static final Identifier FILLED_THIRST = new Identifier(Photosynthesis.MOD_ID,
            "textures/thirst/thirst_full.png");
    private static final Identifier EMPTY_THIRST = new Identifier(Photosynthesis.MOD_ID,
            "textures/thirst/thirst_empty.png");
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

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_THIRST);
        for(int i = 0; i < 10; i++) {
            DrawableHelper.drawTexture(matrixStack,x - 94 + (i * 9),y - 54,0,0,9,9,
                    9,9);
        }

        /*RenderSystem.setShaderTexture(0, FILLED_THIRST);
        for(int i = 0; i < 10; i++) {
            if(((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst") > i) {
                DrawableHelper.drawTexture(matrixStack,x - 94 + (i * 9),y - 54,0,0,12,12,
                        12,12);
            } else {
                break;
            }
        }*/
    }
}
