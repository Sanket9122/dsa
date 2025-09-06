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
        int [] coins1 = {10,20,3};
        int amount1 =4;
        int amount = 5;
        System.out.println(obj.changedecoder(coins, amount));
        System.out.println(obj.changedecoder(coins1, amount1));
    }
}


//algorithmic explanation
//1. We create a dp array of size amount+1 to store the number of ways to make change for each amount from 0 to the target amount.
//2. We initialize dp[0] to 1 because there is one way to make change for amount 0 (using no coins).
//3. We iterate through each coin in the coins array.
//4. For each coin, we iterate through all amounts from coin to the target amount (inclusive).
//5. For each amount, we update dp[i] (where i is the current amount) by adding the number of ways to make change for the amount i-coin (dp[i-coin]) to the current number of ways (dp[i]).
//6. Finally, we return dp[amount], which represents the number of ways to make change for the target amount.

