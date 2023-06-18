package remodeledindustry.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.SuicideAI;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.MoveLightningAbility;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.entities.bullet.*;
import mindustry.gen.EntityMapping;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.world.meta.BlockFlag;

import static mindustry.Vars.tilePayload;

public class RemUnits {
    public static UnitType teeclipse, lspoly, nquad, srcrawler;
    public static void load(){
        teeclipse = new UnitType("te-eclipse"){{
            localizedName = "Thousand Embers Eclipse";
            constructor = EntityMapping.map("eclipse");
            speed = 0.74f;
            accel = 0.04f;
            drag = 0.04f;
            rotateSpeed = 1f;
            outlineColor = Color.valueOf("811f1f");
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
        lspoly = new UnitType("ls-poly"){{

            flying = true;
            constructor = EntityMapping.map("flare");
            localizedName = "LightStrike Poly";
            outlineColor = Color.valueOf("883647");
            drag = 0.05f;
            circleTarget = true;
            speed = 4.6f;
            rotateSpeed = 15f;
            accel = 0.1f;
            range = 130f;
            health = 400;
            engineOffset = 6.5f;
            hitSize = 9f;
            lowAltitude = true;

            ammoType = new PowerAmmoType(900);

            mineTier = 2;
            mineSpeed = 3.5f;

            abilities.add(new MoveLightningAbility(70, 8, 0.03f, 0, 1, 1, Pal.techBlue));

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
        nquad = new UnitType("n-quad"){{
            armor = 14f;
            localizedName = "Nuker Quad";
            constructor = EntityMapping.map("quad");
            outlineColor = Color.valueOf("469b72");
            health = 6000;
            speed = 0.6f;
            rotateSpeed = 2f;
            accel = 0.16f;
            drag = 0.017f;
            lowAltitude = false;
            flying = true;
            circleTarget = true;
            engineOffset = 13f;
            engineSize = 7f;
            faceTarget = false;
            hitSize = 36f;
            payloadCapacity = (4 * 4) * tilePayload;
            range = 140f;
            targetAir = false;
            targetFlags = new BlockFlag[]{BlockFlag.battery, BlockFlag.factory, null};

            ammoType = new PowerAmmoType(3000);

            weapons.add(
                    new Weapon(){{
                        x = y = 0f;
                        mirror = false;
                        reload = 80f;
                        minShootVelocity = 0.01f;

                        soundPitchMin = 0.95f;
                        shootSound = Sounds.plasmadrop;

                        bullet = new BasicBulletType(){{
                            sprite = "large-bomb";
                            width = height = 160/4f;

                            maxRange = 60f;
                            ignoreRotation = true;

                            backColor = Pal.plastanium;
                            frontColor = Color.white;
                            mixColorTo = Color.white;

                            hitSound = Sounds.plasmaboom;

                            shootCone = 180f;
                            ejectEffect = Fx.none;
                            hitShake = 12f;

                            collidesAir = false;

                            lifetime = 85f;

                            despawnEffect = Fx.greenBomb;
                            hitEffect = Fx.massiveExplosion;
                            keepVelocity = false;
                            spin = 1.75f;

                            shrinkX = shrinkY = 0.7f;

                            speed = 0f;
                            collides = false;

                            healPercent = 5f;
                            splashDamage = 440f;
                            splashDamageRadius = 80f;
                            despawnShake = 0.4f;
                            fragBullets = 1;
                            fragBullet = new BasicBulletType(0,0){{
                                splashDamageRadius = 160;
                                splashDamage = 220;
                                lifetime = 0;
                                despawnEffect = Fx.none;
                            }};
                        }};
                    }});
        }};

        srcrawler = new UnitType("sr-crawler"){{
            localizedName="Self Repairing Crawler";
            speed = 0.85f;
            constructor = EntityMapping.map("crawler");
            hitSize = 8f;
            health = 350;
            mechSideSway = 0.25f;
            range = 40f;
            ammoType = new ItemAmmoType(Items.coal);

            weapons.add(new Weapon(){{
                shootOnDeath = true;
                reload = 24f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosion;
                x = shootY = 0f;
                mirror = false;
                bullet = new BulletType(){{
                    collidesTiles = false;
                    collides = false;
                    hitSound = Sounds.explosion;

                    rangeOverride = 30f;
                    hitEffect = Fx.pulverize;
                    speed = 0f;
                    splashDamageRadius = 55f;
                    instantDisappear = true;
                    splashDamage = 100f;
                    killShooter = true;
                    hittable = false;
                    collidesAir = true;
                }};
            }});
            abilities.add(new RepairFieldAbility(20f, 30f, 8f));
        }};
    }

}
