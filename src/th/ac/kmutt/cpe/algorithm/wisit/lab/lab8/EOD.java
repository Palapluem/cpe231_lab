package th.ac.kmutt.cpe.algorithm.wisit.lab.lab8;

import java.util.*;

public class EOD {
    public static int maxValueDefusingEOD(int[] bombs) {
        int n = bombs.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int skip = dp[i + 1];
            int next = i + 1 + bombs[i];
            int take = 1 + bombs[i] + (next <= n ? dp[next] : 0);
            dp[i] = Math.max(skip, take);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        int result = maxValueDefusingEOD(values);
        System.out.println(result);
        sc.close();
    }
}