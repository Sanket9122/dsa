package Graph;
import java.util.*;
public class ccledetection{
    public boolean ccle(ArrayList<ArrayList<Integer>> adj) {
       int v= adj.size();
       boolean [] vis = new boolean[v];
       for (int i=0;i<v;i++){
           if (!vis[i]){
               if (dfs(adj, i, vis, -1))
               return true;
           }
       }
       return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int v, boolean vis[], int parent) {
        vis[v] = true;
        for (Integer it : adj.get(v)) {
            if (!vis[it]) {
                if (dfs(adj, it, vis, v))
                return true;
            }
            else if (parent != it)
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ccledetection g = new ccledetection();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));    
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 1, 3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        System.out.println(g.ccle(adj));
    }
}