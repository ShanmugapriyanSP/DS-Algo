package com.data.structures.algorithms.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence2 {

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence2().lengthOfLIS(new int[] {4,10,4,3,8,9}));
    }


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1)
            return 1;
        Map<Integer, Integer> cache = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(nums, i, cache));
        }
        return res;
    }

    private int dfs(int[] nums, int i, Map<Integer, Integer> cache){
        if (i >= nums.length)
            return 0;

        if (cache.containsKey(i))
            return cache.get(i);

        int res = 1;
        for(int x = i+1; x < nums.length; x++) {
            if (nums[i] < nums[x]) {
                res = Math.max(res, 1 + dfs(nums, x, cache));
            }
        }

        cache.put(i, res);
        return res;
    }
}
