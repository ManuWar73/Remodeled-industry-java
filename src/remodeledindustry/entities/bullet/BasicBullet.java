package remodeledindustry.entities.bullet;

import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;

public class BasicBullet extends BasicBulletType{
    public BasicBullet(float speed, float damage) {
        super(speed, damage);
        hittable = absorbable = false;
        collides = collidesAir = collidesGround = collidesTiles = false;
        pierce = true;
    }
    @Override
    public float continuousDamage(){
        return damage / 2f * 60f;
    }
}