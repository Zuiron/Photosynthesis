package net.zuiron.photosynthesis.util;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.MilkBucketItem;
import net.zuiron.photosynthesis.fluid.ModFluids;

public class FluidUtil {

    public static Fluid getFluidFromBucketItem(Item item) {
        Fluid fluid = Fluids.EMPTY;

        if(item instanceof BucketItem) {
            fluid = ((getFluidFromBucketItemHelper) item).getFluidFromBucketItem();
        } else if (item instanceof MilkBucketItem) {
            fluid = ModFluids.STILL_MILK;
        }

        return fluid;
    }
}
