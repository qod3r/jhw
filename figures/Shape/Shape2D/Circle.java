package Shape.Shape2D;
import Shape.Shape;

public class Circle implements Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double calcArea() {
        return (r * r * Math.PI);
    }

    public double calcPerimeter() {
        return (2 * Math.PI * r);
    }

    public double getR() {
        return r;
    }
}
