package th.ac.kmutt.cpe.algorithm.wisit.lab.PracticeM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithm.wisit.sorting.ShiftTable;

public class Q11_Lottery {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            String T = sc.next(); // student's ticket (length m)
            String P = sc.next(); // prize pattern (length n)

            // Build Horspool shift table for the pattern
            var table = new ShiftTable().shiftTable(P, 256);

            int i = n - 1; // position of pattern's right end
            int shifts = 0; // count how many window shifts we perform
            int pos = -1;

            while (i <= m - 1) {
                int k = 0;
                while (k <= n - 1 && P.charAt(n - 1 - k) == T.charAt(i - k)) {
                    k++;
                }
                if (k == n) { // match
                    pos = i - n + 1;
                    break;
                } else {
                    i += table.get((int) T.charAt(i));
                    shifts++;
                }
            }

            if (pos >= 0) {
                System.out.println("YES " + shifts + " " + pos);
            } else {
                System.out.println("NO " + shifts + " -1");
            }
        }
    }
}
