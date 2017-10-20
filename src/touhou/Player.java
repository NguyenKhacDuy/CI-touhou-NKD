package touhou;

import Bases.GameObject;
import Bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends GameObject{
    static boolean rightPressed;
    static boolean leftPressed;
    static boolean downPressed;
    static boolean upPressed;

    static boolean xPressed;

    boolean spellDisabled;
    final int coolDownTime = 10;

    final int speed = 5; // final = const
    final int left = 0;
    final int right = 356;
    final int top = 0;
    final int bottom = 518;

    public Player(){
        x = 182;
        y = 518;
        image = Utils.loadImage("assets/images/players/straight/0.png");

        spellDisabled = false;
    }

    public void render(Graphics graphics){
        graphics.drawImage(image, (int)x, (int)y, null);
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
    }

    private void move() {
        int vx = 0;
        int vy = 0;

        if(rightPressed){
            vx += speed;
        }
        if (leftPressed){
            vx -= speed;
        }
        if (upPressed){
            vy -= speed;
        }
        if (downPressed){
            vy +=speed;
        }

        x += vx;
        y += vy;

        x = (int)Utils.clamp(x, left, right); // ép kiểu 1 số thì: (kiểu)
        y = (int)Utils.clamp(y, top, bottom);
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
            newSpell.x = (int)x;
            newSpell.y = (int)y;
            GameObject.add(newSpell);

            spellDisabled = true;
        }
    }
}
