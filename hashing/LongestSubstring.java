// package hashing;
// import java.util.*;
// public class LongestSubstring {
//     public int lengthoflongestsubstring(String s){
//        int maxLength = 0;
//        for(int i=0 ; i<s.length();i++){
//             for(int j=i;j<s.length();j++){
//                 if(areUnique(s,i,j)){
//                     maxLength =Math.max(maxLength,j-i+1); 
//                 }
//             }
//         }
//         return maxLength;
//     }
//     private boolean areUnique(String s, int start, int end) {
//         HashSet<Character> set = new HashSet<>();
//         for (int i = start; i <= end; i++) {
//             if (set.contains(s.charAt(i))) {
//                 return false;
//             }
//             set.add(s.charAt(i));
//         }
//         return true;
//     }
//     public static void main(String[] args) {
//         LongestSubstring ls = new LongestSubstring();
//         String s = "abcabcbb";
//         String s1 = "bbbbb";
//         String s2 = "pwwkew";
//         System.out.println(ls.lengthoflongestsubstring(s)); 
//         System.out.println(ls.lengthoflongestsubstring(s1)); 
//         System.out.println(ls.lengthoflongestsubstring(s2)); 
//     }
// }

// This code finds the length of the longest substring without repeating characters.
// It uses a brute force approach to check all substrings and determine if they contain unique characters
// by utilizing a HashSet to track characters in the current substring.
// The time complexity is O(n^3) due to the nested loops and the character checking





//efficient approach

package hashing;
import java.util.*;
public class LongestSubstring {
    public int lengthoflongestsubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            if (map.containsKey(currentChar)) {
                start = Math.max(map.get(currentChar) + 1, start);
            }
            map.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
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


// This code finds the length of the longest substring without repeating characters using a sliding window approach.
// It maintains a HashMap to track the last index of each character and adjusts the start index when a repeating character is encountered.
// The time complexity is O(n) because the HashMap and the loop iterate through the string once.
