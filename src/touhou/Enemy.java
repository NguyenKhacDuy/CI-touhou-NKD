package touhou;

import Bases.GameObject;
import Bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject{
    public int enemyHeath = 1000;
    int timeDisabled = 10;

    boolean bulletDisabled;

    boolean isDeath = false;

    int speed = 3; // final = const
    final int left = 0;
    final int right = 375;

    public Enemy(){
        x = 180;
        y = 10;
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");

        bulletDisabled = false;
    }

    public void render(Graphics graphics){
        graphics.drawImage(image, (int)x, (int)y, null);
    }

    public void run(){
        if (x >= right - image.getWidth()|| x <= left)
            speed = - speed;
        x -= speed;
        x = (int)Utils.clamp(x,left,right);
        shoot();    
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
        if (!isDeath){
            EnemyBullet newSpell = new EnemyBullet();
            newSpell.x = (int)x;
            newSpell.y = (int)y;
            GameObject.add(newSpell);

            bulletDisabled = true;
        }
    }
}
