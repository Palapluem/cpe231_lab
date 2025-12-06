package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

public class ChangeMakingAlgo {
    /**
     * Algorithm 3: ChangeMaking(D[1...m], n)
     * Finds the minimum number of coins of denominations D that add up to n.
     * 
     * @param D Array of denominations (sorted increasing).
     * @param n Target amount.
     * @return The minimum number of coins.
     */
    public int solve(int[] D, int n) {
        int[] F = new int[n + 1];
        F[0] = 0;
        for (int i = 1; i <= n; i++) {
            int temp = Integer.MAX_VALUE;
            int j = 0;
            while (j < D.length && i >= D[j]) {
                if (F[i - D[j]] != Integer.MAX_VALUE) {
                    temp = Math.min(F[i - D[j]], temp);
                }
                j++;
            }
            if (temp != Integer.MAX_VALUE) {
                F[i] = temp + 1;
            } else {
                F[i] = Integer.MAX_VALUE; // Cannot make change
            }
        }
        return F[n];
    }
}
