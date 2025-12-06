package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

public class GrilledGooseAlgo {
    public int grilledGoose(int x, int[] p) {
        boolean[] canOrder = new boolean[x + 1];
        canOrder[0] = true;

        for (int i = 1; i <= x; i++) {
            for (int boxSize : p) {
                if (i >= boxSize && canOrder[i - boxSize]) {
                    canOrder[i] = true;
                    break;
                }
            }
        }

        for (int i = x; i >= 1; i--) {
            if (!canOrder[i]) {
                return i;
            }
        }
        return 0;
    }
}