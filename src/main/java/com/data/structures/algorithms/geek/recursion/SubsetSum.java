package com.data.structures.algorithms.geek.recursion;

public class SubsetSum {

    public static int subsetSum(int[] arr, int sum, int n) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        return subsetSum(arr, sum, n-1) + subsetSum(arr, sum - arr[n-1], n-1);
    }
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{10, 20, 15}, 25, 3));
    }
}
