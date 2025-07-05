import java.util.*;
public class reversepairs {
    public int reversePairs(int[] nums ){
        int count = 0 ;
        int n = nums.length ; 
        for(int i=0 ; i<n ;i++){
            for(int j = i+1 ; j<n; j++){
                if(nums[i] > 2*nums[j]){
                    count +=1;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        reversepairs rp = new reversepairs();
        int[] nums1 = {1,3,2,3,1};
        int[] nums2 = {2,4,3,5,1};
        int[] nums3 = {7,5,6,4};
        int [] nums4 = {1,2,3,4,5};
        
        
        System.out.println("Reverse pairs in nums1: " + rp.reversePairs(nums1));
        System.out.println("Reverse pairs in nums2: " + rp.reversePairs(nums2));
        System.out.println("Reverse pairs in nums3: " + rp.reversePairs(nums3));
        System.out.println("Reverse pairs in nums4: " + rp.reversePairs(nums4));
    }
}