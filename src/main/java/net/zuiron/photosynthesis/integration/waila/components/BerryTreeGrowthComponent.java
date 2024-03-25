package net.zuiron.photosynthesis.integration.waila.components;

import mcp.mobius.waila.api.IBlockAccessor;
import mcp.mobius.waila.api.IBlockComponentProvider;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.ITooltip;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.text.Text;

public enum BerryTreeGrowthComponent implements IBlockComponentProvider {
    INSTANCE;

    @Override
    public void appendBody(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config) {
        if (accessor.getBlock() instanceof SweetBerryBushBlock crop) {
            if (accessor.getBlockState().contains(SweetBerryBushBlock.AGE) && accessor.getBlock() != Blocks.SWEET_BERRY_BUSH) {
                addMaturityTooltip(tooltip, accessor.getBlockState().get(SweetBerryBushBlock.AGE) / 3.0F);
            }
        }
    }

    private static void addMaturityTooltip(ITooltip tooltip, float growthValue) {
        growthValue *= 100.0F;
        if (growthValue < 100.0F)
            tooltip.addLine(Text.translatable("tooltip.waila.crop_growth").append(" ").append(String.format("%.0f%%", growthValue)));
        else
            tooltip.addLine(Text.translatable("tooltip.waila.crop_growth").append(" ").append(Text.translatable("tooltip.waila.crop_mature")));
    }
}
