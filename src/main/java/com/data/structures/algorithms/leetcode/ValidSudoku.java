package com.data.structures.algorithms.leetcode;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };
        System.out.print(validSudoku.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0 || board[0].length != board.length)
            return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                boolean horizontalCheck = isValid(c, board[i], j);
                boolean verticalCheck = isValid(c, board, j, i);
                boolean boxCheck = boxCheck(c, board, i , j);
                if (!horizontalCheck || !verticalCheck || !boxCheck)
                    return false;

            }
        }
        return true;
    }

    private boolean isValid(char c, char[] board, int skipCheck) {
        for (int i = 0; i < board.length; i++) {
            if (i == skipCheck)
                continue;
            if (board[i] == c)
                return false;
        }
        return true;
    }

    private boolean isValid(char c, char[][] board, int columnNumber, int skipCheck) {
        for (int i = 0; i < board.length; i++) {
            if (i == skipCheck)
                continue;
            if (board[i][columnNumber] == c)
                return false;
        }
        return true;
    }

    private boolean boxCheck(char c, char[][] board, int row, int column) {
        int start = getBoxIndex(row);
        int end = getBoxIndex(column);
        for (int i = start; i + start < 3; i++) {
            for (int j = end; j + end < 3; j++) {
                if (i == row && j == column)
                    continue;
                if (board[i][j] == c)
                    return false;
            }
        }
        return true;
    }

    private int getBoxIndex(int index) {
        if (index >= 0 && index <= 2) {
            return 0;
        } else if (index >= 3 && index <= 5) {
            return 3;
        } else {
            return 6;
        }
    }
}
