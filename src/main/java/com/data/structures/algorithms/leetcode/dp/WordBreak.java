package com.data.structures.algorithms.leetcode.dp;

import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen");
        Boolean[] dp = new Boolean[s.length()+1];
        System.out.print(dfs(s, wordDict, 0, dp));
    }

    private static boolean dfs(String s, List<String> wordDict, int i, Boolean[] dp) {

        if (i >= s.length())
            return true;

        if (dp[i] != null) {
            return dp[i];
        }
        for (String str: wordDict) {
            if (i + str.length() <= s.length() && s.substring(i, i+str.length()).equals(str)) {
                if (dfs(s, wordDict, i+str.length(), dp)) {
                    dp[i] = true;
                    return true;
                }

            }
        }
        dp[i] = false;
        return false;
    }
}
