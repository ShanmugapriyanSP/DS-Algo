package com.data.structures.algorithms.java.sorting;

public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 6, 7, 9};

        sort(arr, 0, arr.length-1);

    }

    public static void sort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(nums, l, m);
            sort(nums, m+1, r);
            merge(nums, l, m, r);
        }
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] a1 = new int[n1];
        int[] a2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            a1[i] = nums[l+i];
        }
        for (int j = 0; j < n2; j++) {
            a2[j] = nums[m+1+j];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                nums[k++] = a1[i++];
            } else {
                nums[k++] = a2[j++];
            }
        }

        while (i < n1) {
            nums[k++] = a1[i++];
        }

        while (j < n2) {
            nums[k++] = a2[j++];
        }
    }
}
