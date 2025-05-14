package com.data.structures.algorithms.leetcode.maths;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        List<Integer> list = spiralOrder(matrix);
        list.forEach(e -> System.out.print(e + " "));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int l = 0, r = matrix[0].length;
        int top = 0, bottom = matrix.length;
        while (l < r && top < bottom) {
            for (int i = l; i < r; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i < bottom; i++) {
                list.add(matrix[i][r-1]);
            }
            r--;

            if (top == bottom || r == l) {
                break;
            }

            for (int i = r; i >= l; i--) {
                list.add(matrix[bottom-1][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][l]);
            }
            l++;
        }
        return list;

    }
}
