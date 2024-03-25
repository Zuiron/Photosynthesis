package net.zuiron.photosynthesis.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.block.entity.CropSticksBlockEntity;
import net.zuiron.photosynthesis.block.entity.ModBlockEntities;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.state.property.ModProperties;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Unique;

import java.util.List;

public class CropSticksBlock extends BlockWithEntity implements BlockEntityProvider, Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    private static VoxelShape SHAPE = Block.createCuboidShape(3, -1, 3, 13, 10, 13);
    public CropSticksBlock(Settings settings) {
        super(settings);

        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.WATERLOGGED, false)
                .with(MOD_FERTILIZED, 0)
                .with(MOD_PESTICIDED,0)
        );
    }

    @Unique
    private static final IntProperty MOD_FERTILIZED = ModProperties.MOD_FERTILIZED;

    @Unique
    private static final IntProperty MOD_PESTICIDED = ModProperties.MOD_PESTICIDED;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{Properties.WATERLOGGED}).add(ModProperties.MOD_FERTILIZED).add(ModProperties.MOD_PESTICIDED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(state.contains(ModProperties.MOD_PESTICIDED) && state.contains(ModProperties.MOD_FERTILIZED)) {
            //Is item fertilizer
            if (player.getStackInHand(hand).isOf(ModItems.MANURE)) {
                if (state.get(MOD_FERTILIZED) < 2) {
                    world.setBlockState(pos, state.with(MOD_FERTILIZED, state.get(MOD_FERTILIZED) + 1), 2);
                    player.getStackInHand(hand).decrement(1);
                    BoneMealItem.createParticles(world, pos, 20);
                    world.playSoundAtBlockCenter(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                    return ActionResult.SUCCESS;
                }
            }
            //Or is it pesticide
            else if (player.getStackInHand(hand).isOf(ModItems.SULFUR_DUST)) {
                if (state.get(MOD_PESTICIDED) < 1) {
                    world.setBlockState(pos, state.with(MOD_PESTICIDED, 1), 2);
                    player.getStackInHand(hand).decrement(1);
                    BoneMealItem.createParticles(world, pos, 20);
                    world.playSoundAtBlockCenter(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(Properties.WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public static BlockState withWaterloggedState(WorldView world, BlockPos pos, BlockState state) {
        return state.contains(Properties.WATERLOGGED) ? (BlockState)state.with(Properties.WATERLOGGED, world.isWater(pos)) : state;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        //if(world.getBlockState(pos.up(-1)).isOf(Blocks.DIRT) && world.getFluidState(pos.up(0)).isOf(Fluids.WATER) && world.getBlockState(pos.up(1)).isOf(Blocks.AIR))

        //check if blocks above is air.
        if(world.getBlockState(pos.up()).isOf(Blocks.AIR)) {
            if(world.getBlockState(pos.down()).isOf(Blocks.FARMLAND)) {
                return true;
            } else if (world.getBlockState(pos).isOf(Blocks.WATER) && world.getBlockState(pos.down()).isOf(Blocks.DIRT)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CropSticksBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.CROPSTICKS, CropSticksBlockEntity::tick);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("text.photosynthesis.tooltip.cropsticks"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
