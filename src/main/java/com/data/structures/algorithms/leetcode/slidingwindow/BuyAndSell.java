package com.data.structures.algorithms.leetcode.slidingwindow;

import java.util.LinkedList;

public class BuyAndSell {

    public static void main(String[] args) {
        findMaxProfit(new int[] {7,3,10,1,5,2});
        findMaxProfit(new int[] {1,3,16,1,5,15});
        findMaxProfit(new int[] {15,14,13,12,11,10});
    }

    private static void findMaxProfit(int[] prices) {
        if (prices.length < 1)
            return;

        int maxProfit = 0;
        int minBuy = prices[0];
        int buy = -1, sell = -1;
        for (int i = 1; i < prices.length; i++) {
            if (maxProfit < prices[i] - minBuy) {
                maxProfit = prices[i] - minBuy;
                buy = minBuy;
                sell = prices[i];
            }
            minBuy = Math.min(minBuy, prices[i]);
        }

        System.out.println("Buy: " + buy + ", Sell: " + sell + ", Profit: " + maxProfit);
    }
}
