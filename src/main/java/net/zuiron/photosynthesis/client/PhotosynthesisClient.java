package net.zuiron.photosynthesis.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.impl.ModContainerImpl;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.fluid.Fluids;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.block.entity.ModBlockEntities;
import net.zuiron.photosynthesis.block.entity.client.*;
import net.zuiron.photosynthesis.event.ClientPlayConnectionJoin;
import net.zuiron.photosynthesis.event.KeyInputHandler;
import net.zuiron.photosynthesis.fluid.ModFluids;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.screen.*;
import net.fabricmc.fabric.api.resource.*;

import java.util.Optional;

@SuppressWarnings("unused")
public class PhotosynthesisClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        // Optional Resource Pack - 3D Models (may cause lag on lower end pc's, So we pack it optionally)
        //DISCONTINUED
        /*FabricLoader.getInstance().getModContainer(Photosynthesis.MOD_ID).ifPresent(modContainer -> {
            ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(Photosynthesis.MOD_ID,
                    "photosynthesis3d"),
                    modContainer,
                    Text.of("Photosynthesis 3D"),
                    ResourcePackActivationType.NORMAL);
        });*/

        FabricLoader.getInstance().getModContainer(Photosynthesis.MOD_ID).ifPresent(modContainer -> {
            ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(Photosynthesis.MOD_ID,
                            "photosynthesis32xhd"),
                    modContainer,
                    Text.of("Photosynthesis 32x HD"),
                    ResourcePackActivationType.NORMAL);
        });

        HudRenderCallback.EVENT.register(new ThirstHudOverlay());
        HudRenderCallback.EVENT.register(new SeasonsHudOverlay());
        KeyInputHandler.register();
        ClientPlayConnectionEvents.JOIN.register(new ClientPlayConnectionJoin());


        // DECORATION --------------------------------------------------------------------------------------------------
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.TALL_BEACHGRASS);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BEACHGRASS);

        // FLOWERS -----------------------------------------------------------------------------------------------------
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.FLORAMELISSIA);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.POTTED_FLORAMELISSIA);


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
        //BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BLACK_PEPPER_CROP);
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
        //BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GRAPE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PARSLEY_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MINT_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PINEAPPLE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HOP_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.FILIPENDULA_CROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CAMELLIA_SINENSIS_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.NICOTIANA_RUSTICA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PAPAVER_SOMNIFERUM_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ERYTHROXYLUM_COCA_CROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CACTUS_FRUIT_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CANTALOUPE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.FLAX_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.JUTE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.KENAF_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SISAL_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.AMARANTH_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BEAN_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHICKPEA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LENTIL_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.QUINOA_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEANUT_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.TARO_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.TOMATILLO_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.AGAVE_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GINGER_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SESAME_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MUSTARD_CROP);



        // TREE's ------------------------------------------------------------------------------------------------------
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.APPLETREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.APPLETREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.APPLETREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BANANATREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BANANATREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BANANATREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CINNAMON_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CINNAMON_SAPLING);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ORANGETREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ORANGETREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ORANGETREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEARTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEARTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEARTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COCONUTTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COCONUTTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.COCONUTTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.AVOCADOTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.AVOCADOTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.AVOCADOTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHERRYTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHERRYTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHERRYTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LEMONTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LEMONTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LEMONTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MANGOTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MANGOTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MANGOTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.OLIVETREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.OLIVETREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.OLIVETREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RUBBERTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RUBBERTREE_SAPLING);










        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CANDLENUTTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CANDLENUTTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CANDLENUTTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHESTNUTTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHESTNUTTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHESTNUTTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.NUTMEGTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.NUTMEGTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.NUTMEGTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEACHTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEACHTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEACHTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PLUMTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PLUMTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PLUMTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.WALNUTTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.WALNUTTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.WALNUTTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HAZELNUTTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HAZELNUTTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HAZELNUTTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PAWPAWTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PAWPAWTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PAWPAWTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SOURSOPTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SOURSOPTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SOURSOPTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ALMONDTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ALMONDTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.ALMONDTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.APRICOTTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.APRICOTTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.APRICOTTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CASHEWTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CASHEWTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CASHEWTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DATETREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DATETREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DATETREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DRAGONFRUITTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DRAGONFRUITTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DRAGONFRUITTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DURIANTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DURIANTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DURIANTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.FIGTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.FIGTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.FIGTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GRAPEFRUITTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GRAPEFRUITTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GRAPEFRUITTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LIMETREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LIMETREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LIMETREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PAPAYATREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PAPAYATREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PAPAYATREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PECANTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PECANTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PECANTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PERSIMMONTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PERSIMMONTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PERSIMMONTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PISTACHIOTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PISTACHIOTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PISTACHIOTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.POMEGRANATETREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.POMEGRANATETREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.POMEGRANATETREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.STARFRUITTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.STARFRUITTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.STARFRUITTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BREADFRUITTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BREADFRUITTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BREADFRUITTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GUAVATREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GUAVATREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GUAVATREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.JACKFRUITTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.JACKFRUITTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.JACKFRUITTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LYCHEETREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LYCHEETREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LYCHEETREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PASSIONFRUITTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PASSIONFRUITTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PASSIONFRUITTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RAMBUTANTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RAMBUTANTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RAMBUTANTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.TAMARINDTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.TAMARINDTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.TAMARINDTREE_BUSHCROP);


        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MAPLETREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MAPLETREE_SAPLING);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEPPERCORNTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEPPERCORNTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PEPPERCORNTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.VANILLABEANTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.VANILLABEANTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.VANILLABEANTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PINENUTTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PINENUTTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PINENUTTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GOOSEBERRYTREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GOOSEBERRYTREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GOOSEBERRYTREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GRAPETREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GRAPETREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.GRAPETREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RED_GRAPETREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RED_GRAPETREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RED_GRAPETREE_BUSHCROP);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.KIWITREE_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.KIWITREE_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.KIWITREE_BUSHCROP);




        // BERRY BUSHES ------------------------------------------------------------------------------------------------
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BLUEBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BLACKBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.RASPBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CLOUDBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.WILD_STRAWBERRY_BUSH);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LINGONBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CRANBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.HUCKLEBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.JUNIPERBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MULBERRY_BUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.LATEX_EXTRACTOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MAPLE_EXTRACTOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PLATE);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.TOOLRACK);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DRYINGNET);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.DRYINGRACK);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.WOOD_FIRED_STOVE);

        HandledScreens.register(ModScreenHandlers.CUTTING_BOARD_SCREEN_HANDLER, CuttingBoardScreen::new);
        HandledScreens.register(ModScreenHandlers.MORTAR_SCREEN_HANDLER, MortarScreen::new);
        HandledScreens.register(ModScreenHandlers.LATEX_EXTRACTOR_SCREEN_HANDLER, LatexExtractorScreen::new);
        HandledScreens.register(ModScreenHandlers.MAPLE_EXTRACTOR_SCREEN_HANDLER, MapleExtractorScreen::new);
        HandledScreens.register(ModScreenHandlers.SKILLET_SCREEN_HANDLER, SkilletScreen::new);
        HandledScreens.register(ModScreenHandlers.MIXINGBOWL_SCREEN_HANDLER, MixingBowlScreen::new);
        HandledScreens.register(ModScreenHandlers.COOKINGPOT_SCREEN_HANDLER, CookingPotScreen::new);
        HandledScreens.register(ModScreenHandlers.KEG_SCREEN_HANDLER, KegScreen::new);
        HandledScreens.register(ModScreenHandlers.FLUID_PRESS_SCREEN_HANDLER, FluidPressScreen::new);
        HandledScreens.register(ModScreenHandlers.MILKSEPERATOR_SCREEN_HANDLER, MilkSeperatorScreen::new);
        HandledScreens.register(ModScreenHandlers.PLATE_SCREEN_HANDLER, PlateScreen::new);
        HandledScreens.register(ModScreenHandlers.TOOLRACK_SCREEN_HANDLER, ToolRackScreen::new);
        HandledScreens.register(ModScreenHandlers.SHELF_SCREEN_HANDLER, ShelfScreen::new);
        HandledScreens.register(ModScreenHandlers.DRYINGNET_SCREEN_HANDLER, DryingNetScreen::new);
        HandledScreens.register(ModScreenHandlers.DRYINGRACK_SCREEN_HANDLER, DryingRackScreen::new);
        HandledScreens.register(ModScreenHandlers.SINGLEDOUBLECHEST_SCREEN_HANDLER, SingleDoubleChestScreen::new);
        HandledScreens.register(ModScreenHandlers.WOOD_FIRED_STOVE_SCREEN_HANDLER, WoodFiredStoveScreen::new);
        HandledScreens.register(ModScreenHandlers.WOOD_FIRED_OVEN_SCREEN_HANDLER, WoodFiredOvenScreen::new);
        ModMessages.registerS2CPackets();

        BlockEntityRendererFactories.register(ModBlockEntities.CUTTING_BOARD, CuttingBoardBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.SKILLET, SkilletBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.PLATE, PlateBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.TOOLRACK, ToolRackBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.SHELF, ShelfBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DRYINGNET, DryingNetBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DRYINGRACK, DryingRackBlockEntityRenderer::new);

        //LATEX
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_LATEX, ModFluids.FLOWING_LATEX,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFFFFFFFF
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_LATEX, ModFluids.FLOWING_LATEX);

        //MAPLE
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MAPLE, ModFluids.FLOWING_MAPLE,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"), //minecraft:block/water_still
                        new Identifier("minecraft:block/water_flow"), //minecraft:block/water_flow
                        0xa1ffe1d1
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_MAPLE, ModFluids.FLOWING_MAPLE);

        //MAPLE SYRUP
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MAPLESYRUP, ModFluids.FLOWING_MAPLESYRUP,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"), //minecraft:block/water_still
                        new Identifier("minecraft:block/water_flow"), //minecraft:block/water_flow
                        0xa1dca879
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_MAPLESYRUP, ModFluids.FLOWING_MAPLESYRUP);

        //CANOLAOIL
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_CANOLAOIL, ModFluids.FLOWING_CANOLAOIL,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFFfff1d9
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_CANOLAOIL, ModFluids.FLOWING_CANOLAOIL);

        //SUNFLOWEROIL
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SUNFLOWEROIL, ModFluids.FLOWING_SUNFLOWEROIL,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFFffe7c0
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_SUNFLOWEROIL, ModFluids.FLOWING_SUNFLOWEROIL);

        //MEAD
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MEAD, ModFluids.FLOWING_MEAD,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFF8d532b
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_MEAD, ModFluids.FLOWING_MEAD);

        //MILK
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MILK, ModFluids.FLOWING_MILK,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFFF5F5DC
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_MILK, ModFluids.FLOWING_MILK);

        //MILKCREAM
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MILKCREAM, ModFluids.FLOWING_MILKCREAM,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFFf1ecbf
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_MILKCREAM, ModFluids.FLOWING_MILKCREAM);

        //SKIMMEDMILK
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SKIMMEDMILK, ModFluids.FLOWING_SKIMMEDMILK,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFFFFFFFF
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_SKIMMEDMILK, ModFluids.FLOWING_SKIMMEDMILK);

        //OLIVEOIL
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_OLIVEOIL, ModFluids.FLOWING_OLIVEOIL,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFFe8e474
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_OLIVEOIL, ModFluids.FLOWING_OLIVEOIL);

        //GOATMILK
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_GOATMILK, ModFluids.FLOWING_GOATMILK,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFFF5F5DC
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_GOATMILK, ModFluids.FLOWING_GOATMILK);

        //GOATMILKCREAM
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_GOATMILKCREAM, ModFluids.FLOWING_GOATMILKCREAM,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFFf1ecbf
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_GOATMILKCREAM, ModFluids.FLOWING_GOATMILKCREAM);

        //SKIMMEDGOATMILK
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SKIMMEDGOATMILK, ModFluids.FLOWING_SKIMMEDGOATMILK,
                new SimpleFluidRenderHandler(
                        new Identifier("photosynthesis:block/latex_still"), //minecraft:block/water_still
                        new Identifier("photosynthesis:block/latex_flow"), //minecraft:block/water_flow
                        0xFFFFFFFF
                )); //0xA1E038D0

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_SKIMMEDGOATMILK, ModFluids.FLOWING_SKIMMEDGOATMILK);
    }
}
