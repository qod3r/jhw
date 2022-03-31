package Shape.Shape2D;
import Shape.Shape;

public class Triangle implements Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) throws Exception {
        if ((a + b) > c && (a + c) > b && (b + c) > a) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new Exception("bruh");
        }
    }

    public double calcArea() {
        double p = calcPerimeter() / 2;
        double S = p * (p-a) * (p-b) * (p-c);
        return Math.sqrt(S);
    }

    public double calcPerimeter() {
        return (a + b + c);
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
}
