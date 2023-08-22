package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.custom.DryingNetBlock;
import net.zuiron.photosynthesis.block.custom.GravityPressBlock;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.recipe.GravityPressRecipe;
import net.zuiron.photosynthesis.screen.GravityPressScreenHandler;
import net.zuiron.photosynthesis.state.property.ModProperties;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GravityPressBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY); //N#:SLOTS

    /*public ItemStack getRenderStack() {
        if(this.getStack(2).isEmpty()) {
            return this.getStack(1);
        } else {
            return this.getStack(2);
        }
    }*/

    public ItemStack getRenderStack0() {
        return this.getStack(0);
    }
    public ItemStack getRenderStack1() {
        return this.getStack(1);
    }
    public ItemStack getRenderStack2() {
        return this.getStack(2);
    }

    public void setInventory(DefaultedList<ItemStack> inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            this.inventory.set(i, inventory.get(i));
        }
    }

    public void syncItems() {
        if(!world.isClient()) {
            PacketByteBuf data = PacketByteBufs.create();
            data.writeInt(inventory.size());
            for(int i = 0; i < inventory.size(); i++) {
                data.writeItemStack(inventory.get(i));
            }
            data.writeBlockPos(getPos());

            for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
                ServerPlayNetworking.send(player, ModMessages.ITEM_SYNC, data);
            }
        }
    }

    @Override
    public void markDirty() {
        syncItems();

        super.markDirty();
    }

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 20;

    public GravityPressBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GRAVITYPRESS, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return GravityPressBlockEntity.this.progress;
                    case 1: return GravityPressBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: GravityPressBlockEntity.this.progress = value; break;
                    case 1: GravityPressBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItemsNoConflicts() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("");
    } //Gravity Press

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new GravityPressScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("gravitypress.progress", progress);
        nbt.putInt("gravitypress.cookingTime", maxProgress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("gravitypress.progress");
        maxProgress = nbt.getInt("gravitypress.cookingTime");
    }

    private void resetProgress() {
        this.progress = 0;
        syncItems();
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, GravityPressBlockEntity entity) {
        if(world.isClient()) {
            return;
        }

        if(entity.getStack(2).isEmpty() && state.get(ModProperties.PROGRESS3) != 0 && entity.progress == 0) {
            world.setBlockState(blockPos, state.with(ModProperties.PROGRESS3,0),2);
        }

        if(hasRecipe(entity)) {
            entity.progress++;

            if(entity.progress >= entity.maxProgress && state.get(ModProperties.PROGRESS3) != 2) {
                world.setBlockState(blockPos, state.with(ModProperties.PROGRESS3,2),2);
            }
            if(entity.getStack(2).isEmpty() && entity.progress > (entity.maxProgress/4) && state.get(ModProperties.PROGRESS3) != 1) {
                world.setBlockState(blockPos, state.with(ModProperties.PROGRESS3,1),2);
                if (!world.isClient) {
                    world.playSound(
                            null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                            blockPos, // The position of where the sound will come from
                            SoundEvents.BLOCK_COMPOSTER_READY, // The sound that will play, in this case, the sound the anvil plays when it lands.
                            SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                            1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                            1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                    );
                }
            }

            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
                if (!world.isClient) {
                    world.playSound(
                            null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                            blockPos, // The position of where the sound will come from
                            SoundEvents.BLOCK_WOOD_PLACE, // The sound that will play, in this case, the sound the anvil plays when it lands.
                            SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                            1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                            1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                    );
                }
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }
    }

    private static void craftItem(GravityPressBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<GravityPressRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(GravityPressRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            entity.removeStack(1, 1); //remove 1 item from stack in slot 1 (input)

            int recipeOutputCount = recipe.get().getOutputStack().getCount();
            int outputSlotCount = entity.getStack(2).getCount();

            entity.setStack(2, new ItemStack(recipe.get().getOutputStack().getItem(), outputSlotCount + recipeOutputCount));

            //play sound.
            if (!entity.world.isClient) {
                entity.world.playSound(
                        null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                        entity.pos, // The position of where the sound will come from
                        SoundEvents.BLOCK_WOOD_BREAK, // The sound that will play, in this case, the sound the anvil plays when it lands.
                        SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                        1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                        1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                );
            }

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(GravityPressBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        /*boolean hasRawSaltInFirstSlot = entity.getStack(1).getItem() == ModItems.RAW_SALT;
        return hasRawSaltInFirstSlot && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, ModItems.SALT);*/

        Optional<GravityPressRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(GravityPressRecipe.Type.INSTANCE, inventory, entity.getWorld());

        entity.maxProgress = entity.getWorld().getRecipeManager()
                .getFirstMatch(GravityPressRecipe.Type.INSTANCE, inventory, entity.getWorld()).map(GravityPressRecipe::getCookTime).orElse(20);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory, match.get().getOutputStack().getCount())
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutputStack().getItem());
    }

    private static final int[] INPUT_SLOTS = {0,1};
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(pos).get(GravityPressBlock.FACING);

        if (side == Direction.DOWN) {
            return false;
        }

        if (side == Direction.UP) {
            return isInputSlot(slot);
        }

        //input top, left, back
        return switch (localDir) {
            default -> //NORTH
                    (side.getOpposite() == Direction.NORTH || side.getOpposite() == Direction.WEST) && isInputSlot(slot);
            case EAST ->
                    (side.rotateYClockwise() == Direction.NORTH || side.rotateYClockwise() == Direction.WEST) && isInputSlot(slot);
            case SOUTH ->
                    (side == Direction.NORTH || side == Direction.WEST) && isInputSlot(slot);
            case WEST ->
                    (side.rotateYCounterclockwise() == Direction.NORTH || side.rotateYCounterclockwise() == Direction.WEST) && isInputSlot(slot);
        };
    }

    private boolean isInputSlot(int slot) {
        for (int inputSlot : INPUT_SLOTS) {
            if (slot == inputSlot) {
                return true;
            }
        }
        return false;
    }


    private static final int[] OUTPUT_SLOTS = {2};
    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(GravityPressBlock.FACING);

        if (side == Direction.UP) {
            return false;
        }

        if (side == Direction.DOWN) {
            return isOutputSlot(slot);
        }

        //extract front, right, and down.
        return switch (localDir) {
            default -> (side.getOpposite() == Direction.SOUTH || side.getOpposite() == Direction.EAST) && isOutputSlot(slot);
            case EAST -> (side.rotateYClockwise() == Direction.SOUTH || side.rotateYClockwise() == Direction.EAST) && isOutputSlot(slot);
            case SOUTH -> (side == Direction.SOUTH || side == Direction.EAST) && isOutputSlot(slot);
            case WEST -> (side.rotateYCounterclockwise() == Direction.SOUTH || side.rotateYCounterclockwise() == Direction.EAST) && isOutputSlot(slot);
        };
    }

    private boolean isOutputSlot(int slot) {
        for (int outputSlot : OUTPUT_SLOTS) {
            if (slot == outputSlot) {
                return true;
            }
        }
        return false;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        //return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty(); //crafts up to a stack.
        //make it so output has to be empty. (more manual labor) *evil*
        return inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int amount) {
        return inventory.getStack(2).getMaxCount() >= inventory.getStack(2).getCount() + amount;
    }

    public DefaultedList<ItemStack> getInventoryMod() {
        return this.inventory;
    }
}