package Arrays;
import java.util.*;
public class subarraytriplets{
    public int counttriplets(int []  nums){
        int n = nums.length ; 
        int count =0 ;
        for(int i = 0;i<n-2 ; i++){
            if(nums[i]+nums[i+2] == nums[i+1]){
                count ++;
            }
        }
        return count ;
    }
    public static void main(String[] args) {
        subarraytriplets obj = new subarraytriplets() ; 
        int [] nums = {1,2,3,4,5,1} ; 
        int result = obj.counttriplets(nums) ; 
        System.out.println( result);
    }
}