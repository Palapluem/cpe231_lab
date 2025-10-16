package th.ac.kmutt.cpe.algorithm.wisit.lab.lab8;

import java.util.*;

public class Jaothi{
    static int[] weights;
    static int[] values;
    static int[][] F;
    
    public static int MFKnapsack(int i, int j) {
        if (F[i][j] < 0) {
            if (j < weights[i]) {
                F[i][j] = MFKnapsack(i - 1, j);
            } else {
                int dontTake = MFKnapsack(i - 1, j);
                int take = values[i] + MFKnapsack(i - 1, j - weights[i]);
                F[i][j] = Math.max(dontTake, take);
            }
        }
        return F[i][j];
    }
    
    public static int findMostOverallIncome(int[] w, int[] v, int capacity) {
        int n = w.length;
        weights = new int[n + 1];
        values = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            weights[i + 1] = w[i];
            values[i + 1] = v[i];
        }
        
        F = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    F[i][j] = 0;
                } else {
                    F[i][j] = -1;
                }
            }
        }
        return MFKnapsack(n, capacity);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        
        int[] weights = new int[n];
        int[] values = new int[n];
        
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        
        int result = findMostOverallIncome(weights, values, capacity);
        System.out.println(result);
        sc.close();
    }
}