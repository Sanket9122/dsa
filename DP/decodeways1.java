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

//algorithmic explanation
//1. Base Case: If the index reaches the end of the string, it means we've found a valid decoding, so return 1.
//2. If the character at the current index is '0', return 0 since '0' cannot be decoded.
//3. Check if the result for the current index is already computed and stored in the memo array. If so, return that result to avoid redundant calculations.
//4. Recursive Case:
//   a. Calculate the number of ways to decode the string starting from the next index (index + 1).
//   b. If the next two characters form a valid two-digit number between 10 and 26, add the number of ways to decode the string starting from the next two indices (index + 2) to the result.
//5. Store the result in the memo array for the current index and return it.