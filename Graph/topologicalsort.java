package Graph;
import java.util.*;
public class topologicalsort {
    public static void dfs(int V ,int []vis, ArrayList<ArrayList<Integer>> adj , Stack <Integer> st ) {
        vis[V]=1;
        for (int i : adj.get(V)) {
            if (vis[i]==0) {
                dfs(i,vis,adj,st);
            }
        }
        st.push(V);
    }  
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<Integer>();
        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i]==0) {
                dfs(i,vis,adj,st);
            }
        }
        
        int result[] = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            result[i++]= st.peek();
            st.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        topologicalsort g = new topologicalsort();
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        System.out.println(g.topoSort(V, adj));
        int[] result = g.topoSort(V, adj);

        System.out.println(Arrays.toString(result));
    }
}
