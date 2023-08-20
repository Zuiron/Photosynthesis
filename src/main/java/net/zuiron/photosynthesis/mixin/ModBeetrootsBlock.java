package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BeetrootsBlock.class)
public abstract class ModBeetrootsBlock extends CropBlock {
    @Unique
    private static final IntProperty AGE = Properties.AGE_7;
    public ModBeetrootsBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxAge() {
        return super.getMaxAge();
    }

    @Inject(method = "getAgeProperty", at = @At("HEAD"), cancellable = true)
    protected void getAgeProperty(CallbackInfoReturnable<IntProperty> cir) {
        //return AGE;
        cir.setReturnValue(AGE);
        cir.cancel();
    }

    @Inject(method = "appendProperties", at = @At("HEAD"), cancellable = true)
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        //builder.add(AGE);
        super.appendProperties(builder);
        ci.cancel();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return super.getOutlineShape(state, world, pos, context);
    }
}
