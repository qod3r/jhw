package Shape.Shape3D;

import Shape.Shape;
import Shape.VolShape;

public class Cylinder <T> implements VolShape {
    private T s;

    private double h;

    public Cylinder(T s, double h) {
        this.h = h;
        this.s = s;
    }

    public double calcVolume() {
        return h * ((Shape) s).calcArea();
    }
}
