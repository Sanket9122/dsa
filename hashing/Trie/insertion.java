package hashing.Trie;
import java.util.*;
public class insertion{
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordCount = 0;
    }
    static void insert (TrieNode root , String key){
        TrieNode curTrieNode = root; 
        for (int i = 0; i < key.length(); i++) 
        {
            int index = key.charAt(i) - 'a';
            if (curTrieNode.children[index] == null) 
            {
                curTrieNode.children[index] = new TrieNode();
            }
            curTrieNode = curTrieNode.children[index];
        }
        curTrieNode.wordCount++;
    }
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
    
    // Insert some words
    insert(root, "hello");
    insert(root, "hi");
    insert(root, "hello"); // Insert "hello" again to increase wordCount

    // Check the wordCount for "hello"
    TrieNode curNode = root;
    for (char c : "hello".toCharArray()) {
        int index = c - 'a';
        curNode = curNode.children[index];
    }
    System.out.println("Word count for 'hello': " + curNode.wordCount); // Should print 2

        
    }
}
// package hashing.Trie;

// import java.util.*;

// public class TrieExample {
//     static class TrieNode {
//         TrieNode[] children = new TrieNode[26]; // For 26 lowercase English letters
//         int wordCount = 0; // To count how many times a word ends at this node
//     }

//     static class Trie {
//         private TrieNode root;

//         public Trie() {
//             root = new TrieNode();
//         }

//         // Method to insert a word into the Trie
//         public void insert(String key) {
//             TrieNode curTrieNode = root;
//             for (int i = 0; i < key.length(); i++) {
//                 int index = key.charAt(i) - 'a'; // Calculate index (0-25)
//                 if (curTrieNode.children[index] == null) {
//                     curTrieNode.children[index] = new TrieNode(); // Create new node if it doesn't exist
//                 }
//                 curTrieNode = curTrieNode.children[index]; // Move to the child node
//             }
//             curTrieNode.wordCount++; // Increment the word count at the end of the word
//         }

//         // Method to get the word count for a given word
//         public int getWordCount(String key) {
//             TrieNode curTrieNode = root;
//             for (int i = 0; i < key.length(); i++) {
//                 int index = key.charAt(i) - 'a';
//                 if (curTrieNode.children[index] == null) {
//                     return 0; // If the word is not found, return 0
//                 }
//                 curTrieNode = curTrieNode.children[index];
//             }
//             return curTrieNode.wordCount; // Return the word count at the end of the word
//         }
//     }

//     public static void main(String[] args) {
//         Trie trie = new Trie();

//         // Insert words into the Trie
//         trie.insert("hello");
//         trie.insert("hi");
//         trie.insert("hello"); // Insert "hello" again to increase wordCount
//         trie.insert("hey");

//         // Check the word count for each word
//         System.out.println("Word count for 'hello': " + trie.getWordCount("hello")); // Should print 2
//         System.out.println("Word count for 'hi': " + trie.getWordCount("hi")); // Should print 1
//         System.out.println("Word count for 'hey': " + trie.getWordCount("hey")); // Should print 1
//         System.out.println("Word count for 'world': " + trie.getWordCount("world")); // Should print 0 (not inserted)
//     }
// }