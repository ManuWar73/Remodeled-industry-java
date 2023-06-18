package remodeledindustry;

import mindustry.mod.Mod;
import remodeledindustry.content.*;

public class RemodeledIndustry extends Mod{

    @Override
    public void loadContent(){
        RemUnits.load();
        RemTurrets.load();
    };
}
