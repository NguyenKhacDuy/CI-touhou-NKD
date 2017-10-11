import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;

    public GameCanvas(){
        // Load BackGround
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBackground(Color.BLACK);
    }

    //Draw BackGround


    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(background,0,0,null);
        graphics.drawImage(player, 192,500,null);
    }
}
