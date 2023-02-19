package net.zuiron.photosynthesis.block.custom;

import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class LatexExtractorBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public LatexExtractorBlock(Settings settings) {
        super(settings);
    }

    private static VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        //if(world.getBlockState(pos.up(-1)).isOf(Blocks.DIRT) && world.getFluidState(pos.up(0)).isOf(Fluids.WATER) && world.getBlockState(pos.up(1)).isOf(Blocks.AIR))

        //check if blocks above is air.
        if(world.getBlockState(pos.up()).isOf(Blocks.AIR)) {
            //check if block behind is rubbertree.
            BlockPos relativeSouth = pos.offset(state.get(FACING), -1);
            BlockState relSouthState = world.getBlockState(relativeSouth);
            //check if block behind and one up is stripped rubber log.
            BlockPos relativeSouthUp = pos.offset(state.get(FACING), -1).up();
            BlockState relSouthStateUp = world.getBlockState(relativeSouthUp);

            if (relSouthState.getBlock() == ModBlocks.RUBBERTREE_LOG && relSouthStateUp.getBlock() == ModBlocks.STRIPPED_RUBBERTREE_LOG) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
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
        builder.add(FACING);
    }
}
