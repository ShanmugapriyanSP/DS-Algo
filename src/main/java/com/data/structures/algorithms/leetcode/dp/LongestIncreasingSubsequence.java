package com.data.structures.algorithms.leetcode.dp;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        int max = 0;
        Integer[] dp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dfs(nums, i, dp));
        }
        System.out.println(max);
    }

    private static int dfs(int[] nums, int i, Integer[] dp) {
        if (i >= nums.length)
            return 0;

        if (dp[i] != null)
            return dp[i];

        int res = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                res = Math.max(res, 1+ dfs(nums, j, dp));
            }
        }

        dp[i] = res;
        return res;
    }

}
