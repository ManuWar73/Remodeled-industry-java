package remodeledindustry.entities.bullet;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.*;
import mindustry.graphics.*;

/** An extended BasicBulletType that doesn't have color */
public class DevilsKnife extends BulletType {

    public float width = 5f, height = 5f;
    public float shrinkX = 0f, shrinkY = 0f;
    public Interp shrinkInterp = Interp.linear;
    public float spin = 0, rotationOffset = 0f;
    public String sprite;
    public @Nullable String backSprite;

    public TextureRegion backRegion;
    public TextureRegion frontRegion;

    public DevilsKnife(float speed, float damage, String bulletSprite){
        super(speed, damage);
        this.sprite = bulletSprite;
    }

    public DevilsKnife(float speed, float damage){
        this(speed, damage, "bullet");
    }

    /** For mods. */
    public DevilsKnife(){
        this(1f, 1f, "bullet");
    }

    @Override
    public void load(){
        super.load();

        backRegion = Core.atlas.find(backSprite == null ? (sprite + "-back") : backSprite);
        frontRegion = Core.atlas.find(sprite);
    }

    @Override
    public void draw(Bullet b){
        super.draw(b);
        float shrink = shrinkInterp.apply(b.fout());
        float height = this.height * ((1f - shrinkY) + shrinkY * shrink);
        float width = this.width * ((1f - shrinkX) + shrinkX * shrink);
        float offset = -90 + (spin != 0 ? Mathf.randomSeed(b.id, 360f) + b.time * spin : 0f) + rotationOffset;


        if(backRegion.found()){
            Draw.rect(backRegion, b.x, b.y, width, height, b.rotation() + offset);
        }

        Draw.rect(frontRegion, b.x, b.y, width, height, b.rotation() + offset);

        Draw.reset();
    }
}
