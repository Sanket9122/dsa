package hashing;
import java.util.*;
public class longestcharcterreplacement {
    public int characterReplacement (String s, int k) {
       int length =1 , i = 0 , j= 1 , maxfreq=0  ,ans =1;
       Map<Character,Integer> map = new HashMap<>();
       while (j<s.length()){
        char ch = s.charAt(j);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        length ++ ; 
        maxfreq = Math.max(maxfreq, map.get(ch));
        if (length - maxfreq > k) {
            j++ ; 
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            i++;
            ans = Math.max(ans, length-1);
            length--;
        }
        else{
            j++;
            ans = Math.max(ans, length);
        }
        
       }
       return ans;
    }
    public static void main(String[] args) {
        longestcharcterreplacement lcr = new longestcharcterreplacement();
        String s = "AABABBA";
        String s1 = "ABABB";
        int k = 1;
        int k1 = 2;
        int result = lcr.characterReplacement(s, k);
        int result1 = lcr.characterReplacement(s1, k1);
        System.out.println(result);
        System.out.println(result1); 
    }
}



///algorithm explanation 
///  The algorithm uses a sliding window approach to find the length of the longest substring
/// that can be formed by replacing at most k characters.
/// It maintains a HashMap to track the frequency of characters in the current substring.
/// It also maintains a variable maxfreq to track the maximum frequency of any character in the substring.  
/// If the difference between the current substring length and the maximum frequency is greater than k,
/// it means we need to replace characters, so we move the start of the window forward.
/// The algorithm continues expanding the end of the window until it reaches the end of the string.
///  The time complexity is O(n) where n is the length of the string, as each character is processed at most twice (once when added and once when removed).
/// The space complexity is O(1) since the size of the HashMap is limited to