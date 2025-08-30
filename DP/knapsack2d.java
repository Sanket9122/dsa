package DP;

import java.util.Arrays;

public class knapsack2d {

    public int knap2d(int[] items, int[] prices, int max_cap, int n, int[][] dp) {
        if (n == 0 || max_cap == 0) {
            return 0;
        }

        if (dp[n][max_cap] != -1) {
            return dp[n][max_cap];
        }

        if (items[n - 1] > max_cap) {
            return dp[n][max_cap] = knap2d(items, prices, max_cap, n - 1, dp);
        } else {
            int itemstoexclude = knap2d(items, prices, max_cap, n - 1, dp);

            int itemstoinclude = prices[n - 1] + knap2d(items, prices, max_cap - items[n - 1], n - 1, dp);

            return dp[n][max_cap] = Math.max(itemstoinclude, itemstoexclude);
        }
    }

    public static void main(String[] args) {
        knapsack2d ks = new knapsack2d();
        int[] items = {1, 2, 3};
        int[] prices = {20, 15, 40};
        int max_cap = 5;
        int n = items.length;

        int[][] dp = new int[n + 1][max_cap + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int result = ks.knap2d(items, prices, max_cap, n, dp);
        System.out.println(result);
    }
}
