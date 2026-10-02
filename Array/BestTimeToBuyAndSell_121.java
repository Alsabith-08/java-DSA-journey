
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// IDEA : Minimum Price= cheapest price seen so far , For every current price: cost , maxProfit , update minimumPrice

// Time Complexity : O(n)  
// Space Complexity :O(1)

public class BestTimeToBuyAndSell_121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxprofit(prices));
    }

    static int maxprofit(int[] prices) {

        int maxProfit = 0;                                       // initially 0
        int n = prices.length;
        int minimumPrice = prices[0];                           // initially first price is the minimum Price

        for (int i = 1; i < n; i++) {

            int profit = prices[i] - minimumPrice;               // find the profit by currentPrice with nextPrice

            maxProfit = Math.max(maxProfit, profit);             // update the maxProfit if profit is greater than maxProfit
            minimumPrice = Math.min(prices[i], minimumPrice);    // update the minimumPrice by check currentprice is less than currentMinPrice
        }
        return maxProfit;
    }
}
