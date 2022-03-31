package Shape.Shape2D;
import Shape.Shape;

public class Rectangle implements Shape {
    private double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double calcArea() {
        return (a * b);
    }

    public double calcPerimeter() {
        return ((a + b) / 2);
    }

    public double getA() { return a; }
    public double getB() { return b; }
}
