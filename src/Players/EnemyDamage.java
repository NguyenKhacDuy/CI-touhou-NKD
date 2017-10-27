package Players;

import Bases.GameObject;
import Bases.Physics.BoxCollider;
import Enemies.Enemy;

public class EnemyDamage {
    public void DamageofEnemy (Player p){
        BoxCollider boxCollider = p.getBoxCollider();
        Enemy enemy = GameObject.collideWith(boxCollider, Enemy.class);
        if ( enemy != null){
            enemy.getHit();
            enemy.isActive = false;
        }
    }
}
