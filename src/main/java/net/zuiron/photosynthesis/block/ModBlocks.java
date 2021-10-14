package net.zuiron.photosynthesis.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.item.ModItemGroup;
import net.zuiron.photosynthesis.item.ModItems;

public class ModBlocks {

    // FLOWERS ---------------------------------------------------------------------------------------------------------
    public static final Block FLORAMELISSIA = registerBlock("floramelissia",
            new FlowerBlock(StatusEffect.byRawId(1),1, AbstractBlock.Settings.copy(Blocks.POPPY)));



    // CROPS & SEEDS ---------------------------------------------------------------------------------------------------
    public static final CropBlock CUSTOM_CROP_BLOCK = registerCropBlock("custom_crop_block",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.CUSTOM_SEEDS));


    public static final CropBlock TOMATO_CROP_BLOCK = registerCropBlock("tomato_crop_block",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    Items.WHEAT_SEEDS));

    //ModItems.PRODUCE_TOMATO -> WORKS WHY???
    //ModItems.TOMATO_SEEDS -> does not work. no icon. WHY???
    //wait WTF now nothing works again lol

    public static final SweetBerryBushBlock BLUEBERRY_BUSH = registerBushBlock("blueberry_bush",
            new customBerryBush(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));



    // END OF BLOCKS ---------------------------------------------------------------------------------------------------

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(Photosynthesis.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.PHOTOSYNTHESIS)));
    }

    private static CropBlock registerCropBlock(String name, CropBlock block){
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    private static SweetBerryBushBlock registerBushBlock(String name, SweetBerryBushBlock block){
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + Photosynthesis.MOD_ID);
    }
}
