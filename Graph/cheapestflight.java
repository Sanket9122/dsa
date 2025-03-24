package Graph;
import java.util.*;

public class cheapestflight {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});

        int[][] visited = new int[n][k + 2];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int city = current[1];
            int stops = current[2];

            if (city == dst) {
                return cost;
            }

            if (stops <= k) {
                for (int[] neighbor : adj[city]) {
                    int nextCity = neighbor[0];
                    int price = neighbor[1];

                    if (cost + price < visited[nextCity][stops + 1]) {
                        visited[nextCity][stops + 1] = cost + price;
                        pq.offer(new int[]{cost + price, nextCity, stops + 1});
                    }
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        cheapestflight obj = new cheapestflight();
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        int result = obj.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }
}
