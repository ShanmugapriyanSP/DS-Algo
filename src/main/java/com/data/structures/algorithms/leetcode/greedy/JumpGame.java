package com.data.structures.algorithms.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[] {1,0,8,0}));
    }

    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(nums, 0, memo);
    }

    public boolean dfs(int[] nums, int i, Map<Integer, Boolean> memo) {
        if (i == nums.length-1) {
            return true;
        }
        if (memo.containsKey(i))
            return memo.get(i);

        int end = i + nums[i];
        for (int j = i+1; j <= end; j++) {
            boolean res = dfs(nums, j, memo);
            if (res) {
                memo.put(j, true);
                return true;
            }
        }
        memo.put(i, false);
        return memo.get(i);
    }
}
