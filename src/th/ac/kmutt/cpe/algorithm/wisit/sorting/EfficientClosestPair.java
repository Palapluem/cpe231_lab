package th.ac.kmutt.cpe.algorithm.wisit.sorting;

import java.util.ArrayList;
import java.util.List;

public class EfficientClosestPair {

    // Point class to represent a point in Cartesian plane
    public static class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public double efficientClosestPair(List<Point> P, List<Point> Q) {
        int n = P.size();

        // if n ≤ 3
        if (n <= 3) {
            // return the minimal distance found by the brute-force algorithm
            return bruteForceClosestPair(P);
        } else {
            // copy the first ⌊n/2⌋ points of P to array P_l
            List<Point> P_l = new ArrayList<>(P.subList(0, n / 2));

            // copy the same ⌊n/2⌋ points from Q to array Q_l
            List<Point> Q_l = new ArrayList<>();
            for (Point p : Q) {
                if (P_l.contains(p)) {
                    Q_l.add(p);
                }
            }

            // copy the remaining ⌈n/2⌉ points of P to array P_r
            List<Point> P_r = new ArrayList<>(P.subList(n / 2, n));

            // copy the same ⌈n/2⌉ points from Q to array Q_r
            List<Point> Q_r = new ArrayList<>();
            for (Point p : Q) {
                if (P_r.contains(p)) {
                    Q_r.add(p);
                }
            }

            // d_l ← EfficientClosestPair(P_l, Q_l)
            double d_l = efficientClosestPair(P_l, Q_l);

            // d_r ← EfficientClosestPair(P_r, Q_r)
            double d_r = efficientClosestPair(P_r, Q_r);

            // d ← min{d_l, d_r}
            double d = Math.min(d_l, d_r);

            // m ← P[⌊n/2⌋-1].x
            double m = P.get(n / 2 - 1).x;

            // copy all the points of Q for which |x - m| < d into array S[0..num-1]
            List<Point> S = new ArrayList<>();
            for (Point p : Q) {
                if (Math.abs(p.x - m) < d) {
                    S.add(p);
                }
            }

            // dminsq ← d²
            double dminsq = d * d;
            int num = S.size();

            // for i ← 0 to num - 2 do
            for (int i = 0; i < num - 1; i++) {
                // k ← i + 1
                int k = i + 1;

                // while k ≤ num - 1 and (S[k].y - S[i].y)² < dminsq
                while (k <= num - 1 &&
                        (S.get(k).y - S.get(i).y) * (S.get(k).y - S.get(i).y) < dminsq) {

                    // dminsq ← min((S[k].x - S[i].x)² + (S[k].y - S[i].y)², dminsq)
                    double distSq = (S.get(k).x - S.get(i).x) * (S.get(k).x - S.get(i).x) +
                            (S.get(k).y - S.get(i).y) * (S.get(k).y - S.get(i).y);
                    dminsq = Math.min(distSq, dminsq);

                    // k ← k + 1
                    k = k + 1;
                }
            }

            // return sqrt(dminsq)
            return Math.sqrt(dminsq);
        }
    }

    /**
     * Brute force algorithm to find closest pair for small n
     */
    private double bruteForceClosestPair(List<Point> points) {
        int n = points.size();
        double minDist = Double.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = distance(points.get(i), points.get(j));
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }

        return minDist;
    }

    /**
     * Calculates Euclidean distance between two points
     */
    private double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
