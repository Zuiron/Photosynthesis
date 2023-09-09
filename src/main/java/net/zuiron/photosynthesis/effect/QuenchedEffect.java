package net.zuiron.photosynthesis.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.zuiron.photosynthesis.util.IEntityDataSaver;
import net.zuiron.photosynthesis.util.ThirstData;

import java.util.Random;

public class QuenchedEffect extends StatusEffect {
    protected QuenchedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
            if(new Random().nextFloat() <= 0.05f) {
                if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
                    ThirstData.addThirst((IEntityDataSaver)serverPlayerEntity, 1);
                    ThirstData.addThirstSaturation((IEntityDataSaver)serverPlayerEntity, 60);
                }
            }

        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
