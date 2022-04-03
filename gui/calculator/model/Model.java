package calculator.model;

public class Model {

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double mulitply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) throws Exception {
        if (b == 0) throw new Exception("Cannot divide by 0");
        else return a / b;
    }
}