package DP;
import java.util.*;
public class combinationsum {
    public int combination(int []nums ,int target){
        int [] dp =new int[target+1];
        Arrays.fill(dp , 0);
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(i-num>=0){
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        combinationsum obj = new combinationsum();
        int [] nums = {1,2,3};
        int target = 4;
        System.out.println(obj.combination(nums, target));
    }
}

//algorithmic explanation
//1. We create a dp array of size target+1 to store the number of combinations that sum up to each value from 0 to the target.
//2. We initialize dp[0] to 1 because there is one way to make the target sum of 0 (using no elements).
//3. We iterate through all values from 1 to the target (inclusive).    
//4. For each value, we iterate through all elements in the nums array:
//   a. If the current element is less than or equal to the current value, we update dp[i] by adding the number of combinations from the previous value (dp[i-nums[j]]) to the current value (dp[i]).
//5. Finally, we return dp[target], which represents the number of combinations that sum up to the target value.
