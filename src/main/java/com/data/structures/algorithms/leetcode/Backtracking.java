package com.data.structures.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Backtracking {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(result, board, 0, n);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            result.add(constructSolution(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(result, board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
            int diff = row - i;
            if (col - diff >= 0 && board[i][col - diff] == 'Q') return false;
            if (col + diff < n && board[i][col + diff] == 'Q') return false;
        }
        return true;
    }

    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    public void backtrack1(int[] candidates, int i, List<Integer> curr, int total, int target, List<List<Integer>> res) {
        System.out.println(curr);
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }
        curr.add(candidates[i]);
        backtrack1(candidates, i, curr, total + candidates[i], target, res);
        curr.remove(curr.get(curr.size()-1));
        backtrack1(candidates, i+1, curr, total, target, res);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack1(candidates, 0, new ArrayList<Integer>(), 0, target, res);
        return res;
    }

    public boolean isSafe(int i, int j, char[][] board) {
        return i < board.length && j < board[0].length;

    }

    public boolean existRecursive(char[][] board, int i, int j, int pos, ArrayList<int[]> set, String word) {
        if (pos >= word.length()) {
            return true;
        }

        if (set.contains(new int[]{i, j}) ||
                i < 0 || j < 0 ||
                i >= board.length || j >= board[0].length ||
                word.charAt(pos) != board[i][j]
        ) {
            return false;
        }
        set.add(new int[]{i, j});
        boolean res = existRecursive(board, i+1, j, pos+1, set, word) ||
                existRecursive(board, i, j+1, pos+1, set, word) ||
                existRecursive(board, i-1, j, pos+1, set, word) ||
                existRecursive(board, i, j-1, pos+1, set, word);
        set.remove(new int[]{i, j});
        return res;
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existRecursive(board, i, j, 0, new ArrayList<>(), word)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        List<List<String>> solutions = new Backtracking().solveNQueens(4);
//        for (List<String> solution : solutions) {
//            for (String row : solution) {
//                System.out.println(row);
//            }
//            System.out.println();
//        }
//        System.out.println(new Backtracking().combinationSum(new int[] {2,3,6,7}, 7));
        System.out.println(new Backtracking().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }

}
