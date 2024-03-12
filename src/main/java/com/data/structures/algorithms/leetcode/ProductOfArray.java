package com.data.structures.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArray {

    public static void printArray(int[] result) {
        for (int i: result) {
            System.out.println(i);
        }
        System.out.println();
    }

    public static int[] productExceptSelf(int[] nums) {

        int product = 1;
        boolean isZero = false;
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == 0) {
                isZero = true;
            } else {
                product *= nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (isZero) {
                nums[i] = nums[i] == 0 ? product : 0;
            } else {
                nums[i] = product / nums[i];
            }
        }
        printArray(nums);
        return nums;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
    }
}
