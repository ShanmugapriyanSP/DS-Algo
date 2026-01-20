package com.data.structures.algorithms.leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("226"));
    }

    public int numDecodings(String s) {
        return dfs(s, 0, new HashMap<>());
    }

    private int dfs(String s, int i, Map<Integer, Integer> cache) {
        if (i >= s.length())
            return 1;
        if (s.charAt(i) == '0')
            return 0;

        if (cache.containsKey(i))
            return cache.get(i);

        int res = dfs(s, i+1, cache);
        if (i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i) < '7'))) {
            res += dfs(s, i + 2, cache);
        }

        cache.put(i, res);
        return res;
    }

}
