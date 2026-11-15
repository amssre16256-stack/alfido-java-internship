package task1;

import java.util.Arrays;

/** Task 1 driver: runs every demonstration and prints the results. */
public class Main {

    public static void main(String[] args) {
        part("A. Loops and conditions");
        System.out.println("Multiplication table of 7:");
        BasicsDemo.multiplicationTable(7);
        StringBuilder primes = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (BasicsDemo.isPrime(i)) {
                primes.append(i).append(' ');
            }
        }
        System.out.println("Primes up to 30: " + primes.toString().trim());
        StringBuilder fb = new StringBuilder();
        for (int i = 1; i <= 15; i++) {
            fb.append(BasicsDemo.fizzBuzz(i)).append(i < 15 ? ", " : "");
        }
        System.out.println("FizzBuzz 1..15: " + fb);
        System.out.println("10! = " + BasicsDemo.factorial(10));
        System.out.println("Grade for 82 marks = " + BasicsDemo.grade(82));
        System.out.println("Day 3 = " + BasicsDemo.dayName(3));

        part("B. Arrays");
        int[] data = {42, 7, 19, 88, 3, 56};
        System.out.println("Array      : " + Arrays.toString(data));
        System.out.println("Sum        : " + BasicsDemo.sum(data));
        System.out.println("Average    : " + BasicsDemo.average(data));
        System.out.println("Max / Min  : " + BasicsDemo.max(data) + " / " + BasicsDemo.min(data));
        System.out.println("Reversed   : " + Arrays.toString(BasicsDemo.reverse(data)));
        System.out.println("Index of 19: " + BasicsDemo.linearSearch(data, 19));
        BasicsDemo.bubbleSort(data);
        System.out.println("Sorted     : " + Arrays.toString(data));
        int[][] m = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("Matrix     : " + Arrays.deepToString(m));
        System.out.println("Transpose  : " + Arrays.deepToString(BasicsDemo.transpose(m)));

        part("C. Inheritance and polymorphism with shapes");
        Shape[] shapes = {
            new Circle(5), new Rectangle(4, 6), new Square(3), new Triangle(3, 4, 5)
        };
        for (Shape s : shapes) {
            System.out.println(s.describe());
        }
        try {
            new Triangle(1, 2, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected triangle: " + e.getMessage());
        }

        part("D. Encapsulation and overriding with employees");
        Employee[] staff = {
            new Employee("Asha", 30000),
            new Manager("Ravi", 50000, 4),
            new Developer("Jatin", 40000, 12)
        };
        for (Employee e : staff) {
            System.out.println(e);
        }
        try {
            staff[0].setBaseSalary(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Setter rejected value: " + e.getMessage());
        }

        part("E. Method overloading");
        Calculator calc = new Calculator();
        System.out.println("add(2, 3)        = " + calc.add(2, 3));
        System.out.println("add(2, 3, 4)     = " + calc.add(2, 3, 4));
        System.out.println("add(2.5, 3.25)   = " + calc.add(2.5, 3.25));
        System.out.println("add(\"Jav\", \"a\") = " + calc.add("Jav", "a"));
    }

    private static void part(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }
}
