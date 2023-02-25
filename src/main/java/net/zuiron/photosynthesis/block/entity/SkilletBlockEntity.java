package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
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
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.custom.SkilletBlock;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.recipe.SkilletRecipe;
import net.zuiron.photosynthesis.screen.SkilletScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SkilletBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    //public static boolean LIT = false;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public ItemStack getRenderStack() {
        if(!this.getStack(0).isEmpty()) {
            return this.getStack(0);
        } else {
            return this.getStack(2);
        }
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
    private int maxProgress = 20; //Crafting Time / The cook time in ticks

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
        nbt.putInt("skillet.cookingTime", maxProgress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("skillet.progress");
        maxProgress = nbt.getInt("skillet.cookingTime");
    }

    private void resetProgress() {
        this.progress = 0;
        syncItems();
    }

    public static void animationTick(World level, BlockPos pos, BlockState state) {
        if (isBlockBelowBurning(level, pos) && level.isClient()) {
            Random random = level.random;
            if (random.nextFloat() < 0.2F) {
                double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double y = (double) pos.getY() + 1.1D;
                double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double motionY = random.nextBoolean() ? 0.015D : 0.005D;
                level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 0.0D, motionY, 0.0D);
            }
            if (state.get(BooleanProperty.of("processing"))) {
                double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double y = (double) pos.getY() + 0.1D;
                double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double motionY = random.nextBoolean() ? 0.015D : 0.005D;
                level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, motionY, 0.0D); //ENCHANTED_HIT
            }
        }
    }


    public static void playSkilletSound(World world, BlockPos blockPos) {
        if(!world.isClient()) {
            world.playSound(
                    null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                    blockPos, // The position of where the sound will come from
                    Photosynthesis.SKILLET_SOUND_EVENT, // The sound that will play, in this case, the sound the anvil plays when it lands.
                    SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                    1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                    1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
            );
        }
    }

    private static int tickCounter = 0;

    public static void loopSkilletSound(World world, BlockPos blockPos) {
        int ticksPerLoop = (int) (2.193 * 20);
        tickCounter++;
        if (tickCounter >= ticksPerLoop) {
            playSkilletSound(world, blockPos);
            tickCounter = 0;
        }
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, SkilletBlockEntity entity) {
        animationTick(world, blockPos, state);

        if(world.isClient()) {
            return;
        }
        boolean isBelowHeat = isBlockBelowBurning(world, blockPos);

        //check see if belowblock is burning, if so. enable hot texture!
        state = (BlockState)state.with(SkilletBlock.LIT, isBelowHeat);
        world.setBlockState(blockPos, state, 3);
        if(isBelowHeat) {
            markDirty(world, blockPos, state);
        }

        if(hasRecipe(entity) && isBelowHeat) {
            entity.progress++;
            state = (BlockState)state.with(SkilletBlock.PROCESSING, true); world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);

            //play sound
            loopSkilletSound(world, blockPos);

            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
                state = (BlockState)state.with(SkilletBlock.PROCESSING, false); world.setBlockState(blockPos, state, 3);
            }
        } else {
            entity.resetProgress();
            state = (BlockState)state.with(SkilletBlock.PROCESSING, false); world.setBlockState(blockPos, state, 3);
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
                if(blockStateBelow.get(Properties.LIT)) {
                    // The furnace below your directional block is currently smelting
                    //TODO -- if we decide to allow campfire, which is unlimited LIT. should we decrease cook time? YES!
                    return true;
                } else if(blockStateBelow.getBlock() == Blocks.CAMPFIRE && blockStateBelow.get(Properties.SIGNAL_FIRE)) {
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

        entity.maxProgress = entity.getWorld().getRecipeManager()
                .getFirstMatch(SkilletRecipe.Type.INSTANCE, inventory, entity.getWorld()).map(SkilletRecipe::getCookTime).orElse(20);
        //Photosynthesis.LOGGER.info("setting cooktime to: " + match.get().getCookTime());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory, match.get().getOutput().getCount())
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty(); //crafts up to a stack.
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int amount) {
        return inventory.getStack(2).getMaxCount() >= inventory.getStack(2).getCount() + amount;
    }
}