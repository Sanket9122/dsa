package hashing;
import java.util.*;
public class duplicate2 {
    public boolean containsDuplicate(int [] nums ,int k){
        HashMap<Integer,Integer> resmap = new HashMap<>();
        for (int i=0 ; i<nums.length ; i++){
            int currnum = nums[i];
            
            if(resmap.containsKey(nums[i])){
                int previndex = resmap.get(nums[i]);
                int diff = i - previndex;
                if(diff <= k){
                    return true;
                }
            }
            resmap.put(currnum, i);
        }
        return false;
    }
    public static void main(String[] args) {
        duplicate2 dup = new duplicate2();
        int [] nums = {1,2,3,1,2,3};
        int k = 2;
        int [] nums1 = {1,2,3,1};
        int k1 = 3;
        System.out.println(dup.containsDuplicate(nums,k));
        System.out.println(dup.containsDuplicate(nums1,k1));
    }
}
