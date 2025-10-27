package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class LomutoPartition {
    public int partition(ArrayList<Integer> A, int l, int r) {
        // p ← A[l]
        int p = A.get(l);

        // s ← l
        int s = l;

        // for i ← l + 1 to r do
        for (int i = l + 1; i <= r; i++) {
            // if A[i] < p
            if (A.get(i) < p) {
                // s ← s + 1; swap(A[s], A[i])
                s = s + 1;
                swap(A, s, i);
            }
        }

        // swap(A[l], A[s])
        swap(A, l, s);

        // return s
        return s;
    }

    // Swaps two elements in the ArrayList
    private void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
