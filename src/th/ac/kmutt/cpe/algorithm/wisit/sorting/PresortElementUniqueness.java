package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class PresortElementUniqueness {
    public boolean presortElementUniqueness(ArrayList<Integer> A) {
        int n = A.size();

        // sort the array A
        Collections.sort(A);

        // for i ← 0 to n - 2 do
        for (int i = 0; i < n - 1; i++) {
            // if A[i] = A[i + 1] return false
            if (A.get(i).equals(A.get(i + 1))) {
                return false;
            }
        }

        // return true
        return true;
    }
}
