package com.data.structures.algorithms.leetcode.patterns;

public class Main {

    public static void main(String[] args) {
        pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);
        System.out.println();
        pattern5(5);
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

    private static void pattern5(int n) {
        int total = 2 * n - 1;
        for (int i = 1; i <= n; i++) {
            int numOfChars = 2 * i - 1;
            int numOfSpaces = (total - numOfChars) / 2;
            for (int k = 1; k <= numOfSpaces; k++) {
                System.out.print(" ");
            }
            int pivot = 0;
            for (int j = 0; j < numOfChars; j++) {
                if (j < numOfChars / 2 + 1) {
                    System.out.print((char) ('A' + j));
                    pivot = j;
                } else {
                    System.out.print((char) ('A' + pivot - 1));
                    pivot--;
                }

            }

            for (int z = 1; z <= numOfSpaces; z++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int s = 1; s <= n - i; s++) {
                System.out.print(" ");
            }

            // Print increasing letters: A to current row letter
            for (char ch = 'A'; ch < 'A' + i; ch++) {
                System.out.print(ch);
            }

            // Print decreasing letters: current row letter - 1 back to A
            for (char ch = (char) ('A' + i - 2); ch >= 'A'; ch--) {
                System.out.print(ch);
            }

            // Move to next line
            System.out.println();
        }
    }
}
