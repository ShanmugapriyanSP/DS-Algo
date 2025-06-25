package com.data.structures.algorithms.leetcode.stacks;

public class MinimumInsertionsToBalance {

    public static void main(String[] args) {
        System.out.println(minInsertions("(((()(()((())))(((()())))()())))(((()(()()((()()))"));
    }

    public static int minInsertions(String s) {
        int close = 0;
        int insert = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (close % 2 == 1) {
                    insert++;
                    close--;
                }
                close += 2;

            } else {
                if (close > 0) {
                    close--;
                } else {
                    insert++;
                    close = 1;
                }
            }
        }
        return insert + close;
    }
}
