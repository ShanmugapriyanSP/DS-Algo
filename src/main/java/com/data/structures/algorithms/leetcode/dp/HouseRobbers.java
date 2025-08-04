package com.data.structures.algorithms.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobbers {

    static Map<Integer, Integer> map;
    public static void main(String[] args) {
        System.out.println(rob(new int[] {1, 2, 3, 1}));
    }

    public static int rob(int[] nums) {
        map = new HashMap<>();
        return dfs(nums, 0);
    }

    public static int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (map.containsKey(i))
            return map.get(i);
        int res = Math.max(nums[i] + dfs(nums, i+2), dfs(nums, i+1));
        map.put(i, res);
        return res;
    }
}
