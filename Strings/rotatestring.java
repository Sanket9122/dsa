package Strings;
import java.util.*;
public class rotatestring {
    public boolean rotateString(String s , String goal){
        if (s.length()!=goal.length()){
            return false;
        }
        String res = s+s;
        if(res.contains(goal)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        rotatestring rs = new rotatestring ();
        System.out.println(rs.rotateString("abcde", "cdeab")); 
        System.out.println(rs.rotateString("abcde", "abced"));
    }
}
