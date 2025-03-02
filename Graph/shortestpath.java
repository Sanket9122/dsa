package Graph;
import java.util.*;

public class shortestpath {

    class Pair {
        int first, second;
        Pair(int _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st) {
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Pair> temp = new ArrayList<Pair>();
            adj.add(temp);
        }
        
        // Create the graph using adjacency list
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Perform Topological Sort using DFS technique
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        // Initialize distances
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);  // Use Integer.MAX_VALUE for infinity
        dist[0] = 0;  // Distance from source node (0) is 0

        // Process nodes in topologically sorted order
        while (!st.isEmpty()) {
            int node = st.pop();

            // Relax all edges from the current node
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                // Relaxation step
                if (dist[node] != Integer.MAX_VALUE && dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }

        // If a vertex is unreachable, set its distance to -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        shortestpath sp = new shortestpath();
        int N = 6;
        int M = 7;
        int[][] edges = {
            {0, 1, 5},
            {0, 2, 3},
            {1, 3, 6},
            {1, 2, 2},
            {2, 4, 4},
            {2, 5, 2},
            {2, 3, 7}
        };
        int[] result = sp.shortestPath(N, M, edges);
        System.out.println("Shortest Path distances from node 0:");
        for (int dist : result) {
            System.out.print(dist + " ");
        }
    }
}
