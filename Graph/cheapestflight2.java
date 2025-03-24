package Graph;
import java.util.*;

public class cheapestflight2 {

    static class Node {
        int stops;
        int cost;
        int city;

        Node(int st, int c, int citi) {
            this.cost = c;
            this.stops = st;
            this.city = citi;
        }
    }

    static int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        ArrayList<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, src));

        int[][] visited = new int[n][k + 2]; // visited[i][j] stores the min cost to reach city i with j stops.
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[src][0] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int cost = current.cost;
            int city = current.city;
            int stops = current.stops;

            if (city == dest) {
                return cost; // If we reached the destination, return the cost.
            }

            if (stops <= k) {
                for (int[] neighbor : adj[city]) {
                    int nextCity = neighbor[0];
                    int price = neighbor[1];

                    if (cost + price < visited[nextCity][stops + 1]) {
                        visited[nextCity][stops + 1] = cost + price;
                        queue.offer(new Node(stops + 1, cost + price, nextCity));
                    }
                }
            }
        }

        return -1; // If no valid path found
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {1,3,600},
            {2, 3, 200},
            {2, 0, 100}
        };
        int src = 0;
        int dest = 3;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dest, k)); // Expected output: 200
    }
}
