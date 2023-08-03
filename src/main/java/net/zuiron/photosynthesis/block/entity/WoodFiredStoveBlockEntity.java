package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.SharedConstants;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.Util;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.block.custom.WoodFiredStoveBlock;
import net.zuiron.photosynthesis.fluid.ModFluids;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.screen.WoodFiredStoveScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class WoodFiredStoveBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY); //N#:SLOTS



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
            //sendFluidPacket();
        }

        super.markDirty();
    }

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 60;

    int burnTime;
    int fuelTime;

    public WoodFiredStoveBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WOOD_FIRED_STOVE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return WoodFiredStoveBlockEntity.this.progress;
                    case 1: return WoodFiredStoveBlockEntity.this.maxProgress;
                    case 2: return WoodFiredStoveBlockEntity.this.burnTime;
                    case 3: return WoodFiredStoveBlockEntity.this.fuelTime;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: WoodFiredStoveBlockEntity.this.progress = value; break;
                    case 1: WoodFiredStoveBlockEntity.this.maxProgress = value; break;
                    case 2: WoodFiredStoveBlockEntity.this.burnTime = value; break;
                    case 3: WoodFiredStoveBlockEntity.this.fuelTime = value; break;
                }
            }

            public int size() {
                return 4;
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
    } //Wood Fired Stove

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new WoodFiredStoveScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }




    private static boolean isNonFlammableWood(Item item) {
        return item.getRegistryEntry().isIn(ItemTags.NON_FLAMMABLE_WOOD);
    }


    private static void addFuel(Map<Item, Integer> fuelTimes, TagKey<Item> tag, int fuelTime) {
        for (RegistryEntry<Item> registryEntry : Registries.ITEM.iterateEntries(tag)) {
            if (WoodFiredStoveBlockEntity.isNonFlammableWood(registryEntry.value())) continue;
            fuelTimes.put(registryEntry.value(), fuelTime);
        }
    }

    private static void addFuel(Map<Item, Integer> fuelTimes, ItemConvertible item, int fuelTime) {
        Item item2 = item.asItem();
        if (WoodFiredStoveBlockEntity.isNonFlammableWood(item2)) {
            if (SharedConstants.isDevelopment) {
                throw Util.throwOrPause(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item2.getName(null).getString() + " a furnace fuel. That will not work!"));
            }
            return;
        }
        fuelTimes.put(item2, fuelTime);
    }

    private boolean isBurning() {
        return this.burnTime > 0;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("wood_fired_stove.progress", progress);
        nbt.putShort("BurnTime", (short)this.burnTime);
        nbt.putShort("FuelTime", (short)this.fuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("wood_fired_stove.progress");
        this.burnTime = nbt.getShort("BurnTime");
        //this.fuelTime = this.getFuelTime(this.inventory.get(1));
        this.fuelTime = nbt.getShort("FuelTime");
    }

    private void resetProgress() {
        this.progress = 0;
        syncItems();
    }

    protected int getFuelTime(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        }
        Item item = fuel.getItem();
        return AbstractFurnaceBlockEntity.createFuelTimeMap().getOrDefault(item, 0);
    }

    public static boolean canUseAsFuel(ItemStack stack) {
        return AbstractFurnaceBlockEntity.createFuelTimeMap().containsKey(stack.getItem());
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        if (slot == 2) {
            return false;
        }
        if (slot == 1) {
            ItemStack itemStack = this.inventory.get(1);
            return WoodFiredStoveBlockEntity.canUseAsFuel(stack) || stack.isOf(Items.BUCKET) && !itemStack.isOf(Items.BUCKET);
        }
        return true;
    }


    public static void tick(World world, BlockPos pos, BlockState state, WoodFiredStoveBlockEntity blockEntity) {
        if(world.isReceivingRedstonePower(pos)) {
            if(state.get(WoodFiredStoveBlock.LIT)) {
                state = (BlockState) state.with(WoodFiredStoveBlock.LIT, false);
                world.setBlockState(pos, state, Block.NOTIFY_ALL);
            }
            return;
        } else {
            if(!state.get(WoodFiredStoveBlock.LIT) && blockEntity.isBurning()) {
                state = (BlockState) state.with(WoodFiredStoveBlock.LIT, true);
                world.setBlockState(pos, state, Block.NOTIFY_ALL);
            }
        }

        boolean bl4;
        boolean bl = blockEntity.isBurning();
        boolean bl2 = false;
        if (blockEntity.isBurning()) {
            --blockEntity.burnTime;
        }
        ItemStack itemStack = blockEntity.inventory.get(0);     // this is FUEL itemslot.
        //checks if input slot is !empty
        //boolean bl3 = !blockEntity.inventory.get(0).isEmpty();  // THIS is input slot.
        boolean bl3 = true; //simulates input slot always filled.
        boolean bl5 = bl4 = !itemStack.isEmpty();
        if (blockEntity.isBurning() || bl4 && bl3) {
            //Recipe recipe = bl3 ? (Recipe)blockEntity.matchGetter.getFirstMatch(blockEntity, world).orElse(null) : null;
            int i = blockEntity.getMaxCountPerStack();
            if (!blockEntity.isBurning()) {
                blockEntity.fuelTime = blockEntity.burnTime = blockEntity.getFuelTime(itemStack);
                if (blockEntity.isBurning()) {
                    bl2 = true;
                    if (bl4) {
                        Item item = itemStack.getItem();
                        itemStack.decrement(1);
                        if (itemStack.isEmpty()) {
                            Item item2 = item.getRecipeRemainder();
                            blockEntity.inventory.set(0, item2 == null ? ItemStack.EMPTY : new ItemStack(item2));
                        }
                    }
                }
            }
            if (blockEntity.isBurning()) {
                bl2 = true;
            } else {
                //blockEntity.cookTime = 0;
            }
        }
        if (bl != blockEntity.isBurning()) {
            bl2 = true;
            state = (BlockState)state.with(WoodFiredStoveBlock.LIT, blockEntity.isBurning());
            world.setBlockState(pos, state, Block.NOTIFY_ALL);
        }
        if (bl2) {
            WoodFiredStoveBlockEntity.markDirty(world, pos, state);
        }
    }

    private static void craftItem(WoodFiredStoveBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        if(hasRecipe(entity)) {
            //entity.removeStack(1, 1); //remove 1 item from stack in slot 1 (input)
            /*entity.setStack(2, new ItemStack(ModItems.SALT,
                    entity.getStack(2).getCount() + 1));*/

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(WoodFiredStoveBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }


        return true;
        /*boolean hasRawSaltInFirstSlot = entity.getStack(1).getItem() == ModItems.RAW_SALT;
        return hasRawSaltInFirstSlot && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, ModItems.SALT);*/

        /*
        boolean hasCuttingKnifeInSlot0 = entity.getStack(0).getItem() == ModItems.CUTTING_KNIFE;

        Optional<CuttingBoardRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(CuttingBoardRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem()) && hasCuttingKnifeInSlot0;
         */
    }

}