package DP;
import java.util.*;
public class decodeways {
    public int numdecoding(String s){
        int n =s.length();
        int [] dp = new int [n+1];
        dp[0] = 1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int one = Integer.parseInt(s.substring(i-1,i));
            int two = Integer.parseInt(s.substring(i-2,i));
            if(one>=1 && one<=9) dp[i]+=dp[i-1];
            if(two>=10 && two<=26) dp[i]+=dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        decodeways ob = new decodeways();
        String s = "226";
        System.out.println(ob.numdecoding(s));
    }
}


//algorithmic explanation
//1. Initialize a dp array of size n+1, where n is the length of the input string. Set dp[0] to 1 (base case for an empty string) and dp[1] to 1 (assuming the first character is valid).
//2. Iterate through the string from index 2 to n (inclusive):
//   a. Calculate the number of ways to decode the string starting from the current index (i).
//   b. If the current two characters form a valid two-digit number between 10 and 26, add the number of ways to decode the string starting from the next two indices (i + 2) to the result.
//   c. If the current single character is between 1 and 9, add the number of ways to decode the string starting from the next index (i + 1) to the result.
//3. The final result will be stored in dp[n], which represents the total number of ways to decode the entire string.