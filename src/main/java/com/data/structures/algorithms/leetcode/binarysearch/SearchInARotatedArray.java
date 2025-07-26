package com.data.structures.algorithms.leetcode.binarysearch;

public class SearchInARotatedArray {

    public static void main(String[] args) {
        int[] nums = {1, 3};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        int pivot = findMin(nums);
        if (target == nums[pivot]) {
            return pivot;
        }
        int l = 0, r = nums.length-1;
        if (target > nums[pivot] && target <= nums[nums.length-1]) {
            l = pivot;
        } else {
            r = pivot;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] < nums[r]) {
                return l;
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid+1;
            } else
                r = mid;
        }
        return l;
    }
}
