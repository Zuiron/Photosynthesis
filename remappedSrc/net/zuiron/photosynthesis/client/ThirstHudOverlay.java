package net.zuiron.photosynthesis.client;

import com.mojang.blaze3d.systems.RenderSystem;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.config.ModConfig;
import net.zuiron.photosynthesis.util.IEntityDataSaver;


public class ThirstHudOverlay implements HudRenderCallback {
    static ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    private static final Identifier FILLED_THIRST = new Identifier(Photosynthesis.MOD_ID,
            "textures/thirst/thirst_full.png");
    private static final Identifier FILLED_THIRST_GLINT = new Identifier(Photosynthesis.MOD_ID,
            "textures/thirst/thirst_full_glint.png");
    private static final Identifier FILLED_THIRST_GLINT_EFFECT = new Identifier(Photosynthesis.MOD_ID,
            "textures/thirst/thirst_full_glint_effect.png");
    private static final Identifier FILLED_THIRST_GLINT_NOBG = new Identifier(Photosynthesis.MOD_ID,
            "textures/thirst/thirst_full_glint_nobg.png");
    private static final Identifier EMPTY_THIRST = new Identifier(Photosynthesis.MOD_ID,
            "textures/thirst/thirst_empty.png");

    Random random = Random.create();

    @Override
    public void onHudRender(DrawContext DrawableHelper, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        assert client != null;
        PlayerEntity player = client.player;
        assert player != null;
        boolean isCreative = player.isCreative();
        boolean isSpectator = player.isSpectator();

        if (config.thirst && !isCreative && !isSpectator) {
            int x = 0;
            int y = 0;
            if (client != null) {
                int width = client.getWindow().getScaledWidth();
                int height = client.getWindow().getScaledHeight();

                x = width / 2;
                y = height;
            }
            int offset = 0;

            if (player != null && player.hasVehicle()) {
                Entity vehicle = player.getVehicle();
                if (vehicle instanceof LivingEntity) {
                    float health = ((LivingEntity) vehicle).getMaxHealth();
                    if (health > 20.0f) {
                        offset = 59;
                    } else {
                        offset = 49;
                    }
                }
            } else if (player.getAir() < 300) {
                offset = 59;
            } else {
                offset = 49;
            }

            RenderSystem.setShader(GameRenderer::getPositionTexProgram);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, EMPTY_THIRST);

            int k = player.getHungerManager().getFoodLevel();
            int z = 0;

            for (int i = 0; i < 10; i++) {
                if (((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst") <= 1) {
                    z = offset + (random.nextInt(3) - 1);
                } else {
                    z = offset;
                }
                DrawableHelper.drawTexture(EMPTY_THIRST, x + 10 + (i * 8), y - z, 0, 0, 9, 9,
                        9, 9);
            }


            int thirst = ((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst");


            int thirstSat = ((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst_sat");
            RenderSystem.setShaderTexture(0, FILLED_THIRST_GLINT_EFFECT); //max saturation is 600. so "glint texture" for each 60 saturation we got.
            for (int i = 0; i < thirstSat / 60; i++) {
                //if(i >= thirst) { break; }
                if (thirst <= 1) {
                    break;
                }
                assert MinecraftClient.getInstance().player != null;
                DrawableHelper.drawTexture(FILLED_THIRST_GLINT_EFFECT, x + 82 - (i * 8), y - z, 0, 0, 9, 9,
                        9, 9);
            }


            /*if (thirstSat >= 300) {
                RenderSystem.setShaderTexture(0, FILLED_THIRST_GLINT_NOBG);
            } else {
                RenderSystem.setShaderTexture(0, FILLED_THIRST);
            }*/

            for (int i = 0; i < 10; i++) {
                assert MinecraftClient.getInstance().player != null;
                if (thirst > i) {
                    if (thirstSat >= 300) {
                        RenderSystem.setShaderTexture(0, FILLED_THIRST_GLINT_NOBG);
                        DrawableHelper.drawTexture(FILLED_THIRST_GLINT_NOBG, x + 82 - (i * 8), y - z, 0, 0, 9, 9, 9, 9);
                    } else {
                        RenderSystem.setShaderTexture(0, FILLED_THIRST);
                        DrawableHelper.drawTexture(FILLED_THIRST, x + 82 - (i * 8), y - z, 0, 0, 9, 9, 9, 9);
                    }
                } else {
                    break;
                }
            }


        }
    }
    /*@Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        assert client != null;
        PlayerEntity player = client.player;
        assert player != null;
        boolean isCreative = player.isCreative();
        boolean isSpectator = player.isSpectator();

        if (config.thirst && !isCreative && !isSpectator) {
            int x = 0;
            int y = 0;
            if (client != null) {
                int width = client.getWindow().getScaledWidth();
                int height = client.getWindow().getScaledHeight();

                x = width / 2;
                y = height;
            }
            int offset = 0;

            if (player != null && player.hasVehicle()) {
                Entity vehicle = player.getVehicle();
                if (vehicle instanceof LivingEntity) {
                    float health = ((LivingEntity) vehicle).getMaxHealth();
                    if (health > 20.0f) {
                        offset = 59;
                    } else {
                        offset = 49;
                    }
                }
            } else if (player.getAir() < 300) {
                offset = 59;
            } else {
                offset = 49;
            }

            RenderSystem.setShader(GameRenderer::getPositionTexProgram);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, EMPTY_THIRST);

            int k = player.getHungerManager().getFoodLevel();
            int z = 0;

            for (int i = 0; i < 10; i++) {
                if (((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst") <= 1) {
                    z = offset + (random.nextInt(3) - 1);
                } else {
                    z = offset;
                }
                DrawableHelper.drawTexture(matrixStack, x + 10 + (i * 8), y - z, 0, 0, 9, 9,
                        9, 9);
            }


            int thirst = ((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst");


            int thirstSat = ((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst_sat");
            RenderSystem.setShaderTexture(0, FILLED_THIRST_GLINT_EFFECT); //max saturation is 600. so "glint texture" for each 60 saturation we got.
            for (int i = 0; i < thirstSat / 60; i++) {
                //if(i >= thirst) { break; }
                if (thirst <= 1) {
                    break;
                }
                assert MinecraftClient.getInstance().player != null;
                DrawableHelper.drawTexture(matrixStack, x + 82 - (i * 8), y - z, 0, 0, 9, 9,
                        9, 9);
            }


            if (thirstSat >= 300) {
                RenderSystem.setShaderTexture(0, FILLED_THIRST_GLINT_NOBG);
            } else {
                RenderSystem.setShaderTexture(0, FILLED_THIRST);
            }

            for (int i = 0; i < 10; i++) {
                assert MinecraftClient.getInstance().player != null;
                //int thirst = ((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getInt("thirst");
                if (thirst > i) {
                    DrawableHelper.drawTexture(matrixStack, x + 82 - (i * 8), y - z, 0, 0, 9, 9,
                            9, 9);
                } else {
                    break;
                }
            }


        }
    }*/
}
