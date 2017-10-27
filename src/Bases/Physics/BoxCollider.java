package Bases.Physics;

import Bases.Vector2D;

public class BoxCollider {
    public Vector2D position;
    public float width;
    public float height;

    public BoxCollider(float width, float height){
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }

    public float left(){
        return position.x - width / 2;
    }

    public float right(){
        return position.x + width / 2;
    }

    public float top() {
        return position.y - height / 2;
    }

    public float bottom() {
        return position.y + height / 2;
    }

    public boolean colliderWidth(BoxCollider other){
        return (other.left() <= this.right() &&
                other.right() >= this.left() &&
                other.bottom() >= this.top() &&
                other.top() <= this.bottom());
    }
}
