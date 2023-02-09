package net.zuiron.photosynthesis.world.gen;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

import java.util.List;
import java.util.function.BiConsumer;

public class RichTreeDecorator extends TreeDecorator {
    public static final RichTreeDecorator INSTANCE = new RichTreeDecorator();
    // Our constructor doesn't have any arguments, so we create a unit codec that returns the singleton instance
    public static final Codec<RichTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

    private RichTreeDecorator() {}

    @Override
    protected TreeDecoratorType<?> getType() {
        return Photosynthesis.RICH_TREE_DECORATOR;
    }

    @Override
    public void generate(TreeDecorator.Generator generator) {
        // Iterate through block positions
        //generator.getLogPositions().forEach(pos -> {


        /*generator.getLeavesPositions().forEach(pos -> {
            Random random = generator.getRandom();
            // Pick a value from 0 (inclusive) to 4 (exclusive) and if it's 0, continue
            // This is the chance for spawning the gold block
            if (random.nextInt(4) == 0) {
                // Pick a random value from 0 to 4 and determine the side where the gold block will be placed using it
                int sideRaw = random.nextInt(4);
                Direction side = switch (sideRaw) {
                    case 0 -> Direction.NORTH;
                    case 1 -> Direction.SOUTH;
                    case 2 -> Direction.EAST;
                    case 3 -> Direction.WEST;
                    default -> throw new ArithmeticException("The picked side value doesn't fit in the 0 to 4 bounds");
                };

                // Offset the log position by the resulting side
                //BlockPos targetPosition = logPosition.offset(side, 1);
                //BlockPos targetPosition = generator.getLeavesPositions().get(0).offset(side, 1);
                //BlockPos targetPosition = generator.getLeavesPositions().get(0).offset(Direction.DOWN, 1);
                BlockPos targetPosition = generator.getLeavesPositions().get(0).offset(side, 2).offset(Direction.DOWN, 1);

                // Place the gold block using the replacer BiConsumer
                // This is the standard way of placing blocks in TrunkPlacers, FoliagePlacers and TreeDecorators
                //replacer.accept(targetPosition, Blocks.GOLD_BLOCK.getDefaultState());
                generator.replace(targetPosition, Blocks.GOLD_BLOCK.getDefaultState());
            }
        });*/

        generator.getLeavesPositions().forEach(pos -> {
            //case "rice_crop": if(world.getFluidState(pos.up(1)).isOf(Fluids.WATER) && world.getBlockState(pos.up(2)).isOf(Blocks.AIR)) { return true; }
            Random random = generator.getRandom();
            int chance = random.nextInt(10);

            if(generator.isAir(pos.down()) && chance == 0) {
                //generator.replace(pos.offset(Direction.DOWN, 1), Blocks.GOLD_BLOCK.getDefaultState());
                generator.replace(pos.offset(Direction.DOWN, 1), ModBlocks.APPLETREE_BUSHCROP.getDefaultState());
            }
        });


    }


}
