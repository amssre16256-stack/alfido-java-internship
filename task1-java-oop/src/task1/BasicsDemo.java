package task1;

/**
 * Task 1 (part A): Java basics - loops, conditions and arrays.
 * Every method is static and small so that it can be tested on its own.
 */
public class BasicsDemo {

    /** Prints the multiplication table of n up to 10 using a for loop. */
    public static void multiplicationTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    /** Returns true when n is a prime number (trial division up to sqrt(n)). */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /** Classic FizzBuzz value for one number, using if / else-if conditions. */
    public static String fizzBuzz(int i) {
        if (i % 15 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(i);
    }

    /** Iterative factorial, using a while loop. Valid for 0..20 (fits in long). */
    public static long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("n must be between 0 and 20");
        }
        long result = 1;
        int i = 2;
        while (i <= n) {
            result *= i;
            i++;
        }
        return result;
    }

    /** Converts marks to a grade with a chain of conditions. */
    public static char grade(int marks) {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else if (marks >= 40) {
            return 'D';
        }
        return 'F';
    }

    /** Day name using a switch statement (1 = Monday ... 7 = Sunday). */
    public static String dayName(int day) {
        switch (day) {
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            case 7: return "Sunday";
            default: return "Invalid day";
        }
    }

    // ---------------------------------------------------------------- arrays

    public static int sum(int[] a) {
        int total = 0;
        for (int v : a) {
            total += v;
        }
        return total;
    }

    public static double average(int[] a) {
        if (a.length == 0) {
            throw new IllegalArgumentException("array is empty");
        }
        return (double) sum(a) / a.length;
    }

    public static int max(int[] a) {
        int best = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > best) {
                best = a[i];
            }
        }
        return best;
    }

    public static int min(int[] a) {
        int best = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < best) {
                best = a[i];
            }
        }
        return best;
    }

    /** Returns a new array holding the elements of a in reverse order. */
    public static int[] reverse(int[] a) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            r[a.length - 1 - i] = a[i];
        }
        return r;
    }

    /** Sorts the array in place with bubble sort (stops early if already sorted). */
    public static void bubbleSort(int[] a) {
        for (int pass = 0; pass < a.length - 1; pass++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - pass; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /** Linear search; returns the index of key or -1. */
    public static int linearSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /** Transposes a 2D array (rows become columns). */
    public static int[][] transpose(int[][] m) {
        int[][] t = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                t[j][i] = m[i][j];
            }
        }
        return t;
    }
}
