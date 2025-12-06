package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgo {
    /**
     * Algorithm 7: Kruskal(G)
     * Finds a minimum spanning tree of a weighted connected graph G.
     */

    public static class Edge {
        public int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + u + ", " + v + ", " + weight + ")";
        }
    }

    public List<Edge> solve(int n, List<Edge> edges) {
        List<Edge> Et = new ArrayList<>();
        // Sort E in nondecreasing order of the edge weights
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int eCounter = 0;
        int k = 0;

        while (eCounter < n - 1 && k < edges.size()) {
            Edge e = edges.get(k);
            k++;

            int rootU = find(parent, e.u);
            int rootV = find(parent, e.v);

            // if Et U {e} is acyclic
            if (rootU != rootV) {
                Et.add(e);
                union(parent, rootU, rootV);
                eCounter++;
            }
        }
        return Et;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }

    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}
