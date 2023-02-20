package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<CuttingBoardBlockEntity> CUTTING_BOARD;
    public static BlockEntityType<LatexExtractorBlockEntity> LATEX_EXTRACTOR;

    public static void registerBlockEntities() {
        CUTTING_BOARD = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "cutting_board"),
                FabricBlockEntityTypeBuilder.create(CuttingBoardBlockEntity::new,
                        ModBlocks.CUTTINGBOARD).build(null));

        LATEX_EXTRACTOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "latex_extractor"),
                FabricBlockEntityTypeBuilder.create(LatexExtractorBlockEntity::new,
                        ModBlocks.LATEX_EXTRACTOR).build(null));

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, LATEX_EXTRACTOR);
    }
}
