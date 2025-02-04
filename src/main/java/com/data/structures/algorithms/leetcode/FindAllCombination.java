package com.data.structures.algorithms.leetcode;

import java.util.stream.IntStream;

public class FindAllCombination {
    private static int result = 0;

    public static void recursiveAdd(int[] arr, int currentSum, int idx, int target) {
        if (idx >= arr.length || currentSum > target) return;

        if (currentSum == target) {
            result++;
//            System.out.println("CurrentSum: " + currentSum + ", Idx: " + idx + ", Result: " + result);
            return;
        }

        recursiveAdd(arr, currentSum+arr[idx], idx, target);
        recursiveAdd(arr, currentSum, idx+1, target);
    }

    public static void main(String[] args) {

        for(int i = 1; i <= 10; i++) {
            int[] arr = IntStream.rangeClosed(1, i).toArray();
            result = 0;
            recursiveAdd(arr, 0, 0, i);
            System.out.println("Number of combinations for " + i + " is " + result);
        }
    }
}
