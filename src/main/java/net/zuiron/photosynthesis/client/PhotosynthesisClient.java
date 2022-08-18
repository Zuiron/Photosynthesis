package net.zuiron.photosynthesis.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;
import net.zuiron.photosynthesis.block.ModBlocks;

@SuppressWarnings("unused")
public class PhotosynthesisClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // FLOWERS -----------------------------------------------------------------------------------------------------
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.FLORAMELISSIA);

        // CROPS -------------------------------------------------------------------------------------------------------
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.TOMATO_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BASIL_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.OREGANO_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.STRAWBERRY_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.OAT_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.JALAPENO_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHILI_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CUCUMBER_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ONION_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LEEK_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CELERY_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEAS_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SWEET_POTATO_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ASPARAGUS_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SCALLION_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GARLIC_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHIVE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BROCCOLI_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CAULIFLOWER_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CORN_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BLACK_PEPPER_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CABBAGE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BELLPEPPER_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.TURNIP_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RUTABAGA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CANOLA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BARLEY_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COTTON_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SUGARBEET_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RICE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SOYBEAN_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SPINACH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ARROWROOT_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ARTICHOKE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BRUSSELS_SPROUTS_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CASSAVA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.EGGPLANT_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SUNFLOWER_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.JICAMA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.KALE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.KOHLRABI_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LETTUCE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.OKRA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PARSNIP_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RADISH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RHUBARB_CROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MILLET_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RYE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SQUASH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ZUCCHINI_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COFFEA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GRAPE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CAMELLIA_SINENSIS_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.NICOTIANA_RUSTICA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PAPAVER_SOMNIFERUM_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ERYTHROXYLUM_COCA_CROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SATIVA_COLUMBIAN_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SATIVA_SOUR_DIESEL_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SATIVA_NEPALESE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SATIVA_THAI_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SATIVA_SUPER_SILVER_HAZE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SATIVA_OAXACAN_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.INDICA_ACAPULCO_GOLD_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.INDICA_PURPLE_KUSH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.INDICA_AFGHAN_KUSH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.INDICA_BUBBA_KUSH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.INDICA_LA_CONFIDENTIAL_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.INDICA_NORTHERN_LIGHTS_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYBRID_DURBAN_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYBRID_HINDU_KUSH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYBRID_BLUE_DREAM_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYBRID_MAUI_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYBRID_GOLDEN_GOAT_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYBRID_WHITE_WIDOW_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HYBRID_PINEAPPLE_EXPRESS_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RUDERALIS_SKUNK_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RUDERALIS_DO_SI_DOS_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RUDERALIS_MEMBRANA_HIPER_AUTOFLOWERING_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RUDERALIS_AUTO_MAZAR_CROP);

        // BERRY BUSHES ------------------------------------------------------------------------------------------------
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BLUEBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BLACKBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RASPBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CLOUDBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.WILD_STRAWBERRY_BUSH);
    }
}
