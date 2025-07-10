package hashing;
import java.util.*;
public class uniquecharacter {
    public int unique(String s){
        int n = s.length();
        HashMap<Character ,Integer> Umap = new HashMap<>();
        for(int i= 0 ; i< n ; i++){
            char ch =s.charAt(i);
            Umap.put(ch , Umap.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i<n ;i++){
            char ch = s.charAt(i);
            if(Umap.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        uniquecharacter uch = new uniquecharacter();
        String s = "leetcode";
        String s1 = "aabbbccbbcd";
        int result = uch.unique(s);
        System.out.println(result);
        System.out.println(uch.unique(s1));
    }
}
