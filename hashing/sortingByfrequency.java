package hashing;
import java.util.*;
public class sortingByfrequency {
    public int [] frequencysort(int [] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n =nums.length;
        for(int num :nums ){
            map.put(num , map.getOrDefault(num, 0)+1);
        }
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if (freqA != freqB) {
                return freqA - freqB;
            } else {
                return b - a;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
    public static void main(String[] args) {
        sortingByfrequency sbf = new sortingByfrequency();
        int [] nums = {1,1,2,2,2,3};
        int [] result = sbf.frequencysort(nums);
        System.out.println(Arrays.toString(result));
    }
}
