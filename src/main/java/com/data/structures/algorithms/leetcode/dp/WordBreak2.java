package com.data.structures.algorithms.leetcode.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaa", List.of("aaa", "aaaa")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(s, 0, wordDict, memo);
    }

    public static boolean dfs(String s, int i, List<String> wordDict, Map<Integer, Boolean> memo) {
        if (i >= s.length()) {
            return true;
        }

        if (memo.containsKey(i))
            return memo.get(i);

        for (String word: wordDict) {
            if (i + word.length() <= s.length()) {
                if (s.substring(i, word.length()).equals(word)) {
                    if (dfs(s, i+1, wordDict, memo)) {
                        memo.put(i, true);
                        return true;
                    }

                }
            }
        }

        memo.put(i, false);
        return false;
    }
}
