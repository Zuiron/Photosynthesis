package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TorchflowerBlock.class)
public abstract class ModTorchflowerBlock extends CropBlock {
    @Unique
    private static final IntProperty AGE = Properties.AGE_7;
    public ModTorchflowerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxAge() {
        return super.getMaxAge();
    }

    @Override
    public BlockState withAge(int age) {
        /*if (age == getMaxAge()) {
            return Blocks.TORCHFLOWER.getDefaultState();
        }*/
        return super.withAge(age);
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

    @Inject(method = "getGrowthAmount", at = @At("HEAD"), cancellable = true)
    protected void getGrowthAmount(World world, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(super.getGrowthAmount(world));
        cir.cancel();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return super.getOutlineShape(state, world, pos, context);
    }
}
