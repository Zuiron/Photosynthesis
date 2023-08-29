package net.zuiron.photosynthesis.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;

public class ModEffects {

    public static final StatusEffect DEHYDRATED = registerStatusEffect("dehydrated",
            new DehydratedEffect(StatusEffectCategory.HARMFUL,0x36ebab));

    public static final StatusEffect MEAD = registerStatusEffect("mead",
            new MeadEffect(StatusEffectCategory.BENEFICIAL,0x36ebab));

    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Photosynthesis.MOD_ID, name), statusEffect);
    }
    public static void registerEffects() {
        Photosynthesis.LOGGER.info("Registering Mod Effects for "+Photosynthesis.MOD_ID);
    }
}
