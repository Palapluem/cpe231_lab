package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class Mergesort {

    private Merge merge;

    public Mergesort() {
        this.merge = new Merge();
    }

    public void mergesort(ArrayList<Integer> A) {
        int n = A.size();

        // if n > 1
        if (n > 1) {
            // copy A[0..⌊n/2⌋-1] to B[0..⌊n/2⌋-1]
            ArrayList<Integer> B = new ArrayList<>();
            for (int i = 0; i < n / 2; i++) {
                B.add(A.get(i));
            }

            // copy A[⌊n/2⌋..n-1] to C[0..⌈n/2⌉-1]
            ArrayList<Integer> C = new ArrayList<>();
            for (int i = n / 2; i < n; i++) {
                C.add(A.get(i));
            }

            // Mergesort(B[0..⌊n/2⌋-1])
            mergesort(B);

            // Mergesort(C[0..⌈n/2⌉-1])
            mergesort(C);

            // Merge(B, C, A)
            merge.merge(B, C, A);
        }
    }
}
