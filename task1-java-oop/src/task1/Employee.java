package task1;

/**
 * Encapsulation example: all fields are private and can only be changed
 * through setters that validate the new value.
 */
public class Employee {
    private static int nextId = 1001;      // shared by all employees (static)

    private final int id;
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.id = nextId++;
        setName(name);
        setBaseSalary(baseSalary);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        this.name = name.trim();
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public final void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("salary cannot be negative");
        }
        this.baseSalary = baseSalary;
    }

    /** Overridden by subclasses (runtime polymorphism). */
    public double calculateSalary() {
        return baseSalary;
    }

    public String role() {
        return "Employee";
    }

    @Override
    public String toString() {
        return String.format("%d  %-8s %-14s salary = %10.2f", id, name, role(), calculateSalary());
    }
}
