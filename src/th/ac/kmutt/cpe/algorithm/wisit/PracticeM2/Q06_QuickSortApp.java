package th.ac.kmutt.cpe.algorithm.wisit.PracticeM2;

import java.util.ArrayList;
import java.util.Scanner;
import th.ac.kmutt.cpe.algorithm.wisit.sorting.HoarePartition;

// Practice M2 - Quicksort using Hoare's Partition
public class Q06_QuickSortApp {
    private static final HoarePartition HP = new HoarePartition();

    private static void quicksort(ArrayList<Integer> a, int l, int r) {
        if (l < r) {
            int s = HP.partition(a, l, r); // split index by Hoare
            quicksort(a, l, s);
            quicksort(a, s + 1, r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        sc.close();

        quicksort(a, 0, a.size() - 1);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < a.size(); i++) {
            if (i > 0) {
                out.append(' ');
            }
            out.append(a.get(i));
        }
        System.out.println(out.toString());
    }
}