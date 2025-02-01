package hashing;
import java.util.*;
public class longestsequence {
    public int longestConsecutive(int[] nums) {
        
    if (nums == null || nums.length == 0) {
        return 0;
    }

    Set<Integer> set = new HashSet<Integer>();
    for (int num : nums) {
        set.add(num);
    }

    int longestStreak = 0;

    for (int num : set) {
        if (!set.contains(num - 1)) { 
            int currentNum = num;
            int currentStreak = 1;

            while (set.contains(currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }
    }

    return longestStreak;
}
public static void main(String[] args) {
    int[] nums = {100, 4, 200, 1, 3, 2 , 5 , 6};
    longestsequence sltion = new longestsequence();
    int longestStreak = sltion.longestConsecutive(nums);
    System.out.println("Longest consecutive sequence: " + longestStreak);
}
}
