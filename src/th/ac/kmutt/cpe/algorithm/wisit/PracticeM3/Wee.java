package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3;

import java.util.Scanner;
import th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy.WeeAlgo;

public class Wee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        WeeAlgo solver = new WeeAlgo();
        String[] result = solver.wee(n);
        System.out.println(result[0]);
        System.out.println(result[1]);
        sc.close();
    }
}
