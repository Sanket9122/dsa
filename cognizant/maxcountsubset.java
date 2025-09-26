package cognizant;

import java.util.*;

public class maxcountsubset {
    public int maxCount(int capacity , int [] weights){
        int count =0 ; 
        int n = weights.length;
        int currentweight= 0;
        Arrays.sort(weights);
        for(int weight :weights){
            if(currentweight + weight <= capacity){
                currentweight += weight;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        maxcountsubset mcs = new maxcountsubset();
        int [] weights = {1,2,3,4,5};
        int capacity = 6;
        System.out.println(mcs.maxCount(capacity, weights));
    }
}
