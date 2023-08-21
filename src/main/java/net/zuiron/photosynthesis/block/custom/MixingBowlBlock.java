package net.zuiron.photosynthesis.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.entity.MixingBowlBlockEntity;
import net.zuiron.photosynthesis.block.entity.ModBlockEntities;
import net.zuiron.photosynthesis.block.entity.SkilletBlockEntity;
import net.zuiron.photosynthesis.state.property.ModProperties;
import org.jetbrains.annotations.Nullable;

public class MixingBowlBlock extends AbstractMachineBlock implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static BooleanProperty LIT;
    public static BooleanProperty PROCESSING;

    public MixingBowlBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(LIT, false));
        this.setDefaultState(this.stateManager.getDefaultState().with(PROCESSING, false).with(ModProperties.SLOT_LOCKED,false));
    }

    private static VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 15, 5, 15);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
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
        builder.add(new Property[]{FACING, LIT, PROCESSING});
        super.appendProperties(builder);
    }

    /* BLOCK ENTITY */

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MixingBowlBlockEntity) {
                ItemScatterer.spawn(world, pos, (MixingBowlBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        ActionResult as = super.onUse(state, world, pos, player, hand, hit);
        if (!world.isClient && as != ActionResult.SUCCESS) {
            NamedScreenHandlerFactory screenHandlerFactory = ((MixingBowlBlockEntity) world.getBlockEntity(pos));

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MixingBowlBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.MIXINGBOWL, MixingBowlBlockEntity::tick);
    }

    static {
        LIT = Properties.LIT;
        PROCESSING = BooleanProperty.of("processing");
    }
}
