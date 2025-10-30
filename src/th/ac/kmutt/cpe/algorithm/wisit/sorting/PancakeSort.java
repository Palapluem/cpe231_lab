package th.ac.kmutt.cpe.algorithms.wisit3.sorting;

public class PancakeSort {
    private void flip(int[] a, int k) {
        int i = 0, j = k - 1;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    private int indexOfMax(int[] a, int n) {
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > a[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    public void pancakeSort(int[] a) {
        for (int curr = a.length; curr > 1; curr--) {
            int maxIdx = indexOfMax(a, curr);
            if (maxIdx == curr - 1) {
                continue;
            }
            if (maxIdx != 0) {
                flip(a, maxIdx + 1);
            }
            flip(a, curr);
        }
    }
}
