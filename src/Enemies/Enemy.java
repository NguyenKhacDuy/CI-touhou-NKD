package Enemies;

import Bases.GameObject;
import Bases.Physics.BoxCollider;
import Bases.Physics.PhysicsBody;
import Bases.Utils;

public class Enemy extends GameObject implements PhysicsBody {
    public int enemyHeath = 1000;

    int speed = 2; // final = const
    final int left = 20;
    final int right = 390;

    public BoxCollider boxCollider;
    PlayerDamage playerDamage;
    EnemyCastSpell enemyCastSpell;

    public Enemy(){

        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
        boxCollider = new BoxCollider(30,30);
        this.playerDamage = new PlayerDamage();
        enemyCastSpell = new EnemyCastSpell();
    }

    public void run(){
        move();
        enemyCastSpell.shoot(this);
        boxCollider.position.set(this.position);
        this.playerDamage.DamageOfPlayer(this);
    }

    public void move(){
        if (position.x >= right - image.getWidth()|| position.x <= left)
            speed = - speed;
        position.x += speed;

        position.addUp(0,2);
//        position.x = (int)Utils.clamp(position.x,left,right);
    }


    public void getHit() {
        isActive = false;
    }


    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }


}
