package DP;
import java.util.*;
public class minpathsum {
    private int [][]memo;
    int m ; 
    int n ;
    public int minpath(int [][] grids){
        m = grids.length ; 
        n = grids[0].length ;
        memo = new int [m+1][n+1];
        for(int [] row : memo)  Arrays.fill(row , -1);
        return minpathfinder(grids , 0 , 0);
    }
    public int minpathfinder(int [][]grids ,int row , int col){
        if(row==m-1 && col==n-1) return grids[row][col];
        if(row>=m || col>=n) return Integer.MAX_VALUE;
        if(memo[row][col]!=-1) return memo[row][col];
        int down = minpathfinder(grids , row+1 , col);
        int right = minpathfinder(grids , row , col+1);
        int result  = grids[row][col] + Math.min(down , right);
        memo[row][col] = result;
        return result ;
    }
    public static void main(String[] args) {
        minpathsum ob = new minpathsum();
        int [][] grids = {{1,3,1},{1,5,1},{4,2,1}};
        int [][] grids1 = {{1,2,9},{4,5,6}};
        System.out.println(ob.minpath(grids1));
        System.out.println(ob.minpath(grids));
    }
}


//algorithmic explanation
//1. we have to find the minimum path sum from top left to bottom right in a grid
//2. we can only move down or right
//3. we can use recursion with memoization to solve this problem
//4. we will create a 2D array to store the minimum path sum at each cell
//5. we will start from the top left cell and move down or right recursively
//6. base case: if we reach the bottom right cell, return the value of that cell
//7. if we go out of bounds, return a large value (infinity)
//8. if the value is already computed, return it from the memo array
//9. otherwise, compute the minimum path sum by moving down and right
//10. store the result in the memo array and return it