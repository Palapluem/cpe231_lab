package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;
import java.util.List;

public class LexicographicPermute {
    public List<List<Integer>> generatePermutations(int n) {
        List<List<Integer>> permutations = new ArrayList<>();

        // Initialize the first permutation with 12...n
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        // Add the first permutation
        permutations.add(arrayToList(a));

        // while last permutation has two consecutive elements in increasing order do
        while (hasTwoConsecutiveIncreasing(a)) {
            // let i be its largest index such that a_i < a_{i+1}
            int i = findLargestIndexIncreasing(a);

            // find the largest index j such that a_i < a_j
            int j = findLargestIndexGreaterThan(a, i);

            // swap a_i with a_j
            swap(a, i, j);

            // reverse the order of the elements from a_{i+1} to a_n inclusive
            reverse(a, i + 1, a.length - 1);

            // add the new permutation to the list
            permutations.add(arrayToList(a));
        }
        return permutations;
    }

    // Checks if there are two consecutive elements in increasing order
    private boolean hasTwoConsecutiveIncreasing(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // Finds the largest index i such that a[i] < a[i+1]
    private int findLargestIndexIncreasing(int[] a) {
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // Finds the largest index j such that a[i] < a[j] : (if j >= i + 1 since a_i <
    // a_j)
    private int findLargestIndexGreaterThan(int[] a, int i) {
        for (int j = a.length - 1; j > i; j--) {
            if (a[i] < a[j]) {
                return j;
            }
        }
        return -1;
    }

    // Swaps two elements in the array
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Reverses the order of elements from index start to end inclusive
    private void reverse(int[] a, int start, int end) {
        while (start < end) {
            swap(a, start, end);
            start++;
            end--;
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