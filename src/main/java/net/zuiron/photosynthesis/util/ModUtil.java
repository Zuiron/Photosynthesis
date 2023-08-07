package net.zuiron.photosynthesis.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.ModBlocks;

import java.util.Map;
import java.util.Objects;

public class ModUtil {

    public static Boolean doesBlockBelowHaveCreateHeatAndWhichLevelAsString(BlockState blockState, String str) {
        for (Map.Entry<Property<?>, Comparable<?>> entry : blockState.getEntries().entrySet()) {
            if(Objects.equals(getCreateBlazePropertyString(entry), str)) {
                return true;
            }
        }
        return false;
    }

    private static String getCreateBlazePropertyString(Map.Entry<Property<?>, Comparable<?>> entryIn) {
        Property<?> property = entryIn.getKey();
        Comparable<?> comparable = entryIn.getValue();
        String s = Util.getValueAsString(property, comparable);

        if (Objects.equals(property.getName(), "blaze")) {
            return s;
        }

        return "none";
    }

    public static boolean isBlockBelowBurning(World world, BlockPos blockPos) {
        BlockPos blockPosBelow = blockPos.down(); // assuming 'pos' is the BlockPos of your directional block
        BlockState blockStateBelow = world.getBlockState(blockPosBelow); // assuming 'world' is the World object

        if (blockStateBelow.getBlock() == Blocks.FURNACE ||
                blockStateBelow.getBlock() == Blocks.BLAST_FURNACE ||
                blockStateBelow.getBlock() == Blocks.SMOKER ||
                blockStateBelow.getBlock() == ModBlocks.WOOD_FIRED_STOVE ||
                blockStateBelow.getBlock() == ModBlocks.WOOD_FIRED_OVEN ||
                blockStateBelow.getBlock() == Blocks.CAMPFIRE ||
                //smouldering = low heat. fading = medium heat. kindled = high heat. seething = blaze caked.
                Objects.equals(blockStateBelow.getBlock().getTranslationKey(), "block.create.blaze_burner")) {

            // The block below your directional block is a furnace, blast furnace or smoker
            BlockEntity blockEntity = world.getBlockEntity(blockPosBelow);
            //if (furnaceBlockEntity.isBurning()) {
            if(blockStateBelow.contains(Properties.LIT) && blockStateBelow.get(Properties.LIT)) {
                // The furnace below your directional block is currently smelting
                return true;
            } else if(blockStateBelow.getBlock() == Blocks.CAMPFIRE && blockStateBelow.contains(Properties.SIGNAL_FIRE) && blockStateBelow.get(Properties.SIGNAL_FIRE)) {
                return true;
            } else if (ModUtil.doesBlockBelowHaveCreateHeatAndWhichLevelAsString(blockStateBelow, "kindled")) {
                return true;
            }
        }

        return false;
    }
}
