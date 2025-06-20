import java.util.*;
public class maxproductsubarray{
    public static int maxproduct(int []nums ){
        int current_max,current_min,max_product;
        current_max = current_min = max_product = nums[0];
        for (int i = 1;i<nums.length;i++){
            if (nums[i] < 0) {
                int temp = current_max;
                current_max = current_min;
                current_min = temp;
            }
            
            current_max = Math.max(nums[i], current_max * nums[i]);
            current_min = Math.min(nums[i], current_min * nums[i]);
            
            max_product = Math.max(max_product, current_max);
        }
        return max_product;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxproduct(nums));
    }
}