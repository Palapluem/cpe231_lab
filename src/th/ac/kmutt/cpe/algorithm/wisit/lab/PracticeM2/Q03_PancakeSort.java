package th.ac.kmutt.cpe.algorithms.wisit3.PracticeM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithms.wisit3.sorting.PancakeSort;

public class Q03_PancakeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        PancakeSort solver = new PancakeSort();
        solver.pancakeSort(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        sc.close();
    }
}
