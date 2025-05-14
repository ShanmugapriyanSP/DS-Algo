package com.data.structures.algorithms.leetcode.maths;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void setZeroes(int[][] matrix) {
        boolean[] rowsZero = new boolean[matrix.length];
        boolean[] colsZero = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsZero[i] = true;
                    colsZero[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowsZero[i] || colsZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
