package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
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
    public static BlockEntityType<FluidPressBlockEntity> FLUID_PRESS;
    public static BlockEntityType<MilkSeperatorBlockEntity> MILKSEPERATOR;
    public static BlockEntityType<PlateBlockEntity> PLATE;

    public static BlockEntityType<ToolRackBlockEntity> TOOLRACK;

    public static BlockEntityType<ShelfBlockEntity> SHELF;

    public static BlockEntityType<DryingNetBlockEntity> DRYINGNET;
    public static BlockEntityType<DryingRackBlockEntity> DRYINGRACK;
    public static BlockEntityType<SingleDoubleChestBlockEntity> SINGLEDOUBLECHEST;

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

        FLUID_PRESS = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "fluid_press"),
                FabricBlockEntityTypeBuilder.create(FluidPressBlockEntity::new,
                        ModBlocks.FLUID_PRESS).build(null));

        MILKSEPERATOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "milkseperator"),
                FabricBlockEntityTypeBuilder.create(MilkSeperatorBlockEntity::new,
                        ModBlocks.MILKSEPERATOR).build(null));

        PLATE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "plate"),
                FabricBlockEntityTypeBuilder.create(PlateBlockEntity::new,
                        ModBlocks.PLATE).build(null));

        TOOLRACK = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "toolrack"),
                FabricBlockEntityTypeBuilder.create(ToolRackBlockEntity::new,
                        ModBlocks.TOOLRACK).build(null));

        SHELF = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "shelf"),
                FabricBlockEntityTypeBuilder.create(ShelfBlockEntity::new,
                        ModBlocks.SHELF).build(null));

        DRYINGNET = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "dryingnet"),
                FabricBlockEntityTypeBuilder.create(DryingNetBlockEntity::new,
                        ModBlocks.DRYINGNET).build(null));

        DRYINGRACK = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "dryingrack"),
                FabricBlockEntityTypeBuilder.create(DryingRackBlockEntity::new,
                        ModBlocks.DRYINGRACK).build(null));

        SINGLEDOUBLECHEST = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "singledoublechest"),
                FabricBlockEntityTypeBuilder.create(SingleDoubleChestBlockEntity::new,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_OAK).build(null));

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, LATEX_EXTRACTOR); //ALL sides extract, ok.

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, MAPLE_EXTRACTOR); //ALL sides extract, ok.

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> null, KEG);
        //FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidOutput, KEG);

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidOutput, FLUID_PRESS); //ALL sides extract, ok.

        //FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidInput, MILKSEPERATOR);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> null, MILKSEPERATOR); //input fluid TOP only. extract skimmed bottom, cream right.
        //FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidOutput2, MILKSEPERATOR);
        /*FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> {
            // Allow fluid extraction from the bottom
            if (direction == Direction.DOWN) {
                return blockEntity.fluidOutput;
            }
            // Allow fluid insertion from the top
            else if (direction == Direction.UP) {
                return blockEntity.fluidInput;
            }
            // Disallow fluid extraction and insertion from other sides
            return null;
        }, KEG);*/
    }
}
