package th.ac.kmutt.cpe.algorithm.wisit.PracticeM2;

import java.util.*;
import th.ac.kmutt.cpe.algorithm.wisit.sorting.EfficientClosestPair;

public class Q07_2DClosestPairApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();

        ArrayList<EfficientClosestPair.Point> points = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points.add(new EfficientClosestPair.Point(x, y));
        }
        sc.close();

        // Prepare P sorted by x (then y) and Q sorted by y (then x)
        ArrayList<EfficientClosestPair.Point> P = new ArrayList<>(points);
        P.sort((a, b) -> {
            int cx = Double.compare(a.x, b.x);
            return (cx != 0) ? cx : Double.compare(a.y, b.y);
        });

        ArrayList<EfficientClosestPair.Point> Q = new ArrayList<>(points);
        Q.sort((a, b) -> {
            int cy = Double.compare(a.y, b.y);
            return (cy != 0) ? cy : Double.compare(a.x, b.x);
        });

        EfficientClosestPair solver = new EfficientClosestPair();
        double ans = solver.efficientClosestPair(P, Q);

        System.out.printf("%.3f%n", ans);
    }
}