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
