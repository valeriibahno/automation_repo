package homework_20;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public Double divide(double a, double b) {
        if(b == 0) {
            return null;
        } else {
            return a / b;
        }
    }
}
