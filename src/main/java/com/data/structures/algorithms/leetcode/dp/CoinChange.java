package com.data.structures.algorithms.leetcode.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] nums = {186, 419, 83, 408};
        System.out.println(coinChange(nums, 6249));
    }

    private static Integer coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Integer[] dp = new Integer[amount + 1];
        System.out.println(coin(coins, amount, dp));
        for(Integer value: dp)
            System.out.print(value + " ");
        return dp[coins.length - 1];
    }

    private static Integer coin(int[] coins, int amount, Integer[] dp) {
        if (amount < 1) return 0;


        if (dp[amount] != null)
            return dp[amount];

        int minRes = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int res = coin(coins, amount - coin, dp);
                if (res != Integer.MAX_VALUE) {
                    minRes = Math.min(minRes, 1 + res);
                }
            }
        }
        dp[amount] = minRes;
        return minRes;

    }
}
