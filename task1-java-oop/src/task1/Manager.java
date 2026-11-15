package task1;

public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double baseSalary, int teamSize) {
        super(name, baseSalary);
        setTeamSize(teamSize);
    }

    public int getTeamSize() {
        return teamSize;
    }

    public final void setTeamSize(int teamSize) {
        if (teamSize < 0) {
            throw new IllegalArgumentException("team size cannot be negative");
        }
        this.teamSize = teamSize;
    }

    /** Bonus of 2000 for every person in the team. */
    @Override
    public double calculateSalary() {
        return getBaseSalary() + 2000.0 * teamSize;
    }

    @Override
    public String role() {
        return "Manager";
    }
}
