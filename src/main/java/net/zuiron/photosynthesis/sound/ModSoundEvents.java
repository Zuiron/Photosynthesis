package net.zuiron.photosynthesis.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;

public class ModSoundEvents {
    public static final Identifier BOAR_AMBIENT_SOUND_ID = new Identifier("photosynthesis:entity_boar_ambient");
    public static SoundEvent BOAR_AMBIENT_SOUND_EVENT = SoundEvent.of(BOAR_AMBIENT_SOUND_ID);

    public static final Identifier BOAR_DEATH_SOUND_ID = new Identifier("photosynthesis:entity_boar_death");
    public static SoundEvent BOAR_DEATH_SOUND_EVENT = SoundEvent.of(BOAR_DEATH_SOUND_ID);

    public static final Identifier BOAR_HURT_SOUND_ID = new Identifier("photosynthesis:entity_boar_hurt");
    public static SoundEvent BOAR_HURT_SOUND_EVENT = SoundEvent.of(BOAR_HURT_SOUND_ID);

    public static void registerModSounds() {
        Registry.register(Registries.SOUND_EVENT, BOAR_AMBIENT_SOUND_ID, BOAR_AMBIENT_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, BOAR_DEATH_SOUND_ID, BOAR_DEATH_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, BOAR_HURT_SOUND_ID, BOAR_HURT_SOUND_EVENT);

        System.out.println("Registered Mod Sounds for " + Photosynthesis.MOD_ID);
    }
}
