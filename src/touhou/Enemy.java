package touhou;

import Bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    BufferedImage image;

    public int enemyX = 180;
    public int enemyY = 10;
    public int enemyHeath = 1000;

    boolean isDeath = false;

    int speed = 3; // final = const
    final int left = 0;
    final int right = 375;

    public Enemy(){
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
    }

    public void render(Graphics graphics){
        graphics.drawImage(image, enemyX, enemyY, null);
    }

    public void run(){
        if (enemyX >= right - image.getWidth()|| enemyX <= left)
            speed = - speed;
        enemyX -= speed;
        enemyX = (int)Utils.clamp(enemyX,left,right);
    }

    public void shoot(ArrayList<EnemyBullet> enemyBullets){
        if (!isDeath){
            EnemyBullet newSpell = new EnemyBullet();
            newSpell.bulletX = enemyX;
            newSpell.bulletY = enemyY;
            enemyBullets.add(newSpell);
        }
    }
}
