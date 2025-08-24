package DP;
import java.util.*;
public class houserobber3 {
    public int robcircle(int [] houses){
        int n = houses.length ; 
        if(n==0)   return 0;
        if(n==1) return houses[0];

        int result1 =  rob_linear(houses , 1 , n-1);
        int result2 = rob_linear(houses , 0 , n-2);
        return Math.max(result1 , result2);
    }
    public int rob_linear(int [] houses  , int start  ,int end ){
        int rob1 = 0 ;
        int rob2 = 0 ; 
        for(int i = start ; i <= end ;i++){
            int currmax = Math.max(rob1  , houses[i] + rob2);
            rob2 = rob1;
            rob1 = currmax;
        }
        return rob1;
    }
    public static void main(String[] args) {
        houserobber3 hr3 = new houserobber3();
        int [] houses = {2,3,2,1,5};
        int [] houses1 = {1,2,3,1};
        int result = hr3.robcircle(houses);
        int result1 = hr3.robcircle(houses1);
        System.out.println(result + " " + result1);
    }
}

//algorithmic explanation
//1. Handle edge cases where there are 0 or 1 houses.
//2. Initialize two variables, rob1 and rob2, to keep track of the maximum amount of money that can be robbed in two consecutive houses.
//3. Iterate over the array of houses and calculate the maximum amount of money that can be robbed in each house.
//4. For each house, calculate the maximum amount of money that can be robbed by either robbing the current house and adding it to the amount robbed from two houses ago (rob2), or by skipping the current house and taking the amount robbed from the previous house (rob1).
//5. Update rob2 to be the value of rob1, and rob1 to be the value of currmax.
//6. After iterating through all the houses, return rob1, which contains the maximum amount of money that can be robbed without alerting the police.
//7. Since the houses are arranged in a circle, we need to consider two scenarios: robbing from the first house to the second-to-last house, and robbing from the second house to the last house. We calculate the maximum amount for both scenarios and return the maximum of the two.
//8. The rob_linear function is a helper function that implements the logic for robbing houses
//   in a linear arrangement, which is called twice with different start and end indices to handle the circular arrangement.
//9. Finally, we print the results for the given test cases.