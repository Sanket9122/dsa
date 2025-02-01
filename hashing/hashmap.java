package hashing;

import java.util.HashMap;

public class hashmap {
    public static void main(String[] args) {
        HashMap <Integer,String> map = new HashMap <Integer,String>();
        map.put (2237266,"sanket");
        map.put(2237247,"rahul");
        map.put(2237279,"siddhharth");
        System.out.println(map);
        map.remove (2237247);
        System.out.println(map);
        System.out.println(map.size());

    }    
}
