import Bases.GameObject;
import Enemies.Enemy;
import Enemies.EnemySpawner;
import Players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameCanvas extends JPanel {

    BufferedImage background;

    int mapX = 0;
    int mapY = -2500;

    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player();
    Enemy enemy = new Enemy();

    public GameCanvas(){
        // Create Back Buffer

        backBuffer = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        // Load BackGround
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameObject.add(player);
//        GameObject.add(enemy);
        GameObject.add(new EnemySpawner());
    }

    public void render(){
        // Draw Everything on back Buffer

        backGraphics.drawImage(background,mapX,mapY,null);
        GameObject.renderALl(backGraphics);

        // Call repaint

        repaint();

    }

    //Draw BackGround


    @Override
    protected void paintComponent(Graphics graphics) {

        graphics.drawImage(backBuffer,0,0,null);
    }

    public void run() {

        GameObject.runAll();
    }

    public void mapRun(){
        if (mapY < 0)
            mapY ++;
    }
}
