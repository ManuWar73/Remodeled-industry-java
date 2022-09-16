package remodeledindustry.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import remodeledindustry.entities.bullet.*;
import remodeledindustry.graphics.*;
import remodeledindustry.type.*;
import remodeledindustry.type.shop.*;
import remodeledindustry.world.blocks.campaign.*;
import remodeledindustry.world.blocks.defense.*;
import remodeledindustry.world.blocks.defense.turrets.*;
import remodeledindustry.world.blocks.defense.turrets.pattern.*;
import remodeledindustry.world.blocks.distribution.*;
import remodeledindustry.world.blocks.environment.*;
import remodeledindustry.world.blocks.logic.*;
import remodeledindustry.world.blocks.payloads.*;
import remodeledindustry.world.blocks.power.*;
import remodeledindustry.world.blocks.production.*;
import remodeledindustry.world.blocks.storage.*;
import remodeledindustry.world.blocks.units.*;
import remodeledindustry.world.draw.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

@SuppressWarnings("deprecation")
public class remBlocks{
    //turrets
    public static Block puncher, test;

public static void load() {
  puncher = new ItemTurret("puncher"){{
 requirements(Category.turret, with(Items.copper, 500, Items.graphite, 360, Items.metaglass, 65, Items.phaseFabric, 65));

 reload = 1f;
            range = 240f;
            recoil = 2f;
            size = 3;
            shoot.shots = 2;
            shoot.shotDelay = 1f;
            health = 140 * size * size;
            shootY = 2f;
            coolant = consume(consumeCoolant(1f));
            coolantMultiplier = 0.4f;
            shoot.type = ShootAlternate;
            shoot.barrels = 2;
            shoot.spread = 2;
  }};
 test = new ItemTurret("test"){{
 requirements(Category.turret, with(Items.copper, 500, Items.graphite, 360, Items.metaglass, 65, Items.phaseFabric, 65));

 reload = 1f;
            range = 240f;
            recoil = 2f;
            size = 3;
            shoot.shots = 2;
            shoot.shotDelay = 1f;
            health = 140 * size * size;
            shootY = 2f;
            coolant = consume(consumeCoolant(1f));
            coolantMultiplier = 0.4f;
            shoot.type = ShootAlternate;
            shoot.barrels = 2;
            shoot.spread = 2;
  }};
}
}