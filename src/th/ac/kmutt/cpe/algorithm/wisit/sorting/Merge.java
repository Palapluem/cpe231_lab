package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class Merge {
    public void merge(ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> A) {
        int p = B.size();
        int q = C.size();

        // i ← 0; j ← 0; k ← 0
        int i = 0;
        int j = 0;
        int k = 0;

        // while i < p and j < q do
        while (i < p && j < q) {
            // if B[i] ≤ C[j]
            if (B.get(i) <= C.get(j)) {
                // A[k] ← B[i]; i ← i + 1
                A.set(k, B.get(i));
                i = i + 1;
            } else {
                // else A[k] ← C[j]; j ← j + 1
                A.set(k, C.get(j));
                j = j + 1;
            }

            // k ← k + 1
            k = k + 1;
        }

        // if i = p
        if (i == p) {
            // copy C[j..q-1] to A[k..p+q-1]
            while (j < q) {
                A.set(k, C.get(j));
                j++;
                k++;
            }
        } else {
            // else copy B[i..p-1] to A[k..p+q-1]
            while (i < p) {
                A.set(k, B.get(i));
                i++;
                k++;
            }
        }
    }
}
