package touhou;

import Bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage image;
    public int playerX = 182;
    public int playerY = 518;

    static boolean rightPressed;
    static boolean leftPressed;
    static boolean downPressed;
    static boolean upPressed;

    static boolean xPressed;

    final int speed = 5; // final = const
    final int left = 0;
    final int right = 356;
    final int top = 0;
    final int bottom = 518;

    public Player(){
        image = Utils.loadImage("assets/images/players/straight/0.png");
    }

    public void render(Graphics graphics){
        graphics.drawImage(image, playerX, playerY, null);
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

        playerX += vx;
        playerY += vy;

        playerX = (int)Utils.clamp(playerX, left, right); // ép kiểu 1 số thì: (kiểu)
        playerY = (int)Utils.clamp(playerY, top, bottom);
    }

    public void shoot(ArrayList<PlayerSpell> spells){
        if (xPressed) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.bulletX = playerX;
            newSpell.bulletY = playerY;
            spells.add(newSpell);
        }
    }
}
