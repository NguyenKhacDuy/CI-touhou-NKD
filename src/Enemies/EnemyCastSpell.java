package Enemies;

import Bases.GameObject;
import Bases.Physics.BoxCollider;

public class EnemyCastSpell {
    int coolDownTime = 0;
    boolean bulletDisabled;
    int timeDisabled = 20;

    public void shoot(Enemy owner){
        if (bulletDisabled){
            coolDownTime++;
            if (coolDownTime >= timeDisabled){
                bulletDisabled = false;
                coolDownTime = 0;
            }
            return;
        }

        EnemyBullet newSpell = GameObject.recycleEnemyBullet(EnemyBullet.class);
        newSpell.position.set(owner.position.subtract(0, owner.image.getHeight() / 2 ));
        GameObject.add(newSpell);

        bulletDisabled = true;

    }

}
