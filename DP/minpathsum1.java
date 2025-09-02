package DP;
import java.util.*;
public class minpathsum1 {
    public int minpath(int [][] grids){
        int m = grids.length ; 
        int n = grids[0].length ;
        for(int i = 1 ; i<m ;i++){
            grids[i][0]+=grids[i-1][0];
        }
        for(int j=1;j<n;j++){
            grids[0][j]+=grids[0][j-1];
        }
        for(int i = 1 ; i<m ;i++){
            for(int j=1;j<n;j++){
                grids[i][j]+=Math.min(grids[i-1][j], grids[i][j-1]);
            }
        }
        return grids[m-1][n-1];
    }
    public static void main(String[] args) {
        minpathsum1 ob = new minpathsum1();
        int [][] grids = {{1,3,1},{1,5,1},{4,2,1}};
        int [][] grids1 = {{1,2,9},{-6,12,8}};
        System.out.println(ob.minpath(grids1));
        System.out.println(ob.minpath(grids));
    }
}
