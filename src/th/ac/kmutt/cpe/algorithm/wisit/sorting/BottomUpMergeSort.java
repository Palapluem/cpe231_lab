package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

// Bottom-up (iterative) Merge Sort: follows the worksheet pseudocode closely.
public class BottomUpMergeSort {
    public void sort(ArrayList<Integer> A) {
        int n = A.size();
        if (n < 2)
            return; // if n < 2 then return

        // temp buffer (same size as A) used by merge
        ArrayList<Integer> temp = new ArrayList<>(n);
        for (int t = 0; t < n; t++)
            temp.add(0);

        int i = 1; // Initial subarray size
        while (i < n) { // while i < n do
            int j = 0; // j <- 0
            while (j < n - i) { // while j < n - i do
                int left = j;
                int mid = j + i;
                int right = Math.min(j + 2 * i, n);

                // if n < j + (2 x i) then merge(A, j, j + i, n)
                // else merge(A, j, j + i, j + (2 x i))
                merge(A, temp, left, mid, right);

                j = j + 2 * i; // j <- j + 2 x i
            }
            i = i * 2; // i <- i x 2
        }
    }

    // Merge two sorted subarrays A[l..m-1] and A[m..r-1] into A[l..r-1]
    private void merge(ArrayList<Integer> A, ArrayList<Integer> temp, int l, int m, int r) {
        int p = l; // pointer in left run
        int q = m; // pointer in right run
        int k = l; // write position in temp

        while (p < m && q < r) {
            if (A.get(p) <= A.get(q)) {
                temp.set(k++, A.get(p++));
            } else {
                temp.set(k++, A.get(q++));
            }
        }
        while (p < m)
            temp.set(k++, A.get(p++));
        while (q < r)
            temp.set(k++, A.get(q++));

        // copy back to A
        for (int t = l; t < r; t++)
            A.set(t, temp.get(t));
    }
}
