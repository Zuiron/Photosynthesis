package net.zuiron.photosynthesis.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.zuiron.photosynthesis.block.entity.ModBlockEntities;
import net.zuiron.photosynthesis.block.entity.SeasonsCalendarBlockEntity;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.state.property.ModProperties;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SeasonsCalendarBlock extends BlockWithEntity implements BlockEntityProvider{
    public static final BooleanProperty POWERED = Properties.POWERED;                               //From LeverBlock
    public static IntProperty RPOWER = ModProperties.RPOWER;
    public static IntProperty SEASON = ModProperties.SEASON;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;                    //HorizontalFacingBlock
    public static final EnumProperty<WallMountLocation> FACE = Properties.WALL_MOUNT_LOCATION;      //WallMountedBlock

    protected static final VoxelShape NORTH_WALL_SHAPE = Block.createCuboidShape(1, 1, 15, 15, 15, 16);
    protected static final VoxelShape SOUTH_WALL_SHAPE = Block.createCuboidShape(1, 1, 0, 15, 15, 1);
    protected static final VoxelShape EAST_WALL_SHAPE = Block.createCuboidShape(0, 1, 1, 1, 15, 15);
    protected static final VoxelShape WEST_WALL_SHAPE = Block.createCuboidShape(15, 1, 1, 16, 15, 15);
    protected static final VoxelShape FLOOR_Z_AXIS_SHAPE = Block.createCuboidShape(1, 0, 1, 15, 1, 15);
    protected static final VoxelShape FLOOR_X_AXIS_SHAPE = Block.createCuboidShape(1, 0, 1, 15, 1, 15);
    protected static final VoxelShape CEILING_Z_AXIS_SHAPE = Block.createCuboidShape(1, 15, 1, 15, 16, 15);
    protected static final VoxelShape CEILING_X_AXIS_SHAPE = Block.createCuboidShape(1, 15, 1, 15, 16, 15);

    public SeasonsCalendarBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(POWERED, false)).with(FACE, WallMountLocation.WALL));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((WallMountLocation)state.get(FACE)) {
            case FLOOR: {
                switch (state.get(FACING).getAxis()) {
                    case X: {
                        return FLOOR_X_AXIS_SHAPE;
                    }
                }
                return FLOOR_Z_AXIS_SHAPE;
            }
            case WALL: {
                switch (state.get(FACING)) {
                    case EAST: {
                        return EAST_WALL_SHAPE;
                    }
                    case WEST: {
                        return WEST_WALL_SHAPE;
                    }
                    case SOUTH: {
                        return SOUTH_WALL_SHAPE;
                    }
                }
                return NORTH_WALL_SHAPE;
            }
        }
        switch (state.get(FACING).getAxis()) {
            case X: {
                return CEILING_X_AXIS_SHAPE;
            }
        }
        return CEILING_Z_AXIS_SHAPE;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (moved || state.isOf(newState.getBlock())) {
            return;
        }
        if (state.get(POWERED).booleanValue()) {
            this.updateNeighbors(state, world, pos);
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        //return state.get(POWERED) != false ? 15 : 0;
        if (state.get(POWERED).booleanValue()) {
            return state.get(RPOWER);
        }
        return 0;
    }

    //kinda works, but not. so it works. but doesn't update correctly. look at this later, maybe.
    /*@Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        if (state.get(POWERED).booleanValue() && SeasonsCalendarBlock.getDirection(state) == direction) {
            return state.get(RPOWER);
        }
        return 0;
    }*/

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.getStackInHand(hand).isOf(ModItems.WRENCH)) {
            if (world.isClient) {
                BlockState blockState = (BlockState)state.cycle(POWERED);
                if (blockState.get(POWERED).booleanValue()) {
                    SeasonsCalendarBlock.spawnParticles(blockState, world, pos, 1.0f);
                }
                return ActionResult.SUCCESS;
            }
            BlockState blockState = this.togglePower(state, world, pos);
            float f = blockState.get(POWERED) != false ? 0.6f : 0.5f;
            world.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3f, f);
            world.emitGameEvent((Entity)player, blockState.get(POWERED) != false ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
            return ActionResult.CONSUME;
        }
        return ActionResult.FAIL;
    }

    public BlockState togglePower(BlockState state, World world, BlockPos pos) {
        state = (BlockState)state.cycle(POWERED);
        world.setBlockState(pos, state, Block.NOTIFY_ALL);
        this.updateNeighbors(state, world, pos);
        return state;
    }

    private static void spawnParticles(BlockState state, WorldAccess world, BlockPos pos, float alpha) {
        Direction direction = state.get(FACING).getOpposite();
        Direction direction2 = SeasonsCalendarBlock.getDirection(state).getOpposite();
        double d = (double)pos.getX() + 0.5 + 0.1 * (double)direction.getOffsetX() + 0.2 * (double)direction2.getOffsetX();
        double e = (double)pos.getY() + 0.5 + 0.1 * (double)direction.getOffsetY() + 0.2 * (double)direction2.getOffsetY();
        double f = (double)pos.getZ() + 0.5 + 0.1 * (double)direction.getOffsetZ() + 0.2 * (double)direction2.getOffsetZ();
        world.addParticle(new DustParticleEffect(DustParticleEffect.RED, alpha), d, e, f, 0.0, 0.0, 0.0);
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    private void updateNeighbors(BlockState state, World world, BlockPos pos) {
        world.updateNeighborsAlways(pos, this);
        world.updateNeighborsAlways(pos.offset(SeasonsCalendarBlock.getDirection(state).getOpposite()), this);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACE, FACING, POWERED, RPOWER, SEASON);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);
        tooltip.add(Text.translatable("text.photosynthesis.tooltip.seasons_calendar_1"));
        tooltip.add(Text.translatable("text.photosynthesis.tooltip.seasons_calendar_2"));
    }

    //WallMountedBlock -------------------------------------------------------------------------------------------------
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return SeasonsCalendarBlock.canPlaceAt(world, pos, SeasonsCalendarBlock.getDirection(state).getOpposite());
    }

    public static boolean canPlaceAt(WorldView world, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.offset(direction);
        return world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, direction.getOpposite());
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        for (Direction direction : ctx.getPlacementDirections()) {
            BlockState blockState = direction.getAxis() == Direction.Axis.Y ? (BlockState)((BlockState)this.getDefaultState().with(FACE, direction == Direction.UP ? WallMountLocation.CEILING : WallMountLocation.FLOOR)).with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()) : (BlockState)((BlockState)this.getDefaultState().with(FACE, WallMountLocation.WALL)).with(FACING, direction.getOpposite());
            if (!blockState.canPlaceAt(ctx.getWorld(), ctx.getBlockPos())) continue;
            return blockState;
        }
        return null;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (SeasonsCalendarBlock.getDirection(state).getOpposite() == direction && !state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    protected static Direction getDirection(BlockState state) {
        switch (state.get(FACE)) {
            case CEILING: {
                return Direction.DOWN;
            }
            case FLOOR: {
                return Direction.UP;
            }
        }
        return state.get(FACING);
    }
    //------------------------------------------------------------------------------------------------------------------

    //HorizontalFacingBlock --------------------------------------------------------------------------------------------
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
    //------------------------------------------------------------------------------------------------------------------

    //BlockWithEntity --------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SeasonsCalendarBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.SEASONSCALENDAR, SeasonsCalendarBlockEntity::tick);
    }
    //------------------------------------------------------------------------------------------------------------------
}
