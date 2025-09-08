package DP;
import java.util.*;
public class IntegerBreak {
    public int integerbreak(int n){
        int [] dp =new int[n+1];
        Arrays.fill(dp , 0);
        if(n==0)   return 0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++){
            for(int j=1;j<=i/2;j++){
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        IntegerBreak obj = new IntegerBreak();
        int n = 10;
        int n1=4;
        System.out.println(obj.integerbreak(n));
        System.out.println(obj.integerbreak(n1));
    }
}