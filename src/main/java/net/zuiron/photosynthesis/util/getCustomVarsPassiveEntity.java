package net.zuiron.photosynthesis.util;

public interface getCustomVarsPassiveEntity {
    int getMod_Water();
    int getMod_Water_max();
    void setMod_Water(int amount);


    int getMod_Grass();
    int getMod_Grass_max();
    void setMod_Grass(int amount);


    int getMod_Hay();
    int getMod_Hay_max();
    void setMod_Hay(int amount);



    int getMod_Straw();
    int getMod_Straw_max();
    void setMod_Straw(int amount);



    int getMod_Food();
    int getMod_Food_max();
    void setMod_Food(int amount);

    long getMod_LivingTicks();
    void addMod_LivingTicks(long amount);
}
