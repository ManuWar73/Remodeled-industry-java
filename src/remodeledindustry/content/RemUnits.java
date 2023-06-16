package remodeledindustry.content;

import arc.graphics.Color;
import mindustry.ai.UnitCommand;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.MoveLightningAbility;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.world.meta.BlockFlag;

public class RemUnits {
    public static UnitType teeclipse, lspoly;
    public static void load(){
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
        lspoly = new UnitType("lightstrike-poly"){{
            defaultCommand = UnitCommand.rebuildCommand;

            flying = true;
            localizedName = "LightStrike Poly";
            drag = 0.05f;
            speed = 2.6f;
            rotateSpeed = 15f;
            accel = 0.1f;
            range = 130f;
            health = 400;
            buildSpeed = 0.5f;
            engineOffset = 6.5f;
            hitSize = 9f;
            lowAltitude = true;

            ammoType = new PowerAmmoType(900);

            mineTier = 2;
            mineSpeed = 3.5f;

            abilities.add(new MoveLightningAbility(70, 8, 0.5f, 0, 1, 10, Color.yellow));

            weapons.add(new Weapon("remodeled-ind-ls-poly-weapon"){{
                top = false;
                y = -2.5f;
                x = 3.75f;
                reload = 20f;
                ejectEffect = Fx.none;
                recoil = 2f;
                shootSound = Sounds.missile;
                velocityRnd = 0.5f;
                inaccuracy = 15f;
                alternate = true;

                bullet = new MissileBulletType(4f, 28){{
                    homingPower = 0.08f;
                    weaveMag = 5;
                    weaveScale = 5;
                    splashDamage = 10;
                    splashDamageRadius = 16;
                    lifetime = 80f;
                    keepVelocity = false;
                    accel = 0.02f;
                    shootEffect = Fx.shootPyraFlame;
                    smokeEffect = Fx.hitLaser;
                    hitEffect = despawnEffect = Fx.hitLaser;
                    frontColor = Color.red;
                    hitSound = Sounds.none;

                    backColor = Pal.turretHeat;
                    trailColor = Pal.turretHeat;
                    hitEffect = despawnEffect = Fx.explosion;
                }};
            }});
        }};
    }

}
