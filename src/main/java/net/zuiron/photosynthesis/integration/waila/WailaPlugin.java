package net.zuiron.photosynthesis.integration.waila;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import net.minecraft.block.CropBlock;
import net.zuiron.photosynthesis.block.custom.CropSticksBlock;
import net.zuiron.photosynthesis.integration.waila.components.FertPestComponent;

import static mcp.mobius.waila.api.TooltipPosition.BODY;

public class WailaPlugin implements IWailaPlugin {

    @Override
    public void register(IRegistrar registrar) {
        registrar.addComponent(FertPestComponent.INSTANCE, BODY, CropSticksBlock.class);
        registrar.addComponent(FertPestComponent.INSTANCE, BODY, CropBlock.class);
    }
}
