package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

import java.util.ArrayList;
import java.util.List;

public class PrimAlgo {
    /**
     * Algorithm 6: Prim(G)
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

    /**
     * @param graph Adjacency matrix where graph[u][v] is the weight of edge (u, v).
     *              Use 0 or Integer.MAX_VALUE for no edge, but logic below assumes
     *              0 means no edge unless checked.
     *              Actually, for Prim's, usually 0 means no edge (except self
     *              loop).
     *              The logic below checks graph[u][v] != 0.
     * @return List of edges in MST.
     */
    public List<Edge> solve(int[][] graph) {
        int n = graph.length;
        List<Edge> Et = new ArrayList<>();
        boolean[] Vt = new boolean[n]; // Vt <- {v0}
        Vt[0] = true;

        for (int i = 0; i < n - 1; i++) {
            int minWeight = Integer.MAX_VALUE;
            int uBest = -1, vBest = -1;

            // Find minimum-weight edge e* = (v*, u*) such that v* is in Vt and u* is in V -
            // Vt
            for (int u = 0; u < n; u++) {
                if (Vt[u]) {
                    for (int v = 0; v < n; v++) {
                        if (!Vt[v] && graph[u][v] != 0 && graph[u][v] < minWeight) {
                            minWeight = graph[u][v];
                            uBest = u;
                            vBest = v;
                        }
                    }
                }
            }

            if (uBest != -1) {
                Et.add(new Edge(uBest, vBest, minWeight));
                Vt[vBest] = true;
            }
        }
        return Et;
    }
}
