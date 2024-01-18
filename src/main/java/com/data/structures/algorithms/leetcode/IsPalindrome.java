package com.data.structures.algorithms.leetcode;

public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        if (s.trim().length() == 0) {
            return true;
        }
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int size = s.length();
        String firstHalf = s.substring(0, ((size/2)));
        String secondHalf = size % 2 == 0 ? s.substring(size/2, size-1) : s.substring((size/2)+1, size-1);
        String secondReversed = "";
        for (int i = secondHalf.length() - 1; i >= 0; i--) {
            secondReversed = secondReversed + String.valueOf(secondHalf.charAt(i));
        }
        return firstHalf.equals(secondReversed);
    }

    public static void main(String[] args) {

        System.out.println(IsPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}