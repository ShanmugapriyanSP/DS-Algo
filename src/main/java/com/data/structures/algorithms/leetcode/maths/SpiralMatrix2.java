package com.data.structures.algorithms.leetcode.maths;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

//        int[][] matrix = {
//                {1,2},
//                {3,4}
//        };
        List<Integer> list = spiralOrder(matrix);
        list.forEach(e -> System.out.print(e + " "));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        List<Integer> res = new ArrayList<>();
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
        }
        return res;
    }
}
