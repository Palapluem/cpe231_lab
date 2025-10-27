package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;

public class ShiftTable {
    public ArrayList<Integer> shiftTable(String P, int size) {
        int m = P.length();

        // Initialize Table with m
        ArrayList<Integer> Table = new ArrayList<>();

        // for i ← 0 to size - 1 do Table[i] ← m
        for (int i = 0; i < size; i++) {
            Table.add(m);
        }

        // for j ← 0 to m - 2 do Table[P[j]] ← m - 1 - j
        for (int j = 0; j < m - 1; j++) {
            int charIndex = P.charAt(j); // character as index
            Table.set(charIndex, m - 1 - j);
        }

        // return Table
        return Table;
    }
}
