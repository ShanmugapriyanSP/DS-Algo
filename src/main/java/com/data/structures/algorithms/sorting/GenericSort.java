package com.data.structures.algorithms.sorting;

public class GenericSort {

    public <T extends Comparable<T>> void insertionSort(T[] arr) {

        for (int i = 1; i < arr.length; i++) {
           int counter = i;
           while (counter != 0) {
               if (arr[counter].compareTo(arr[counter - 1]) < 0) {
                   swap(arr, counter, counter-1);
               }
               counter--;
           }
        }
    }

    private <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public <T> void print(T[] arr) {
        for (T i: arr) {
            System.out.print(i + " ");
        }
    }
}
