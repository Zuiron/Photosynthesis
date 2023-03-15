package net.zuiron.photosynthesis.client;

import com.mojang.blaze3d.systems.RenderSystem;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.config.ModConfig;

public class SeasonsHudOverlay implements HudRenderCallback {
    private static final Identifier CALENDAR = new Identifier(Photosynthesis.MOD_ID,
            "textures/seasons/seasons_calendar.png");
    private static final Identifier CALENDAR_BAR = new Identifier(Photosynthesis.MOD_ID,
            "textures/seasons/seasons_bar.png");
    private static final Identifier CALENDAR_TAB = new Identifier(Photosynthesis.MOD_ID,
            "textures/seasons/tab.png");

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

        //Photosynthesis.LOGGER.info("SEASONS");

        assert client != null;
        PlayerEntity player = client.player;

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        boolean seasons = config.seasons; //is seasons enabled = default: true
        int daysPerSeason = config.daysPerSeason; //days per season = default: 20
        //starting season = summer. minecraft time 0

        assert player != null;
        World world = player.getWorld();

        assert world != null;
        long time = world.getTimeOfDay();

        int day = (int) (time / 24000L) + 1; // add 1 since day 0 is the first day

        // calculate the current day of the current season
        int dayInSeason = (day - 1) % daysPerSeason + 1;


        RenderSystem.setShaderTexture(0, CALENDAR_BAR);
        DrawableHelper.drawTexture(matrixStack,x - 128 ,0 ,0,0,256,12,
                256,12);


        int daysSinceStartOfYear = day;
        int seasonsPerYear = 4;
        int daysPerYear = daysPerSeason * seasonsPerYear;

        // Calculate the number of days since the start of the year, modulo the number of days in a year
        int dayOfYear = daysSinceStartOfYear % daysPerYear;

        // Calculate the number of days per season, modulo the number of days in a year
        int daysPerSeasonMod = daysPerSeason % daysPerYear;

        // Calculate the season, based on the number of days since the start of the year
        int current_season = (dayOfYear / daysPerSeasonMod) % seasonsPerYear;

        // Calculate the percentage of the current season that has elapsed
        float seasonPercentage = ((float)(daysSinceStartOfYear % daysPerSeason)) / daysPerSeason;

        float pixelsPerSeason = 256.0f / seasonsPerYear; // 4 seasons

        // Calculate the position of the tab within the current season's pixel range
        float tabPosition = (current_season * pixelsPerSeason) + (seasonPercentage * pixelsPerSeason) - 128.0f;



        Photosynthesis.LOGGER.info("time: "+time+
                ", day: "+day+
                ", tabPosition: " + tabPosition +
                ", daysPerSeason: "+daysPerSeason+
                ", current_season: "+current_season+
                ", dayInSeason: "+dayInSeason);


        RenderSystem.setShaderTexture(0, CALENDAR_TAB);
        DrawableHelper.drawTexture(matrixStack, (int) (x + tabPosition - 3),1,0,0,5,11,
                5,11);

    }
}
