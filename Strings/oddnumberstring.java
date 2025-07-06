package Strings;
import java.util.*;
public class oddnumberstring {
    public String oddnumberString(String num){
        int n= num.length();
        for(int i =n-1;i>=0;i--){
            char digitChar = num.charAt(i);
            int digit = digitChar - '0';
            if(digit%2!=0){
                return num.substring(0, i+1);
            }
        }
        return " ";
    }
    public static void main(String[] args) {
        oddnumberstring obj = new oddnumberstring();
        String num = "52";
        String num1 = "754620";
        System.out.println(obj.oddnumberString(num));
        System.out.println(obj.oddnumberString(num1));
    }
}
