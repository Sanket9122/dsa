package hashing;
import java.util.*;
public class jewelstones {
    public int JewelStones(String jewels ,String Stones){
        int count = 0 ;
        HashSet<Character> jewelSet = new HashSet<>();
        char[] jewelarray = jewels.toCharArray();
        char[] stonearray = Stones.toCharArray();
        for(char jewel : jewelarray){
            jewelSet.add(jewel);
        }
        for(char stone : stonearray){
            if(!jewelSet.contains(stone)){
                break;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        jewelstones jewel = new jewelstones();
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(jewel.JewelStones(jewels,stones));
    }
}
