package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.zuiron.photosynthesis.Photosynthesis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CropBlock.class)
public abstract class ModCropBlock {
    @Shadow public abstract int getMaxAge();

    @Shadow protected abstract int getAge(BlockState state);

    @Shadow public abstract BlockState withAge(int age);

    //@Inject(method = "randomTick", at = @At("HEAD"))
    @Inject(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/CropBlock;withAge(I)Lnet/minecraft/block/BlockState;", ordinal = 0), cancellable = true)
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        Photosynthesis.LOGGER.info("apply growth?: "+state.getBlock().getTranslationKey());
        //world.setBlockState(pos, this.withAge(this.getAge(state) + 1), 2); //works
        if(state.getBlock().getTranslationKey() == "block.minecraft.wheat") {

        }
        ci.cancel();
        //world.setBlockState(pos, this.withAge(i + 1), 2); //Original MC Code
    }

    /*@Inject(method = "randomTick", at = @At("HEAD"))
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        Photosynthesis.LOGGER.info("test");
    }*/
}
