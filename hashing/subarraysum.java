package hashing;
import java.util.*;
public class subarraysum {
   static int sumsubarray(int []nums , int k , int n){
    HashMap <Integer , Integer > map = new HashMap<Integer,Integer>();
    map.put (0 , 1);
    int rslt  = 0;
    int currsum = 0; 
    for (int i = 0; i<n ; i++){
        currsum   += nums[i];
        
        int rmvsum = currsum - k;
        if (map.containsKey(rmvsum)){
            rslt += map.get(rmvsum);
        }
        map.put(currsum , map.getOrDefault(currsum , 0) + 1);
    }
    return rslt;
   }
   public static void main(String[] args) {
    int []nums = {6,2,-3,3,5,4 ,4};
    int k = 8;
    int n = nums.length;    
    System.out.println(sumsubarray(nums , k , n));
   }
}
