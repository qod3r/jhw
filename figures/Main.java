import Shape.Shape;
// import Shape.Shape2D.Triangle;
import Shape.Shape2D.Circle;
import Shape.Shape3D.Cylinder;

public class Main {
    public static void main(String args[]) {
        Shape s;
        Cylinder<Shape> cyl;

        s = new Circle(1);
        System.out.println(s.calcArea());

        cyl = new Cylinder<Shape>(s, 10);
        System.out.println(cyl.calcVolume());
    }
}
