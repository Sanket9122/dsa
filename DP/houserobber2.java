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
