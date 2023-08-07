package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoneMealItem.class)
public class ModBoneMealItem {
    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    public void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        //Photosynthesis.LOGGER.info("useOnBlock: "+context.getStack()+", "+context.getBlockPos());
        if(context.getWorld().getBlockState(context.getBlockPos()).isOf(Blocks.GRASS_BLOCK)) {
            //Photosynthesis.LOGGER.info("grass block, not allowed to bonemeal!");
            cir.setReturnValue(ActionResult.PASS);
            cir.cancel();
        }
    }
}
