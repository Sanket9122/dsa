package DP;
import java.util.*;
public class coinchange2 {
    public int changedecoder(int [] coins ,  int amount){
        int [] dp = new int [amount+1]; 
        Arrays.fill(dp  , 0);
        dp[0]=1;
        for(int coin:coins){
            for(int i = coin ;i<=amount ;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        coinchange2 obj = new coinchange2();
        int [] coins = {1,2,5};
        int amount = 5;
        System.out.println(obj.changedecoder(coins, amount));
    }
}
