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
    public static BlockEntityType<GravityPressBlockEntity> GRAVITYPRESS;
    public static BlockEntityType<LatexExtractorBlockEntity> LATEX_EXTRACTOR;
    public static BlockEntityType<WoodFiredStoveBlockEntity> WOOD_FIRED_STOVE;
    public static BlockEntityType<WoodFiredOvenBlockEntity> WOOD_FIRED_OVEN;
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
    public static BlockEntityType<HayRackBlockEntity> HAYRACK;
    public static BlockEntityType<SingleDoubleChestBlockEntity> SINGLEDOUBLECHEST;
    public static BlockEntityType<BaleBlockEntity> BALE;

    public static BlockEntityType<FeedingTroughBlockEntity> FEEDINGTROUGH;
    public static BlockEntityType<WaterTroughBlockEntity> WATERTROUGH;

    public static BlockEntityType<SeasonsCalendarBlockEntity> SEASONSCALENDAR;

    public static void registerBlockEntities() {
        CUTTING_BOARD = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "cutting_board"),
                FabricBlockEntityTypeBuilder.create(CuttingBoardBlockEntity::new,
                        ModBlocks.CUTTINGBOARD).build(null));

        MORTAR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "mortar"),
                FabricBlockEntityTypeBuilder.create(MortarBlockEntity::new,
                        ModBlocks.MORTAR).build(null));

        GRAVITYPRESS = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "gravitypress"),
                FabricBlockEntityTypeBuilder.create(GravityPressBlockEntity::new,
                        ModBlocks.GRAVITYPRESS).build(null));

        LATEX_EXTRACTOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "latex_extractor"),
                FabricBlockEntityTypeBuilder.create(LatexExtractorBlockEntity::new,
                        ModBlocks.LATEX_EXTRACTOR).build(null));

        WOOD_FIRED_STOVE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "wood_fired_stove"),
                FabricBlockEntityTypeBuilder.create(WoodFiredStoveBlockEntity::new,
                        ModBlocks.WOOD_FIRED_STOVE).build(null));

        WOOD_FIRED_OVEN = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "wood_fired_oven"),
                FabricBlockEntityTypeBuilder.create(WoodFiredOvenBlockEntity::new,
                        ModBlocks.WOOD_FIRED_OVEN).build(null));

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

        HAYRACK = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "hayrack"),
                FabricBlockEntityTypeBuilder.create(HayRackBlockEntity::new,
                        ModBlocks.HAYRACK).build(null));

        BALE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "bale"),
                FabricBlockEntityTypeBuilder.create(BaleBlockEntity::new,
                        ModBlocks.GRASS_BALE,ModBlocks.HAY_BALE,ModBlocks.STRAW_BALE,ModBlocks.WRAPPED_GRASS_BALE).build(null));

        FEEDINGTROUGH = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "feedingtrough"),
                FabricBlockEntityTypeBuilder.create(FeedingTroughBlockEntity::new,
                        ModBlocks.FEEDINGTROUGH).build(null));

        WATERTROUGH = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "watertrough"),
                FabricBlockEntityTypeBuilder.create(WaterTroughBlockEntity::new,
                        ModBlocks.WATERTROUGH).build(null));

        SEASONSCALENDAR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "seasonscalendar"),
                FabricBlockEntityTypeBuilder.create(SeasonsCalendarBlockEntity::new,
                        ModBlocks.SEASONSCALENDAR).build(null));

        SINGLEDOUBLECHEST = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Photosynthesis.MOD_ID, "singledoublechest"),
                FabricBlockEntityTypeBuilder.create(SingleDoubleChestBlockEntity::new,
                        //all kitchen counters or objects of SingleDoubleChest's goes here.
                        //Diorite
                        /*ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_OAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_OAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_OAK,
                        //Deepslate
                        ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_OAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_OAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_OAK,
                        //Andesite
                        ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_OAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_OAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_OAK,
                        //Granite
                        ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_OAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_OAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_OAK*/
                        ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_OAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_OAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_OAK,
                        ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_OAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_OAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_OAK,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_OAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_OAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_OAK,
                        ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_OAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_OAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_OAK,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_SPRUCE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_BIRCH,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_JUNGLE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_ACACIA,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_CHERRY,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_DARKOAK,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_MANGROVE,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DIORITE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DIORITE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DIORITE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_POLISHED_GRANITE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_GRANITE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_GRANITE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_POLISHED_DEEPSLATE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_DEEPSLATE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_DEEPSLATE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_POLISHED_ANDESITE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_BIG_POLISHED_ANDESITE_BAMBOO,
                        ModBlocks.KITCHENCOUNTER_DRAWERS_POLISHED_ANDESITE_BAMBOO,

                        //cabinets
                        ModBlocks.KITCHENCABINET_SPLIT_OAK,
                        ModBlocks.KITCHENCABINET_LEFT_OAK,
                        ModBlocks.KITCHENCABINET_RIGHT_OAK,
                        ModBlocks.KITCHENCABINET_SPLIT_SPRUCE,
                        ModBlocks.KITCHENCABINET_LEFT_SPRUCE,
                        ModBlocks.KITCHENCABINET_RIGHT_SPRUCE,
                        ModBlocks.KITCHENCABINET_SPLIT_BIRCH,
                        ModBlocks.KITCHENCABINET_LEFT_BIRCH,
                        ModBlocks.KITCHENCABINET_RIGHT_BIRCH,
                        ModBlocks.KITCHENCABINET_SPLIT_JUNGLE,
                        ModBlocks.KITCHENCABINET_LEFT_JUNGLE,
                        ModBlocks.KITCHENCABINET_RIGHT_JUNGLE,
                        ModBlocks.KITCHENCABINET_SPLIT_ACACIA,
                        ModBlocks.KITCHENCABINET_LEFT_ACACIA,
                        ModBlocks.KITCHENCABINET_RIGHT_ACACIA,
                        ModBlocks.KITCHENCABINET_SPLIT_CHERRY,
                        ModBlocks.KITCHENCABINET_LEFT_CHERRY,
                        ModBlocks.KITCHENCABINET_RIGHT_CHERRY,
                        ModBlocks.KITCHENCABINET_SPLIT_DARKOAK,
                        ModBlocks.KITCHENCABINET_LEFT_DARKOAK,
                        ModBlocks.KITCHENCABINET_RIGHT_DARKOAK,
                        ModBlocks.KITCHENCABINET_SPLIT_MANGROVE,
                        ModBlocks.KITCHENCABINET_LEFT_MANGROVE,
                        ModBlocks.KITCHENCABINET_RIGHT_MANGROVE,
                        ModBlocks.KITCHENCABINET_SPLIT_BAMBOO,
                        ModBlocks.KITCHENCABINET_LEFT_BAMBOO,
                        ModBlocks.KITCHENCABINET_RIGHT_BAMBOO

                        ).build(null));

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, LATEX_EXTRACTOR); //ALL sides extract, ok.

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, MAPLE_EXTRACTOR); //ALL sides extract, ok.

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, WATERTROUGH); //ALL sides extract, ok.

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
