package task1;

public class Rectangle extends Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this("Rectangle", length, width);
    }

    /** Protected constructor so that a subclass (Square) can give its own name. */
    protected Rectangle(String name, double length, double width) {
        super(name);
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("sides must be positive");
        }
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}
