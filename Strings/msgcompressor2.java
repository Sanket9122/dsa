package Strings;
import java.util.*;
public class msgcompressor2 {
    public String compressedMessages(String s ){
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int i = 0;
        if(n==0){
            return " ";
        }
        
        while(i<n){
            char currchar = s.charAt(i);
            int count =1;
            while(i+1<n && s.charAt(i+1)==currchar){
                count++;
                i++;
            }
            result.append(currchar);
            if(count>=1){
                result.append(count);
            }
            i++;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        msgcompressor2 mc = new msgcompressor2();
        String s = "aaabbbccddef";
        String s1 = "sssaaankkketpp";
        System.out.println(mc.compressedMessages(s));
        System.out.println(mc.compressedMessages(s1));
    }
}
