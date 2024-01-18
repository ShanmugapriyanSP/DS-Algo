package com.data.structures.algorithms.leetcode;

public class SwapOddEven {

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }
    public static void printArr(int[] arr) {
        for (int num: arr)
            System.out.print(num + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 6, 11, 23, 76, 89, 88, 101, 102}; // {1, 4, 3, 6, 5, 8, 7, 10, 9, 12}
        int even = 1;
        int odd = 0;

        while (true) {
            System.out.println("EVEN - " + even + ", ODD - " + odd);
            printArr(arr);
            if (arr[even] % 2 != 0) {
                swap(arr, even, odd);
            } else {
                even += 2;
            }

            if (arr[odd] % 2 == 0) {
                swap(arr, odd, even);
            } else {
                odd += 2;
            }

            if (even >= arr.length || odd >= arr.length)
                break;
        }
    }
}
