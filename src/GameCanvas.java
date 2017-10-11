import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;
    int playerX;
    int playerY;

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    BufferedImage backBuffer;
    Graphics backGraphics;

    public GameCanvas(){
        // Create Back Buffer

        backBuffer = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        // Load BackGround
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBackground(Color.BLACK);
    }

    public void render(){
        // Draw Everything on back Buffer

        backGraphics.drawImage(background,0,0,null);
        backGraphics.drawImage(player, playerX,playerY,null);

        // Call repaint

        repaint();

    }

    //Draw BackGround


    @Override
    protected void paintComponent(Graphics graphics) {

        graphics.drawImage(backBuffer,0,0,null);
    }

    public void keyPressed(KeyEvent keyEvent) {
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
    }

    public void keyReleased(KeyEvent keyEvent) {
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
    }

    public void run(){
        int vx = 0;
        int vy = 0;

        if(rightPressed){
            vx += 5;
        }
        if (leftPressed){
            vx -= 5;
        }
        if (upPressed){
            vy -= 5;
        }
        if (downPressed){
            vy +=5;
        }
        playerX += vx;
        playerY += vy;
    }
}
