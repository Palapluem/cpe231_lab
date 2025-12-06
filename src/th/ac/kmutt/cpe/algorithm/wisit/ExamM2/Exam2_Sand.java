package th.ac.kmutt.cpe.algorithm.wisit.ExamM2;

import th.ac.kmutt.cpe.algorithm.wisit.sorting.SandSort;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam2_Sand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(sc.nextLong());
        }

        SandSort solver = new SandSort();
        long result = solver.sandSort(n, A);
        System.out.println(result);
        sc.close();
    }
}
