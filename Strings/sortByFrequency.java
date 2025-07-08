package Strings;
import java.util.*;
public class sortByFrequency {
    public String frequencySort(String s ){
        Map<Character ,Integer > map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else{
                map.put(c, 1);
            }
        }
        ArrayList<Character> res =  new ArrayList<>(map.keySet());
        res.sort((a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for(char c : res){
            int freq = map.get(c);
            for(int i = 0; i < freq; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        sortByFrequency sbf = new sortByFrequency();
        String s = "tree";
        String s1 = "cccaaa";
        System.out.println(sbf.frequencySort(s)); 
        System.out.println(sbf.frequencySort(s1)); 
    }
}
