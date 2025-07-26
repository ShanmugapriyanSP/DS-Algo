package com.data.structures.algorithms.leetcode.stacks;

import javax.sound.midi.Soundbank;

public class MinimumInsertionsToBalance {

    public static void main(String[] args) {
        System.out.println(minInsertions("(()))(()))()())))"));   // 4
        System.out.println(minInsertions("(((()(()((())))(((()())))()())))(((()(()()((()()))"));  // 31
        System.out.println(minInsertions("))(()()))()))))))()())()(())()))))()())(()())))()("));  // 16
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
        int close = 0;
        int leftOver = 0;
        boolean swap = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (close > 0) {
                    close--;
                } else {
                    if (i+1 < s.length() && s.charAt(i+1) == ')') {
                        leftOver++;
                        i++;
                    } else {
                        leftOver += 2;
                    }
                }
                swap = true;
            } else {
                if (swap) {
                    if (close % 2 != 0) {
                        leftOver++;
                        close--;
                        swap = false;
                    }
                }
                close += 2;
            }
        }
        return leftOver + close;
    }
}
