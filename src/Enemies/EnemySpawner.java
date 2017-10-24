package Enemies;

import Bases.FrameCounter;
import Bases.GameObject;

import java.util.Random;

public class EnemySpawner extends GameObject {
    FrameCounter frameCounter = new FrameCounter(120);
    Random r = new Random();

//    @Override
    public void run(){
        if (frameCounter.run()){
            frameCounter.reset();
            spawn();
        }
    }

    public void spawn(){
        Enemy enemy = new Enemy();
        enemy.position.y = 10;
        enemy.position.x = r.nextInt(384);
        GameObject.add(enemy);
    }
}
