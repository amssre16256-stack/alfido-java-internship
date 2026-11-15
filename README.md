# Alfido Tech - Java Developer Internship Tasks

Author: Jatin Jadaun (Candidate ID BS/REG/128507)
Internship: Java Developer Intern, Alfido Tech, 10 Aug 2026 - 10 Sep 2026

This repository contains my solutions to three of the four internship tasks
(the internship asked for any three). Each task is a separate Java project with
its own source folder, tests and README. The three task documents (Word files)
with screenshots, code snippets and commands are in the main folder.

| Task | Folder | What it shows |
|------|--------|---------------|
| 1 | `task1-java-oop/` | Java basics (loops, conditions, arrays) and OOP: inheritance, polymorphism, encapsulation |
| 2 | `task2-student-management/` | Console Student Management System: Scanner input, menus, conditions, loops |
| 3 | `task3-collections-exceptions/` | ArrayList, HashMap, HashSet, try-catch-finally and custom exceptions |

## Requirements

* JDK 8 or newer (tested with JDK 21). Check with `javac -version`.
* No external libraries. Tests are plain Java programs that print PASS or FAIL.

## How to build and run (example for Task 1)

```
cd task1-java-oop
javac -d out src/task1/*.java
java -cp out task1.Main
java -cp out task1.Task1Tests
```

For Task 2 use `task2-student-management`, `src/task2/*.java`, `task2.Main`, `task2.Task2Tests`.
For Task 3 use `task3-collections-exceptions`, `src/task3/*.java`, `task3.Main`, `task3.Task3Tests`.

## Test results (JDK 21)

| Task | Test class | Result |
|------|------------|--------|
| 1 | `Task1Tests` | 33 passed, 0 failed |
| 2 | `Task2Tests` | 27 passed, 0 failed |
| 3 | `Task3Tests` | 25 passed, 0 failed |

All three projects compile with `javac -Xlint:all` without warnings.
