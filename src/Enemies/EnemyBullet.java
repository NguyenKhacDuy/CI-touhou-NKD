package Enemies;

import Bases.GameObject;
import Bases.Physics.BoxCollider;
import Bases.Utils;
import Players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    BoxCollider boxCollider;

    final int bulletSpeed = 5;

    public EnemyBullet(){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
        boxCollider = new BoxCollider(5,5);
    }

    public void run (){
        this.position.addUp(0, bulletSpeed);
        boxCollider.position.set(this.position);
        Player player = GameObject.collideWith(boxCollider, Player.class);
        if (player != null){
            player.getHit();
            this.isActive = false;
        }
    }


}
