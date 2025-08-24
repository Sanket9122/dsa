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
