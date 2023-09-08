package net.zuiron.photosynthesis.mixin.season_weather;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.state.property.ModProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(GrassBlock.class)
public abstract class ModGrassBlock extends SpreadableBlock {
    @Unique
    private static final IntProperty SEASON = ModProperties.SEASON;

    protected ModGrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(Seasons.isSeasonsEnabled() && this == Blocks.GRASS_BLOCK && state.contains(Properties.SNOWY) && !state.get(Properties.SNOWY)) {
            int season = Seasons.getCurrentSeason(world.getTimeOfDay());
            world.setBlockState(pos, state.with(SEASON, season));
        }
        super.randomTick(state, world, pos, random);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SEASON);
        super.appendProperties(builder);
    }
}
