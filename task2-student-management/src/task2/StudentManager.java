package task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds the list of students and the operations on it.
 * It does no input or output, so it can be tested without a keyboard.
 */
public class StudentManager {
    private final List<Student> students = new ArrayList<Student>();

    public int count() {
        return students.size();
    }

    public List<Student> all() {
        return new ArrayList<Student>(students);
    }

    /** Adds a student; returns false if the roll number is already used. */
    public boolean add(Student s) {
        if (find(s.getRollNo()) != null) {
            return false;
        }
        students.add(s);
        return true;
    }

    public Student find(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                return s;
            }
        }
        return null;
    }

    public boolean remove(int rollNo) {
        Student s = find(rollNo);
        return s != null && students.remove(s);
    }

    public boolean updateMarks(int rollNo, int maths, int science, int english) {
        Student s = find(rollNo);
        if (s == null) {
            return false;
        }
        s.setMarks(maths, science, english);
        return true;
    }

    /** The student with the highest total; the earlier one wins a tie. Null if empty. */
    public Student topper() {
        Student best = null;
        for (Student s : students) {
            if (best == null || s.total() > best.total()) {
                best = s;
            }
        }
        return best;
    }

    public double classAveragePercentage() {
        if (students.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Student s : students) {
            sum += s.percentage();
        }
        return sum / students.size();
    }

    /** Number of students who have the given grade. */
    public int countWithGrade(char grade) {
        int n = 0;
        for (Student s : students) {
            if (s.grade() == grade) {
                n++;
            }
        }
        return n;
    }
}
