package Strings;
import java.util.*;
public class integertoroman {
    public String intToRoman(int num) {
        int [] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder romanNumeral = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                romanNumeral.append(symbols[i]);
                num -= values[i];
            }
        }
        return romanNumeral.toString();
    }
    public static void main(String[] args) {
        integertoroman itr = new integertoroman();
        int num1 = 1994;
        int num2 = 58;
        int num3 = 66;
        System.out.println(itr.intToRoman(num1)); 
        System.out.println(itr.intToRoman(num2)); 
        System.out.println(itr.intToRoman(num3));
    }
}
