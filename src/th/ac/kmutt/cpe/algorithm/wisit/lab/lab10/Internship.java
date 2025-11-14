package th.ac.kmutt.cpe.algorithm.wisit.lab.lab10;

import java.util.*;

public class Internship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] companyPrefs = new int[n][n];
        int[][] studentPrefs = new int[n][n];
        int[][] studentRank = new int[n][n];
        int[] studentPartner = new int[n];
        int[] nextProposal = new int[n];
        Queue<Integer> freeCompanies = new LinkedList<>();

        for (int c = 0; c < n; c++) {
            for (int i = 0; i < n; i++) {
                companyPrefs[c][i] = sc.nextInt();
            }
        }

        for (int s = 0; s < n; s++) {
            for (int rank = 0; rank < n; rank++) {
                int company = sc.nextInt();
                studentPrefs[s][rank] = company;
                studentRank[s][company] = rank;
            }
        }

        Arrays.fill(studentPartner, -1);
        for (int c = 0; c < n; c++) {
            freeCompanies.add(c);
        }

        while (!freeCompanies.isEmpty()) {
            int company = freeCompanies.poll();
            int student = companyPrefs[company][nextProposal[company]];
            nextProposal[company]++;

            int currentPartner = studentPartner[student];

            if (currentPartner == -1) {
                studentPartner[student] = company;
            } else {
                int newOfferRank = studentRank[student][company];
                int currentPartnerRank = studentRank[student][currentPartner];

                if (newOfferRank < currentPartnerRank) {
                    studentPartner[student] = company;
                    freeCompanies.add(currentPartner);
                } else {
                    freeCompanies.add(company);
                }
            }
        }

        for (int s = 0; s < n; s++) {
            System.out.println(s + " " + studentPartner[s]);
        }
        sc.close();
    }
}