package DP;
import java.util.*;
public class mincost_to_reach_i {
    public int mincost(int [] cost){
        int n =  cost.length;
        int [] dp = new int[n+1];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
    public static void main(String[] args) {
        mincost_to_reach_i mc = new mincost_to_reach_i();
        int [] cost = {10,15,20};
        int [] cost1 = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(mc.mincost(cost));
        System.out.println(mc.mincost(cost1));
    }
}

//algorithmic explanation
//1. we have to find the minimum cost to reach the top of the floor
//2. we can start from either step 0 or step 1
//3. we can use recursion with memoization to solve this problem
//4. we will create a 1D array to store the minimum cost at each step
//5. we will start from step 2 and move to the top recursively
//6. base case: if we reach step 0 or step 1, return the cost of that step
//7. if the value is already computed, return it from the dp array
//8. otherwise, compute the minimum cost by moving to either step 0 or step 1
//9. store the result in the dp array and return it 
