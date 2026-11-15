# Task 2 - Console-Based Mini Project: Student Management System

**Goal:** build a simple console application that applies Java fundamentals.

## Files (`src/task2/`)

| File | Purpose |
|------|---------|
| `Student.java` | roll number, name, marks in three subjects; total, percentage and grade |
| `StudentManager.java` | the list of students and the operations on it (no input or output) |
| `Main.java` | menu loop, `Scanner` input and input validation |
| `Task2Tests.java` | 27 self-checking tests of the logic classes |

## Features

1. Add student  2. View all  3. Search by roll number  4. Update marks
5. Delete student  6. Show topper  7. Class statistics  0. Exit

* Input comes from `Scanner`; every number is read as a line and parsed, so a wrong entry such as `abc` never crashes the program.
* Conditional logic: grade rules (a student who fails any subject gets F), duplicate roll numbers are refused.
* Loops: the menu is a `do-while` loop; each input prompt repeats until the value is valid.

## Grade rules

Pass mark is 35 in every subject, otherwise grade F. Otherwise by percentage:
A 90+, B 75-89, C 60-74, D 45-59, E below 45.

## Run

```
javac -d out src/task2/*.java
java -cp out task2.Main
java -cp out task2.Task2Tests
```
