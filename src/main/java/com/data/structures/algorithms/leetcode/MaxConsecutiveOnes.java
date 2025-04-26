package com.data.structures.algorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int left = 0, right = 0;
        int maxCount = 0;
        int flipCount = 0;
        while(left < right) {
            if (nums[right] == 0) {
                flipCount++;
            }

            while (flipCount > k) {
                if (nums[left] == 0) {
                    flipCount--;
                }
                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }

        System.out.println(maxCount);
    }
}
