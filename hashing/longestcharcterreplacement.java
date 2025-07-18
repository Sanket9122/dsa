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
