package net.zuiron.photosynthesis.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.block.entity.BaleBlockEntity;
import net.zuiron.photosynthesis.block.entity.KegBlockEntity;
import net.zuiron.photosynthesis.block.entity.MixingBowlBlockEntity;
import net.zuiron.photosynthesis.block.entity.ModBlockEntities;
import net.zuiron.photosynthesis.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class ModBaleBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;
    public ModBaleBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AXIS, Direction.Axis.Y));
    }

    //pillar
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return ModBaleBlock.changeRotation(state, rotation);
    }

    public static BlockState changeRotation(BlockState state, BlockRotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90: {
                switch (state.get(AXIS)) {
                    case X: {
                        return (BlockState)state.with(AXIS, Direction.Axis.Z);
                    }
                    case Z: {
                        return (BlockState)state.with(AXIS, Direction.Axis.X);
                    }
                }
                return state;
            }
        }
        return state;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.handleFallDamage(fallDistance, 0.2f, world.getDamageSources().fall());
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        //TODO - drop itemform BUT. with tag damage based on food left in block.
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BaleBlockEntity) {

                DefaultedList<ItemStack> itemStacks = DefaultedList.of();
                ItemStack baleStack = state.getBlock().asItem().getDefaultStack();

                //NbtCompound nbtCompound = new NbtCompound();
                //nbtCompound.putInt("Damage", 500);
                //baleStack.setNbt(nbtCompound);
                int actualDamage = 1000 - BaleBlockEntity.getDurability((BaleBlockEntity) blockEntity);

                baleStack.setDamage(actualDamage);
                itemStacks.add(baleStack);
                ItemScatterer.spawn(world, pos, itemStacks);

                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    //entity

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BaleBlockEntity(pos, state);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        int actualDamage = (1000-itemStack.getDamage());
        Photosynthesis.LOGGER.info("now: "+actualDamage);

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof BaleBlockEntity) {
            BaleBlockEntity.setDurability((BaleBlockEntity) blockEntity, actualDamage);
        }

        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.BALE, BaleBlockEntity::tick);
    }
}
