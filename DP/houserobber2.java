package DP;
import java.util.*;
public class houserobber2 {
    public int getrob(int [] houses){
        int n = houses.length ; 
        int rob1=0;
        int rob2=0;
        if(n==0)   return 0;
        if(n==1) return houses[0];
        for(int house : houses){
            int currmax = Math.max(rob1  , house + rob2);
            rob2 = rob1;
            rob1 = currmax;
        }
        return rob1;
    }
    public static void main(String[] args) {
        houserobber2 hr2 = new houserobber2();
        int [] houses = {2,7,9,3,1};
        int [] houses1 = {1,1,0,0};
        int result = hr2.getrob(houses);
        int result1 = hr2.getrob(houses1);
        System.out.println(result + " " + result1);
    }
}

//algorithmic explanation
//1. Initialize two variables, rob1 and rob2, to keep track of the maximum amount of money that can be robbed in two consecutive houses.
//2. Iterate over the array of houses and calculate the maximum amount of money that can be robbed in each house.
//3. For each house, calculate the maximum amount of money that can be robbed by either robbing the current house and adding it to the amount robbed from two houses ago (rob2), or by skipping the current house and taking the amount robbed from the previous house (rob1).
//4. Update rob2 to be the value of rob1, and rob1 to be the value of currmax.
//5. After iterating through all the houses, return rob1, which contains the maximum amount of money that can be robbed without alerting the police.