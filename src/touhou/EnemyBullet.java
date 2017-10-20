package touhou;

import Bases.GameObject;
import Bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {

    final int bulletSpeed = 7;

    public EnemyBullet(){

        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
    }

    public void run (){
        y += bulletSpeed;
    }
}
