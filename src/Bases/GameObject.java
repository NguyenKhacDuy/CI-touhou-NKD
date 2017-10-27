package Bases;

import Bases.Physics.BoxCollider;
import Bases.Physics.PhysicsBody;
import Enemies.EnemyBullet;
import Players.PlayerSpell;

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

    public static  <T extends PhysicsBody> T collideWith(BoxCollider boxCollider, Class<T> cls){

        for (GameObject gameObject: gameObjects){
            if (!gameObject.isActive) continue;
            if (!(gameObject instanceof PhysicsBody)) continue;
            if (!(gameObject.getClass().equals(cls))) continue;

            BoxCollider otherBoxCollider = ((PhysicsBody) gameObject).getBoxCollider();

            if (otherBoxCollider.colliderWidth(boxCollider)){
                return (T)gameObject;
            }
        }
        return null;
    }

    public static <T extends PlayerSpell>T recycle(Class<T> cls){
        //tim trong tat ca cac GameObject
        //Neu gap 1 object tm 2 dk
        //1. Game Object nay la Player Spell
        //2. isActive = false
        //thi return object nafy
        // neu k tim thay thi khoi tao 1 Player Spell moi => return
        for (GameObject gameObject: gameObjects) {
            if ((gameObject instanceof PlayerSpell) && !((PlayerSpell) gameObject).isActive) {
                ((PlayerSpell) gameObject).isActive = true;
                return (T) gameObject;
            }
        }

        try {
            T newGameObject = cls.newInstance(); // tuong duong voi = new
            add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static <T extends PhysicsBody> T collideWith1(BoxCollider boxCollider, Class<T> cls) {
//        for (GameObject gameObject: gameObjects){
//            if (!gameObject.isActive) continue;
//            if (!(gameObject instanceof PhysicsBody)) continue;
//            if (!(gameObject.getClass().equals(cls))) continue;
//
//            BoxCollider anotherBoxCollider = ((PhysicsBody) gameObject).getBoxCollider();
//
//            if (anotherBoxCollider.colliderWidth(boxCollider)){
//                return (T)gameObject;
//            }
//        }
//        return null;
//    }

    public static <T extends EnemyBullet>T recycleEnemyBullet(Class<T> cls) {
        for (GameObject gameObject: gameObjects){
            if ((gameObject instanceof  EnemyBullet) && !((EnemyBullet)gameObject).isActive){
                ((EnemyBullet)gameObject).isActive = true;
                return (T) gameObject;
            }
        }

        try {
            T newGameObject = cls.newInstance();
            add(newGameObject);
            return newGameObject;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            }
        return null;
    }

//    public static <T extends GameObject>T recycle(Class<T> cls){
//        //tim trong tat ca cac GameObject
//        //Neu gap 1 object tm 2 dk
//        //1. Game Object nay la Player Spell
//        //2. isActive = false
//        //thi return object nafy
//        // neu k tim thay thi khoi tao 1 Player Spell moi => return
//        for (GameObject gameObject: gameObjects) {
//            if ( !gameObject.isActive) {
//                 gameObject.isActive = true;
//                return (T) gameObject;
//            }
//        }
//
//        try {
//            T newGameObject = cls.newInstance(); // tuong duong voi = new
//            add(newGameObject);
//            return newGameObject;
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
