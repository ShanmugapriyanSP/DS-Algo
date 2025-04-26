package com.data.structures.algorithms.leetcode.binarysearch;

import java.util.Arrays;

public class MinAndMax {

    public static void main(String[] args) {
        int[][] testCases = {
                {4, 5, 6, 1, 2, 3},
                {30, 40, 50, 10, 20},
                {6, 7, 8, 1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {10, 20, 30, 40, 50},
                {7, 7, 7, 7, 7},
                {3, 4, 5, 1, 1, 2, 3},
                {2, 2, 2, 3, 1, 2},
                {10, 10, 1, 10, 10},
                {5, 4, 3, 2, 1},
                {99},
                {1, 2},
                {2, 1},
                {2, 2}
        };

        for (int[] testCase : testCases) {
            System.out.println("Min in " + Arrays.toString(testCase) + " = " + findMin(testCase));
            System.out.println("Max in " + Arrays.toString(testCase) + " = " + findMax(testCase));
        }
    }

    private static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {

            if (nums[l] < nums[r]) {
                return nums[l];
            }

            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    private static int findMax(int[] nums) {

        int l = 0, r = nums.length - 1;

        while (l < r) {

            if (nums[l] < nums[r]) {
                return nums[r];
            }

            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[l]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }


}
