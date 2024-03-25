package net.zuiron.photosynthesis.integration.waila.components;

import mcp.mobius.waila.api.IBlockAccessor;
import mcp.mobius.waila.api.IBlockComponentProvider;
import mcp.mobius.waila.api.IPluginConfig;

import mcp.mobius.waila.api.ITooltip;
import net.minecraft.block.BlockState;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.zuiron.photosynthesis.block.custom.CropSticksBlock;

import java.util.List;

public enum CropSticksComponent implements IBlockComponentProvider {
    INSTANCE;

    @Override
    public void appendBody(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config) {
        BlockState state = accessor.getBlockState();
        
        Text text = Text.translatable("text.photosynthesis.tooltip.waila.organic_fertilizer").append(state.get(CropSticksBlock.MOD_FERTILIZED).toString());
        tooltip.addLine(text);
    }
}
