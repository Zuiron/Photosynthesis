package net.zuiron.photosynthesis.mixin;

import net.zuiron.photosynthesis.Photosynthesis;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class PhotosynthesisMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		Photosynthesis.LOGGER.info("This line is printed by Photosynthesis mixin!");
	}
}
