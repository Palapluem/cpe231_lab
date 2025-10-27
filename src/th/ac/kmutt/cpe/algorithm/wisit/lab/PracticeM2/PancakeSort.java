package th.ac.kmutt.cpe.algorithm.wisit.lab.PracticeM2;

import java.util.*;

public class PancakeSort {
    private static void flip(int[] a, int k) {
        int i = 0, j = k - 1;
        while (i < j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
    }

    private static int indexOfMax(int[] a, int n) {
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[idx])
                idx = i;
        }
        return idx;
    }

    // Sort ascending using pancake sort
    public static void pancakeSort(int[] a) {
        for (int curr = a.length; curr > 1; curr--) {
            int maxIdx = indexOfMax(a, curr);
            if (maxIdx == curr - 1)
                continue;
            if (maxIdx != 0)
                flip(a, maxIdx + 1);
            flip(a, curr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        pancakeSort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}