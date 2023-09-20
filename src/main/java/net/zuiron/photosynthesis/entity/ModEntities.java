package net.zuiron.photosynthesis.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.entity.custom.BoarEntity;

public class ModEntities {
    public static final EntityType<BoarEntity> BOAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Photosynthesis.MOD_ID, "boar"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BoarEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 1.1f)).build());

    public static void registerModEntities() {
        Photosynthesis.LOGGER.info("Registering Mod Entities for " + Photosynthesis.MOD_ID);
    }
}
