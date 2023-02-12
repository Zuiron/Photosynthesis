package net.zuiron.photosynthesis.item;

import com.google.common.collect.BiMap;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class BarkPeelerSpudItem extends AxeItem {
    public BarkPeelerSpudItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        /*Random random = (Random) new java.util.Random();
        return random.nextInt(max - min) + min;*/
        return Random.createLocal().nextBetween(min, max);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()){
            //tooltip.add(new TranslatableText("tooltip.huntergatherers.flint_knife_shift"));
        }else{
            //tooltip.add(new TranslatableText("tooltip.huntergatherers.flint_knife"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);
        Optional<BlockState> optional = this.getStrippedState(blockState);
        Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(blockState);
        Optional<BlockState> optional3 = Optional.ofNullable((Block)((BiMap) HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get()).get(blockState.getBlock())).map((block) -> {
            return block.getStateWithProperties(blockState);
        });

        ItemStack itemStack = context.getStack();
        Optional<BlockState> optional4 = Optional.empty();
        if (optional.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            optional4 = optional;

            //used on a log.

            //get block which we just stripped
            Block blockStripped = context.getWorld().getBlockState(blockPos).getBlock();

            if(blockStripped == Blocks.OAK_LOG) {
                Block.dropStack(world,blockPos,new ItemStack(ModItems.BARK_OAK,getRandomNumberUsingNextInt(1,3)));
            } else if(blockStripped == Blocks.BIRCH_LOG) {
                Block.dropStack(world,blockPos,new ItemStack(ModItems.BARK_BIRCH,getRandomNumberUsingNextInt(1,3)));
            } else if(blockStripped == Blocks.ACACIA_LOG) {
                Block.dropStack(world,blockPos,new ItemStack(ModItems.BARK_ACACIA,getRandomNumberUsingNextInt(1,3)));
            } else if(blockStripped == Blocks.DARK_OAK_LOG) {
                Block.dropStack(world,blockPos,new ItemStack(ModItems.BARK_DARK_OAK,getRandomNumberUsingNextInt(1,3)));
            } else if(blockStripped == Blocks.SPRUCE_LOG) {
                Block.dropStack(world,blockPos,new ItemStack(ModItems.BARK_SPRUCE,getRandomNumberUsingNextInt(1,3)));
            } else if(blockStripped == Blocks.JUNGLE_LOG) {
                Block.dropStack(world,blockPos,new ItemStack(ModItems.BARK_JUNGLE,getRandomNumberUsingNextInt(1,3)));
            } else if(blockStripped == ModBlocks.CINNAMON_LOG) {
                Block.dropStack(world,blockPos,new ItemStack(ModItems.CINNAMON_RAW,getRandomNumberUsingNextInt(1,3)));
            }

        } else if (optional2.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(playerEntity, 3005, blockPos, 0);
            optional4 = optional2;
        } else if (optional3.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(playerEntity, 3004, blockPos, 0);
            optional4 = optional3;
        }

        if (optional4.isPresent()) {
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos, itemStack);
            }

            world.setBlockState(blockPos, (BlockState)optional4.get(), 11);
            if (playerEntity != null) {
                itemStack.damage(1, playerEntity, (p) -> {
                    p.sendToolBreakStatus(context.getHand());
                });
            }

            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }

    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable((Block)STRIPPED_BLOCKS.get(state.getBlock())).map((block) -> {
            return (BlockState)block.getDefaultState().with(PillarBlock.AXIS, (Direction.Axis)state.get(PillarBlock.AXIS));
        });
    }
}
