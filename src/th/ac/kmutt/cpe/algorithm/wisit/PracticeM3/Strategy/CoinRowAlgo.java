package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

public class CoinRowAlgo {
    /**
     * Algorithm 2: CoinRow(C[1...n])
     * Finds the maximum amount of money that can be picked up from coin row without
     * picking two adjacent coins.
     * 
     * @param C Array of positive integers indicating coin values.
     * @return The maximum amount of money.
     */
    public int solve(int[] C) {
        int n = C.length;
        if (n == 0)
            return 0;
        int[] F = new int[n + 1];
        F[0] = 0;
        F[1] = C[0];
        for (int i = 2; i <= n; i++) {
            F[i] = Math.max(C[i - 1] + F[i - 2], F[i - 1]);
        }
        return F[n];
    }
}
