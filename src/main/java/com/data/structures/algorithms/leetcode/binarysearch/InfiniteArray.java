package com.data.structures.algorithms.leetcode.binarysearch;

public class InfiniteArray {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 6, 7, 9, 11, 18, 25, 34, 60, 99};
        int target = 9 ;
        int l = 0, r = 1;
        int result = -1;

        while (l <= r) {
            if (arr[r] < target) {
                int temp = r + 1;
                r = r + (r - l + 1) * 2;
                l = temp;
            } else {
                result = binarySearch(arr, l, r, target);
                break;
            }
        }
        System.out.println("Position of " + target + " in the array is " + result);
    }

    private static int binarySearch(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < target) {
                l = mid + 1;
            } else if (arr[mid] > target){
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
