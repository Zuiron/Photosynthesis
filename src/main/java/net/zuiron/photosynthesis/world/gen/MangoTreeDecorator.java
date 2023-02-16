package net.zuiron.photosynthesis.world.gen;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;

public class MangoTreeDecorator extends TreeDecorator {
    public static final MangoTreeDecorator INSTANCE = new MangoTreeDecorator();
    public static final Codec<MangoTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);
    private MangoTreeDecorator() {}
    @Override
    protected TreeDecoratorType<?> getType() {
        return Photosynthesis.MANGO_TREE_DECORATOR;
    }
    @Override
    public void generate(Generator generator) {
        generator.getLeavesPositions().forEach(pos -> {
            Random random = generator.getRandom();
            int chance = random.nextInt(4);

            if(generator.isAir(pos.down()) && chance == 0) {
                generator.replace(pos.offset(Direction.DOWN, 1), ModBlocks.MANGOTREE_BUSHCROP.getDefaultState());
            }
        });
    }
}
