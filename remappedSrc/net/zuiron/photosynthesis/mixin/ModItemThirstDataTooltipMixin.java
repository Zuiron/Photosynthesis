package net.zuiron.photosynthesis.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.api.ThirstDataAPI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Item.class)
public abstract class ModItemThirstDataTooltipMixin {
    @Inject(method = "appendTooltip", at = @At("HEAD"))
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        ThirstDataAPI thirstDataAPI = ThirstDataAPI.getThirstDataFor(stack.getItem().getTranslationKey());
        if(thirstDataAPI != null && ThirstDataAPI.isThirstEnabled()) {
            int addThirst = thirstDataAPI.getThirstData();
            int addThirstSat = thirstDataAPI.getThirstSatData();

            int remThirst = thirstDataAPI.getRemThirstData();
            int remThirstSat = thirstDataAPI.getRemThirstSatData();
            //tooltip.add(Text.literal("Plant: ").append(Text.literal(getPlantSeason).styled(style -> style.withColor(getPlantSeasonTextColor))));
            String thirst = "";
            String thirstSat = "";
            String remThirstStr = "";
            String remThirstSatStr = "";

            //THIRST
            for (int i = 0; i < addThirst; i++) {
                thirst = thirst + "\uE001";
            }
            if(addThirst > 0) {
                tooltip.add(Text.literal(thirst));
            }
            //REM THIRST
            for (int i = 0; i < remThirst; i++) {
                remThirstStr = remThirstStr + "\uE005";
            }
            if(remThirst > 0) {
                tooltip.add(Text.literal(remThirstStr));
            }



            //THIRST SAT
            for (int i = 0; i < addThirstSat / 60; i++) {
                thirstSat = thirstSat + "\uE002";
            }
            if(addThirstSat > 0) {
                tooltip.add(Text.literal(thirstSat));
            }
            //REM THIRST SAT
            for (int i = 0; i < remThirstSat / 60; i++) {
                remThirstSatStr = remThirstSatStr + "\uE006";
            }
            if(remThirstSat > 0) {
                tooltip.add(Text.literal(remThirstSatStr));
            }
        } else if (thirstDataAPI == null && ThirstDataAPI.isThirstEnabled() && stack.isFood()) {
            //NO DATA ON ITEM. DO SOMETHING OR NOT?
            /*int remThirst = 1;
            int remThirstSat = 150;
            String remThirstStr = "";
            String remThirstSatStr = "";

            //REM THIRST
            for (int i = 0; i < remThirst; i++) {
                remThirstStr = remThirstStr + "\uE005";
            }
            if(remThirst > 0) {
                tooltip.add(Text.literal(remThirstStr));
            }
            //REM THIRST SAT
            for (int i = 0; i < remThirstSat / 60; i++) {
                remThirstSatStr = remThirstSatStr + "\uE006";
            }
            if(remThirstSat > 0) {
                tooltip.add(Text.literal(remThirstSatStr));
            }*/
        }
    }
}
