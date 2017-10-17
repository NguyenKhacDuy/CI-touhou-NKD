package touhou;

import Bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PlayerSpell {
    BufferedImage image;

    public int bulletX;
    public int bulletY;
    final int bulletSpeed = 10;

    public PlayerSpell(){
        image = Utils.loadImage("assets/images/player-bullets/a/1.png");
    }

    public void render(Graphics graphics){
        graphics.drawImage(image, bulletX, bulletY, null);
    }

    public void run(){
        bulletY -= bulletSpeed;
    }
}
