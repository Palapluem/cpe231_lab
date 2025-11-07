package th.ac.kmutt.cpe.algorithm.wisit.lab.lab9;

import java.util.Scanner;

public class EgyptianFraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please insert a numerator : ");
        int numerator = sc.nextInt();
        System.out.print("Please insert a denominator : ");
        int denominator = sc.nextInt();
        System.out.print("Result of Egyptian Fraction from " + numerator + "/" + denominator + " : ");
        toEgyptian(numerator, denominator);
        sc.close();
    }

    private static void toEgyptian(int numerator, int denominator) {
        if (denominator == 0 || numerator == 0) {
            return;
        }

        if (denominator % numerator == 0) {
            System.out.print("1/" + denominator / numerator);
            return;
        }

        if (numerator % denominator == 0) {
            System.out.print(numerator / denominator);
            return;
        }

        if (numerator > denominator) {
            System.out.print(numerator / denominator + " + ");
            toEgyptian(numerator % denominator, denominator);
            return;
        }

        int n = denominator / numerator + 1;
        System.out.print("1/" + n + " + ");

        toEgyptian(numerator * n - denominator, denominator * n);
    }

}