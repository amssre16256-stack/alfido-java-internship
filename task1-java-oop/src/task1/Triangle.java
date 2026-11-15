package task1;

public class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        super("Triangle");
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("sides do not form a triangle");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;            // Heron's formula
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}
