package net.zuiron.photosynthesis.mixin.season_weather;

import net.minecraft.block.*;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.particle.ModParticles;
import net.zuiron.photosynthesis.state.property.ModProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LeavesBlock.class)
public abstract class ModLeavesBlock extends Block {
    @Unique
    private static final IntProperty SEASON = ModProperties.SEASON;
    @Unique
    private static final BooleanProperty SNOWY = Properties.SNOWY;

    @Unique
    private static final IntProperty DISTANCE = Properties.DISTANCE_1_7;
    @Unique
    private static final BooleanProperty PERSISTENT = Properties.PERSISTENT;
    @Unique
    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public ModLeavesBlock(Settings settings) {
        super(settings);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onConstructorReturn(Settings settings, CallbackInfo info) {
        if(this.asBlock().getDefaultState().contains(SNOWY)) {
            //this.setDefaultState(this.stateManager.getDefaultState().with(SNOWY, false));
            this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState())
                    .with(DISTANCE, 7))
                    .with(PERSISTENT, false))
                    .with(WATERLOGGED, false)
                    .with(SNOWY, false));
        }
    }

    @Inject(at = @At("HEAD"), method = "hasRandomTicks", cancellable = true)
    public void hasRandomTicks(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
        cir.cancel();
    }
    @Inject(at = @At("HEAD"), method = "randomTick")
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if(Seasons.isSeasonsEnabled()) {
            int season = Seasons.getCurrentSeason(world.getTimeOfDay());
            if(season == 2 && world.getBlockState(pos.up()).isOf(Blocks.SNOW) || world.getBlockState(pos.up()).isOf(Blocks.AIR)) {
                if(pos.getY() >= 60) {
                    if(world.getLightLevel(LightType.BLOCK, pos) < 8) { //12, too high, try 8.
                        if(world.getBiomeAccess().getBiome(pos).value().hasPrecipitation()) {
                            world.setBlockState(pos, state.with(SNOWY, true).with(SEASON, season));
                        } else {
                            world.setBlockState(pos, state.with(SNOWY, false).with(SEASON, 0));
                        }
                    } else {
                        world.setBlockState(pos, state.with(SNOWY, false).with(SEASON, season));
                    }
                } else {
                    world.setBlockState(pos, state.with(SNOWY, false).with(SEASON, season));
                }
            } else {
                world.setBlockState(pos, state.with(SNOWY, false).with(SEASON, season));
            }
            if(season != 2) {
                world.setBlockState(pos, state.with(SNOWY, false).with(SEASON,season));
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "appendProperties")
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(SEASON,SNOWY);
    }

    //Fancy particles
    /*
    public static boolean isFaceFullSquare(VoxelShape shape, Direction side) {
        VoxelShape voxelShape = shape.getFace(side);
        return Block.isShapeFullCube(voxelShape);
    }
     */
    @Inject(at = @At("HEAD"), method = "randomDisplayTick", cancellable = true)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random, CallbackInfo ci) {
        if(Seasons.isSeasonsEnabled() && !state.isOf(Blocks.CHERRY_LEAVES)) {
            super.randomDisplayTick(state, world, pos, random);
            if (random.nextInt(10) != 0) {
                return;
            }
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (Block.isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
                return;
            }

            int season = Seasons.getCurrentSeason(world.getTimeOfDay());
            if (season == 1) {
                if(state.isOf(Blocks.ACACIA_LEAVES) || state.isOf(Blocks.BIRCH_LEAVES) || state.isOf(ModBlocks.CHERRYTREE_LEAVES)) {
                    ParticleUtil.spawnParticle(world, pos, random, ModParticles.YELLOW_FALLING_LEAVES);
                } else if(state.isOf(Blocks.OAK_LEAVES) || state.isOf(Blocks.DARK_OAK_LEAVES) || state.isOf(ModBlocks.MAPLETREE_LEAVES)) {
                    ParticleUtil.spawnParticle(world, pos, random, ModParticles.ORANGE_FALLING_LEAVES);
                } else {
                    ParticleUtil.spawnParticle(world, pos, random, ModParticles.GREEN_FALLING_LEAVES);
                }
            } else if (season == 3) {
                if(state.isOf(ModBlocks.CHERRYTREE_LEAVES)) {
                    ParticleUtil.spawnParticle(world, pos, random, ParticleTypes.CHERRY_LEAVES);
                }
            }
        }
    }
}
