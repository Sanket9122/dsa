package DP;
import java.util.*;
public class minpathsum1 {
    public int minpath(int [][] grids){
        int m = grids.length ; 
        int n = grids[0].length ;
        int [][] dp = new int [m][n];
        dp[0][0] = grids[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grids[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grids[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grids[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        minpathsum1 ob = new minpathsum1();
        int [][] grids = {{1,3,1},{1,5,1},{4,2,1}};
        int [][] grids1 = {{1,2,9},{-6,12,8}};
        System.out.println(ob.minpath(grids1));
        System.out.println(ob.minpath(grids));
    }
}


//algorithmic explanation
//1. we have to find the minimum path sum from top left to bottom right in a grid
//2. we can only move down or right
//3. we can use dynamic programming to solve this problem
//4. we will create a 2D array to store the minimum path sum at each cell
//5. we will start from the top left cell and move down or right iteratively
//6. base case: the value at the top left cell is the value of that cell
//7. we will fill the first row and first column by adding the values of the cells
//8. for other cells, we will compute the minimum path sum by taking the minimum of the cell above and the cell to the left
//9. store the result in the dp array and return the value at the bottom right cell