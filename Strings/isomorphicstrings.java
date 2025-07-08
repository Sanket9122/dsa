package Strings ;
import java.util.*;
public class isomorphicstrings{
    public boolean isIsomorphic(String s,String t){
        Map<Character,Character> map_to_s= new HashMap<>();
        Map<Character,Character> map_to_t= new HashMap<>();
        int n =s.length();
        if(n!=t.length()){
            return false;
        }
        for(int i=0 ;i <n;i++){
            char ch_s =s.charAt(i);
            char ch_t =t.charAt(i);
            if(map_to_s.containsKey(ch_s)){
                if(map_to_s.get(ch_s) != ch_t){
                    return false;
                }
            } else {
                map_to_s.put(ch_s, ch_t);
            }
            if(map_to_t.containsKey(ch_t)){
                if(map_to_t.get(ch_t) != ch_s){
                    return false;
                }
            } else {
                map_to_t.put(ch_t, ch_s);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        isomorphicstrings iso = new isomorphicstrings();
        String s1 = "egg";
        String t1 = "add";
        String s2 = "foo";
        String t2 = "bar";
        System.out.println(iso.isIsomorphic(s1, t1)); 
        System.out.println(iso.isIsomorphic(s2, t2)); 
    }
}