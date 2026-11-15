package task3;

/** Unchecked exception: the student name is null, empty or contains digits. */
public class InvalidStudentException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidStudentException(String message) {
        super(message);
    }
}
