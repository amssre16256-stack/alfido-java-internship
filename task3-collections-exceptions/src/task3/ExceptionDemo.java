package task3;

/** Examples of try-catch-finally, multi-catch, throw/throws and try-with-resources. */
public class ExceptionDemo {

    /** A resource that reports when it is opened and closed. */
    static class Resource implements AutoCloseable {
        private final String name;

        Resource(String name) {
            this.name = name;
            System.out.println("  opened " + name);
        }

        void use(boolean fail) {
            System.out.println("  using " + name);
            if (fail) {
                throw new IllegalStateException("failure while using " + name);
            }
        }

        @Override
        public void close() {
            System.out.println("  closed " + name);
        }
    }

    public static int divide(int a, int b) {
        return a / b;                                   // may throw ArithmeticException
    }

    public static int parse(String text) {
        return Integer.parseInt(text);                  // may throw NumberFormatException
    }

    /** Declares the checked exception with 'throws' so the caller must handle it. */
    public static void checkAge(int age) throws Exception {
        if (age < 0 || age > 120) {
            throw new Exception("Age out of range: " + age);
        }
    }

    public static void run() {
        System.out.println("1. ArithmeticException");
        try {
            System.out.println("  10 / 0 = " + divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("  caught: " + e.getMessage());
        } finally {
            System.out.println("  finally block runs");
        }

        System.out.println("2. NumberFormatException");
        try {
            System.out.println("  parse(\"42\") = " + parse("42"));
            System.out.println("  parse(\"4x2\") = " + parse("4x2"));
        } catch (NumberFormatException e) {
            System.out.println("  caught: " + e.getMessage());
        }

        System.out.println("3. ArrayIndexOutOfBoundsException and NullPointerException (multi-catch)");
        int[] arr = new int[3];
        String s = null;
        for (int i = 0; i < 2; i++) {
            try {
                if (i == 0) {
                    arr[5] = 1;
                } else {
                    System.out.println(s.length());
                }
            } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                System.out.println("  caught " + e.getClass().getSimpleName());
            }
        }

        System.out.println("4. Checked exception with throws");
        int[] ages = {25, 150};
        for (int age : ages) {
            try {
                checkAge(age);
                System.out.println("  age " + age + " accepted");
            } catch (Exception e) {
                System.out.println("  caught: " + e.getMessage());
            }
        }

        System.out.println("5. try-with-resources closes the resource even when an exception occurs");
        try (Resource r = new Resource("report.txt")) {
            r.use(true);
        } catch (IllegalStateException e) {
            System.out.println("  caught: " + e.getMessage());
        }
    }
}
