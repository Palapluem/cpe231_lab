package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class HistogramSelect {
    public double histogramSelect(ArrayList<Double> A, int b, int k) {
        if (A.size() == 1) {
            return A.get(0);
        }
        double min = Collections.min(A);
        double max = Collections.max(A);

        if (min == max) {
            return min;
        }

        double width = (max - min) / b;

        int[] count = new int[b];
        for (double value : A) {
            int idx = Math.min((int) ((value - min) / width), b - 1);
            count[idx]++;
        }

        int additive = 0;
        int targetBin = -1;
        for (int i = 0; i < b; i++) {
            if (additive + count[i] >= k) {
                targetBin = i;
                break;
            }
            additive += count[i];
        }

        if (targetBin == -1) {
            return max;
        }

        double rangeStart = min + targetBin * width;
        double rangeEnd = rangeStart + width;

        ArrayList<Double> selected = new ArrayList<>();
        for (double value : A) {
            if ((value >= rangeStart && value < rangeEnd) || (value == max && targetBin == b - 1)) {
                selected.add(value);
            }
        }

        k = k - additive;

        if (selected.size() == 1) {
            return selected.get(0);
        }

        return histogramSelect(selected, b, k);
    }
}