package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class QuickSort {

    private LomutoPartition partition;

    public QuickSort() {
        this.partition = new LomutoPartition();
    }

    public void quicksort(ArrayList<Integer> A, int l, int r) {
        // if l < r
        if (l < r) {
            // s ← Partition(A[l..r]) //s is a split position
            int s = partition.partition(A, l, r);

            // Quicksort(A[l..s-1])
            quicksort(A, l, s - 1);

            // Quicksort(A[s+1..r])
            quicksort(A, s + 1, r);
        }
    }
}
