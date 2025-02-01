package Graph;
import java.util.*;
public class numberofEnclave {
    public static int number(int [][] grids){
        int count = 0;
        int m = grids.length  ;
        int n =grids[0].length ; 
        for (int i = 0; i < m; i++) {
            dfs(grids, i, 0);
            dfs(grids,  i, n-1);
        }
        for(int j = 0 ; j<n ; j++){
            dfs(grids, 0, j);
            dfs(grids, m-1, j);
        }
        for(int i = 0; i<m; i++){
            for(int j = 0 ;j<n ;j++){
                if (grids[i][j]==1){
                    count ++;
                }
            }
        }
        return count ;
    }
    private static void dfs (int [][] grids , int i , int j){
        if (i<0 || j<0 || i>=grids.length || j>=grids[0].length || grids[i][j]==0){
            return ;
        }
        grids[i][j] = 0 ;
        dfs(grids, i - 1, j);
        dfs(grids, i + 1, j);   
        dfs(grids, i, j - 1);
        dfs(grids, i, j + 1);
    }
    public static void main(String[] args) {
        int [][] grids = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };
        System.out.println(number(grids));

    }
}
