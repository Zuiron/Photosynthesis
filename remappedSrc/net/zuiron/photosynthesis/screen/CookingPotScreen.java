package net.zuiron.photosynthesis.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;

public class CookingPotScreen extends HandledScreen<CookingPotScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(Photosynthesis.MOD_ID, "textures/gui/cookingpot_gui.png");

    public CookingPotScreen(CookingPotScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);

        int k;
        int i = this.x;
        int j = this.y;
        if (((CookingPotScreenHandler)this.handler).isLit()) {
            //k = ((WoodFiredStoveScreenHandler)this.handler).getFuelProgress();
            k = 12;
            x = 152;
            y = 18;
            context.drawTexture(TEXTURE, i + x, j + y + 12 - k, 176, 12 - k, 14, k + 1);
        }
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if (handler.isCrafting()) {
            //context.drawTexture(TEXTURE, x + 103, y + 20, 176, 0, 8, handler.getScaledProgress());
            context.drawTexture(TEXTURE, x + 90, y + 45, 177, 31, handler.getScaledProgress2(), 16);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

}
