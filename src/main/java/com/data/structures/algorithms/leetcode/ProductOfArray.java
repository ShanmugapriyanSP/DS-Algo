package com.data.structures.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArray {

    public static int recursiveMultiply(int[] nums, int index) {
        if (index == 0) {
            return nums[index];
        }
        return nums[index] * recursiveMultiply(nums, --index);

    }
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i=0; i < nums.length; i++) {
            int[] temp = nums;
            temp[i] = 1;
            result[i] = recursiveMultiply(temp, nums.length-1);
        }
        for (int i: result) {
            System.out.println(i);
        }
        return result;
    }
    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
    }
}
