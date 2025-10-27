package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class HorspoolMatching {

    private ShiftTable shiftTableGenerator;

    public HorspoolMatching() {
        this.shiftTableGenerator = new ShiftTable();
    }

    public int horspoolMatching(String P, String T) {
        int m = P.length();
        int n = T.length();

        // ShiftTable(P[0..m-1]) //generate Table of shifts
        ArrayList<Integer> Table = shiftTableGenerator.shiftTable(P, 256); // ASCII size

        // i ← m - 1 //position of the pattern's right end
        int i = m - 1;

        // while i ≤ n - 1 do
        while (i <= n - 1) {
            // k ← 0 //number of matched characters
            int k = 0;

            // while k ≤ m - 1 and P[m - 1 - k] = T[i - k] do
            while (k <= m - 1 && P.charAt(m - 1 - k) == T.charAt(i - k)) {
                // k ← k + 1
                k = k + 1;
            }

            // if k = m
            if (k == m) {
                // return i - m + 1
                return i - m + 1;
            } else {
                // else i ← i + Table[T[i]]
                i = i + Table.get((int) T.charAt(i));
            }
        }

        // return -1
        return -1;
    }
}
