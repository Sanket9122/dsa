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

//algorithmic explanation
//1. we have to find the number of ways to reach the nth stair
//2. we can either take 1 step or 2 steps to reach the next stair
//3. we can use recursion with memoization to solve this problem
//4. we will create a HashMap to store the number of ways to reach each stair
//5. we will start from the second stair and move to the top recursively
//6. base case: if we reach the top, return 1
//7. if the value is already computed, return it from the memo HashMap
//8. otherwise, compute the number of ways to reach the current stair by taking 1 step or 2 steps
//9. store the result in the memo HashMap and return it
