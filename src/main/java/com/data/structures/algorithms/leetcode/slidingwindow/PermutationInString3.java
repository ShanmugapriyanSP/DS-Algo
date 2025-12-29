package com.data.structures.algorithms.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString3 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaoooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();
        for (char c: s1.toCharArray()){
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        while (r < s2.length()) {
            s2Count.put(s2.charAt(r), s2Count.getOrDefault(s2.charAt(r), 0) + 1);
            if((r-l+1) > s1.length()) {
                s2Count.put(s2.charAt(l), s2Count.get(s2.charAt(l)) - 1);
                l++;
            }
            if ((r-l+1) == s1.length()) {
                boolean matched = true;
                for (Map.Entry<Character, Integer> entry: s1Count.entrySet()) {
                    if (!s2Count.containsKey(entry.getKey()) || !s2Count.get(entry.getKey()).equals(entry.getValue())) {
                        matched = false;
                        break;
                    }
                }
                if (matched)
                    return true;
            }
            r++;
        }
        return false;

    }
}
