package com.data.structures.algorithms.java.sorting;

import com.data.structures.algorithms.utils.Utils;

public class InsertionSort {

    public static void main(String[] args) {
        Integer[] arr = {5, 1, 9, 6, 7, 9};

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        Utils.printArray(arr);

    }
}
