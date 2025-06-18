import java.util.*;
public class buysellstock{
    public static int bestTimeToBuyAndSell(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; 
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int [] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = bestTimeToBuyAndSell(prices);
        System.out.println("Maximum profit from buying and selling stock: " + maxProfit);
    }
}