package com.data.structures.algorithms.java.sorting;

import com.data.structures.algorithms.utils.Utils;

public class SelectionSort {

    public static void main(String[] args) {
        Integer[] arr = {5, 1, 9, 6, 7, 9};

        for (int i = 0; i < arr.length; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
        Utils.printArray(arr);
    }
}
