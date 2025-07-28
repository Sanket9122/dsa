package hashing;
import java.util.*;
public class Subarrayswithsum {
    public int binarysum(int [] nums  , int goal){
        int count = 0 , sum = 0;
        Map<Integer, Integer> resmap = new HashMap<>();
        if(resmap.isEmpty()) {
            resmap.put(0, 1);
        }

        for(int num :nums){
            sum += num ; 
            int targetprevsum  =  sum -goal ; 
            if(resmap.containsKey(targetprevsum)){
                count += resmap.get(targetprevsum);
            }
            resmap.put(sum, resmap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Subarrayswithsum obj = new Subarrayswithsum();
        int[] nums = {1, 1, 1};
        int []nums2 = {1, 0,1,0,1};
        int goal2 = 2;
        int result2 = obj.binarysum(nums2, goal2);
        int goal = 2;
        int result = obj.binarysum(nums, goal);
        System.out.println(result);
        System.out.println(result2);

    }
}


//algorithm explanation
//1. We maintain a hashmap to store the cumulative sum and its frequency.
//2. We initialize the count variable to 0.
//3. We iterate over the input array nums.
//4. For each element, we update the cumulative sum.
//5. We calculate the target previous sum by subtracting the goal from the current cumulative sum.
//6. If the target previous sum exists in the hashmap, we add its frequency to the count.
//7. We update the hashmap with the current cumulative sum and its frequency.
//8. Finally, we return the count.

//example visualization
//Input: nums = [1, 1, 1], goal = 2
//Output: 2
//Explanation: The subarrays with sum equal to 2 are [1, 1] (from index 0 to 1) and [1, 1] (from index 1 to 2).
//Input: nums = [1, 0, 1, 0, 1], goal = 2
//Output: 4
//Explanation: The subarrays with sum equal to 2 are [1, 0, 1] (from index 0 to 2), [0, 1, 0, 1] (from index 1 to 4), [1, 0, 1] (from index 2 to 4), and [0, 1] (from index 3 to 4).