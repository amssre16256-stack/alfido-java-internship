package task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Case study: how much does the choice of collection matter for lookups?
 * For each size n the program looks up every id 0..n-1, once in an ArrayList
 * (List.contains = linear search) and once in a HashMap (containsKey = hashing).
 * Timings depend on the machine and the moment of the run, so compare the
 * growth between sizes rather than the exact numbers.
 */
public class LookupBenchmark {

    private static long timeListLookups(List<Integer> list, int n) {
        long start = System.nanoTime();
        int found = 0;
        for (int id = 0; id < n; id++) {
            if (list.contains(id)) {
                found++;
            }
        }
        long elapsed = System.nanoTime() - start;
        if (found != n) {
            throw new IllegalStateException("lookup failed");
        }
        return elapsed;
    }

    private static long timeMapLookups(Map<Integer, String> map, int n) {
        long start = System.nanoTime();
        int found = 0;
        for (int id = 0; id < n; id++) {
            if (map.containsKey(id)) {
                found++;
            }
        }
        long elapsed = System.nanoTime() - start;
        if (found != n) {
            throw new IllegalStateException("lookup failed");
        }
        return elapsed;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 20000};
        System.out.printf("%-8s %18s %18s%n", "n", "ArrayList (ms)", "HashMap (ms)");
        for (int n : sizes) {
            List<Integer> list = new ArrayList<Integer>();
            Map<Integer, String> map = new HashMap<Integer, String>();
            for (int i = 0; i < n; i++) {
                list.add(i);
                map.put(i, "student" + i);
            }
            timeListLookups(list, n);                    // warm-up
            timeMapLookups(map, n);
            double listMs = timeListLookups(list, n) / 1e6;
            double mapMs = timeMapLookups(map, n) / 1e6;
            System.out.printf("%-8d %18.3f %18.3f%n", n, listMs, mapMs);
        }
    }
}
