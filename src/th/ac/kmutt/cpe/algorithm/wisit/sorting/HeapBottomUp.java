package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class HeapBottomUp {
    // Generic method สำหรับ Integer
    public void heapBottomUp(ArrayList<Integer> H) {
        int n = H.size() - 1; // excluding index 0

        // for i ← ⌊n/2⌋ downto 1 do
        for (int i = n / 2; i >= 1; i--) {
            // k ← i; v ← H[k]
            int k = i;
            Integer v = H.get(k);

            // heap ← false
            boolean heap = false;

            // while not heap and 2 * k ≤ n do
            while (!heap && 2 * k <= n) {
                // j ← 2 * k
                int j = 2 * k;

                // if j < n //there are two children
                if (j < n) {
                    // if H[j] < H[j + 1] j ← j + 1
                    if (H.get(j).compareTo(H.get(j + 1)) < 0) {
                        j = j + 1;
                    }
                }

                // if v ≥ H[j]
                if (v.compareTo(H.get(j)) >= 0) {
                    // heap ← true
                    heap = true;
                } else {
                    // else H[k] ← H[j]; k ← j
                    H.set(k, H.get(j));
                    k = j;
                }
            }

            // H[k] ← v
            H.set(k, v);
        }
    }

    // Method สำหรับ Long
    public void heapBottomUpLong(ArrayList<Long> H) {
        int n = H.size() - 1; // excluding index 0

        // for i ← ⌊n/2⌋ downto 1 do
        for (int i = n / 2; i >= 1; i--) {
            // k ← i; v ← H[k]
            int k = i;
            Long v = H.get(k);

            // heap ← false
            boolean heap = false;

            // while not heap and 2 * k ≤ n do
            while (!heap && 2 * k <= n) {
                // j ← 2 * k
                int j = 2 * k;

                // if j < n //there are two children
                if (j < n) {
                    // if H[j] < H[j + 1] j ← j + 1
                    if (H.get(j).compareTo(H.get(j + 1)) < 0) {
                        j = j + 1;
                    }
                }

                // if v ≥ H[j]
                if (v.compareTo(H.get(j)) >= 0) {
                    // heap ← true
                    heap = true;
                } else {
                    // else H[k] ← H[j]; k ← j
                    H.set(k, H.get(j));
                    k = j;
                }
            }

            // H[k] ← v
            H.set(k, v);
        }
    }
}
