package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.block.custom.ModBaleBlock;
import net.zuiron.photosynthesis.util.getCustomVarsPassiveEntity;

import java.util.List;
import java.util.function.Predicate;

public class BaleBlockEntity extends BlockEntity {
    private int durability = 168000; //max 1000
    public BaleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BALE, pos, state);
    }

    public static int getDurability(BaleBlockEntity baleBlockEntity) {
        return baleBlockEntity.durability;
    }

    public static void setDurability(BaleBlockEntity baleBlockEntity, int durability) {
        baleBlockEntity.durability = durability;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("bale.durability", this.durability);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.durability = nbt.getInt("bale.durability");
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, BaleBlockEntity baleBlockEntity) {
        if(world.isClient()) {
            return;
        }

        Photosynthesis.LOGGER.info("i am ticking. "+blockState.getBlock().getName()+", dura: "+ baleBlockEntity.durability);
        //baleBlockEntity.durability--; //just testing.

        // Get the range in which you want to scan for entities
        double range = 10.0; // Adjust this value as needed

        // Calculate the bounding box around the block position
        Box boundingBox = new Box(
                blockPos.getX() - range, blockPos.getY() - range, blockPos.getZ() - range,
                blockPos.getX() + range, blockPos.getY() + range, blockPos.getZ() + range
        );

        // Look for passiveEntity entities
        Predicate<Entity> entityPredicate = entity -> {
            return entity instanceof PassiveEntity;
        };

        List<Entity> filteredEntities = world.getEntitiesByClass(Entity.class, boundingBox, entityPredicate);
        for (Entity entity : filteredEntities) {

            if(entity instanceof CowEntity) {
                if (blockState.getBlock() == ModBlocks.GRASS_BALE) {
                    int mod_Grass = ((getCustomVarsPassiveEntity) entity).getMod_Grass();
                    int mod_Grass_max = ((getCustomVarsPassiveEntity) entity).getMod_Grass_max();

                    int missing = mod_Grass_max - mod_Grass;

                    if (baleBlockEntity.durability >= missing) {
                        //add missing difference.
                        ((getCustomVarsPassiveEntity) entity).setMod_Grass(mod_Grass + missing);
                        baleBlockEntity.durability -= missing;
                    } else if (baleBlockEntity.durability > 0) {
                        //didnt have enough for missing, but giving rest of durability.
                        ((getCustomVarsPassiveEntity) entity).setMod_Grass(mod_Grass + baleBlockEntity.durability);
                        baleBlockEntity.durability -= baleBlockEntity.durability;
                        world.breakBlock(blockPos, false);
                    } else { world.breakBlock(blockPos, false); } //ehh just in case.
                }
            }



        }
    }
}
