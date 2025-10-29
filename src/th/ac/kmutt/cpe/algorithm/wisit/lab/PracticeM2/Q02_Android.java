package th.ac.kmutt.cpe.algorithms.wisit2.practiceM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithms.wisit2.sorting.LexicographicPermute;

public class Q02_Android {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] words = new String[n];

        for (int i = 0; i < m; i++) {
            String s = sc.next();
            if (s.length() != n) {
                sc.close();
                return;
            }
            words[i] = s;
        }

        for (int i = 0; i < m; i++) {
            System.out.println(LexicographicPermute.lexitographicPermute(words[i]));
        }
        sc.close();
    }
}
