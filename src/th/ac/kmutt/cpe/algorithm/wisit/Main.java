package th.ac.kmutt.cpe.algorithm.wisit;

import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.wisit.searching.BeadSearch;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String beads = sc.nextLine().trim();
        String[] text = sc.nextLine().trim().split(" ");
        char A = text[0].charAt(0);
        char B = text[1].charAt(0);
        int p = Integer.parseInt(sc.nextLine().trim());
        int result = BeadSearch.countSubStrings(beads, A, B, p);
        System.out.println(result);
        sc.close();
    }
}