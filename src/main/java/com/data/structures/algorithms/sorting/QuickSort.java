package com.data.structures.algorithms.sorting;

import com.data.structures.algorithms.utils.Utils;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] arr = {5, 1, 9, 6, 7, 9};
        sort(arr, 0, arr.length-1);
        Utils.printArray(arr);
    }

    public static void sort(Integer[] nums, int l, int r) {
        if (l < r) {
            int partition = partition(nums, l, r);

            sort(nums, l, partition-1);
            sort(nums, partition+1, r);
        }
    }

    public static int partition(Integer[] nums, int l , int r) {
        int pivot = nums[r];
        int insertionPoint = l;
        for (int i = l; i <= r-1; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, insertionPoint);
                insertionPoint++;
            }
        }
        swap(nums, insertionPoint, r);
        return insertionPoint;
    }

    public static void swap(Integer[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
