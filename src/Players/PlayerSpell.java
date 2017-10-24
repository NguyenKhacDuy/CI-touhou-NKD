package Players;

import Bases.GameObject;
import Bases.Physics.BoxCollider;
import Bases.Utils;
import Enemies.Enemy;

public class PlayerSpell extends GameObject {
    final int bulletSpeed = 10;
    public BoxCollider boxCollider;

    public PlayerSpell(){
        image = Utils.loadImage("assets/images/player-bullets/a/1.png");
        boxCollider = new BoxCollider(20, 20);
    }

    public void run(){
        this.position.subtractBy(0, bulletSpeed);
        boxCollider.posotion.set(this.position);
        Enemy enemy = GameObject.colliderWith(this.boxCollider);
        if (enemy != null){
            enemy.getHit();
            this.isActive = true;
        }
    }
}
