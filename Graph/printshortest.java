package Graph;
import java.util.*;
public class printshortest {
    static class Pair {
        int node ;
        int distance; 
        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }
   public List<Integer> printshortest(int n,int m,  int [][] edges) {
    List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 1});
        
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            
            if (d > dist[node]) continue;
            
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                
                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    parent[nextNode] = node;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        if (dist[n] == Integer.MAX_VALUE) {
            return Collections.singletonList(-1);
        }
        
        List<Integer> path = new ArrayList<>();
        for (int node = n; node != -1; node = parent[node]) {
            path.add(node);
        }
        
        Collections.reverse(path);
        path.add(0, dist[n]);
        
        return path;
   }
   public static void main(String[] args) {
    int n = 5;
    int m = 6;
    int[][] edges ={{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
    printshortest obj = new printshortest();
    List<Integer> path = obj.printshortest(n, m, edges);
    System.out.println("Shortest path distance: " + path.get(0));
    System.out.println("Shortest path: " + path.subList(1, path.size()));

   }
   
}
