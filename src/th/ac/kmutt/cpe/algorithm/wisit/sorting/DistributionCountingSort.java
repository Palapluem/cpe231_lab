package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class DistributionCountingSort {
    public ArrayList<Integer> distributionCountingSort(ArrayList<Integer> A, int l, int u) {
        int n = A.size();

        // Initialize D array for distribution
        ArrayList<Integer> D = new ArrayList<>();
        for (int j = 0; j <= u - l; j++) {
            D.add(0);
        }

        // for j ← 0 to u - l do D[j] ← 0 //initialize frequencies
        // (already done above)

        // for i ← 0 to n - 1 do D[A[i] - l] ← D[A[i] - l] + 1 //compute frequencies
        for (int i = 0; i < n; i++) {
            int index = A.get(i) - l;
            D.set(index, D.get(index) + 1);
        }

        // for j ← 1 to u - l do D[j] ← D[j - 1] + D[j] //reuse for distribution
        for (int j = 1; j <= u - l; j++) {
            D.set(j, D.get(j - 1) + D.get(j));
        }

        // Initialize output array S
        ArrayList<Integer> S = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            S.add(0);
        }

        // for i ← n - 1 downto 0 do
        for (int i = n - 1; i >= 0; i--) {
            // j ← A[i] - l
            int j = A.get(i) - l;

            // S[D[j] - 1] ← A[i]
            S.set(D.get(j) - 1, A.get(i));

            // D[j] ← D[j] - 1
            D.set(j, D.get(j) - 1);
        }

        // return S
        return S;
    }
}