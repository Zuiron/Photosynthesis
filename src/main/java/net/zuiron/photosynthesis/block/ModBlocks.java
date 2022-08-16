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
    public static final CropBlock TOMATO_CROP = registerCropBlockSimple("tomato_crop", ModItems.TOMATO_SEEDS);
    public static final CropBlock BASIL_CROP = registerCropBlockSimple("basil_crop", ModItems.BASIL_SEEDS);
    public static final CropBlock OREGANO_CROP = registerCropBlockSimple("oregano_crop", ModItems.OREGANO_SEEDS);
    public static final CropBlock STRAWBERRY_CROP = registerCropBlockSimple("strawberry_crop", ModItems.STRAWBERRY_SEEDS);
    public static final CropBlock OAT_CROP = registerCropBlockSimple("oat_crop", ModItems.OAT_SEEDS);
    public static final CropBlock JALAPENO_CROP = registerCropBlockSimple("jalapeno_crop", ModItems.JALAPENO_SEEDS);
    public static final CropBlock CHILI_CROP = registerCropBlockSimple("chili_crop", ModItems.CHILI_SEEDS);
    public static final CropBlock CUCUMBER_CROP = registerCropBlockSimple("cucumber_crop", ModItems.CUCUMBER_SEEDS);
    public static final CropBlock ONION_CROP = registerCropBlockSimple("onion_crop", ModItems.ONION_SEEDS);
    public static final CropBlock LEEK_CROP = registerCropBlockSimple("leek_crop", ModItems.LEEK_SEEDS);
    public static final CropBlock CELERY_CROP = registerCropBlockSimple("celery_crop", ModItems.CELERY_SEEDS);
    public static final CropBlock PEAS_CROP = registerCropBlockSimple("peas_crop", ModItems.PEAS_SEEDS);
    public static final CropBlock SWEET_POTATO_CROP = registerCropBlockSimple("sweet_potato_crop", ModItems.SWEET_POTATO_SEEDS);
    public static final CropBlock ASPARAGUS_CROP = registerCropBlockSimple("asparagus_crop", ModItems.ASPARAGUS_SEEDS);
    public static final CropBlock SCALLION_CROP = registerCropBlockSimple("scallion_crop", ModItems.SCALLION_SEEDS);
    public static final CropBlock GARLIC_CROP = registerCropBlockSimple("garlic_crop", ModItems.GARLIC_SEEDS);
    public static final CropBlock CHIVE_CROP = registerCropBlockSimple("chive_crop", ModItems.CHIVE_SEEDS);
    public static final CropBlock BROCCOLI_CROP = registerCropBlockSimple("broccoli_crop", ModItems.BROCCOLI_SEEDS);
    public static final CropBlock CAULIFLOWER_CROP = registerCropBlockSimple("cauliflower_crop", ModItems.CAULIFLOWER_SEEDS);
    public static final CropBlock CORN_CROP = registerCropBlockSimple("corn_crop", ModItems.CORN_SEEDS);
    public static final CropBlock BLACK_PEPPER_CROP = registerCropBlockSimple("black_pepper_crop", ModItems.BLACK_PEPPER_SEEDS);
    public static final CropBlock CABBAGE_CROP = registerCropBlockSimple("cabbage_crop", ModItems.CABBAGE_SEEDS);
    public static final CropBlock BELLPEPPER_CROP = registerCropBlockSimple("bellpepper_crop", ModItems.BELLPEPPER_SEEDS);
    public static final CropBlock TURNIP_CROP = registerCropBlockSimple("turnip_crop", ModItems.TURNIP_SEEDS);
    public static final CropBlock RUTABAGA_CROP = registerCropBlockSimple("rutabaga_crop", ModItems.RUTABAGA_SEEDS);
    public static final CropBlock CANOLA_CROP = registerCropBlockSimple("canola_crop", ModItems.CANOLA_SEEDS);
    public static final CropBlock BARLEY_CROP = registerCropBlockSimple("barley_crop", ModItems.BARLEY_SEEDS);
    public static final CropBlock COTTON_CROP = registerCropBlockSimple("cotton_crop", ModItems.COTTON_SEEDS);
    public static final CropBlock SUGARBEET_CROP = registerCropBlockSimple("sugarbeet_crop", ModItems.SUGARBEET_SEEDS);
    public static final CropBlock RICE_CROP = registerCropBlockSimple("rice_crop", ModItems.RICE_SEEDS);
    public static final CropBlock SUGARCANE_CROP = registerCropBlockSimple("sugarcane_crop", ModItems.SUGARCANE_SEEDS);
    public static final CropBlock SOYBEAN_CROP = registerCropBlockSimple("soybean_crop", ModItems.SOYBEAN_SEEDS);
    public static final CropBlock SPINACH_CROP = registerCropBlockSimple("spinach_crop", ModItems.SPINACH_SEEDS);
    public static final CropBlock ARROWROOT_CROP = registerCropBlockSimple("arrowroot_crop", ModItems.ARROWROOT_SEEDS);
    public static final CropBlock ARTICHOKE_CROP = registerCropBlockSimple("artichoke_crop", ModItems.ARTICHOKE_SEEDS);
    public static final CropBlock BRUSSELS_SPROUTS_CROP = registerCropBlockSimple("brussels_sprouts_crop", ModItems.BRUSSELS_SPROUTS_SEEDS);
    public static final CropBlock CASSAVA_CROP = registerCropBlockSimple("cassava_crop", ModItems.CASSAVA_SEEDS);
    public static final CropBlock EGGPLANT_CROP = registerCropBlockSimple("eggplant_crop", ModItems.EGGPLANT_SEEDS);
    public static final CropBlock SUNFLOWER_CROP = registerCropBlockSimple("sunflower_crop", ModItems.SUNFLOWER_SEEDS);
    public static final CropBlock JICAMA_CROP = registerCropBlockSimple("jicama_crop", ModItems.JICAMA_SEEDS);
    public static final CropBlock KALE_CROP = registerCropBlockSimple("kale_crop", ModItems.KALE_SEEDS);
    public static final CropBlock KOHLRABI_CROP = registerCropBlockSimple("kohlrabi_crop", ModItems.KOHLRABI_SEEDS);
    public static final CropBlock LETTUCE_CROP = registerCropBlockSimple("lettuce_crop", ModItems.LETTUCE_SEEDS);
    public static final CropBlock OKRA_CROP = registerCropBlockSimple("okra_crop", ModItems.OKRA_SEEDS);
    public static final CropBlock PARSNIP_CROP = registerCropBlockSimple("parsnip_crop", ModItems.PARSNIP_SEEDS);
    public static final CropBlock RADISH_CROP = registerCropBlockSimple("radish_crop", ModItems.RADISH_SEEDS);
    public static final CropBlock RHUBARB_CROP = registerCropBlockSimple("rhubarb_crop", ModItems.RHUBARB_SEEDS);

    /*public static final CropBlock RHUBARB_CROP = registerCropBlock("rhubarb_crop",
            new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                    ModItems.RHUBARB_SEEDS));*/


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

    private static CropBlock registerCropBlockSimple(String name, Item item){
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name),
                new CustomCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP),
                name));
    }

    private static SweetBerryBushBlock registerBushBlock(String name, SweetBerryBushBlock block){
        return Registry.register(Registry.BLOCK, new Identifier(Photosynthesis.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + Photosynthesis.MOD_ID);
    }
}
