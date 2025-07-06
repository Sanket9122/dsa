package Strings;
import java.util.*;
public class longestPrefixSum {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        char [] first = strs[0].toCharArray();
        char [] last = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < first.length; i++) {
            if (first[i] == last[i]) {
                res.append(first[i]);
            } else {
                break;
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        longestPrefixSum lps = new longestPrefixSum();
        String[] strs = {"flower","flow","flight"};
        System.out.println(lps.longestCommonPrefix(strs));
    }
}



//2nd approach
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs == null || strs.length == 0) {
//             return "";
//         }
        
//         if (strs.length == 1) {
//             return strs[0];
//         }

//         String firstStr = strs[0];

//         for (int i = 0; i < firstStr.length(); i++) {
//             char currentChar = firstStr.charAt(i);

//             for (int j = 1; j < strs.length; j++) {
//                 if (i == strs[j].length() || strs[j].charAt(i) != currentChar) {
//                     return firstStr.substring(0, i);
//                 }
//             }
//         }

//         return firstStr;
//     }
// }