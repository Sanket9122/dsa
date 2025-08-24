package DP;
import java.util.*;
public class houseRobber {
    public int rob (int [] nums ){
        int n= nums.length;
        if(n==0){
            return 0 ;
        }
        if(n==1){
            return nums[0];
        }
        int [] dp = new int[n];
        dp[0]= nums[0] ; 
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n ;i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        houseRobber hr = new houseRobber();
        int [] nums = {2,7,9,3,1};
        int [] nums1 = {1,2,3,1};
        int result1 = hr.rob(nums1);
        int result = hr.rob(nums);
        System.out.println(result + " " + result1);
    }
}

//algorithmic explanation
//1. Create a dp array to store the maximum amount of money that can be robbed up to each house.
//2. Initialize the first two elements of the dp array: dp[0] is the amount in the first house, and dp[1] is the maximum of the first two houses.
//3. Iterate through the houses starting from the third house (index 2).
//4. For each house, calculate the maximum amount of money that can be robbed by either robbing the current house and adding it to the amount robbed from two houses ago (dp[i-2]), or by skipping the current house and taking the amount robbed from the previous house (dp[i-1]).
//5. Update the dp array with the maximum amount for each house.
//6. After iterating through all the houses, return the last element of the dp array, which contains the maximum amount of money that can be robbed without alerting the police.

