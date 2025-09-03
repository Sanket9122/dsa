package DP;
import java.util.*;
public class decodeways {
    public int numdecoding(String s){
        int n =s.length();
        int [] dp = new int [n+1];
        dp[0] = 1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int one = Integer.parseInt(s.substring(i-1,i));
            int two = Integer.parseInt(s.substring(i-2,i));
            if(one>=1 && one<=9) dp[i]+=dp[i-1];
            if(two>=10 && two<=26) dp[i]+=dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        decodeways ob = new decodeways();
        String s = "226";
        System.out.println(ob.numdecoding(s));
    }
}
