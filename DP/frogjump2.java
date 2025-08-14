package DP;
import java.util.*;
public class frogjump2{
    public int maxfrogjump (int [] stones ){
          int left = 0;
        int right = stones[stones.length - 1] - stones[0];
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCrossWithMaxJump(stones, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    public boolean canCrossWithMaxJump(int[] stones, int maxJump) {
        int n = stones.length;
        if (n <= 2) {
            return stones[n - 1] - stones[0] <= maxJump;
        }
        
        int lastStoneA = 0;
        for (int i = 2; i < n; i += 2) {
            if (stones[i] - lastStoneA > maxJump) {
                return false;
            }
            lastStoneA = stones[i];
        }
        if (stones[n - 1] - lastStoneA > maxJump) {
             return false;
        }
        
        int lastStoneB = 0;
        if (stones[1] - lastStoneB > maxJump) {
             return false;
        }
        lastStoneB = stones[1];
        for (int i = 3; i < n; i += 2) {
            if (stones[i] - lastStoneB > maxJump) {
                return false;
            }
            lastStoneB = stones[i];
        }
        if (stones[n - 1] - lastStoneB > maxJump) {
             return false;
        }

        return true;
    }
    public static void main(String[] args) {
        frogjump2 fj = new frogjump2();
        int[] stones = {0, 2, 5, 7, 11, 14, 18};
        int [] stones2 =  {0,2,5,6,7};
        int result2 =  fj.maxfrogjump(stones2);
        System.out.println(result2);
        int result = fj.maxfrogjump(stones);
        System.out.println(result);
    }
}


//***/
//1 - the code is defining the `frogjump2` class with methods to determine the maximum jump distance a frog can make across stones.
//2 - the `maxfrogjump` method uses binary search to find the maximum jump distance the frog can make while still being able to cross all stones.
//3 - the `canCrossWithMaxJump` method checks if the frog can cross the stones with a given maximum jump distance by iterating through the stones and ensuring that the distance between consecutive stones does not exceed the maximum jump.