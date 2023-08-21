package net.zuiron.photosynthesis.item.advanced;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WrenchItem extends Item {
    public WrenchItem(Settings settings) {
        super(settings);
    }

    /*@Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            // Retrieve the block state at the specified position
            BlockState blockState = context.getWorld().getBlockState(context.getBlockPos());

            // Retrieve the block from the block state
            Block block = blockState.getBlock();

            if (block instanceof AbstractMachineBlock) {
                AbstractMachineBlock abstractMachineBlock = (AbstractMachineBlock) block;
                if (blockState.contains(ModProperties.SLOT_LOCKED)) {
                    boolean slotLocked = !blockState.get(ModProperties.SLOT_LOCKED);
                    context.getWorld().setBlockState(context.getBlockPos(), blockState.with(ModProperties.SLOT_LOCKED, slotLocked), 2);
                    Objects.requireNonNull(context.getPlayer()).sendMessage(Text.literal("Slot Lock: " + slotLocked));
                }
            }
        }

        return super.useOnBlock(context);
    }*/

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.literal("Changes machine behavior"));
    }
}
