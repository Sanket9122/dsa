package hashing;
import java.util.*;
public class GetRandom {
    private Map<Integer, Integer> resmap;
    private List<Integer> list;
    private Random random;
    public GetRandom(){
        resmap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    public boolean insert (int value){
        if(!resmap.containsKey(value)){
            resmap.put(value, list.size()-1);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        GetRandom gr = new GetRandom();
        System.out.println(gr.insert(1));
        System.out.println(gr.insert(2));
        System.out.println(gr.insert(1)); 
        System.out.println(gr.insert(3));
        System.out.println(gr.insert(2)); 
    }
}
