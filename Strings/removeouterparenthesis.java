package Strings;
import java.util.*;
public class removeouterparenthesis {
    public String removeouter(String s){
        int count = 0 ;
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count > 0) {
                    res.append(ch);
                }
                count++;
            } else  {
                count--;
                if (count > 0) {
                    res.append(ch);
                }
            }
        }
        return res.toString();
    } 
    public static void main(String[] args) {
        removeouterparenthesis r = new removeouterparenthesis();
        String s = "(()())(())(())";
        System.out.println(r.removeouter(s));
    }
}
