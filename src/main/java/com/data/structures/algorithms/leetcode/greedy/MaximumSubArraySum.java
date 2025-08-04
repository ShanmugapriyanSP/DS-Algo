package com.data.structures.algorithms.leetcode.greedy;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[] {1, 2, 3, 4, 5}));
    }

    public static int maxSubArraySum(int[] nums) {
        int res = nums[0];
        int maxEnd = nums[0];
        for (int i = 0; i < nums.length; i++) {
            maxEnd = Math.max(maxEnd + nums[i], maxEnd);
            res = Math.max(res, maxEnd);
        }
        return res;
    }
}
