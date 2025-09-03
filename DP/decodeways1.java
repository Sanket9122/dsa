package DP;
import java.util.*;

public class decodeways1 {
    private Integer[] memo;

    public int numDecoding(String s) {
        int n = s.length();
        memo = new Integer[n + 1];
        return decoder(s, 0);
    }

    public int decoder(String s, int index) {
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        int result = decoder(s, index + 1);

        if (index + 1 < s.length()) {
            int twoDigits = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigits >= 10 && twoDigits <= 26) {
                result += decoder(s, index + 2);
            }
        }

        memo[index] = result;
        return result;
    }

    public static void main(String[] args) {
        decodeways1 ob = new decodeways1();
        String s = "226";
        System.out.println(ob.numDecoding(s));
    }
}