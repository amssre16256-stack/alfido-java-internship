package task1;

public class Developer extends Employee {
    private int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        setOvertimeHours(overtimeHours);
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public final void setOvertimeHours(int overtimeHours) {
        if (overtimeHours < 0) {
            throw new IllegalArgumentException("overtime cannot be negative");
        }
        this.overtimeHours = overtimeHours;
    }

    /** Overtime is paid at 500 per hour. */
    @Override
    public double calculateSalary() {
        return getBaseSalary() + 500.0 * overtimeHours;
    }

    @Override
    public String role() {
        return "Developer";
    }
}
