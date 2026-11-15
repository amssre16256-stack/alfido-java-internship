package task3;

/** Checked exception: no course exists with the given code. */
public class CourseNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public CourseNotFoundException(String courseCode) {
        super("No course with code " + courseCode);
    }
}
