package task2;

import java.util.List;
import java.util.Scanner;

/** Task 2: console-based Student Management System driven by a Scanner menu. */
public class Main {
    private static final Scanner IN = new Scanner(System.in);
    private static final StudentManager MANAGER = new StudentManager();

    public static void main(String[] args) {
        System.out.println("*** Student Management System ***");
        int choice;
        do {
            printMenu();
            choice = readInt("Enter your choice: ", 0, 7);
            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewAll(); break;
                case 3: searchStudent(); break;
                case 4: updateMarks(); break;
                case 5: deleteStudent(); break;
                case 6: showTopper(); break;
                case 7: showStatistics(); break;
                case 0: System.out.println("Thank you. Goodbye!"); break;
                default: break;
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("----- MENU -----");
        System.out.println("1. Add student");
        System.out.println("2. View all students");
        System.out.println("3. Search by roll number");
        System.out.println("4. Update marks");
        System.out.println("5. Delete student");
        System.out.println("6. Show topper");
        System.out.println("7. Class statistics");
        System.out.println("0. Exit");
    }

    // ------------------------------------------------------------ commands

    private static void addStudent() {
        int roll = readInt("Roll number: ", 1, 999999);
        if (MANAGER.find(roll) != null) {
            System.out.println("A student with roll number " + roll + " already exists.");
            return;
        }
        String name = readName("Name: ");
        int[] m = readMarks();
        MANAGER.add(new Student(roll, name, m[0], m[1], m[2]));
        System.out.println("Student added.");
    }

    private static void viewAll() {
        List<Student> list = MANAGER.all();
        if (list.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }
        printHeader();
        for (Student s : list) {
            printRow(s);
        }
    }

    private static void searchStudent() {
        int roll = readInt("Roll number to search: ", 1, 999999);
        Student s = MANAGER.find(roll);
        if (s == null) {
            System.out.println("No student with roll number " + roll + ".");
        } else {
            printHeader();
            printRow(s);
        }
    }

    private static void updateMarks() {
        int roll = readInt("Roll number to update: ", 1, 999999);
        if (MANAGER.find(roll) == null) {
            System.out.println("No student with roll number " + roll + ".");
            return;
        }
        int[] m = readMarks();
        MANAGER.updateMarks(roll, m[0], m[1], m[2]);
        System.out.println("Marks updated.");
    }

    private static void deleteStudent() {
        int roll = readInt("Roll number to delete: ", 1, 999999);
        System.out.println(MANAGER.remove(roll) ? "Student deleted."
                                                 : "No student with roll number " + roll + ".");
    }

    private static void showTopper() {
        Student t = MANAGER.topper();
        if (t == null) {
            System.out.println("No students yet.");
            return;
        }
        System.out.println("Topper:");
        printHeader();
        printRow(t);
    }

    private static void showStatistics() {
        if (MANAGER.count() == 0) {
            System.out.println("No students yet.");
            return;
        }
        System.out.println("Students            : " + MANAGER.count());
        System.out.printf("Class average       : %.2f%%%n", MANAGER.classAveragePercentage());
        for (char g : new char[] {'A', 'B', 'C', 'D', 'E', 'F'}) {
            int n = MANAGER.countWithGrade(g);
            if (n > 0) {
                System.out.println("Grade " + g + "             : " + n);
            }
        }
    }

    // ------------------------------------------------------------ printing

    private static void printHeader() {
        System.out.printf("%-6s %-14s %6s %8s %8s %7s %8s %5s%n",
                "Roll", "Name", "Maths", "Science", "English", "Total", "Percent", "Grade");
    }

    private static void printRow(Student s) {
        System.out.printf("%-6d %-14s %6d %8d %8d %7d %7.2f%% %5c%n",
                s.getRollNo(), s.getName(), s.getMarks(0), s.getMarks(1), s.getMarks(2),
                s.total(), s.percentage(), s.grade());
    }

    // ------------------------------------------------------- input helpers

    /** Reads a whole line; ends the program politely if the input has ended. */
    private static String readLine(String prompt) {
        System.out.print(prompt);
        if (!IN.hasNextLine()) {
            System.out.println();
            System.out.println("Input ended. Exiting.");
            System.exit(0);
        }
        return IN.nextLine().trim();
    }

    /** Keeps asking until the user types a whole number inside [min, max]. */
    private static int readInt(String prompt, int min, int max) {
        while (true) {
            String text = readLine(prompt);
            try {
                int v = Integer.parseInt(text);
                if (v >= min && v <= max) {
                    return v;
                }
                System.out.println("Please enter a number from " + min + " to " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number. Try again.");
            }
        }
    }

    private static String readName(String prompt) {
        while (true) {
            String s = readLine(prompt);
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Name cannot be empty.");
        }
    }

    private static int[] readMarks() {
        int[] m = new int[Student.SUBJECTS.length];
        for (int i = 0; i < m.length; i++) {
            m[i] = readInt("Marks in " + Student.SUBJECTS[i] + " (0-100): ", 0, 100);
        }
        return m;
    }
}
