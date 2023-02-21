package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.custom.LatexExtractorBlock;
import net.zuiron.photosynthesis.block.custom.SkilletBlock;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.recipe.CuttingBoardRecipe;
import net.zuiron.photosynthesis.recipe.SkilletRecipe;
import net.zuiron.photosynthesis.screen.CuttingBoardScreenHandler;
import net.zuiron.photosynthesis.screen.SkilletScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SkilletBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    //public static boolean LIT = false;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

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

    public SkilletBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SKILLET, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return SkilletBlockEntity.this.progress;
                    case 1: return SkilletBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: SkilletBlockEntity.this.progress = value; break;
                    case 1: SkilletBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Skillet");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new SkilletScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("skillet.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("skillet.progress");
    }

    private void resetProgress() {
        this.progress = 0;
        syncItems();
    }

    public static void animationTick(World level, BlockPos pos) {
        //level == entity.getWorld()
        if (isBlockBelowBurning(level, pos) && level.isClient()) {
            Random random = level.random;
            if (random.nextFloat() < 0.2F) {
                double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double y = (double) pos.getY() + 1.1D;
                double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double motionY = random.nextBoolean() ? 0.015D : 0.005D;
                //level.addParticle(ModParticleTypes.STEAM.get(), x, y, z, 0.0D, motionY, 0.0D);
                level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 0.0D, motionY, 0.0D);
            }
            if (isBlockBelowBurning(level, pos)) {
                double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double y = (double) pos.getY() + 0.1D;
                double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                /*double motionX = level.random.nextFloat() - 0.5F;
                double motionY = level.random.nextFloat() * 0.5F + 0.2f;
                double motionZ = level.random.nextFloat() - 0.5F;*/
                //level.addParticle(ParticleTypes.SMOKE, x, y, z, motionX, motionY, motionZ); //ENCHANTED_HIT
                double motionY = random.nextBoolean() ? 0.015D : 0.005D;
                level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, motionY, 0.0D); //ENCHANTED_HIT
            }
        }

    }

    public static void tick(World world, BlockPos blockPos, BlockState state, SkilletBlockEntity entity) {
        animationTick(world, blockPos);

        if(world.isClient()) {
            return;
        }
        boolean isBelowHeat = isBlockBelowBurning(world, blockPos);

        //TODO IS NOT WORKING WHY NOT??? NO IDEA
        //state.with(SkilletBlock.LIT, isBelowHeat);
        //state.getBlock().getDefaultState().with(SkilletBlock.LIT, isBelowHeat);
        //world.getBlockState(blockPos).with(SkilletBlock.LIT, isBelowHeat);
        state = (BlockState)state.with(SkilletBlock.LIT, isBelowHeat);
        //BooleanProperty booleanProperty (BlockState)SkilletBlock.LIT;
        //this.world.getBlockState(blockPos).with(SkilletBlock.LIT, isBelowHeat);
        world.setBlockState(blockPos, state, 3);
        //Direction localDir = world.getBlockState(blockPos).get(LatexExtractorBlock.FACING);
        if(isBelowHeat) {
            markDirty(world, blockPos, state);
        }
        //SkilletBlockEntity.LIT = isBelowHeat;
        //state = (BlockState)state.with(SkilletBlock.LIT, isBelowHeat);
        //state.with(SkilletBlock.LIT, isBelowHeat);

        if(hasRecipe(entity) && isBelowHeat) {
            entity.progress++;
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
                if (!world.isClient) {
                    world.playSound(
                            null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                            blockPos, // The position of where the sound will come from
                            SoundEvents.BLOCK_BEEHIVE_SHEAR, // The sound that will play, in this case, the sound the anvil plays when it lands.
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

    private static boolean isBlockBelowBurning(World world, BlockPos blockPos) {
        BlockPos blockPosBelow = blockPos.down(); // assuming 'pos' is the BlockPos of your directional block
        BlockState blockStateBelow = world.getBlockState(blockPosBelow); // assuming 'world' is the World object

        if (blockStateBelow.getBlock() == Blocks.FURNACE || blockStateBelow.getBlock() == Blocks.BLAST_FURNACE || blockStateBelow.getBlock() == Blocks.SMOKER || blockStateBelow.getBlock() == Blocks.CAMPFIRE) {
            // The block below your directional block is a furnace, blast furnace or smoker
            BlockEntity blockEntity = world.getBlockEntity(blockPosBelow);
                //if (furnaceBlockEntity.isBurning()) {
                if(blockStateBelow.get(Properties.LIT) || blockStateBelow.getBlock() == Blocks.CAMPFIRE) {
                    // The furnace below your directional block is currently smelting
                    //TODO -- if we decide to allow campfire, which is unlimited LIT. should we decrease cook time? YES!
                    return true;
                }
        }

        return false;
    }

    private static void craftItem(SkilletBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<SkilletRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(SkilletRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            entity.removeStack(0, 1);
            entity.removeStack(1, 1);
            /*entity.setStack(2, new ItemStack(ModItems.SALT,
                    entity.getStack(2).getCount() + 1));*/


            int recipeOutputCount = recipe.get().getOutput().getCount();
            int outputSlotCount = entity.getStack(2).getCount();

            entity.setStack(2, new ItemStack(recipe.get().getOutput().getItem(), outputSlotCount + recipeOutputCount));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(SkilletBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        /*boolean hasRawSaltInFirstSlot = entity.getStack(1).getItem() == ModItems.RAW_SALT;
        return hasRawSaltInFirstSlot && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, ModItems.SALT);*/

        Optional<SkilletRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(SkilletRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty(); //crafts up to a stack.
        //make it so output has to be empty. (more manual labor) *evil*
        //return inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }
}