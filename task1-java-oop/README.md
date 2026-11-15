Author: Jatin Jadaun (Candidate ID BS/REG/128507)
Internship: Java Developer Intern, Alfido Tech, 10 Aug 2026 - 10 Sep 2026
This repository contains my solutions to three of the four internship tasks
(the internship asked for any three). Each task is a separate, self-contained
Java project with its own source folder, tests and README.
Task	Folder	What it shows
1	`task1-java-oop/`	Java basics (loops, conditions, arrays) and OOP: classes, objects, inheritance, polymorphism, encapsulation
2	`task2-student-management/`	Console Student Management System: Scanner input, menus, conditions, loops
3	`task3-collections-exceptions/`	ArrayList, HashMap, HashSet, try-catch-finally and custom exceptions
Requirements
JDK 8 or newer (tested with JDK 21). Check with `javac -version`.
No external libraries. Tests are plain Java programs that print PASS or FAIL.
How to build and run
Open a terminal inside the task folder. The commands are the same on
Windows (Command Prompt / PowerShell), Linux and macOS.
```
cd task1-java-oop
javac -d out src/task1/*.java
java -cp out task1.Main
java -cp out task1.Task1Tests
```
```
cd task2-student-management
javac -d out src/task2/*.java
java -cp out task2.Main
java -cp out task2.Task2Tests
```
```
cd task3-collections-exceptions
javac -d out src/task3/*.java
java -cp out task3.Main
java -cp out task3.Task3Tests
```
Test results (JDK 21)
Task	Test class	Result
1	`Task1Tests`	33 passed, 0 failed
2	`Task2Tests`	27 passed, 0 failed
3	`Task3Tests`	25 passed, 0 failed
All three projects compile with `javac -Xlint:all` without warnings.
Repository layout
```
alfido-java-internship/
  README.md
  .gitignore
  task1-java-oop/src/task1/...
  task2-student-management/src/task2/...
  task3-collections-exceptions/src/task3/...
```
