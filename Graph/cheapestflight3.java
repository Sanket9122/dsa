package Graph;
import java.util.*;

public class cheapestflight3 {
    static class Flight {
        int src, dest, price;
        Flight(int src, int dest, int price) {
            this.src = src;
            this.dest = dest;
            this.price = price;
        }
    }

    static int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        Map<Integer, List<Flight>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Flight(flight[0], flight[1], flight[2]));
        }

        PriorityQueue<Flight> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
        pq.offer(new Flight(src, src, 0));

        int[] cheapestPrices = new int[n];
        Arrays.fill(cheapestPrices, Integer.MAX_VALUE);
        cheapestPrices[src] = 0;

        while (!pq.isEmpty()) {
            Flight current = pq.poll();
            if (current.dest == dest) {
                return current.price;
            }
            if (current.price > cheapestPrices[current.dest]) {
                continue;
            }
            for (Flight neighbor : graph.get(current.dest)) {
                int newPrice = current.price + neighbor.price;
                if (newPrice < cheapestPrices[neighbor.dest]) {
                    cheapestPrices[neighbor.dest] = newPrice;
                    pq.offer(new Flight(current.src, neighbor.dest, newPrice));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};    
        int src = 0;
        int dest = 2;    
        int k = 1;
        int result = findCheapestPrice(n, flights, src, dest, k);    
        System.out.println(result);
    }
}