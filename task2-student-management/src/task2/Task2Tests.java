package task2;

/** Self-checking tests for Student and StudentManager. */
public class Task2Tests {
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
        Student a = new Student(1, "Asha", 90, 95, 100);
        check("T1", "total = 285", a.total() == 285);
        check("T2", "percentage = 95.00", Math.abs(a.percentage() - 95.0) < 1e-9);
        check("T3", "grade A for 95%", a.grade() == 'A');
        check("T4", "grade B for 75-89%", new Student(2, "B", 80, 75, 70).grade() == 'B');
        check("T5", "grade C for 60-74%", new Student(3, "C", 60, 65, 70).grade() == 'C');
        check("T6", "grade D for 45-59%", new Student(4, "D", 45, 50, 55).grade() == 'D');
        check("T7", "grade E for below 45% with all subjects passed", new Student(5, "E", 36, 40, 44).grade() == 'E');
        check("T8", "failing one subject gives F even with a high average",
              new Student(6, "F", 100, 100, 20).grade() == 'F');
        check("T9", "marks above 100 are rejected", throwsIAE(() -> new Student(7, "X", 101, 0, 0)));
        check("T10", "negative marks are rejected", throwsIAE(() -> new Student(8, "X", -1, 0, 0)));
        check("T11", "empty name is rejected", throwsIAE(() -> new Student(9, " ", 1, 1, 1)));
        check("T12", "roll number 0 is rejected", throwsIAE(() -> new Student(0, "X", 1, 1, 1)));

        StudentManager m = new StudentManager();
        check("T13", "new manager is empty and has no topper", m.count() == 0 && m.topper() == null);
        check("T14", "class average of empty manager is 0", m.classAveragePercentage() == 0);
        check("T15", "add returns true for a new roll", m.add(a));
        check("T16", "duplicate roll number is refused", !m.add(new Student(1, "Other", 1, 1, 1)));
        m.add(new Student(2, "Ravi", 60, 70, 80));
        m.add(new Student(3, "Meera", 99, 98, 97));
        check("T17", "count = 3", m.count() == 3);
        check("T18", "find returns the right student", m.find(2) != null && "Ravi".equals(m.find(2).getName()));
        check("T19", "find returns null for unknown roll", m.find(99) == null);
        check("T20", "topper is Meera (total 294)", "Meera".equals(m.topper().getName()));
        check("T21", "update marks changes the total", m.updateMarks(2, 100, 100, 100) && m.find(2).total() == 300);
        check("T22", "topper changes after the update", "Ravi".equals(m.topper().getName()));
        check("T23", "update of unknown roll returns false", !m.updateMarks(77, 1, 1, 1));
        check("T24", "countWithGrade(A) = 3", m.countWithGrade('A') == 3);
        check("T25", "remove returns true and count drops", m.remove(3) && m.count() == 2);
        check("T26", "remove of unknown roll returns false", !m.remove(3));
        check("T27", "class average = (95 + 100) / 2", Math.abs(m.classAveragePercentage() - 97.5) < 1e-9);

        System.out.println();
        System.out.println("Passed: " + passed + "   Failed: " + failed);
        if (failed > 0) System.exit(1);
    }
}
