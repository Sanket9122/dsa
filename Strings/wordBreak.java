package Strings;
import java.util.*;
public class wordBreak {
    public boolean wordbreak(String s , List<String> wordlist){
        HashSet<String> set  = new HashSet<>(wordlist);
        int n = s.length();
        boolean [] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 0; i<n; i++){
            if(!dp[i]) continue;
            for(int j = i; j < n; j++){
                String sub = s.substring(i, j+1);
                if(set.contains(sub)){
                    dp[j+1] = true;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        wordBreak wl = new wordBreak();
        List<String> wordList = Arrays.asList("leet","code");
        System.out.println(wl.wordbreak("leetcode", wordList)); 
    }
}


//algorithm explanation:
//1. Create a HashSet from the word list for O(1) lookups.
//2. Initialize a boolean array `dp` where `dp[i]` indicates if the substring `s[0:i]` can be segmented into words from the word list.
//3. Set `dp[0]` to true, as an empty string can always be segmented.
//4. Iterate through the string `s` using two nested loops: the outer loop iterates over each position `i` in the string, and the inner loop iterates from `i` to the end of the string to check all possible substrings starting from `i`.
//5. If `dp[i]` is true, check all substrings `s[i:j+1]` and if they exist in the word set, mark `dp[j+1]` as true. This indicates that the substring `s[0:j+1]` can be segmented into words from the word list.
//6. Finally, return `dp[n]`, which indicates whether the entire string can be segmented into words from the word list.


//example visualization:
//For the string "leetcode" and word list ["leet", "code"], the `dp` array will be updated as follows:
//- Start with `dp = [true, false, false, false, false, false, false, false, false]`.
//- After processing "leet", `dp` becomes `[true, false, false, false, true, true, false, false, false]`.
//- After processing "code", `dp` becomes `[true, false, false, false, true, true, false, false, true]`.    
//- Finally, `dp[n]` is true, indicating that the entire string can be segmented into words from the word list.
