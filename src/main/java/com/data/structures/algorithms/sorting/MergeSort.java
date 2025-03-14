package com.data.structures.algorithms.sorting;

import com.data.structures.algorithms.utils.Utils;

public class MergeSort {

    public static void merge(Integer[] arr, int l, int m, int r) {
        int n1 = (m - l) + 1;
        int n2 = r - m;

        Integer L[] = new Integer[n1];
        Integer R[] = new Integer[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l+i];
        }

        for (int i = 0; i < n2; ++i) {
            R[i] = arr[m+1+i];
        }

        int k = l, i = 0, j = 0;

        while(i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }


    }

    public static void sort(Integer[] arr, int l , int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 1, 9, 6, 7, 9};

        sort(arr, 0, arr.length-1);

        Utils.printArray(arr);
    }
}
