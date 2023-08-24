package net.zuiron.photosynthesis.client;

import com.mojang.blaze3d.systems.RenderSystem;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.config.ModConfig;

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
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        if(Seasons.isSeasonsEnabled() && MinecraftClient.isHudEnabled()) {
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
            if(config.seasonDisplayTimeline) {
                RenderSystem.setShaderTexture(0, CALENDAR_BAR);
                context.drawTexture(CALENDAR_BAR, x - 128, 0, 0, 0, 256, 12,
                        256, 12);
            }

            //--------------------------------------------------------------------------------------------------------------
            //------------- SEASON IMAGE
            if(config.seasonDisplayIcon) {
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
            }


            //--------------------------------------------------------------------------------------------------------------
            //------------- CALENDAR TAB
            // Get the text renderer
            TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

            if(config.seasonDisplayTimeline) {
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

                float seasonTimelineTextScale = config.seasonTimelineTextScale;

                // Draw the text
                int scaledWidth = (int) (textRenderer.getWidth(text) * seasonTimelineTextScale);
                int xs = (int) ((client.getWindow().getScaledWidth() / 2.0f) - (scaledWidth / 2));
                int ys = config.seasonTimelineTextYOffset;


                context.getMatrices().push();
                context.getMatrices().scale(seasonTimelineTextScale, seasonTimelineTextScale, 1.0f);
                xs /= seasonTimelineTextScale; // Adjust for scaling
                context.drawTextWithShadow(textRenderer, text, xs, ys, 0xFFFFFF);
                context.getMatrices().pop();
            }
            //--------------------------------------------------------------------------------------------------------------
            //------------- INFO DISPLAYS
            if(config.seasonDisplayInfo) {
                int y_text_1 = 100;
                int y_text_2 = 110;

                if(!config.seasonDisplayIcon) {
                    y_text_1 = y_text_1-90;
                    y_text_2 = y_text_2-90;
                }

                float textScale = config.seasonDisplayInfoScale;
                int textXOffset = config.seasonDisplayInfoXOffset;
                int textYOffset = config.seasonDisplayInfoYOffset;

                String text_season_1 = String.format("Day: %d/%d, Year: %d", dayOfYear + 1, daysPerYear, getYear);
                text_season_1.formatted(Formatting.BOLD);
                context.getMatrices().push();
                context.getMatrices().scale(textScale, textScale, 1.0f);
                context.drawTextWithShadow(textRenderer, text_season_1, 10+textXOffset, y_text_1+textYOffset, 0xFFFFFF);
                context.getMatrices().pop();

                String text_season_2 = String.format("%s - Day: %d/%d", getSeasonName, dayInSeason + 1, daysPerSeasonMod);
                text_season_2.formatted(Formatting.BOLD);
                context.getMatrices().push();
                context.getMatrices().scale(textScale, textScale, 1.0f);
                context.drawTextWithShadow(textRenderer, text_season_2, 10+textXOffset, y_text_2+textYOffset, 0xFFFFFF);
                context.getMatrices().pop();
            }
        }
    }
}
