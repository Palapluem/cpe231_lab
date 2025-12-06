package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3;

import java.util.Scanner;
import th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy.GrilledGooseAlgo;

public class GrilledGoose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        GrilledGooseAlgo solver = new GrilledGooseAlgo();
        int result = solver.grilledGoose(x, p);
        if (result != 0) {
            System.out.println(result);
        }
        sc.close();
    }
}
