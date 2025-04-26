package com.data.structures.algorithms.leetcode.dp;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babaddtattarrattatddetartrateedredividerb";
        String[][] dp = new String[s.length()][s.length()];
        System.out.println(dfs(s, 0, 0, dp));
        String maxResult = "";
        for (String[] row : dp) {
            for (String value : row) {
                if (value == null) continue;
                maxResult = value.length() > maxResult.length() ? value : maxResult;
            }
        }
        System.out.println(maxResult);
    }

    private static String dfs(String s, int i, int j, String[][] dp) {
        if (i >= s.length() || j >= s.length()) return "";
        if (dp[i][j] != null) return dp[i][j];
        if (isPalindrome(s.substring(i, j+1))) {
            dp[i][j] = s.substring(i, j+1);
        }
        dfs(s, i, j+1, dp);
        dfs(s, i+1, j+1, dp);
        return dp[i][j];
    }

    private static boolean isPalindrome(String s) {
        if(s.length() == 1) return true;
        if (s.isEmpty()) return false;
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
