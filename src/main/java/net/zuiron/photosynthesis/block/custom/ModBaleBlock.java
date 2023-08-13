package net.zuiron.photosynthesis.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
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
            if(newState.getBlock() == ModBlocks.WRAPPED_GRASS_BALE) {
                return;
            }
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BaleBlockEntity) {

                DefaultedList<ItemStack> itemStacks = DefaultedList.of();
                ItemStack baleStack = state.getBlock().asItem().getDefaultStack();

                //NbtCompound nbtCompound = new NbtCompound();
                //nbtCompound.putInt("Damage", 500);
                //baleStack.setNbt(nbtCompound);
                int actualDamage = 168000 - BaleBlockEntity.getDurability((BaleBlockEntity) blockEntity);

                baleStack.setDamage(actualDamage);
                itemStacks.add(baleStack);

                //only drop if durability is higher than 0.
                if(BaleBlockEntity.getDurability((BaleBlockEntity) blockEntity) > 0) {
                    ItemScatterer.spawn(world, pos, itemStacks);
                } else {
                    if(!world.isClient()) {
                        world.playSound(null, pos, SoundEvents.BLOCK_GRASS_HIT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    }
                }

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
        int actualDamage = (168000-itemStack.getDamage());
        Photosynthesis.LOGGER.info("now: "+actualDamage);

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof BaleBlockEntity) {
            BaleBlockEntity.setDurability((BaleBlockEntity) blockEntity, actualDamage);
        }

        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient()) {
            return super.onUse(state, world, pos, player, hand, hit);
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        assert blockEntity != null;
        int dmg = BaleBlockEntity.getDurability((BaleBlockEntity) blockEntity);

        if (player.getStackInHand(hand).isOf(ModItems.PLASTIC_WRAP) && state.getBlock() == ModBlocks.GRASS_BALE && dmg == 168000) {
            player.getStackInHand(hand).decrement(1);
            world.setBlockState(pos, ModBlocks.WRAPPED_GRASS_BALE.getDefaultState(), 2);
            world.playSound(null, pos, SoundEvents.BLOCK_WET_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.BALE, BaleBlockEntity::tick);
    }
}
