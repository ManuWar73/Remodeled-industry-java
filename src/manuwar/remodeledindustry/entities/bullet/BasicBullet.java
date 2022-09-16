package remodeledindustry.entities.bullet;

import arc.graphics.*;
import remodeledindustry.content.*;
import mindustry.graphics.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;

public class BasicBullet extends BulletType{
    public BasicBullet(float damage, float speed, float range, Color color){
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