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


        // 2nd approach using HashSet
        // Set<Integer> resset = new HashSet<>();
        // for (int i=0 ; i<nums.length ; i++){
        //     if(resset.contains(nums[i])){
        //         return true;
        //     }
        //     resset.add(nums[i]);
        //     if(resset.size() > k){
        //         resset.remove(nums[i - k]);
        //     }
        // }
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
