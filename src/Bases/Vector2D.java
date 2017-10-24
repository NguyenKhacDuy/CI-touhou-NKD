package Bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this( 0, 0);
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void set(float x, float y){
       this.x = x;
       this.y = y;
    }

    public Vector2D set(Vector2D anotherVector) {
        return new Vector2D(this.x = anotherVector.x, this.y = anotherVector.y);
    }

    public void addUp(float x, float y){
        this.x += x;
        this.y += y;
    }

    public Vector2D addUp(Vector2D anotherVector) {
        return new Vector2D(this.x += anotherVector.x, this.y += anotherVector.y);
    }

    public Vector2D multiply(float number) {
//        this.x *= number;
//        this.y *= number;
        return new Vector2D(this.x * number, this.y * number);
    }

    public Vector2D multiply (Vector2D anotherVector){
        return new Vector2D( this.x * anotherVector.x, this.y * anotherVector.y);
    }

    public Vector2D subtract(float x, float y){
//        this.x -= number;
//        this.y -= number;
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D subtract (Vector2D anotherVector){
        return new Vector2D( this.x - anotherVector.x, this.y - anotherVector.y);
    }

    public Vector2D subtractBy(float x, float y){
        return new Vector2D( this.x -= x, this.y -= y);
    }

    public Vector2D subtractBy(Vector2D anotherVector){
        return new Vector2D( this.x -= anotherVector.x, this.y -= anotherVector.y);
    }

    public float length(){
        return (float)Math.sqrt(x * x + y * y );
    }

    public Vector2D normalize(){
        float length = length();
        return new Vector2D(this.x / length, this.y / length);
    }

    public Vector2D clone(){
        return new Vector2D(this.x, this.y);
    }

    public void print(){
        System.out.println(this.x);
        System.out.println(this.y);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
