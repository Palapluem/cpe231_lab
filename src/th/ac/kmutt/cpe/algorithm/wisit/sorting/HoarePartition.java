package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class HoarePartition {
    public int partition(ArrayList<Integer> A, int l, int r) {
        // p ← A[l]
        int p = A.get(l);

        // i ← l; j ← r + 1
        int i = l;
        int j = r + 1;

        // repeat
        do {
            // repeat i ← i + 1 until A[i] ≥ p
            do {
                i = i + 1;
            } while (i <= r && A.get(i) < p);

            // repeat j ← j - 1 until A[j] ≤ p
            do {
                j = j - 1;
            } while (A.get(j) > p);

            // swap(A[i], A[j])
            swap(A, i, j);

        } while (i < j); // until i ≥ j

        // swap(A[i], A[j]) //undo last swap when i ≥ j
        swap(A, i, j);

        // swap(A[l], A[j])
        swap(A, l, j);

        // return j
        return j;
    }

    private void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
