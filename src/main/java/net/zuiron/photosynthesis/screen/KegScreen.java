package net.zuiron.photosynthesis.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.screen.renderer.FluidStackRenderer;
import net.zuiron.photosynthesis.util.FluidStack;
import net.zuiron.photosynthesis.util.MouseUtil;

import java.util.Optional;

public class KegScreen extends HandledScreen<KegScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(Photosynthesis.MOD_ID, "textures/gui/keg_gui.png");

    private FluidStackRenderer fluidStackRenderer;

    public KegScreen(KegScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
        assignFluidStackRenderer();
    }

    private void assignFluidStackRenderer() {
        fluidStackRenderer = new FluidStackRenderer(FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 4,
                true, 15, 55);
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        //renderEnergyAreaTooltips(matrices, mouseX, mouseY, x, y);
        renderFluidTooltip(matrices, mouseX, mouseY, x, y, handler.fluidInputStack, 30, 6, fluidStackRenderer);
        renderFluidTooltip(matrices, mouseX, mouseY, x, y, handler.fluidOutputStack, 130, 6, fluidStackRenderer);
    }

    private void renderFluidTooltip(MatrixStack matrices, int mouseX, int mouseY, int x, int y,
                                    FluidStack fluidStack, int offsetX, int offsetY, FluidStackRenderer renderer) {
        if(isMouseAboveArea(mouseX, mouseY, x, y, offsetX, offsetY, renderer)) {
            renderTooltip(matrices, renderer.getTooltip(fluidStack, TooltipContext.Default.BASIC),
                    Optional.empty(), mouseX - x, mouseY - y);
        }
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(matrices, x, y);

        fluidStackRenderer.drawFluid(matrices, handler.fluidInputStack, x + 30, y + 6, 16, 55,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 4);
        fluidStackRenderer.drawFluid(matrices, handler.fluidOutputStack, x + 130, y + 6, 16, 55,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 4);
    }

    private void renderProgressArrow(MatrixStack matrices, int x, int y) {
        if(handler.isCrafting()) {
            //drawTexture(matrices, x + 103, y + 20, 176, 0, 8, handler.getScaledProgress());
            drawTexture(matrices, x + 76, y + 47, 177, 31, handler.getScaledProgress2(), 16);
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidStackRenderer renderer) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }
}
