import Players.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame{

    GameCanvas canvas;
    long lastTimeUpdate;

    public GameWindow(){
        this.setSize(800,600);

        this.canvas = new GameCanvas();
        this.setContentPane(this.canvas);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {

            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
        this.setResizable(false);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

                Player.keyPressed(keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                Player.keyReleased(keyEvent);
            }
        });

        this.canvas.setVisible(true);
        this.setVisible(true);
        lastTimeUpdate = System.nanoTime();
    }

    public void gameLoop(){
        while (true){
            long currentTime = System.nanoTime();

            if (currentTime - lastTimeUpdate >= 17000000){
                canvas.run();
                canvas.mapRun();
                canvas.render();
                lastTimeUpdate = currentTime;
            }
        }
    }
}
