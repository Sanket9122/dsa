package Strings;
import java.util.*;
public class msgcompressor {
    public String compressor(String s){
        if (s == null || s.isEmpty()) {
            return "";
        }

        String reduced = new String();
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for(char c : s.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for(char c : charCount.keySet()){
            reduced = reduced + c + charCount.get(c);
        }
        return reduced.toString();

            
    }
    public static void main(String[] args) {
        msgcompressor mc = new msgcompressor();
        String s = "aaabbbccdaa";
        String s1 = "abcdd";
        System.out.println(mc.compressor(s));
        System.out.println(mc.compressor(s1));
    }
}





//2nd approach :


// package Strings;
// import java.util.*;
// public class msgcompressor {
//     public String compressor(String s){
//         if (s == null || s.isEmpty()) {
//             return "";
//         }

//         StringBuilder reduced = new StringBuilder();
//         HashMap<Character, Integer> charCount = new HashMap<>();
        
//         char prevChar = s.charAt(0);
//         charCount.put(prevChar, 1);

//         for (int i = 1; i < s.length(); i++) {
//             char currentChar = s.charAt(i);

//             if (currentChar == prevChar) {
//                 charCount.put(currentChar, charCount.get(currentChar) + 1);
//             } else {
                
//                 reduced.append(prevChar);
//                 int count = charCount.get(prevChar);
//                 if (count >= 1) {
//                     reduced.append(count);
//                 }
                
                
//                 prevChar = currentChar;
//                 charCount.put(prevChar, count);

//             }
//         }
//         reduced.append(prevChar);
//         int count = charCount.get(prevChar);
//         if(count >=1) {
//             reduced.append(count);
//         }
//         return reduced.toString();
//     }
//     public static void main(String[] args) {
//         msgcompressor mc = new msgcompressor();
//         String s = "aaabbbccdaa";
//         String s1 = "abcdd";
//         System.out.println(mc.compressor(s));
//         System.out.println(mc.compressor(s1));
//     }
// }


//algorithmic explanation :
//1. Initialize a StringBuilder to build the compressed string and a HashMap to count character frequencies.
//2. Iterate through the string, counting consecutive characters.
//3. If the current character is the same as the previous character, increment its count in the HashMap.
//4. If the current character is different from the previous character, append the previous character and its count to the StringBuilder.
//5. Set the previous character to the current character and reset its count in the HashMap.
//6. Append the last character and its count to the StringBuilder.
//7. Return the compressed string.




