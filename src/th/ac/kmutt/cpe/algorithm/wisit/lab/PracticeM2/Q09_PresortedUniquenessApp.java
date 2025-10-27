package th.ac.kmutt.cpe.algorithm.wisit.lab.PracticeM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithm.wisit.sorting.PresortElementUniqueness;

// Presorted Uniqueness: read n and n integers, print unique values in ascending order
public class Q09_PresortedUniquenessApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();

        ArrayList<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            a.add(sc.nextInt());
        sc.close();

        new PresortElementUniqueness().presortElementUniqueness(a);

        StringBuilder out = new StringBuilder();
        Integer prev = null;
        for (int x : a) {
            if (prev == null || x != prev) {
                if (out.length() > 0)
                    out.append(' ');
                out.append(x);
                prev = x;
            }
        }
        System.out.println(out.toString());
    }
}
