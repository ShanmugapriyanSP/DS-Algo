package com.data.structures.algorithms.leetcode.stacks;

public class MinimumInsertionsToBalance {

    public static void main(String[] args) {
        System.out.println(minInsertions("(((()(()((())))(((()())))()())))(((()(()()((()()))"));
    }

//    public static int minInsertions(String s) {
//        int close = 0;
//        int insert = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                if (close % 2 == 1) {
//                    insert++;
//                    close--;
//                }
//                close += 2;
//
//            } else {
//                if (close > 0) {
//                    close--;
//                } else {
//                    insert++;
//                    close = 1;
//                }
//            }
//        }
//        return insert + close;
//    }

    public static int minInsertions(String s) {
        int open = 0;
        int res = 0;
        boolean swap = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else {
                    if (i+1 < s.length() && s.charAt(i+1) == ')') {
                        res++;
                        i++;
                    } else {
                        res += 2;
                    }
                }
                swap = true;
            } else {
                if (swap) {
                    res += open;
                    open = 2;
                    swap = false;
                } else {
                    open += 2;
                }
            }
        }
        return res + open;
    }
}
