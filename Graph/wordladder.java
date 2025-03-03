package Graph;
import java.util.*;
public class wordladder {
    public int ladderlength(String beginword , String endword  ,List<String> Wordlist){
        Queue<String> q = new LinkedList<>();
        HashSet<String> st = new HashSet<>(Wordlist);
        q.add(beginword);
        int level =1;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String currword = q.poll();
                for (int j =  0; j< currword.length(); j++) {
                    char [] chars = currword.toCharArray();
                    for(char ch = 'a'; ch<='z'; ch++){
                        chars[j] = ch;
                        String newword = new String(chars);
                        if (newword.equals(endword)) {
                            return level + 1;
                        }
                        if (st.contains(newword)) {
                            q.add(newword);
                            st.remove(newword);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        wordladder w = new wordladder();
        String beginword = "hit" ;
        String endword = "cog";
        List<String> Wordlist = new ArrayList<>();
        Wordlist.add("bot");
        Wordlist.add("hot");
        Wordlist.add("dot");
        Wordlist.add("dog");
        Wordlist.add("loc");        
        Wordlist.add("lot");
        Wordlist.add("log");
        Wordlist.add("cog");
        System.out.println(w.ladderlength(beginword, endword, Wordlist));
    }
}
