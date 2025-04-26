package com.data.structures.algorithms.leetcode.dp;

public class HouseRobbersII {

    public static void main(String[] args) {
        int[] nums = {1};
        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length-1) {
                arr1[i] = nums[i];
            }
            if (i != 0) {
                arr2[i-1] = nums[i];
            }
        }
        System.out.print(Math.max(robHouse(arr1, 0, new Integer[arr1.length]), robHouse(arr2, 0, new Integer[arr2.length])));
    }

    private static int robHouse(int[] nums, int i, Integer[] dp) {
        if (i >= nums.length) return 0;
        if (dp[i] != null) return dp[i];
        dp[i] = Math.max(nums[i] + robHouse(nums, i + 2, dp), robHouse(nums, i + 1, dp));
        return dp[i];
    }
}
