package DP;
import java.util.*;
public class fib {
    public int fibonacci(int n){
        if(n<=1){
            return n;
        }
        // int [] dp = new int [n+1];
        // dp[0]= 0;
        // dp[1] = 1;
        // for(int i = 2 ; i<=n ;i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n];

        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String[] args) {
        fib f = new fib();
        Scanner sc = new Scanner(System.in);
        int n =8;
        System.out.println(f.fibonacci(n)); 
    }
}
