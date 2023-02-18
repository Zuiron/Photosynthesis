package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<CuttingBoardBlockEntity> CUTTING_BOARD;

    public static void registerBlockEntities() {
        CUTTING_BOARD = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "cutting_board"),
                FabricBlockEntityTypeBuilder.create(CuttingBoardBlockEntity::new,
                        ModBlocks.CUTTINGBOARD).build(null));
    }
}
