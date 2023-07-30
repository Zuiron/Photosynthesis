package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.block.custom.LatexExtractorBlock;
import net.zuiron.photosynthesis.fluid.ModFluids;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.screen.LatexExtractorScreenHandler;
import net.zuiron.photosynthesis.util.FluidStack;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class LatexExtractorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY); //N#:SLOTS



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
        if(!world.isClient()) {
            sendFluidPacket();
        }

        super.markDirty();
    }

    public final SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            //return FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 2; // 20k mB
            return FluidConstants.BUCKET * 2; // 20k mB
        }

        @Override
        protected void onFinalCommit() {
            markDirty();
            if(!world.isClient()) {
                sendFluidPacket();
            }
        }
    };

    private void sendFluidPacket() {
        PacketByteBuf data = PacketByteBufs.create();
        fluidStorage.variant.toPacket(data);
        data.writeLong(fluidStorage.amount);
        data.writeBlockPos(getPos());

        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
            ServerPlayNetworking.send(player, ModMessages.FLUID_SYNC, data);
        }
    }

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 60;

    public LatexExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LATEX_EXTRACTOR, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return LatexExtractorBlockEntity.this.progress;
                    case 1: return LatexExtractorBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: LatexExtractorBlockEntity.this.progress = value; break;
                    case 1: LatexExtractorBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    public void setFluidLevel(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidStorage.variant = fluidVariant;
        this.fluidStorage.amount = fluidLevel;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Latex Extractor");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        if(!world.isClient()) {
            sendFluidPacket(); //SYNC when we open gui.
        }
        return new LatexExtractorScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("latex_extractor.progress", progress);

        nbt.put("latex_extractor.variant", fluidStorage.variant.toNbt());
        nbt.putLong("latex_extractor.fluid", fluidStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("latex_extractor.progress");

        fluidStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("latex_extractor.variant"));
        fluidStorage.amount = nbt.getLong("latex_extractor.fluid");
    }

    private void resetProgress() {
        this.progress = 0;
        syncItems();
    }


    public static void tick(World world, BlockPos blockPos, BlockState state, LatexExtractorBlockEntity entity) {
        if(world.isClient()) {
            return;
        }

        if(hasRecipe(entity) && canHarvestLatex(world, blockPos, entity)) {
            entity.progress++;
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }

        //if we have a latex bucket in input slot TOP.
        if(hasFluidSourceInSlot(entity)) {
            transferFluidToFluidStorage(entity);
        }

        if(hasEmptyBucketInSlot(entity)) {
            extractFluidAndMakeBucket(entity);
        }
    }

    private static boolean canHarvestLatex(World world, BlockPos blockPos, LatexExtractorBlockEntity entity) {
        Direction localDir = world.getBlockState(blockPos).get(LatexExtractorBlock.FACING);

        if(!world.getBlockState(blockPos.up()).isOf(Blocks.AIR)) {
            return false;
        }
        BlockPos relativeSouth = blockPos.offset(localDir, -1);
        BlockState relSouthState = world.getBlockState(relativeSouth);
        //check if block behind and one up is stripped rubber log.
        BlockPos relativeSouthUp = blockPos.offset(localDir, -1).up();
        BlockState relSouthStateUp = world.getBlockState(relativeSouthUp);

        if (relSouthState.getBlock() == ModBlocks.RUBBERTREE_LOG && relSouthStateUp.getBlock() == ModBlocks.STRIPPED_RUBBERTREE_LOG) {
            return true;
        } else {
            //drop contents
            ItemScatterer.spawn(world, blockPos, entity);
            //remove block
            world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 3);
            //spawn extractor block as drop.
            ItemStack itemStack = new ItemStack(ModBlocks.LATEX_EXTRACTOR);
            ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5, itemStack);
            world.spawnEntity(itemEntity);
        }

        return false;
    }

    private static boolean hasEmptyBucketInSlot(LatexExtractorBlockEntity entity) {
        if(entity.getStack(0).getItem() == Items.BUCKET) {
            return true;
        }
        return false;
    }

    private static void extractFluidAndMakeBucket(LatexExtractorBlockEntity entity) {
        //if(entity.fluidStorage.amount >= 1000 && entity.getStack(1).isEmpty()) {
        if(entity.fluidStorage.amount >= FluidConstants.BUCKET && entity.getStack(1).isEmpty()) {
            ItemStack itemStack = new ItemStack(ModFluids.LATEX_BUCKET);
            //if(extractFluid(entity, 1000)) {
            if(extractFluid(entity, FluidConstants.BUCKET)) {
                //TODO fix, double buckets in slot 0 or more.
                int count = entity.getStack(0).getCount();
                if(count > 1) {
                    entity.getStack(0).setCount(count - 1);
                } else {
                    entity.setStack(0, new ItemStack(Items.AIR));
                }

                entity.setStack(1, itemStack);
            }
        }
    }

    private static boolean extractFluid(LatexExtractorBlockEntity entity, long Amount) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(FluidVariant.of(ModFluids.STILL_LATEX),
                    Amount, transaction);
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }



    private static boolean insertFluid(LatexExtractorBlockEntity entity, long amount) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.insert(FluidVariant.of(ModFluids.STILL_LATEX), amount, transaction);
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    private static void transferFluidToFluidStorage(LatexExtractorBlockEntity entity) {

        if(entity.getStack(1).isEmpty() && canTankAcceptBucketWorth(entity)) {
            //if (insertFluid(entity, FluidStack.convertDropletsToMb(FluidConstants.BUCKET))) {
            if (insertFluid(entity, FluidConstants.BUCKET)) {
                entity.setStack(0, new ItemStack(Items.AIR));
                entity.setStack(1, new ItemStack(Items.BUCKET));
            }
        }
    }

    private static boolean canTankAcceptBucketWorth(LatexExtractorBlockEntity entity) {
        long availableSpace = entity.fluidStorage.getCapacity() - entity.fluidStorage.getAmount();
        //if(availableSpace >= FluidStack.convertDropletsToMb(FluidConstants.BUCKET)) {
        if(availableSpace >= FluidConstants.BUCKET) {
            return true;
        }
        return false;
    }

    private static boolean hasFluidSourceInSlot(LatexExtractorBlockEntity entity) {
        return entity.getStack(0).getItem() == ModFluids.LATEX_BUCKET;
    }

    private static void craftItem(LatexExtractorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        if(hasRecipe(entity)) {
            //entity.removeStack(1, 1); //remove 1 item from stack in slot 1 (input)
            /*entity.setStack(2, new ItemStack(ModItems.SALT,
                    entity.getStack(2).getCount() + 1));*/


            try(Transaction transaction = Transaction.openOuter()) {
                entity.fluidStorage.insert(FluidVariant.of(ModFluids.STILL_LATEX),
                        //FluidStack.convertDropletsToMb(FluidConstants.NUGGET), transaction);
                        FluidConstants.NUGGET, transaction);
                transaction.commit();
            }

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(LatexExtractorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        assert entity.world != null;
        long time = entity.world.getTimeOfDay();
        if(Seasons.isSeasonsEnabled()) {
            if(Objects.equals(Seasons.getSeasonString(Seasons.getCurrentSeason(time)), "Summer")) {
                //only produce latex in summer.
                return true;
            } else return false;
        }
        return true;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        //return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty(); //crafts up to a stack.
        //make it so output has to be empty. (more manual labor) *evil*
        return inventory.getStack(1).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(1).getMaxCount() > inventory.getStack(1).getCount();
    }
}