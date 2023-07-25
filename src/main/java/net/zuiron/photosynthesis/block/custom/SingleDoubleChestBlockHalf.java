package net.zuiron.photosynthesis.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class SingleDoubleChestBlockHalf extends SingleDoubleChestBlock{
    public SingleDoubleChestBlockHalf(Settings settings) {
        super(settings);
    }

    //private static VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        //return SHAPE;
        VoxelShape SHAPE2 = Block.createCuboidShape(0, 0, 0, 16, 16, 16);
        switch (state.get(FACING)) {
            case NORTH -> SHAPE2 = Block.createCuboidShape(0, 0, 8, 16, 16, 16);
            case EAST -> SHAPE2 = Block.createCuboidShape(0, 0, 0, 8, 16, 16);
            case SOUTH -> SHAPE2 = Block.createCuboidShape(0, 0, 0, 16, 16, 8);
            case WEST -> SHAPE2 = Block.createCuboidShape(8, 0, 0, 16, 16, 16);
        }
        return SHAPE2;
    }
}
