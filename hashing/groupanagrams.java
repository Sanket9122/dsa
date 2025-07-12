package hashing;
import java.util.*;
public class groupanagrams {
    public List<List<String>> groupAnagrams(String [] strs){
        Map<String,List<String>> anagramMap = new HashMap<>();

        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        for(String str :strs){
            char [] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = new String(ch);
            if(!anagramMap.containsKey(sortedStr)){
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
    public static void main(String[] args) {
        groupanagrams g = new groupanagrams();
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagrams(strs));
    }
}
