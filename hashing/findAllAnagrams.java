// package hashing;
// import java.util.*;
// public class findAllAnagrams {
//     public List<Integer>findAnagrans(String s , String P){
//         List<Integer> result = new ArrayList<>();
//         int[] pFreq = new int[26];
//         int[] sFreq = new int[26];

//         for (char c : P.toCharArray()) {
//             pFreq[c - 'a']++;
//         }

//         for (int i = 0; i < s.length(); i++) {
//             sFreq[s.charAt(i) - 'a']++;

//             if (i >= P.length()) {
//                 sFreq[s.charAt(i - P.length()) - 'a']--;
//             }

//             if (Arrays.equals(pFreq, sFreq)) {
//                 result.add(i - P.length() + 1);
//             }
//         }
//         return result;
//     }
//     public static void main(String[] args) {
//         findAllAnagrams obj = new findAllAnagrams();
//         String s = "cbaebabacd";
//         String p = "abc";
//         List<Integer> result = obj.findAnagrans(s, p);
//         System.out.println(result);
//     }
// }

//Algorithm Explanation:
// 1. We create two frequency arrays, pFreq for the pattern P and sFreq for the substring of s.
// 2. We populate pFreq with the character counts of P.
// 3. We iterate through the string s, updating sFreq with the character counts of the current window of size equal to P.
// 4. If the current window size exceeds the length of P, we decrement the count of the character that is sliding out of the window.
// 5. After updating sFreq, we check if it matches pFreq.
// 6. If it does, we add the starting index of the window to the result list.   
// 7. Finally, we return the result list containing all starting indices of anagrams of P in s.

//2nd approach using HashMap
package hashing;
import java.util.*;
public class findAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> pFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();

        for (char c : p.toCharArray()) {
            pFreq.put(c, pFreq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            sFreq.put(currentChar, sFreq.getOrDefault(currentChar, 0) + 1);

            if (i >= p.length()) {
                char charToRemove = s.charAt(i - p.length());
                if (sFreq.get(charToRemove) == 1) {
                    sFreq.remove(charToRemove);
                } else {
                    sFreq.put(charToRemove, sFreq.get(charToRemove) - 1);
                }
            }

            if (pFreq.equals(sFreq)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findAllAnagrams obj = new findAllAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = obj.findAnagrams(s, p);
        System.out.println(result);
    }
}

// Algorithm Explanation:
// 1. We create two HashMaps, pFreq for the pattern P and sFreq for the substring of s.
// 2. We populate pFreq with the character counts of P. 
// 3. We iterate through the string s, updating sFreq with the character counts of the current window of size equal to P.
// 4. If the current window size exceeds the length of P, we decrement the count of the character that is sliding out of the window.
// 5. After updating sFreq, we check if it matches pFreq.   
// 6. If it does, we add the starting index of the window to the result list.
// 7. Finally, we return the result list containing all starting indices of anagrams of P in s.