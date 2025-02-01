package Graph;
import java.util.*;
public class ccledetection2 {
    public static boolean iscyclic(List<List<Integer>> adj , int v,boolean [] visited , boolean[] reckstack){
        if(!visited [v]){
            visited[v] = true;
            reckstack[v] = true;
            for (int x  : adj.get(v)){
                if(!visited[x] && iscyclic(adj,x,visited,reckstack)){
                    return true;
                }
                else if (reckstack[x]){
                    return true;
                }
            }
        }
        reckstack[v] = false;
        return false;
    }
    public static boolean iscycle(List<List<Integer>> adj){
        int v= adj.size();
        boolean [] visited = new boolean[v];
        boolean [] reckstack = new boolean[v];
        for (int i=0;i<v;i++){
            if(!visited[i] && iscyclic(adj,i,visited,reckstack)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v= 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);
        System.out.println(iscycle(adj));
    }
}
