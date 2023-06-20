package net.zuiron.photosynthesis.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

public class ModItemGroup {
    public static ItemGroup PHOTOSYNTHESIS = Registry.register(Registries.ITEM_GROUP, new Identifier(Photosynthesis.MOD_ID, "photosynthesis"),
            FabricItemGroup.builder().displayName(Text.literal("Photosynthesis"))
                    .icon(() -> new ItemStack(ModBlocks.FLORAMELISSIA)).entries((displayContext, entries) -> {
                        entries.add(ModItems.AGAVE);
                        entries.add(ModItems.AGAVE_SEEDS);

                        entries.add(ModBlocks.ALMONDTREE_BUSHCROP);
                    }).build());
    public static void registerItemGroup() {
        //example add to ingredients group tab.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.ZUCCHINI);
        });
    }
}
