package th.ac.kmutt.cpe.algorithm.wisit.lab.lab8;

import java.util.*;

public class Zigzag {
	public static int[][] calculateLongestZigzagDP(int[] arr) {
		if (arr == null || arr.length == 0) return new int[0][0];
		
		int n = arr.length;
		int[][] dp = new int[n][2];

		for (int i = 0; i < n; i++) {
			dp[i][0] = 1; // decreasing (False)
			dp[i][1] = 1; // increasing (True)
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
				}
				if (arr[i] < arr[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
				}
			}
		}
		
		return dp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[][] result = calculateLongestZigzagDP(arr);
		// Output DP(1, True), DP(2, True), ..., DP(n, True)
		for (int i = 0; i < n; i++) {
			if (i > 0) System.out.print(" ");
			System.out.print(result[i][1]);
		}
		System.out.println();
		
		// Output DP(1, False), DP(2, False), ..., DP(n, False)
		for (int i = 0; i < n; i++) {
			if (i > 0) System.out.print(" ");
			System.out.print(result[i][0]);
		}
		System.out.println();
		sc.close();
	}
}