package net.zuiron.photosynthesis.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;

public class ModParticles {
    public static final DefaultParticleType BOILING_BUBBLES_PARTICLES =
            registerParticle("boiling_bubbles_particles", FabricParticleTypes.simple());
    public static final DefaultParticleType ORANGE_FALLING_LEAVES =
            registerParticle("orange_falling_leaves", FabricParticleTypes.simple(false));
    public static final DefaultParticleType YELLOW_FALLING_LEAVES =
            registerParticle("yellow_falling_leaves", FabricParticleTypes.simple(false));
    public static final DefaultParticleType GREEN_FALLING_LEAVES =
            registerParticle("green_falling_leaves", FabricParticleTypes.simple(false));

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(Photosynthesis.MOD_ID, name), particleType);
    }
    public static void registerParticles() {
        Photosynthesis.LOGGER.info("Registering particles for: " + Photosynthesis.MOD_ID);
    }
}
