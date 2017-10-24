package Players;

import Bases.GameObject;
import Bases.Physics.BoxCollider;
import Bases.Utils;
import Bases.Vector2D;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject{
    static boolean rightPressed;
    static boolean leftPressed;
    static boolean downPressed;
    static boolean upPressed;

    static boolean xPressed;

    boolean spellDisabled;
    final int coolDownTime = 10;

    final int speed = 5; // final = const
    final int left = 20;
    final int right = 370;
    final int top = 0;
    final int bottom = 518;

    public BoxCollider boxCollider;

    public Player(){
        position.set(182, 518);
        image = Utils.loadImage("assets/images/players/straight/0.png");
        boxCollider = new BoxCollider(5,5);
        spellDisabled = false;
    }

    public static void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if (keyEvent.getKeyCode() == keyEvent.VK_UP){
            upPressed = true;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_DOWN){
            downPressed = true;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_X){
            xPressed = true;
        }
    }

    public static void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (keyEvent.getKeyCode() == keyEvent.VK_UP){
            upPressed = false;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_DOWN){
            downPressed = false;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_X){
            xPressed = false;
        }
    }

    public void run(){
        move();
        shoot();
        boxCollider.posotion.set(this.position);
    }


    Vector2D velocity = new Vector2D();

    private void move() {
        velocity.set(0,0);

        if(rightPressed){
            velocity.x += speed;
        }
        if (leftPressed){
            velocity.x -= speed;
        }
        if (upPressed){
            velocity.y -= speed;
        }
        if (downPressed){
            velocity.y +=speed;
        }

        position.addUp(velocity);

        position.x = (int)Utils.clamp(position.x, left, right); // ép kiểu 1 số thì: (kiểu)
        position.y = (int)Utils.clamp(position.y, top, bottom);
    }

    int coolDownCount = 0;

    public void shoot(){
        if (spellDisabled){
            coolDownCount++;
            if (coolDownCount >= coolDownTime){
                spellDisabled = false;
                coolDownCount = 0;
            }

            return;
        }
        if (xPressed) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.position.set(this.position.subtract(0, image.getHeight() / 2));
            GameObject.add(newSpell);
            spellDisabled = true;
        }
    }

    public void getHit() {
        isActive = false;
    }
}
