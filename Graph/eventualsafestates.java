package Graph;
import java.util.*;

public class eventualsafestates {
    
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        int[] state = new int[V];  // 0 = unvisited, -1 = visiting, 1 = safe
        
        for (int i = 0; i < V; i++) {
            if (dfs(i, adj, state)) {
                result.add(i);
            }
        }
        
        return result;
    }

    private boolean dfs(int node, List<List<Integer>> adj, int[] state) {
        if (state[node] != 0) {
            return state[node] == 1;  // Return true if safe, false if unsafe
        }

        state[node] = -1;  // Mark node as being processed (detect cycles)

        for (int neighbor : adj.get(node)) {
            if (state[neighbor] == -1 || !dfs(neighbor, adj, state)) {
                state[node] = 2;  // Unsafe
                return false;
            }
        }

        state[node] = 1;  // Mark as safe
        return true;
    }
    
    public static void main(String[] args) {
        int V = 7;  // Number of nodes
        List<List<Integer>> adj = new ArrayList<>();
        
        // Proper adjacency list initialization
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).addAll(Arrays.asList(1, 2, 3));
        adj.get(1).addAll(Arrays.asList(0, 2));
        adj.get(2).addAll(Arrays.asList(0, 1, 3));
        adj.get(3).addAll(Arrays.asList(0, 2));
        adj.get(4).addAll(Arrays.asList(5, 6));

        eventualsafestates obj = new eventualsafestates();
        System.out.println(obj.eventualSafeNodes(V, adj));
    }
}
