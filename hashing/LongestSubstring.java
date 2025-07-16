package hashing;
import java.util.*;
public class LongestSubstring {
    public int lengthoflongestsubstring(String s){
       int maxLength = 0;
       for(int i=0 ; i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(areUnique(s,i,j)){
                    maxLength =Math.max(maxLength,j-i+1); 
                }
            }
        }
        return maxLength;
    }
    private boolean areUnique(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        String s = "abcabcbb";
        String s1 = "bbbbb";
        String s2 = "pwwkew";
        System.out.println(ls.lengthoflongestsubstring(s)); 
        System.out.println(ls.lengthoflongestsubstring(s1)); 
        System.out.println(ls.lengthoflongestsubstring(s2)); 
    }
}
