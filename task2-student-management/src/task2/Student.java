package task2;

/** One student with a roll number, a name and marks in three subjects. */
public class Student {
    public static final String[] SUBJECTS = {"Maths", "Science", "English"};

    private final int rollNo;
    private String name;
    private final int[] marks = new int[SUBJECTS.length];

    public Student(int rollNo, String name, int maths, int science, int english) {
        if (rollNo <= 0) {
            throw new IllegalArgumentException("roll number must be positive");
        }
        this.rollNo = rollNo;
        setName(name);
        setMarks(maths, science, english);
    }

    public int getRollNo() {
        return rollNo;
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

    public int getMarks(int subjectIndex) {
        return marks[subjectIndex];
    }

    public final void setMarks(int maths, int science, int english) {
        int[] m = {maths, science, english};
        for (int v : m) {
            if (v < 0 || v > 100) {
                throw new IllegalArgumentException("marks must be between 0 and 100");
            }
        }
        System.arraycopy(m, 0, marks, 0, m.length);
    }

    public int total() {
        int t = 0;
        for (int v : marks) {
            t += v;
        }
        return t;
    }

    public double percentage() {
        return total() * 100.0 / (SUBJECTS.length * 100);
    }

    /** Grade from the percentage; a student who fails any subject (below 35) gets F. */
    public char grade() {
        for (int v : marks) {
            if (v < 35) {
                return 'F';
            }
        }
        double p = percentage();
        if (p >= 90) {
            return 'A';
        } else if (p >= 75) {
            return 'B';
        } else if (p >= 60) {
            return 'C';
        } else if (p >= 45) {
            return 'D';
        }
        return 'E';
    }
}
