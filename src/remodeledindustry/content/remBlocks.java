package remodeledindustry.content;
import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion.*;
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
import remodeledindustry.entities.bullet.*;
import remodeledindustry.entities.bullet.ContinuousDamageBulletType;

import static mindustry.type.ItemStack.*;
public class remBlocks{
    //turrets
    public static Block puncher, devilsknife;

public static void load() {
  puncher = new ItemTurret("puncher"){{
 requirements(Category.turret, with(Items.thorium, 80, Items.graphite, 65, Items.beryllium, 50));
            recoil = 2f;
            size = 6;
            coolantMultiplier = 0.4f;
            shoot = new ShootAlternate(8f);

            shootY = 3f;
            reload = 10f;
            range = 160;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 100 * size * size;
            inaccuracy = 0f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);

             ammo(
                Items.surgeAlloy, new BasicBulletType(4f, 50f){{
                    lifetime = 40;
                }}
            );
  }};
  devilsknife = new ItemTurret("Deltarune turret 1"){{
requirements(Category.turret, with(Items.thorium, 500));
size = 5;
health = 1000;
reload = 240;
shoot = new ShootBarrel(){{
    barrels = new float[] {
            0, 0, 0, 0, 0, 90, 0, 0, 180, 0, 0, 270
    };
    shots = 4;
}};
      ammo(
              Items.thorium, new DevilsKnife(3f, 150f){{
range = 340;
        lifetime = 120;
        fragRandomSpread = 0;
        fragAngle = 180;
        fragBullets = 1;
        drag = 0.01f;
        fragOnHit = false;
        pierce = true;
        pierceCap = 10000;
        sprite = "ri-devilsknife";
        spin = 7.5f;
        fragVelocityMax = 1f;
        fragVelocityMin = 1f;
        height = 40;
        width = 40;
                  hasColor = false;
                  lightOpacity = 0;
                  lightRadius = 0;
                  hitSize = 30;

        fragBullet = new DevilsKnife(3f, 200f){{
            drag = 0.001f;
            lifetime = 120;
            fragRandomSpread = 0;
            fragAngle = 180;
            fragBullets = 1;
            pierce = true;
            pierceCap = 10000;
            sprite = "ri-devilsknife";
            spin = 7.5f;
            height = 40;
            width = 40;
            hasColor = false;
            lightOpacity = 0;
            lightRadius = 0;
            hitSize = 30;
        }};
              }}
      );
  }};
  }}