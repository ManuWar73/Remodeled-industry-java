package remodeledindustry.content;

//import remodeledindustry.graphics.*;
//import remodeledindustry.type.*;
//import remodeledindustry.world.blocks.campaign.*;
//import remodeledindustry.world.blocks.defense.*;
//import remodeledindustry.world.blocks.defense.turrets.*;
//import remodeledindustry.world.blocks.defense.turrets.pattern.*;
//import remodeledindustry.world.blocks.distribution.*;
//import remodeledindustry.world.blocks.environment.*;
//import remodeledindustry.world.blocks.logic.*;
//import remodeledindustry.world.blocks.payloads.*;
//import remodeledindustry.world.blocks.power.*;
//import remodeledindustry.world.blocks.production.*;
//import remodeledindustry.world.blocks.storage.*;
//import remodeledindustry.world.blocks.units.*;
//import remodeledindustry.world.draw.*;
import mindustry.content.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.*;
        import mindustry.type.*;
import mindustry.world.*;
        import mindustry.world.blocks.defense.turrets.*;
import remodeledindustry.content.remBullets.*;
import remodeledindustry.entities.bullet.BasicBullet;

import static mindustry.type.ItemStack.*;
public class remBlocks{
    //turrets
    public static Block puncher;

public static void load() {
  puncher = new ItemTurret("puncher"){{
 requirements(Category.turret, with(Items.lead, 80, Items.graphite, 65, Items.titanium, 50));

 reload = 1f;
            range = 240f;
            recoil = 2f;
            size = 6;
            shoot.shots = 2;
            shoot.shotDelay = 1f;
            health = 140 * size * size;
            shootY = 2f;
            coolant = consume(consumeCoolant(1f));
            coolantMultiplier = 0.4f;
            shoot = new ShootAlternate(3.5f);

            shootY = 3f;
            reload = 20f;
            range = 200;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 250;
            inaccuracy = 0f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);

             ammo(
                Items.surgeAlloy, new BasicBulletType(1f, 50f){{
                    lifetime = 40f;
                }}
            );
  }};
  }}