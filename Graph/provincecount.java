package Graph;
import java.util.*;
public class provincecount{
    public int provinces(int[][] isconnected) {
        int n  =  isconnected.length;
        boolean [] vist = new boolean [n];
        int count = 0 ;
        for (int i = 0 ; i < n ; i ++ ){
            if(!vist[i]){
                dfs(i , isconnected , vist );
                count++;
            }
        }
        return count ;
    }
    static void dfs(int i , int [][] isconnected , boolean [] vist){
        vist[i] = true;
        for (int j = 0 ; j < isconnected.length ; j ++ ){
            if (isconnected[i][j] == 1 && !vist[j]){
                dfs(j , isconnected , vist);
            }
        }
    }
    public static void main(String[] args) {
        provincecount g = new provincecount();
        int[][] isconnected = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(g.provinces(isconnected));

    }
}
