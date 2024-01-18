package com.data.structures.algorithms.geek.recursion;

public class GenerateSubsets {

    public static void subsets(String s, String curr, int i) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }
        subsets(s, curr, i + 1);
//        System.out.println("curr: " + curr + " + s.charAt(i): " + s.charAt(i));
        subsets(s, curr + s.charAt(i), i + 1);
//        System.out.println("curr: " + curr + " + s.charAt(i): " + s.charAt(i));
    }
    public static void main(String[] args) {
        subsets("ABC", "", 0);
    }
}