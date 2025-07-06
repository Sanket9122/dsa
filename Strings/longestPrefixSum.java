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
