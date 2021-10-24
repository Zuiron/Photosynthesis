package net.zuiron.photosynthesis.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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


    // CROP BLOCKS -----------------------------------------------------------------------------------------------------
    public static final CropBlock TOMATO_CROP = registerCropBlock("tomato_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.TOMATO_SEEDS));

    public static final CropBlock BASIL_CROP = registerCropBlock("basil_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.BASIL_SEEDS));

    public static final CropBlock OREGANO_CROP = registerCropBlock("oregano_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.OREGANO_SEEDS));

    public static final CropBlock STRAWBERRY_CROP = registerCropBlock("strawberry_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.STRAWBERRY_SEEDS));

    public static final CropBlock OAT_CROP = registerCropBlock("oat_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.OAT_SEEDS));

    public static final CropBlock JALAPENO_CROP = registerCropBlock("jalapeno_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.JALAPENO_SEEDS));

    public static final CropBlock CHILI_CROP = registerCropBlock("chili_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.CHILI_SEEDS));

    public static final CropBlock CUCUMBER_CROP = registerCropBlock("cucumber_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.CUCUMBER_SEEDS));

    public static final CropBlock ONION_CROP = registerCropBlock("onion_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.ONION_SEEDS));

    public static final CropBlock LEEK_CROP = registerCropBlock("leek_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.LEEK_SEEDS));

    public static final CropBlock CELERY_CROP = registerCropBlock("celery_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.CELERY_SEEDS));

    public static final CropBlock PEAS_CROP = registerCropBlock("peas_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.PEAS_SEEDS));

    public static final CropBlock SWEET_POTATO_CROP = registerCropBlock("sweet_potato_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.SWEET_POTATO_SEEDS));

    public static final CropBlock ASPARAGUS_CROP = registerCropBlock("asparagus_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.ASPARAGUS_SEEDS));

    public static final CropBlock SCALLION_CROP = registerCropBlock("scallion_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.SCALLION_SEEDS));

    public static final CropBlock GARLIC_CROP = registerCropBlock("garlic_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.GARLIC_SEEDS));

    public static final CropBlock CHIVE_CROP = registerCropBlock("chive_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.CHIVE_SEEDS));

    public static final CropBlock BROCCOLI_CROP = registerCropBlock("broccoli_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.BROCCOLI_SEEDS));

    public static final CropBlock CAULIFLOWER_CROP = registerCropBlock("cauliflower_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.CAULIFLOWER_SEEDS));

    public static final CropBlock CORN_CROP = registerCropBlock("corn_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.CORN_SEEDS));

    public static final CropBlock BLACK_PEPPER_CROP = registerCropBlock("black_pepper_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.BLACK_PEPPER_SEEDS));

    public static final CropBlock CABBAGE_CROP = registerCropBlock("cabbage_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.CABBAGE_SEEDS));

    public static final CropBlock BELLPEPPER_CROP = registerCropBlock("bellpepper_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.BELLPEPPER_SEEDS));


    // BERRY BUSHES ----------------------------------------------------------------------------------------------------
    public static final SweetBerryBushBlock BLUEBERRY_BUSH = registerBushBlock("blueberry_bush",
            new BlueberryBush(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    public static final SweetBerryBushBlock BLACKBERRY_BUSH = registerBushBlock("blackberry_bush",
            new BlackberryBush(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    public static final SweetBerryBushBlock RASPBERRY_BUSH = registerBushBlock("raspberry_bush",
            new RaspberryBush(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    public static final SweetBerryBushBlock CLOUDBERRY_BUSH = registerBushBlock("cloudberry_bush",
            new CloudberryBush(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final SweetBerryBushBlock WILD_STRAWBERRY_BUSH = registerBushBlock("wild_strawberry_bush",
            new Wild_StrawberryBush(AbstractBlock.Settings.of(Material.PLANT)
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
