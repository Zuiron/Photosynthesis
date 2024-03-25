package net.zuiron.photosynthesis.integration.waila;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.custom.CropSticksBlock;
import net.zuiron.photosynthesis.integration.waila.components.CropSticksComponent;

import static mcp.mobius.waila.api.TooltipPosition.BODY;

public class WailaPlugin implements IWailaPlugin {

    @Override
    public void register(IRegistrar registrar) {
        registrar.addComponent(CropSticksComponent.INSTANCE, BODY, CropSticksBlock.class);
    }
}
