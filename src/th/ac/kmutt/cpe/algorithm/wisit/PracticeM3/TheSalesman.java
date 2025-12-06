package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3;

import java.util.*;
import th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy.TheSalesmanAlgo;

public class TheSalesman {
    static ArrayList<String> cities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCities = sc.nextInt();
        int p = sc.nextInt();
        int n = numCities + 1; // รวม THA

        cities.add("THA");
        int[][] dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, -1);

        for (int i = 0; i < p; i++) {
            int u = getCityId(sc.next());
            int v = getCityId(sc.next());
            int w = sc.nextInt();
            dist[u][v] = dist[v][u] = w;
        }

        // เรียกใช้ Algo
        TheSalesmanAlgo algo = new TheSalesmanAlgo(n, dist);
        int maxCost = algo.getMaxCost();

        // แสดงผล
        System.out.println(algo.getPathString(cities));
        System.out.println(maxCost);

        sc.close();
    }

    static int getCityId(String name) {
        if (!cities.contains(name)) {
            cities.add(name);
        }
        return cities.indexOf(name);
    }
}