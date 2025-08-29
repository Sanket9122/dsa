package DP;

import java.util.*;

public class knapsack {
    public int knap(int[] wt, int max_cap, int[] val) {
        int n = wt.length;
        int[] dp = new int[max_cap + 1];

        for (int i = 0; i < n; i++) {
            for (int cap = max_cap; cap >= wt[i]; cap--) {
                dp[cap] = Math.max(dp[cap], val[i] + dp[cap - wt[i]]);
            }
        }
        
        return dp[max_cap];
    }
    
    public static void main(String[] args) {
        knapsack ks = new knapsack();
        int[] wt = {1, 2, 3};
        int[] val = {20, 15, 40};
        int max_cap = 5;
        
        int result = ks.knap(wt, max_cap, val);
        System.out.println(result);
    }
}
