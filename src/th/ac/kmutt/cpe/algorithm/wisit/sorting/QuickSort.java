package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

/**
 * Quicksort strategy using Lomuto's partition by default (do not modify unless
 * required by a specific exercise).
 */
public class QuickSort {

    private LomutoPartition partition;

    public QuickSort() {
        this.partition = new LomutoPartition();
    }

    public void quicksort(ArrayList<Integer> A, int l, int r) {
        // if l < r
        if (l < r) {
            // s ← Partition(A[l..r]) // s is a split position
            int s = partition.partition(A, l, r);

            // Quicksort(A[l..s − 1]) and Quicksort(A[s + 1..r])
            quicksort(A, l, s - 1);
            quicksort(A, s + 1, r);
        }
    }
}
