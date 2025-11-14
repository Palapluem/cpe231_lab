package th.ac.kmutt.cpe.algorithm.wisit.PracticeM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithm.wisit.sorting.QuickSelect;

public class Q04_QuickSelectApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            A.add(sc.nextInt());
        int k = sc.nextInt(); // 1-based

        if (k < 1 || k > n) {
            System.out.println(-1);
            sc.close();
            return;
        }

        QuickSelect qs = new QuickSelect();
        int ans = qs.quickselect(A, 0, n - 1, k);
        System.out.println(ans);
        sc.close();
    }
}
