package net.zuiron.photosynthesis.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.item.ModItemGroup;

public class ModFluids {
    public static FlowableFluid STILL_LATEX;
    public static FlowableFluid FLOWING_LATEX;
    public static Block LATEX_BLOCK;
    public static Item LATEX_BUCKET;

    public static FlowableFluid STILL_CANOLAOIL;
    public static FlowableFluid FLOWING_CANOLAOIL;
    public static Block CANOLAOIL_BLOCK;
    public static Item CANOLAOIL_BUCKET;

    public static FlowableFluid STILL_SUNFLOWEROIL;
    public static FlowableFluid FLOWING_SUNFLOWEROIL;
    public static Block SUNFLOWEROIL_BLOCK;
    public static Item SUNFLOWEROIL_BUCKET;

    public static FlowableFluid STILL_MEAD;
    public static FlowableFluid FLOWING_MEAD;
    public static Block MEAD_BLOCK;
    public static Item MEAD_BUCKET;

    public static void register() {
        //LATEX
        STILL_LATEX = Registry.register(Registries.FLUID,
                new Identifier(Photosynthesis.MOD_ID, "latex"), new LatexFluid.Still());
        FLOWING_LATEX = Registry.register(Registries.FLUID,
                new Identifier(Photosynthesis.MOD_ID, "flowing_latex"), new LatexFluid.Flowing());
        LATEX_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, "latex_block"),
                new FluidBlock(ModFluids.STILL_LATEX, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        LATEX_BUCKET = Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, "latex_bucket"),
                new BucketItem(ModFluids.STILL_LATEX, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.PHOTOSYNTHESIS).register(entries -> entries.add(LATEX_BUCKET));

        //CANOLA OIL
        STILL_CANOLAOIL = Registry.register(Registries.FLUID,
                new Identifier(Photosynthesis.MOD_ID, "canolaoil"), new CanolaOilFluid.Still());
        FLOWING_CANOLAOIL = Registry.register(Registries.FLUID,
                new Identifier(Photosynthesis.MOD_ID, "flowing_canolaoil"), new CanolaOilFluid.Flowing());
        CANOLAOIL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, "canolaoil_block"),
                new FluidBlock(ModFluids.STILL_CANOLAOIL, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        CANOLAOIL_BUCKET = Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, "canolaoil_bucket"),
                new BucketItem(ModFluids.STILL_CANOLAOIL, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.PHOTOSYNTHESIS).register(entries -> entries.add(CANOLAOIL_BUCKET));

        //SUNFLOWER OIL
        STILL_SUNFLOWEROIL = Registry.register(Registries.FLUID,
                new Identifier(Photosynthesis.MOD_ID, "sunfloweroil"), new SunflowerOilFluid.Still());
        FLOWING_SUNFLOWEROIL = Registry.register(Registries.FLUID,
                new Identifier(Photosynthesis.MOD_ID, "flowing_sunfloweroil"), new SunflowerOilFluid.Flowing());
        SUNFLOWEROIL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, "sunfloweroil_block"),
                new FluidBlock(ModFluids.STILL_SUNFLOWEROIL, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        SUNFLOWEROIL_BUCKET = Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, "sunfloweroil_bucket"),
                new BucketItem(ModFluids.STILL_SUNFLOWEROIL, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.PHOTOSYNTHESIS).register(entries -> entries.add(SUNFLOWEROIL_BUCKET));

        //MEAD
        STILL_MEAD = Registry.register(Registries.FLUID,
                new Identifier(Photosynthesis.MOD_ID, "mead"), new MeadFluid.Still());
        FLOWING_MEAD = Registry.register(Registries.FLUID,
                new Identifier(Photosynthesis.MOD_ID, "flowing_mead"), new MeadFluid.Flowing());
        MEAD_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, "mead_block"),
                new FluidBlock(ModFluids.STILL_MEAD, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        MEAD_BUCKET = Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, "mead_bucket"),
                new BucketItem(ModFluids.STILL_MEAD, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.PHOTOSYNTHESIS).register(entries -> entries.add(MEAD_BUCKET));
    }
}
