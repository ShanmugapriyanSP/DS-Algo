package com.data.structures.algorithms.leetcode;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.print(validSudoku.isValidSudoku(board));
    }

//    public boolean isValidSudoku(char[][] board) {
//        if (board.length == 0 || board[0].length != board.length)
//            return false;
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                char c = board[i][j];
//                if (c == '.')
//                    continue;
//                boolean horizontalCheck = isValid(c, board[i], j);
//                boolean verticalCheck = isValid(c, board, j, i);
//                boolean boxCheck = boxCheck(c, board, i , j);
//                if (!horizontalCheck || !verticalCheck || !boxCheck)
//                    return false;
//
//            }
//        }
//        return true;
//    }

//    private boolean isValid(char c, char[] board, int skipCheck) {
//        for (int i = 0; i < board.length; i++) {
//            if (i == skipCheck)
//                continue;
//            if (board[i] == c)
//                return false;
//        }
//        return true;
//    }
//
//    private boolean isValid(char c, char[][] board, int columnNumber, int skipCheck) {
//        for (int i = 0; i < board.length; i++) {
//            if (i == skipCheck)
//                continue;
//            if (board[i][columnNumber] == c)
//                return false;
//        }
//        return true;
//    }
//
//    private boolean boxCheck(char c, char[][] board, int row, int column) {
//        int start = getBoxIndex(row);
//        int end = getBoxIndex(column);
//        for (int i = start; i + start < 3; i++) {
//            for (int j = end; j + end < 3; j++) {
//                if (i == row && j == column)
//                    continue;
//                if (board[i][j] == c)
//                    return false;
//            }
//        }
//        return true;
//    }
//
//    private int getBoxIndex(int index) {
//        if (index >= 0 && index <= 2) {
//            return 0;
//        } else if (index >= 3 && index <= 5) {
//            return 3;
//        } else {
//            return 6;
//        }
//    }

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.')
                    continue;

                if (!checkSquare(board, board[i][j], i, j))
                    return false;

                for (int x = 0; x < rows; x++) {
                    if ((j != x && board[i][j] == board[i][x]) || (x != i && board[i][j] == board[x][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkSquare(char[][] board, char target, int i, int j) {
        int row = getIndex(i);
        int col = getIndex(j);
        for (int x = row; x < row+3; x++) {
            for (int y = col; y < col+3; y++) {
                if (i == x && j == y)
                    continue;
                if (board[x][y] == target)
                    return false;
            }
        }
        return true;
    }

    private int getIndex(int i) {
        if (i < 3) {
            return 0;
        } else if (i < 6) {
            return 3;
        } else {
            return 6;
        }
    }
}
