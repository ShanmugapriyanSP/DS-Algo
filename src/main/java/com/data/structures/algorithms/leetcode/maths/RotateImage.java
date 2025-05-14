package com.data.structures.algorithms.leetcode.maths;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        rotate(matrix);
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int l = 0, r = matrix[0].length-1;

        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int top = l, bottom = r;

                int temp1 = matrix[top+i][r];
                matrix[top+i][r] = matrix[top][l+i];

                int temp2 = matrix[bottom][r-i];
                matrix[bottom][r-i] = temp1;

                int temp3 = matrix[bottom-i][l];
                matrix[bottom-i][l] = temp2;

                matrix[top][l+i] = temp3;

            }
            l++;
            r--;
        }
    }
}
