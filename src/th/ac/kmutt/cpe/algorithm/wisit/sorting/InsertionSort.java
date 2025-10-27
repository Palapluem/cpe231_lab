package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;
import th.ac.kmutt.cpe.algorithm.wisit.searching.BinarySearch;

/**
 * Insertion Sort Algorithm Implementation
 * Sorts a given array by insertion sort
 * Input: An array A[0..n-1] of n orderable elements
 * Output: Array A[0..n-1] sorted in nondecreasing order
 */
public class InsertionSort<T extends Comparable<T>> implements SortStrategy<T> {

    private BinarySearch<T> binarySearch;

    public InsertionSort() {
        this.binarySearch = new BinarySearch<>();
    }

    @Override
    public int sort(ArrayList<T> list, T target) {
        insertionSort(list);
        return binarySearch.search(list, target);
    }

    public void insertionSort(ArrayList<T> A) {
        int n = A.size();

        // for i ← 1 to n - 1 do
        for (int i = 1; i < n; i++) {
            // v ← A[i]
            T v = A.get(i);

            // j ← i - 1
            int j = i - 1;

            // while j ≥ 0 and A[j] > v do
            while (j >= 0 && A.get(j).compareTo(v) > 0) {
                // A[j + 1] ← A[j]
                A.set(j + 1, A.get(j));

                // j ← j - 1
                j = j - 1;
            }

            // A[j + 1] ← v
            A.set(j + 1, v);
        }
    }
}
