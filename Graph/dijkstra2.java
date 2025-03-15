package Graph;
import java.util.*;
public class dijkstra2 {
    static class Pair {
        int node;
        int distance;

        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static int[] dijkstra(int v, ArrayList<ArrayList<Pair>> adj, int src) {
        HashSet<Integer> vis = new HashSet<>();
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int d = current.distance;

            if (vis.contains(u)) continue;
            vis.add(u);

            for (Pair neighbor : adj.get(u)) {
                int neighborNode = neighbor.node;
                int weight = neighbor.distance;

                if (!vis.contains(neighborNode) && dist[u] + weight < dist[neighborNode]) {
                    dist[neighborNode] = dist[u] + weight;
                    pq.add(new Pair(dist[neighborNode], neighborNode));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(9, 3));
        adj.get(0).add(new Pair(4, 5));
        adj.get(1).add(new Pair(4, 4));
        adj.get(2).add(new Pair(10, 5));
        adj.get(3).add(new Pair(9, 0));
        adj.get(4).add(new Pair(4, 1));
        adj.get(4).add(new Pair(3, 5));
        adj.get(5).add(new Pair(4, 0));
        adj.get(5).add(new Pair(10, 2));
        adj.get(5).add(new Pair(3, 4));

        int S = 1;
        int[] result = dijkstra(V, adj, S);

        System.out.println("Shortest distances from source vertex " + S + ": " + Arrays.toString(result));
    }
}
