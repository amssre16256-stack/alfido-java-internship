# Task 3 - Collections and Exception Handling

**Goal:** manage data efficiently with collections and handle runtime errors.

The project is a small course-enrolment system.

## Files (`src/task3/`)

| File | Purpose |
|------|---------|
| `Course.java` | a course with limited seats; students kept in an `ArrayList` |
| `EnrollmentService.java` | `HashMap` of courses, `HashSet` of distinct students, set operations |
| `CourseFullException.java` | custom checked exception |
| `DuplicateEnrollmentException.java` | custom checked exception |
| `CourseNotFoundException.java` | custom checked exception |
| `InvalidStudentException.java` | custom unchecked exception |
| `ExceptionDemo.java` | try-catch-finally, multi-catch, throws, try-with-resources |
| `Main.java` | runs the whole scenario |
| `LookupBenchmark.java` | timing case study: `ArrayList.contains` against `HashMap.containsKey` |
| `Task3Tests.java` | 25 self-checking tests |

## Collections used

* `ArrayList<String>`: the roll of each course, in the order students enrolled; sorted with `Collections.sort`.
* `HashMap<String, Course>`: course code to course, for lookup by code.
* `HashSet<String>`: all distinct students; `retainAll` gives the intersection and `addAll` the union of two courses.

## Exceptions

Checked: `CourseFullException`, `DuplicateEnrollmentException`, `CourseNotFoundException`.
Unchecked: `InvalidStudentException`. Built-in examples: `ArithmeticException`,
`NumberFormatException`, `ArrayIndexOutOfBoundsException`, `NullPointerException`.

## Run

```
javac -d out src/task3/*.java
java -cp out task3.Main
java -cp out task3.Task3Tests
java -cp out task3.LookupBenchmark
```
