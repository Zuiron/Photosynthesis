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

    public static void register() {
        STILL_LATEX = Registry.register(Registries.FLUID,
                new Identifier(Photosynthesis.MOD_ID, "latex"), new LatexFluid.Still());
        FLOWING_LATEX = Registry.register(Registries.FLUID,
                new Identifier(Photosynthesis.MOD_ID, "flowing_latex"), new LatexFluid.Flowing());

        LATEX_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Photosynthesis.MOD_ID, "latex_block"),
                new FluidBlock(ModFluids.STILL_LATEX, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        LATEX_BUCKET = Registry.register(Registries.ITEM, new Identifier(Photosynthesis.MOD_ID, "latex_bucket"),
                new BucketItem(ModFluids.STILL_LATEX, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.PHOTOSYNTHESIS).register(entries -> entries.add(LATEX_BUCKET));
    }
}
