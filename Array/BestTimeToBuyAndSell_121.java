package LeetCodeEx.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class BestTimeToBuyAndSell_121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxprofit(prices));
    }

    static int maxprofit(int[] prices) {

        int maxProfit = 0;
        int n = prices.length;
        int minimumPrice = prices[0];

        for (int i = 1; i < n; i++) {

            int cost = prices[i] - minimumPrice;

            maxProfit = Math.max(maxProfit, cost);
            minimumPrice = Math.min(prices[i], minimumPrice);
        }
        return maxProfit;
    }
}
