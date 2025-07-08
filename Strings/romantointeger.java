package Strings;
import java.util.*;
public class romantointeger {
    public int romanToInteger(String s){
        HashMap<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int Int_value = 0 ;
        for(int i = 0;i < s.length(); i++){
            int current_value = romanMap.get(s.charAt(i));
            if(i < s.length() -1 && current_value < romanMap.get(s.charAt(i + 1))){
                Int_value -= current_value; 
            } else {
                Int_value += current_value; 
            }
        }
        return Int_value;
    }
    public static void main(String[] args) {
        romantointeger rti = new romantointeger();
        String s = "MCMXCIV";
        System.out.println(rti.romanToInteger(s));
    }
}
