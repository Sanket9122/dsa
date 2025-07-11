package hashing;
import java.util.*;
public class intersectiorofArrays2 {
    public List<Integer> intersection(int []nums1 , int []nums2){
        Map<Integer ,Integer > counts = new HashMap<>();
        for(int num : nums1){
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        List<Integer> reslist = new ArrayList<>();
        for(int num : nums2){
            if(counts.containsKey(num) && counts.get(num) > 0){
                reslist.add(num);
                counts.put(num, counts.get(num) - 1);
            }
        }
        return reslist;
    }
    public static void main(String[] args) {
        intersectiorofArrays2 obj = new intersectiorofArrays2();
        int []nums1 = {1, 2, 2, 1};
        int []nums2 = {2, 2};
        List<Integer> result = obj.intersection(nums1, nums2);
        System.out.println(result);
    }
}
