package com.data.structures.algorithms.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int counter = 0;
        int l = 0, r = 1;
        set.add(s.charAt(l));
        while (r < s.length()) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            counter = Math.max(counter, r - l + 1);
            r++;
        }
        return counter;
    }
}
