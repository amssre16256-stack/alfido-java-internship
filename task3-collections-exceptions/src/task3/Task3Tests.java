package task3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** Self-checking tests for the enrolment service and the custom exceptions. */
public class Task3Tests {
    private static int passed = 0;
    private static int failed = 0;

    private static void check(String id, String what, boolean ok) {
        System.out.println((ok ? "PASS " : "FAIL ") + id + "  " + what);
        if (ok) passed++; else failed++;
    }

    private interface Action {
        void run() throws Exception;
    }

    /** Returns the class of the exception thrown by the action, or null if none. */
    private static Class<?> thrown(Action a) {
        try {
            a.run();
            return null;
        } catch (Exception e) {
            return e.getClass();
        }
    }

    public static void main(String[] args) throws Exception {
        final EnrollmentService s = new EnrollmentService();
        s.addCourse(new Course("A1", "Alpha", 2));
        s.addCourse(new Course("B2", "Beta", 3));

        s.enroll("A1", "Asha");
        s.enroll("A1", "Ravi");
        check("T1", "enrolment keeps order in the ArrayList",
              s.getCourse("A1").getEnrolled().equals(Arrays.asList("Asha", "Ravi")));
        check("T2", "seatsLeft = 0 when full", s.getCourse("A1").seatsLeft() == 0);
        check("T3", "full course throws CourseFullException",
              thrown(() -> s.enroll("A1", "Meera")) == CourseFullException.class);
        check("T4", "duplicate throws DuplicateEnrollmentException",
              thrown(() -> s.enroll("B2", "Asha")) == null
              && thrown(() -> s.enroll("B2", "Asha")) == DuplicateEnrollmentException.class);
        check("T5", "unknown course throws CourseNotFoundException",
              thrown(() -> s.enroll("ZZ", "Asha")) == CourseNotFoundException.class);
        check("T6", "name with digits throws InvalidStudentException",
              thrown(() -> s.enroll("B2", "R2D2")) == InvalidStudentException.class);
        check("T7", "empty name throws InvalidStudentException",
              thrown(() -> s.enroll("B2", "   ")) == InvalidStudentException.class);
        check("T8", "null name throws InvalidStudentException",
              thrown(() -> s.enroll("B2", null)) == InvalidStudentException.class);
        check("T9", "InvalidStudentException is unchecked",
              RuntimeException.class.isAssignableFrom(InvalidStudentException.class));
        check("T10", "CourseFullException is checked",
              !RuntimeException.class.isAssignableFrom(CourseFullException.class));
        check("T11", "failed enrolment does not change the roll", s.getCourse("A1").getEnrolled().size() == 2);
        check("T12", "distinct students counts each name once", s.distinctStudents() == 2);

        s.enroll("B2", "Meera");
        Set<String> both = s.inBoth("A1", "B2");
        check("T13", "intersection = {Asha}", both.equals(new HashSet<String>(Arrays.asList("Asha"))));
        check("T14", "union has 3 students", s.inEither("A1", "B2").size() == 3);
        check("T15", "coursesOf(Asha) = [A1, B2]", s.coursesOf("Asha").equals(Arrays.asList("A1", "B2")));
        check("T16", "sortedRoll is alphabetical",
              s.sortedRoll("B2").equals(Arrays.asList("Asha", "Meera")));
        check("T17", "drop returns true and frees a seat",
              s.drop("A1", "Ravi") && s.getCourse("A1").seatsLeft() == 1);
        check("T18", "drop of a non-member returns false", !s.drop("A1", "Ravi"));
        check("T19", "student with no courses leaves the HashSet",
              s.coursesOf("Ravi").isEmpty() && s.distinctStudents() == 2);
        check("T20", "courseCodes are sorted", s.courseCodes().equals(Arrays.asList("A1", "B2")));
        check("T21", "capacity 0 is rejected", thrown(() -> new Course("X", "X", 0)) == IllegalArgumentException.class);
        check("T22", "divide(10, 0) throws ArithmeticException",
              thrown(() -> ExceptionDemo.divide(10, 0)) == ArithmeticException.class);
        check("T23", "parse(\"abc\") throws NumberFormatException",
              thrown(() -> ExceptionDemo.parse("abc")) == NumberFormatException.class);
        check("T24", "checkAge(-1) throws a checked Exception",
              thrown(() -> ExceptionDemo.checkAge(-1)) == Exception.class);
        check("T25", "checkAge(30) is accepted", thrown(() -> ExceptionDemo.checkAge(30)) == null);

        System.out.println();
        System.out.println("Passed: " + passed + "   Failed: " + failed);
        if (failed > 0) System.exit(1);
    }
}
