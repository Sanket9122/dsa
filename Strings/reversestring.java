package Strings;
import java.util.*;
public class reversestring {
    public String reverseString(String s){
        String trims = s.trim();
        String [] words = trims.split("\\s+");
        StringBuilder res = new StringBuilder ();
        for (int i = words.length-1 ;i>=0;i--){
            res.append(words[i]);
            if(i>0){
                res.append(" ");
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        reversestring rs = new reversestring ();
        String s = "hello new    world";
        System.out.println(rs.reverseString(s));
    }
}
