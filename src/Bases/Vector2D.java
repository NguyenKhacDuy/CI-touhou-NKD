package Bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(float x, float y){
       this.x = x;
       this.y = y;
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

    public Vector2D subtract(float number){
//        this.x -= number;
//        this.y -= number;
        return new Vector2D(this.x - number, this.y - number);
    }

    public Vector2D subtract (Vector2D anotherVector){
        return new Vector2D( this.x - anotherVector.x, this.y - anotherVector.y);
    }

    public Vector2D subtractBy(float number){
        return new Vector2D( this.x -= number, this.y -= number);
    }

    public Vector2D subtractBy(Vector2D anotherVector){
        return new Vector2D( this.x -= anotherVector.x, this.y -= anotherVector.y);
    }

    public float length(Vector2D vector2D){
        return (float)Math.sqrt(vector2D.x * vector2D.x + vector2D.y * vector2D.y );
    }

    public Vector2D clone(){
        return new Vector2D(this.x, this.y);
    }

    public void print(){
        System.out.println(this.x);
        System.out.println(this.y);
    }

    public static void main(String[] args) {
        Vector2D vector2D = new Vector2D( 1, 2);
        Vector2D vector2D1 = new Vector2D( 3, 4);
        Vector2D vector2D2;
        vector2D.set(1,2);
        vector2D.print();

        Vector2D v10 = vector2D.multiply(5);
        vector2D.print();


        vector2D.print();
        vector2D.subtract(1);

    }
}
