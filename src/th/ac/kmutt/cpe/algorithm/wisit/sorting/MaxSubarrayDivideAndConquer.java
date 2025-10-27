package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class MaxSubarrayDivideAndConquer {

    public long maxSubarraySum(ArrayList<Integer> a) {
        if (a == null || a.isEmpty())
            return 0L;
        return solve(a, 0, a.size() - 1);
    }

    private long solve(ArrayList<Integer> a, int l, int r) {
        if (l == r)
            return a.get(l);
        int m = (l + r) >>> 1;

        long leftBest = solve(a, l, m);
        long rightBest = solve(a, m + 1, r);

        // best suffix of left half
        long sum = 0, bestLeftSuffix = Long.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum += a.get(i);
            if (sum > bestLeftSuffix)
                bestLeftSuffix = sum;
        }

        // best prefix of right half
        sum = 0;
        long bestRightPrefix = Long.MIN_VALUE;
        for (int i = m + 1; i <= r; i++) {
            sum += a.get(i);
            if (sum > bestRightPrefix)
                bestRightPrefix = sum;
        }

        long cross = bestLeftSuffix + bestRightPrefix;
        return Math.max(Math.max(leftBest, rightBest), cross);
    }
}
