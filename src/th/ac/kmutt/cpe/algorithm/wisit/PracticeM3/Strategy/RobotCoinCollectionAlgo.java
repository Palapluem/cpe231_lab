package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

public class RobotCoinCollectionAlgo {
    /**
     * Algorithm 4: RobotCoinCollection(C[1...n, 1...m])
     * Computes the largest number of coins a robot can collect on an n x m board.
     * 
     * @param C Matrix where C[i][j] is 1 if there is a coin, 0 otherwise.
     * @return Largest number of coins collected.
     */
    public int solve(int[][] C) {
        int n = C.length;
        int m = C[0].length;
        int[][] F = new int[n + 1][m + 1];

        // F[1, 1] <- C[1, 1] (using 0-based indexing for input C)
        F[1][1] = C[0][0];

        // Initialize first row
        for (int j = 2; j <= m; j++) {
            F[1][j] = F[1][j - 1] + C[0][j - 1];
        }

        // Fill the rest
        for (int i = 2; i <= n; i++) {
            F[i][1] = F[i - 1][1] + C[i - 1][0];
            for (int j = 2; j <= m; j++) {
                F[i][j] = Math.max(F[i - 1][j], F[i][j - 1]) + C[i - 1][j - 1];
            }
        }
        return F[n][m];
    }
}
