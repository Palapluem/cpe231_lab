package th.ac.kmutt.cpe.algorithm.wisit;

import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.wisit.lab.lab4.Beads;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String beads = sc.nextLine().trim();
        String[] chars = sc.nextLine().trim().split(" ");
        char A = chars[0].charAt(0);
        char B = chars[1].charAt(0);
        int p = Integer.parseInt(sc.nextLine().trim());
        int result = Beads.countSubStrings(beads, A, B, p);
        System.out.println(result);
        sc.close();
    }
}