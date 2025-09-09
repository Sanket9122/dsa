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
        int n2=6;
        System.out.println(obj.integerbreak(n));
        System.out.println(obj.integerbreak(n1));
        System.out.println(obj.integerbreak(n2));
    }
}


//algorithmic explanation
//1. We create a dp array of size n+1 to store the maximum product for each integer from 0 to n.
//2. We initialize dp[0] to 0, dp[1] to 1, dp[2] to 2, and dp[3] to 3 because these are the base cases.
//3. We iterate through all integers from 4 to n (inclusive).
//4. For each integer i, we iterate through all integers j from 1 to i/2 (inclusive).
//5. For each j, we update dp[i] by taking the maximum of dp[i] and dp[j] * dp[i-j].
//6. Finally, we return dp[n], which represents the maximum product for the given integer n.