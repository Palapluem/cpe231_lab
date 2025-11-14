package th.ac.kmutt.cpe.algorithm.wisit.PracticeM2;

import java.util.ArrayList;

public class Q01_NextPermutation {
    public boolean nextPermutation(ArrayList<Integer> arr) {
        int n = arr.size();

        // Step 2: หา index i ที่มากที่สุด ที่ ai < ai+1
        int i = n - 2;
        while (i >= 0 && arr.get(i) >= arr.get(i + 1)) {
            i--;
        }

        // ถ้าไม่พบ i แสดงว่าเป็น permutation สุดท้ายแล้ว (เรียงจากมากไปน้อย)
        if (i < 0) {
            return false;
        }

        // Step 3: หา index j ที่มากที่สุดที่ ai < aj
        int j = n - 1;
        while (j > i && arr.get(i) >= arr.get(j)) {
            j--;
        }

        // Step 4: สลับ ai และ aj
        swap(arr, i, j);

        // Step 5: กลับลำดับ (Reverse) ของตัวที่แล้ว ai+1 ถึง an
        reverse(arr, i + 1, n - 1);

        return true;
    }

    // Swap two elements in the ArrayList
    private void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    // Reverses the elements from index start to end
    private void reverse(ArrayList<Integer> arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public ArrayList<ArrayList<Integer>> generateAllPermutations(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Initialize first permutation: 1, 2, 3, ..., n
        ArrayList<Integer> current = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            current.add(i);
        }

        // Add first permutation
        result.add(new ArrayList<>(current));

        // Generate all next permutations
        while (nextPermutation(current)) {
            result.add(new ArrayList<>(current));
        }

        return result;
    }

    public static void main(String[] args) {
        Q01_NextPermutation np = new Q01_NextPermutation();

        // Test with n = 3
        int n = 3;
        System.out.println("All permutations of {1, 2, ..., " + n + "} in lexicographic order:");
        System.out.println("=".repeat(60));

        ArrayList<ArrayList<Integer>> permutations = np.generateAllPermutations(n);

        for (int i = 0; i < permutations.size(); i++) {
            System.out.printf("%2d: %s\n", i + 1, permutations.get(i));
        }

        System.out.println("=".repeat(60));
        System.out.println("Total permutations: " + permutations.size());

        // Test nextPermutation step by step
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Testing nextPermutation() step by step:");
        System.out.println("=".repeat(60));

        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        int count = 1;
        System.out.printf("%2d: %s\n", count++, test);

        while (np.nextPermutation(test)) {
            System.out.printf("%2d: %s\n", count++, test);
        }
    }
}