package net.zuiron.photosynthesis.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.entity.DryingRackBlockEntity;
import net.zuiron.photosynthesis.block.entity.HayRackBlockEntity;
import net.zuiron.photosynthesis.block.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class HayRackBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty CRAFT_STATE = IntProperty.of("craft_state", 0, 2);

    public HayRackBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(CRAFT_STATE, 0));
    }

    private static VoxelShape SHAPE = Block.createCuboidShape(1, 0, 7, 15, 16, 9);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape SHAPE2 = Block.createCuboidShape(0, 0, 0, 16, 16, 16);
        switch (state.get(FACING)) {
            case NORTH -> SHAPE2 = Block.createCuboidShape(1, 1, 4.5, 15, 17, 11.5);
            case EAST -> SHAPE2 = Block.createCuboidShape(4.5, 1, 1, 11.5, 17, 15);
            case SOUTH -> SHAPE2 = Block.createCuboidShape(1, 1, 4.5, 15, 17, 11.5);
            case WEST -> SHAPE2 = Block.createCuboidShape(4.5, 1, 1, 11.5, 17, 15);
        }
        return SHAPE2;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING,CRAFT_STATE);
    }

    /* BLOCK ENTITY */

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    //on block break. spew out all items inside block.
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof HayRackBlockEntity) {
                ItemScatterer.spawn(world, pos, (HayRackBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = ((HayRackBlockEntity) world.getBlockEntity(pos));

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HayRackBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.HAYRACK, HayRackBlockEntity::tick);
    }
}
