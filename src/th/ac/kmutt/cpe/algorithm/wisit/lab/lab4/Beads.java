package th.ac.kmutt.cpe.algorithm.wisit.lab.lab4;

public class Beads {
    public static int countSubStrings(String beads, char A, char B, int p) {
        int n = beads.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (beads.charAt(i) == A) {
                if (A == B && p == 1) {
                    count++;
                }
                for (int j = i + 1; j < n; j++) {
                    if (beads.charAt(j) == B) {
                        if (j - i + 1 >= p) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}