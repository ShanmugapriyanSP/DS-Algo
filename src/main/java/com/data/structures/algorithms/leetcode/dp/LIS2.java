package com.data.structures.algorithms.leetcode.dp;

import java.util.Arrays;

public class LIS2 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(nums, i, cache));
        }
        return res;
    }

    private static int dfs(int[] nums, int i, int[] cache) {
        if (i >= nums.length)
            return 0;

        if (cache[i] != -1)
            return cache[i];
        int tempRes = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                tempRes = Math.max(tempRes, 1+dfs(nums, j, cache));
            }
        }
        cache[i] = tempRes;
        return cache[i];
    }
}
