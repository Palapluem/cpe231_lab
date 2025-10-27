package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class UniqueElements {
    public boolean uniqueElements(ArrayList<Integer> A) {
        int n = A.size();

        // for i ← 0 to n - 2 do
        for (int i = 0; i < n - 1; i++) {
            // for j ← i + 1 to n - 1 do
            for (int j = i + 1; j < n; j++) {
                // if A[i] = A[j] return false
                if (A.get(i).equals(A.get(j))) {
                    return false;
                }
            }
        }

        // return true
        return true;
    }
}
