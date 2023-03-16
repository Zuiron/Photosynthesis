package net.zuiron.photosynthesis.client;

import com.mojang.blaze3d.systems.RenderSystem;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.font.UnicodeTextureFont;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.config.ModConfig;

import java.awt.font.FontRenderContext;

public class SeasonsHudOverlay implements HudRenderCallback {
    private static final Identifier CALENDAR = new Identifier(Photosynthesis.MOD_ID,
            "textures/seasons/seasons_calendar.png");
    private static final Identifier CALENDAR_BAR = new Identifier(Photosynthesis.MOD_ID,
            "textures/seasons/seasons_bar.png");
    private static final Identifier CALENDAR_TAB = new Identifier(Photosynthesis.MOD_ID,
            "textures/seasons/tab.png");

    private static final Identifier SEASON_SUMMER = new Identifier(Photosynthesis.MOD_ID,
            "textures/seasons/summer.png");
    private static final Identifier SEASON_SPRING = new Identifier(Photosynthesis.MOD_ID,
            "textures/seasons/spring.png");
    private static final Identifier SEASON_AUTUMN = new Identifier(Photosynthesis.MOD_ID,
            "textures/seasons/autumn.png");
    private static final Identifier SEASON_WINTER = new Identifier(Photosynthesis.MOD_ID,
            "textures/seasons/winter.png");

    public static void renderSeasonsBar(MatrixStack matrixStack, float tickDelta, int x) {
        RenderSystem.setShaderTexture(0, CALENDAR_BAR);
        DrawableHelper.drawTexture(matrixStack, x - 128, 0, 0, 0, 256, 12,
                256, 12);
    }

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

        assert player != null;
        World world = player.getWorld();

        assert world != null;
        long time = world.getTimeOfDay();

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        //int day = Seasons.getDay(time);
        //int dayInSeason = Seasons.getDayInSeason(time);
        //int daysPerYear = Seasons.getDaysPerYear();
        //int dayOfYear = Seasons.getDayOfYear(time);
        //int daysPerSeasonMod = Seasons.getDaysPerSeasonMod();
        int current_season = Seasons.getCurrentSeason(time);
        int daysRemaining = Seasons.getRemainingDaysOfCurrentSeason(time);
        float seasonPercentage = Seasons.getSeasonPercentage(time);

        //--------------------------------------------------------------------------------------------------------------
        //------------- SEASONS BAR
        renderSeasonsBar(matrixStack, tickDelta, x);


        //--------------------------------------------------------------------------------------------------------------
        //------------- SEASON IMAGE

        //seasons image
        if (current_season == 0) {
            RenderSystem.setShaderTexture(0, SEASON_SUMMER);
        } else if(current_season == 1) {
            RenderSystem.setShaderTexture(0, SEASON_AUTUMN);
        } else if(current_season == 2) {
            RenderSystem.setShaderTexture(0, SEASON_WINTER);
        } else if(current_season == 3) {
            RenderSystem.setShaderTexture(0, SEASON_SPRING);
        } else {
            RenderSystem.setShaderTexture(0, SEASON_SUMMER); //just in case.
        }
        DrawableHelper.drawTexture(matrixStack,2 ,2 ,0,0,64,64,
                64,64);




        //--------------------------------------------------------------------------------------------------------------
        //------------- CALENDAR TAB
        float pixelsPerSeason = 256.0f / 4; // 4 seasons
        // Calculate the position of the tab within the current season's pixel range
        float tabPosition = (current_season * pixelsPerSeason) + (seasonPercentage * pixelsPerSeason) - 128.0f;

        RenderSystem.setShaderTexture(0, CALENDAR_TAB);
        DrawableHelper.drawTexture(matrixStack, (int) (x + tabPosition - 4),1,0,0,5,11,
                5,11);

        String[] seasonNames = {"Summer", "Autumn", "Winter", "Spring"};

        // Get the text to display
        String text = String.format("Current season: %s (%d days remaining)", seasonNames[current_season], daysRemaining);

        // Get the text renderer
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        // Draw the text
        int scaledWidth = (int) (textRenderer.getWidth(text) * 0.5f);
        int textWidth = textRenderer.getWidth(text);
        //int xs = (int) (client.getWindow().getScaledWidth() / 2.0f - textWidth / 2.0f);
        int xs = (int) ((client.getWindow().getScaledWidth() / 2.0f) - (scaledWidth / 2));
        int ys = 20;

        matrixStack.push();
        matrixStack.scale(0.5f, 0.5f, 1.0f);
        xs /= 0.5f; // Adjust for scaling
        textRenderer.draw(matrixStack, text, xs, ys, 0xFFFFFF);
        matrixStack.pop();


        //--------------------------------------------------------------------------------------------------------------
        //------------- INFO DISPLAYS

        //TODO
    }
}
