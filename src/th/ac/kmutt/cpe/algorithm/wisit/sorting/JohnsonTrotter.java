package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;
import java.util.List;

public class JohnsonTrotter {

    public List<List<Integer>> generatePermutations(int n) {
        List<List<Integer>> permutations = new ArrayList<>();

        // Initialize the first permutation with 1 2 ... n
        int[] permutation = new int[n];
        boolean[] direction = new boolean[n]; // true = left, false = right

        for (int i = 0; i < n; i++) {
            permutation[i] = i + 1;
            direction[i] = true; // initially all arrows point left
        }

        // Add the first permutation to the list
        permutations.add(arrayToList(permutation));

        // while the last permutation has a mobile element do
        while (hasMobileElement(permutation, direction)) {
            // find its largest mobile element k
            int k = findLargestMobileElement(permutation, direction);
            int kIndex = findIndex(permutation, k);

            // swap k with the adjacent element k's arrow points to
            int swapIndex = direction[kIndex] ? kIndex - 1 : kIndex + 1;
            swap(permutation, direction, kIndex, swapIndex);

            // reverse the direction of all the elements that are larger than k
            reverseDirectionLargerThan(permutation, direction, k);

            // add the new permutation to the list
            permutations.add(arrayToList(permutation));
        }

        return permutations;
    }

    /**
     * Checks if there is a mobile element in the permutation
     * A mobile element is one that is larger than its adjacent element in the arrow
     * direction
     */
    private boolean hasMobileElement(int[] perm, boolean[] dir) {
        for (int i = 0; i < perm.length; i++) {
            if (isMobile(perm, dir, i)) {
                return true;
            }
        }
        return false;
    }

    // Checks if element at index i is mobile
    private boolean isMobile(int[] perm, boolean[] dir, int i) {
        // Check left direction
        if (dir[i] && i > 0 && perm[i] > perm[i - 1]) {
            return true;
        }
        // Check right direction
        if (!dir[i] && i < perm.length - 1 && perm[i] > perm[i + 1]) {
            return true;
        }
        return false;
    }

    // Finds the largest mobile element
    private int findLargestMobileElement(int[] perm, boolean[] dir) {
        int largest = -1;

        for (int i = 0; i < perm.length; i++) {
            if (isMobile(perm, dir, i)) {
                if (largest == -1 || perm[i] > largest) {
                    largest = perm[i];
                }
            }
        }

        return largest;
    }

    // Finds the index of a value in the permutation
    private int findIndex(int[] perm, int value) {
        for (int i = 0; i < perm.length; i++) {
            if (perm[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Swaps two elements and their directions
    private void swap(int[] perm, boolean[] dir, int i, int j) {
        // Swap values
        int temp = perm[i];
        perm[i] = perm[j];
        perm[j] = temp;

        // Swap directions
        boolean tempDir = dir[i];
        dir[i] = dir[j];
        dir[j] = tempDir;
    }

    // Reverses the direction of all elements larger than k
    private void reverseDirectionLargerThan(int[] perm, boolean[] dir, int k) {
        for (int i = 0; i < perm.length; i++) {
            if (perm[i] > k) {
                dir[i] = !dir[i];
            }
        }
    }

    // Converts array to List<Integer>
    private List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            list.add(val);
        }
        return list;
    }
}
