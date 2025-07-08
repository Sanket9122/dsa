package Strings;
import java.util.*;
public class sumofBeauty {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                int minFreq = Integer.MAX_VALUE;
                int maxFreq = Integer.MIN_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        minFreq = Math.min(minFreq, f);
                        maxFreq = Math.max(maxFreq, f);
                    }
                }
                ans += maxFreq - minFreq;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        sumofBeauty sb = new sumofBeauty();
        String s = "aabcb";
        String s1 = "abc";
        System.out.println(sb.beautySum(s)); 
        System.out.println(sb.beautySum(s1));
    }
}