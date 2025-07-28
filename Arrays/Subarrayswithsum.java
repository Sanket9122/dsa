import java.util.*;
public class Subarrayswithsum {
    public int binarySum(int [] nums , int goal){
        //first approach brute force
        // int count = 0 ,sum=0;
        // int n =nums.length;
        // for(int i=0; i<n; i++){
        //     sum = 0;
        //     for(int j=i; j<n; j++){
        //         sum += nums[j];
        //         if(sum == goal){
        //             count++;
        //         }
        //     }
        // }
        // return count; 

        //2nd approach
        int countAtMostGoal = 0;
        int sum1 = 0;
        int left1 = 0;
        
        for (int right = 0; right < nums.length; right++) {
            sum1 += nums[right];
            while (sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            countAtMostGoal += (right - left1 + 1);
        }

        int countAtMostGoalMinusOne = 0;
        int kMinusOne = goal - 1; 
        
        if (kMinusOne < 0) {
            countAtMostGoalMinusOne = 0;
        } else {
            int sum2 = 0;
            int left2 = 0;
            for (int right = 0; right < nums.length; right++) {
                sum2 += nums[right];
                while (sum2 > kMinusOne) {
                    sum2 -= nums[left2];
                    left2++;
                }
                countAtMostGoalMinusOne += (right - left2 + 1);
            }
        }
        
        return countAtMostGoal - countAtMostGoalMinusOne;
    }
    public static void main(String[] args) {
        Subarrayswithsum obj = new Subarrayswithsum();
        int[] nums = {1, 1, 1};
        int []nums2 = {1, 0, 1, 0, 1};
        int goal2 = 2;
        int result2 = obj.binarySum(nums2, goal2);
        int goal = 2;
        int result = obj.binarySum(nums, goal);
        System.out.println(result);
        System.out.println(result2);
    }
}


//algorithm explanation 1st approach :
//1. We iterate through the array and calculate the sum of all subarrays.
//2. If the sum equals the goal, we increment the count.
//3. We return the count.


//algorithm explanation 2nd approach :
//1. We maintain a sliding window to count subarrays with sum at most goal.
//2. We use two pointers, left and right, to represent the current window.
//3. We expand the right pointer and add the current element to the sum.
//4. If the sum is greater than the goal, we shrink the window by subtracting the element at the left pointer.
//5. We continue this process until the right pointer reaches the end of the array.
//6. We return the count of subarrays with sum at most goal.




