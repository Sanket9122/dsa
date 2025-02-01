package hashing;

import java.util.HashSet;

public class repeatingelement {
    static int repeatingelmnt (int []nums ){
        HashSet<Integer> set = new HashSet<Integer>();
        int min_ele = Integer.MAX_VALUE;
        for (int i  =0 ; i<nums.length ; i++){
            if (set.contains(nums[i])) {
                min_ele = Math.min(min_ele, nums[i]);
            }
            else{
                set.add(nums[i]);
            }
        }
        return min_ele = Integer.MAX_VALUE ? -1 : min_ele ;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5,1,2,3,4,5,6,7,8};
        System.out.println(repeatingelmnt(nums));
    }
}
