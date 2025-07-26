package hashing;

import java.util.Arrays;

public class anagramconcatenation {
    public int anagramconcat(String s) {
        int n = s.length();

        for (int k = 1; k <= n; k++) {
            if (n % k == 0) {
                int[] firstChunkFreq = new int[26];
                for (int i = 0; i < k; i++) {
                    firstChunkFreq[s.charAt(i) - 'a']++;
                }

                boolean allChunksAreAnagrams = true;
                
                for (int i = k; i < n; i += k) {
                    int[] currentChunkFreq = new int[26];
                    for (int j = 0; j < k; j++) {
                        currentChunkFreq[s.charAt(i + j) - 'a']++;
                    }

                    if (!Arrays.equals(firstChunkFreq, currentChunkFreq)) {
                        allChunksAreAnagrams = false;
                        break;
                    }
                }

                if (allChunksAreAnagrams) {
                    return k;
                }
            }
        }
        return n;
    }
    public static void main(String[] args) {
        anagramconcatenation ac = new anagramconcatenation();
        String s = "ababab";
        int result = ac.anagramconcat(s);
        System.out.println(result);
    }
}