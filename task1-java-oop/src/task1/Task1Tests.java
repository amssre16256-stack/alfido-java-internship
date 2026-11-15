package task1;

import java.util.Arrays;

/** Small self-checking test runner (no external library needed). */
public class Task1Tests {
    private static int passed = 0;
    private static int failed = 0;

    private static void check(String id, String what, boolean ok) {
        System.out.println((ok ? "PASS " : "FAIL ") + id + "  " + what);
        if (ok) passed++; else failed++;
    }

    private static boolean throwsIAE(Runnable r) {
        try {
            r.run();
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public static void main(String[] args) {
        check("T1", "isPrime(2) is true", BasicsDemo.isPrime(2));
        check("T2", "isPrime(1) is false", !BasicsDemo.isPrime(1));
        check("T3", "isPrime(97) is true", BasicsDemo.isPrime(97));
        check("T4", "isPrime(100) is false", !BasicsDemo.isPrime(100));
        check("T5", "fizzBuzz(15) = FizzBuzz", "FizzBuzz".equals(BasicsDemo.fizzBuzz(15)));
        check("T6", "fizzBuzz(9) = Fizz", "Fizz".equals(BasicsDemo.fizzBuzz(9)));
        check("T7", "fizzBuzz(7) = 7", "7".equals(BasicsDemo.fizzBuzz(7)));
        check("T8", "factorial(0) = 1", BasicsDemo.factorial(0) == 1);
        check("T9", "factorial(10) = 3628800", BasicsDemo.factorial(10) == 3628800L);
        check("T10", "factorial(21) is rejected", throwsIAE(() -> BasicsDemo.factorial(21)));
        check("T11", "grade(90) = A and grade(39) = F",
              BasicsDemo.grade(90) == 'A' && BasicsDemo.grade(39) == 'F');
        check("T12", "dayName(8) = Invalid day", "Invalid day".equals(BasicsDemo.dayName(8)));

        int[] a = {5, 2, 9, 1};
        check("T13", "sum = 17", BasicsDemo.sum(a) == 17);
        check("T14", "average = 4.25", BasicsDemo.average(a) == 4.25);
        check("T15", "max = 9 and min = 1", BasicsDemo.max(a) == 9 && BasicsDemo.min(a) == 1);
        check("T16", "reverse works",
              Arrays.equals(BasicsDemo.reverse(a), new int[]{1, 9, 2, 5}));
        int[] b = a.clone();
        BasicsDemo.bubbleSort(b);
        check("T17", "bubbleSort sorts", Arrays.equals(b, new int[]{1, 2, 5, 9}));
        check("T18", "linearSearch finds 9 at index 2", BasicsDemo.linearSearch(a, 9) == 2);
        check("T19", "linearSearch returns -1 when absent", BasicsDemo.linearSearch(a, 4) == -1);
        check("T20", "average of empty array is rejected",
              throwsIAE(() -> BasicsDemo.average(new int[0])));

        check("T21", "Circle(1) area = pi", Math.abs(new Circle(1).area() - Math.PI) < 1e-9);
        check("T22", "Rectangle(4,6) area = 24 and perimeter = 20",
              new Rectangle(4, 6).area() == 24 && new Rectangle(4, 6).perimeter() == 20);
        check("T23", "Square(3) is a Rectangle with area 9",
              new Square(3) instanceof Rectangle && new Square(3).area() == 9);
        check("T24", "Triangle(3,4,5) area = 6", Math.abs(new Triangle(3, 4, 5).area() - 6) < 1e-9);
        check("T25", "Triangle(1,2,10) is rejected", throwsIAE(() -> new Triangle(1, 2, 10)));
        check("T26", "Circle(-1) is rejected", throwsIAE(() -> new Circle(-1)));

        Employee e = new Employee("Test", 1000);
        Employee m = new Manager("Boss", 1000, 3);
        Employee d = new Developer("Dev", 1000, 2);
        check("T27", "Employee salary = 1000", e.calculateSalary() == 1000);
        check("T28", "Manager salary = 1000 + 3 x 2000", m.calculateSalary() == 7000);
        check("T29", "Developer salary = 1000 + 2 x 500", d.calculateSalary() == 2000);
        check("T30", "empty name is rejected", throwsIAE(() -> e.setName("  ")));
        check("T31", "negative salary is rejected", throwsIAE(() -> e.setBaseSalary(-5)));
        check("T32", "ids are unique and increasing", m.getId() == e.getId() + 1 && d.getId() == m.getId() + 1);

        Calculator c = new Calculator();
        check("T33", "overloaded add: int, int, double and String",
              c.add(1, 2) == 3 && c.add(1, 2, 3) == 6 && c.add(1.5, 2.5) == 4.0 && "ab".equals(c.add("a", "b")));

        System.out.println();
        System.out.println("Passed: " + passed + "   Failed: " + failed);
        if (failed > 0) System.exit(1);
    }
}
