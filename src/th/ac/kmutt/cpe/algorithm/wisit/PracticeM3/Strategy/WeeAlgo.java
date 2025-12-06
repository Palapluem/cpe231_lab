package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

public class WeeAlgo {
    public String[] wee(int n) {
        long totalSum = (long) n * (n + 1) / 2;
        long target = totalSum / 2;

        boolean[] isSelected = new boolean[n + 1];
        long currentSum = 0;

        for (int i = n; i >= 1; i--) {
            if (currentSum + i <= target) {
                currentSum += i;
                isSelected[i] = true;
            }
        }

        boolean groupOneIsLeft = isSelected[1];

        StringBuilder leftOutput = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (isSelected[i] == groupOneIsLeft) {
                leftOutput.append(i).append(" ");
            }
        }

        StringBuilder rightOutput = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (isSelected[i] != groupOneIsLeft) {
                rightOutput.append(i).append(" ");
            }
        }

        return new String[] { leftOutput.toString().trim(), rightOutput.toString().trim() };
    }
}
