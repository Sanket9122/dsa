package DP;
import java.util.*;
public class nthtribonacci {
    private int [] memo ; 
    public int tribonacci(int n){
        memo = new int [n+1];
        Arrays.fill(memo  ,-1) ; 
        return tribon(n);
    }
    public int tribon(int n){
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        if(memo[n]!=-1) return memo[n];
        memo[n] = tribon(n-1)+tribon(n-2)+tribon(n-3);
        return memo[n];
    }
    public static void main(String[] args) {
        nthtribonacci ob = new nthtribonacci();
        Scanner sc = new Scanner(System.in);
        int n = 4; int n1 = 25;
        System.out.println(ob.tribonacci(n));
        System.out.println(ob.tribonacci(n1));
    }
}
