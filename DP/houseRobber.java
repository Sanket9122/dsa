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
