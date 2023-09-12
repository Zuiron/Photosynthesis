package net.zuiron.photosynthesis.mixin.season_weather;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IceBlock;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.api.Seasons;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IceBlock.class)
public abstract class ModIceBlock extends Block {
    public ModIceBlock(Settings settings) {
        super(settings);
    }

    @Shadow protected abstract void melt(BlockState state, World world, BlockPos pos);

    //TODO make it meltable somehow... i think it works?
    @Inject(at = @At("HEAD"), method = "randomTick")
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if(Seasons.isSeasonsEnabled() && this == Blocks.ICE) { //only touch vanilla ice, don't mess with other blocks using IceBlock.
            int season = Seasons.getCurrentSeason(world.getTimeOfDay());
            String seasonString = Seasons.getSeasonString(season);

            if (!seasonString.equals("Winter")) {
                if(!world.getBiome(pos).isIn(BiomeTags.POLAR_BEARS_SPAWN_ON_ALTERNATE_BLOCKS)) {
                    this.melt(state, world, pos);
                }
            }
        }
    }
}
