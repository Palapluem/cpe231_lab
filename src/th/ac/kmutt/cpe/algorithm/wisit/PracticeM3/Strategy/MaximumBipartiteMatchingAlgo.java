package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.Strategy;

import java.util.Arrays;

public class MaximumBipartiteMatchingAlgo {
    /**
     * Algorithm 8: MaximumBipartiteMatching(G)
     * Finds a maximum matching in bipartite graph by a BFS-like traversal
     * (Augmenting Paths).
     * 
     * Note: The pseudocode describes a specific BFS traversal to find augmenting
     * paths.
     * This implementation uses a standard BFS-based augmenting path search
     * (Hopcroft-Karp style or simple BFS for max flow).
     * For simplicity and robustness, this implements the standard augmenting path
     * algorithm using BFS/DFS logic
     * which is equivalent to finding paths in the residual graph.
     */

    public int solve(int[][] graph) {
        // graph[u][v] = 1 if edge exists. Rows = Set U (left), Cols = Set V (right)
        int uCount = graph.length;
        int vCount = graph[0].length;
        int[] matchR = new int[vCount]; // matchR[v] = u, where u is matched with v
        Arrays.fill(matchR, -1);

        int result = 0;
        for (int u = 0; u < uCount; u++) {
            boolean[] seen = new boolean[vCount];
            if (bpm(graph, u, seen, matchR)) {
                result++;
            }
        }
        return result;
    }

    // A DFS based recursive function that returns true if a matching for vertex u
    // is possible
    private boolean bpm(int[][] graph, int u, boolean[] seen, int[] matchR) {
        int vCount = matchR.length;
        for (int v = 0; v < vCount; v++) {
            if (graph[u][v] == 1 && !seen[v]) {
                seen[v] = true;

                // If v is not visited
                // If v is not matched OR previously matched vertex matchR[v] has an alternate
                // job
                if (matchR[v] < 0 || bpm(graph, matchR[v], seen, matchR)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
}
