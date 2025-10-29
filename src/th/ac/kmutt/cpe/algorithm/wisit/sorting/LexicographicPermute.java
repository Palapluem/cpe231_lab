package th.ac.kmutt.cpe.algorithms.wisit2.sorting;

public class LexicographicPermute {
    public static int lexitographicPermute(String s) {
        int n = s.length();
        int rank = 1;
        int[] count = new int[256];

        for (int i = 0; i < n; i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        for (int i = 0; i < n; i++) {
            int charIndex = s.charAt(i);
            int smaller = count[charIndex - 1];
            rank += smaller * fact[n - i - 1];

            for (int j = charIndex; j < 256; j++) {
                count[j]--;
            }
        }
        return rank;
    }
}
