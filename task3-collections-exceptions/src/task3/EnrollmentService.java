package task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Uses the three collections asked for in the task:
 *   HashMap  - course code  -> Course        (fast lookup by code)
 *   ArrayList- students of one course        (keeps enrolment order)
 *   HashSet  - every distinct student name   (no duplicates, set operations)
 */
public class EnrollmentService {
    private final Map<String, Course> courses = new HashMap<String, Course>();
    private final Set<String> allStudents = new HashSet<String>();

    public void addCourse(Course c) {
        courses.put(c.getCode(), c);
    }

    public Course getCourse(String code) throws CourseNotFoundException {
        Course c = courses.get(code);
        if (c == null) {
            throw new CourseNotFoundException(code);
        }
        return c;
    }

    /** Sorted list of course codes (HashMap order is not defined, so we sort for display). */
    public List<String> courseCodes() {
        List<String> codes = new ArrayList<String>(courses.keySet());
        Collections.sort(codes);
        return codes;
    }

    private static void validateName(String student) {
        if (student == null || student.trim().isEmpty()) {
            throw new InvalidStudentException("Student name cannot be empty");
        }
        for (char ch : student.toCharArray()) {
            if (Character.isDigit(ch)) {
                throw new InvalidStudentException("Student name cannot contain digits: " + student);
            }
        }
    }

    public void enroll(String courseCode, String student)
            throws CourseNotFoundException, CourseFullException, DuplicateEnrollmentException {
        validateName(student);
        String name = student.trim();
        Course c = getCourse(courseCode);
        c.enroll(name);
        allStudents.add(name);
    }

    public boolean drop(String courseCode, String student) throws CourseNotFoundException {
        Course c = getCourse(courseCode);
        boolean removed = c.drop(student);
        if (removed && coursesOf(student).isEmpty()) {
            allStudents.remove(student);
        }
        return removed;
    }

    public int distinctStudents() {
        return allStudents.size();
    }

    /** Sorted list of the courses a student is enrolled in. */
    public List<String> coursesOf(String student) {
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, Course> e : courses.entrySet()) {
            if (e.getValue().has(student)) {
                result.add(e.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }

    /** Students enrolled in both courses (intersection of two HashSets). */
    public Set<String> inBoth(String codeA, String codeB) throws CourseNotFoundException {
        Set<String> a = new HashSet<String>(getCourse(codeA).getEnrolled());
        a.retainAll(getCourse(codeB).getEnrolled());
        return a;
    }

    /** Students enrolled in at least one of the two courses (union of two HashSets). */
    public Set<String> inEither(String codeA, String codeB) throws CourseNotFoundException {
        Set<String> a = new HashSet<String>(getCourse(codeA).getEnrolled());
        a.addAll(getCourse(codeB).getEnrolled());
        return a;
    }

    /** Alphabetically sorted copy of a course roll (ArrayList + Collections.sort). */
    public List<String> sortedRoll(String code) throws CourseNotFoundException {
        List<String> roll = getCourse(code).getEnrolled();
        Collections.sort(roll);
        return roll;
    }
}
