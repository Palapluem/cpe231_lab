package th.ac.kmutt.cpe.algorithm.wisit.lab.PracticeM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithm.wisit.sorting.MaxSubarrayDivideAndConquer;

public class Q08_MakeAWish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        sc.close();

        MaxSubarrayDivideAndConquer solver = new MaxSubarrayDivideAndConquer();
        long ans = solver.maxSubarraySum(a);
        System.out.println(ans);
    }
}
