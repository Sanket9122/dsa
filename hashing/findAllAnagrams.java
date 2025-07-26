package hashing;
import java.util.*;
public class findAllAnagrams {
    public List<Integer>findAnagrans(String s , String P){
        List<Integer> result = new ArrayList<>();
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        for (char c : P.toCharArray()) {
            pFreq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;

            if (i >= P.length()) {
                sFreq[s.charAt(i - P.length()) - 'a']--;
            }

            if (Arrays.equals(pFreq, sFreq)) {
                result.add(i - P.length() + 1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        findAllAnagrams obj = new findAllAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = obj.findAnagrans(s, p);
        System.out.println(result);
    }
}
