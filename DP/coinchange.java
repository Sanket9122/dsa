package DP;
import java.util.*;
public class coinchange {
    public int coinchangecombination(int [] coins ,int amount){
        int n = coins.length ; 
        int [] dp = new int [amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i =1 ;i <= amount ; i++){
            for(int coin :coins){
                if(coin<=i){
                    dp[i]=  Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
    public static void main(String[] args) {
        coinchange ob = new coinchange();
        int [] coins = {1,2,5};
        int amount = 11;
        System.out.println(ob.coinchangecombination(coins, amount));
    }
}


//algorithmic explanation
//1. Initialize a dp array of size amount+1, where amount is the target amount to be formed using the coins. Fill the array with a value greater than amount (amount+1) to represent an initially unreachable state. Set dp[0] to 0, as zero coins are needed to make the amount 0.
//2. Iterate through all amounts from 1 to the target amount (inclusive):
//   a. For each amount, iterate through all coins:
//      i. If the current coin is less than or equal to the amount, calculate the minimum number of coins needed to make the amount by using the current coin and the amount minus the current coin.
//      ii. Update dp[i] with the minimum value between its current value and 1 plus the value of dp[i - coin] (which represents using one more coin).
//3. After filling the dp array, check the value at dp[amount]. If it is greater than amount, it means the target amount cannot be formed using the given coins. Return -1, as there is no way to make the amount.
//4. If dp[amount] is less than or equal to amount, return dp[amount], which represents the minimum number of coins needed to make the target amount.
