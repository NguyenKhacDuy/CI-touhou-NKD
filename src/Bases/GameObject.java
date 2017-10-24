package Bases;

import Bases.Physics.BoxCollider;
import Enemies.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    public BufferedImage image;
    public boolean isActive;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObject = new Vector<>();

    public static void runAll(){
        for (GameObject gameObject: gameObjects){
            if (gameObject.isActive)
                gameObject.run();
        }

        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }

    public static void renderALl(Graphics graphics){
        for (GameObject gameObject: gameObjects){
            if (gameObject.isActive)
                gameObject.render(graphics);
        }
    }

    public static void add(GameObject gameObject){
        newGameObject.add(gameObject);
    }


    public static Enemy colliderWith(BoxCollider boxCollider) {
        for (GameObject gameObject: gameObjects){
            if (gameObject.isActive && gameObject instanceof Enemy) {
                Enemy enemy = (Enemy)gameObject;
                if (enemy.boxCollider.colliderWidth(boxCollider)){
                    return enemy;
                }
            }
        }
        return null;
    }

    public GameObject(){
        position = new Vector2D();
        isActive = true;
    }

    public void run(){

    }

    public void render(Graphics graphics){
        if (image !=null){
          graphics.drawImage(image,
                  (int)(position.x - image.getWidth() / 2),
                  (int)(position.y - image.getHeight() / 2),
                  null);
        }
    }
}
