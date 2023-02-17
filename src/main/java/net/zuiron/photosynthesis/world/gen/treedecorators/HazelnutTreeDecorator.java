
package net.zuiron.photosynthesis.world.gen.treedecorators;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

public class HazelnutTreeDecorator extends TreeDecorator {
    public static final HazelnutTreeDecorator INSTANCE = new HazelnutTreeDecorator();
    public static final Codec<HazelnutTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);
    private HazelnutTreeDecorator() {}
    @Override
    protected TreeDecoratorType<?> getType() {
        return Photosynthesis.HAZELNUT_TREE_DECORATOR;
    }
    @Override
    public void generate(Generator generator) {
        generator.getLeavesPositions().forEach(pos -> {
            Random random = generator.getRandom();
            int chance = random.nextInt(4);

            if(generator.isAir(pos.down()) && chance == 0) {
                generator.replace(pos.offset(Direction.DOWN, 1), ModBlocks.HAZELNUTTREE_BUSHCROP.getDefaultState());
            }
        });
    }
}
