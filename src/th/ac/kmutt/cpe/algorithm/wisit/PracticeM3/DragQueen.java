package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3;

import java.util.Scanner;
import th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy.DragQueenAlgo;

public class DragQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        DragQueenAlgo solver = new DragQueenAlgo();
        System.out.println(solver.dragQueen(s));
        sc.close();
    }
}