package net.zuiron.photosynthesis.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

public class ModItemGroup {
    public static ItemGroup PHOTOSYNTHESIS;
    public static void registerItemGroup() {
        PHOTOSYNTHESIS = FabricItemGroup.builder(new Identifier(Photosynthesis.MOD_ID, "photosynthesis"))
                .displayName(Text.literal("Photosynthesis Item Group"))
                .icon(() -> new ItemStack(ModBlocks.FLORAMELISSIA)).build();
    }
}
