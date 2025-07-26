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
        String s1 = "abcabc";
        int result = ac.anagramconcat(s);
        int result1 = ac.anagramconcat(s1);
        System.out.println(result);
        System.out.println(result1);
    }
}

// Algorithm Explanation:
// 1. We iterate through possible chunk sizes k from 1 to n (length of the string).
// 2. For each k, we check if n is divisible by k.
// 3. If it is, we calculate the frequency of characters in the first chunk.
// 4. Then, we check if the remaining chunks are anagrams of the first chunk.
// 5. If they are, we return k as the result.
// 6. If no such k is found, we return n, indicating that the entire string is the only valid chunk size.
// 7. The main method demonstrates the usage of the anagramconcat method with a sample string.
// 8. The output will be the size of the smallest chunk that can be repeated to form the original string, which is printed to the console.


///// example visualization:
// For the string "ababab":
//  k = 1: "a", "b", "a", "b", "a", "b" (not all chunks are anagrams)
//  k = 2: "ab", "ab", "ab" (all chunks are anagrams, return 2)
//  k = 3: "aba", "bab" (not all chunks are anagrams)
//  k = 4: "abab", "ab" (not all chunks are anagrams)
//  k = 5: "ababa", "b" (not all chunks are anagrams)
//  k = 6: "ababab" (the whole string, not a valid chunk size)
// For the string "ababbbab":
//  k = 1: "a", "b", "a", "b", "b", "a", "b", "b" (not all chunks are anagrams)
//  k = 2: "ab", "ab", "bb", "ab" (not all chunks are anagrams)
//  k = 3: "aba", "bbb", "ab" (not all chunks are anagrams)
//  k = 4: "abab", "bbab" (not all chunks are anagrams)
//  k = 5: "ababb", "bab" (not all chunks are anagrams)
//  k = 6: "ababbb", "ab" (not all chunks are anagrams)
//  k = 7: "ababbb", "ab" (not all chunks are anagrams)
//  k = 8: "ababbbab" (the whole string, not a valid chunk size)