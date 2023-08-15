package net.zuiron.photosynthesis.mixin.Animals;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.util.getCustomVarsPassiveEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PigEntity.class)
public abstract class ModPigEntity extends AnimalEntity {
    protected ModPigEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void mobTick() {
        int mod_Water = ((getCustomVarsPassiveEntity) this).getMod_Water();
        int mod_Water_max = ((getCustomVarsPassiveEntity) this).getMod_Water_max();

        int mod_Straw = ((getCustomVarsPassiveEntity) this).getMod_Straw();
        int mod_Straw_max = ((getCustomVarsPassiveEntity) this).getMod_Straw_max();

        int mod_Food = ((getCustomVarsPassiveEntity) this).getMod_Food();
        int mod_Food_max = ((getCustomVarsPassiveEntity) this).getMod_Food_max();

        //Food Control -------------------------------------------------------------------------------------------------
        //remove food and waters.
        if(mod_Water > 0)  { ((getCustomVarsPassiveEntity) this).setMod_Water(mod_Water-1); }
        if(mod_Straw > 0)  { ((getCustomVarsPassiveEntity) this).setMod_Straw(mod_Straw-1); }
        if(mod_Food > 0)   { ((getCustomVarsPassiveEntity) this).setMod_Food(mod_Food-1);  }

        float PigProductivity = photosynthesis$getPigProductivity(mod_Water, mod_Water_max, mod_Straw, mod_Straw_max, mod_Food, mod_Food_max);

        //livingTicks
        if(PigProductivity >= 100.0f) {
            ((getCustomVarsPassiveEntity) this).addMod_LivingTicks(1);
        }

        //damage missing water or food.
        if(mod_Water <= 0) {
            this.damage(this.getDamageSources().dryOut(), 2);
        } else if (mod_Food <= 0) {
            this.damage(this.getDamageSources().starve(), 1);
        }

        super.mobTick();
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        long mod_LivingTicks = ((getCustomVarsPassiveEntity) this).getMod_LivingTicks();

        int mod_Water = ((getCustomVarsPassiveEntity) this).getMod_Water();
        int mod_Water_max = ((getCustomVarsPassiveEntity) this).getMod_Water_max();

        int mod_Straw = ((getCustomVarsPassiveEntity) this).getMod_Straw();
        int mod_Straw_max = ((getCustomVarsPassiveEntity) this).getMod_Straw_max();

        int mod_Food = ((getCustomVarsPassiveEntity) this).getMod_Food();
        int mod_Food_max = ((getCustomVarsPassiveEntity) this).getMod_Food_max();

        if (!player.getWorld().isClient()) {

            //get some data.
            if (player.isPlayer()) {
                if (player.getStackInHand(hand).isOf(Items.STICK)) {

                    String entityname = this.getWorld().getEntityById(this.getId()).getName().getString(); //gets name, or if tagged tag name.
                    String string = "Entity: "+entityname + " \n";

                    float PigProductivity = photosynthesis$getPigProductivity(mod_Water, mod_Water_max, mod_Straw, mod_Straw_max, mod_Food, mod_Food_max);

                    string += "LivingTicks: "+mod_LivingTicks+" \n";

                    if(this.isBaby()) {
                        if(PigProductivity >= 100.0f) {
                            string += "Growing: TRUE \n";
                        } else {
                            string += "Growing: FALSE \n";
                        }
                    }

                    string += "Water: "+mod_Water+"/"+mod_Water_max+" \n";
                    string += "Straw: "+mod_Straw+"/"+mod_Straw_max+" \n";
                    string += "Food: "+mod_Food+"/"+mod_Food_max+" \n";
                    string += "Productivity: "+ PigProductivity +"%";


                    player.sendMessage(Text.literal(string),false);
                } else if (player.getStackInHand(hand).isOf(Items.ROTTEN_FLESH)) {
                    //this.mod_Milk = this.mod_Milk_max;
                    ((getCustomVarsPassiveEntity) this).setMod_Food(mod_Food-24000);
                    //((getCustomVarsPassiveEntity) this).setMod_Water(mod_Water-24000);
                    //((getCustomVarsPassiveEntity) this).addMod_LivingTicks(480000);
                    //this.mod_Egg+= 10000;
                }
            }
        }
        super.interactMob(player, hand);
        return ActionResult.SUCCESS;
    }

    @Unique
    public float photosynthesis$getPigProductivity(int mod_Water, int mod_Water_max, int mod_Straw, int mod_Straw_max, int mod_Food, int mod_Food_max) {
        float productivity = 0.0f;

        if(mod_Water >= (mod_Water_max/2)) {
            if(mod_Straw > (mod_Straw_max/2)) { productivity += 50f; }
            if(mod_Food  > (mod_Food_max/2) ) { productivity += 50f; }
        }

        return productivity;
    }
}
