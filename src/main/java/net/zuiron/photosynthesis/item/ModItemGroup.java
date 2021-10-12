package net.zuiron.photosynthesis.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup PHOTOSYNTHESIS = FabricItemGroupBuilder.build(new Identifier(Photosynthesis.MOD_ID, "photosynthesis"),
            () -> new ItemStack(ModBlocks.FLORAMELISSIA));
}
