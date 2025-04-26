package com.data.structures.algorithms.leetcode.dp;

import java.util.Arrays;

public class ClimbingStairs {

    private static int climb(int n, int i, int[] dp) {
        if (i >= n) return i == n ?  1: 0;
        if (dp[i] != -1) return dp[i];
        dp[i] = climb(n ,i+1, dp) + climb(n, i+2, dp);
        return dp[i];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(climb(n , 0, dp));

        dp = new int[n];
        dp[0] = 1; dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n-1]);
    }
}
