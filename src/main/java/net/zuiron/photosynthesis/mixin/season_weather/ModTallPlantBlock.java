package net.zuiron.photosynthesis.mixin.season_weather;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.zuiron.photosynthesis.api.Seasons;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TallPlantBlock.class)
public abstract class ModTallPlantBlock extends PlantBlock {
    @Unique
    private static final BooleanProperty SNOWY = Properties.SNOWY;
    private static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;
    public ModTallPlantBlock(Settings settings) {
        super(settings);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onConstructorReturn(Settings settings, CallbackInfo info) {
        if(this.asBlock().getDefaultState().contains(SNOWY)) {
            this.setDefaultState(this.stateManager.getDefaultState().with(SNOWY, false));
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(Seasons.isSeasonsEnabled()) {
            int season = Seasons.getCurrentSeason(world.getTimeOfDay());
            if(state.contains(SNOWY)) {
                if (season == 2) {
                    int light = world.getLightLevel(LightType.BLOCK, pos);
                    if(state.contains(HALF) && state.get(HALF) == DoubleBlockHalf.UPPER) {
                        light = world.getLightLevel(LightType.BLOCK, pos.down());
                    }

                    if(light < 8) {
                        if(pos.getY() >= 60) {
                            if(world.getBiomeAccess().getBiome(pos).value().hasPrecipitation()) {
                                world.setBlockState(pos, state.with(SNOWY, true));
                            } else {
                                world.setBlockState(pos, state.with(SNOWY, false));
                            }
                        } else {
                            world.setBlockState(pos, state.with(SNOWY, false));
                        }
                    } else {
                        world.setBlockState(pos, state.with(SNOWY, false));
                    }
                } else {
                    world.setBlockState(pos, state.with(SNOWY, false));
                }
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "appendProperties")
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(SNOWY);
    }
}
