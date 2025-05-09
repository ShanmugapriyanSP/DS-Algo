package com.data.structures.algorithms.leetcode.slidingwindow;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] charCount = getCharCount(s1);
        int r = 0;
        while(r < s2.length()) {
            int counter = 0;
            while(r < s2.length() && charCount[s2.charAt(r) - 'a'] != 0) {
                charCount[s2.charAt(r) - 'a']--;
                r++;
                counter++;
            }

            if (counter == s1.length()) {
                return true;
            } else {
                charCount = getCharCount(s1);
            }
            r++;
        }
        return false;
    }

    private static int[] getCharCount(String s1) {
        int[] charCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
        }
        return charCount;
    }
}
