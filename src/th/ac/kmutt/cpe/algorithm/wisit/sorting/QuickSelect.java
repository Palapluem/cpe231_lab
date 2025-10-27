package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class QuickSelect {

    private LomutoPartition lomutoPartition;

    public QuickSelect() {
        this.lomutoPartition = new LomutoPartition();
    }

    public int quickselect(ArrayList<Integer> A, int l, int r, int k) {
        // Interpret k as 1-based order statistic within subarray A[l..r]
        // Base case
        if (l == r)
            return A.get(l);

        int s = lomutoPartition.partition(A, l, r);
        int order = s - l + 1; // rank of pivot within A[l..r]

        if (order == k) {
            return A.get(s);
        } else if (k < order) {
            return quickselect(A, l, s - 1, k);
        } else {
            return quickselect(A, s + 1, r, k - order);
        }
    }
}
