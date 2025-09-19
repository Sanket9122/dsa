package Strings;
import java.util.*;
public class happytriplets {
    public int countdivisblestrings(String s){
        int n = s.length();
        int count = 0 ;
        for(int i = 0 ; i< n -2 ; i++){
            int digit1 = Character.getNumericValue(s.charAt(i));
            int digit2 = Character.getNumericValue(s.charAt(i+1));
            int digit3 = Character.getNumericValue(s.charAt(i+2));
            int sum = digit1 + digit2 + digit3 ;
            if(sum % 3 == 0){
                count++;
            }
        }
        return count ;
    }
    public static void main(String[] args) {
        happytriplets obj = new happytriplets();
        String s = "12345680";
        System.out.println(obj.countdivisblestrings(s));
        String s1 = "357698";
        System.out.println(obj.countdivisblestrings(s1));
    }
}

//algorithmic explanation
//we will iterate through the string and for each triplet of consecutive characters
//we will convert them to integers and calculate their sum
//if the sum is divisible by 3 we will increment our count
//finally we will return the count of such triplets
