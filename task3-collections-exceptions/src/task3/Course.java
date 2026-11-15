package task3;

import java.util.ArrayList;
import java.util.List;

/** A course with limited seats. Students are kept in an ArrayList in enrolment order. */
public class Course {
    private final String code;
    private final String title;
    private final int capacity;
    private final List<String> enrolled = new ArrayList<String>();

    public Course(String code, String title, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.code = code;
        this.title = title;
        this.capacity = capacity;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    public int seatsLeft() {
        return capacity - enrolled.size();
    }

    public List<String> getEnrolled() {
        return new ArrayList<String>(enrolled);
    }

    public boolean has(String student) {
        return enrolled.contains(student);
    }

    public void enroll(String student) throws CourseFullException, DuplicateEnrollmentException {
        if (enrolled.contains(student)) {
            throw new DuplicateEnrollmentException(student, code);
        }
        if (enrolled.size() >= capacity) {
            throw new CourseFullException(code, capacity);
        }
        enrolled.add(student);
    }

    public boolean drop(String student) {
        return enrolled.remove(student);
    }
}
