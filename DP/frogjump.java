package DP;
import java.util.*;

public class frogjump {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(0).add(0);

        for (int stone : stones) {
            for (int k : dp.get(stone)) {
                if (k - 1 > 0 && dp.containsKey(stone + k - 1)) {
                    dp.get(stone + k - 1).add(k - 1);
                }
                if (k > 0 && dp.containsKey(stone + k)) {
                    dp.get(stone + k).add(k);
                }
                if (dp.containsKey(stone + k + 1)) {
                    dp.get(stone + k + 1).add(k + 1);
                }
            }
        }

        return dp.get(stones[stones.length - 1]).size() > 0;
    }
    
    public static void main(String[] args) {
        frogjump fj = new frogjump();
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(fj.canCross(stones));
        int[] stones2 = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(fj.canCross(stones2));
    }
}


