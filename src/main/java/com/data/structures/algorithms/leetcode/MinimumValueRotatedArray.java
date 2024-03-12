package com.data.structures.algorithms.leetcode;

public class MinimumValueRotatedArray {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        int res = nums[0];

        while (left < right) {

            res = Math.min(res, Math.min(nums[left], nums[right]));

            int mid = (right - left + 1) / 2;
            if (nums[mid] > nums[left]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3, 4 ,5, 1, 2}));
    }
}
