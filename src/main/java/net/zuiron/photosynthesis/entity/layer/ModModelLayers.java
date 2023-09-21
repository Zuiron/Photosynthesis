package net.zuiron.photosynthesis.entity.layer;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.zuiron.photosynthesis.Photosynthesis;

public class ModModelLayers {
    public static final EntityModelLayer BOAR =
            new EntityModelLayer(new Identifier(Photosynthesis.MOD_ID, "boar"), "main");
    public static final EntityModelLayer ALLIGATOR =
            new EntityModelLayer(new Identifier(Photosynthesis.MOD_ID, "alligator"), "main");
}
