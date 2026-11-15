# Task 1 - Java Basics and OOP Fundamentals

**Goal:** understand Java basics and object-oriented programming.

## Files (`src/task1/`)

| File | Purpose |
|------|---------|
| `BasicsDemo.java` | loops, conditions, switch, arrays: multiplication table, primes, FizzBuzz, factorial, grades, sum/average/max/min, reverse, bubble sort, search, transpose |
| `Shape.java` | abstract base class (abstraction) |
| `Circle.java`, `Rectangle.java`, `Triangle.java` | subclasses that override `area()` and `perimeter()` |
| `Square.java` | multilevel inheritance: Square -> Rectangle -> Shape |
| `Employee.java` | encapsulation: private fields, validated getters and setters |
| `Manager.java`, `Developer.java` | inheritance and method overriding of `calculateSalary()` |
| `Calculator.java` | method overloading |
| `Main.java` | runs every demonstration |
| `Task1Tests.java` | 33 self-checking tests |

## OOP concepts used

* **Encapsulation:** `Employee` keeps `name` and `baseSalary` private and validates them in the setters.
* **Inheritance:** `Manager` and `Developer` extend `Employee`; `Square` extends `Rectangle`.
* **Polymorphism:** a `Shape[]` and an `Employee[]` are processed in one loop, and each object runs its own overridden method (runtime). `Calculator.add` is overloaded (compile time).
* **Abstraction:** `Shape` declares abstract methods that every concrete shape must provide.

## Run

```
javac -d out src/task1/*.java
java -cp out task1.Main
java -cp out task1.Task1Tests
```
