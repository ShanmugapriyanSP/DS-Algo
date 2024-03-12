package com.data.structures.algorithms.leetcode;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int res = -1;
        int left = 0, right = nums.length-1;
        while (left < right) {
            res = nums[left] == target ? left : (nums[right] == target ? right : -1);
            if (res != -1) break;

            int mid = (right - left + 1) / 2;
            if (nums[mid] > target) {
                if (nums[left] > target) {
                    left = mid;
//                    right--;
                } else {
                    right = mid;
//                    left++;
                }
            } else {
                if (nums[right] < target) {
                    left = mid;
//                    right--;
                } else {
                    right = mid;
//                    left++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {1,3,5}, 3));
    }
}
