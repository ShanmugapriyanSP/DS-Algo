package com.data.structures.algorithms.scripts;

import com.data.structures.algorithms.java.sorting.GenericSort;

import java.util.Scanner;

public class Sorting {


    private static Integer[] getIntegerInputs() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number Of Elements: ");
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a value: ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    private static String[] getStringInputs() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number Of Elements: ");
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a value: ");
            arr[i] = scanner.next();
        }
        return arr;
    }

    public static void main(String[] args) {
        GenericSort sort = new GenericSort();

        Integer[] arrInteger = getIntegerInputs();
        sort.insertionSort(arrInteger);
        sort.print(arrInteger);

        System.out.println("\n");

        String[] arrString = getStringInputs();
        sort.insertionSort(arrString);
        sort.print(arrString);
    }
}
