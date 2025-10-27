package th.ac.kmutt.cpe.algorithm.wisit.lab.PracticeM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithm.wisit.sorting.HashFunction;

public class Q12_HashTableApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Z = sc.nextInt(), n = sc.nextInt();
        String[] t = new String[Z];
        HashFunction h = new HashFunction(Z);

        while (n-- > 0) {
            String s = sc.next();
            int i = h.hashInteger(sum(s)); // A=1..Z=26
            while (t[i] != null) {
                i = (i + 1) % Z; // linear probing
            }
            t[i] = s;
        }

        StringBuilder sb = new StringBuilder(Z * 5);
        for (int i = 0; i < Z; i++) {
            if (i > 0)
                sb.append(' ');
            sb.append(t[i] == null ? "NULL" : t[i]);
        }
        System.out.println(sb);
        sc.close();
    }

    private static int sum(String s) { // assumes uppercase A..Z per worksheet
        int x = 0;
        for (int i = 0; i < s.length(); i++)
            x += s.charAt(i) - 'A' + 1;
        return x;
    }
}
