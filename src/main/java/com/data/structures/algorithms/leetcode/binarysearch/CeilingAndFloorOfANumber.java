package com.data.structures.algorithms.leetcode.binarysearch;

public class CeilingAndFloorOfANumber {

    public static int findCeiling(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = end - (end-start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static int findFloor(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = end - (end-start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3 ,5, 9, 14, 16, 18};
        int target = 15;
        System.out.println(findCeiling(arr, target));
        System.out.println(findFloor(arr, target));
    }
}
