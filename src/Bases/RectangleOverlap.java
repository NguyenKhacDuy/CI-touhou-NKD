package Bases;

public class RectangleOverlap {
    public float x;
    public float y;
    public float heigh;
    public float width;

    public RectangleOverlap(float x, float y, float width, float heigh) {
        this.x = x;
        this.y = y;
        this.heigh = heigh;
        this.width = width;
    }

    public static boolean check(RectangleOverlap a, RectangleOverlap b){
        if( a.x + a.width >= b.x &&
            a.x + a.width <= b.x + b.width &&
            a.y + a.heigh >= b.y &&
            a.y + a.heigh <= b.y + b.heigh ||
                b.x + b.width >= a.x &&
                b.x + b.width <= a.x + a.width &&
                b.y + b.heigh >= a.y &&
                b.y + b.heigh <= a.y + a.heigh)
            return true;
        else return false;
    }
}
