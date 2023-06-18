package remodeledindustry.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.LaserTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;

import static mindustry.type.ItemStack.with;

public class RemTurrets {
    public static Block upbringer;
    public static void load(){
        upbringer = new PowerTurret("upbringer"){{
            localizedName = "Upbringer";
            range = 480;
            reload = 60;
            shootY = 0;
            shootX = 0;
            consumePower(7);
            shoot = new ShootSpread() {{
                shots = 5;
                spread = 27;
            }};
            requirements(Category.turret, with(Items.copper, 60, Items.lead, 70, Items.silicon, 60, Items.titanium, 30)); //Todo Change prices
            size = 3;
             shootType = new BasicBulletType(){{
                 lifetime = 0;
                 damage = 0;
                 despawnEffect = Fx.none;
                 fragBullets = 1;
                 fragVelocityMin= 1;
                 fragVelocityMax = 1;
                 fragLifeMax = 1;
                 fragLifeMin = 1;
                 fragRandomSpread = 0;
                 fragSpread = 0;
                 fragAngle = 180;
                 fragBullet = new BasicBulletType(){{
                     damage = 60;
                     speed = 4f;
                     trailWidth = 4;
                     lifetime = 300;
                     homingRange = 720;
                     homingPower = 0.08f;
                     homingDelay = 30;
                     trailColor = Pal.techBlue;
                     trailLength = 80;
                 }};
            }};
        }};
    }
}
