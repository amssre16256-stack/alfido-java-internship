package task3;

/** Checked exception: thrown when a course has no free seat. */
public class CourseFullException extends Exception {
    private static final long serialVersionUID = 1L;

    private final String courseCode;

    public CourseFullException(String courseCode, int capacity) {
        super("Course " + courseCode + " is full (capacity " + capacity + ")");
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }
}
