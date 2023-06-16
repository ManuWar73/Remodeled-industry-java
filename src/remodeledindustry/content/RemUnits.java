package remodeledindustry.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.gen.Sounds;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.world.meta.BlockFlag;

public class RemUnits {
    public static UnitType teeclipse;
    public void load(){
        teeclipse = new UnitType("thousand-embers-eclipse"){{
            localizedName = "Thousand Embers Eclipse";
            speed = 0.74f;
            accel = 0.04f;
            drag = 0.04f;
            rotateSpeed = 1f;
            flying = true;
            lowAltitude = true;
            health = 18000;
            engineOffset = 38;
            engineSize = 7.3f;
            hitSize = 58f;
            armor = 11f;
            targetFlags = new BlockFlag[]{BlockFlag.reactor, BlockFlag.battery, BlockFlag.core, null};
            ammoType = new ItemAmmoType(Items.thorium);

            BulletType fragBullet = new FlakBulletType(8f, 30){{
                shootEffect = Fx.shootBig;
                ammoMultiplier = 4f;
                splashDamage = 80f;
                makeFire = true;
                splashDamageRadius = 25f;
                collidesGround = true;
                lifetime = 23.5f;

                status = StatusEffects.melting;
                statusDuration = 60f;
            }};

            weapons.add(
                    new Weapon("remodeled-ind-te-large-laser-mount"){{
                        shake = 4f;
                        shootY = 9f;
                        x = 18f;
                        y = 5f;
                        rotateSpeed = 2f;
                        reload = 45f;
                        recoil = 4f;
                        shootSound = Sounds.laser;
                        shadow = 20f;
                        rotate = true;

                        bullet = new LaserBulletType(){{
                            damage = 215f;
                            sideAngle = 20f;
                            sideWidth = 1.5f;
                            sideLength = 80f;
                            makeFire = true;
                            width = 25f;
                            length = 230f;
                            shootEffect = Fx.shockwave;
                            colors = new Color[]{Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                        }};
                    }},
                    new Weapon("remodeled-ind-te-large-artillery"){{
                        x = 11f;
                        y = 27f;
                        rotateSpeed = 2f;
                        reload = 9f;
                        shootSound = Sounds.shoot;
                        shadow = 7f;
                        rotate = true;
                        recoil = 0.5f;
                        shootY = 7.25f;
                        bullet = fragBullet;
                    }},
                    new Weapon("remodeled-ind-te-large-artillery"){{
                        y = -13f;
                        x = 20f;
                        reload = 12f;
                        ejectEffect = Fx.casing1;
                        rotateSpeed = 7f;
                        shake = 1f;
                        shootSound = Sounds.shoot;
                        rotate = true;
                        shadow = 12f;
                        shootY = 7.25f;
                        bullet = fragBullet;
                    }});
        }};
    }

}
