package Enemies;

import Bases.GameObject;
import Bases.Physics.BoxCollider;
import Bases.Utils;

import java.awt.*;

public class Enemy extends GameObject{
    public int enemyHeath = 1000;
    int timeDisabled = 10;

    boolean bulletDisabled;

    int speed = 3; // final = const
    final int left = 30;
    final int right = 390;

    public BoxCollider boxCollider;

    public Enemy(){

        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
        boxCollider = new BoxCollider(30,30);
        bulletDisabled = false;
    }

    public void run(){
        move();
        shoot();
        position.addUp(0,2);
//        position.x = (int)Utils.clamp(position.x,left,right);
        boxCollider.posotion.set(this.position);
    }

    public void move(){
        if (position.x >= right - image.getWidth()|| position.x <= left)
            speed = - speed;
    }

    int coolDownTime = 0;
    public void shoot(){
        if (bulletDisabled){
            coolDownTime++;
            if (coolDownTime >= timeDisabled){
                bulletDisabled = false;
                coolDownTime = 0;
            }

            return;
        }

            EnemyBullet newSpell = new EnemyBullet();
            newSpell.position.set(this.position);
            GameObject.add(newSpell);

            bulletDisabled = true;

    }

    public void getHit() {
        isActive = false;
    }
}
