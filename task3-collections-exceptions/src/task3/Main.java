package task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/** Task 3 driver: collections and exception handling in one course-enrolment scenario. */
public class Main {

    public static void main(String[] args) throws Exception {
        EnrollmentService svc = new EnrollmentService();
        svc.addCourse(new Course("JAVA101", "Core Java", 4));
        svc.addCourse(new Course("DSA201", "Data Structures", 3));
        svc.addCourse(new Course("DB301", "Databases", 5));

        System.out.println("=== Part 1: collections ===");
        System.out.println("Courses (HashMap keys, sorted): " + svc.courseCodes());

        String[] javaStudents = {"Jatin", "Asha", "Ravi", "Meera"};
        for (String s : javaStudents) {
            svc.enroll("JAVA101", s);
        }
        svc.enroll("DSA201", "Asha");
        svc.enroll("DSA201", "Karan");
        svc.enroll("DSA201", "Jatin");

        System.out.println("JAVA101 in enrolment order (ArrayList): " + svc.getCourse("JAVA101").getEnrolled());
        System.out.println("JAVA101 sorted                        : " + svc.sortedRoll("JAVA101"));
        System.out.println("Seats left in JAVA101 / DSA201        : "
                + svc.getCourse("JAVA101").seatsLeft() + " / " + svc.getCourse("DSA201").seatsLeft());
        System.out.println("Distinct students (HashSet)           : " + svc.distinctStudents());
        System.out.println("In both JAVA101 and DSA201 (intersection): " + new TreeSet<String>(svc.inBoth("JAVA101", "DSA201")));
        System.out.println("In either course (union)                 : " + new TreeSet<String>(svc.inEither("JAVA101", "DSA201")));
        System.out.println("Courses of Jatin                      : " + svc.coursesOf("Jatin"));

        System.out.println();
        System.out.println("Iterating over the HashMap:");
        for (String code : svc.courseCodes()) {
            Course c = svc.getCourse(code);
            System.out.printf("  %-8s %-16s %d/%d seats used%n", code, c.getTitle(),
                    c.getEnrolled().size(), c.getCapacity());
        }

        System.out.println();
        System.out.println("=== Part 2: custom exceptions ===");
        List<String[]> attempts = new ArrayList<String[]>();
        attempts.add(new String[] {"JAVA101", "Neha"});      // course is full
        attempts.add(new String[] {"JAVA101", "Asha"});      // duplicate (full also, duplicate is checked first)
        attempts.add(new String[] {"PHY999", "Neha"});       // unknown course
        attempts.add(new String[] {"DB301", "R2D2"});        // invalid name
        attempts.add(new String[] {"DB301", "  "});          // empty name
        attempts.add(new String[] {"DB301", "Neha"});        // fine
        for (String[] a : attempts) {
            try {
                svc.enroll(a[0], a[1]);
                System.out.println("OK        enrolled '" + a[1].trim() + "' in " + a[0]);
            } catch (CourseFullException e) {
                System.out.println("FULL      " + e.getMessage());
            } catch (DuplicateEnrollmentException | CourseNotFoundException e) {
                System.out.println("REJECTED  " + e.getMessage());
            } catch (InvalidStudentException e) {
                System.out.println("INVALID   " + e.getMessage());
            } finally {
                System.out.println("          (attempt for " + a[0] + " processed)");
            }
        }

        System.out.println();
        System.out.println("Dropping a student frees a seat:");
        System.out.println("  drop Ravi from JAVA101 -> " + svc.drop("JAVA101", "Ravi"));
        System.out.println("  seats left in JAVA101  -> " + svc.getCourse("JAVA101").seatsLeft());
        svc.enroll("JAVA101", "Neha");
        System.out.println("  Neha enrolled now      -> " + svc.getCourse("JAVA101").getEnrolled());

        System.out.println();
        System.out.println("=== Part 3: built-in exceptions ===");
        ExceptionDemo.run();

        System.out.println();
        System.out.println("=== Part 4: sorting with a Comparator ===");
        List<String> names = new ArrayList<String>(svc.inEither("JAVA101", "DSA201"));
        Collections.sort(names, new java.util.Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                int byLength = Integer.compare(x.length(), y.length());
                return byLength != 0 ? byLength : x.compareTo(y);
            }
        });
        System.out.println("Names by length, then alphabetically: " + names);
        Set<String> unique = new TreeSet<String>(names);
        System.out.println("Unique count: " + unique.size());
    }
}
