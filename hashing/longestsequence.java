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



//algorithm explanation :
//1. first we check if the input array is null or empty, if it is we return 0.
//2. we convert the array to a set to remove duplicates and to have O(1) lookup time.
//3. we iterate over the set and for each number we check if it is the start of a consecutive sequence.
//4. if it is the start of a sequence we start a while loop that continues as long as the next number in the sequence is in the set.
//5. we keep track of the current streak and update the longest streak if the current streak is longer.
//6. we return the longest streak.