
package net.zuiron.photosynthesis.world.feature.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.zuiron.photosynthesis.world.feature.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class PassionfruittreeSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.PASSIONFRUITTREE_KEY;
    }
}
