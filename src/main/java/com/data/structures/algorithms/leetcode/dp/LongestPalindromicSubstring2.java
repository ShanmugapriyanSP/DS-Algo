package com.data.structures.algorithms.leetcode.dp;

public class LongestPalindromicSubstring2 {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }

    public static String longestPalindrome(String s) {
        String res = "";
        int maxLen = res.length();
        for (int i = 0; i < s.length(); i++) {
            String odd = dfs(s, i-1, i+1, 0, 0);
            String even = dfs(s, i, i+1, 0, 0);
            int len = Math.max(odd.length(), even.length());
            if (maxLen < len) {
                maxLen = len;
                res = odd.length() > even.length() ? odd : even;
            }
        }
        return res;
    }

    private static String dfs(String s, int left, int right, int res, int resLen) {

        if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
            System.out.println(s.substring(res, res+resLen));
            return s.substring(res, res+resLen);
        }

        res = left;
        resLen = right - left + 1;
        return dfs(s, left-1, right+1, res, resLen);
    }
}
