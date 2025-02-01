package hashing;
import java.util.*;
import java.util.Iterator;
public class hashset {
    public static void main(String[] args) {
        HashSet<Integer> ht  = new HashSet();
        ht.add(1);
        ht.add(2);
        ht.add(3);
        ht.add(4);
        ht.add(5);
        ht.add(6);
        Iterator <Integer> itr = ht.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next());
        }   



    }
}
