package Strings;

import java.util.*;

public class maximumNestedDepths {
    public int maxDepth(String s) {
        int maxdepth = 0;
        int currdepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                maxdepth++;
                if (maxdepth > currdepth) {
                    currdepth = maxdepth;
                }
            } else if (ch == ')') {
                currdepth--;
            }
        }
        return maxdepth ; 
    }
    public static void main(String[] args) {
        maximumNestedDepths mnd = new maximumNestedDepths();
        String s = "(1+(2*3)+((8)/4))+1";
        String s1 = "(1)+((2))+(((3)))";
        System.out.println(mnd.maxDepth(s));   
        System.out.println(mnd.maxDepth(s1)); 
    }
}
