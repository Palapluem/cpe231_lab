package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

import java.util.Arrays;

public class StableMarriageAlgo {
    /**
     * Algorithm 9: Stable Marriage Algorithm
     * Finds a stable marriage matching.
     * 
     * @param menPrefs   menPrefs[m][k] is the k-th preference of man m.
     * @param womenPrefs womenPrefs[w][k] is the k-th preference of woman w.
     * @return Array where index is woman, value is her partner (man).
     */
    public int[] solve(int[][] menPrefs, int[][] womenPrefs) {
        int n = menPrefs.length;
        int[] womenPartner = new int[n];
        boolean[] menFree = new boolean[n];
        Arrays.fill(womenPartner, -1);
        Arrays.fill(menFree, true);
        int freeCount = n;

        // Need to track next proposal for each man to avoid re-scanning list
        int[] menNextProposal = new int[n];

        // Preprocess women preferences to rank for O(1) comparison
        // womenRank[w][m] = rank (lower is better)
        int[][] womenRank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int r = 0; r < n; r++) {
                womenRank[w][womenPrefs[w][r]] = r;
            }
        }

        while (freeCount > 0) {
            int m;
            for (m = 0; m < n; m++) {
                if (menFree[m])
                    break;
            }

            // Man m proposes to w
            int w = menPrefs[m][menNextProposal[m]++];

            if (womenPartner[w] == -1) {
                // If w is free, she accepts
                womenPartner[w] = m;
                menFree[m] = false;
                freeCount--;
            } else {
                // If w is not free, she compares m with current partner
                int currentPartner = womenPartner[w];
                if (womenRank[w][m] < womenRank[w][currentPartner]) {
                    // She prefers m over currentPartner
                    womenPartner[w] = m;
                    menFree[m] = false;
                    menFree[currentPartner] = true; // Current partner becomes free
                }
                // Else she rejects m (m remains free, tries next preference next loop)
            }
        }
        return womenPartner;
    }
}
