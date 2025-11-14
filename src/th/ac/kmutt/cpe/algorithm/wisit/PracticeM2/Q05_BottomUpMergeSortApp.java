package th.ac.kmutt.cpe.algorithm.wisit.PracticeM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithm.wisit.sorting.BottomUpMergeSort;

public class Q05_BottomUpMergeSortApp {

    // Read exactly n integers from the scanner
    private static ArrayList<Integer> readNumbers(Scanner sc, int n) {
        ArrayList<Integer> numbers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }
        return numbers;
    }

    // Print list values space-separated on a single line
    private static void printNumbers(ArrayList<Integer> numbers) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            if (i > 0)
                out.append(' ');
            out.append(numbers.get(i));
        }
        System.out.println(out.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Read the n numbers
        ArrayList<Integer> numbers = readNumbers(sc, n);
        sc.close();

        // Sort using Bottom-up Merge Sort
        BottomUpMergeSort sorter = new BottomUpMergeSort();
        sorter.sort(numbers);

        printNumbers(numbers);
    }
}