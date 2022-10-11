package remodeledindustry;

import mindustry.mod.Mod;
import remodeledindustry.content.remBlocks;

public class RemodeledIndustry extends Mod{

    @Override
    public void loadContent(){
        remBlocks.load();
    }
}
