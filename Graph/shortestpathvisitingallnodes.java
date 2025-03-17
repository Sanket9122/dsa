package Graph ;  
import java.util.*;
public class shortestpathvisitingallnodes {
    public static int shortestpathvisiting(int [][]graph ,int n  ){
        int [][] dp = new int [n][1<<n] ;
        // store the large number of arrays in the dp[][]
        for (int[] row : dp){
            Arrays.fill(row , Integer.MAX_VALUE);
        }
        //Initializing queue with the linkedlist
        //base case starting at any node 
        Queue<int []> q = new LinkedList<>();
        for (int i= 0 ; i<n ;i++){
            dp[i][1<<i] = 0 ;
            q.offer(new int[]{i , 1<<i});
        }
        /////Breadth first search traversal
        while (!q.isEmpty()){
            int [] curr  = q.poll();
            int vis  = curr[0];
            int wtvis = curr[1];
            for (int node : graph [vis]){
                int next = wtvis | (1<<node);
                if (dp[node][next] > dp[vis][wtvis] + 1){
                    dp[node][next] = dp[vis][wtvis] + 1;
                    q.offer(new int[]{node , next});
                }
            }

        }
        // shortest path that visits all nodes
        int rslt =  Integer.MAX_VALUE;
        for (int i= 0;i<n;i++){
            rslt = Math.min(rslt , dp[i][(1<<n)-1]);
        }
        return rslt ;
    }
    public static void main(String[] args) {
        int [][] graph = {{1,2,3},{0},{0},{0}} ;
        System.out.println(shortestpathvisiting(graph , 4));

    }
}