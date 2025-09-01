package DP;
import java.util.*;

import hashing.hashmap;
public class climbingstairs1 {
    private HashMap<Integer,Integer> memo = new HashMap<>();
    public int climbstairs(int n){
        if(n<=2){
            return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result = climbstairs(n-1)+climbstairs(n-2);
        memo.put(n,result);
        return result;
    }
    public static void main(String[] args) {
        climbingstairs1 ob = new climbingstairs1();
        Scanner sc = new Scanner(System.in);
        int n = 4;int n1 = 5;
        System.out.println(ob.climbstairs(n1));
        System.out.println(ob.climbstairs(n));
    }
}
