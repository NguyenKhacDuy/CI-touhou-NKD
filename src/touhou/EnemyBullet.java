package touhou;

import Bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet {
    BufferedImage image;
    public int bulletX;
    public int bulletY;

    final int bulletSpeed = 7;

    public EnemyBullet(){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
    }

    public void render(Graphics graphics){
        graphics.drawImage(image, bulletX, bulletY,null);
    }

    public void run (){
        bulletY += bulletSpeed;
    }
}
