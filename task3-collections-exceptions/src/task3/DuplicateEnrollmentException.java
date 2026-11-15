package task3;

/** Checked exception: the student is already enrolled in this course. */
public class DuplicateEnrollmentException extends Exception {
    private static final long serialVersionUID = 1L;

    public DuplicateEnrollmentException(String student, String courseCode) {
        super(student + " is already enrolled in " + courseCode);
    }
}
