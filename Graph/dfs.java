package Graph;
import java.util.*;
public class dfs {
    public ArrayList <Integer> dfs (ArrayList<ArrayList<Integer>> adj) {
        int v= adj.size();
        boolean vis[] = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<v;i++){
            if(!vis[i]){
                dfs(i,adj,vis,ans);
            }
        }
       
        dfs(0, adj, vis, ans);
        
        return ans;
    }
    
    public void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
        
        vis[v] = true;
        
        // Add the current vertex to the answer list
        ans.add(v);
        
        // Explore all the neighbors of the current vertex
        for (Integer neighbor : adj.get(v)) {
            if (!vis[neighbor]) {
                // If the neighbor hasn't been visited, recursively call DFS
                dfs(neighbor, adj, vis, ans);
            }
        }
    }
    public static void main(String[] args) {
        dfs g = new dfs();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 1, 3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        ArrayList<Integer> ans = g.dfs(adj);
        System.out.println(ans);
    }
}
