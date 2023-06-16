package remodeledindustry.entities.bullet;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Interp;
import arc.math.Mathf;
import arc.util.Nullable;
import arc.util.Tmp;
import mindustry.entities.bullet.ContinuousBulletType;
import mindustry.gen.Bullet;
import mindustry.graphics.Pal;

public class ContinuousDamageBulletType extends ContinuousBulletType{
         public ContinuousDamageBulletType(float speed, float damage){
            this.damage = damage;
            this.speed = speed;
    }
    public Color backColor = Pal.bulletYellowBack, frontColor = Pal.bulletYellow;
    public Color mixColorFrom = new Color(1f, 1f, 1f, 0f), mixColorTo = new Color(1f, 1f, 1f, 0f);
    public float width = 5f, height = 7f;
    public float shrinkX = 0f, shrinkY = 0.5f;
    public Interp shrinkInterp = Interp.linear;
    public float spin = 0, rotationOffset = 0f;
    public String sprite;
    public @Nullable String backSprite;

    public TextureRegion backRegion;
    public TextureRegion frontRegion;
    @Override
    public void draw(Bullet b){
        super.draw(b);
        float shrink = shrinkInterp.apply(b.fout());
        float height = this.height * ((1f - shrinkY) + shrinkY * shrink);
        float width = this.width * ((1f - shrinkX) + shrinkX * shrink);
        float offset = -90 + (spin != 0 ? Mathf.randomSeed(b.id, 360f) + b.time * spin : 0f) + rotationOffset;

        Color mix = Tmp.c1.set(mixColorFrom).lerp(mixColorTo, b.fin());

        Draw.mixcol(mix, mix.a);

        if(backRegion.found()){
            Draw.color(backColor);
            Draw.rect(backRegion, b.x, b.y, width, height, b.rotation() + offset);
        }

        Draw.color(frontColor);
        Draw.rect(frontRegion, b.x, b.y, width, height, b.rotation() + offset);

        Draw.reset();
    }
}