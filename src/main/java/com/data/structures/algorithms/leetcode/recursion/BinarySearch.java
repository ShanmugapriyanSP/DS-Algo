package com.data.structures.algorithms.leetcode.recursion;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {1,2,3,4,5}, 4, 0, 4));
    }


    private static int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r)
            return -1;

        int mid = l + (r - l) / 2;
        if (nums[mid] == target)
            return mid;

        if (nums[mid] > target)
            return binarySearch(nums, target, l, mid-1);
        else
            return binarySearch(nums, target, mid+1, r);

    }
}
