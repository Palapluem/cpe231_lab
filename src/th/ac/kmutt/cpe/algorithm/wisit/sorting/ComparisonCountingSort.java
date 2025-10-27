package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class ComparisonCountingSort {
    public ArrayList<Integer> comparisonCountingSort(ArrayList<Integer> A) {
        int n = A.size();

        // Initialize Count array
        ArrayList<Integer> Count = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Count.add(0);
        }

        // for i ← 0 to n - 1 do Count[i] ← 0
        // (already done above)

        // for i ← 0 to n - 2 do
        for (int i = 0; i < n - 1; i++) {
            // for j ← i + 1 to n - 1 do
            for (int j = i + 1; j < n; j++) {
                // if A[i] < A[j]
                if (A.get(i) < A.get(j)) {
                    // Count[j] ← Count[j] + 1
                    Count.set(j, Count.get(j) + 1);
                } else {
                    // else Count[i] ← Count[i] + 1
                    Count.set(i, Count.get(i) + 1);
                }
            }
        }

        // Initialize output array S
        ArrayList<Integer> S = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            S.add(0);
        }

        // for i ← 0 to n - 1 do S[Count[i]] ← A[i]
        for (int i = 0; i < n; i++) {
            S.set(Count.get(i), A.get(i));
        }

        // return S
        return S;
    }
}
