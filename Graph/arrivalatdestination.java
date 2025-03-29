package Graph;
import java.util.*;

public class arrivalatdestination {

    public static int countPaths(int[][] roads, int n, int src, int dest) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], weight = road[2];
            graph[u].add(new int[]{v, weight});
            graph[v].add(new int[]{u, weight});
        }

        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        ways[src] = 2;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], node = curr[1], pathCount = curr[2];

            if (u > dist[node]) continue;

            for (int[] neighbor : graph[node]) {
                int v = neighbor[0];
                int time = neighbor[1];
                if (dist[v] > u + time) {
                    dist[v] = u + time;
                    ways[v] = pathCount * ways[node];
                    pq.offer(new int[]{dist[v], v, ways[v]});
                } else if (dist[v] == u + time) {
                    ways[v] += pathCount * ways[node];
                }
            }
        }

        return ways[dest];
    }

    public static void main(String[] args) {
        int[][] roads = {{0, 1, 2}, {1, 2, 3}, {2, 3, 6}, {0, 3, 1}, {0, 4, 1}, {4, 3, 1}};
        int n = 5;
        int src = 0;
        int dest = 4;
        System.out.println(countPaths(roads, n, src, dest));
    }
}
