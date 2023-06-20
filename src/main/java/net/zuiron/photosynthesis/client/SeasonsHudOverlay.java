package net.zuiron.photosynthesis.client;

import com.mojang.blaze3d.systems.RenderSystem;
import me.shedaniel.rei.api.client.gui.DrawableConsumer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.Seasons;
import org.joml.Matrix4f;

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


    @Override
    public void onHudRender(DrawContext context, float tickDelta) {
        if(Seasons.isSeasonsEnabled()) {
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

            int day = Seasons.getDay(time);
            int dayInSeason = Seasons.getDayInSeason(time);
            int daysPerYear = Seasons.getDaysPerYear();
            int dayOfYear = Seasons.getDayOfYear(time);
            int getYear = Seasons.getYear(time);
            int daysPerSeasonMod = Seasons.getDaysPerSeasonMod();
            int current_season = Seasons.getCurrentSeason(time);
            int daysRemaining = Seasons.getRemainingDaysOfCurrentSeason(time);
            float seasonPercentage = Seasons.getSeasonPercentage(time);
            String getSeasonName = Seasons.getSeasonString(current_season);

            //--------------------------------------------------------------------------------------------------------------
            //------------- SEASONS BAR
            RenderSystem.setShaderTexture(0, CALENDAR_BAR);
            context.drawTexture(CALENDAR_BAR, x - 128, 0, 0, 0, 256, 12,
                    256, 12);


            //--------------------------------------------------------------------------------------------------------------
            //------------- SEASON IMAGE

            //seasons image
            if (current_season == 0) {
                RenderSystem.setShaderTexture(0, SEASON_SUMMER);
                context.drawTexture(SEASON_SUMMER, 2, 2, 0, 0, 64, 64,
                        64, 64);
            } else if (current_season == 1) {
                RenderSystem.setShaderTexture(0, SEASON_AUTUMN);
                context.drawTexture(SEASON_AUTUMN, 2, 2, 0, 0, 64, 64,
                        64, 64);
            } else if (current_season == 2) {
                RenderSystem.setShaderTexture(0, SEASON_WINTER);
                context.drawTexture(SEASON_WINTER, 2, 2, 0, 0, 64, 64,
                        64, 64);
            } else if (current_season == 3) {
                RenderSystem.setShaderTexture(0, SEASON_SPRING);
                context.drawTexture(SEASON_SPRING, 2, 2, 0, 0, 64, 64,
                        64, 64);
            } else {
                RenderSystem.setShaderTexture(0, SEASON_SUMMER); //just in case.
                context.drawTexture(SEASON_SUMMER, 2, 2, 0, 0, 64, 64,
                        64, 64);
            }


            //--------------------------------------------------------------------------------------------------------------
            //------------- CALENDAR TAB
            float pixelsPerSeason = 256.0f / 4; // 4 seasons
            // Calculate the position of the tab within the current season's pixel range
            // Lets shift by one. and fix shift. looks nicer on the bar.
            int current_seasonMOD = current_season + 1;
            if (current_seasonMOD == 4) {
                current_seasonMOD = 0;
            }
            float tabPosition = (current_seasonMOD * pixelsPerSeason) + (seasonPercentage * pixelsPerSeason) - 128.0f;

            RenderSystem.setShaderTexture(0, CALENDAR_TAB);
            context.drawTexture(CALENDAR_TAB, (int) (x + tabPosition), 1, 0, 0, 5, 11,
                    5, 11);

            // Get the text to display
            String text = String.format("%s (%d days remaining)", getSeasonName, daysRemaining - 1);

            // Get the text renderer
            TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
            // Draw the text
            int scaledWidth = (int) (textRenderer.getWidth(text) * 0.5f);
            int textWidth = textRenderer.getWidth(text);
            //int xs = (int) (client.getWindow().getScaledWidth() / 2.0f - textWidth / 2.0f);
            int xs = (int) ((client.getWindow().getScaledWidth() / 2.0f) - (scaledWidth / 2));
            int ys = 20;


            context.getMatrices().push();
            context.getMatrices().scale(0.5f, 0.5f, 1.0f);
            xs /= 0.5f; // Adjust for scaling
            context.drawTextWithShadow(textRenderer, text, xs, ys, 0xFFFFFF);
            context.getMatrices().pop();
            /*matrixStack.push();
            matrixStack.scale(0.5f, 0.5f, 1.0f);
            xs /= 0.5f; // Adjust for scaling
            textRenderer.drawWithShadow(matrixStack, text, xs, ys, 0xFFFFFF);
            matrixStack.pop();
*/

            //--------------------------------------------------------------------------------------------------------------
            //------------- INFO DISPLAYS

            /*
            String text_season_1 = String.format("Day: %d/%d, Year: %d", dayOfYear + 1, daysPerYear, getYear);
            text_season_1.formatted(Formatting.BOLD);
            matrixStack.push();
            matrixStack.scale(0.5f, 0.5f, 1.0f);
            textRenderer.drawWithShadow(matrixStack, text_season_1, 10, 100, 0xFFFFFF);
            matrixStack.pop();

            String text_season_2 = String.format("%s - Day: %d/%d", getSeasonName, dayInSeason + 1, daysPerSeasonMod);
            text_season_2.formatted(Formatting.BOLD);
            matrixStack.push();
            matrixStack.scale(0.5f, 0.5f, 1.0f);
            textRenderer.drawWithShadow(matrixStack, text_season_2, 10, 110, 0xFFFFFF);
            matrixStack.pop();*/
        }
    }




    /*@Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        if(Seasons.isSeasonsEnabled()) {
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

            int day = Seasons.getDay(time);
            int dayInSeason = Seasons.getDayInSeason(time);
            int daysPerYear = Seasons.getDaysPerYear();
            int dayOfYear = Seasons.getDayOfYear(time);
            int getYear = Seasons.getYear(time);
            int daysPerSeasonMod = Seasons.getDaysPerSeasonMod();
            int current_season = Seasons.getCurrentSeason(time);
            int daysRemaining = Seasons.getRemainingDaysOfCurrentSeason(time);
            float seasonPercentage = Seasons.getSeasonPercentage(time);
            String getSeasonName = Seasons.getSeasonString(current_season);

            //--------------------------------------------------------------------------------------------------------------
            //------------- SEASONS BAR
            RenderSystem.setShaderTexture(0, CALENDAR_BAR);
            DrawableHelper.drawTexture(matrixStack, x - 128, 0, 0, 0, 256, 12,
                    256, 12);


            //--------------------------------------------------------------------------------------------------------------
            //------------- SEASON IMAGE

            //seasons image
            if (current_season == 0) {
                RenderSystem.setShaderTexture(0, SEASON_SUMMER);
            } else if (current_season == 1) {
                RenderSystem.setShaderTexture(0, SEASON_AUTUMN);
            } else if (current_season == 2) {
                RenderSystem.setShaderTexture(0, SEASON_WINTER);
            } else if (current_season == 3) {
                RenderSystem.setShaderTexture(0, SEASON_SPRING);
            } else {
                RenderSystem.setShaderTexture(0, SEASON_SUMMER); //just in case.
            }
            DrawableHelper.drawTexture(matrixStack, 2, 2, 0, 0, 64, 64,
                    64, 64);


            //--------------------------------------------------------------------------------------------------------------
            //------------- CALENDAR TAB
            float pixelsPerSeason = 256.0f / 4; // 4 seasons
            // Calculate the position of the tab within the current season's pixel range
            // Lets shift by one. and fix shift. looks nicer on the bar.
            int current_seasonMOD = current_season + 1;
            if (current_seasonMOD == 4) {
                current_seasonMOD = 0;
            }
            float tabPosition = (current_seasonMOD * pixelsPerSeason) + (seasonPercentage * pixelsPerSeason) - 128.0f;

            RenderSystem.setShaderTexture(0, CALENDAR_TAB);
            DrawableHelper.drawTexture(matrixStack, (int) (x + tabPosition), 1, 0, 0, 5, 11,
                    5, 11);

            // Get the text to display
            String text = String.format("%s (%d days remaining)", getSeasonName, daysRemaining - 1);

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
            textRenderer.drawWithShadow(matrixStack, text, xs, ys, 0xFFFFFF);
            matrixStack.pop();


            //--------------------------------------------------------------------------------------------------------------
            //------------- INFO DISPLAYS

            String text_season_1 = String.format("Day: %d/%d, Year: %d", dayOfYear + 1, daysPerYear, getYear);
            text_season_1.formatted(Formatting.BOLD);
            matrixStack.push();
            matrixStack.scale(0.5f, 0.5f, 1.0f);
            textRenderer.drawWithShadow(matrixStack, text_season_1, 10, 100, 0xFFFFFF);
            matrixStack.pop();

            String text_season_2 = String.format("%s - Day: %d/%d", getSeasonName, dayInSeason + 1, daysPerSeasonMod);
            text_season_2.formatted(Formatting.BOLD);
            matrixStack.push();
            matrixStack.scale(0.5f, 0.5f, 1.0f);
            textRenderer.drawWithShadow(matrixStack, text_season_2, 10, 110, 0xFFFFFF);
            matrixStack.pop();
        }
    }*/
}
