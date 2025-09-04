package DP;
import java.util.*;
public class coinchange1 {
    private int []memo ; 
    public int coinchangecombination(int [] coins , int amount){
        memo = new int [amount+1];
        Arrays.fill(memo , 0) ; 
        int res = coinchanger(coins , amount ) ;
        return res;
    }
    public int coinchanger(int [] coins , int amount){
        if(amount == 0) return 0 ; 
        if(amount < 0 ) return -1 ; 
        if(memo[amount] != 0) return memo[amount] ; 
        int res = amount + 1 ; 
        for(int coin : coins){
            int subproblem = coinchanger(coins , amount - coin) ; 
            if(subproblem == -1) continue ; 
            res = Math.min(res , 1 + subproblem) ; 
        }
        
        memo[amount] = (res == amount + 1) ? -1 : res ; 
        return memo[amount] ; 
    }
    public static void main(String[] args) {
        coinchange1 ob = new coinchange1();
        int [] coins = {1,2,5};
        int amount = 11;
        System.out.println(ob.coinchangecombination(coins, amount));
    }
}

//algorithmic explanation
//1. Base Case: If the amount is 0, return 0 since no coins are needed to make the amount. If the amount is negative, return -1 since it's not possible to form a negative amount.
//2. Memoization Check: Before performing any calculations, check if the result for the current amount is already stored in the memo array. If so, return that result to avoid redundant calculations.
//3. Recursive Case:
//   a. Initialize the result to a large value (amount + 1) to represent an initially unreachable state.
//   b. Iterate through each coin in the coins array:
//      i. Calculate the result of the subproblem by recursively calling the coinchanger function with the amount reduced by the value of the current coin.
//      ii. If the subproblem returns -1, it means that the current coin cannot contribute to forming the amount, so continue to the next coin.
//      iii. Update the result with the minimum value between its current value and 1 plus the value of the subproblem (which represents using one more coin).
//4. Store the result in the memo array for the current amount. If the result is still equal to amount + 1, it means the amount cannot be formed using the given coins, so store -1 instead.
//5. Return the result for the current amount.
