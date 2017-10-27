package Input;

import java.awt.event.KeyEvent;

public class InputManage {
    //Theo doi input nguoi dung
    //Singleton

    public static boolean rightPressed;
    public static boolean leftPressed;
    public static boolean downPressed;
    public static boolean upPressed;
    public static boolean xPressed;

    public static final InputManage instance = new InputManage();

    private InputManage(){

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
}
