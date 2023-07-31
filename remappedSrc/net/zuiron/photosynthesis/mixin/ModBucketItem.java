package net.zuiron.photosynthesis.mixin;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.FluidModificationItem;
import net.minecraft.item.Item;
import net.zuiron.photosynthesis.util.getFluidFromBucketItemHelper;
import org.spongepowered.asm.mixin.*;

@Mixin(BucketItem.class)
public abstract class ModBucketItem extends Item implements FluidModificationItem, getFluidFromBucketItemHelper {

    @Mutable
    @Final
    @Shadow
    private final Fluid fluid;
    public ModBucketItem(Settings settings, Fluid fluid) {
        super(settings);
        this.fluid = fluid;
    }

    public Fluid getFluidFromBucketItem() {
        return this.fluid;
    }
}
