package Players;

import Bases.GameObject;
import Bases.Physics.BoxCollider;
import Bases.Utils;
import Enemies.Enemy;
import javafx.print.PageLayout;

public class PlayerSpell extends GameObject {
    final int bulletSpeed = 10;
    public BoxCollider boxCollider;

    public PlayerSpell(){
        image = Utils.loadImage("assets/images/player-bullets/a/1.png");
        boxCollider = new BoxCollider(5, 5);
    }

    public void run(){
        this.position.subtractBy(0, bulletSpeed);
        boxCollider.position.set(this.position);
//        Enemy enemy = GameObject.colliderWith(this.boxCollider, Player.class);
        Enemy enemy = GameObject.collideWith(boxCollider, Enemy.class);
        if (enemy != null){
            enemy.getHit();
            this.isActive = false;
        }
    }
    private void deactiveIfNeeded(){
        if (position.y < 0){
            this.isActive = false;
        }
    }
}
