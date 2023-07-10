package net.zuiron.photosynthesis.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.screen.renderer.FluidStackRenderer;
import net.zuiron.photosynthesis.util.FluidStack;
import net.zuiron.photosynthesis.util.MouseUtil;

public class MilkSeperatorScreen extends HandledScreen<MilkSeperatorScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(Photosynthesis.MOD_ID, "textures/gui/milkseperator_gui.png");

    private FluidStackRenderer fluidStackRenderer;

    public MilkSeperatorScreen(MilkSeperatorScreenHandler handler, PlayerInventory inventory, Text title) {
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
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        // renderEnergyAreaTooltips(context, mouseX, mouseY, x, y);
        renderFluidTooltip(context, mouseX, mouseY, x, y, handler.fluidInputStack, 62, 19, fluidStackRenderer);
        renderFluidTooltip(context, mouseX, mouseY, x, y, handler.fluidOutputStack, 114, 19, fluidStackRenderer);
        renderFluidTooltip(context, mouseX, mouseY, x, y, handler.fluidOutputStack2, 133, 19, fluidStackRenderer);
    }


    private void renderFluidTooltip(DrawContext context, int mouseX, int mouseY, int x, int y,
                                    FluidStack fluidStack, int offsetX, int offsetY, FluidStackRenderer renderer) {
        if (isMouseAboveArea(mouseX, mouseY, x, y, offsetX, offsetY, renderer)) {
            context.drawTooltip(textRenderer, renderer.getTooltip(fluidStack, TooltipContext.Default.BASIC), mouseX - x, mouseY - y);
        }
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

        fluidStackRenderer.drawFluid(context, handler.fluidInputStack, x + 62, y + 19, 16, 55,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 4);
        fluidStackRenderer.drawFluid(context, handler.fluidOutputStack, x + 114, y + 19, 16, 55,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 4);
        fluidStackRenderer.drawFluid(context, handler.fluidOutputStack2, x + 133, y + 19, 16, 55,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 4);
    }



    private void renderProgressArrow(DrawContext context, int x, int y) {
        if (handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 85, y + 31, 177, 31, handler.getScaledProgress2(), 16);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidStackRenderer renderer) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }
}
