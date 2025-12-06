package th.ac.kmutt.cpe.algorithm.wisit.ExamM2;

import th.ac.kmutt.cpe.algorithm.wisit.sorting.HistogramSelect;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam1_HistogramSelect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        ArrayList<Double> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(sc.nextDouble());
        }
        int k = sc.nextInt();

        HistogramSelect hs = new HistogramSelect();
        System.out.println(hs.histogramSelect(A, b, k));
        sc.close();
    }
}