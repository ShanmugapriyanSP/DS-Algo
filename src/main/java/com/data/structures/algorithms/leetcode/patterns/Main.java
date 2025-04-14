package com.data.structures.algorithms.leetcode.patterns;

public class Main {

    public static void main(String[] args) {
        pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);
    }

    private static void pattern1(int n) {
        for (int i = 0; i < 2*n; i++) {
            int limit = i <= n ? i: (2*n) - i;
            for(int j = 0; j < limit; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            int numOfSpaces = (n - i);
            for (int k = 0; k < numOfSpaces; k++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= n - numOfSpaces ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            int numOfSpaces = (n - i) * 2;
            for (int k = 0; k < numOfSpaces; k++) {
                System.out.print(" ");
            }
            for(int j = n - i + 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern4(int n) {
        for (int i = 1; i <= 2 * n; i++) {
            int numOfSpaces = i < n ? (n - i) * 2: (i - n) * 2;
            for (int k = 0; k < numOfSpaces; k++) {
                System.out.print(" ");
            }
            for(int j = n - i + 1; j <= 2 * n ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
