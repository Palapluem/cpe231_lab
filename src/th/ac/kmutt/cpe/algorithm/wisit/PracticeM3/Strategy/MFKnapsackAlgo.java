package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

import java.util.Arrays;

public class MFKnapsackAlgo {
    /**
     * Algorithm 5: MFKnapsack(i, j)
     * Implements the memory function method for the knapsack problem.
     */

    private int[][] F;
    private int[] Weights;
    private int[] Values;

    public int solve(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        this.Weights = weights;
        this.Values = values;

        // F[0...n, 0...W] initialized with -1's except row 0 and col 0 with 0's
        this.F = new int[n + 1][capacity + 1];
        for (int[] row : F) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i <= n; i++)
            F[i][0] = 0;
        for (int j = 0; j <= capacity; j++)
            F[0][j] = 0;

        return mfKnapsack(n, capacity);
    }

    private int mfKnapsack(int i, int j) {
        if (F[i][j] < 0) {
            if (j < Weights[i - 1]) {
                F[i][j] = mfKnapsack(i - 1, j);
            } else {
                F[i][j] = Math.max(mfKnapsack(i - 1, j),
                        Values[i - 1] + mfKnapsack(i - 1, j - Weights[i - 1]));
            }
        }
        return F[i][j];
    }
}
