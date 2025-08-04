package com.data.structures.algorithms.leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        System.out.println(exist(board, "ABCB"));
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = backtrack(board, word, 0, i, j, new HashSet<>());
                if (result) return result;
            }
        }
        return false;
    }

    public static boolean backtrack(char[][] board, String word, int index, int i , int j, Set<String> set) {

        if (index == word.length())
            return true;

        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || set.contains(i + "," + j)) {
            return false;
        }

        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        set.add(i + "," + j);

        boolean result = backtrack(board, word, index+1, i+1, j, set) ||
                backtrack(board, word, index+1, i, j+1, set) ||
                backtrack(board, word, index+1, i-1, j, set) ||
                backtrack(board, word, index+1, i, j-1, set);

        set.remove(i + "," + j);

        return result;
    }
}
