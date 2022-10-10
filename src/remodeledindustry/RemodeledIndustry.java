package remodeledindustry;

import mindustry.mod.Mod;
import remodeledindustry.content.remBlocks;
import remodeledindustry.content.remBullets;

public class RemodeledIndustry extends Mod{

    @Override
    public void loadContent(){
        remBlocks.load();
        remBullets.load();
    }
}
