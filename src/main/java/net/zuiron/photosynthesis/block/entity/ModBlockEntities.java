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
    public static BlockEntityType<MortarBlockEntity> MORTAR;
    public static BlockEntityType<LatexExtractorBlockEntity> LATEX_EXTRACTOR;
    public static BlockEntityType<MapleExtractorBlockEntity> MAPLE_EXTRACTOR;
    public static BlockEntityType<SkilletBlockEntity> SKILLET;
    public static BlockEntityType<MixingBowlBlockEntity> MIXINGBOWL;
    public static BlockEntityType<CookingPotBlockEntity> COOKINGPOT;
    public static BlockEntityType<KegBlockEntity> KEG;

    public static BlockEntityType<MilkSeperatorBlockEntity> MILKSEPERATOR;

    public static void registerBlockEntities() {
        CUTTING_BOARD = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "cutting_board"),
                FabricBlockEntityTypeBuilder.create(CuttingBoardBlockEntity::new,
                        ModBlocks.CUTTINGBOARD).build(null));

        MORTAR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "mortar"),
                FabricBlockEntityTypeBuilder.create(MortarBlockEntity::new,
                        ModBlocks.MORTAR).build(null));

        LATEX_EXTRACTOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "latex_extractor"),
                FabricBlockEntityTypeBuilder.create(LatexExtractorBlockEntity::new,
                        ModBlocks.LATEX_EXTRACTOR).build(null));

        MAPLE_EXTRACTOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "maple_extractor"),
                FabricBlockEntityTypeBuilder.create(MapleExtractorBlockEntity::new,
                        ModBlocks.MAPLE_EXTRACTOR).build(null));

        SKILLET = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "skillet"),
                FabricBlockEntityTypeBuilder.create(SkilletBlockEntity::new,
                        ModBlocks.SKILLET).build(null));

        MIXINGBOWL = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "mixingbowl"),
                FabricBlockEntityTypeBuilder.create(MixingBowlBlockEntity::new,
                        ModBlocks.MIXING_BOWL).build(null));

        COOKINGPOT = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "cookingpot"),
                FabricBlockEntityTypeBuilder.create(CookingPotBlockEntity::new,
                        ModBlocks.COOKINGPOT).build(null));

        KEG = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "keg"),
                FabricBlockEntityTypeBuilder.create(KegBlockEntity::new,
                        ModBlocks.KEG).build(null));

        MILKSEPERATOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "milkseperator"),
                FabricBlockEntityTypeBuilder.create(MilkSeperatorBlockEntity::new,
                        ModBlocks.MILKSEPERATOR).build(null));

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, LATEX_EXTRACTOR);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, MAPLE_EXTRACTOR);
    }
}
