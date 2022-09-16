package remodeledindustry.entities.bullet;

import arc.graphics.*;
import remodeledindustry.content.*;
import mindustry.graphics.*;

public class BasicBullet extends InstantHitBulletType{
    public CoinBulletType(float damage, float speed, float range, Color color){
        super(damage);
        this.pierceDamage = pierceDamage;
        hitColor = trailColor = color;
        this.speed = speed;
        lifetime = range / speed;
    }

    public BasicBullet(float damage){
        this(damage, damage, Pal.engine);
    }
}