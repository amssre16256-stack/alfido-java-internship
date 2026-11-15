package task1;

/**
 * Abstract base class for all shapes (abstraction + inheritance).
 * The name is encapsulated: it is private and read through a getter.
 */
public abstract class Shape {
    private final String name;

    protected Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /** Each concrete shape must supply its own area. */
    public abstract double area();

    /** Each concrete shape must supply its own perimeter. */
    public abstract double perimeter();

    /** Shared behaviour written once in the base class. */
    public String describe() {
        return String.format("%-10s area = %8.2f   perimeter = %8.2f", name, area(), perimeter());
    }

    @Override
    public String toString() {
        return describe();
    }
}
