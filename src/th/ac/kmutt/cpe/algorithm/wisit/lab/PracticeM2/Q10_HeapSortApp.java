package th.ac.kmutt.cpe.algorithm.wisit.lab.PracticeM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithm.wisit.sorting.HeapBottomUp;

public class Q10_HeapSortApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] a = new int[n + 1]; // 1-based indexing; a[0] unused
            ArrayList<Integer> H = new ArrayList<>(n + 1);
            H.add(0); // dummy at index 0
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
                H.add(-a[i]); // negate to reuse max-heapify as min-heap
            }

            new HeapBottomUp().heapBottomUp(H); // now H is max-heap over negatives

            // Line 1: print array after first Min-Heapify (from H)
            StringBuilder out = new StringBuilder(Math.max(16, n * 4));
            for (int i = 1; i <= n; i++) {
                if (i > 1)
                    out.append(' ');
                out.append(-H.get(i)); // convert back to original values (min-heap)
            }
            out.append('\n');

            // For descending line: simply sort and print from high to low
            Arrays.sort(a, 1, n + 1);
            for (int i = n; i >= 1; i--) {
                if (i < n)
                    out.append(' ');
                out.append(a[i]);
            }
            out.append('\n');

            System.out.print(out.toString());
        }
    }
}