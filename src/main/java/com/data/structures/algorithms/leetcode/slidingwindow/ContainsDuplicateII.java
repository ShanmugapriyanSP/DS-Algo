package com.data.structures.algorithms.leetcode.slidingwindow;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[] {0,1,2,3,2,5}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2)
            return false;
        int l = 0, r = 1;
        while (l < r) {

            if (nums[l] == nums[r] && (r - l) <= k)
                return true;

            if ((r - l) > k) {
                l++;
                continue;
            }

            if (r+1 < nums.length)
                r++;
            else
                l++;
        }
        return false;
    }
}
