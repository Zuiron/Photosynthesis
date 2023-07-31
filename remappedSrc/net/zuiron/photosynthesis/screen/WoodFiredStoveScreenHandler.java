package net.zuiron.photosynthesis.screen;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.zuiron.photosynthesis.block.entity.CookingPotBlockEntity;
import net.zuiron.photosynthesis.block.entity.WoodFiredStoveBlockEntity;

public class WoodFiredStoveScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;

    public final WoodFiredStoveBlockEntity blockEntity;

    public WoodFiredStoveScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        //this(syncId, inventory, new SimpleInventory(1));
        this(syncId, inventory, inventory.player.method_48926().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(4));
    }

    //public WoodFiredStoveScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
    public WoodFiredStoveScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity, PropertyDelegate delegate) {
        super(ModScreenHandlers.WOOD_FIRED_STOVE_SCREEN_HANDLER, syncId);
        //checkSize(inventory, 1);
        checkSize(((Inventory) entity), 1);
        //this.inventory = inventory;
        this.inventory = (Inventory)entity;
        this.propertyDelegate = delegate;
        this.blockEntity = (WoodFiredStoveBlockEntity) entity;
        inventory.onOpen(playerInventory.player);

        this.addSlot(new Slot(inventory, 0, 79, 35)); //tool

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }

    /*
        FURNACE
                case 0: {
                    return AbstractFurnaceBlockEntity.this.burnTime;
                }
                case 1: {
                    return AbstractFurnaceBlockEntity.this.fuelTime;
                }
                case 2: {
                    return AbstractFurnaceBlockEntity.this.cookTime;
                }
                case 3: {
                    return AbstractFurnaceBlockEntity.this.cookTimeTotal;

        THIS --> ME
                    case 0: return WoodFiredStoveBlockEntity.this.progress;
                    case 1: return WoodFiredStoveBlockEntity.this.maxProgress;
                    case 2: return WoodFiredStoveBlockEntity.this.burnTime;
                    case 3: return WoodFiredStoveBlockEntity.this.fuelTime;
     */

    public int getFuelProgress() {
        int i = this.propertyDelegate.get(3);
        if (i == 0) {
            i = 200;
        }
        return this.propertyDelegate.get(2) * 13 / i;
    }

    public boolean isBurning() {
        return this.propertyDelegate.get(2) > 0;
    }
}
