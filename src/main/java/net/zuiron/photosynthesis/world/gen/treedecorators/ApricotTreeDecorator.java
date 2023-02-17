
package net.zuiron.photosynthesis.world.gen.treedecorators;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

public class ApricotTreeDecorator extends TreeDecorator {
    public static final ApricotTreeDecorator INSTANCE = new ApricotTreeDecorator();
    public static final Codec<ApricotTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);
    private ApricotTreeDecorator() {}
    @Override
    protected TreeDecoratorType<?> getType() {
        return Photosynthesis.APRICOT_TREE_DECORATOR;
    }
    @Override
    public void generate(Generator generator) {
        generator.getLeavesPositions().forEach(pos -> {
            Random random = generator.getRandom();
            int chance = random.nextInt(4);

            if(generator.isAir(pos.down()) && chance == 0) {
                generator.replace(pos.offset(Direction.DOWN, 1), ModBlocks.APRICOTTREE_BUSHCROP.getDefaultState());
            }
        });
    }
}
